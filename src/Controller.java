
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller {

        // random 6 kí tự  của Captcha
    public static String generateCaptcha() {
        String chars = "1234567890qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM";
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(chars.charAt(r.nextInt(chars.length()))); //lấy 1 kí tự bất kì trong khoảng String chars
        }
        return sb.toString();
    }
    // để lấy value từ properties, truyền key và lấy value tương ứng
    public String getWordLanguage(Locale locale, String key) {
        ResourceBundle words = ResourceBundle.getBundle("Language/TPBank", locale );//ten folder/base name: để lấy file đúng
        return words.getString(key);// truyền key lấy lại ra value
    }
}
//locale : en_US