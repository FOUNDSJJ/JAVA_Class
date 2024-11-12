import com.boda.UsedClass.Cylinder;

import java.util.Scanner;

public class ClassInheritance {

    public static void main(String[] args){
        Scanner myScanner=new Scanner(System.in);
        System.out.print("请输入圆柱的底面半径（单位：米）：");
        double radius=myScanner.nextDouble();
        System.out.print("请输入圆柱的高度（单位：米）：");
        double height=myScanner.nextDouble();

        var myCylinder=new Cylinder(height,radius);
        System.out.println("圆柱的面积为："+myCylinder.getArea()+" m^2");
        System.out.println("圆柱的体积为："+myCylinder.getVolume()+" m^3");
    }

}
