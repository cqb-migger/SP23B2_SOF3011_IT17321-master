package repository;




import domain_models.HoaDon;


import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLHoaDon;

import java.util.ArrayList;
import java.util.List;

public class HoaDonRepository {
    private ArrayList<QLHoaDon> list;
    private Session hSession;

    public HoaDonRepository()
    {
        this.list = new ArrayList<>();
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(HoaDon hd)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(hd);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(HoaDon hd)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.save(hd);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(HoaDon hd)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(hd);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

//    public HoaDon findById(String id)
//    {
//        return this.hSession.find(HoaDon.class, id);
//    }

    public List<HoaDon> findAll()
    {
        Session session = HibernateUtil.getFACTORY().openSession();
        String hql = "SELECT obj FROM HoaDon obj";
        TypedQuery<HoaDon> query = session.createQuery(hql, HoaDon.class);
        return query.getResultList();
    }

    public HoaDon findByMa(String ma)
    {
        String hql = "SELECT obj FROM HoaDon obj WHERE obj.ma = ?1";
        TypedQuery<HoaDon> query = this.hSession.createQuery(hql, HoaDon.class);
        query.setParameter(1, ma);
        try {
            HoaDon hd = query.getSingleResult();
            return hd;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
}
