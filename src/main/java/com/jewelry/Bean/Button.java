package com.jewelry.Bean;

import java.util.List;

/**
 * Created by godlikehzj on 2017/11/25.
 */
public class Button {
    private String name;
    private String url;
    private List<Button> sub_button;

    public Button() {
    }

    public Button(String name, String url, List<Button> sub_button) {
        this.name = name;
        this.url = url;
        this.sub_button = sub_button;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Button> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<Button> sub_button) {
        this.sub_button = sub_button;
    }
}
