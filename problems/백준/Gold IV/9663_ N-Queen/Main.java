import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());
        var n = Integer.parseInt(st.nextToken());
        var arr = new int[n];
        solve(0, n, arr);
        System.out.println(count);
    }

    static void solve(int row, int n, int[] arr) {
        if(row == n) {
            ++count;
            return;
        }
        A:for(int i = 0; i < n; i++) {
            for(int j = 0; j < row; j++) {
                if(!isValid(j, row, arr[j], i)) continue A;
            }
            arr[row] = i;
            solve(row + 1, n, arr);
        }
    }

    static boolean isValid(int pr, int r, int pc, int c) {
        if(pc == c) {
            return false;
        }
        return Math.abs(pr - r) != Math.abs(pc - c);
    }
}