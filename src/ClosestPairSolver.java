import java.util.Arrays;
import java.util.Comparator;
public class ClosestPairSolver {
    private int comparisons = 0;
    private int maxDepth = 0;
    public double findClosest(Point[]  points){
        comparisons = 0;
        maxDepth = 0;
        Point[] pointsByX = points.clone();
        Point[] pointsByY = points.clone();
        Arrays.sort(pointsByX, new Comparator<Point>() {
            public int compare(Point a , Point b){
                return Double.compare(a.x , b.x);
            }
        });
        Arrays.sort(pointsByY, new Comparator<Point>() {
            public int compare(Point a , Point b){
                return Double.compare(a.y , b.y);
            }
        });
        return closest(pointsByX , pointsByY , 1);
    }
    private double closest(Point[] pointsByX , Point[] pointsByY , int depth){
        if(depth > maxDepth){
            maxDepth = depth;
        }
        int n = pointsByX.length;
        if(n<= 3){
            return bruteForce(pointsByX);
        }
        int middle = n / 2;
        Point middlePoint = pointsByX[middle];
        Point[] leftX = Arrays.copyOfRange(pointsByX , 0 , middle);
        Point[] rightX = Arrays.copyOfRange(pointsByX , middle , n);

        Point[] leftY = new Point[leftX.length];
        Point[] rightY = new Point[rightX.length];

        int leftCount = 0;
        int rightCount = 0;

        for(int i = 0; i < pointsByY.length; i++){
            boolean found = false;
            for(int j = 0; j< leftX.length; j++){
                if (pointsByY[i] == leftX[j]){
                    found = true;
                    break;
                }
            }
            if(found){
                leftY[leftCount] = pointsByY[i];
                leftCount++;
            }
            else{
                rightY[rightCount] = pointsByY[i];
                rightCount++;
            }
        }
        double leftDistance = closest(leftX , leftY , depth +1);
        double rightDistance = closest(rightX , rightY , depth + 1);

        double minDistance = Math.min(leftDistance , rightDistance);
        Point[] strip = new Point[n];
        int count = 0;

        for(int i = 0; i< pointsByY.length; i++){
            if(Math.abs(pointsByY[i].x - middlePoint.x) < minDistance){
                strip[count] = pointsByY[i];
                count++;
            }
        }
        for(int i = 0; i < count; i++){
            for(int j = i+1 ; j < count; j++){
                if(strip[j].y - strip[i].y >= minDistance){
                    break;
                }
                comparisons++;
                double distance = distance(strip[i] , strip[j]);
                if (distance < minDistance){
                    minDistance = distance;
                }
            }
        }
        return minDistance;
    }

    private double bruteForce(Point[] points){
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i< points.length; i++){
            for(int j = i+1;  j< points.length; j++){
                comparisons ++;
                double distance = distance(points[i] , points[j]);
                if(distance < minDistance){
                    minDistance = distance;
                }
            }
        }
        return minDistance;
    }
    private double distance(Point a, Point b){
        double x = a.x - b.x;
        double y = a.y - b.y;
        return Math.sqrt(x * x + y * y);
    }
    public int getComparisons(){
        return comparisons;
    }
    public int getMaxDepth(){
        return maxDepth;
    }
}
