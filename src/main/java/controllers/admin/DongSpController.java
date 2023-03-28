package controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.DongSpRepository;
import view_model.QLDongSp;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/dong-sp/index",    // GET
        "/dong-sp/create",   // GET
        "/dong-sp/edit",     // GET
        "/dong-sp/delete",   // GET
        "/dong-sp/store",    // POST
        "/dong-sp/update",   // POST
})

public class DongSpController extends HttpServlet {
    private DongSpRepository dspRepo;

    public DongSpController()
    {
        dspRepo = new DongSpRepository();
        dspRepo.insert(new QLDongSp("PH1", "Tong Thong"));
        dspRepo.insert(new QLDongSp("PH2", "Dan Den"));
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
            response.sendRedirect("/SP23B2_SOF3011_IT17321_war/dong-sp/index");
        }
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsDongSp", dspRepo.findAll());
        request.setAttribute("view", "/views/dong_sp/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/dong_sp/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLDongSp dsp = dspRepo.findByMa(ma);
        request.setAttribute("dsp", dsp);
        request.setAttribute("view", "/views/dong_sp/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLDongSp dsp = dspRepo.findByMa(ma);
        dspRepo.delete(dsp);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/dong-sp/index");
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLDongSp qldsp = new QLDongSp();
            BeanUtils.populate(qldsp, request.getParameterMap());
            dspRepo.insert(qldsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/dong-sp/index");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLDongSp qldsp = new QLDongSp();
            BeanUtils.populate(qldsp, request.getParameterMap());
            dspRepo.update(qldsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/dong-sp/index");
    }
}
