package com.qa.lbg.repos;

import com.qa.lbg.entities.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PropertiesRepo extends JpaRepository<Properties, Integer> {
}
