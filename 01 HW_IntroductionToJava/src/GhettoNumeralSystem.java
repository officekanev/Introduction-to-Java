import java.util.Scanner;

//           Problem 7.	*Ghetto Numeral System
// Write a program that converts the decimal number system to the ghetto numeral system. 
//In the ghetto, numbers are represented as following:
// 0 - Gee; 1-Bro; 2--Zuz; 3-Ma; 4-Duh; 5-Yo; 6-Dis; 7-Hood; 8-Jam; 9-Mack;
//Input	Output
//6781	DisHoodJamBro
//9374	MackMaHoodDuh
//533	    YoMaMa
//102	    BroGeeZuz

public class GhettoNumeralSystem {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		String rezult = "";
		for (int i = 0; i < input.length(); i++) {		
			int num = Character.getNumericValue(input.charAt(i));
			switch (num) {
			case 0 : rezult += "Gee";break;
			case 1 : rezult += "Bro";break;
			case 2 : rezult += "Zuz";break;
			case 3 : rezult += "Ma";break;
			case 4 : rezult += "Duh";break;
			case 5 : rezult += "Yo";break;
			case 6 : rezult += "Dis";break;
			case 7 : rezult += "Hood";break;
			case 8 : rezult += "Jam";break;
			case 9 : rezult += "Mack";break;				
			default:
				break;
			}
		}
		System.out.println(rezult);
	}
}
