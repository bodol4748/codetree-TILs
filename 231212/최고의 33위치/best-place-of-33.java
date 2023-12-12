import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr =  new int[n][n];
        int[] dx = new int[]{0,1,2,0,1,2,0,1,2};
        int[] dy = new int[]{0,0,0,1,1,1,2,2,2};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int sum = 0;
        int max = 0;
        for(int y = 0; y < n-2; y++) {
            for(int x = 0; x < n-2; x++) {
                for(int t = 0; t < 9; t++) {
                    sum += arr[y + dy[t]][x + dx[t]];
                }
                if(max < sum) {
                    max = sum;
                }
                sum = 0;
            }
        }
        System.out.print(max);
    }
}