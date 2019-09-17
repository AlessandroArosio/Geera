package com.alessandro.computershare.database.dao;

import com.alessandro.computershare.database.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Integer> {
}
