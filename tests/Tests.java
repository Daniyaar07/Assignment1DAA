import java.util.Arrays;
import java.util.Random;

public class Tests {
    public static void main(String[] args) {
        testMergeSort();
        testQuickSort();
        testDeterministicSelector();
    }

    public static void testMergeSort() {
        int[][] tests = {
                {5, 2, 8 , 1, 3},
                {},
                {7},
                {5, 2, 5, 2, 1, 1},
                {1, 2 , 3, 4, 5},
                {5 , 4 , 3, 2, 1}
        };
        for (int i = 0; i< tests.length; i++){
            int[] array = tests[i].clone();
            int[] expected = tests[i].clone();

            Arrays.sort(expected);

            MergeSorter sorter = new MergeSorter();
            sorter.sort(array);

            if(Arrays.equals(array , expected)){
                System.out.println("MergeSort test " + (i+1) + " passed" );
            }
            else{
                System.out.println("MergeSort test " + (i + 1) + " failed");
            }
        }
        System.out.println();
    }
    public static void testQuickSort(){
        int[][] tests = {
                {5, 2, 8 , 1, 3},
                {},
                {7},
                {5, 2, 5, 2, 1, 1},
                {1 , 2, 3, 4, 5},
                {5 , 4, 3, 2, 1}
        };
        for (int i = 0; i < tests.length; i++){
            int[] array = tests[i].clone();
            int[] expected = tests[i].clone();

            Arrays.sort(expected);

            QuickSorter sorter = new QuickSorter();
            sorter.sort(array);

            if(Arrays.equals(array , expected)){
                System.out.println("QuickSort test " + (i+1) + " passed");
            }
            else{
                System.out.println("QuickSort test " + (i+1) + " failed");
            }
        }
        System.out.println();
    }
    public static void testDeterministicSelector(){
        Random random = new Random();
        for(int t = 0; t<100; t++){
            int[] array = new int[20];

            for(int i = 0; i< array.length; i++){
                array[i] = random.nextInt(100);
            }
            int[] expected = array.clone();

            Arrays.sort(expected);
            int k = random.nextInt(array.length);
            DeterministicSelector selector = new DeterministicSelector();
            int result = selector.select(array, k);

            if(result != expected[k]){
                System.out.println("Deterministic Select test failed");
                return;
            }
        }
        System.out.println("Deterministic Select: 100 tests passed");
    }
}