package com.example.Tiepnmph25816_Java4_Assigment.repository;

import com.example.Tiepnmph25816_Java4_Assigment.entity.ChiTietSP;
import com.example.Tiepnmph25816_Java4_Assigment.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChiTietSPRepository {

    public List<ChiTietSP> getAll() {
        List<ChiTietSP> listChiTietSP = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSP ", ChiTietSP.class);
            listChiTietSP = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChiTietSP;
    }

    public ChiTietSP getOne(UUID id) {
        ChiTietSP chiTietSP = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSP WHERE id=:id", ChiTietSP.class);
            query.setParameter("id", id);
            chiTietSP = (ChiTietSP) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietSP;
    }

    public boolean add(ChiTietSP ctsp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(ctsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(ChiTietSP ctsp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(ctsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(ChiTietSP ctsp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ctsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
