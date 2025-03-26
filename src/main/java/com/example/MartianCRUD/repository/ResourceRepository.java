package com.example.MartianCRUD.repository;

import com.example.MartianCRUD.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {}
