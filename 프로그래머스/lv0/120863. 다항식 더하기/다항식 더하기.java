class Solution {
    public String solution(String polynomial) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();

        int x = 0;
        int num = 0;
        
        // 문자열 나누기
        for (String s : polynomial.split(" ")) {
            // x 가 있으면
            if(s.contains("x")){
                // x 만 있다면 1x로 변경 (-> 1 로 변경)
                if(s.equals("x")){
//                    s = "1x";
                    s = "1";
                } else {
                    if(s.length() <= 2){
                        s = s.substring(0, 1);
                    } else {
                        s = s.substring(0, 2);
                    }
                }

                x += Integer.parseInt(s);

                // + 가 아니라면 (= 숫자라면)
            } else if(!s.equals("+")) {
//                sbNum.append(s);
                num += Integer.parseInt(s);
            }
        }

        // x 계산

//        if(sbX.length() > 0){
//            sbX = new StringBuilder(sbX.toString().replaceAll("x", ""));
//            for (String str : sbX.toString().split("")) {
//                x += Integer.parseInt(str);
//            }
//
//            sbX.delete(0, sbX.length());
//        }

        // 상수 계산

//        if(sbNum.length() > 0){
//            for (String str : sbNum.toString().split("")) {
//                num += Integer.parseInt(str);
//            }
//
//            sbNum.delete(0, sbX.length());
//        }

        // 둘다 0 일 경우
        if(x == 0 && num == 0){
            answer = "0";

        } else if(x != 0 && num == 0){      // x변만 있는 경우
            answer = sb.append((x == 1) ? "" : x).append("x").toString();

        } else if(x == 0 && num != 0){      // 상수변만 있는 경우
            answer = sb.append(num).toString();

        } else {        // 둘다 있는 경우
            answer = sb.append((x == 1) ? "" : x).append("x").append(" + ").append(num).toString();
        }
        
        return answer;
    }
}