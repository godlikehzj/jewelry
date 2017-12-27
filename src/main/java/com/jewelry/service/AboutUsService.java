package com.jewelry.service;

import com.jewelry.dao.cn.AboutUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutUsService {
    @Autowired
    private AboutUsRepository aboutUsRepository;

    public Object getAboutUsContent(){
        return aboutUsRepository.findAllByStatus(1);
    }
}
