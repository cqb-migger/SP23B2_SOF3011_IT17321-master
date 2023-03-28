package controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.NhanVienRepository;
import view_model.QLNhanVien;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/nhan-vien/index",    // GET
        "/nhan-vien/create",   // GET
        "/nhan-vien/edit",     // GET
        "/nhan-vien/delete",   // GET
        "/nhan-vien/store",    // POST
        "/nhan-vien/update",   // POST
})

public class NhanVienController extends HttpServlet  {
    private NhanVienRepository nvRepo;

    public NhanVienController()
    {
        nvRepo = new NhanVienRepository();
        nvRepo.insert(new QLNhanVien("PH1", "Hoa","Khanh","Vi",true,"12-12-2022","BG","01232131212",true));
        nvRepo.insert(new QLNhanVien("PH2", "Hoa","Khanh","Vi",false,"12-12-2022","BG","01232131212",false));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("create")) {
            create(request, response);
        }else if (url.contains("edit")) {
            edit(request, response);
        }
        else if (url.contains("delete")) {
            delete(request, response);
        } else {
            index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if(url.contains("store")){
            store(request, response);
        } else if (url.contains("update")) {
            update(request,response);
        } else {
            response.sendRedirect("/SP23B2_SOF3011_IT17321_war/nhan-vien/index");
        }
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsNhanVien", nvRepo.findAll());
        request.setAttribute("view", "/views/nhan_vien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/nhan_vien/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNhanVien nv = nvRepo.findByMa(ma);
        request.setAttribute("nv", nv);
        request.setAttribute("view", "/views/nhan_vien/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNhanVien nv = nvRepo.findByMa(ma);
        nvRepo.delete(nv);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/nhan-vien/index");
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLNhanVien qlnv = new QLNhanVien();
            BeanUtils.populate(qlnv, request.getParameterMap());
            nvRepo.insert(qlnv);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/nhan-vien/index");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLNhanVien qlnv = new QLNhanVien();
            BeanUtils.populate(qlnv, request.getParameterMap());
            nvRepo.update(qlnv);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/nhan-vien/index");
    }
}
