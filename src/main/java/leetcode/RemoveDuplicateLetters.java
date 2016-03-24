package leetcode;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by xinghuangxu on 3/24/16.
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int charLength = 26;
        int[] charCounts = new int[charLength];
        int[] sCharFrequency = new int[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            charCounts[s.charAt(i) - 'a']++;
            sCharFrequency[i] = charCounts[s.charAt(i) - 'a'];
        }
        int uniqueCount = 0;
        for (int i = 0; i < charLength; i++) {
            if (charCounts[i] != 0) {
                uniqueCount++;
            }
        }
        boolean[] visited = new boolean[charLength];
        List<List<Character>> candidates = new ArrayList();
        findPossibleCandidates(candidates, visited, sCharFrequency, s, 0, new ArrayList(uniqueCount), uniqueCount);
        for (int i = 0; i < uniqueCount; i++) {
            int minChar = Integer.MAX_VALUE;
            for (int j = 0; j < candidates.size(); j++) {
                List<Character> c = candidates.get(j);
                if(c.get(i)< minChar){
                    minChar = c.get(i);
                }
            }
            for (int j = 0; j < candidates.size();) {
                List<Character> c = candidates.get(j);
                if(c.get(i)!=minChar){
                    candidates.remove(j);
                }else{
                    j++;
                }
            }
        }
        StringBuilder result=new StringBuilder();
        if(candidates.size()>0){
            List<Character> resultList = candidates.get(0);
            for(int i=0;i<resultList.size();i++){
                result.append(resultList.get(i));
            }
        }
        return result.toString();
    }

    private void findPossibleCandidates(List<List<Character>> candidates, boolean[] visited, int[] sCharFrequency, String s, int cur, List<Character> candidate, int uniqueCount) {
        if (candidate.size() == uniqueCount) {
            List<Character> copy = new ArrayList(candidate);
            candidates.add(copy);
            return;
        }
        if (cur >= s.length()) return;
        char curChar = s.charAt(cur);
        int curIndex = curChar - 'a';
        if (visited[curIndex]) { //char has been visited
            findPossibleCandidates(candidates, visited, sCharFrequency, s, cur + 1, candidate, uniqueCount);
        } else {
            candidate.add(curChar);
            visited[curIndex] = true;
            findPossibleCandidates(candidates, visited, sCharFrequency, s, cur + 1, candidate, uniqueCount);
            candidate.remove(candidate.size() - 1);
            visited[curIndex] = false;
            if (sCharFrequency[cur] > 1) { //don't use it
                findPossibleCandidates(candidates, visited, sCharFrequency, s, cur + 1, candidate, uniqueCount);
            }
        }
    }
}
