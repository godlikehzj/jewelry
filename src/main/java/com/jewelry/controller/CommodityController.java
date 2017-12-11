package com.jewelry.controller;

import com.jewelry.bean.entity.Response;
import com.jewelry.service.CommodityService;
import com.jewelry.utils.ApiStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @RequestMapping(value = "/list.json",produces = MediaType.APPLICATION_JSON_VALUE)
    Response commodityList(@RequestParam("type_id") Integer type_id,
                           Integer part_id,
                           Integer meterial_id,
                           Integer sort){
        return new Response(ApiStatus.ok, ApiStatus.msg.get(ApiStatus.ok), commodityService.getCommodityList(type_id, part_id, meterial_id, sort));
    }

    @RequestMapping(value = "/one.json",produces = MediaType.APPLICATION_JSON_VALUE)
    Response oneCommodity(@RequestParam("commodity_id") Long commodity_id){
        return new Response(ApiStatus.ok, ApiStatus.msg.get(ApiStatus.ok), commodityService.getCommodity(commodity_id));
    }
}
