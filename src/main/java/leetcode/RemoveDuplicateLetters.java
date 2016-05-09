package leetcode;

import java.util.*;

/**
 * Created by xinghuangxu on 3/24/16.
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int CHARACTER_SIZE = 256;
        int[] count = new int[CHARACTER_SIZE];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            sb.append(s.charAt(i));
        }
        int i = 0;
        while (i != sb.length()) {
            if (i > -1 && i + 1 < sb.length()) {
                if (sb.charAt(i) > sb.charAt(i + 1) && count[sb.charAt(i)] > 1) {
                    count[sb.charAt(i)]--;
                    sb.deleteCharAt(i);
                    i = i - 2;
                }
            }
            i++;
        }
        i = sb.length() - 1;
        while (i != 0) {
            if (count[sb.charAt(i)] > 1) {
                sb.deleteCharAt(i);
            }
            i--;
        }
        return sb.toString();
    }

    /*

    public String removeDuplicateLetters(String s) {
        int CHARACTER_SIZE = 265;
        boolean[] visited = new boolean[CHARACTER_SIZE];
        int[] frequencies = new int[CHARACTER_SIZE];

        for (int i = 0; i < s.length(); i++) {
            frequencies[s.charAt(i)]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Character curChar = s.charAt(i);
            frequencies[curChar]--;
            if (!visited[curChar]) {
                //remove from the back of the que
                while (sb.length() > 0 && curChar < sb.charAt(sb.length() - 1) && frequencies[sb.charAt(sb.length() - 1)] > 0) {
                    visited[sb.charAt(sb.length() - 1)] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(curChar);
                visited[curChar] = true;
            }
        }
        return sb.toString();
    }
    */

    //bad solution
    /*
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
    */
}
