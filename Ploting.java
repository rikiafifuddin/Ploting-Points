import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class Ploting extends Application {
    @Override 
    public void start(Stage stage) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("enter your x Coordinate :: ");
        double X1= s.nextDouble();
        System.out.println("enter your Y Coordinate :: ");
        double Y1= s.nextDouble();
        double[] coordinate = {X1,Y1};
        
        stage.setTitle("Scatter Chart");
        final NumberAxis xAxis = new NumberAxis(-5, 5, 1); //Change Value For X  Example: (Xstart,XEnd,Range) = (-90,90,5)
        final NumberAxis yAxis = new NumberAxis(-5, 5, 1); //Change Value For Y Example: (Ystart,YEnd,Range) = (-180,180,10)     
        final ScatterChart<Number,Number> sc = new ScatterChart<Number,Number>(xAxis,yAxis);
        xAxis.setLabel("X");                
        yAxis.setLabel("Y");
        sc.setTitle("Mapping Point and Coordinate");
        
    final long startTimePoints = System.currentTimeMillis();
        //Read CSV FILE and Ploting point on graph
        BufferedReader br;
        String line;
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Points");
        final int X = 0;
        final int Y = 1;
        double[][] points = new double[100000][2];
        try {
            br=new BufferedReader(new FileReader("D:\\Kuliah\\Basisdata\\test.csv")); //recomended use test file(reduce points) in case ploting 100k points take too long
            int i=1;
            while((line=br.readLine())!=null){
                String[] point=line.split(";");
                double x = Double.parseDouble(point[0]);
                double y = Double.parseDouble(point[1]);
                points [i][X] = x;
                points [i][Y] = y;
                series1.getData().add(new XYChart.Data(x, y));
                i++; 
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    final long endTimePoints = System.currentTimeMillis();
        //ploting coordinate on graph
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Coordinate Input ("+X1+ "; "+Y1+")");
        series2.getData().add(new XYChart.Data(X1, Y1));
    
    final long startTimeFind = System.currentTimeMillis();
        //Marking Nearest Point
        double[] closest = Point.nearestPoint(coordinate, points); 
        double CDistance = Point.distance(coordinate[X], coordinate[Y], closest[X], closest[Y]);
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Nearest Point ("+closest[X]+"; "+closest[Y]+") Distance = "+CDistance+"   ");
        series3.getData().add(new XYChart.Data(closest[X],closest[Y])); 
         
        //Marking Farthest Point
        double[] mostfar = Point.farthestPoint(coordinate, points);
        double FDistance = Point.distance(coordinate[X], coordinate[Y], mostfar[X], mostfar[Y]);
        XYChart.Series series4 = new XYChart.Series();
        series4.setName("Farthest Point ("+mostfar[X]+"; "+mostfar[Y]+") Distance = "+FDistance+"  ");
        series4.getData().add(new XYChart.Data(mostfar[X], mostfar[Y]));
    final long endTimeFind = System.currentTimeMillis();   
        
        //Label For Time estimation
        XYChart.Series series5 = new XYChart.Series();
        XYChart.Series series6 = new XYChart.Series();
        series5.setName("! Ploting Points Time Estimation = "+(endTimePoints - startTimePoints)+ "ms");
        series6.setName("! Finding Nearest and Farthest Point Time Estimation = "+(endTimeFind - startTimeFind)+ "ms");
        
        Scene scene  = new Scene(sc, 300, 250);
        sc.getData().addAll(series1,series2,series3, series4, series5, series6); 
        stage.setScene(scene);
        stage.show();   
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}