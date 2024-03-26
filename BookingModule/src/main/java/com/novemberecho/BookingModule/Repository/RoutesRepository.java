package com.novemberecho.BookingModule.Repository;


import com.novemberecho.BookingModule.Entity.Routes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutesRepository extends JpaRepository<Routes, Integer> {
}
