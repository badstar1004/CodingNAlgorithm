import java.util.*;

class Solution {
    
    // TrieNode (트라이 노드)
    class TrieNode {
        Map<Character, TrieNode> child = new HashMap<>();
        int count = 0;
        
        public TrieNode() {}
    }
    
    // Trie (트라이)
    class Trie {
        TrieNode root;
        
        // 생성자 (TrieNode 초기화)
        public Trie() {
            root = new TrieNode();
        }
        
        // 트라이 삽입
        public void insert(String word) {
            TrieNode node = root;
            for(char c : word.toCharArray()) {
                node.child.putIfAbsent(c, new TrieNode());
                node = node.child.get(c);
                node.count++;
            }
        }
        
        // 입력해야하는 문자 수 계산
        public int countPreFix(String word) {
            TrieNode node = root;
            int prefixCount = 0;
            
            for(char c : word.toCharArray()) {
                node = node.child.get(c);
                prefixCount++;
                
                // 1개뿐이면 입력 x
                if(node.count == 1) {
                    break;
                }
            }
            
            return prefixCount;
        }
    }
    
    
    public int solution(String[] words) {
        int answer = 0;
        
        // Trie (트라이)
        Trie trie = new Trie();
        
        // 트라이에 삽입
        for(String word : words) {
            trie.insert(word);
        }
        
        // 문자 수 계산
        for(String word : words) {
            answer += trie.countPreFix(word);
        }
        
        return answer;
    }
}