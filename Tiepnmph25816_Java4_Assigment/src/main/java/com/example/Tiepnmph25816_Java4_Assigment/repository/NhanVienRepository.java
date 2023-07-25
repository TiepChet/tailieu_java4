package com.example.Tiepnmph25816_Java4_Assigment.repository;

import com.example.Tiepnmph25816_Java4_Assigment.entity.NhanVien;
import com.example.Tiepnmph25816_Java4_Assigment.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NhanVienRepository {

    public List<NhanVien> getAll() {
        List<NhanVien> listNhanVien = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NhanVien", NhanVien.class);
            listNhanVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNhanVien;
    }

    public NhanVien getOne(UUID id) {
        NhanVien nhanVien = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NhanVien WHERE id=:id", NhanVien.class);
            query.setParameter("id", id);
            nhanVien = (NhanVien) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVien;
    }


    public Boolean add(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
