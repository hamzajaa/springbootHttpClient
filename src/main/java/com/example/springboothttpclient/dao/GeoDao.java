package com.example.springboothttpclient.dao;

import com.example.springboothttpclient.beans.Geo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeoDao extends JpaRepository<Geo, Long> {
}
