package service;

import db.IDAO;
import db.UserDAO;
import model.User;

import java.util.Optional;

public class UserService implements IDAO<User> {

    UserDAO dao = new UserDAO();
    private static UserService instance;

    public static UserService getInstance(){
        if (instance==null) instance = new UserService();
        return instance;
    }

    @Override
    public int insert(User model) {
        return dao.insert(model);
    }

    public String getEmail(String email){
        return dao.getEmail(email);
    }

    public String getPassword(String email){
        return dao.getPassword(email);
    }

    public static void main(String[] args) {
//        User user = new User("01", "Dương Trí Nguyên", "21130456@st.hcmuaf.edu.vn", "123456");
//        int res = UserService.getInstance().insert(user);
//        System.out.println(res);
        String email = "21130456@st.hcmuaf.edu.vn";
        String res = String.valueOf(UserService.getInstance().getEmail(email));
        System.out.println(res.equals("21130456@st.hcmuaf.edu.vn"));
    }
}
