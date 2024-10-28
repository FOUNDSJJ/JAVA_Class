import static java.lang.Math.pow;

import java.util.Scanner;

public class DecimalToBinary {

    public static String toBinary(int value) {
        String temp = "";
        String result = "";
        if (value >= 0)
            result += '0';
        else {
            value = -value;
            result += '1';
        }
        while (value != 0) {
            if (value % 2 == 1)
                temp += '1';
            else
                temp += '0';
            value /= 2;
        }
        for(int i=31-temp.length();i>0;i--)
            result += '0';
        for (int i = temp.length() - 1; i >= 0; i--)
            result += temp.charAt(i);
        return result;
    }

    public static void main(String[] main) {
        System.out.println("二进制数最高位为符号位（0为正数 1为负数），表示范围：" + (pow(2, 32) - 1) + "~" + (-pow(2, 32)));
        Scanner myScanner = new Scanner(System.in);
        System.out.print("请输入十进制数 ：");
        int decimal = myScanner.nextInt();
        System.out.println("二进制 ：" + toBinary(decimal));
    }

}