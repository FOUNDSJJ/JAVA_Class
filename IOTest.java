import java.io.*;

public class IOTest {

    public static String filePath="D:\\Private\\Grade_2\\面向对象程序设计（Java）\\StudyingTest\\src\\inputFile.txt";

    public static void main(String[] args){
        var file=new File(filePath);
        var newFile=new File("src\\inputFile.txt");
        System.out.print(file.exists()+"\n");
        System.out.println(file.length());
        System.out.println(file);
        file.delete();
    }

}
