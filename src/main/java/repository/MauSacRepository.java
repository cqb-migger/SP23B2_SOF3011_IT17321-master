package repository;



import view_model.QLMauSac;

import java.util.ArrayList;

public class MauSacRepository {
    private ArrayList<QLMauSac> list = new ArrayList<>();

    public MauSacRepository() {
        list = new ArrayList<>();

    }
    public void insert (QLMauSac qlms){
        list.add(qlms);
    }
    public void update(QLMauSac qlms){
        for (int i = 0; i < list.size() ; i++) {
            QLMauSac vm = list.get(i);
            if(vm.getMa().equals(qlms.getMa())){
                list.set(i, qlms);
            }
        }
    }
    public void delete(QLMauSac qlms){
        for (int i = 0; i < list.size() ; i++) {
            QLMauSac vm = list.get(i);
            if(vm.getMa().equals(qlms.getMa())){
                list.remove(i);
            }
        }
    }

    public ArrayList<QLMauSac> findAll(){
        return list;
    }
    public QLMauSac findByMa(String ma){
        for (int i = 0; i < list.size() ; i++) {
            QLMauSac vm = list.get(i);
            if(vm.getMa().equals(ma)){
                return list.get(i);
            }
        }
        return null;
    }
}
