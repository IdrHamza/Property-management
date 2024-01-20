package com.mycomapny.propertymanagement.Controller;

import com.mycomapny.propertymanagement.Model.PropertyDto;
import com.mycomapny.propertymanagement.Service.PropertyService;
import com.mycomapny.propertymanagement.Service.impl.PropertyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vi")
public class PropertyController {
    @Value("${pms.dummy}")
    private String dummy;
    @Autowired
    private PropertyService propertyservice ;
    @GetMapping("/hello")

    public String sayHello(){
        return " Hello " ;
    }
    @PostMapping("/properties")
    public ResponseEntity<PropertyDto> saveProperty(@RequestBody  PropertyDto propertyDto){
        propertyDto=propertyservice.saveProperty(propertyDto);
        ResponseEntity<PropertyDto> responseEntity=new ResponseEntity<>(propertyDto, HttpStatus.CREATED);

       return responseEntity;
    }
    @GetMapping("/properties")
    public   ResponseEntity<List<PropertyDto>> getAllProperties(){
        List<PropertyDto> propertylist= propertyservice.getAllProperties();
        ResponseEntity<List<PropertyDto>> responseEntity=new ResponseEntity<>(propertylist,HttpStatus.CREATED);
        return responseEntity;
    }
    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDto> updateProperty(@RequestBody PropertyDto propertyDto,@PathVariable Long propertyId){
       propertyDto= propertyservice.updateProperty(propertyDto,propertyId);
        ResponseEntity<PropertyDto>responseEntity=new ResponseEntity<>(propertyDto,HttpStatus.CREATED);
        return responseEntity;
    }
    @PatchMapping("properties/properties-Description/{propertyId}")
    public ResponseEntity<PropertyDto>updatPropertyDescription(@RequestBody PropertyDto propertyDto, @PathVariable  Long propertyId){
       propertyDto= propertyservice.updatPropertyDescription(propertyDto,propertyId);
        ResponseEntity<PropertyDto>responseEntity=new ResponseEntity<>(propertyDto,HttpStatus.OK);
        return responseEntity;}
    @PatchMapping("properties/properties-Price/{propertyId}")
    public ResponseEntity<PropertyDto> updatPropertyPrice(@RequestBody PropertyDto propertyDto, @PathVariable  Long propertyId){
      propertyDto=  propertyservice.updatPropertyPrice(propertyDto,propertyId);
        ResponseEntity<PropertyDto>responseEntity=new ResponseEntity<>(propertyDto,HttpStatus.OK);
        return responseEntity;}
    @DeleteMapping("properties/{propertyId}")
    public ResponseEntity deleteProperty(@PathVariable Long propertyId){
        propertyservice.deleteProperty(propertyId);
        ResponseEntity<Void> responseEntity=new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        return responseEntity;
    }

}
