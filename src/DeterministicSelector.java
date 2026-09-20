import java.util.Arrays;
public class DeterministicSelector {
    private int comparisons = 0;
    private int maxDepth = 0;
    public int select(int[] array , int k){
        comparisons = 0;
        maxDepth = 0;
        return select(array, 0 , array.length - 1, k , 1);
    }
    private int select(int[] array , int left , int right , int k , int depth){
        if(depth > maxDepth){
            maxDepth = depth;
        }

        if (left == right){
            return array[left];
        }
        int pivot = getPivot(array , left, right , depth);
        int pivotIndex = partition(array , left , right , pivot);
        if (k== pivotIndex){
            return array[k];
        }
        if (k < pivotIndex){
            return select(array , left , pivotIndex - 1, k , depth + 1);
        }
        else {
            return select(array , pivotIndex + 1 , right , k , depth + 1);
        }
    }
    private int getPivot(int[] array , int left , int right , int depth){
        int size = right - left + 1;
        if(size <= 5){
            Arrays.sort(array , left , right + 1);
            return array[left + size / 2];
        }
        int medianCount = 0;
        for (int i = left; i <=right; i+= 5){
            int end = Math.min(i + 4 , right);
            Arrays.sort(array , i ,end + 1);
            int medianIndex = i+ (end - i) / 2;
            int temp = array[left + medianCount];
            array[left + medianCount] = array[medianIndex];
            array[medianIndex] = temp;
            medianCount++;
        }
        return select(array , left, left + medianCount - 1, left + medianCount/2 , depth + 1);
    }
    private int partition(int[] array , int left , int right , int pivot){
        int pivotIndex = left;
        for (int i = left ; i<=right ; i++){
            comparisons++;
            if(array[i] == pivot){
                pivotIndex = i;
                break;
            }
        }
        int temp = array[pivotIndex];
        array[pivotIndex] = array[right];
        array[right] = temp;
        int i = left;
        for (int j = left; j < right; j++){
            comparisons++;
            if (array[j] < pivot){
                temp = array[i];
                array[i] = array[j];
                array[j] =temp;
                i++;
            }
        }
        temp = array[i];
        array[i] = array[right];
        array[right] =temp;
        return i;
    }
    public int getComparisons(){
        return comparisons;
    }
    public int getMaxDepth(){
        return maxDepth;
    }
}
