import java.util.*;

class Solution {
    
    // Song class
    public class Song {
        // 노래 고유 번호
        int id;
        // 재생 횟수
        int playCount;
        
        Song(int id, int playCount) {
            this.id = id;
            this.playCount = playCount;
        }
    }
    
    
    public int[] solution(String[] genres, int[] plays) {
        // map
        // 장르별 총 재생횟수
        Map<String, Integer> genrePlayCount = new HashMap<>();
        
        // 장르별 노래 목록
        Map<String, List<Song>> genreSong = new HashMap<>();
        
        // 장르별 총 재생 횟수와 장르별 노래 채우기
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) 
+ play);
            
            genreSong.putIfAbsent(genre, new ArrayList<>());
            genreSong.get(genre).add(new Song(i, play));
        }
        
        // 장르별 재생 횟수 내림차순 정렬
        List<String> genreOrder = new ArrayList<>(genrePlayCount.keySet());
        genreOrder.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));
        
        // 베스트 앨범
        List<Integer> bestAlbum = new ArrayList<>();
        for(String genre : genreOrder) {
            List<Song> songList = genreSong.get(genre);
            
            // 각 장르의 재생 횟수, 고유 번호 기준으로 정렬
            songList.sort((a, b) -> b.playCount - a.playCount == 0 ? a.id - b.id : b.playCount - a.playCount);
            
            // 최대 두 곡 추가
            for(int i = 0; i < Math.min(2, songList.size()); i++) {
                bestAlbum.add(songList.get(i).id);
            }
        }
        
        return bestAlbum.stream().mapToInt(Integer::intValue).toArray();
    }
}