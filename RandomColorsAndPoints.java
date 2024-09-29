import java.util.Random;

public class RandomColorsAndPoints {
    public static char randomCorlors(){
        Random myRandom = new Random();
        int randomInt = myRandom.nextInt(100);
        char[] colors = {'♦', '♠', '♣', '♥'};
        char color = colors[randomInt%4];
        return color;
    }

    public static String randomPoints(){
        Random myRandom = new Random();
        int randomInt = myRandom.nextInt(100);
        String[] points = {"2", "3", "4", "5","6","7","8","9","10","J","Q","K","A"};
        String point = points[randomInt%13];
        return point;
    }

    public static void main(String[] args){
        for (int i = 0; i < 10; i++) {
            System.out.println("第"+i+"轮 ：");
            System.out.println("The random color and random point are : "+randomCorlors()+" "+randomPoints());
        }
    }
}
