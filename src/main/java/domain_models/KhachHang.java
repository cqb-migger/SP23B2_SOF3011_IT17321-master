package domain_models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;


import java.util.Date;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name="KhachHang")
public class KhachHang {
    @Id
//    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
//    @GeneratedValue(generator = "generator")
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    @Column(name="Ma")
    private String Ma;
    @Column(name="Ten")
    private String Ten;
    @Column(name="TenDem")
    private String TenDem;
    @Column(name="Ho")
    private String Ho;
    @Column(name="NgaySinh")
    private Date NgaySinh;
    @Column(name="Sdt")
    private String Sdt;
    @Column(name="DiaChi")
    private String DiaChi;
    @Column(name="ThanhPho")
    private String ThanhPho;
    @Column(name="QuocGia")
    private String QuocGia;
    @Column(name="MatKhau")
    private String MatKhau;



}
