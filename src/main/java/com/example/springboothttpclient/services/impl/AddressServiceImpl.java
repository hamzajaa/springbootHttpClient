package com.example.springboothttpclient.services.impl;

import com.example.springboothttpclient.beans.Address;
import com.example.springboothttpclient.beans.Geo;
import com.example.springboothttpclient.dao.AddressDao;
import com.example.springboothttpclient.services.facade.AddressService;
import com.example.springboothttpclient.services.facade.GeoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressDao addressDao;
    private GeoService geoService;

    public AddressServiceImpl(AddressDao addressDao, GeoService geoService) {
        this.addressDao = addressDao;
        this.geoService = geoService;
    }


    @Override
    public List<Address> findAll() {
        return addressDao.findAll();
    }

    @Override
    public Address findById(Long id) {
        return addressDao.findById(id).orElse(null);
    }

    @Override
    public Address save(Address address) {
        if (address == null) return null;
        Geo geo = address.getGeo();
        geoService.save(geo);
        return addressDao.save(address);
    }

    @Override
    public Address update(Address address, Long id) {
        Address foundedAddress = findById(id);
        if (foundedAddress == null) return null;
        return addressDao.save(address);
    }

    @Override
    public int delete(Long id) {
        Address foundedAddress = findById(id);
        if (foundedAddress == null) return -1;
        addressDao.deleteById(id);
        return 1;
    }
}
