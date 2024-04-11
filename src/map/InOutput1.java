package map;
//입출력
//Scanner를 이용하여 순차적으로 int정수를 받아 합을 출력하는 프로그램을 작성하라
//Ex) 100 200 -> 300
import java.util.Scanner;
public class InOutput1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        int sum = x + y;
        System.out.println(sum);

    }
}
