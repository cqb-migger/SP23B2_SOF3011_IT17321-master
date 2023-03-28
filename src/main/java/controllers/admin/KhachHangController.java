package controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.KhachHangRepository;
import view_model.QLKhachHang;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


@WebServlet({
    "/khach-hang/index",    // GET
    "/khach-hang/create",   // GET
    "/khach-hang/edit",     // GET
    "/khach-hang/delete",   // GET
    "/khach-hang/store",    // POST
    "/khach-hang/update",   // POST
})
public class KhachHangController extends HttpServlet {


    private KhachHangRepository khRepo;

    public KhachHangController()
    {
        this.khRepo = new KhachHangRepository();
        this.khRepo.insert(new QLKhachHang("PH1", "Ng", "Van", "A", "12-12-2022", "0123123123", "HN", "A", "vi", "hn"));
        this.khRepo.insert(new QLKhachHang("PH2", "Tr", "Thi", "B", "12-12-2022", "0123123123", "HN", "A", "vi", "hn"));
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
            this.index(request, response);
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
            response.sendRedirect("/SP23B2_SOF3011_IT17321_war/khach-hang/index");
        }

    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsKhachHang", khRepo.findAll());
        request.setAttribute("view", "/views/khach_hang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/khach_hang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLKhachHang kh = khRepo.findByMa(ma);
        request.setAttribute("kh", kh);
        request.setAttribute("view", "/views/khach_hang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLKhachHang kh = khRepo.findByMa(ma);
        khRepo.delete(kh);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/khach-hang/index");
    }


    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLKhachHang qlkh = new QLKhachHang();
            BeanUtils.populate(qlkh, request.getParameterMap());
            khRepo.insert(qlkh);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/khach-hang/index");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLKhachHang qlkh = new QLKhachHang();
            BeanUtils.populate(qlkh, request.getParameterMap());
            khRepo.update(qlkh);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/khach-hang/index");
    }



}
