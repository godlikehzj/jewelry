package com.jewelry.controller;

import com.jewelry.bean.entity.Response;
import com.jewelry.service.JoinUsService;
import com.jewelry.service.en.JoinUsENService;
import com.jewelry.utils.ApiStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/join_us")
public class JoinUsController {
    @Autowired
    private JoinUsService joinUsService;

    @Autowired
    private JoinUsENService joinUsServiceEn;

    @RequestMapping(value = "/content",produces = MediaType.APPLICATION_JSON_VALUE)
    Response joinUsContent(){
        return new Response(ApiStatus.ok, ApiStatus.msg.get(ApiStatus.ok), joinUsService.getJoinUsContent(),joinUsServiceEn.getJoinUsContent());
    }
}
