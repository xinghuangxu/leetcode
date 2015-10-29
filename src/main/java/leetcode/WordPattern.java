package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinghuangxu on 10/27/15.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<String, Character> map = new HashMap();
        boolean[] used = new boolean[26];
        String[] words = str.split(" ");
        if(words.length!=pattern.length())return false;
        for (int i = 0; i < words.length; i++) {
            if(map.containsKey(words[i])){
                if(map.get(words[i])!=pattern.charAt(i)){
                    return false;
                }
            }else{
                if(used[pattern.charAt(i)-'a']){
                    return false;
                }
                used[pattern.charAt(i)-'a'] = true;
                map.put(words[i],pattern.charAt(i));
            }
        }
        return true;
    }
}
