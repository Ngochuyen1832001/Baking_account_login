
import java.util.Locale;
import java.util.Scanner;

public class DataInput {

    private static final Scanner in = new Scanner(System.in);
    
    // hàm check input kiểu int 
    public static int inputIntLimit(int min, int max, String msg) {
        while (true) {
            System.out.print(msg);
            try {
                int result = Integer.parseInt(in.nextLine());
                if (result >= min && result <= max) {
                    return result;
                } else {
                    System.out.println("Please input number in range [" + min + ", " + max + "]!");
                }
            } catch (Exception ex) {
                System.out.println("Number only!");
            }
        }
    }
    // nhập tài khoản
    public static int inputAccount(Locale locale) {
        Controller c = new Controller();
        while (true) {
            System.out.print(c.getWordLanguage(locale, "enterAccount"));
            String result = in.nextLine();
            if (result.matches("^\\d{10}$")) { //d:digit[0-9], nhập 10 số
                return Integer.parseInt(result);
            }
            System.out.println(c.getWordLanguage(locale, "errCheckInputAccount"));//
        }
    }
    
    public static String inputPassword(Locale locale) {
        Controller c = new Controller();
        while (true) {
            System.out.print(c.getWordLanguage(locale, "enterPassword"));
            String password = in.nextLine();
            
            if (password.matches("^((?=\\w*[0-9])(?=\\d*[a-zA-Z]))[a-zA-Z0-9]{8,31}$")) {  //1 check đằng sau kí tự chữ nào cũng phải có kí tự số //2 check đằng sau mỗi kí tự số phải có 1 kí tự chữ //3 check dộ dài passwork trong khoảng 8-31
                    return password;
            } else {
                System.out.println(c.getWordLanguage(locale, "errCheckPassword"));
            }
        }
    }

    public static void inputCaptcha(String captchaGenerated, Locale locale) {
        Controller c = new Controller();
        while (true) {
            System.out.print(c.getWordLanguage(locale, "enterCaptcha"));
            String captchaInput = in.nextLine();
            if (captchaGenerated.contains(captchaInput)) { //nếu chọn 1 chữ trong chuỗi captcha thì vẫn ra 
                System.out.println(c.getWordLanguage(locale, "loginSuccess"));
                return;
            } else {
                System.out.println(c.getWordLanguage(locale, "errCaptchaIncorrect"));
            }
        }
    }
}
