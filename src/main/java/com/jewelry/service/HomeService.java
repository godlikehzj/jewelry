package com.jewelry.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jewelry.bean.entity.HomePageType;
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
                part.put("enName", bodyPart.getEnName());
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
            banner.setImgUrl(Commons.img_url + "/banner/" + banner.getImgUrl());
        }
        return banners;
    }

    private JSONObject getLine(HomePage homePage){
        JSONObject one_page = new JSONObject();
        one_page.put("cType", homePage.getcType());
        one_page.put("widthNum", homePage.getWidthNum());

        //不是文字设置访问url
        if (homePage.getcType() != 1){
            one_page.put("content", Commons.img_url + "/home_page/" + homePage.getContent());
            //图片需要设置跳转商品id
            if (homePage.getcType() == 2)
                one_page.put("goId", homePage.getGoId());
        }
        else{
            one_page.put("content", homePage.getContent());
            one_page.put("enContent", homePage.getEnContent());
        }

        return one_page;
    }

    public Object getHomePageContent(){
        JSONObject lines = new JSONObject();

        //获取banner信息
        List<Banner> banners = bannerRepository.findAllByStatusIsNot(0);
        for (Banner banner:banners){
            banner.setImgUrl(Commons.img_url + "/banner/" + banner.getImgUrl());
        }

        lines.put("banners", banners);

        //获取首页内容信息
        Sort.Order lineOrder = new Sort.Order(Sort.Direction.ASC, "lineOrder");
        Sort.Order indexOrder = new Sort.Order(Sort.Direction.ASC, "indexOrder");
        List<Sort.Order> list = new ArrayList<Sort.Order>();
        list.add(lineOrder);
        list.add(indexOrder);
        Sort sort = new Sort(list);
        List<HomePage> homePages = homePageRepository.findAllByStatusNot(0, sort);
        List<Line> pages = new ArrayList<Line>();

        int current_line = 0;
        Line line = null;
        for (HomePage homePage:homePages){

            if (current_line != homePage.getLineOrder()){
                current_line = homePage.getLineOrder();
                line = new Line(0, new ArrayList<Object>());
                pages.add(line);
            }
            if (current_line < 1000){
                line.setType(HomePageType.commodity_pages.ordinal());
                line.getLine().add(getLine(homePage));
            }else if (current_line < 2000){
                line.setType(HomePageType.about_us.ordinal());
                line.getLine().add(getLine(homePage));
            }else{
                line.setType(HomePageType.join_us.ordinal());
                line.getLine().add(getLine(homePage));
            }
        }

        lines.put("pages", pages);
        return lines;
    }

    private class Line{
        private int type;
        private List<Object> line;

        public Line() {
        }

        public Line(int type, List<Object> line) {
            this.type = type;
            this.line = line;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<Object> getLine() {
            return line;
        }

        public void setLine(List<Object> line) {
            this.line = line;
        }
    }
}
