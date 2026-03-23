import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());
        var numOfComputers = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine().trim());
        var numOfEdges = Integer.parseInt(st.nextToken());

        var arr = new int[numOfEdges][2];
        for(int i = 0; i < numOfEdges; i++) {
            st = new StringTokenizer(br.readLine().trim());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        var graph = arrayToGraph(arr, numOfComputers);
        var visited = new boolean[numOfComputers + 1];

        System.out.println(dfs(1, graph, visited));
    }

    private static int dfs(int start, List<List<Integer>> graph, boolean[] visited) {
        visited[start] = true;
        var count = 0;

        for(var next : graph.get(start)) {
            if(!visited[next]) {
                count += dfs(next, graph, visited) + 1;
            }
        }

        return count;
    }

    private static List<List<Integer>> arrayToGraph(int[][] arr, int numOfVertices) {
        var result = new ArrayList<List<Integer>>();

        for(int i = 0; i <= numOfVertices; i++) {
            result.add(new ArrayList<Integer>());
        }

        for(var edge : arr) {
            result.get(edge[0]).add(edge[1]);
            result.get(edge[1]).add(edge[0]);
        }

        return result;
    }
}