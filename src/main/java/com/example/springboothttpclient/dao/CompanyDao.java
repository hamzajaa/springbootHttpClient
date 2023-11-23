package com.example.springboothttpclient.dao;

import com.example.springboothttpclient.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDao extends JpaRepository<Company, Long> {
}
