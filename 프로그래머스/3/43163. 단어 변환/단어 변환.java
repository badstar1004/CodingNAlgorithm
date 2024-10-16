import java.util.*;

class Solution {
    
    // 단어 노드 클래스
    public static class WordNode {
        String word;
        int steps;
        
        WordNode(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        // target 단어가 words에 없으면 return 0
        boolean isTarget = false;
        for(String word : words) {
            if(word.equals(target)) {
                isTarget = true;
                break;
            }
        }
        
        if(!isTarget) {
            return 0;
        }
        
        // BFS Queue
        Queue<WordNode> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        // 초기 상태 설정
        queue.offer(new WordNode(begin, 0));
        
        while(!queue.isEmpty()) {
            WordNode curWordNode = queue.poll();
            String curWord = curWordNode.word;
            int curSteps = curWordNode.steps;
            
            // 일치하면 변환 횟수 return
            if(curWord.equals(target)) {
                return curSteps;
            }
            
            // 변환 가능한 단어 찾아서 큐에 추가
            for(int i = 0; i < words.length; i++) {
                if(!visited[i] && canTransform(curWord, words[i])) {
                    visited[i] = true;
                    queue.offer(new WordNode(words[i], curSteps + 1));
                }
            }
        }
        
        return 0;
    }
    
    
    // 한글자 차이인가
    public boolean canTransform(String curWord, String word) {
        int diffCount = 0;
        for(int i = 0; i < curWord.length(); i++) {
            if(curWord.charAt(i) != word.charAt(i)) {
                diffCount++;
            }
            
            if(diffCount > 1) {
                return false;
            }
        }
        
        return diffCount == 1;
    }
}