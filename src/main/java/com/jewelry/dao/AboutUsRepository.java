package com.jewelry.dao;

import com.jewelry.bean.jpa.AboutUs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AboutUsRepository  extends JpaRepository<AboutUs, Long>{
    List<AboutUs> findAllByStatus(int status);
}
