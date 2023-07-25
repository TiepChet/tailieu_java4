package com.example.Java4_Buoi9.crud.repository;

import com.example.Java4_Buoi9.crud.entity.GiangVien;
import com.example.Java4_Buoi9.crud.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class GiangVienRepository {

    public List<GiangVien> getAll() {
        List<GiangVien> listGiangVien = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM GiangVien ", GiangVien.class);
            listGiangVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listGiangVien;
    }

    public GiangVien getOne(Long id) {
        GiangVien giangVien = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM GiangVien WHERE id =:id", GiangVien.class);
            query.setParameter("id", id);
            giangVien = (GiangVien) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return giangVien;
    }

    public List<GiangVien> search(String ten) {
        List<GiangVien> listGiangVien = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM GiangVien where ten like :ten", GiangVien.class);
            query.setParameter("ten", "%" + ten + "%");
            listGiangVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listGiangVien;
    }


    public List<GiangVien> giangVienNu() {
        List<GiangVien> listGiangVien = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM GiangVien where  gioi_tinh=0", GiangVien.class);
            listGiangVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listGiangVien;
    }

    public List<GiangVien> sortTuoi() {
        List<GiangVien> listGiangVien = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM GiangVien order by tuoi", GiangVien.class);
            listGiangVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listGiangVien;
    }

    public Boolean add(GiangVien giangVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(giangVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean delete(GiangVien giangVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(giangVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean update(GiangVien giangVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(giangVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

//    public static void main(String[] args) {
//        GiangVien gv = GiangVien.builder()
//                .id(Long.valueOf(2))
//                .ma("ma")
//                .ten("hi")
//                .tuoi(Long.valueOf(34))
//                .gioiTinh(Boolean.valueOf(true))
//                .diaChi("thai binh")
//                .build();
//
//        Boolean add = new GiangVienRepository().update(gv);
//        System.out.println(add);
//    }
}
