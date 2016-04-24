package com.kevinzhao.weather.service.query;

import com.kevinzhao.weather.domain.City;
import com.kevinzhao.weather.service.query.CityQuery;
import org.junit.Test;
import org.torpedoquery.jpa.Query;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class CityQueryTest {

    @Test
    public void testBuildQuery() throws Exception {
        CityQuery query = new CityQuery();
        Query<City> q = query.buildQuery();
        assertThat(q.getQuery(), is("select city_0 from City city_0 order by city_0.id"));
        assertThat(q.getParameters().size(), is(0));
    }

    @Test
    public void testBuildQueryByName() throws Exception {
        CityQuery query = new CityQuery();
        query.setName("Sydney");
        Query<City> q = query.buildQuery();
        assertThat(q.getQuery(), is("select city_0 from City city_0 where ( ( city_0.name = :name_1 ) )  order by city_0.id"));
        assertThat(q.getParameters().size(), is(1));
    }
}

