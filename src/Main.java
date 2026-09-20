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
        System.out.println("Comparisons:" + quickSorter.getComparisons());
        System.out.println("Max depth:" + quickSorter.getMaxDepth());

        int[] numbers3= {7 , 2 ,9 , 1 , 3};
        DeterministicSelector selector = new DeterministicSelector();
        int result = selector.select(numbers3, 2);
        System.out.println("Deterministic Select:");
        System.out.println("Result: " + result);
        System.out.println("Comparisons: " + selector.getComparisons());
        System.out.println("Max Depth: " + selector.getMaxDepth());

        Point[] points = {
                new Point(1, 1),
                new Point(2, 2),
                new Point(5 ,5),
                new Point(8 , 8)
        };
        ClosestPairSolver closestPair = new ClosestPairSolver();
        double closestDistance = closestPair.findClosest(points);
        System.out.println("Closest Pair:");
        System.out.println("Distance: " + closestDistance);
        System.out.println("Comparisons: " + closestPair.getComparisons());
        System.out.println("Max depth: " + closestPair.getMaxDepth());
    }
}
