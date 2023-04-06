package controllers.admin;

import domain_models.ChucVu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import repository.ChucVuRepository;




import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


@WebServlet({
        "/chuc-vu/index",    // GET
        "/chuc-vu/create",   // GET
        "/chuc-vu/edit",     // GET
        "/chuc-vu/delete",   // GET
        "/chuc-vu/store",    // POST
        "/chuc-vu/update",   // POST
})

public class ChucVuController extends HttpServlet {

    private ChucVuRepository cvRepo;

    public ChucVuController()
    {
        cvRepo = new ChucVuRepository();
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
            response.sendRedirect("/SP23B2_SOF3011_IT17321_war/chuc-vu/index");
        }
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dsChucVu", cvRepo.findAll());
        request.setAttribute("view", "/views/chuc_vu/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/views/chuc_vu/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu cv = cvRepo.findByMa(ma);
        request.setAttribute("cv", cv);
        request.setAttribute("view", "/views/chuc_vu/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu cv = cvRepo.findByMa(ma);
        cvRepo.delete(cv);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/chuc-vu/index");
    }


    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            if (ma.trim().isEmpty()||ten.trim().isEmpty()){
                request.getSession().setAttribute("errorMessage", "Vui lòng nhập đầy đủ thông tin");
                response.sendRedirect(request.getContextPath() + "/chuc-vu/create");
                return;

            }
            if (cvRepo.findByMa(ma) != null ){
                request.getSession().setAttribute("errorMessage", "Trùng mã");
                response.sendRedirect(request.getContextPath() + "/chuc-vu/create");
                return;
            }



            ChucVu domainModelCV = new ChucVu();
            BeanUtils.populate(domainModelCV, request.getParameterMap());
            this.cvRepo.insert(domainModelCV);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/chuc-vu/index");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            if (ma.trim().isEmpty()||ten.trim().isEmpty()){
                request.getSession().setAttribute("errorMessage", "Vui lòng nhập đầy đủ thông tin");
                response.sendRedirect(request.getContextPath() + "/chuc-vu/edit?ma=" + ma);
                return;

            }



            ChucVu domainModelCV = new ChucVu();
            BeanUtils.populate(domainModelCV, request.getParameterMap());
            this.cvRepo.update(domainModelCV);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/chuc-vu/index");
    }



}
