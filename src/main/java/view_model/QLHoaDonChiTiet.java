package view_model;

public class QLHoaDonChiTiet {
    private String ma;
    private String so_luong;
    private String don_gia;

    public QLHoaDonChiTiet() {
    }

    public QLHoaDonChiTiet(String ma, String so_luong, String don_gia) {
        this.ma = ma;
        this.so_luong = so_luong;
        this.don_gia = don_gia;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(String so_luong) {
        this.so_luong = so_luong;
    }

    public String getDon_gia() {
        return don_gia;
    }

    public void setDon_gia(String don_gia) {
        this.don_gia = don_gia;
    }
}
