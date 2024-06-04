/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sng.ecommerce_sboot.config;

import com.sng.ecommerce_sboot.entity.Product;
import com.sng.ecommerce_sboot.entity.ProductCategory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 *
 * @author mahmoud
 */
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
    
    /**
     * Read Only approach
     * @param config
     * @param cors
     */
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnSupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
        // disable HTTP methods for Product: PUT, POST and DELETE
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnSupportedActions))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnSupportedActions));
        
        // disable HTTP methods for ProductCategory: PUT, POST and DELETE
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnSupportedActions))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnSupportedActions));
    
        // call an internal helper method
        exposeIds(config);
    }

    // developed method to expose the IDs
    // spring-data-rest don't expose IDs for objs by default
    private void exposeIds(RepositoryRestConfiguration config){
        // expose entity IDs
        
        // get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
        
        // create an array of the entity types
        List<Class> entityClasses = new ArrayList<>();
        
        // get the entity types for the entities
        for (EntityType tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }
        
        // expose the entity IDs for the array of entity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }
    
}
