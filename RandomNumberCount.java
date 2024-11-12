import java.util.Random;

public class RandomNumberCount {

    public static int[] randomNumberCount(int randomStart, int randomEnd, int num) {
        if (randomStart > randomEnd || num < 0)
            return null;
        int[] result = new int[randomEnd - randomStart + 1];
        Random myRondom = new Random();
        for (int i = 0; i < num; i++) {
            int randomNumber = myRondom.nextInt(randomStart-1, randomEnd - randomStart + 1);
            result[randomNumber]++;
        }
        return result;
    }

    public static void showResult(int[] result) {
        if(result==null)
            return;
        int i = 1;
        for (int num : result) {
            System.out.println("RandomNumber:" + i + "  Counts:" + num);
            i++;
        }
    }

    public static void main(String[] args) {
        System.out.println("600个1~6随机数统计结果：");
        showResult(randomNumberCount(1, 6, 600));
        System.out.println("\n6000个1~6随机数统计结果：");
        showResult(randomNumberCount(1, 6, 6000));
    }

}
