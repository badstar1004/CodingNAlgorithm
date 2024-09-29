import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());  // 사진틀의 개수
        int totalVotes = Integer.parseInt(br.readLine());  // 총 추천 횟수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] recommendations = new int[totalVotes];
        for (int i = 0; i < totalVotes; i++) {
            recommendations[i] = Integer.parseInt(st.nextToken());  // 추천받은 학생 번호
        }

        Map<Integer, Integer> voteMap = new HashMap<>();  // 학생별 추천 횟수 저장
        List<Integer> frames = new ArrayList<>();  // 사진틀에 게시된 학생 목록 (최대 n명)

        for (int i = 0; i < totalVotes; i++) {
            int student = recommendations[i];

            // 이미 사진틀에 있는 학생일 경우 추천 횟수만 증가
            if (voteMap.containsKey(student)) {
                voteMap.put(student, voteMap.get(student) + 1);
            } else {
                // 사진틀이 가득 찬 경우
                if (frames.size() == n) {
                    // 추천 횟수가 가장 적고, 오래된 학생을 제거
                    int minVotes = Integer.MAX_VALUE;
                    int toRemove = -1;

                    for (int s : frames) {
                        if (voteMap.get(s) < minVotes) {
                            minVotes = voteMap.get(s);
                            toRemove = s;
                        }
                    }

                    frames.remove((Integer) toRemove);  // 사진틀에서 제거
                    voteMap.remove(toRemove);  // 추천 횟수 관리에서도 삭제
                }

                // 새롭게 사진틀에 학생 추가
                frames.add(student);
                voteMap.put(student, 1);  // 처음 추천받았으므로 추천 횟수는 1
            }
        }

        // 최종 후보들 정렬 (학생 번호 기준 오름차순)
        Collections.sort(frames);

        // 출력
        for (int student : frames) {
            System.out.print(student + " ");
        }
    }
}