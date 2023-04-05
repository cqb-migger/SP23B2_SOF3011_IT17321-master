package domain_models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity

@Table(name = "NhanVien")
public class NhanVien implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="Id")
    private UUID id;
    @Column(name="Ma")
    private String ma;
    @Column(name="Ten")
    private String ten;
    @Column(name="TenDem")
    private String tenDem;
    @Column(name="Ho")
    private String ho;
    @Column(name="GioiTinh")
    private String gioiTinh;
    @Column(name="NgaySinh")
    private Date ngaySinh;
    @Column(name="DiaChi")
    private String diaChi;
    @Column(name="Sdt")
    private String sdt;
    @Column(name="MatKhau")
    private String matKhau;
    @Column(name="TrangThai")
    private int trangThai;

    @ManyToOne
    @JoinColumn(name="IdCH")
    private CuaHang cuaHang;
    @ManyToOne
    @JoinColumn(name="IdCV")
    private ChucVu chucVu;

    @ManyToOne
    @JoinColumn(name="IdGuiBC")
    private NhanVien nhanVien;

    @OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
    private List<NhanVien> listNhanVien;

    @OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
    private List<HoaDon> listHoaDon;


}
