import java.util.*;

public class Main {    
    private static int[][] arr;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        while (q > 0) {
            int start_line = sc.nextInt();
            String start_dir = sc.next();
            int i = start_line - 1; int j = start_line - 1;
            blow(start_line - 1, start_dir);
            while ((i != 0 && (isSame(i, i-1))) || ((j != n-1)  && (isSame(j, j+1)))) {
                start_dir = start_dir.equals("L") ? "R" : "L";
                if(i > 0 && isSame(i, i-1)) {
                    i = i-1;
                    blow(i, start_dir);
                }
                if(j+1 < n && isSame(j, j+1)) {
                    j = j+1;
                    blow(j, start_dir);
                }
            }
            q = q-1;
        }
        for(int x = 0; x < n; x++) {
            for(int z = 0; z < m; z++) {
                System.out.print(arr[x][z] + " ");
            }
            System.out.print("\n");
        }
    }

    public static boolean isSame(int line, int next_line) {
        for(int i = 0; i < arr[0].length; i++) {
            if(arr[line][i] == arr[next_line][i]) {
                return true;
            }
        } return false;
    }

    private static void blow(int line, String direction) {
        int dir = (direction.equals("L")) ? +1 : -1;
        int before;
        if(dir == -1) {
            before = arr[line][arr[1].length-1];
            for(int i = arr[1].length-1; i > -1; i--) {
                if(i == 0) {
                    arr[line][arr[1].length-1] = before;
                    break;
                }
                int after = arr[line][i+dir];
                arr[line][i+dir] = before;
                before = after;
            }
        } else {
            before = arr[line][0];
            for(int i = 0; i < arr[1].length; i++) {
                if(i == arr[1].length-1) {
                    int index = dir == 1 ? 0 : arr[1].length-1;
                    arr[line][index] = before;
                    break;
                }
                int after = arr[line][i+dir];
                arr[line][i+dir] = before;
                before = after;
            }
        }
    }
}