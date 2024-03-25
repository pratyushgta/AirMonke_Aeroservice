package com.novemberecho.AdminModule.Repository;

import com.novemberecho.AdminModule.Entity.Routes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutesRepository extends JpaRepository<Routes, Integer> {
}
