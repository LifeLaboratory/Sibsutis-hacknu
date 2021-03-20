package com.haknu.btsdigital.repo;

import com.haknu.btsdigital.domain.Organization;
import com.haknu.btsdigital.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrganizationRepository extends JpaRepository<Organization, Long>, JpaSpecificationExecutor<Organization> {
    Organization findByName(String name);
    Organization findOrganizationById(Long id);
    boolean existsOrganizationById(Long id);
}
