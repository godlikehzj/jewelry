package com.jewelry.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jewelry.bean.entity.PositionType;
import com.jewelry.bean.entity.Sortype;
import com.jewelry.bean.jpa.CPicture;
import com.jewelry.bean.jpa.Commodity;
import com.jewelry.bean.jpa.JewelryType;
import com.jewelry.dao.*;
import com.jewelry.utils.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommodityService {
    @Autowired
    private CommodityRepository commodityRepository;

    @Autowired
    private JewelryTypeRepository jewelryTypeRepository;

    @Autowired
    private BodyPartRepository bodyPartRepository;

    @Autowired
    private CPictureRespository cPictureRespository;

    @Autowired
    private JewelryMeterialRepository jewelryMeterialRepository;

    public Object getCommodityList(Long list_id, List<Long> meterial_ids, Integer sort){
        Sort sorter = null;
        if (sort != null){
            if (sort == Sortype.createTime.getIndex())
                sorter = new Sort(Sort.Direction.DESC, "createTime");
            else if (sort == Sortype.price_high.getIndex())
                sorter = new Sort(Sort.Direction.DESC, "price");
            else if (sort == Sortype.price_low.getIndex())
                sorter = new Sort(Sort.Direction.ASC, "price");
            else if (sort == Sortype.hot.getIndex())
                sorter = new Sort(Sort.Direction.ASC, "clicks");
        }
        Long type_id;
        Long part_id;
        List<Commodity> commodities;

        JewelryType jewelryType = jewelryTypeRepository.getById(list_id);
        if (jewelryType == null){
            part_id = list_id;
            if (meterial_ids == null)
                commodities = commodityRepository.findAllByPartId(part_id, sorter);
            else
                commodities = commodityRepository.findAllByPartIdAndMeterialIdIn(part_id, meterial_ids, sorter);
        }else{
            type_id = list_id;
            if (meterial_ids == null)
                commodities = commodityRepository.findAllByTypeId(type_id, sorter);
            else
                commodities = commodityRepository.findAllByTypeIdAndMeterialIdIn(type_id, meterial_ids, sorter);
        }

        Double transfor =  Commons.getUSD();
        List<Object> result = new ArrayList<Object>();
        for(Commodity commodity : commodities){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("commodityId", commodity.getId());
            jsonObject.put("title", commodity.getListTitle());
            jsonObject.put("enTitle", commodity.getEnListTitle());
            jsonObject.put("price", commodity.getPrice());
            jsonObject.put("usPrice", new Double(commodity.getPrice() * transfor).intValue());
            List<CPicture> cpictures = cPictureRespository.findAllByCommodityIdAndPositionType(commodity.getId(), PositionType.List.ordinal());
            List<String> imgs = new ArrayList<String>();
            for(CPicture cpicture:cpictures){
                imgs.add(Commons.domain + cpicture.getPicName());
            }
            jsonObject.put("meterial", jewelryMeterialRepository.getOne(commodity.getMeterialId()).getName());
            jsonObject.put("enMeterial", jewelryMeterialRepository.getOne(commodity.getMeterialId()).getEnName());


            jsonObject.put("img", imgs);
            result.add(jsonObject);
        }

        return result;
    }

    public Object getCommodity(Long commodity_id){
        Commodity commodity = commodityRepository.getCommodityById(commodity_id);
        if (commodity == null) return null;

        Double transfor =  Commons.getUSD();
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(commodity));
        jsonObject.put("usPrice",  new Double(commodity.getPrice() * transfor).intValue());
        List<CPicture> cpictures = cPictureRespository.findAllByCommodityIdAndPositionType(commodity_id, PositionType.Detail.ordinal());
        List<String> imgs = new ArrayList<String>();
        for(CPicture cpicture:cpictures){
            imgs.add(Commons.domain + cpicture.getPicName());
        }
        jsonObject.put("img", imgs);
        return jsonObject;
    }

    public Object getMeterialList(Long type_id){
        return jewelryMeterialRepository.findAllByTypeId(type_id);
    }
}
