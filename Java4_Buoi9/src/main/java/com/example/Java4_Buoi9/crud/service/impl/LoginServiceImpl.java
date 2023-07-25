package com.example.Java4_Buoi9.crud.service.impl;

import com.example.Java4_Buoi9.crud.entity.Login;
import com.example.Java4_Buoi9.crud.repository.LoginRepository;
import com.example.Java4_Buoi9.crud.service.LoginService;

public class LoginServiceImpl implements LoginService {
    private LoginRepository loginRepository = new LoginRepository();

    @Override
    public Login getOne(String username, String password) {
        return loginRepository.getOne(username, password);
    }
}
