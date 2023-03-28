package repository;



import view_model.QLHoaDonChiTiet;

import java.util.ArrayList;

public class HoaDonChiTietRepository {
    private ArrayList<QLHoaDonChiTiet> list = new ArrayList<>();

    public HoaDonChiTietRepository() {
        list = new ArrayList<>();

    }
    public void insert (QLHoaDonChiTiet qlhdct){
        list.add(qlhdct);
    }
    public void update(QLHoaDonChiTiet qlhdct){
        for (int i = 0; i < list.size() ; i++) {
            QLHoaDonChiTiet vm = list.get(i);
            if(vm.getMa().equals(qlhdct.getMa())){
                list.set(i, qlhdct);
            }
        }
    }
    public void delete(QLHoaDonChiTiet qlhdct){
        for (int i = 0; i < list.size() ; i++) {
            QLHoaDonChiTiet vm = list.get(i);
            if(vm.getMa().equals(qlhdct.getMa())){
                list.remove(i);
            }
        }
    }

    public ArrayList<QLHoaDonChiTiet> findAll(){
        return list;
    }
    public QLHoaDonChiTiet findByMa(String ma){
        for (int i = 0; i < list.size() ; i++) {
            QLHoaDonChiTiet vm = list.get(i);
            if(vm.getMa().equals(ma)){
                return list.get(i);
            }
        }
        return null;
    }
}
