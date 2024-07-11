package com.qa.lbg.services;

import com.qa.lbg.entities.Properties;
import com.qa.lbg.repos.PropertiesRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertiesService {

    private PropertiesRepo repo;

    public PropertiesService(PropertiesRepo repo) {
        this.repo = repo;
    }

    public List<Properties> getAll() {
        return this.repo.findAll();
    }

    public Properties createProperties(Properties properties) {
          return this.repo.save(properties);
    }

    public Properties removeProperties(int propertyId) {

        Properties remove = this.repo.findById(propertyId).get();
        this.repo.deleteById(propertyId);
          return remove;
    }

    public Properties updateProperties(int propertyId,
                                String type,
                                String location,
                                Integer bedrooms,
                                Integer bathrooms,
                                Integer price,
                                String imageUrl) {

        Properties toUpdate = this.repo.findById(propertyId).get();

        if (type != null) toUpdate.setType(type);
        if (location != null) toUpdate.setLocation(location);
        if (bedrooms != null) toUpdate.setBedrooms(bedrooms);
        if (bathrooms != null) toUpdate.setBathrooms(bathrooms);
        if (price != null) toUpdate.setPrice(price);
        if (imageUrl != null) toUpdate.setImageUrl(imageUrl);

        return this.repo.save(toUpdate);
    }

}
