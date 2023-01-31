class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        int cnt = 0;
        
        for (int i = 0; i < dic.length; i++) {
            if(dic[i].length() == spell.length){
                for (int j = 0; j < spell.length; j++) {
                    if(dic[i].contains(spell[j])){
                        cnt++;
                    } else {
                        cnt = 0;
                        break;
                    }
                }

                if(cnt == spell.length){
                    answer = 1;
                    break;
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
        
        return answer;
    }
}