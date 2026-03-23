import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine().trim());

        var numbers = new int[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 선택 했는지 판별하는 flag
        var isSelected = false;

        solution(0, s, 0, numbers, isSelected);

        System.out.println(count);
    }

    private static void solution(int start, int s, int sum, int[] numbers, boolean isSelected) {
        if(start == numbers.length) {
            if(sum == s && isSelected) {
                ++count;
            }
            return;
        }
        // 선택 한 경우
        solution(start + 1, s, sum + numbers[start], numbers, true);
        // 선택 안한 경우
        solution(start + 1, s, sum, numbers, isSelected);
    }
}