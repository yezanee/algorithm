import java.util.*;

class Music {
    int num;
    int playCnt;
    
    Music(int num, int playCnt) {
        this.num = num;
        this.playCnt = playCnt;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, List<Music>> findBestAlbum = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            findBestAlbum.computeIfAbsent(genres[i], k->new ArrayList<>())
                         .add(new Music(i, plays[i]));
        }
        
        for(String key : findBestAlbum.keySet()) {
            findBestAlbum.get(key).sort(
                (a,b) -> {
                    if(b.playCnt == a.playCnt) {
                        return a.num - b.num;
                    }
                    return b.playCnt - a.playCnt;
                }
            );
        }
        
        HashMap<String, Integer> genreTotal = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreTotal.put(genres[i], genreTotal.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> genreOrder = new ArrayList<>(genreTotal.keySet());
        genreOrder.sort((a, b) -> genreTotal.get(b) - genreTotal.get(a));
        
        List<Integer> result = new ArrayList<>();

        for (String genre : genreOrder) {
            List<Music> list = findBestAlbum.get(genre);

            for (int i = 0; i < list.size() && i < 2; i++) {
                result.add(list.get(i).num);
            }
        }
        
        
        return result.stream().mapToInt(i->i).toArray();
    }
}