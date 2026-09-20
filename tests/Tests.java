import java.util.Arrays;
public class Tests {
    public static void main(String[] args) {
        testMergeSort();
        testQuickSort();
    }

    public static void testMergeSort() {
        int[][] tests = {
                {5, 2, 8 , 1, 3},
                {},
                {7},
                {5, 2, 5, 2, 1, 1}
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
                {5, 2, 5, 2, 1, 1}
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
    }
}