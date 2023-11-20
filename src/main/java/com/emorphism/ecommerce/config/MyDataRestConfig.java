package com.emorphism.ecommerce.config;

import com.emorphism.ecommerce.entity.ProductCategory;
import com.emorphism.ecommerce.entity.product;
//import org.hibernate.type.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    private EntityManager entityManager;
    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }



    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config){
        HttpMethod[]    theUnsupportedActions = {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};
        //disable HttpMethod for Product : PUT , POST AND DELETE
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods
                        .disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods
                        .disable(theUnsupportedActions));
        config.getExposureConfiguration()
                .forDomainType(product
                        .class)
                .withItemExposure((metdata, httpMethods) -> httpMethods
                        .disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods
                        .disable(theUnsupportedActions));
        //call an internal  helper methods
        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        //expose entity ids method
        //-> get  a list of all entity classes from the entity manager
        Set<EntityType<?>> entites = entityManager.getMetamodel().getEntities();
        //create an array of the entity types
        List<Class> entityclasses = new ArrayList<>();
        //get the entity type for the entites
        for (EntityType tempEntityType : entites){
            entityclasses.add(tempEntityType.getJavaType());

            //expose the entity ids for the array of entity /domin types
             Class[] dominTypes = entityclasses.toArray(new Class[0]);
             config.exposeIdsFor(dominTypes);

{

            }

        }
    }

}
