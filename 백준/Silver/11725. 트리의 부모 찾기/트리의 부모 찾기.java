import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        
        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            
            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }
        
        int[] arrParents = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(1);
        visited[1] = true;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            for(int num : tree.get(cur)) {
                if(!visited[num]) {
                    visited[num] = true;
                    arrParents[num] = cur;
                    queue.add(num);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N; i++) {
            sb.append(arrParents[i]).append('\n');
        }
        
        System.out.println(sb.toString());
    }
}