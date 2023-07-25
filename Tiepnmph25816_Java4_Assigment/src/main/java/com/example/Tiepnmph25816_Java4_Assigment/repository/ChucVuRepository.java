package com.example.Tiepnmph25816_Java4_Assigment.repository;

import com.example.Tiepnmph25816_Java4_Assigment.entity.ChucVu;
import com.example.Tiepnmph25816_Java4_Assigment.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChucVuRepository {

    public List<ChucVu> getAll() {
        List<ChucVu> listChucVu = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChucVu ", ChucVu.class);
            listChucVu = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listChucVu;
    }


    public ChucVu getOne(UUID id) {
        ChucVu chucVu = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChucVu WHERE Id=:id", ChucVu.class);
            query.setParameter("id", id);
            chucVu = (ChucVu) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chucVu;
    }

    public Boolean add(ChucVu chucVu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean update(ChucVu chucVu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }


    public Boolean delete(ChucVu chucVu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

}
