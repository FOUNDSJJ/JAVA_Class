public class BubbleSorting {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i=0;i<a.length;i++){
            int index = (int)(Math.random()*1);
            System.out.println(i+" : "+index);
            int temp =a[index];
            a[index]=a[i];
            a[i] = temp;
        }
        for(int i : a){
            System.out.print(i+" ");
        }
    }
}