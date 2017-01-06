import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//                                                        Problem 1 – Dragon Sharp
//Now that you are an experienced programmer, you decide to create your own programming language. Since you are a nerd and really
//love dragons and C#, you name your language Dragon Sharp, or D#. Funny thing about the language is that the compiler is written
//in Java, since Java is such fun. You need to polish it a bit, though. It does not process condition statements correctly.
//Let’s take a look at the statement if (5==5) loop 3 out “gosho”; 
//The condition is true so you print gosho three times on a new line. There can be an “else” statement such as else out "pesho";
//In that case, you print pesho only if the if statement on the previous line was false. There won’t be an else statement 
//following another else statement in the input.
//There will always be a single space separating other elements. There are only four types of valid statement:
//if (5==5) loop 3 out “gosho”;	    else out "pesho";    if (5==5) out “gosho”;	    else loop 3 out "pesho";  
//Invalid: if the statement is not terminated with a semicolon “;” or the string in not enclosed with quotes “”.
//If you encounter invalid input you should print Compile time error @ line {line number} and nothing else
//Lines are numbered starting from 1.
//Input
//•	On the first line you receive the integer N -> the number of lines that will follow
//•	On each of the next N lines you will receive a statement in one of the above described formats
//Output
//•	Each of the statement outputs is on a separate line.
//•	If an error is encountered, only the error message is printed. All other output is discarded.
//Constraints
//•	The number N is an integer between 1 and 50.
//•	The number of loop repetitions is an integer is between 0 and 10.
//•	There can only be integers and >, < or == in the condition brackets.
//•	There can be ANY character between the string quotes (“”).
//•	Allowed working time for your program: 0.25s
//•	Allowed memory: 16 MB
//Examples
//Input	                                   Output                Input	                                     Output
//3                                      zdr ko staa              3                                     zdr ko staa
//if (5==5) loop 2 out "zdr ko staa";    zdr ko staa        if (5==5) loop 2 out "zdr ko staa";         zdr ko staa
//if (11<8) out "nishto super e";        abe mani           if (11>8) out "nishto super e";             nishto super e
//else loop 3 out "abe mani";	         abe mani           else loop 3 out "abe mani";
//                                       abe mani

//Input                                             	Output
//2                                             Compile time error @ line 2
//if (8==8) loop 2 out "lolol";
//else out mega greshka;	
public class p1DragonSharp {
    private static ArrayList<String> outputList;
    private static String[] matchTokens;

    public static void main(String[] args) {
        outputList = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        int n = Integer.parseInt(scn.nextLine());
        String pattern = "(.+?)\"(.+?)\";";

    Pattern pat = Pattern.compile(pattern);

    Boolean expectsElse = false;
    Boolean isCompileError = false;
    int errorLine = 0;

    for (int i = 1; i <= n && !isCompileError; i++) {
        String line = scn.nextLine();
        Matcher match = pat.matcher(line);

        if (match.find()) {
            matchTokens = match.group(1).trim().split("\\s+");
            String output = match.group(2);

            if (matchTokens[0].equals("if")) {
                if (evaluateCondition(matchTokens[1])) {
                    processCommand(output, false);
                    expectsElse = false;
                } else {
                    expectsElse = true;
                }
            } else if (matchTokens[0].equals("else") && expectsElse) {
                processCommand(output, true);
            }
        } else {
            isCompileError = true;
            errorLine = i;
        }
    }

    if (isCompileError) {
        System.out.println("Compile time error @ line " + errorLine);
    } else {
        for (String line : outputList) {
            System.out.println(line);
        }
    }
    scn.close();
}

private static boolean evaluateCondition(String condition) {
    condition = condition.substring(1, condition.length() - 1);
    String[] conditionDigits = condition.split("[><=]+");

    int left = Integer.parseInt(conditionDigits[0]);
    int right = Integer.parseInt(conditionDigits[1]);
    String operator = condition.replaceAll("\\d+", "");

    boolean result;
    switch (operator) {
        case "==": result = left == right; break;
        case ">": result = left > right; break;
        case "<": result = left < right; break;
        default: result = false;
    }

    return result;
}

private static void processCommand(String output, boolean isElse) {
    int loopIndex = isElse ? 1 : 2;
    boolean isLoop = matchTokens[loopIndex].equals("loop");
    int repetitions = isLoop ? Integer.parseInt(matchTokens[loopIndex + 1]) : 1;

    for (int i = 1; i <= repetitions; i++) {
        outputList.add(output);
    }
}
}
























