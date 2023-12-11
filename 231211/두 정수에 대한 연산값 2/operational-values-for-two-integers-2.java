import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        a = a > b ? big(a) : small(a);
        b = b > a ? big(b) : small(b);

        System.out.printf("%d %d", a, b);
    }

    public static int big(int n) {
        return n * 2;
    }
    public static int small(int n) {
        return n + 10;
    }
}