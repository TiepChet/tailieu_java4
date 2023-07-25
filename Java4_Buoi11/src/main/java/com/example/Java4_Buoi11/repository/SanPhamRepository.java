package com.example.Java4_Buoi11.repository;

import com.example.Java4_Buoi11.entity.SanPham;
import com.example.Java4_Buoi11.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SanPhamRepository {

    public List<SanPham> getAll() {
        List<SanPham> listSanPham = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SanPham ", SanPham.class);
            listSanPham = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listSanPham;
    }

    public SanPham getOne(Long id) {
        SanPham sanPham = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SanPham WHERE id=:id", SanPham.class);
            query.setParameter("id", id);
            sanPham = (SanPham) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sanPham;
    }

    public boolean add(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }


    public boolean update(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public boolean delete(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public List<SanPham> search(String ten) {
        List<SanPham> listSanPham = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SanPham WHERE ten=:ten", SanPham.class);
            query.setParameter("ten", ten);
            listSanPham = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listSanPham;
    }



}
