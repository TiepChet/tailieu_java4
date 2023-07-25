package com.example.LuyenTap6.repository;

import com.example.LuyenTap6.entity.SinhVien;
import com.example.LuyenTap6.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SinhVienRepository {

    public List<SinhVien> getAll() {
        List<SinhVien> listSinhVien = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SinhVien ", SinhVien.class);
            listSinhVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSinhVien;
    }

    public SinhVien getOne(UUID ma) {
        SinhVien sinhVien = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SinhVien WHERE ma=:ma", SinhVien.class);
            query.setParameter("ma", ma);
            sinhVien = (SinhVien) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sinhVien;
    }

    public Boolean add(SinhVien sinhVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(sinhVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(SinhVien sinhVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(sinhVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(SinhVien sinhVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sinhVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<SinhVien> sinhVienNu() {
        List<SinhVien> listSinhVien = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SinhVien WHERE gioi_tinh=0 ", SinhVien.class);
            listSinhVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSinhVien;
    }

    public List<SinhVien> searchTen(String ten) {
        List<SinhVien> listSinhVien = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SinhVien WHERE ten like :ten ", SinhVien.class);
            query.setParameter("ten", "%" + ten + "%");
            listSinhVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSinhVien;
    }

    public List<SinhVien> sortTuoi() {
        List<SinhVien> listSinhVien = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SinhVien order by tuoi desc ", SinhVien.class);
            listSinhVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSinhVien;
    }


    public List<SinhVien> sortTen() {
        List<SinhVien> listSinhVien = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SinhVien order by ten desc ", SinhVien.class);
            listSinhVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSinhVien;
    }

    public static void main(String[] args) {
        SinhVien sv = SinhVien.builder()
                .ten("a")
                .tuoi(Integer.valueOf(20))
                .gioiTinh(Boolean.valueOf(true))
                .diaChi("a")
                .kyHoc(Integer.valueOf(1))
                .build();
        boolean add = new SinhVienRepository().add(sv);
        System.out.println(add);
    }

}
