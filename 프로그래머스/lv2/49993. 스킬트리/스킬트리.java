class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        // 구현
        // skill을 제외한 문자 없애고 비교
        for(String skillTree : skill_trees) {
            String filterSkillTree = filter(skill, skillTree);
            
            if(skill.startsWith(filterSkillTree)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // skill을 제외한 문자 걸러내기
    private static String filter(String skill, String skillTree) {
        StringBuilder  sb = new StringBuilder ();
        
        for(char c : skillTree.toCharArray()) {
            if(skill.contains(Character.toString(c))) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}