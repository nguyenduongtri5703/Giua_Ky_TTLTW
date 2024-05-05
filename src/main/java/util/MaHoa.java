package util;

import java.security.MessageDigest;
import java.util.Base64;

public class MaHoa {

    public static String toSHA1(String str) {
        String salt = "askpljodhaojs1!@#--124";
        String result = null;

        str += salt;
        try {
            byte[] dataBytes = str.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            result = Base64.getEncoder().encodeToString(md.digest(dataBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String pass = "123456";
        System.out.println(toSHA1(pass));    }
}
