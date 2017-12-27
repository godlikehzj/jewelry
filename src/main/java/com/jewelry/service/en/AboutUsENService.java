package com.jewelry.service.en;

import com.jewelry.dao.en.AboutUsENRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutUsENService {
    @Autowired
    private AboutUsENRepository aboutUsRepository;

    public Object getAboutUsContent(){
        return aboutUsRepository.findAllByStatus(1);
    }
}
