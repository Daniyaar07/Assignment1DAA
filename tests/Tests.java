import java.util.Arrays;
import java.util.Random;

public class Tests {
    public static void main(String[] args) {
        testMergeSort();
        testQuickSort();
        testDeterministicSelector();
        testClosestPair();
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
    public static void testClosestPair(){
        Point[] points = {
                new Point(1 , 1),
                new Point(2 , 2),
                new Point(5 , 5),
                new Point(8 , 8)
        };
        ClosestPairSolver solver = new ClosestPairSolver();
        double result = solver.findClosest(points);
        double bruteResult = bruteForce(points);

        if(result == bruteResult){
            System.out.println("Closest Pair test passed");
        }
        else{
            System.out.println("Closest Pair test failed");
        }
    }
    public static double bruteForce(Point[] points){
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i< points.length; i++){
            for (int j = i+ 1 ; j < points.length; j++){
                double x = points[i].x - points[j].x;
                double y = points[i].y - points[j].y;

                double distance = Math.sqrt(x*x + y*y);
                if (distance < minDistance){
                    minDistance = distance;
                }
            }
        }
        return minDistance;
    }
}