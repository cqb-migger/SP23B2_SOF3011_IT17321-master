package controllers.admin;

import domain_models.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import repository.ChiTietSanPhamRepository;
import repository.HoaDonChiTietRepository;
import repository.HoaDonRepository;
import view_model.QLHoaDonChiTiet;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

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

    private HoaDonRepository hdRepo;
    private ChiTietSanPhamRepository ctspRepo;

    public HoaDonChiTietController()
    {
        hdctRepo = new HoaDonChiTietRepository();
        hdRepo = new HoaDonRepository();
        ctspRepo =new ChiTietSanPhamRepository();

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
        request.setAttribute("dsHoaDon", hdRepo.findAll());
        request.setAttribute("dsChiTietSanPham", ctspRepo.findAll());
        request.setAttribute("view", "/views/hoadon_ct/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsHoaDon", hdRepo.findAll());
        request.setAttribute("dsChiTietSanPham", ctspRepo.findAll());

        UUID id = UUID.fromString(request.getParameter("id"));
        HoaDonChiTiet hdct = hdctRepo.findByMa(id);
        request.setAttribute("hdct", hdct);

        request.setAttribute("idHoaDon", hdct.getHoaDon().getId());
        request.setAttribute("idChiTietSanPham", hdct.getChiTietSanPham().getId());

        request.setAttribute("view", "/views/hoadon_ct/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        HoaDonChiTiet hdct = hdctRepo.findByMa(id);
        hdctRepo.delete(hdct);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/hoadon-chitiet/index");
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {


            UUID idHoaDon = UUID.fromString(request.getParameter("idHoaDon"));
            HoaDon hd = new HoaDon();
            hd.setId(idHoaDon);

            UUID idChiTietSanPham = UUID.fromString(request.getParameter("idChiTietSanPham"));
            ChiTietSanPham ctsp = new ChiTietSanPham();
            ctsp.setId(idChiTietSanPham);


            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setHoaDon(hd);
            hoaDonChiTiet.setChiTietSanPham(ctsp);

            BeanUtils.populate(hoaDonChiTiet, request.getParameterMap());
            hdctRepo.insert(hoaDonChiTiet);
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

            UUID id = UUID.fromString(request.getParameter("id"));


            UUID idHoaDon = UUID.fromString(request.getParameter("idHoaDon"));
            HoaDon hd = new HoaDon();
            hd.setId(idHoaDon);

            UUID idChiTietSanPham = UUID.fromString(request.getParameter("idChiTietSanPham"));
            ChiTietSanPham ctsp = new ChiTietSanPham();
            ctsp.setId(idChiTietSanPham);


            HoaDonChiTiet hoaDonChiTiet = hdctRepo.findByMa(id);
            hoaDonChiTiet.setHoaDon(hd);
            hoaDonChiTiet.setChiTietSanPham(ctsp);

            int soLuong = Integer.parseInt(request.getParameter("soLuong"));
            BigDecimal donGia = new BigDecimal(request.getParameter("donGia"));

            hoaDonChiTiet.setSoLuong(soLuong);
            hoaDonChiTiet.setDonGia(donGia);

//            BeanUtils.populate(hoaDonChiTiet, request.getParameterMap());
            hdctRepo.update(hoaDonChiTiet);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/hoadon-chitiet/index");
    }
}
