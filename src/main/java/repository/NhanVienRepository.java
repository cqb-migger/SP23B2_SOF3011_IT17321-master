package repository;




import domain_models.NhanVien;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLMauSac;
import view_model.QLNhanVien;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NhanVienRepository {
    private ArrayList<QLNhanVien> list;
    private Session hSession;

    public NhanVienRepository()
    {
        this.list = new ArrayList<>();
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(NhanVien nv)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(NhanVien nv)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.save(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(NhanVien nv)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public NhanVien  findById(String id)
    {
        return this.hSession.find(NhanVien.class, id);
    }

    public List<NhanVien> findAll()
    {
        Session session = HibernateUtil.getFACTORY().openSession();
        String hql = "SELECT obj FROM NhanVien obj";
        TypedQuery<NhanVien> query = session.createQuery(hql, NhanVien.class);
        return query.getResultList();
    }

    public NhanVien findByMa(String ma)
    {
        String hql = "SELECT obj FROM NhanVien obj WHERE obj.ma = ?1";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql, NhanVien.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
    public NhanVien login(String ma, String matKhau)
    {
        String hql = "SELECT nv FROM NhanVien nv WHERE nv.ma = ?1 AND nv.matKhau = ?2";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql, NhanVien.class);
        query.setParameter(1, ma);
        query.setParameter(2, matKhau);

        try {
            NhanVien nv = query.getSingleResult();
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
    public UUID findIdChucVuByMa(String ma) {
        Query query = hSession.createQuery("select nv.chucVu.id from  NhanVien nv where ma=:ma");
        query.setParameter("ma", ma);
        UUID idChucVu = (UUID) query.getSingleResult();
        return idChucVu;
    }
    public UUID findIdCuaHangByMa(String ma) {
        Query query = hSession.createQuery("select nv.cuaHang.id from  NhanVien nv where ma=:ma");
        query.setParameter("ma", ma);
        UUID idCuaHang = (UUID) query.getSingleResult();
        return idCuaHang;
    }
}
