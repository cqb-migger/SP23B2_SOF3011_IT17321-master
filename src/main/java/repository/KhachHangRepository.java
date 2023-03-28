package repository;

import view_model.QLKhachHang;

import java.util.ArrayList;

public class KhachHangRepository {
    private ArrayList<QLKhachHang> list = new ArrayList<>();

    public KhachHangRepository() {
        list = new ArrayList<>();

    }
    public void insert (QLKhachHang qlkh){
        list.add(qlkh);
    }

    public void update(QLKhachHang qlkh){
        for (int i = 0; i < list.size() ; i++) {
            QLKhachHang vm = list.get(i);
            if(vm.getMa().equals(qlkh.getMa())){
                list.set(i, qlkh);
            }
        }
    }
    public void delete(QLKhachHang qlkh){
        for (int i = 0; i < list.size(); i++) {
            QLKhachHang vm = list.get(i);
            if(vm.getMa().equals(qlkh.getMa())){
                list.remove(i);
            }
        }
    }

    public ArrayList<QLKhachHang> findAll(){
        return list;
    }
    public QLKhachHang findByMa(String ma){
        for (int i = 0; i < list.size() ; i++) {
            QLKhachHang vm = list.get(i);
            if(vm.getMa().equals(ma)){
                return list.get(i);
            }
        }
        return null;
    }


}
