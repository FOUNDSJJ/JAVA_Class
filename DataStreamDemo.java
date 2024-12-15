import java.io.*;
import java.util.Random;

public class DataStreamDemo {

    public  static  String filePath="data.dat";

    public static void main(String[] args){
        //写入整数
        try(
                FileOutputStream fis=new FileOutputStream(filePath);
                DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(fis));
                ){
            Random myRandom=new Random();
            for(int i=0;i<10;i++){
                var val=myRandom.nextInt(1000,2001);
                System.out.println("第"+(i+1)+"个数："+val);
                dos.writeInt(val);
            }
        }catch(IOException ioe){
            System.out.println(ioe.toString());
        }

        //读取文件中的整数
        try(
                var fis=new FileInputStream(filePath);
                var dis=new DataInputStream(new BufferedInputStream(fis));
                ){
            int val;
            while(dis.available()!=0){
                val=dis.readInt();
                System.out.println("读取的整数："+val);
            }
        }catch(IOException ioe){
            System.out.println(ioe.toString());
        }
    }

}
