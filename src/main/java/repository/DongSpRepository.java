package repository;



import domain_models.DongSp;
import domain_models.SanPham;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import view_model.QLDongSp;

import java.util.ArrayList;
import java.util.List;

public class DongSpRepository {
    private ArrayList<QLDongSp> list;
    private Session hSession;

    public DongSpRepository()
    {
        this.list = new ArrayList<>();
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(DongSp dsp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(dsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(DongSp dsp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(dsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(DongSp dsp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(dsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

//    public DongSp findById(String id)
//    {
//        return this.hSession.find(DongSp.class, id);
//    }

    public List<DongSp> findAll()
    {
        String hql = "SELECT obj FROM DongSp obj";
        TypedQuery<DongSp> query = this.hSession.createQuery(hql, DongSp.class);
        return query.getResultList();
    }

    public DongSp findByMa(String ma)
    {
        String hql = "SELECT obj FROM DongSp obj WHERE obj.ma = ?1";
        TypedQuery<DongSp> query = this.hSession.createQuery(hql, DongSp.class);
        query.setParameter(1, ma);
        try {
            DongSp dsp = query.getSingleResult();
            return dsp;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
}
