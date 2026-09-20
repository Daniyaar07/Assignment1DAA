import java.util.Random;
public class Experiment {
    public static void main(String[] args){
        int[] sizes = {100 , 1000 , 10000};
        Random random = new Random();
        for(int s = 0; s < sizes.length; s++){
            int size = sizes[s];
            int[] array1 = new int[size];
            int[] array2 = new int[size];

            for(int i = 0; i < size; i++){
                int num = random.nextInt(10000);
                array1[i] = num;
                array2[i] = num;
            }
            MergeSorter mergeSorter = new MergeSorter();
            long start = System.nanoTime();
            mergeSorter.sort(array1);
            long time = System.nanoTime() - start;

            System.out.println("Size: " + size);
            System.out.println("MergeSort time: " + time);
            System.out.println("Comparisons: " + mergeSorter.getComparisons());
            System.out.println("Max depth: " + mergeSorter.getMaxDepth());

            QuickSorter quickSorter = new QuickSorter();
            start = System.nanoTime();
            quickSorter.sort(array2);
            time = System.nanoTime() - start;

            System.out.println("QuickSort time: " + time);
            System.out.println("Comparisons: " + quickSorter.getComparisons());
            System.out.println("Max depth: " + quickSorter.getMaxDepth());

            int[] array3 = new int[size];
            for(int i = 0; i < size; i++){
                array3[i] = random.nextInt(10000);
            }
            DeterministicSelector selector = new DeterministicSelector();
            int k = size / 2;
            long startSelect = System.nanoTime();
            int result = selector.select(array3 , k);
            long selectTime = System.nanoTime() - startSelect;

            System.out.println("Deterministic Select time: " + selectTime);
            System.out.println("Result: " + result);
            System.out.println("Comparisons: " + selector.getComparisons());
            System.out.println("Max Depth: " + selector.getMaxDepth());


            Point[] points = new Point[size];
            for(int i = 0; i < size; i++){
                points[i] = new Point(random.nextInt(10000), random.nextInt(10000) );
            }
            ClosestPairSolver closestPair = new ClosestPairSolver();
            long startClosest = System.nanoTime();
            double closestResult = closestPair.findClosest(points);
            long closestTime = System.nanoTime() - startClosest;

            System.out.println("Closest Pair time: " + closestTime );
            System.out.println("Distance: " + closestResult);
            System.out.println("Comparisons: " + closestPair.getComparisons());
            System.out.println("Max Depth: " + closestPair.getMaxDepth());

            System.out.println("--------------------------");
        }
    }
}
