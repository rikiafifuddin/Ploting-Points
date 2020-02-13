# Ploting Points
 Ploting points, finding nearest and farthes, and ploting on Scatter graph using Java and Java FX
 
Tools 
Netbean 8.1 or Other (support JavaFX)

-Instalation (Point.Java)
1. Open Netbean
2. Creat New Project
3. Java > Java Application
4. Project Name : (example : Tugas)
5. aunmark "Creat Main Class" > Finish
6. Creat New Java Class > name: Point.java
7. Insert code (copy paste)"Point.java" at folder to Point.java in Netbean

- File Data Points
1. at Point.java Line 59 
	br=new BufferedReader(new FileReader("D:\\Kuliah\\Basisdata\\D2\\random 100k.csv")); 
	change "D:\\Kuliah\\Basisdata\\D2\\random 100k.csv" with your file location.

-Running
1. Run File
2. insert X coordinate > Enter
3. insert Y coordinate > Enter
4. Wait Result

-Result included 
Nearest Point From Coordinate with distance.
Farthest Point From Coordinate with Distance.
Estimation running time to obtain both result.
(screen shot IMG_Point.png)

-Instalation 2 (Ploting.Java)
1. make sure already have Point.java in packages
2. creat JavaFX main Class with (right clcik on package > new > JavaFX main Claass) or (right click on package >new > others >JavaFX > JavaFX Main Class)
3. class name: Ploting > Finish
4. Insert code (copy paste)"Ploting.java" at folder to Ploting.java in Netbean

-File Data Point
1. at Ploting.java Line 44 "br=new BufferedReader(new FileReader("D:\\Kuliah\\Basisdata\\test.csv"))"
	change file location with your "D:\\Kuliah\\Basisdata\\test.csv" 
	Note: if using 100k data take long time to process, recomended using data provided test1k.csv, if need small data use test20.csv so point will show correctly (that mean you can see the different)

-Runing
1. Run File Ploting.java
2. input X coordinate > Enter
3. input Y coordinate > Enter
4. Wait result
5. you will see Scatter Graph From Point.

-Result Included
 Graph Ploting Point, Coordinate, Nearest Point with Distance, Farthest Point with Distance, Ploting Point Estimation Time and Estimation running time to obtain both result.
 Screen Shot (IMG_Ploting 1k Points.PNG) this using data Test1k.csv
 Screen Shot (IMG_Ploting 20 Points.PNG) this using data Test20.csv
 Note: Sorry we do not use 100k point because this take very long time to ploting on graph (but we use 100k points data in Point.java to compleate our task)


