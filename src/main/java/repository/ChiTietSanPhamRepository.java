package repository;



import view_model.QLChiTietSanPham;

import java.util.ArrayList;

public class ChiTietSanPhamRepository {
    private ArrayList<QLChiTietSanPham> list = new ArrayList<>();

    public ChiTietSanPhamRepository() {
        list = new ArrayList<>();

    }
    public void insert (QLChiTietSanPham qlctsp){
        list.add(qlctsp);
    }
    public void update(QLChiTietSanPham qlctsp){
        for (int i = 0; i < list.size() ; i++) {
            QLChiTietSanPham vm = list.get(i);
            if(vm.getMa().equals(qlctsp.getMa())){
                list.set(i, qlctsp);
            }
        }
    }
    public void delete(QLChiTietSanPham qlctsp){
        for (int i = 0; i < list.size() ; i++) {
            QLChiTietSanPham vm = list.get(i);
            if(vm.getMa().equals(qlctsp.getMa())){
                list.remove(i);
            }
        }
    }

    public ArrayList<QLChiTietSanPham> findAll(){
        return list;
    }
    public QLChiTietSanPham findByMa(String ma){
        for (int i = 0; i < list.size() ; i++) {
            QLChiTietSanPham vm = list.get(i);
            if(vm.getMa().equals(ma)){
                return list.get(i);
            }
        }
        return null;
    }
}
