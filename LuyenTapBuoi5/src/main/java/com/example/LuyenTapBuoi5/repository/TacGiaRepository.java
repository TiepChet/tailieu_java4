package com.example.LuyenTapBuoi5.repository;

import com.example.LuyenTapBuoi5.entity.TacGia;
import com.example.LuyenTapBuoi5.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TacGiaRepository {

    public List<TacGia> getAll() {
        List<TacGia> listTacGia = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM TacGia ", TacGia.class);
            listTacGia = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTacGia;
    }


    public TacGia getOne(UUID ma) {
        TacGia tacGia = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM TacGia  WHERE ma=:ma", TacGia.class);
            query.setParameter("ma", ma);
            tacGia = (TacGia) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tacGia;
    }

    public Boolean add(TacGia tacGia) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(tacGia);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(TacGia tacGia) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(tacGia);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public Boolean delete(TacGia tacGia) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(tacGia);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public List<TacGia> sortTuoi() {
        List<TacGia> listTacGia = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM TacGia order by tuoi desc", TacGia.class);
            listTacGia = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTacGia;
    }

    public List<TacGia> sortTen() {
        List<TacGia> listTacGia = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM TacGia order by ten desc", TacGia.class);
            listTacGia = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTacGia;
    }


    public List<TacGia> searchTen(String ten) {
        List<TacGia> listTacGia = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM TacGia WHERE ten like :ten", TacGia.class);
            query.setParameter("ten", "%" + ten + "%");
            listTacGia = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTacGia;
    }


}
