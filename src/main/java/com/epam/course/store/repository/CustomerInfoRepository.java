package com.epam.course.store.repository;

import com.epam.course.store.domain.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Integer> {
}
