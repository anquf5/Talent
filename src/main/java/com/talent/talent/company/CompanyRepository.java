package com.talent.talent.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository
        extends JpaRepository<Company, Long> {

    @Query("SELECT c FROM Company c WHERE c.name = ?1")
    Optional<Company> findCompanyByName(String name);
}
