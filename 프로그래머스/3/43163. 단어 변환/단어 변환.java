import java.util.*;

class Solution { // BFS 방식
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.offer(new Word(begin, 0));

        while (!queue.isEmpty()) {
            Word current = queue.poll();

            if (current.word.equals(target)) {
                return current.depth;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isOneCharDiff(current.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Word(words[i], current.depth + 1));
                }
            }
        }

        return 0; // target에 도달할 수 없는 경우
    }

    private boolean isOneCharDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }

    class Word {
        String word;
        int depth;

        Word(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
}

/* BFS 방식
class Solution {
    int min = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, visited, 0);

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    void dfs(String current, String target, String[] words, boolean[] visited, int depth) {
        if (current.equals(target)) {
            min = Math.min(min, depth);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && isOneCharDiff(current, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, visited, depth + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }

    boolean isOneCharDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}

 */