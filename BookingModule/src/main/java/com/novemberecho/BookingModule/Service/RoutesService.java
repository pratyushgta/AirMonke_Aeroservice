package com.novemberecho.BookingModule.Service;

import com.novemberecho.BookingModule.Entity.Routes;
import com.novemberecho.BookingModule.Repository.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoutesService {
    @Autowired
    RoutesRepository routesRepository;

    public void addRoute(Routes routes) {
        routesRepository.save(routes);
    }

    public List<Routes> getAllRoutes() {
        return routesRepository.findAll();
    }

    public void deleteRoutebyID(int id) {
        routesRepository.deleteById(id);
    }

    public Optional<Routes> getRoutesbyID(int id) {
        return routesRepository.findById(id);
    }
}
