package controllers.admin;


import domain_models.HoaDon;
import domain_models.KhachHang;
import domain_models.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import repository.HoaDonRepository;
import repository.KhachHangRepository;
import repository.NhanVienRepository;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.UUID;

@WebServlet({
        "/hoa-don/index",    // GET
        "/hoa-don/create",   // GET
        "/hoa-don/edit",     // GET
        "/hoa-don/delete",   // GET
        "/hoa-don/store",    // POST
        "/hoa-don/update",   // POST
})

public class HoaDonController  extends HttpServlet {
    private HoaDonRepository hdRepo;

    private KhachHangRepository khRepo;

    private NhanVienRepository nvRepo;

    public HoaDonController()
    {
        hdRepo = new HoaDonRepository();
        khRepo = new KhachHangRepository();
        nvRepo = new NhanVienRepository();

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
            response.sendRedirect("/SP23B2_SOF3011_IT17321_war/hoa-don/index");
        }
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsHoaDon", hdRepo.findAll());
        request.setAttribute("view", "/views/hoa_don/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsKhachHang", khRepo.findAll());
        request.setAttribute("dsNhanVien", nvRepo.findAll());
        request.setAttribute("view", "/views/hoa_don/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsKhachHang", khRepo.findAll());
        request.setAttribute("dsNhanVien", nvRepo.findAll());

        String ma = request.getParameter("ma");
        HoaDon hd = hdRepo.findByMa(ma);
        request.setAttribute("hd", hd);

        request.setAttribute("idKhachHang", hd.getKhachHang().getId());
        request.setAttribute("idNhanVien", hd.getNhanVien().getId());

        request.setAttribute("view", "/views/hoa_don/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        HoaDon hd = hdRepo.findByMa(String.valueOf(id));
        hdRepo.delete(hd);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/hoa-don/index");
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            String tenNguoiNhan = request.getParameter("tenNguoiNhan");
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            if (ma.trim().isEmpty()||tenNguoiNhan.trim().isEmpty()||diaChi.trim().isEmpty()||sdt.trim().isEmpty()){
                request.getSession().setAttribute("errorMessage", "Vui lòng nhập đầy đủ thông tin");
                response.sendRedirect(request.getContextPath() + "/hoa-don/create");
                return;

            }
            if (hdRepo.findByMa(ma) != null ){
                request.getSession().setAttribute("errorMessage", "Trùng mã");
                response.sendRedirect(request.getContextPath() + "/hoa-don/create");
                return;
            }


            DateTimeConverter dateTimeConverter = new DateConverter(new Date());
            dateTimeConverter.setPattern("yyyy-MM-dd");
            ConvertUtils.register(dateTimeConverter, Date.class);


            UUID idKhachHang= UUID.fromString(request.getParameter("idKhachHang"));
            KhachHang kh = new KhachHang();
            kh.setId(idKhachHang);

            UUID idNhanVien = UUID.fromString(request.getParameter("idNhanVien"));
            NhanVien nv = new NhanVien();
            nv.setId(idNhanVien);


            HoaDon domainModelHD = new HoaDon();
            domainModelHD.setKhachHang(kh);
            domainModelHD.setNhanVien(nv);

            BeanUtils.populate(domainModelHD, request.getParameterMap());
            hdRepo.insert(domainModelHD);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/hoa-don/index");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {


            String ma = request.getParameter("ma");
            String tenNguoiNhan = request.getParameter("tenNguoiNhan");
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            if (ma.trim().isEmpty()||tenNguoiNhan.trim().isEmpty()||diaChi.trim().isEmpty()||sdt.trim().isEmpty()){
                request.getSession().setAttribute("errorMessage", "Vui lòng nhập đầy đủ thông tin");
                response.sendRedirect(request.getContextPath() + "/hoa-don/edit?ma=" + ma);
                return;

            }

            DateTimeConverter dateTimeConverter = new DateConverter(new Date());
            dateTimeConverter.setPattern("yyyy-MM-dd");
            ConvertUtils.register(dateTimeConverter, Date.class);


            UUID idKhachHang= UUID.fromString(request.getParameter("idKhachHang"));
            KhachHang kh = new KhachHang();
            kh.setId(idKhachHang);

            UUID idNhanVien = UUID.fromString(request.getParameter("idNhanVien"));
            NhanVien nv = new NhanVien();
            nv.setId(idNhanVien);


            HoaDon domainModelHD = hdRepo.findByMa(ma);
            domainModelHD.setKhachHang(kh);
            domainModelHD.setNhanVien(nv);

            BeanUtils.populate(domainModelHD, request.getParameterMap());
            hdRepo.update(domainModelHD);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/hoa-don/index");
    }
}
