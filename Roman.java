import java.util.*;

public class RN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a Roman numeral: ");
        String romanNumeral = scanner.nextLine().toUpperCase();

        int result = romanToInteger(romanNumeral);
        
        System.out.println("Integer equivalent: " + result);

        scanner.close();
    }

    public static int romanToInteger(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int currentNum = romanMap.get(s.charAt(i));
            int nextNum = (i + 1 < s.length()) ? romanMap.get(s.charAt(i + 1)) : 0;

            if (currentNum < nextNum) {
                result += (nextNum - currentNum);
                i++; 
            } else {
                result += currentNum;
            }
        }

        return result;
    }
}
