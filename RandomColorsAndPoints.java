import java.util.Random;

public class RandomColorsAndPoints {
    public static char randomColors(){
        Random myRandom = new Random();
        int randomInt = myRandom.nextInt(100);
        char[] colors = {'♦', '♠', '♣', '♥'};
        return colors[randomInt%4];
    }

    public static String randomPoints(){
        Random myRandom = new Random();
        int randomInt = myRandom.nextInt(100);
        String[] points = {"2", "3", "4", "5","6","7","8","9","10","J","Q","K","A"};
        return points[randomInt%13];
    }

    public static void main(String[] args){
        for (int i = 0; i < 10; i++) {
            System.out.println("第"+i+"轮 ：");
            System.out.println("The random color and random point are : "+randomColors()+" "+randomPoints());
        }
    }
}
