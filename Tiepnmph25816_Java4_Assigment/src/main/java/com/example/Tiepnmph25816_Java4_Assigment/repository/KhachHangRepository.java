package com.example.Tiepnmph25816_Java4_Assigment.repository;

import com.example.Tiepnmph25816_Java4_Assigment.entity.KhachHang;
import com.example.Tiepnmph25816_Java4_Assigment.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class KhachHangRepository {

    public List<KhachHang> getAll() {
        List<KhachHang> listKhachHang = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM KhachHang ", KhachHang.class);
            listKhachHang = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;
    }

    public KhachHang getOne(UUID id) {
        KhachHang khachHang = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM KhachHang WHERE id=:id ", KhachHang.class);
            query.setParameter("id", id);
            khachHang = (KhachHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return khachHang;
    }


    public Boolean add(KhachHang khachHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public Boolean update(KhachHang khachHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public Boolean delete(KhachHang khachHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
