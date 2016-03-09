package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by xinghuangxu on 10/29/15.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int size = 256;
        //Bidirectional Mapping
        int[] m1 = new int[size];
        int[] m2 = new int[size];

        for (int i = 0; i < s.length(); i++) {
            Character t1 = s.charAt(i);
            Character t2 = t.charAt(i);

            //one xdirection
            if(m1[t1]==0){
                m1[t1]=t2;
            }

            //second xdirection
            if(m2[t2]==0){
                m2[t2]=t1;
            }

            //check if there are conflicts
            if(m1[t1]!=t2||m2[t2]!=t1){
                return false;
            }
        }
        return true;
    }
}
