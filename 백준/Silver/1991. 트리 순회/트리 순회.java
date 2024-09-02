import java.io.*;
import java.util.*;

public class Main {
    // Node 클래스
    static class Node {
        char left;
        char right;
        
        Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }
    
    // 이진트리 map
    static Map<Character, Node> tree = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 노드 개수
        int N = Integer.parseInt(br.readLine());
        
        // 트리 넣기
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            char parent = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);
            
            tree.put(parent, new Node(left, right));
        }
        
        // 전위
        pre('A');
        System.out.println();
        
        // 중위
        in('A');
        System.out.println();
        
        // 후위
        post('A');
        System.out.println();
        
    }
    
    // 전위
    public static void pre(char root) {
        if(root == '.') {
            return;
        }
        
        System.out.print(root);    // 루트
        pre(tree.get(root).left);    // 왼쪽
        pre(tree.get(root).right);    // 오른쪽
    }
    
    // 중위
    public static void in(char root) {
        if(root == '.') {
            return;
        }
        
        in(tree.get(root).left);    // 왼쪽
        System.out.print(root);    // 루트
        in(tree.get(root).right);    // 오른쪽
    }
    
    // 후위
    public static void post(char root) {
        if(root == '.') {
            return;
        }
        
        post(tree.get(root).left);    // 왼쪽
        post(tree.get(root).right);    // 오른쪽
        System.out.print(root);    // 루트
    }
}