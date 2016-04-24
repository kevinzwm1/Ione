package com.kevinzhao.weather.web;


import com.kevinzhao.base.web.AbstractControllerTest;
import com.kevinzhao.weather.domain.City;
import com.kevinzhao.weather.service.CityService;
import com.kevinzhao.weather.service.query.CityQuery;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ContextConfiguration(classes = {TestConfig.class})
public class CityControllerTest   extends AbstractControllerTest {
    @Autowired
    private CityService mockService;
    private List<City> allCities;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        reset(mockService);
        allCities = new ArrayList<City>();
        City sydney = new City();
        sydney.setId("6619279");
        sydney.setName("Sydney");

        City melbourne = new City();
        melbourne.setId("7839805");
        melbourne.setName("Melborune");

        City wollongong = new City();
        wollongong.setId("7839791");
        wollongong.setName("Wollongong");

        allCities.add(sydney);
        allCities.add(melbourne);
        allCities.add(wollongong);
    }

    @Test
    public void testListCities() throws Exception {
        when(mockService.findAll(any(CityQuery.class))).thenReturn(allCities);

        MockHttpServletRequestBuilder requestBuilder = get("/cities")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$[0].id").value(allCities.get(0).getId())).andExpect(jsonPath("$[0].name").value(allCities.get(0).getName()))
                .andExpect(jsonPath("$[1].id").value(allCities.get(1).getId())).andExpect(jsonPath("$[1].name").value(allCities.get(1).getName()));
    }
}