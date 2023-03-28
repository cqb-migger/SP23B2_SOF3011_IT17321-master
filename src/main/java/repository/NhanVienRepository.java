package repository;



import view_model.QLNhanVien;

import java.util.ArrayList;

public class NhanVienRepository {
    private ArrayList<QLNhanVien> list = new ArrayList<>();

    public NhanVienRepository() {
        list = new ArrayList<>();

    }
    public void insert (QLNhanVien qlnv){
        list.add(qlnv);
    }
    public void update(QLNhanVien qlnv){
        for (int i = 0; i < list.size() ; i++) {
            QLNhanVien vm = list.get(i);
            if(vm.getMa().equals(qlnv.getMa())){
                list.set(i, qlnv);
            }
        }
    }
    public void delete(QLNhanVien qlnv){
        for (int i = 0; i < list.size() ; i++) {
            QLNhanVien vm = list.get(i);
            if(vm.getMa().equals(qlnv.getMa())){
                list.remove(i);
            }
        }
    }

    public ArrayList<QLNhanVien> findAll(){
        return list;
    }
    public QLNhanVien findByMa(String ma){
        for (int i = 0; i < list.size() ; i++) {
            QLNhanVien vm = list.get(i);
            if(vm.getMa().equals(ma)){
                return list.get(i);
            }
        }
        return null;
    }
}
