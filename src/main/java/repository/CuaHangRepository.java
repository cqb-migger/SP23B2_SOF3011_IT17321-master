package repository;



import view_model.QLCuaHang;

import java.util.ArrayList;

public class CuaHangRepository {
    private ArrayList<QLCuaHang> list = new ArrayList<>();

    public CuaHangRepository() {
        list = new ArrayList<>();

    }
    public void insert (QLCuaHang qlch){
        list.add(qlch);
    }
    public void update(QLCuaHang qlch){
        for (int i = 0; i < list.size() ; i++) {
            QLCuaHang vm = list.get(i);
            if(vm.getMa().equals(qlch.getMa())){
                list.set(i, qlch);
            }
        }
    }
    public void delete(QLCuaHang qlch){
        for (int i = 0; i < list.size() ; i++) {
            QLCuaHang vm = list.get(i);
            if(vm.getMa().equals(qlch.getMa())){
                list.remove(i);
            }
        }
    }

    public ArrayList<QLCuaHang> findAll(){
        return list;
    }
    public QLCuaHang findByMa(String ma){
        for (int i = 0; i < list.size() ; i++) {
            QLCuaHang vm = list.get(i);
            if(vm.getMa().equals(ma)){
                return list.get(i);
            }
        }
        return null;
    }
}
