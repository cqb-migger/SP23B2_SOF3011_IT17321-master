package controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.NSXRepository;
import view_model.QLNSX;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/nsx/index",    // GET
        "/nsx/create",   // GET
        "/nsx/edit",     // GET
        "/nsx/delete",   // GET
        "/nsx/store",    // POST
        "/nsx/update",   // POST
})

public class NSXController extends HttpServlet {
    private NSXRepository nsxRepo;

    public NSXController()
    {
        nsxRepo = new NSXRepository();
        nsxRepo.insert(new QLNSX("PH1", "Tong Thong"));
        nsxRepo.insert(new QLNSX("PH2", "Dan Den"));
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
            response.sendRedirect("/SP23B2_SOF3011_IT17321_war/nsx/index");
        }
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsNSX", nsxRepo.findAll());
        request.setAttribute("view", "/views/nsx/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/nsx/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNSX nsx = nsxRepo.findByMa(ma);
        request.setAttribute("nsx", nsx);
        request.setAttribute("view", "/views/nsx/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNSX nsx = nsxRepo.findByMa(ma);
        nsxRepo.delete(nsx);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/nsx/index");
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLNSX qlnsx = new QLNSX();
            BeanUtils.populate(qlnsx, request.getParameterMap());
            nsxRepo.insert(qlnsx);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/nsx/index");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLNSX qlnsx = new QLNSX();
            BeanUtils.populate(qlnsx, request.getParameterMap());
            nsxRepo.update(qlnsx);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/nsx/index");
    }
}
