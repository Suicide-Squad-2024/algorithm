package PGS.Hash;

import java.util.*;

public class Hash5 {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> best = new ArrayList<>();
        Map<String, Integer> genrePlays = new HashMap<>();
        Map<String, ArrayList<Integer>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genrePlays.put(genres[i], genrePlays.getOrDefault(genres[i], 0) + plays[i]);
            if (!genreSongs.containsKey(genres[i])) {
                genreSongs.put(genres[i], new ArrayList<>());
            }
            genreSongs.get(genres[i]).add(i);
        }

        List<String> genreList = new ArrayList<>(genrePlays.keySet());
        Collections.sort(genreList, (o1, o2) -> genrePlays.get(o2) - genrePlays.get(o1));

        for (String genre : genreList) {
            List<Integer> songList = genreSongs.get(genre);
            Collections.sort(songList, (o1, o2) -> plays[o2] - plays[o1]);
            if (songList.size() < 2) {
                best.add(songList.get(0));
            } else {
                best.add(songList.get(0));
                best.add(songList.get(1));
            }
        }

        return best.stream().mapToInt(x -> x).toArray();
    }
}