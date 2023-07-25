package com.example.DemoJoinTable.crud.repository;

import com.example.DemoJoinTable.crud.entity.Category;
import com.example.DemoJoinTable.crud.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {



    public List<Category> getAll() {
        List<Category> listCategory = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Category", Category.class);
            listCategory = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listCategory;
    }

    public Category getOne(Long id) {
        Category category = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Category WHERE id=:id", Category.class);
            query.setParameter("id", id);
            category = (Category) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return category;
    }


    public Boolean add(Category category) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(category);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }


    public Boolean update(Category category) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(category);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }


    public Boolean delete(Category category) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(category);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }


    public static void main(String[] args) {
//        List<Category> getAll = new CategoryRepository().getAll();
//        System.out.println(getAll);
//
//        Category getOne = new CategoryRepository().getOne("C01");
//        System.out.println(getOne);

        Category cg = Category.builder()
                .categoryCode("CD57")
                .categoryName("Cate3")
                .build();
        Boolean add = new CategoryRepository().delete(cg);
        System.out.println(add);
    }

}
