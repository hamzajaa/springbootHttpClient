package com.example.springboothttpclient.services.facade;

import com.example.springboothttpclient.beans.Geo;

import java.util.List;

public interface GeoService {

    List<Geo> findAll();
    Geo findById(Long id);

    Geo save(Geo geo);

    Geo update(Geo geo, Long id);

    int delete(Long id);

}
