package com.epam.course.store.repository;

import com.epam.course.store.domain.ItemBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemBalanceRepository extends JpaRepository<ItemBalance, Integer> {
}
