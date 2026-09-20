import java.util.Arrays;
import java.util.Comparator;
public class ClosestPairSolver {
    public double findClosest(Point[]  points){
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
        return closest(pointsByX , pointsByY);
    }
    private double closest(Point[] pointsByX , Point[] pointsByY){
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
            if(pointsByY[i].x < middlePoint.x && leftCount < leftY.length){
                leftY[leftCount] = pointsByY[i];
                leftCount++;
            }
            else{
                rightY[rightCount] = pointsByY[i];
                rightCount++;
            }
        }
        double leftDistance = closest(leftX , leftY);
        double rightDistance = closest(rightX , rightY);

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
}
