public class BubbleSorting {

    public static void exchangeValue(int[] array, int i, int j) {
        if (i < 0 || j < 0 || i > array.length - 1 || j > array.length - 1) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static void bubbleSorting(int[] array) {
        int num = array.length;
        for (int i = 0; i < num - 1; i++)
            for (int m = 0; m < num - i - 1; m++)
                if (array[m] > array[m + 1])
                    exchangeValue(array, m, m + 1);
    }

    public static void showArray(int[] array) {
        System.out.print("数组升序排序后 ： ");
        for (int val : array)
            System.out.print(val + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {75, 53, 32, 12, 46, 199, 17, 54};
        bubbleSorting(a);
        showArray(a);
    }
}