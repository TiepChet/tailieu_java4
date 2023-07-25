package com.example.Tiepnmph25816_Java4_Assigment.repository;

import com.example.Tiepnmph25816_Java4_Assigment.entity.NhaSanXuat;
import com.example.Tiepnmph25816_Java4_Assigment.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NhaSanXuatRepository {


    public List<NhaSanXuat> getAll() {
        List<NhaSanXuat> listNSX = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NhaSanXuat ", NhaSanXuat.class);
            listNSX = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNSX;
    }

    public NhaSanXuat getOne(UUID id) {
        NhaSanXuat nhaSanXuat = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NhaSanXuat WHERE id=:id ", NhaSanXuat.class);
            query.setParameter("id", id);
            nhaSanXuat = (NhaSanXuat) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhaSanXuat;
    }

    public Boolean add(NhaSanXuat nhaSanXuat) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(nhaSanXuat);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(NhaSanXuat nhaSanXuat) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nhaSanXuat);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(NhaSanXuat nhaSanXuat) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nhaSanXuat);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
