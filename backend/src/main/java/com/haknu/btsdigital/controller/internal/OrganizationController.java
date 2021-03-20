package com.haknu.btsdigital.controller.internal;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haknu.btsdigital.domain.Organization;
import com.haknu.btsdigital.domain.User;
import com.haknu.btsdigital.service.OrganizationService;
import com.haknu.btsdigital.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;

    @RequestMapping(value = "/api/organization/profile/id", method = RequestMethod.POST)
    public Organization getOrganizationProfile(@RequestBody String object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Organization org = mapper.readValue(object, Organization.class);
        return organizationService.getOrganizationById(org.getId());
    }

    @RequestMapping(value = "/api/organization/newOrganization", method = RequestMethod.POST)
    public Organization addNewOrganization(@RequestBody String object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Organization organization = mapper.readValue(object, Organization.class);
        return organizationService.addNewOrganization(organization);
    }

    @RequestMapping(value = "/api/organization/authOrganization", method = RequestMethod.POST)
    public ResponseEntity<?> authUOrganization(@RequestBody String object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Organization organization = mapper.readValue(object, Organization.class);
        if (organizationService.authOrganization(organization).equals(HttpStatus.ACCEPTED)) {
            return ResponseEntity.ok(organization);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
