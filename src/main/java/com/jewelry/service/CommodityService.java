package com.jewelry.service;

import com.jewelry.bean.entity.Response;
import com.jewelry.bean.entity.Sortype;
import com.jewelry.bean.jpa.Commodity;
import com.jewelry.dao.CommodityRepository;
import com.jewelry.utils.ApiStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommodityService {
    @Autowired
    private CommodityRepository commodityRepository;
    public Object getCommodityList(Integer type_id, Integer part_id, Integer meterial_id, Integer sort){
        Sort sorter = null;
        if (sort != null){
            if (sort == Sortype.createTime.getIndex())
                sorter = new Sort(Sort.Direction.DESC, "create_time");
            else if (sort == Sortype.price_high.getIndex())
                sorter = new Sort(Sort.Direction.DESC, "price");
            else if (sort == Sortype.price_low.getIndex())
                sorter = new Sort(Sort.Direction.ASC, "price");
            else if (sort == Sortype.hot.getIndex())
                sorter = new Sort(Sort.Direction.ASC, "clicks");
        }

        List<Commodity> commodities = null;
        if (type_id != null && part_id == null && meterial_id == null){
            commodities = commodityRepository.findAllByType_id(type_id, sorter);
        }else if (type_id != null && part_id != null && meterial_id == null){
            commodities = commodityRepository.findAllByType_idAndPart_id(type_id, part_id, sorter);
        }else if (type_id != null && part_id != null && meterial_id != null){
            commodities = commodityRepository.findAllByType_idAndPart_idAndMeterial_id(type_id, part_id, meterial_id, sorter);
        }

        return commodities;
    }

    public Object getCommodity(Long commodity_id){
        return commodityRepository.getCommodityById(commodity_id);
    }
}
