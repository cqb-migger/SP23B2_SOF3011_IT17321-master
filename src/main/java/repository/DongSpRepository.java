package repository;


import view_model.QLDongSp;

import java.util.ArrayList;

public class DongSpRepository {
    private ArrayList<QLDongSp> list = new ArrayList<>();

    public DongSpRepository() {
        list = new ArrayList<>();

    }
    public void insert (QLDongSp qldsp){
        list.add(qldsp);
    }
    public void update(QLDongSp qldsp){
        for (int i = 0; i < list.size() ; i++) {
            QLDongSp vm = list.get(i);
            if(vm.getMa().equals(qldsp.getMa())){
                list.set(i, qldsp);
            }
        }
    }
    public void delete(QLDongSp qldsp){
        for (int i = 0; i < list.size() ; i++) {
            QLDongSp vm = list.get(i);
            if(vm.getMa().equals(qldsp.getMa())){
                list.remove(i);
            }
        }
    }

    public ArrayList<QLDongSp> findAll(){
        return list;
    }
    public QLDongSp findByMa(String ma){
        for (int i = 0; i < list.size() ; i++) {
            QLDongSp vm = list.get(i);
            if(vm.getMa().equals(ma)){
                return list.get(i);
            }
        }
        return null;
    }
}
