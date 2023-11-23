package com.example.springboothttpclient.services.impl;

import com.example.springboothttpclient.beans.Geo;
import com.example.springboothttpclient.dao.GeoDao;
import com.example.springboothttpclient.services.facade.GeoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeoServiceImpl implements GeoService {

    private GeoDao geoDao;

    public GeoServiceImpl(GeoDao geoDao) {
        this.geoDao = geoDao;
    }


    @Override
    public List<Geo> findAll() {
        return geoDao.findAll();
    }

    @Override
    public Geo findById(Long id) {
        return geoDao.findById(id).orElse(null);
    }

    @Override
    public Geo save(Geo geo) {
        return geoDao.save(geo);
    }

    @Override
    public Geo update(Geo geo, Long id) {
        Geo foundedGeo = findById(id);
        if (foundedGeo == null) return null;
        return geoDao.save(geo);
    }

    @Override
    public int delete(Long id) {
        Geo foundedGeo = findById(id);
        if (foundedGeo == null) return -1;
        geoDao.deleteById(id);
        return 1;
    }
}
