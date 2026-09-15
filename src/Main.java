import java.util.Arrays;
public class Main {
    public static void main(String[] args){
        int[] numbers = {5, 2 ,8 , 1, 3};
        MergeSorter sorter = new MergeSorter();
        sorter.sort(numbers);
        System.out.println("MergeSort:");
        System.out.println(Arrays.toString(numbers));
        System.out.println("Comparisons:" + sorter.getComparisons());
        System.out.println("Max depth:" + sorter.getMaxDepth());

        int[] numbers2 = {5 , 2, 8 , 1, 3};
        QuickSorter quickSorter = new QuickSorter();
        quickSorter.sort(numbers2);
        System.out.println("QuickSort:");
        System.out.println(Arrays.toString(numbers2));
    }
}
