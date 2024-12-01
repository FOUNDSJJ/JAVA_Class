import java.util.Random;

public class Interface {

    public interface IntSequence{
        public abstract boolean hasNext();
        public abstract int next();
    }

    public static class RandomIntSequence implements IntSequence,Comparable<RandomIntSequence>{
        private int n;

        public RandomIntSequence(){};

        public boolean hasNext(){
            var myRandom=new Random();
            n=myRandom.nextInt(10,100);
            return true;
        }

        public int next(){
            return n;
        }

        @Override
        public int compareTo(RandomIntSequence otherIntSequence){
            return Integer.compare(n, otherIntSequence.next());
        }
    }

    public static void main(String[] args){
        System.out.println("--实例化两个RandomIntSequence对象random1，random2");
        RandomIntSequence random1=new RandomIntSequence();
        RandomIntSequence random2=new RandomIntSequence();
        System.out.println("--调用random1.hasNext()");
        System.out.println("返回值："+random1.hasNext());
        System.out.println("--调用random2.hasNext()");
        System.out.println("返回值："+random2.hasNext());
        System.out.println("--调用random1.next()");
        System.out.println("Random1.n = "+random1.next());
        System.out.println("--调用random2.next()");
        System.out.println("Random2.n = "+random2.next());
        System.out.println("--调用random1.compareTo(random2) //1:random1>random2,0:random1==random2,-1:random1<random2");
        System.out.println("比较结果："+random1.compareTo(random2));
    }

}
