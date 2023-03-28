package repository;



import view_model.QLChucVu;

import java.util.ArrayList;

public class ChucVuRepository {
    private ArrayList<QLChucVu> list = new ArrayList<>();

    public ChucVuRepository() {
        list = new ArrayList<>();

    }
    public void insert (QLChucVu qlcv){
        list.add(qlcv);
    }
    public void update(QLChucVu qlcv){
        for (int i = 0; i < list.size() ; i++) {
            QLChucVu vm = list.get(i);
            if(vm.getMa().equals(qlcv.getMa())){
                list.set(i, qlcv);
            }
        }
    }
    public void delete(QLChucVu qlcv){
        for (int i = 0; i < list.size() ; i++) {
            QLChucVu vm = list.get(i);
            if(vm.getMa().equals(qlcv.getMa())){
                list.remove(i);
            }
        }
    }

    public ArrayList<QLChucVu> findAll(){
        return list;
    }
    public QLChucVu findByMa(String ma){
        for (int i = 0; i < list.size() ; i++) {
            QLChucVu vm = list.get(i);
            if(vm.getMa().equals(ma)){
                return list.get(i);
            }
        }
        return null;
    }
}
