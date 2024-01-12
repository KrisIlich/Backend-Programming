package com.d288.d288backendprogramming.dao;

import com.d288.d288backendprogramming.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CountryRepository extends JpaRepository<Country, Long> {
}
