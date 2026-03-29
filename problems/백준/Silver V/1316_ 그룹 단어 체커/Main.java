import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        var n = Integer.parseInt(st.nextToken());
        var count = 0;
        A:for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            var input = st.nextToken();
            var stack = new ArrayDeque<Character>();
            var visited = new boolean[26];
            for(int j = 0; j < input.length(); j++) {
                if(!visited[input.charAt(j) - 'a']) {
                    visited[input.charAt(j) - 'a'] = true;
                    stack.push(input.charAt(j));
                }
                else {
                    if(!stack.isEmpty()) {
                        var top = stack.peek();
                        if(top != input.charAt(j)) {
                            stack.clear();
                            continue A;
                        }
                    }
                }
            }
            if(!stack.isEmpty()) {
                ++count;
            }
        }
        System.out.println(count);
    }
}