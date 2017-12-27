package com.jewelry.controller;

import com.jewelry.bean.entity.Response;
import com.jewelry.service.AboutUsService;
import com.jewelry.service.en.AboutUsENService;
import com.jewelry.utils.ApiStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/about_us")
public class AboutUsController {
    @Autowired
    private AboutUsService aboutUsService;

    @Autowired
    private AboutUsENService aboutUsServiceEn;

    @RequestMapping(value = "/content",produces = MediaType.APPLICATION_JSON_VALUE)
    Response aboutUsContent(){
        return new Response(ApiStatus.ok, ApiStatus.msg.get(ApiStatus.ok), aboutUsService.getAboutUsContent(), aboutUsServiceEn.getAboutUsContent());
    }
}
