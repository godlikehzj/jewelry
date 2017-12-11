package com.jewelry.bean.entity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public enum Sortype {
    createTime("最新", 1),
    price_high("最贵", 2),
    price_low("最便宜", 3),
    hot("最热", 4);

    // 成员变量
    private String name;
    private int index;

    Sortype(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public JSONArray getSortypeList(){
        JSONArray jsonArray = new JSONArray();
        for(Sortype sortype : Sortype.values()){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", sortype.name);
            jsonObject.put("id", sortype.index);
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
}
