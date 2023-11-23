package com.example.springboothttpclient.services.impl;

import com.example.springboothttpclient.beans.Company;
import com.example.springboothttpclient.dao.CompanyDao;
import com.example.springboothttpclient.services.facade.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyDao companyDao;

    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }


    @Override
    public List<Company> findAll() {
        return companyDao.findAll();
    }

    @Override
    public Company findById(Long id) {
        return companyDao.findById(id).orElse(null);
    }

    @Override
    public Company save(Company company) {
        return companyDao.save(company);
    }

    @Override
    public Company update(Company company, Long id) {
        Company foundedCompany = findById(id);
        if (foundedCompany == null) return null;
        return companyDao.save(company);
    }

    @Override
    public int delete(Long id) {
        Company foundedCompany = findById(id);
        if (foundedCompany == null) return -1;
        companyDao.deleteById(id);
        return 1;
    }
}
