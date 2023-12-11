import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int big = n > m ? n : m;
        int small = n < m ? n : m;
        int r = big % small;
        while(small % r != 0) {
            int temp = small % r;
            small = r;
            r = temp;
        }
        System.out.print(n*m/r);
    }
}