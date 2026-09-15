import java.util.Random;
public class QuickSorter {
    Random random = new Random();
    public void sort(int[] array){
        quickSort(array, 0 , array.length - 1);
    }
    private void quickSort(int[] array , int left ,int right){
        if(left>= right){
            return;
        }
        int randomIndex = left + random.nextInt(right - left + 1);
        int temp = array[randomIndex];
        array[randomIndex] = array[right];
        array[right] = temp;
        int pivotIndex = partition(array , left ,right);
        quickSort(array , left , pivotIndex - 1);
        quickSort(array , pivotIndex + 1 , right);
    }
    private int partition(int[] array , int left , int right){
        int pivot = array[right];
        int i = left;
        for(int j = left; j<right; j++){
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
}
