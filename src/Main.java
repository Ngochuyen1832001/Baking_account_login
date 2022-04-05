
import java.util.Locale;

public class Main {
    // khai báo 2 locale 
    public static void main(String[] args) {
        Locale vietnamese = new Locale("vi", "VN");// nếu muốn đổi tên thì phải đổi tên properties tương ứng
        Locale english = new Locale("en", "US");
        int choice = menu();
        switch (choice) {
            case 1:
                login(vietnamese);
                break;
            case 2:
                login(english);
                break;
            case 3:
                break;
        }
    }

    private static int menu() {
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        int choice = DataInput.inputIntLimit(1, 3, "Please choice one option: ");
        return choice;
    }

    // nhập dữ liệu: tkhoan và mật khẩu, captcha
    private static void login(Locale locale) {
        Controller c = new Controller();
        //int account = DataInput.inputAccount(locale); 
        String password = DataInput.inputPassword(locale);
        String captchaGenerated = Controller.generateCaptcha();
        System.out.println(c.getWordLanguage(locale, "showCaptcha") + captchaGenerated);
        DataInput.inputCaptcha(captchaGenerated, locale);
    }
}
