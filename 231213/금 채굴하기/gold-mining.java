import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 여기에 코드를 작성해주세요.
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[][] arr = new int[n][n];
        int max = 0;

        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int k = 0; k < n+1; k++){
            int cost = k * k + (k + 1) * (k + 1);
            int gold_sum = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    gold_sum += Arrays.stream(Arrays.copyOfRange(arr[i],(j-k)>0?j-k:0,(j+k+1)<n?(j+k+1):n)).sum();
                    int now_idx = 1;
                    while(k+1 != now_idx) {
                        if (i-now_idx > -1) {
                            for(int temp = (j-(k-now_idx)>-1?j-(k-now_idx):0); temp < (j+(k-now_idx)+1<n?j+(k-now_idx)+1:n); temp++) {
                                if(arr[i-now_idx][temp] == 1) gold_sum++;
                            }
                        } if (i+now_idx < n) {
                            for(int temp = (j-(k-now_idx)>-1?j-(k-now_idx):0); temp < (j+(k-now_idx)+1<n?j+(k-now_idx)+1:n); temp++) {
                                if(arr[i+now_idx][temp] == 1) gold_sum++;
                            }
                        }
                        now_idx++;
                    }
                    max = (-1 < gold_sum*m - cost) && (max < gold_sum) ? gold_sum : max;
                    gold_sum = 0;
                }
            }
        }
        System.out.print(max);
    }
}