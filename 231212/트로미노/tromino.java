import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dx = new int[]{0, 1, 0, 1};
        int[] dy = new int[]{0, 0, 1, 1};
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int sum = 0;
        int max = 0;
        for(int pass_idx = 0; pass_idx < 4; pass_idx++) {
            for(int i = 0; i < n-1; i++) {
                for(int j = 0; j < m-1; j++) {
                    for(int temp = 0; temp < 4; temp++) {
                        if(pass_idx != temp) {
                            sum += arr[i + dy[temp]][j + dx[temp]];
                        }
                    }
                    if(max < sum) {
                        max = sum;
                    }
                    sum = 0;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m-2; j++) {
                sum = arr[i][j] + arr[i][j+1] + arr[i][j+2];
                if(max < sum) {
                    max = sum;
                }
                sum = 0;
            }
        }

        for(int i = 0; i < n-2; i++) {
            for(int j = 0; j < m; j++) {
                sum = arr[i][j] + arr[i+1][j] + arr[i+2][j];
                if(max < sum) {
                    max = sum;
                }
                sum = 0;
            }
        }
        System.out.print(max);

    }
}