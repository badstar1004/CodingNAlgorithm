import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // Score 클래스
    static class Score {
        int staffIdx;
        double score;

        // 생성자
        public Score(int staffIdx, double score) {
            this.staffIdx = staffIdx;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        // 득표수
        int X = Integer.parseInt(br.readLine());
        // 스태프 수
        int N = Integer.parseInt(br.readLine());

        // 5% 미만 스태프 제외
        double validCut = X * 0.05;
        boolean[] validCandidate = new boolean[26];
        int[] staffVote = new int[26];
        int candidateCount = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int vote = Integer.parseInt(st.nextToken());

            if(vote >= validCut){
                int idx = name.charAt(0) - 'A';
                validCandidate[idx] = true;
                staffVote[idx] = vote;
                candidateCount++;
            }

        }

        // 남은 스태프마다 받은 득표수 1 ~ 14로 나눈 점수 집합을 구함
        Score[] scores = new Score[candidateCount * 14];
        int scoreIdx = 0;
        for (int i = 0; i < 26; i++) {
            if(validCandidate[i]){
                for (int j = 1; j <= 14; j++) {
                    scores[scoreIdx++] = new Score(i, (double) staffVote[i] / j);
                }
            }
        }

        // 전체 점수 집합에서 점수가 큰 1 ~ 14번째 스태프에게 칩을 1개씩 지급
        sortScoresDescendingOrder(scores);

        int[] ans = new int[26];
        for (int i = 0; i < 14; i++) {
            ans[scores[i].staffIdx]++;
        }

        // 스태프 이름에 대해 사전순으로 후보 스태프와 받은 칩의 수를 출력
        for (int i = 0; i < 26; i++) {
            if(validCandidate[i]){
                System.out.println((char)(i + 'A') + " " + ans[i]);
            }
        }

    }

    private static void sortScoresDescendingOrder(Score[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i].score > arr[j].score){
                    Score cur = arr[i];

                    for (int k = i; k > j; k--) {
                        arr[k] = arr[k - 1];
                    }
                    arr[j] = cur;
                }
            }
        }
    }
}