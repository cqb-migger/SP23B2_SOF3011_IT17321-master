package controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.ChiTietSanPhamRepository;
import view_model.QLChiTietSanPham;
import view_model.QLKhachHang;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/chitiet-sp/index",    // GET
        "/chitiet-sp/create",   // GET
        "/chitiet-sp/edit",     // GET
        "/chitiet-sp/delete",   // GET
        "/chitiet-sp/store",    // POST
        "/chitiet-sp/update",   // POST
})

public class ChiTietSanPhamController extends HttpServlet {
    private ChiTietSanPhamRepository ctspRepo;

    public ChiTietSanPhamController()
    {
        ctspRepo = new ChiTietSanPhamRepository();
        ctspRepo.insert(new QLChiTietSanPham("PH1", "12-12-2022","ko co" ,"10","10","10"));
        ctspRepo.insert(new QLChiTietSanPham("PH2", "12-12-2022","ko co" ,"10","10","10"));
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            create(request, response);
        } else if (uri.contains("edit")) {
            edit(request, response);
        }else if (uri.contains("delete")) {
            delete(request, response);
        }

        else {
            index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            store(request, response);
        } else if (uri.contains("update")) {
            update(request, response);
        } else {
            response.sendRedirect("/SP23B2_SOF3011_IT17321_war/chitiet-sp/index");
        }
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsCtsp", ctspRepo.findAll());
        request.setAttribute("view", "/views/chitiet_sanpham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/chitiet_sanpham/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLChiTietSanPham ctsp = ctspRepo.findByMa(ma);
        request.setAttribute("ctsp", ctsp);
        request.setAttribute("view", "/views/chitiet_sanpham/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLChiTietSanPham ctsp = ctspRepo.findByMa(ma);
        ctspRepo.delete(ctsp);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/chitiet-sp/index");
    }


    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLChiTietSanPham qlctsp = new QLChiTietSanPham();
            BeanUtils.populate(qlctsp, request.getParameterMap());
            ctspRepo.insert(qlctsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/chitiet-sp/index");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLChiTietSanPham qlctsp = new QLChiTietSanPham();
            BeanUtils.populate(qlctsp, request.getParameterMap());
            ctspRepo.update(qlctsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/chitiet-sp/index");
    }
}
