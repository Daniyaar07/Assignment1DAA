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
        }
    }
}
