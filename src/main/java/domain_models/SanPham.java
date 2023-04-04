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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class SanPham implements Serializable {
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

    @OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
    private List<ChiTietSanPham> listChiTietSanPham;
}
