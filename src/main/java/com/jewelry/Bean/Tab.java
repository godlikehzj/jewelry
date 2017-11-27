package com.jewelry.Bean;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by godlikehzj on 2017/11/5.
 */
@Entity
public class Tab {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private Long parent;

    public Tab() {
    }

    public Tab(String title, Long parent) {
        this.title = title;
        this.parent = parent;
    }
}
