package repository;



import view_model.QLNSX;

import java.util.ArrayList;

public class NSXRepository {
    private ArrayList<QLNSX> list = new ArrayList<>();

    public NSXRepository() {
        list = new ArrayList<>();

    }
    public void insert (QLNSX qlnsx){
        list.add(qlnsx);
    }
    public void update(QLNSX qlnsx){
        for (int i = 0; i < list.size() ; i++) {
            QLNSX vm = list.get(i);
            if(vm.getMa().equals(qlnsx.getMa())){
                list.set(i, qlnsx);
            }
        }
    }
    public void delete(QLNSX qlnsx){
        for (int i = 0; i < list.size() ; i++) {
            QLNSX vm = list.get(i);
            if(vm.getMa().equals(qlnsx.getMa())){
                list.remove(i);
            }
        }
    }

    public ArrayList<QLNSX> findAll(){
        return list;
    }
    public QLNSX findByMa(String ma){
        for (int i = 0; i < list.size() ; i++) {
            QLNSX vm = list.get(i);
            if(vm.getMa().equals(ma)){
                return list.get(i);
            }
        }
        return null;
    }
}
