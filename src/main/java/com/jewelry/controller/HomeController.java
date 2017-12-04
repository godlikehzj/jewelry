package com.jewelry.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jewelry.bean.entity.Response;
import com.jewelry.bean.jpa.BodyPart;
import com.jewelry.bean.jpa.JewelryType;
import com.jewelry.dao.BodyPartRepository;
import com.jewelry.dao.JewelryTypeRepository;
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
    private JewelryTypeRepository jewelryTypeRepository;
    @Autowired
    private BodyPartRepository bodyPartRepository;

    @RequestMapping(value = "/head.json",produces = MediaType.APPLICATION_JSON_VALUE)
    Response head(){
        JSONObject headMenu = new JSONObject();
        JSONArray buttons = new JSONArray();

        List<JewelryType> jewelryTypes = jewelryTypeRepository.findAll();
        JSONArray result = new JSONArray();

        for(JewelryType jewelryType:jewelryTypes){
            List<BodyPart> bodyParts = bodyPartRepository.findByTypeIdEquals(jewelryType.getId());
            JSONObject type = (JSONObject)JSON.toJSON(jewelryType);
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
        return new Response(0, "OK", result);
    }


}
