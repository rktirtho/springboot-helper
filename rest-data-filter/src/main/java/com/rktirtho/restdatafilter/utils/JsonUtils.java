package com.rktirtho.restdatafilter.utils;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;

public class JsonUtils {

    public static MappingJacksonValue jsonValueInclude(String filterName, Object teacher, String[] fields) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(teacher);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
        FilterProvider filters = new SimpleFilterProvider().addFilter(filterName, filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    public static MappingJacksonValue jsonValueIgnore(String filterName, Object teacher, String[] fields) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(teacher);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept(fields);
        FilterProvider filters = new SimpleFilterProvider().addFilter(filterName, filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}
