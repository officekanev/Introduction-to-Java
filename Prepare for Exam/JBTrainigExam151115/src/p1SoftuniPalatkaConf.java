import java.util.Scanner;

public class p1SoftuniPalatkaConf {
public static void main(String[] args) {
//	Scanner scan = new Scanner(System.in);                         // 70 point
//	int comePeple = Integer.parseInt(scan.nextLine());
//	int inputLines = Integer.parseInt(scan.nextLine());
//	int countAllRooms = 0;
//	int countPortionFoods = 0;
//	for (int i = 0; i < inputLines; i++) {
//		String[] line = scan.nextLine().split("[ ]+");
//		if (line[0].contains("tents")) {
//			if (line[2].contains("firstClass")) {
//				countAllRooms += Integer.parseInt(line[1]) * 3;
//			}else {
//				countAllRooms += Integer.parseInt(line[1]) * 2;
//			}
//		}else if (line[0].contains("rooms")) {
//			if (line[2].contains("triple")) {
//				countAllRooms += Integer.parseInt(line[1]) * 3;
//			}else if (line[2].contains("double")) {
//				countAllRooms += Integer.parseInt(line[1]) * 2;
//			}else if (line[2].contains("single")) {
//				countAllRooms += Integer.parseInt(line[1]);
//			}
//			
//		}else if (line[0].contains("food")) {
//			if (line[2].contains("zakuska")) {
//				countPortionFoods = 0;
//			}else {
//				countPortionFoods += Integer.parseInt(line[1]) * 2;
//			}
//		}
//	}
//	scan.close();
//	if (comePeple > countAllRooms) {
//		System.out.printf("Some people are freezing cold. Beds needed: %d\n",comePeple - countAllRooms);
//	}else {
//		System.out.printf("Everyone is happy and sleeping well. Beds left: %d\n", countAllRooms -comePeple);
//	}
//	if (comePeple > countPortionFoods) {
//		System.out.printf("People are starving. Meals needed: %d\n",comePeple - countPortionFoods);
//	}else {
//		System.out.printf("Nobody left hungry. Meals left: %d\n", countPortionFoods - comePeple);
//	}

	   //avt
	
    Scanner scn = new Scanner(System.in);

    int availableMeals = 0;
    int availableBeds = 0;

    int people = Integer.parseInt(scn.nextLine().trim());
    int N = Integer.parseInt(scn.nextLine().trim());

    for (int i = 1; i <= N; i++) {
        String[] lineArgs = scn.nextLine().trim().split("\\s+");
        switch (lineArgs[0]) {
            case "rooms":
                String roomType = lineArgs[2];
                int numberOfRooms = Integer.parseInt(lineArgs[1]);
                if (roomType.equals("single"))
                    availableBeds += numberOfRooms;
                if (roomType.equals("double"))
                    availableBeds += numberOfRooms * 2;
                if (roomType.equals("triple"))
                    availableBeds += numberOfRooms * 3;
                break;
            case "tents":
                String tentType = lineArgs[2];
                int numberOfTents = Integer.parseInt(lineArgs[1]);
                if (tentType.equals("firstClass"))
                    availableBeds += numberOfTents * 3;
                if (tentType.equals("normal"))
                    availableBeds += numberOfTents * 2;
                break;
            case "food":
            default:
                String mealType = lineArgs[2];
                int numberOfMeals = Integer.parseInt(lineArgs[1]);
                if (mealType.equals("musaka"))
                    availableMeals += numberOfMeals * 2;
                break;
        }
    }
     scn.close();
    if (availableBeds >= people) {
        System.out.println("Everyone is happy and sleeping well. Beds left: " + (availableBeds - people));
    } else {
        System.out.println("Some people are freezing cold. Beds needed: " + (people - availableBeds));
    }
    if (availableMeals >= people) {
        System.out.println("Nobody left hungry. Meals left: " + (availableMeals - people));
    } else {
        System.out.println("People are starving. Meals needed: " + (people - availableMeals));
    }
 }
}








