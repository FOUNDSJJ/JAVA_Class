import java.util.Arrays;
import java.util.Scanner;

public class JudgeConstellation {

    public static String[] constellation = {"水瓶座", "双鱼座", "白羊座", "金牛座", "巨蟹座", "狮子座",
            "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座"};


    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    public static void speekConstellation(int year, int month, int day) {
        if (year < 0 || month <= 0 || month > 12 || day <= 0 || day > 31)
            System.out.println("输入的日期不正确！！！");
        int index = -1;
        switch (month) {
            case 1:
                if (day < 20)
                    index = 11;
                else
                    index = 0;
                break;
            case 2:
                if (day < 19)
                    index = 0;
                else {
                    if (day < 29 || (day == 29 && isLeapYear(year)))
                        index = 1;
                }
                break;
            case 3:
                if (day < 21)
                    index = 1;
                else
                    index = 2;
                break;
            case 4:
                if (day < 20)
                    index = 2;
                else {
                    if (day < 31)
                        index = 3;
                }
                break;
            case 5:
                if (day < 21)
                    index = 3;
                else
                    index = 4;
                break;
            case 6:
                if (day < 22)
                    index = 4;
                else {
                    if (day < 31)
                        index = 5;
                }
                break;
            case 7:
                if (day < 23)
                    index = 5;
                else
                    index = 6;
                break;
            case 8:
                if (day < 23)
                    index = 6;
                else
                    index = 7;
                break;
            case 9:
                if (day < 23)
                    index = 7;
                else {
                    if (day < 31)
                        index = 8;
                }
                break;
            case 10:
                if (day < 24)
                    index = 8;
                else
                    index = 9;
                break;
            case 11:
                if (day < 23)
                    index = 9;
                else {
                    if (day < 31)
                        index = 10;
                }
                break;
            case 12:
                if (day < 22)
                    index = 10;
                else
                    index = 11;
                break;
        }
        if (index == -1)
            System.out.println("输入的日期不正确！！！");
        else
            System.out.println(year + "年" + month + "月" + day + "号是" + constellation[index] + "。");
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int year, month, day;
        System.out.print("请输入公历出生日期（年月日，使用空格隔开，例如2024 11 9）：");
        year = myScanner.nextInt();
        month = myScanner.nextInt();
        day = myScanner.nextInt();
        speekConstellation(year, month, day);
    }

}
