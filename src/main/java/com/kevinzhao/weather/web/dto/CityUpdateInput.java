package com.kevinzhao.weather.web.dto;

import org.hibernate.validator.constraints.NotBlank;

public class CityUpdateInput {
    private String name;
    private String id;

    @NotBlank
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

