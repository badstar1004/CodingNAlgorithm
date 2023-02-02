class Solution {
    public int[] solution(int brown, int yellow) {
        // 크기 2 고정
        int[] answer = new int[2];
        // 세로 길이는 최소 3
        // 가로 최대 길이 = (brown + yellow) / 3
        // 가로 >= 세로
        int w = (brown + yellow) / 3;
        int h = 3;
        
        while(w >= h){
            // (brown + yellow) 값 == (w * h) 값
            // 직사각형 둘레 길이 (= (길이 + 폭) x 2) - 4 == brown
            // ((길이 + 폭) * 2) - 4는 꼭지점 겹쳐서 - 4를 해주면 brown과 같아짐)
            if((brown + yellow) == (w * h) && ((w + h) * 2) - 4 == brown){
                answer[0] = w;
                answer[1] = h;
                break;
            }
            h++;
            w = (brown + yellow) / h;
        }
        
        return answer;
    }
}