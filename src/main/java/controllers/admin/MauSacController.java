package controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.MauSacRepository;
import view_model.QLMauSac;
import view_model.QLSanPham;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


@WebServlet({
        "/mau-sac/index",    // GET
        "/mau-sac/create",   // GET
        "/mau-sac/edit",     // GET
        "/mau-sac/delete",   // GET
        "/mau-sac/store",    // POST
        "/mau-sac/update",   // POST
})


public class MauSacController extends HttpServlet {
    private MauSacRepository msRepo;

    public MauSacController()
    {
        this.msRepo = new MauSacRepository();
        this.msRepo.insert(new QLMauSac("PH1", "Tong Thong"));
        this.msRepo.insert(new QLMauSac("PH2", "Dan Den"));
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
        if (url.contains("store")) {
            store(request, response);
        } else if (url.contains("update")) {
            update(request, response);
        }
        else {
            response.sendRedirect("/SP23B2_SOF3011_IT17321_war/mau-sac/index");
        }
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsMauSac", msRepo.findAll());
        request.setAttribute("view", "/views/mau_sac/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/mau_sac/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLMauSac ms = msRepo.findByMa(ma);
        request.setAttribute("ms", ms);
        request.setAttribute("view", "/views/mau_sac/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLMauSac ms = msRepo.findByMa(ma);
        msRepo.delete(ms);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/mau-sac/index");
    }protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLMauSac qlms = new QLMauSac();
            BeanUtils.populate(qlms, request.getParameterMap());
            msRepo.update(qlms);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/san-pham/index");
    }



    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");



        QLMauSac qlms = new QLMauSac(ma,ten);
        //Tộ ArrayList & thêm vào
        msRepo.insert(qlms);
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/mau-sac/index");
    }
}
