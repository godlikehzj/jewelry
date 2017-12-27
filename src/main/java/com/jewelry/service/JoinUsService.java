package com.jewelry.service;

import com.jewelry.dao.cn.JoinUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinUsService {
    @Autowired
    private JoinUsRepository joinUsRepository;

    public Object getJoinUsContent(){
        return joinUsRepository.getByStatus(1);
    }
}
