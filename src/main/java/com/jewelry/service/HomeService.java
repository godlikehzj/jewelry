package com.jewelry.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jewelry.bean.jpa.Banner;
import com.jewelry.bean.jpa.BodyPart;
import com.jewelry.bean.jpa.HomePage;
import com.jewelry.bean.jpa.JewelryType;
import com.jewelry.dao.BannerRepository;
import com.jewelry.dao.BodyPartRepository;
import com.jewelry.dao.HomePageRepository;
import com.jewelry.dao.JewelryTypeRepository;
import com.jewelry.utils.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {
    @Autowired
    private JewelryTypeRepository jewelryTypeRepository;

    @Autowired
    private BodyPartRepository bodyPartRepository;

    @Autowired
    private BannerRepository bannerRepository;

    @Autowired
    private HomePageRepository homePageRepository;

    public Object getHeadMenu(){
        List<JewelryType> jewelryTypes = jewelryTypeRepository.findAll();
        JSONArray result = new JSONArray();

        for(JewelryType jewelryType:jewelryTypes){
            List<BodyPart> bodyParts = bodyPartRepository.findByTypeIdEquals(jewelryType.getId());
            JSONObject type = (JSONObject) JSON.toJSON(jewelryType);
            JSONArray parts = new JSONArray();
            for(BodyPart bodyPart : bodyParts){
                JSONObject part = new JSONObject();
                part.put("id", bodyPart.getId());
                part.put("name", bodyPart.getName());
                parts.add(part);
            }
            type.put("parts", parts);
            result.add(type);
        }
        return result;
    }

    public Object getBannerList(){
        List<Banner> banners = bannerRepository.findAllByStatusIsNot(0);
        for (Banner banner:banners){
            banner.setImg_url(Commons.domain + "/banner/" + banner.getImg_url());
        }
        return banners;
    }

    public Object getHomePageContent(){
        Sort.Order lineOrder = new Sort.Order(Sort.Direction.ASC, "line_order");
        Sort.Order indexOrder = new Sort.Order(Sort.Direction.ASC, "index_order");
        List<Sort.Order> list = new ArrayList<Sort.Order>();
        list.add(lineOrder);
        list.add(indexOrder);
        Sort sort = new Sort(list);
        List<HomePage> homePages = homePageRepository.findByAndSort(0, sort);
        JSONArray lines = new JSONArray();
        for (HomePage homePage:homePages){
            JSONArray subline;
            if (homePage.getLine_order() > lines.size()){
                subline = new JSONArray();
            }else{
                subline = lines.getJSONArray(homePage.getLine_order() - 1);
            }
            JSONObject one_page = new JSONObject();
            one_page.put("c_type", homePage.getC_type());
            //不是文字设置访问url
            if (homePage.getC_type() != 1){
                one_page.put("content", Commons.domain + "/home_page/" + homePage.getContent());
                //图片需要设置跳转商品id
                if (homePage.getC_type() == 2)
                    one_page.put("commodity_id", homePage.getCommodity_id());
            }
            else
                one_page.put("content", homePage.getContent());

            subline.add(one_page);
            lines.set(homePage.getLine_order() - 1, subline);
        }
        return lines;
    }
}
