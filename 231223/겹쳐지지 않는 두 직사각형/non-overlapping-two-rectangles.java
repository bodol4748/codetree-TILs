import java.io.*;
import java.util.*;

public class Main {
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        } // array에 입력값 넣기

        for(int y1 = 0; y1 < n; y1++) {
            for(int x1 = 0; x1 < m; x1++) {
                for(int y2 = y1; y2 < n; y2++) {
                    for(int x2 = x1; x2 < m; x2++) {
                        // 첫번째 직사각형 꼭짓점 2개 선택
                        int rec1 = calc(y1, x1, y2, x2);
                        for(int y3 = 0; y3 < n; y3++) {
                            for(int x3 = 0; x3 < m; x3++) {
                                for(int y4 = y3; y4 < n; y4++) {
                                    for(int x4 = x3; x4 < m; x4++) {
                                        if((x1 <= x4 && x3 <= x2) && (y3 <= y2 && y1 <= y4)) {
                                            continue;
                                        }

                                        int rec2 = calc(y3, x3, y4, x4);
                                        if(max < rec1 + rec2) {
                                            max = rec2 + rec1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
    }

    // 직사각형 꼭짓점(대각선방향) 2개 받아와 내부 값 합산
    private static int calc(int y1, int x1, int y2, int x2) {
        int sum = 0;
        for(int y = y1; y <= y2; y++) {
            for(int x = x1; x <= x2; x++) {
                sum += arr[y][x];
            }
        }
        return sum;
    }
}