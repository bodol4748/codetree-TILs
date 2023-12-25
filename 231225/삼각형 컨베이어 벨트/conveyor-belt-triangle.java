import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt() % (n*3);
        int[] arr = new int[n*3];

        for(int i = 0; i < n*3; i++) {
            arr[i] = sc.nextInt();
        }
        int before = arr[0];
        while(t > 0) {
            for(int i = 0; i < n*3; i++) {
                if(i == n*3-1) {
                    arr[0] = before;
                    break;
                }
                int after = arr[i+1];
                arr[i+1] = before;
                before = after;
            }
            t--;
        }
        for(int i = 0; i < n*3; i++) {
            if((i != 0) && (i % 3 == 0)) System.out.println();
            System.out.print(Integer.toString(arr[i]) + " ");
        }
    }
}