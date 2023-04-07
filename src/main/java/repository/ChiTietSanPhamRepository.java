package repository;




import domain_models.ChiTietSanPham;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLChiTietSanPham;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChiTietSanPhamRepository {
    private ArrayList<QLChiTietSanPham> list;
    private Session hSession;

    public ChiTietSanPhamRepository()
    {
        this.list = new ArrayList<>();
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(ChiTietSanPham ctsp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(ChiTietSanPham ctsp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.save(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(ChiTietSanPham ctsp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(ctsp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

//    public ChiTietSanPham findById(String id)
//    {
//        return this.hSession.find(ChiTietSanPham.class, id);
//    }

    public List<ChiTietSanPham> findAll()
    {
        Session session = HibernateUtil.getFACTORY().openSession();
        String hql = "SELECT obj FROM ChiTietSanPham obj";
        TypedQuery<ChiTietSanPham> query = session.createQuery(hql, ChiTietSanPham.class);
        return query.getResultList();
    }

    public ChiTietSanPham findByMa(UUID id)
    {
        String hql = "SELECT c FROM ChiTietSanPham c WHERE c.id = ?1";
        TypedQuery<ChiTietSanPham> query = this.hSession.createQuery(hql, ChiTietSanPham.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }
//        public UUID findIdSanPhamById(UUID id) {
//        Query query = hSession.createQuery("select ctsp.sanPham.id from ChiTietSanPham ctsp where id=:id");
//        query.setParameter("id", id);
//        UUID idSanPham = (UUID) query.getSingleResult();
//        return idSanPham;
//    }
//    public UUID findIdNSXById(UUID id) {
//        Query query = hSession.createQuery("select ctsp.nsx.id from ChiTietSanPham ctsp where id=:id");
//        query.setParameter("id", id);
//        UUID idNSX = (UUID) query.getSingleResult();
//        return idNSX;
//    }
//    public UUID findIdMauSacById(UUID id) {
//        Query query = hSession.createQuery("select ctsp.mauSac.id from ChiTietSanPham ctsp where id=:id");
//        query.setParameter("id", id);
//        UUID idMauSac = (UUID) query.getSingleResult();
//        return idMauSac;
//    }
//    public UUID findIdDongSpById(UUID id) {
//        Query query = hSession.createQuery("select ctsp.dongSp.id from ChiTietSanPham ctsp where id=:id");
//        query.setParameter("id", id);
//        UUID idDongSP = (UUID) query.getSingleResult();
//        return idDongSP;
//    }
}
