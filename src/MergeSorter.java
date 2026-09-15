public class MergeSorter {
    public static final int cutoff = 10;
    private int comparisons = 0;
    private int maxDepth = 0;
    public void sort(int[] array){
        comparisons = 0;
        maxDepth = 0;
        int[] temp = new int[array.length];
        mergeSort(array, temp , 0 , array.length - 1, 1);
    }
    private void mergeSort(int[]  array , int [] temp , int left, int right , int depth){
        if(depth > maxDepth){
            maxDepth = depth;
        }
        if (left >= right){
            return;
        }
        if(right - left + 1 <= cutoff){
            insertionSort(array, left ,right);
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(array , temp , left , middle , depth + 1);
        mergeSort(array , temp ,middle + 1 , right , depth +1);
        merge(array , temp , left , middle , right);
    }
    private void merge(int[] array , int[] temp , int left , int middle , int right){
        int i = left;
        int j = middle + 1;
        int k = left;
        while (i<= middle && j<= right){
            comparisons++;
            if(array[i] <= array[j]){
                temp[k] = array[i];
                i++;
            }else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }
        while (i <=middle){
            temp[k] =array[i];
            i++;
            k++;
        }
        while (j <=right){
            temp[k] = array[j];
            j++;
            k++;
        }
        for (int x =left; x <=right; x++){
            array[x] = temp[x];
        }
    }
    private void insertionSort(int[] array , int left , int right){
        for (int i = left + 1; i <= right; i++){
            int key = array[i];
            int j = i - 1;
            while (j>=left ){
                comparisons ++;
                if (array[j] <= key){
                    break;
                }
                array[j + 1] = array[j];
                j --;
            }
            array[j+1] = key;
        }
    }
    public int getComparisons(){
        return comparisons;
    }
    public int getMaxDepth(){
        return maxDepth;
    }
}