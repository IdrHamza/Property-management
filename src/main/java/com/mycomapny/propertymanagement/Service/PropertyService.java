package com.mycomapny.propertymanagement.Service;

import com.mycomapny.propertymanagement.Model.PropertyDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {
    public PropertyDto saveProperty(PropertyDto propertydto);
    public List<PropertyDto> getAllProperties();
    PropertyDto updateProperty(PropertyDto propertyDto,Long propertyId);
    PropertyDto updatPropertyDescription(@RequestBody PropertyDto propertyDto, Long propertyId);
    PropertyDto updatPropertyPrice(@RequestBody PropertyDto propertyDto, Long propertyId);
    void deleteProperty(Long propertyId);

}
