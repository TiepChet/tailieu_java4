package com.example.Tiepnmph25816_Java4_Assigment.repository;

import com.example.Tiepnmph25816_Java4_Assigment.entity.SanPham;
import com.example.Tiepnmph25816_Java4_Assigment.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SanPhamRepository {


    public List<SanPham> getAll() {
        List<SanPham> listSanPham = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SanPham ", SanPham.class);
            listSanPham = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }

    public SanPham getOne(UUID id) {
        SanPham sanPham = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SanPham WHERE id=:id ", SanPham.class);
            query.setParameter("id", id);
            sanPham= (SanPham) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }

    public Boolean add(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
