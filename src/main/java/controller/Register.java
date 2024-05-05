package controller;


import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebServlet(name = "Register", value = "/dangky")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String tel = req.getParameter("tel");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");
        System.out.println(password);
        System.out.println(repassword);

        String error = "";
        boolean isValid = true;
        if (!repassword.equals(password)){
            isValid = false;
            error = "Mật khẩu không trùng khớp vui lòng nhập lại";
            req.setAttribute("error", error);
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
        if (!isValidPhoneNumber(tel)){
            isValid = false;
            error = "Số điện thoại không hợp lệ";
            req.setAttribute("error", error);
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }

        if(isValid) {
            User user = new User(createID(), name, email, password);
            int res = UserService.getInstance().insert(user);

            if (res > 0) {
                resp.sendRedirect("success.jsp");
            } else {
                error = "Tạo tài khoản không thành công";
                req.setAttribute("error", error);
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            }
        }
    }

    private boolean isValidPhoneNumber(String tel) {
        String regex = "0\\d{9,10}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tel);
        return matcher.matches();
    }

    private String createID(){
        Random random = new Random();
        int id = random.nextInt(10000);
        String randomId = String.format("%04d", id);
        return randomId;
    }

}
