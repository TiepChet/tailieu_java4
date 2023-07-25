package com.example.DemoJoinTable.crud.repository;

import com.example.DemoJoinTable.crud.entity.Product;
import com.example.DemoJoinTable.crud.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public List<Product> getAll() {
        List<Product> listProduct = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Product ", Product.class);
            listProduct = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listProduct;
    }

    public Product getOne(Long id) {
        Product product =null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Product WHERE id=:id ", Product.class);
            query.setParameter("id",id);
            product = (Product) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return product;
    }

    public static void main(String[] args) {
        List<Product> getAll = new ProductRepository().getAll();
        System.out.println(getAll);
    }
}
