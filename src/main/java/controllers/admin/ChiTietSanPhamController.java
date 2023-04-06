package controllers.admin;


import domain_models.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import repository.*;




import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

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

    private SanPhamRepository spRepo;

    private NSXRepository nsxRepo;

    private MauSacRepository msRepo;

    private DongSpRepository dspRepo;

    public ChiTietSanPhamController()
    {
        ctspRepo = new ChiTietSanPhamRepository();
        spRepo = new SanPhamRepository();
        nsxRepo = new NSXRepository();
        msRepo = new MauSacRepository();
        dspRepo = new DongSpRepository();
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
        request.setAttribute("dsSanPham", spRepo.findAll());
        request.setAttribute("dsNSX", nsxRepo.findAll());
        request.setAttribute("dsMauSac", msRepo.findAll());
        request.setAttribute("dsDongSP", dspRepo.findAll());

        request.setAttribute("view", "/views/chitiet_sanpham/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsSanPham", spRepo.findAll());
        request.setAttribute("dsNSX", nsxRepo.findAll());
        request.setAttribute("dsMauSac", msRepo.findAll());
        request.setAttribute("dsDongSP", dspRepo.findAll());

        UUID id = UUID.fromString(request.getParameter("id"));

        ChiTietSanPham ctsp = ctspRepo.findByMa(id);
        request.setAttribute("ctsp", ctsp);

        request.setAttribute("idSanPham", ctspRepo.findIdSanPhamById(id));
        request.setAttribute("idNSX", ctspRepo.findIdNSXById(id));
        request.setAttribute("idMauSac", ctspRepo.findIdMauSacById(id));
        request.setAttribute("idDongSP", ctspRepo.findIdDongSpById(id));

        request.setAttribute("view", "/views/chitiet_sanpham/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChiTietSanPham ctsp = ctspRepo.findByMa(UUID.fromString(id));
        ctspRepo.delete(ctsp);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/chitiet-sp/index");
    }


    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
        UUID idSanPham = UUID.fromString(request.getParameter("idSanPham"));
        SanPham sp = new SanPham();
        sp.setId(idSanPham);

        UUID idNSX = UUID.fromString(request.getParameter("idNSX"));
        NSX nsx = new NSX();
        nsx.setId(idNSX);

        UUID idMauSac = UUID.fromString(request.getParameter("idMauSac"));
        MauSac ms  = new MauSac();
        ms.setId(idMauSac);

        UUID idDongSP = UUID.fromString(request.getParameter("idDongSP"));
        DongSp dsp  = new DongSp();
        dsp.setId(idDongSP);


        ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
        chiTietSanPham.setSanPham(sp);
        chiTietSanPham.setNsx(nsx);
        chiTietSanPham.setMauSac(ms);
        chiTietSanPham.setDongSp(dsp);

//        BeanUtils.populate (chiTietSanPham, request.getParameterMap());
           int namSX = Integer.parseInt(request.getParameter("namSX"));
           String moTa = request.getParameter("moTa");
           int soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
            BigDecimal giaNhap = new BigDecimal(request.getParameter("giaNhap"));
            BigDecimal giaBan = new BigDecimal(request.getParameter("giaBan"));

           chiTietSanPham.setNamSX(namSX);
           chiTietSanPham.setMoTa(moTa);
           chiTietSanPham.setSoLuongTon(soLuongTon);
           chiTietSanPham.setGiaNhap(giaNhap);
           chiTietSanPham.setGiaBan(giaBan);




        ctspRepo.insert(chiTietSanPham);
    } catch (Exception e) {
        e.printStackTrace();
    }

//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/chitiet-sp/index");
    }


    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            UUID id = UUID.fromString(request.getParameter("id"));

            UUID idSanPham = UUID.fromString(request.getParameter("idSanPham"));
            SanPham sp = new SanPham();
            sp.setId(idSanPham);

            UUID idNSX = UUID.fromString(request.getParameter("idNSX"));
            NSX nsx = new NSX();
            nsx.setId(idNSX);

            UUID idMauSac = UUID.fromString(request.getParameter("idMauSac"));
            MauSac ms  = new MauSac();
            ms.setId(idMauSac);

            UUID idDongSP = UUID.fromString(request.getParameter("idDongSP"));
            DongSp dsp  = new DongSp();
            dsp.setId(idDongSP);


            ChiTietSanPham chiTietSanPham = ctspRepo.findByMa(id);
            chiTietSanPham.setSanPham(sp);
            chiTietSanPham.setNsx(nsx);
            chiTietSanPham.setMauSac(ms);
            chiTietSanPham.setDongSp(dsp);

//            BeanUtils.populate (chiTietSanPham, request.getParameterMap());
            int namSX = Integer.parseInt(request.getParameter("namSX"));
            String moTa = request.getParameter("moTa");
            int soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
            BigDecimal giaNhap = new BigDecimal(request.getParameter("giaNhap"));
            BigDecimal giaBan = new BigDecimal(request.getParameter("giaBan"));

            chiTietSanPham.setNamSX(namSX);
            chiTietSanPham.setMoTa(moTa);
            chiTietSanPham.setSoLuongTon(soLuongTon);
            chiTietSanPham.setGiaNhap(giaNhap);
            chiTietSanPham.setGiaBan(giaBan);
            ctspRepo.update(chiTietSanPham);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/chitiet-sp/index");
    }
}
