package com.example.springboothttpclient.services.facade;

import com.example.springboothttpclient.beans.Company;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();
    Company findById(Long id);

    Company save(Company company);

    Company update(Company company, Long id);

    int delete(Long id);

}
