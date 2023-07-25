package com.example.LuyenTapJava4.repository;

import com.example.LuyenTapJava4.entity.ThucVat;
import com.example.LuyenTapJava4.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ThucVatRepository {

    public List<ThucVat> getAll() {
        List<ThucVat> listThucVat = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ThucVat", ThucVat.class);
            listThucVat = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listThucVat;
    }

    public ThucVat getOne(UUID ma) {
        ThucVat thucVat = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ThucVat WHERE ma=:ma", ThucVat.class);
            query.setParameter("ma", ma);
            thucVat = (ThucVat) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thucVat;
    }

    public Boolean add(ThucVat thucVat) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(thucVat);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(ThucVat thucVat) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(thucVat);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(ThucVat thucVat) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(thucVat);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ThucVat> search(String ten) {
        List<ThucVat> listThucVat = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ThucVat WHERE ten like :ten", ThucVat.class);
            query.setParameter("ten", "%" + ten + "%");
            listThucVat = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listThucVat;
    }

    public List<ThucVat> sortTuoi() {
        List<ThucVat> listThucVat = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ThucVat order by tuoi desc ", ThucVat.class);
            listThucVat = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listThucVat;
    }


    public List<ThucVat> sortTen() {
        List<ThucVat> listThucVat = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ThucVat order by ten desc ", ThucVat.class);
            listThucVat = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listThucVat;
    }


}
