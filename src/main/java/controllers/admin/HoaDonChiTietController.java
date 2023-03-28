package controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.HoaDonChiTietRepository;
import view_model.QLHoaDonChiTiet;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/hoadon-chitiet/index",    // GET
        "/hoadon-chitiet/create",   // GET
        "/hoadon-chitiet/edit",     // GET
        "/hoadon-chitiet/delete",   // GET
        "/hoadon-chitiet/store",    // POST
        "/hoadon-chitiet/update",   // POST
})

public class HoaDonChiTietController extends HttpServlet {
    private HoaDonChiTietRepository hdctRepo;

    public HoaDonChiTietController()
    {
        hdctRepo = new HoaDonChiTietRepository();
        hdctRepo.insert(new QLHoaDonChiTiet("PH1", "10","10"));
        hdctRepo.insert(new QLHoaDonChiTiet("PH2", "10","10"));
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
            response.sendRedirect("/SP23B2_SOF3011_IT17321_war/hoadon-chitiet/index");
        }
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsHoaDonChiTiet", hdctRepo.findAll());
        request.setAttribute("view", "/views/hoadon_ct/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/hoadon_ct/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLHoaDonChiTiet hdct = hdctRepo.findByMa(ma);
        request.setAttribute("hdct", hdct);
        request.setAttribute("view", "/views/hoadon_ct/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLHoaDonChiTiet hdct = hdctRepo.findByMa(ma);
        hdctRepo.delete(hdct);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/hoadon-chitiet/index");
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLHoaDonChiTiet qlhdct = new QLHoaDonChiTiet();
            BeanUtils.populate(qlhdct, request.getParameterMap());
            hdctRepo.insert(qlhdct);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/hoadon-chitiet/index");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLHoaDonChiTiet qlhdct = new QLHoaDonChiTiet();
            BeanUtils.populate(qlhdct, request.getParameterMap());
            hdctRepo.update(qlhdct);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/hoadon-chitiet/index");
    }
}
