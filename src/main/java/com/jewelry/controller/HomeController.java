package com.jewelry.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jewelry.Bean.Button;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * Created by godlikehzj on 2017/11/4.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/home")
public class HomeController {
    @RequestMapping(value = "/head.json",produces = MediaType.APPLICATION_JSON_VALUE)
    String head(){
        JSONObject headMenu = new JSONObject();
        JSONArray buttons = new JSONArray();

        Button b1 = new Button();
        b1.setName("珍珠");
        List<Button> sub_buttons = new ArrayList<Button>();
        sub_buttons.add(new Button());

//        b1.put("name", "珍珠");
//        b1.put("sub_button", new JSONArray())
//        buttons.add();
//        headMenu.put();
        Executor
        return "";
    }


}
