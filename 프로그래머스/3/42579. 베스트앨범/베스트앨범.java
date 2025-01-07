import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        /*
        1. 속한 노래가 많이 재생된 장르 먼저 수록
        2. 장르별로 가장 많이 재생된 노래를 최대 두 개까지 수록
        */

        // 장르별 총 재생 수를 저장할 해시맵
        HashMap<String, Integer> genrePlayCount = new HashMap<>();
        // 장르별 곡 정보(고유 번호와 재생 수)를 저장할 해시맵
        HashMap<String, List<int[]>> genreSongs = new HashMap<>();
        
        // 1. 데이터를 맵에 저장
        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
            
            genreSongs.putIfAbsent(genres[i], new ArrayList<>());
            genreSongs.get(genres[i]).add(new int[] {i, plays[i]}); // 고유번호와 재생 수 저장
        }
        
        // 2. 장르별 총 재생 수를 기준으로 내림차순 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((g1, g2) -> genrePlayCount.get(g2) - genrePlayCount.get(g1));
        
        // 3. 결과 리스트 생성
        ArrayList<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            // 해당 장르의 곡들을 재생 수 내림차순, 고유 번호 오름차순으로 정렬
            List<int[]> songs = genreSongs.get(genre);
            songs.sort((a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);
            
            // 최대 두 곡의 고유 번호 추가
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i)[0]);
            }
        }
        
        // 리스트를 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
    }
}
