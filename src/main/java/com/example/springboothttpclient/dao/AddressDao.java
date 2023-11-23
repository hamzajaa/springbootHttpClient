package com.example.springboothttpclient.dao;

import com.example.springboothttpclient.beans.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address, Long> {
}
