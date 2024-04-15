package map;
//클래스와 메소드 연습
public class Counter {
    static int n;

    public static void main(String[] args) {
        bump();
        reset();
    }
    public static void bump() {
        for (int i = 0; i < 5; i++) {
            n++;
            show();
        }
    }
    public static void show() {
        System.out.println(n);
    }
    public static void reset() {
        n = 0;
    }


}