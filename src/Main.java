import java.util.Arrays;
public class Main {
    public static void main(String[] args){
        int[] numbers = {5, 2 ,8 , 1, 3};
        MergeSorter sorter = new MergeSorter();
        sorter.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
