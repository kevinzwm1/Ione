package com.kevinzhao.weather.web;

import com.kevinzhao.weather.domain.City;
import com.kevinzhao.weather.service.CityService;
import com.kevinzhao.weather.service.query.CityQuery;
import com.kevinzhao.weather.web.dto.CityInput;
import com.kevinzhao.weather.web.dto.CityUpdateInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/cities")
public class CityController {

    private CityService service;

    @Autowired
    public void setService(CityService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<City> listCities(@Valid CityQuery query) {
        return service.findAll(query);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public City addCity(@Valid @RequestBody CityInput input) throws BindException {
        // FIXME
        return null;
    }


    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    public City getCity(@PathVariable String uuid) {
        // FIXME
        return null;
    }

    @RequestMapping(value = "/{uuid}", method = RequestMethod.PUT)
    public City updateCity(@PathVariable String uuid, @Valid @RequestBody CityUpdateInput input) throws BindException {
        // FIXME
        return null;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{uuid}", method = RequestMethod.DELETE)
    public void deleteCity(@PathVariable String uuid) {
        // FIXME
    }
}




