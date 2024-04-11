package map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Scanner를 사용하지 않고 입력이 끝날때(white space는 입력을 구분하는 인자로 취급)까지 정수를 받아 그 합을 구하는 프로그램을 구현하라
//Ex) 입력1)123 456 789 ctrl+D/ctrl/Z -> 1368
public class InOutput2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String[] numbers = line.split("\\s+");
        int[] numbersInt = new int[numbers.length];
        int sum = 0;
        for (int i =0; i < numbers.length; i++) {
            numbersInt[i] = Integer.parseInt(numbers[i]);
        }
        for (int num : numbersInt) {
            sum += num;
        }
        System.out.println(sum);
    }
}