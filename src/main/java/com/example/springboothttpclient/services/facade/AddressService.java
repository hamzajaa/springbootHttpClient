package com.example.springboothttpclient.services.facade;

import com.example.springboothttpclient.beans.Address;

import java.util.List;

public interface AddressService {

    List<Address> findAll();
    Address findById(Long id);

    Address save(Address address);

    Address update(Address address, Long id);

    int delete(Long id);

}
