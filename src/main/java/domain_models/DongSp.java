package domain_models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name="DongSP")
public class DongSp implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "Id")
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;

    @OneToMany(mappedBy = "dongSp", fetch = FetchType.LAZY)
    private List<ChiTietSanPham> listChiTietSanPham;

}
