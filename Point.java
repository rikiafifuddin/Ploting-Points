import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author rikiafifuddin
 */
public class Point {
    
    public static double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }
    
    public static double[] nearestPoint(double[] coordinate, double [][] points){
        final int X = 0;
        final int Y = 1;
        double[] closestPoint = points[0];
        double closestDist =100;
        
        for (int i=0; i<points.length; i++){
            double DN = distance(coordinate[X], coordinate[Y], points[i][X], points[i][Y]);
            if (DN < closestDist && (points[i][X]!=0) && (points[i][Y]!=0)){
                closestDist = DN;
                closestPoint = points[i];
            }    
        }
    return closestPoint;    
    }
    
    public static double[] farthestPoint(double[] coordinate, double [][] points){
        final int X = 0;
        final int Y = 1;
        double[] farPoint = points[0];
        double fartherestDist = 0;
  
        for (int i=0; i<points.length; i++){
            double DF = distance (coordinate[X], coordinate[Y], points[i][X], points[i][Y]);
            if (DF> fartherestDist && (points[i][X]!=0) && (points[i][Y]!=0)){
                fartherestDist = DF;
                farPoint = points[i];
            }
        }
    return farPoint;
    }
    
    public static void main(String[] args){
        // this variable for read row and coloum.
        final int X = 0;
        final int Y = 1;
        
        //Read CSV FILE
        BufferedReader br;
        String line;
        double[][] points = new double[100000][2];
        try {
            br=new BufferedReader(new FileReader("D:\\Kuliah\\Basisdata\\D2\\random 100k.csv"));
            int i=0;
            while((line=br.readLine())!=null){
                String[] point=line.split(";");
                double x = Double.parseDouble(point[0]);
                double y = Double.parseDouble(point[1]);
                points [i][X] = x;
                points [i][Y] = y;
                //System.out.println(pointt[i][X] +" "+pointt[i][Y]);
                i++;  
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //Simple Test with some point
        //double[][] points ={{1, -2},
                            //{3, 4},
                            //{1, 1},
                            //{2, -4}
                            //};
        
        //Input X and Y coordinate
        Scanner s = new Scanner(System.in);
        System.out.println("enter your x Coordinate :: ");
        double X1= s.nextDouble();
        System.out.println("enter your Y Coordinate :: ");
        double Y1= s.nextDouble();
        double[] coordinate = {X1,Y1};
        
        //Main Program
    final long startTime = System.currentTimeMillis();
        double[] closest = nearestPoint(coordinate, points);
        double CDistance = distance(coordinate[X], coordinate[Y], closest[X], closest[Y]);
        System.out.println("Nearest Coordinate From Point");
        System.out.println("("+closest[X]+", "+closest[Y]+")");
        System.out.println("Distance = "+CDistance); 
        System.out.println("Farthest Coordinate From Point");
        double[] mostfar = farthestPoint(coordinate, points);
        double FDistance = distance(coordinate[X], coordinate[Y], mostfar[X], mostfar[Y]);
        System.out.println("("+mostfar[X]+", "+mostfar[Y]+")");
        System.out.println("Distance = "+FDistance);
    final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + " ms" );
    
    }
}
