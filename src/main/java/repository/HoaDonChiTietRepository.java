package repository;



import domain_models.HoaDonChiTiet;
import domain_models.SanPham;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLHoaDonChiTiet;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HoaDonChiTietRepository {
    private ArrayList<QLHoaDonChiTiet> list;
    private Session hSession;

    public HoaDonChiTietRepository()
    {
        this.list = new ArrayList<>();
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(HoaDonChiTiet hdct)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(hdct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(HoaDonChiTiet hdct)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.save(hdct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(HoaDonChiTiet hdct)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(hdct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

//    public HoaDonChiTiet findById(String id)
//    {
//        return this.hSession.find(HoaDonChiTiet.class, id);
//    }

    public List<HoaDonChiTiet> findAll()
    {
        Session session = HibernateUtil.getFACTORY().openSession();
        String hql = "SELECT obj FROM HoaDonChiTiet obj";
        TypedQuery<HoaDonChiTiet> query = session.createQuery(hql, HoaDonChiTiet.class);
        return query.getResultList();
    }

    public HoaDonChiTiet findByMa(UUID id)
    {
        String hql = "SELECT c FROM HoaDonChiTiet c JOIN c.hoaDon h WHERE h.id = ?1";
        TypedQuery<HoaDonChiTiet> query = this.hSession.createQuery(hql, HoaDonChiTiet.class);
        query.setParameter(1, id);
        try {
            HoaDonChiTiet hdct = query.getSingleResult();
            return hdct;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }catch (NonUniqueResultException e) {
            e.printStackTrace();
            return null;
        }

    }

}
