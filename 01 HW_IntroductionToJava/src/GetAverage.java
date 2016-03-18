//            Problem 8.	**Get Average
//Create a method that finds the average of three numbers. Read in internet about java methods.
//Check the naming conventions. Invoke your method and test it. Format the output to two digits
//after the decimal separator. The placeholder is %.2f
//           a	          b	            c	         Average
//           1.5	      2.5	        3.8	          2.60
//           12	          13	        25	          16.67
//           0.005	      0.5	        0.55	      0.35
//           0	          0	            2	          0.67
public class GetAverage {
  public static void main(String[] args) {
	double[] valueNumberA = {1.5,12,0.005,0};
	double[] valueNumberB = {2.5,13,0.5,0};
	double[] valueNumberC = {3.8,25,0.55,2};
	for (int i = 0; i < valueNumberC.length; i++) {
		double a = valueNumberA[i];
		double b = valueNumberB[i];
		double c = valueNumberC[i];
		double rezult = calculateAverage(a, b, c);
		System.out.printf("%.2f",rezult);
		System.out.println();
	}
  }
  
  public static double calculateAverage(double a, double b, double c){
	  double rezult = 0;
	  rezult = (a + b + c) / 3;
	  return rezult;
  }
}
