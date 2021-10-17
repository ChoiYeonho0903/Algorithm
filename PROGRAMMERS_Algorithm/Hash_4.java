package PROGRAMMERS_Algorithm;

import java.util.*;

public class Hash_4 {
    static String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    static int[] plays = {500, 2500, 150, 800, 2500};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <genres.length; i++) {
            String key = genres[i];
            if(map.containsKey(key)) {
                map.put(key, map.get(key)+plays[i]);
            }
            else {
                map.put(key, plays[i]);
            }
        }
        ArrayList<String> genres_order = new ArrayList<>();
        while(map.size()!=0) {
            int max = 0;
            String max_str = "";
            for (String key : map.keySet()) {
                if(map.get(key) > max) {
                    max = map.get(key);
                    max_str = key;
                }
            }
            genres_order.add(max_str);
            map.remove(max_str);
        }

        ArrayList<Play> music_order = new ArrayList<>();
        for (String gern : genres_order) {
            ArrayList<Play> tmp = new ArrayList<>();
            for (int i = 0; i <genres.length; i++) {
               if(genres[i].equals(gern)) {
                   tmp.add(new Play(plays[i], i));
               }
            }
            Collections.sort(tmp, new Comparator<Play>() {
                @Override
                public int compare(Play o1, Play o2) {
                    if(o1.plays>o2.plays)
                        return -1;
                    else if(o1.plays == o2.plays) {
                        if(o1.index > o2.index)
                            return 1;
                        else
                            return -1;
                    }
                    else
                        return 1;
                }
            });
            music_order.add(tmp.get(0));
            if(tmp.size()!=1) {
                music_order.add(tmp.get(1));
            }

        }
        answer = new int[music_order.size()];
        for (int i = 0; i <music_order.size(); i++) {
            answer[i] = music_order.get(i).index;
        }
        return answer;
    }

    private static class Play {
        public int plays;
        public int index;

        public Play(int plays, int index) {
            this.plays = plays;
            this.index = index;
        }
    }
}
