import java.io.IOException;

public class HandleIOException {

    public static void methodA() throws IOException{
        System.out.println("--methodA()抛出异常……");
        throw new IOException("methodA()发生异常……");
    }

    public static void methodB() throws IOException{
        try{
            methodA();
        }catch (IOException i){
            System.out.println("--methodB()接收到methodA()抛出的异常");
            System.out.println("methodA()抛出的异常: "+i.toString());
            System.out.println("--methodB()抛出异常……");
            throw new IOException("methodB()发生异常……");
        }
    }

    public static void main(String[] args){
        try{
            methodB();
        }catch(IOException i){
            System.out.println("--main(String[] args)接收到methodB()抛出的异常");
            System.out.println("methodB()抛出的异常: "+i.toString());
        }
    }

}
