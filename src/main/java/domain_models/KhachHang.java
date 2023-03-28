package domain_models;

import jakarta.persistence.*;

import java.util.Date;


@Entity


@Table(name="KhachHang")
public class KhachHang {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;
    @Column(name="Ma")
    private String Ma;
    @Column(name="Ho")
    private String Ho;
    @Column(name="TenDem")
    private String TenDem;
    @Column(name="Ten")
    private String Ten;
    @Column(name="NgaySinh")
    private Date NgaySinh;
    @Column(name="Sdt")
    private String Sdt;
    @Column(name="DiaChi")
    private String DiaChi;
    @Column(name="MatKhau")
    private String MatKhau;
    @Column(name="QuocGia")
    private String QuocGia;
    @Column(name="ThanhPho")
    private String ThanhPho;

    public KhachHang() {
    }

    public KhachHang(String id, String ma, String ho, String tenDem, String ten, Date ngaySinh, String sdt, String diaChi, String matKhau, String quocGia, String thanhPho) {
        Id = id;
        Ma = ma;
        Ho = ho;
        TenDem = tenDem;
        Ten = ten;
        NgaySinh = ngaySinh;
        Sdt = sdt;
        DiaChi = diaChi;
        MatKhau = matKhau;
        QuocGia = quocGia;
        ThanhPho = thanhPho;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String ma) {
        Ma = ma;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String ho) {
        Ho = ho;
    }

    public String getTenDem() {
        return TenDem;
    }

    public void setTenDem(String tenDem) {
        TenDem = tenDem;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getQuocGia() {
        return QuocGia;
    }

    public void setQuocGia(String quocGia) {
        QuocGia = quocGia;
    }

    public String getThanhPho() {
        return ThanhPho;
    }

    public void setThanhPho(String thanhPho) {
        ThanhPho = thanhPho;
    }
}
