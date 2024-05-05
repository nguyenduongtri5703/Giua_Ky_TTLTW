package controller;


import service.UserService;
import util.MaHoa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "Login", value = "/dangnhap")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String error = "";

        if (!email.equals(UserService.getInstance().getEmail(email))) {
            error = "Tài khoản không tồn tại";
            req.setAttribute("error", error);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else if (!MaHoa.toSHA1(password).equals(UserService.getInstance().getPassword(email))) {
            error = "Mật khẩu không chính xác";
            req.setAttribute("error", error);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("success.jsp");
        }

    }

}
