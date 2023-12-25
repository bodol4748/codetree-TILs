import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        a = a > 1 ? a : 2;
        int b = sc.nextInt();
        boolean isDec = true;
        int count = 0;
        for(int i = a; i <= b; i++) {
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