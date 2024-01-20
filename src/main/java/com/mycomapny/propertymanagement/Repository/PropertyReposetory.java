package com.mycomapny.propertymanagement.Repository;

import com.mycomapny.propertymanagement.Entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service

public interface PropertyReposetory extends CrudRepository <PropertyEntity,Long> {

}
