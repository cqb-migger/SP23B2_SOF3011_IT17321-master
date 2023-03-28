package repository;



import view_model.QLSanPham;

import java.util.ArrayList;

public class SanPhamRepository {
    private ArrayList<QLSanPham> list = new ArrayList<>();

    public SanPhamRepository() {
        list = new ArrayList<>();

    }
    public void insert (QLSanPham qlsp){
        list.add(qlsp);
    }
    public void update(QLSanPham qlsp){
        for (int i = 0; i < list.size() ; i++) {
            QLSanPham vm = list.get(i);
            if(vm.getMa().equals(qlsp.getMa())){
                list.set(i, qlsp);
            }
        }
    }
    public void delete(QLSanPham qlsp){
        for (int i = 0; i < list.size() ; i++) {
            QLSanPham vm = list.get(i);
            if(vm.getMa().equals(qlsp.getMa())){
                list.remove(i);
            }
        }
    }

    public ArrayList<QLSanPham> findAll(){
        return list;
    }
    public QLSanPham findByMa(String ma){
        for (int i = 0; i < list.size() ; i++) {
            QLSanPham vm = list.get(i);
            if(vm.getMa().equals(ma)){
                return list.get(i);
            }
        }
        return null;
    }
}
