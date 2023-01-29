class Solution {
    public int solution(String my_string) {
        int answer = 0;
        int sum = 0;
        
        String[] str = my_string.split("[a-zA-z\\s]");

        for(int i = 0; i < str.length; i++){
            if(str[i].equals("")){
                continue;
            } else {
                sum += Integer.parseInt(str[i]);
            }
        }      
        
        return sum;
    }
}