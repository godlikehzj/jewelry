package com.jewelry.dao.en;

import com.jewelry.bean.jpa.en.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BannerENRepository extends JpaRepository<Banner, Long> {
    List<Banner> findAllByStatus(int status);
}
