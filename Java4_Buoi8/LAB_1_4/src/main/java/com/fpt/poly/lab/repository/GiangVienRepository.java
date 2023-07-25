package com.fpt.poly.lab.repository;

import com.fpt.poly.lab.entity.GiangVien;
import com.fpt.poly.lab.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class GiangVienRepository {

    public List<GiangVien> getAll() {
        List<GiangVien> listGiangVien = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM GiangVien", GiangVien.class);
            listGiangVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listGiangVien;
    }

    public GiangVien getOne(String ma) {
        GiangVien giangVien = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM GiangVien WHERE mssv=:ma", GiangVien.class);
            query.setParameter("ma", ma);
            giangVien = (GiangVien) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return giangVien;
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

    public List<GiangVien> searchTen(String ten) {
        List<GiangVien> listGiangVien = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM GiangVien  WHERE ten =:ten", GiangVien.class);
            query.setParameter("ten", ten);
            listGiangVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listGiangVien;
    }

    public List<GiangVien> searchMinMax(int min, int max) {
        List<GiangVien> listGiangVien = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM GiangVien  WHERE tuoi  BETWEEN :min AND :max", GiangVien.class);
            query.setParameter("min", min);
            query.setParameter("max", max);
            listGiangVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listGiangVien;
    }

    public List<GiangVien> giangVienNu() {
        List<GiangVien> listGiangVien = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM GiangVien  WHERE gioi_tinh=0", GiangVien.class);
            listGiangVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listGiangVien;
    }


    public List<GiangVien> sortTuoi() {
        List<GiangVien> listGiangVien = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM GiangVien order by tuoi desc", GiangVien.class);
            listGiangVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listGiangVien;
    }


    public static void main(String[] args) {



//        List<GiangVien> getAll = new GiangVienRepository().getAll();
//        System.out.println(getAll);

//        GiangVien getOne = new GiangVienRepository().getOne("2");
//        System.out.println(getOne);

//        GiangVien gv = new GiangVien("1","fs",32,true,"ha noi");
//        Boolean add = new GiangVienRepository().add(gv);
//        System.out.println(add);

//        GiangVien gv = new GiangVien("1","fs",32,true,"ha noi");
//        Boolean delete = new GiangVienRepository().delete(gv);
//        System.out.println(delete);

//        GiangVien gv = new GiangVien("2","fs",32,true,"ha noi");
//        Boolean update = new GiangVienRepository().update(gv);
//        System.out.println(update);

//        List<GiangVien> search = new GiangVienRepository().searchTen("a");
//        System.out.println(search);
//
//        List<GiangVien> search = new GiangVienRepository().searchMinMax(1, 100);
//        System.out.println(search);

//        List<GiangVien> giangVienNu = new GiangVienRepository().giangVienNu();
//        System.out.println(giangVienNu);

//        List<GiangVien> sortTuoi = new GiangVienRepository().sortTuoi();
//        System.out.println(sortTuoi);

    }
}
