import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        boolean isDec = true;
        int count = 0;
        for(int i = 0; i <= a; i++) {
            if(i == 0 || i == 1) continue;
            for(int j = 2; j < i; j++) {
                if(j*j > i) {
                    break;
                }
                if(i%j == 0) {
                    isDec = false;
                    break;
                }
            }
            if (isDec) {
                count++;
            }
            isDec = true;
        }
        System.out.println(count);
    }
}