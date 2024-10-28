import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Calendar;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Scanner;

public class StringRegularExpression {

    static String emailRegex = "\\w+@{1}+((gmail.com$)|(qq.com$)|(163.com$)" +
            "|(126.com$)|(live.com$)|(live.cn$)|(outlook.cn$)|(hotmail.com$))";

    static String idRegex = "(\\d{17}+(([0-9]$)|(X$)))";

    static Pattern emailPattern = Pattern.compile(emailRegex);

    static Pattern idPattern = Pattern.compile(idRegex);

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    public static boolean cheekId(String id) {
        Matcher idMatcher = idPattern.matcher(id);
        if (idMatcher.find()) {
            Calendar nowDate = Calendar.getInstance();
            String matchedString = idMatcher.group();
            int bothYear = Integer.parseInt(matchedString.substring(6, 10));
            int bothMonth = Integer.parseInt(matchedString.substring(10, 12));
            int bothDay = Integer.parseInt(matchedString.substring(12, 14));
            if (bothYear > nowDate.get(Calendar.YEAR)) {
                System.out.println("出生年份" + bothYear + "超出合规范围！！！");
                return false;
            } else if (bothMonth > 12 ||
                    (bothYear == nowDate.get(Calendar.YEAR) && bothMonth > nowDate.get(Calendar.MONTH) + 1)) {
                System.out.println("出生月份" + (bothMonth) + "超出合规范围！！！");
                return false;
            } else {
                if (bothMonth == nowDate.get(Calendar.MONTH) + 1 && bothDay > nowDate.get(Calendar.DAY_OF_MONTH)) {
                    System.out.println("出生号数" + (bothDay) + "超出合规范围！！！");
                    return false;
                } else if (bothDay <= 0) {
                    System.out.println("出生号数" + (bothDay) + "超出合规范围！！！");
                }
                switch (bothMonth) {
                    case 1, 3, 5, 7, 8, 10, 12:
                        if (bothDay > 31) {
                            System.out.println("出生号数" + (bothDay) + "超出合规范围！！！");
                            return false;
                        }
                        break;
                    case 2:
                        if (bothDay > 29 || (!(isLeapYear(bothYear) && bothDay == 29))) {
                            System.out.println("出生号数" + (bothDay) + "超出合规范围！！！");
                            return false;
                        }
                        break;
                    case 4, 6, 9, 11:
                        if (bothDay > 30) {
                            System.out.println("出生号数" + (bothDay) + "超出合规范围！！！");
                            return false;
                        }
                        break;
                    default:
                        System.out.println("出生号数" + (bothDay) + "超出合规范围！！！");
                        return false;
                }
            }
        }
        return true;
    }

    public static boolean cheekEmail(String email) {
        Matcher emailMatcher = emailPattern.matcher(email);
        if (emailMatcher.find()) {
            return true;
        }
        System.out.println("邮箱" + email + "不是合规邮箱名称！！！");
        return false;
    }

    public static void main(String[] args) throws IOException {
        String idPath = "src/IdTest";
        String emailPath = "src/EmailTest";
        try (InputStream myStream = new FileInputStream(idPath)) {
            Scanner myScanner = new Scanner(myStream);
            while (myScanner.hasNext()) {
                String id = myScanner.next();
                System.out.println("测试身份证号 ： " + id);
                if (cheekId(id))
                    System.out.println("身份证号码合规");
            }
        }
        try (InputStream myStream = new FileInputStream(emailPath)) {
            Scanner myScanner = new Scanner(myStream);
            while (myScanner.hasNext()) {
                String id = myScanner.next();
                System.out.println("测试邮箱名称 ： " + id);
                if (cheekEmail(id))
                    System.out.println("邮箱名称合规");
            }
        }
    }
}