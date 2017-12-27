package com.jewelry.service.en;

import com.jewelry.dao.en.JoinUsENRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinUsENService {
    @Autowired
    private JoinUsENRepository joinUsRepository;

    public Object getJoinUsContent(){
        return joinUsRepository.getByStatus(1);
    }
}
