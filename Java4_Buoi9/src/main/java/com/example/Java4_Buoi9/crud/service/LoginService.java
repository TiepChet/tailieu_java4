package com.example.Java4_Buoi9.crud.service;

import com.example.Java4_Buoi9.crud.entity.GiangVien;
import com.example.Java4_Buoi9.crud.entity.Login;

public interface LoginService {
    Login getOne(String username, String password);
}
