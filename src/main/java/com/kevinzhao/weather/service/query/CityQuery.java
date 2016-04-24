package com.kevinzhao.weather.service.query;

import com.kevinzhao.weather.domain.City;
import com.kevinzhao.weather.service.Queryable;
import org.apache.commons.lang3.StringUtils;
import org.torpedoquery.jpa.OnGoingLogicalCondition;
import org.torpedoquery.jpa.Query;

import java.util.ArrayList;
import java.util.List;

import static org.torpedoquery.jpa.Torpedo.*;


public class CityQuery implements Queryable<City> {
    private String name;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Query<City> buildQuery() {
        City from = from(City.class);
        List<OnGoingLogicalCondition> conditions = new ArrayList<>();

        if (StringUtils.isNotBlank(id)) {
            conditions.add(condition(from.getId()).eq(id));
        }

        if (StringUtils.isNotBlank(name)) {
            conditions.add(condition(from.getName()).eq(name));
        }

        if (!conditions.isEmpty()) {
            where(and(conditions));
        }
        orderBy(from.getId());

        return select(from);
    }

}

