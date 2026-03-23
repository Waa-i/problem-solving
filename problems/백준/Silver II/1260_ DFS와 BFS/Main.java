import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim());

        var numOfVertices = Integer.parseInt(st.nextToken());
        var numOfEdges = Integer.parseInt(st.nextToken());
        var start = Integer.parseInt(st.nextToken());

        var arr = new int[numOfEdges][2];
        for(int i = 0; i < numOfEdges; i++) {
            st = new StringTokenizer(br.readLine().trim());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        var graph = arrayToGraph(arr, numOfVertices);
        var dfsVisited = new boolean[numOfVertices + 1];
        var dfsResult = new StringBuilder();
        dfs(start, graph, dfsVisited, dfsResult);

        var bfsVisited = new boolean[numOfVertices + 1];
        var bfsResult = new StringBuilder();
        bfs(start, graph, bfsVisited, bfsResult);

        System.out.println(dfsResult);
        System.out.println(bfsResult);
    }

    private static void dfs(int start, List<List<Integer>> graph, boolean[] visited, StringBuilder sb) {
        visited[start] = true;
        sb.append(start).append(" ");

        for(var next : graph.get(start)) {
            if(!visited[next]) {
                dfs(next, graph, visited, sb);
            }
        }
    }

    private static void bfs(int start, List<List<Integer>> graph, boolean[] visited, StringBuilder sb) {
        var queue = new LinkedList<Integer>();
        queue.add(start);
        visited[start] = true;
        sb.append(start).append(" ");

        while(!queue.isEmpty()) {
            var cur = queue.poll();
            for(var next : graph.get(cur)) {
                if(!visited[next]) {
                    queue.add(next);
                    sb.append(next).append(" ");
                    visited[next] = true;
                }
            }
        }
    }

    private static List<List<Integer>> arrayToGraph(int[][] arr, int numOfVertices) {
        var result = new ArrayList<List<Integer>>();

        for(int i = 0; i <= numOfVertices; i++) {
            result.add(new ArrayList<Integer>());
        }

        for(var edges : arr) {
            result.get(edges[0]).add(edges[1]);
            result.get(edges[1]).add(edges[0]);
        }

        for(int i = 1; i < result.size(); i++) {
            Collections.sort(result.get(i));
        }

        return result;
    }
}