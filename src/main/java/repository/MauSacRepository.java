package repository;




import domain_models.MauSac;
import domain_models.SanPham;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import view_model.QLMauSac;

import java.util.ArrayList;
import java.util.List;

public class    MauSacRepository {
    private ArrayList<QLMauSac> list;
    private Session hSession;

    public MauSacRepository()
    {
        this.list = new ArrayList<>();
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(MauSac ms)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(MauSac ms)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(MauSac ms)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public MauSac  findById(String id)
    {
        return this.hSession.find(MauSac.class, id);
    }

    public List<MauSac> findAll()
    {
        String hql = "SELECT obj FROM MauSac obj";
        TypedQuery<MauSac> query = this.hSession.createQuery(hql, MauSac.class);
        return query.getResultList();
    }

    public MauSac findByMa(String ma)
    {
        String hql = "SELECT obj FROM MauSac obj WHERE obj.ma = ?1";
        TypedQuery<MauSac> query = this.hSession.createQuery(hql, MauSac.class);
        query.setParameter(1, ma);
        try {
            MauSac ms = query.getSingleResult();
            return ms;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
}
