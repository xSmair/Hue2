package Uebung3;

import com.google.common.math.IntMath;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NumberTester {

    private int numberOfTests;
    private Map<Integer, Integer> numbers = new HashMap<>();
    private int currentNumber;

    public NumberTester(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
            String line = br.readLine();
            numberOfTests = Integer.parseInt(line);
            line = br.readLine();
            while (line != null) {
                String[] splitted = line.split(" ");
                numbers.put(Integer.parseInt(splitted[1]), Integer.parseInt(splitted[0]));
                line = br.readLine();
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(NumberTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setOddEvenTester(NumberTest oddTester) {
        if (oddTester.testNumber(currentNumber)) {
            System.out.println(currentNumber + " is EVEN");
        } else {
            System.out.println(currentNumber + " is ODD");
        }

    }

    public void setPrimeTester(NumberTest primeTester) {
        if (primeTester.testNumber(currentNumber)) {
            System.out.println(currentNumber + " is PRIME");
        } else {
            System.out.println(currentNumber + " is NO PRIME");
        }
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        if (palindromeTester.testNumber(currentNumber)) {
            System.out.println(currentNumber + " is PALINDROME");
        } else {
            System.out.println(currentNumber + " is NO PALINDROME");
        }
    }

    public void testFile() {
        numbers.keySet().forEach(key -> {
            if (null != numbers.get(key)) {
                switch (numbers.get(key)) {
                    case 1:
                        currentNumber = key;
                        setOddEvenTester(number -> number % 2 == 0);
                        break;
                    case 2:
                        currentNumber = key;
                        setPrimeTester(number -> IntMath.isPrime(number));
                        break;
                    case 3:
                        currentNumber = key;
                        setPalindromeTester(number -> {
                            String numberStr = String.valueOf(number);
                            String reversedNumber = "";
                            for (int i = numberStr.length() - 1; i >= 0; i--) {
                                reversedNumber += numberStr.charAt(i);
                            }
                            return reversedNumber.equals(numberStr);
                        });
                    default:
                        break;
                }
            }
        });
    }
}


