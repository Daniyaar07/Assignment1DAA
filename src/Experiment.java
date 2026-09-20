import java.util.Random;
import java.util.Arrays;
import java.io.PrintWriter;
public class Experiment {
    public static void main(String[] args){
        int[] sizes = {100 , 1000 , 10000};
        Random random = new Random();
        try {
            PrintWriter writer = new PrintWriter("results/results.csv");
            writer.println("Algorithm , InputType , Size , Time , Comparisons , MaxDepth");

            for (int s = 0; s < sizes.length; s++) {
                int size = sizes[s];
                int[] array1 = new int[size];
                int[] array2 = new int[size];

                for (int i = 0; i < size; i++) {
                    int num = random.nextInt(10000);
                    array1[i] = num;
                    array2[i] = num;
                }

                int[] sorted1 = array1.clone();
                int[] sorted2 = array2.clone();

                Arrays.sort(sorted1);
                Arrays.sort(sorted2);

                int[] reverse1 = sorted1.clone();
                int[] reverse2 = sorted2.clone();

                for (int i = 0; i < size / 2; i++) {
                    int temp = reverse1[i];
                    reverse1[i] = reverse1[size - 1 - i];
                    reverse1[size - 1 - i] = temp;

                    temp = reverse2[i];
                    reverse2[i] = reverse2[size - 1 - i];
                    reverse2[size - 1 - i] = temp;
                }
                int[] duplicate1 = new int[size];
                int[] duplicate2 = new int[size];

                for (int i = 0; i < size; i++) {
                    int num = random.nextInt(10);
                    duplicate1[i] = num;
                    duplicate2[i] = num;
                }
                System.out.println();
                System.out.println("-----Size: " + size + "-----");

                System.out.println();
                System.out.println("---Random---");
                MergeSorter mergeSorter = new MergeSorter();
                long start = System.nanoTime();
                mergeSorter.sort(array1);
                long time = System.nanoTime() - start;

                System.out.println("Random MergeSort time: " + time);
                System.out.println("Comparisons: " + mergeSorter.getComparisons());
                System.out.println("Max depth: " + mergeSorter.getMaxDepth());

                writer.println(
                        "MergeSort , Random, " + size + "," + time + "," +
                                mergeSorter.getComparisons() + "," + mergeSorter.getMaxDepth()
                );

                QuickSorter quickSorter = new QuickSorter();
                start = System.nanoTime();
                quickSorter.sort(array2);
                time = System.nanoTime() - start;

                System.out.println("Random QuickSort time: " + time);
                System.out.println("Comparisons: " + quickSorter.getComparisons());
                System.out.println("Max depth: " + quickSorter.getMaxDepth());

                writer.println(
                        "QuickSort , Random, " + size + "," + time + "," +
                                quickSorter.getComparisons() + "," + quickSorter.getMaxDepth()
                );
                System.out.println();
                System.out.println("---Sorted---");

                MergeSorter mergeSorted = new MergeSorter();
                start = System.nanoTime();
                mergeSorted.sort(sorted1);
                time = System.nanoTime() - start;

                System.out.println("Sorted MergeSort time: " + time);
                System.out.println("Comparisons: " + mergeSorted.getComparisons());
                System.out.println("Max depth: " + mergeSorted.getMaxDepth());

                writer.println(
                        "MergeSort , Sorted, " + size + "," + time + "," +
                                mergeSorted.getComparisons() + "," + mergeSorted.getMaxDepth()
                );

                QuickSorter quickSorted = new QuickSorter();
                start = System.nanoTime();
                quickSorted.sort(sorted2);
                time = System.nanoTime() - start;

                System.out.println("Sorted QuickSort time: " + time);
                System.out.println("Comparisons: " + quickSorted.getComparisons());
                System.out.println("Max depth: " + quickSorted.getMaxDepth());

                writer.println(
                        "QuickSort , Sorted, " + size + "," + time + "," +
                                quickSorted.getComparisons() + "," + quickSorted.getMaxDepth()
                );

                System.out.println();
                System.out.println("---Reverse---");

                MergeSorter mergeReverse = new MergeSorter();
                start = System.nanoTime();
                mergeReverse.sort(reverse1);
                time = System.nanoTime() - start;

                System.out.println("Reverse MergeSort time: " + time);
                System.out.println("Comparisons: " + mergeReverse.getComparisons());
                System.out.println("Max depth: " + mergeReverse.getMaxDepth());

                writer.println(
                        "MergeSort , Reverse, " + size + "," + time + "," +
                                mergeReverse.getComparisons() + "," + mergeReverse.getMaxDepth()
                );

                QuickSorter quickReverse = new QuickSorter();
                start = System.nanoTime();
                quickReverse.sort(reverse2);
                time = System.nanoTime() - start;

                System.out.println("Reverse QuickSort time: " + time);
                System.out.println("Comparisons: " + quickReverse.getComparisons());
                System.out.println("Max depth: " + quickReverse.getMaxDepth());

                writer.println(
                        "QuickSort , Reverse, " + size + "," + time + "," +
                                quickReverse.getComparisons() + "," + quickReverse.getMaxDepth()
                );

                System.out.println();
                System.out.println("---Duplicate---");

                MergeSorter mergeDuplicate = new MergeSorter();
                start = System.nanoTime();
                mergeDuplicate.sort(duplicate1);
                time = System.nanoTime() - start;

                System.out.println("Duplicate MergeSort time: " + time);
                System.out.println("Comparisons: " + mergeDuplicate.getComparisons());
                System.out.println("Max depth: " + mergeDuplicate.getMaxDepth());

                writer.println(
                        "MergeSort , Duplicate, " + size + "," + time + "," +
                                mergeDuplicate.getComparisons() + "," + mergeDuplicate.getMaxDepth()
                );

                QuickSorter quickDuplicate = new QuickSorter();
                start = System.nanoTime();
                quickDuplicate.sort(duplicate2);
                time = System.nanoTime() - start;

                System.out.println("Duplicate QuickSort time: " + time);
                System.out.println("Comparisons: " + quickDuplicate.getComparisons());
                System.out.println("Max depth: " + quickDuplicate.getMaxDepth());

                writer.println(
                        "QuickSort , Duplicate, " + size + "," + time + "," +
                                quickDuplicate.getComparisons() + "," + quickDuplicate.getMaxDepth()
                );

                System.out.println();
                System.out.println("---Deterministic Select---");

                int[] array3 = new int[size];
                for (int i = 0; i < size; i++) {
                    array3[i] = random.nextInt(10000);
                }
                DeterministicSelector selector = new DeterministicSelector();
                int k = size / 2;
                long startSelect = System.nanoTime();
                int result = selector.select(array3, k);
                long selectTime = System.nanoTime() - startSelect;

                System.out.println("Deterministic Select time: " + selectTime);
                System.out.println("Result: " + result);
                System.out.println("Comparisons: " + selector.getComparisons());
                System.out.println("Max Depth: " + selector.getMaxDepth());

                writer.println(
                        "DeterministicSelect , Random, " + size + "," + selectTime + "," +
                                selector.getComparisons() + "," + selector.getMaxDepth()
                );

                System.out.println();
                System.out.println("---Closest Pair---");

                Point[] points = new Point[size];
                for (int i = 0; i < size; i++) {
                    points[i] = new Point(random.nextInt(10000), random.nextInt(10000));
                }
                ClosestPairSolver closestPair = new ClosestPairSolver();
                long startClosest = System.nanoTime();
                double closestResult = closestPair.findClosest(points);
                long closestTime = System.nanoTime() - startClosest;

                System.out.println("Closest Pair time: " + closestTime);
                System.out.println("Distance: " + closestResult);
                System.out.println("Comparisons: " + closestPair.getComparisons());
                System.out.println("Max Depth: " + closestPair.getMaxDepth());

                writer.println(
                        "ClosestPair , Random, " + size + "," + closestTime + "," +
                                closestPair.getComparisons() + "," + closestPair.getMaxDepth()
                );

                System.out.println();
                System.out.println("--------------------------");
            }
            writer.close();
        }catch (Exception e){
            System.out.println("Error creating CSV file");
        }
    }
}
