package com.example.springboothttpclient.services.impl;

import com.example.springboothttpclient.beans.Address;
import com.example.springboothttpclient.beans.Company;
import com.example.springboothttpclient.beans.User;
import com.example.springboothttpclient.dao.UserDao;
import com.example.springboothttpclient.services.facade.AddressService;
import com.example.springboothttpclient.services.facade.CompanyService;
import com.example.springboothttpclient.services.facade.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private AddressService addressService;
    private CompanyService companyService;

    public UserServiceImpl(UserDao userDao, AddressService addressService, CompanyService companyService) {
        this.userDao = userDao;
        this.addressService = addressService;
        this.companyService = companyService;
    }


    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        if (user == null) return null;
        Address address = user.getAddress();
        Company company = user.getCompany();
        addressService.save(address);
        companyService.save(company);
        return userDao.save(user);
    }

    @Override
    public User update(User user, Long id) {
        User foundedUser = findById(id);
        if (foundedUser == null) return null;
        return userDao.save(user);
    }

    @Override
    public int delete(Long id) {
        User foundedUser = findById(id);
        if (foundedUser == null) return -1;
        userDao.deleteById(id);
        return 1;
    }
}
