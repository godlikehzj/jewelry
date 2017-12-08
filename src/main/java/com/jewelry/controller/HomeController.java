package com.jewelry.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jewelry.bean.entity.Response;
import com.jewelry.bean.jpa.Banner;
import com.jewelry.bean.jpa.BodyPart;
import com.jewelry.bean.jpa.HomePage;
import com.jewelry.bean.jpa.JewelryType;
import com.jewelry.dao.BannerRepository;
import com.jewelry.dao.BodyPartRepository;
import com.jewelry.dao.HomePageRepository;
import com.jewelry.dao.JewelryTypeRepository;
import com.jewelry.service.HomeService;
import com.jewelry.utils.ApiStatus;
import com.jewelry.utils.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by godlikehzj on 2017/11/4.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @RequestMapping(value = "/head.json",produces = MediaType.APPLICATION_JSON_VALUE)
    Response head(){
        return new Response(ApiStatus.ok, ApiStatus.msg.get(ApiStatus.ok), homeService.getHeadMenu());
    }

    @RequestMapping(value = "/banner.json",produces = MediaType.APPLICATION_JSON_VALUE)
    Response banner(){
        return new Response(ApiStatus.ok, ApiStatus.msg.get(ApiStatus.ok), homeService.getBannerList());
    }

    @RequestMapping(value = "/page.json",produces = MediaType.APPLICATION_JSON_VALUE)
    Response homePage(){
        return new Response(ApiStatus.ok, ApiStatus.msg.get(ApiStatus.ok), homeService.getHomePageContent());
    }
}
