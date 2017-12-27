package com.jewelry.controller;

import com.jewelry.bean.entity.Response;
import com.jewelry.service.CommodityService;
import com.jewelry.service.en.CommodityENService;
import com.jewelry.utils.ApiStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @Autowired
    private CommodityENService commodityServiceEn;

    @RequestMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    Response commodityList(@RequestParam("list_id") Long list_id,
                           String meterial_id,
                           Integer sort){
        List<Long> mids = null;
        if (meterial_id != null && !meterial_id.isEmpty()){
            String[] amids = meterial_id.split(",");
            List<String> smids = Arrays.asList(amids);
            mids = new ArrayList<Long>();
            for(String mid:smids)
                mids.add(Long.valueOf(mid));
        }
        return new Response(ApiStatus.ok, ApiStatus.msg.get(ApiStatus.ok), commodityService.getCommodityList(list_id, mids, sort), commodityServiceEn.getCommodityList(list_id, mids, sort));
    }

    @RequestMapping(value = "/one",produces = MediaType.APPLICATION_JSON_VALUE)
    Response oneCommodity(@RequestParam("commodity_id") Long commodity_id){
        return new Response(ApiStatus.ok, ApiStatus.msg.get(ApiStatus.ok), commodityService.getCommodity(commodity_id),commodityServiceEn.getCommodity(commodity_id));
    }

    @RequestMapping(value = "meterial/list" ,produces = MediaType.APPLICATION_JSON_VALUE)
    Response meterialList(@RequestParam("type_id") Long type_id){
        return new Response(ApiStatus.ok, ApiStatus.msg.get(ApiStatus.ok), commodityService.getMeterialList(type_id), commodityServiceEn.getMeterialList(type_id));
    }
}
