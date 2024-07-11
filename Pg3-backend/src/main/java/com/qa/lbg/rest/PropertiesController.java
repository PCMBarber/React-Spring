package com.qa.lbg.rest;

import com.qa.lbg.entities.Properties;
import com.qa.lbg.services.PropertiesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="properties")
@CrossOrigin
public class PropertiesController {

    private PropertiesService service;

    public PropertiesController(PropertiesService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<Properties> getAll() {
        return this.service.getAll();
    }


    @PostMapping("/create")
    public Properties createProperties(@RequestBody Properties properties) {
        return this.service.createProperties(properties);
    }

    @DeleteMapping("/remove/{propertyId}")
    public Properties removeProperties(@PathVariable int propertyId) {
        return this.service.removeProperties(propertyId);
    }

    @PatchMapping("/update/{propertyId}")
    public Properties updateProperties(@PathVariable int propertyId,
                                @RequestParam(required = false) String type,
                                @RequestParam(required = false) String location,
                                @RequestParam(required = false) Integer bedrooms,
                                @RequestParam(required = false) Integer bathrooms,
                                @RequestParam(required = false) Integer price,
                                @RequestParam(required = false) String imageUrl) {
        return this.service.updateProperties(propertyId, type, location, bedrooms, bathrooms, price, imageUrl);
    }

}
