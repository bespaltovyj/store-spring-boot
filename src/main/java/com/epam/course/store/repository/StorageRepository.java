package com.epam.course.store.repository;

import com.epam.course.store.domain.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<Storage, Integer> {
}
