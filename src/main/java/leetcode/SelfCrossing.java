package leetcode;

/**
 * Created by k586j642 on 2/25/2016.
 */
public class SelfCrossing {
    public boolean isSelfCrossing(int[] x) {
        if (x == null || x.length < 4) return false;
        for (int i = 3; i < x.length; i++) { //forth cross with the first
            if(x[i-3]>=x[i-1]&&x[i]>=x[i-2]){
                return true;
            }
            if(i>=4){ //fifth cross with the first (overlapping)
                if(x[i-1]==x[i-3] && x[i]+x[i-4]>=x[i-2]){
                    return true;
                }
            }
            if(i>=5){ //sixth cross with the first
                if(x[i-3]>x[i-1]&&x[i-2]>x[i-4]&&x[i]+x[i-4]>=x[i-2]){
                    return true;
                }
            }
        }
        return false;
    }
}
