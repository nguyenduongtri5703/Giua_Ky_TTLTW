package db;

import model.User;
import util.MaHoa;
import vn.fit.nlu.gk.db.JDBIConnector;

import java.util.Optional;

public class UserDAO implements IDAO<User>{
    @Override
    public int insert(User model) {
        String sql = "insert into user values(?,?,?,?)";
        return JDBIConnector.get().withHandle(handle ->
                handle.createUpdate(sql)
                        .bind(0, model.getId())
                        .bind(1, model.getName())
                        .bind(2, model.getEmail())
                        .bind(3, MaHoa.toSHA1(model.getPassword()))
                        .execute()
        );
    }

    public String getEmail(String email) {
        String sql = "select email from user where email = ?";
        return JDBIConnector.get().withHandle(handle ->
                handle.createQuery(sql)
                        .bind(0, email)
                        .mapTo(String.class)
                        .findOne()
                        .orElse(null)
        );
    }

    public String getPassword(String email){
        String sql = "select password from user where email = ?";
         return JDBIConnector.get().withHandle(handle ->
                handle.createQuery(sql)
                        .bind(0, email)
                        .mapTo(String.class)
                        .findOne()
                        .orElse(null)
        );
    }
}
