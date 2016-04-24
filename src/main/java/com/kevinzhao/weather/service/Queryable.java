package com.kevinzhao.weather.service;

/**
 * Created by kevin on 24/04/2016.
 */
import org.torpedoquery.jpa.Query;

public interface Queryable<T> {
    Query<T> buildQuery();
}
