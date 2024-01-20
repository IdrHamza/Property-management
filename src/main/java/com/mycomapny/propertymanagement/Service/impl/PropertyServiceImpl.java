package com.mycomapny.propertymanagement.Service.impl;

import com.mycomapny.propertymanagement.Converter.PropertyConverter;
import com.mycomapny.propertymanagement.Entity.PropertyEntity;
import com.mycomapny.propertymanagement.Model.PropertyDto;
import com.mycomapny.propertymanagement.Repository.PropertyReposetory;
import com.mycomapny.propertymanagement.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyReposetory propertyrepository ;
    @Autowired
    PropertyConverter propertyconverter;
    @Override
    public PropertyDto saveProperty(PropertyDto propertydto) {
        PropertyEntity pe=propertyconverter.convertDtoEntity(propertydto);
        pe=propertyrepository.save(pe);
        PropertyDto dto=propertyconverter.entitytoDto(pe);

         return  dto ;
    }

    @Override
    public List<PropertyDto> getAllProperties( ) {
       List<PropertyEntity>listofprop= (List<PropertyEntity>)propertyrepository.findAll();
       List<PropertyDto>proplist=new ArrayList<>();
       for(PropertyEntity pe: listofprop){
           PropertyDto dto=propertyconverter.entitytoDto(pe);
           proplist.add(dto);
       }
        return  proplist;
    }

    @Override
    public PropertyDto updateProperty(PropertyDto propertydto, Long propertyId) {
      Optional<PropertyEntity> optEn= propertyrepository.findById(propertyId);
      PropertyDto dto=null;
      if(optEn.isPresent()){
          PropertyEntity pe=optEn.get();//Data from Database
          pe.setTitle(propertydto.getTitle());
          pe.setAdress(propertydto.getAdress());
          pe.setOwnerName(propertydto.getOwnerName());
          pe.setDescription(propertydto.getDescription());
          pe.setOwnerEmail(propertydto.getOwnerEmail());
          pe.setPrice(propertydto.getPrice());
          dto=propertyconverter.entitytoDto(pe);
          propertyrepository.save(pe);
      }
      return dto;
    }

    @Override
    public PropertyDto updatPropertyDescription(PropertyDto propertyDto, Long propertyId) {
        Optional<PropertyEntity> optEn= propertyrepository.findById(propertyId);
        PropertyDto dto=null;
        if(optEn.isPresent()){
            PropertyEntity pe=optEn.get();//Data from Database
           ;
            pe.setDescription(propertyDto.getDescription());

            dto=propertyconverter.entitytoDto(pe);
            propertyrepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDto updatPropertyPrice(PropertyDto propertyDto, Long propertyId) {
        Optional<PropertyEntity> optEn= propertyrepository.findById(propertyId);
        PropertyDto dto=null;
        if(optEn.isPresent()){
            PropertyEntity pe=optEn.get();//Data from Database
            ;
            pe.setPrice(propertyDto.getPrice());

            dto=propertyconverter.entitytoDto(pe);
            propertyrepository.save(pe);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyrepository.deleteById(propertyId);
    }

}
