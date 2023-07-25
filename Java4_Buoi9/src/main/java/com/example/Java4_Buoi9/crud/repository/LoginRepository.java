package com.example.Java4_Buoi9.crud.repository;

import com.example.Java4_Buoi9.crud.entity.Login;
import com.example.Java4_Buoi9.crud.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

public class LoginRepository {

    public Login getOne(String username, String password) {
        Login login = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Login where username =:username and password =:password ", Login.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            login = (Login) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return login;
    }

    public static void main(String[] args) {
        Login login = new LoginRepository().getOne("tiepnmph25816", "12345");
        System.out.println(login);
    }
}
