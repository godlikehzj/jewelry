package com.jewelry.dao.cn;

import com.jewelry.bean.jpa.cn.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BannerRepository extends JpaRepository<Banner, Long> {
    List<Banner> findAllByStatus(int status);
}
