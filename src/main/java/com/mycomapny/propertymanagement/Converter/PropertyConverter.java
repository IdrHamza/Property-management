package com.mycomapny.propertymanagement.Converter;

import com.mycomapny.propertymanagement.Entity.PropertyEntity;
import com.mycomapny.propertymanagement.Model.PropertyDto;
import org.springframework.stereotype.Component;

@Component

public class PropertyConverter {
    public PropertyEntity convertDtoEntity(PropertyDto propertydto){
        PropertyEntity pe=new PropertyEntity();
        pe.setTitle(propertydto.getTitle());
        pe.setAdress(propertydto.getAdress());
        pe.setOwnerName(propertydto.getOwnerName());
        pe.setDescription(propertydto.getDescription());
        pe.setOwnerEmail(propertydto.getOwnerEmail());
        pe.setPrice(propertydto.getPrice());
        return pe;

    }
    public  PropertyDto entitytoDto(PropertyEntity propertyEntity){
        PropertyDto propertyDto= new PropertyDto();
        propertyDto.setId(propertyDto.getId());
        propertyDto.setAdress(propertyEntity.getAdress());
        propertyDto.setDescription(propertyEntity.getDescription());
        propertyDto.setTitle(propertyEntity.getTitle());
        propertyDto.setPrice(propertyEntity.getPrice());
        propertyDto.setOwnerEmail(propertyEntity.getOwnerEmail());
        propertyDto.setOwnerName(propertyEntity.getOwnerName());
        return propertyDto;
    }
}
