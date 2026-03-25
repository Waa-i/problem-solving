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

        var edges = new int[numOfEdges][2];
        for(int i = 0; i < numOfEdges; i++) {
            st = new StringTokenizer(br.readLine().trim());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        var graph = arrayToGraph(edges, numOfVertices);
        var result = new ArrayList<Integer>();

        for(int i = 1; i <= numOfVertices; i++) {
            var visited = new boolean[numOfVertices + 1];
            result.add(bfs(i, graph, visited));
        }

        System.out.println(min(result));
    }

    private static int bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        var queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        var sum = 0;
        while(!queue.isEmpty()) {
            var cur = queue.poll();
            sum += cur[1];
            for(var next : graph.get(cur[0])) {
                if(!visited[next]) {
                    queue.offer(new int[]{next, cur[1] + 1});
                    visited[next] = true;
                }
            }
        }

        return sum;
    }

    private static List<List<Integer>> arrayToGraph(int[][] arr, int numOfVertices) {
        var result = new ArrayList<List<Integer>>();
        for(int i = 0; i <= numOfVertices; i++) {
            result.add(new ArrayList<Integer>());
        }

        for(var edge : arr) {
            result.get(edge[1]).add(edge[0]);
            result.get(edge[0]).add(edge[1]);
        }

        return result;
    }

    private static int min(List<Integer> list) {
        if(list.isEmpty()) {
            return 0;
        }
        int min = list.get(0);
        int idx = 0;
        for(int i = 0; i < list.size(); i++) {
            if(min > list.get(i)) {
                min = list.get(i);
                idx = i;
            }
        }
        return idx + 1;
    }
}