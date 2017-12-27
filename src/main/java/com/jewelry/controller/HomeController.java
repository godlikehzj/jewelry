package com.jewelry.controller;

import com.jewelry.bean.entity.Response;
import com.jewelry.service.HomeService;
import com.jewelry.service.en.HomeENService;
import com.jewelry.utils.ApiStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by godlikehzj on 2017/11/4.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @Autowired
    private HomeENService homeServiceEn;

    @RequestMapping(value = "/menu",produces = MediaType.APPLICATION_JSON_VALUE)
    Response head(){
        return new Response(ApiStatus.ok, ApiStatus.msg.get(ApiStatus.ok), homeService.getHeadMenu(),  homeServiceEn.getHeadMenu());
    }

    @RequestMapping(value = "/banner",produces = MediaType.APPLICATION_JSON_VALUE)
    Response banner(){
        return new Response(ApiStatus.ok, ApiStatus.msg.get(ApiStatus.ok), homeService.getBannerList(), homeServiceEn.getBannerList());
    }

    @RequestMapping(value = "/page",produces = MediaType.APPLICATION_JSON_VALUE)
    Response homePage(){
        return new Response(ApiStatus.ok, ApiStatus.msg.get(ApiStatus.ok), homeService.getHomePageContent(), homeServiceEn.getHomePageContent());
    }
}
