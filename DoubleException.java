import java.util.Scanner;
import java.lang.Math;
import java.lang.Double;

public class DoubleException {

    public static class myDoubleException extends Exception {
        public String input;
        public Double radius = 1.0;

        public myDoubleException(String i) {
            input = i;
        }

        public myDoubleException(double r, String i) {
            input = i;
            radius = r;
        }

        @Override
        public String toString() {
            if (radius <= 0)
                return "发生错误,输入的半径<=0！！！\n" +
                        "错误的的输入为" + input;
            else {
                if (input.isEmpty())
                    return "发生错误,输入为空！！！";
                else
                    return "发生错误,输入不是double类型！！！\n" +
                            "错误的输入为: " + input;
            }
        }
    }

    public static double calculateArea(String radius)
            throws myDoubleException {
        if (radius.isEmpty()) {
            throw new myDoubleException(radius);
        }
        double r;
        try {
            r = Double.parseDouble(radius);
            if (r <= 0)
                throw new myDoubleException(r, radius);
        } catch (NumberFormatException e) {
            throw new myDoubleException(radius);
        }
        return r * r * Math.PI;
    }

    public static void main(String[] args) {
        var myScanner = new Scanner(System.in);
        System.out.print("请输入圆的半径： ");
        String input = myScanner.next();
        double area;
        try {
            area = calculateArea(input);
            System.out.println("圆的面积是： " + area);
        } catch (myDoubleException d) {
            System.out.println(d);
        }
    }

}
