import java.util.Scanner;

public class PerimeterAndArea_Circular {
    public static final int PI = 314;

    public static double circularPerimeter(double r){
        return 2*PI*r/100;
    }

    public static double circularArea(double r){
        return PI*r*r/100;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Please input the radius of the circular in centimeters: ");
        double r =myScanner.nextDouble();
        System.out.println("Perimeter of the circular is : "+circularPerimeter(r)+" cm");
        System.out.println("Area of the circular is : "+circularArea(r)+" cm^2");
    }
}