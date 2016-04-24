package com.kevinzhao.weather.service;

/**
 * Created by kevin on 24/04/2016.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.torpedoquery.jpa.Query;

import javax.persistence.EntityManager;
import java.util.List;

public interface QueryService<T> {
    Logger logger = LoggerFactory.getLogger(QueryService.class);

    JpaRepository<T, String> getRepository();

    EntityManager getEntityManager();

    @Transactional(
            readOnly = true
    )
    default List<T> findAll(Queryable query) {
        Query q = query.buildQuery();
        logger.debug("JPQL: {} with parameter {}", q.getQuery(), q.getParameters());
        return q.list(this.getEntityManager());
    }
}
