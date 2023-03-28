package controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.HoaDonRepository;
import view_model.QLHoaDon;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

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

    public HoaDonController()
    {
        hdRepo = new HoaDonRepository();
        hdRepo.insert(new QLHoaDon("PH1", "12-12-2022","12-12-2022","12-12-2022","12-12-2022","dtt","Hoa","BG","0231212312321"));
        hdRepo.insert(new QLHoaDon("PH2", "12-12-2022","12-12-2022","12-12-2022","12-12-2022","ctt","Hoa","BG","0231212312321"));
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
        request.setAttribute("view", "/views/hoa_don/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLHoaDon hd = hdRepo.findByMa(ma);
        request.setAttribute("hd", hd);
        request.setAttribute("view", "/views/hoa_don/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLHoaDon hd = hdRepo.findByMa(ma);
        hdRepo.delete(hd);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/hoa-don/index");
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QLHoaDon qlhd = new QLHoaDon();
            BeanUtils.populate(qlhd, request.getParameterMap());
            hdRepo.insert(qlhd);
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
            QLHoaDon qlhd = new QLHoaDon();
            BeanUtils.populate(qlhd, request.getParameterMap());
            hdRepo.update(qlhd);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(list);
        response.sendRedirect("/SP23B2_SOF3011_IT17321_war/hoa-don/index");
    }
}
