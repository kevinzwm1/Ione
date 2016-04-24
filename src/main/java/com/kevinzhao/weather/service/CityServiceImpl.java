package com.kevinzhao.weather.service;

import com.kevinzhao.weather.dao.CityRepository;
import com.kevinzhao.weather.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;


@Service
public class CityServiceImpl implements CityService {

    private CityRepository repository;
    private EntityManager entityManager;


    public JpaRepository<City, String> getRepository() {
        return repository;
    }

    @Autowired
    public void setRepository(CityRepository repository) {
        this.repository = repository;
    }


    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}



