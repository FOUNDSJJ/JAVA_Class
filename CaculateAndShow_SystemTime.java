import java.util.Date;

public class CaculateAndShow_SystemTime {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        Date date = new Date();
        System.out.println("Now is "+date);
        long endTime = System.currentTimeMillis();
        System.out.println("Program's running time is "+(endTime-startTime)+" ms");
    }
}
