package com.haknu.btsdigital.service;


import com.haknu.btsdigital.domain.Organization;
import com.haknu.btsdigital.domain.User;
import com.haknu.btsdigital.repo.OrganizationRepository;
import com.haknu.btsdigital.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Slf4j
@Component
public class OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

    @Transactional
    public Organization getOrganizationById(Long id) {
        if(organizationRepository.existsOrganizationById(id)) {
            return organizationRepository.findOrganizationById(id);
        }else{
            return null;
        }
    }

    @Transactional
    public Organization addNewOrganization(Organization organization) {
        if(organizationRepository.existsOrganizationById(organization.getId())) {
            return null;
        }else{
            organizationRepository.save(organization);
            return organizationRepository.findOrganizationById(organization.getId());
        }
    }

    @Transactional
    public HttpStatus authOrganization(Organization organization) {
        if(organizationRepository.existsOrganizationById(organization.getId())) {
            return HttpStatus.ACCEPTED;
        }else{
            return HttpStatus.NOT_FOUND;
        }
    }
}
