package controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import repository.SanPhamRepository;
import view_model.QLKhachHang;
import view_model.QLSanPham;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


@WebServlet({
        "/san-pham/index",    // GET
        "/san-pham/create",   // GET
        "/san-pham/edit",     // GET
        "/san-pham/delete",   // GET
        "/san-pham/store",    // POST
        "/san-pham/update",   // POST
})

public class SanPhamController extends HttpServlet {
    private SanPhamRepository spRepo;

    public SanPhamController()
    {
        this.spRepo = new SanPhamRepository();
        this.spRepo.insert(new QLSanPham("PH1", "Tong Thong"));
        this.spRepo.insert(new QLSanPham("PH2", "Dan Den"));
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
            response.sendRedirect("/SP23B2_SOF3011_IT17321_war/san-pham/index");
        }
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsSanPham", spRepo.findAll());
        request.setAttribute("view", "/views/san_pham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/san_pham/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLSanPham sp = spRepo.findByMa(ma);
        request.setAttribute("sp", sp);
        request.setAttribute("view", "/views/san_pham/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLSanPham sp = spRepo.findByMa(ma);
        spRepo.delete(sp);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/san-pham/index");
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");



        QLSanPham qlsp = new QLSanPham(ma,ten);
        //Tộ ArrayList & thêm vào
        spRepo.insert(qlsp);
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/san-pham/index");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLSanPham qlsp = new QLSanPham();
            BeanUtils.populate(qlsp, request.getParameterMap());
            spRepo.update(qlsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/san-pham/index");
    }
}
