import java.util.ArrayList;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i : ingredient){
            al.add(i);
            if(al.size() >= 4){
                if(al.get(al.size()-4)==1&&al.get(al.size()-3)==2&&al.get(al.size()-2) == 3&&al.get(al.size()-1)==1){
                    answer ++;
                    al.remove(al.size()-4);                                   
                    al.remove(al.size()-3);
                    al.remove(al.size()-2);
                    al.remove(al.size()-1);
                }
            }
        }
        return answer;
    }
}