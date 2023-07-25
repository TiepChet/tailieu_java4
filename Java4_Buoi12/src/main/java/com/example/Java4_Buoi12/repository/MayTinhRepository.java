package com.example.Java4_Buoi12.repository;

import com.example.Java4_Buoi12.entity.MayTinh;
import com.example.Java4_Buoi12.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MayTinhRepository {

    public List<MayTinh> getAll() {
        List<MayTinh> listMayTinh = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MayTinh ", MayTinh.class);
            listMayTinh = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMayTinh;
    }

    public MayTinh getOne(UUID ma) {
        MayTinh mayTinh = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MayTinh WHERE ma=:ma", MayTinh.class);
            query.setParameter("ma", ma);
            mayTinh = (MayTinh) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mayTinh;
    }
    public List<MayTinh> sortGia() {
        List<MayTinh> listMayTinh = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MayTinh order by gia desc ", MayTinh.class);
            listMayTinh = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMayTinh;
    }

    public List<MayTinh> sortBoNho() {
        List<MayTinh> listMayTinh = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MayTinh order by bo_nho desc ", MayTinh.class);
            listMayTinh = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMayTinh;
    }

    public Boolean add(MayTinh mayTinh){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.persist(mayTinh);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(MayTinh mayTinh){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.merge(mayTinh);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(MayTinh mayTinh){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(mayTinh);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
