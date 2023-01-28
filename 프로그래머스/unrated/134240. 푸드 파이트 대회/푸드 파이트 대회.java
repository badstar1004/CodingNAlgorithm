class Solution {
    public String solution(int[] food) {
        
        if(food.length < 2 && food.length > 9){
            return "";
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();

        for (int i = 1; i < food.length ; i++) {
            stringBuilder.append(String.valueOf(i).repeat(food[i] / 2));
            
            if(i == food.length - 1){
                stringBuilder2.append(stringBuilder);
                stringBuilder.append(0).append(stringBuilder2.reverse());
            }
        }
        return stringBuilder.toString();
    }
}