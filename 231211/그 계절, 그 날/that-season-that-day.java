import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] season = new String[]{"Winter", "Spring", "Summer", "Fall", "Winter"};
        int Y = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();
        if(Y%4 == 0 & (!(Y % 100 == 0) | (Y % 400 == 0))) {
            days[1] = 29;
        }
        boolean pass = false;
        if(Y >= 1 & Y <= 3000) {
            if(M >= 1 & M <= 12) {
                if(D >= 1 & D <= days[M-1]) {
                    pass = true;
                }
            }
        }
        if(pass) {
            System.out.print(season[M/3]);
        } else {
            System.out.print(-1);
        }
    }
}