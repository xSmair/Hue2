package Uebung3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NumberTester {
    public NumberTester(String fileName){
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            int length = Integer.parseInt(line);
            for (int i = 0; i < length; i++) {
                String[] temp = br.readLine().split(" ");
                int type = Integer.parseInt(temp[0]);
                int number = Integer.parseInt(temp[1]);
            }
        }catch (IOException IOException){

        }
    }

    public void setOddEvenTester(NumberTester oddTester){

    }

    public void setPrimeTester(NumberTester primeTester){

    }

    public void setPalindromeTester(NumberTester palindromeTester){

    }

    public void testFile(){

    }
}

