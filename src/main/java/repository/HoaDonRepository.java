package repository;



import view_model.QLHoaDon;

import java.util.ArrayList;

public class HoaDonRepository {
    private ArrayList<QLHoaDon> list = new ArrayList<>();

    public HoaDonRepository() {
        list = new ArrayList<>();

    }
    public void insert (QLHoaDon qlhd){
        list.add(qlhd);
    }
    public void update(QLHoaDon qlhd){
        for (int i = 0; i < list.size() ; i++) {
            QLHoaDon vm = list.get(i);
            if(vm.getMa().equals(qlhd.getMa())){
                list.set(i, qlhd);
            }
        }
    }
    public void delete(QLHoaDon qlhd){
        for (int i = 0; i < list.size() ; i++) {
            QLHoaDon vm = list.get(i);
            if(vm.getMa().equals(qlhd.getMa())){
                list.remove(i);
            }
        }
    }

    public ArrayList<QLHoaDon> findAll(){
        return list;
    }
    public QLHoaDon findByMa(String ma){
        for (int i = 0; i < list.size() ; i++) {
            QLHoaDon vm = list.get(i);
            if(vm.getMa().equals(ma)){
                return list.get(i);
            }
        }
        return null;
    }
}
