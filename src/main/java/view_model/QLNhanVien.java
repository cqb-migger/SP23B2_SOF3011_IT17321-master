package view_model;

public class QLNhanVien {
    private String ma;
    private String ten;
    private String ten_dem;
    private String ho;
    private Boolean gioi_tinh;
    private String ngay_sinh;
    private String dia_chi;
    private String sdt;
    private Boolean trang_thai;

    public QLNhanVien() {
    }

    public QLNhanVien(String ma, String ten, String ten_dem, String ho, Boolean gioi_tinh, String ngay_sinh, String dia_chi, String sdt, Boolean trang_thai) {
        this.ma = ma;
        this.ten = ten;
        this.ten_dem = ten_dem;
        this.ho = ho;
        this.gioi_tinh = gioi_tinh;
        this.ngay_sinh = ngay_sinh;
        this.dia_chi = dia_chi;
        this.sdt = sdt;
        this.trang_thai = trang_thai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTen_dem() {
        return ten_dem;
    }

    public void setTen_dem(String ten_dem) {
        this.ten_dem = ten_dem;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public Boolean getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(Boolean gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Boolean getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(Boolean trang_thai) {
        this.trang_thai = trang_thai;
    }
}
