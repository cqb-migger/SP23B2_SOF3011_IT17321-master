package domain_models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name="KhachHang")
public class KhachHang implements Serializable {
    @Id
//    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
//    @GeneratedValue(generator = "generator")
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name="Ma")
    private String ma;
    @Column(name="Ten")
    private String ten;
    @Column(name="TenDem")
    private String tenDem;
    @Column(name="Ho")
    private String ho;
    @Column(name="NgaySinh")
    private Date ngaySinh;
    @Column(name="Sdt")
    private String sdt;
    @Column(name="DiaChi")
    private String diaChi;
    @Column(name="ThanhPho")
    private String thanhPho;
    @Column(name="QuocGia")
    private String quocGia;
    @Column(name="MatKhau")
    private String matKhau;

    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    private List<HoaDon> listHoaDon;



}
