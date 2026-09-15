import java.util.Random;
public class QuickSorter {
    Random random = new Random();
    private int comparisons = 0;
    private int maxDepth = 0;
    public void sort(int[] array){
        comparisons = 0;
        maxDepth = 0;
        quickSort(array, 0 , array.length - 1 , 1);
    }
    private void quickSort(int[] array , int left ,int right , int depth){
        if (depth > maxDepth){
            maxDepth = depth;
        }
        while (left < right){
            int randomIndex = left + random.nextInt(right - left + 1);
            int temp = array[randomIndex];
            array[randomIndex] = array[right];
            array[right] = temp;
            int pivotIndex = partition(array, left , right);
            if(pivotIndex - left < right - pivotIndex){
                quickSort(array, left, pivotIndex - 1 , depth +1);
                left = pivotIndex + 1;
            }
            else{
                quickSort(array , pivotIndex + 1 , right , depth + 1);
                right = pivotIndex - 1;
            }
        }
    }
    private int partition(int[] array , int left , int right){
        int pivot = array[right];
        int i = left;
        for(int j = left; j<right; j++){
            comparisons ++;
            if(array[j] < pivot){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        int temp = array[i];
        array[i] = array[right];
        array[right] = temp;
        return i;
    }
    public int getComparisons(){
        return comparisons;
    }
    public int getMaxDepth(){
        return maxDepth;
    }
}
