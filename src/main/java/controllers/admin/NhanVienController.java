package controllers.admin;

import domain_models.ChucVu;

import domain_models.CuaHang;
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
import repository.ChucVuRepository;
import repository.CuaHangRepository;

import repository.NhanVienRepository;



import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.UUID;

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

    private ChucVuRepository cvRepo;

    private CuaHangRepository chRepo;

    public NhanVienController()
    {
        nvRepo = new NhanVienRepository();
        cvRepo = new ChucVuRepository();
        chRepo = new CuaHangRepository();
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
        request.setAttribute("dsChucVu", cvRepo.findAll());
        request.setAttribute("dsCuaHang", chRepo.findAll());
        request.setAttribute("view", "/views/nhan_vien/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsCuaHang", chRepo.findAll());
        request.setAttribute("dsChucVu", cvRepo.findAll());
        String ma = request.getParameter("ma");
        NhanVien nv = nvRepo.findByMa(ma);
        request.setAttribute("nv", nv);

        request.setAttribute("idCuaHang", nvRepo.findIdCuaHangByMa(ma));
        request.setAttribute("idChucVu", nvRepo.findIdChucVuByMa(ma));
        request.setAttribute("view", "/views/nhan_vien/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien nv = nvRepo.findByMa(ma);
        nvRepo.delete(nv);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/nhan-vien/index");
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DateTimeConverter dateTimeConverter = new DateConverter(new Date());
            dateTimeConverter.setPattern("yyyy-MM-dd");
            ConvertUtils.register(dateTimeConverter, Date.class);


            UUID idChucVu = UUID.fromString(request.getParameter("idChucVu"));
            ChucVu cv = new ChucVu();
            cv.setId(idChucVu);

            UUID idCuaHang = UUID.fromString(request.getParameter("idCuaHang"));
            CuaHang ch = new CuaHang();
            ch.setId(idCuaHang);


            NhanVien domainModelNV = new NhanVien();
            domainModelNV.setChucVu(cv);
            domainModelNV.setCuaHang(ch);

            BeanUtils.populate(domainModelNV, request.getParameterMap());
            nvRepo.insert(domainModelNV);
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

            String ma = request.getParameter("ma");

            DateTimeConverter dateTimeConverter = new DateConverter(new Date());
            dateTimeConverter.setPattern("yyyy-MM-dd");
            ConvertUtils.register(dateTimeConverter, Date.class);




            UUID idChucVu = UUID.fromString(request.getParameter("idChucVu"));
            ChucVu cv = new ChucVu();
            cv.setId(idChucVu);


            UUID idCuaHang = UUID.fromString(request.getParameter("idCuaHang"));
            CuaHang ch = new CuaHang();
            ch.setId(idCuaHang);



            NhanVien domainModelNV = nvRepo.findByMa(ma);
            domainModelNV.setChucVu(cv);
            domainModelNV.setCuaHang(ch);

            BeanUtils.populate(domainModelNV, request.getParameterMap());
//            domainModelNV.setChucVu(cv);
//            domainModelNV.setCuaHang(ch);
            nvRepo.update(domainModelNV);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(list);x`
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/nhan-vien/index");
    }
}
