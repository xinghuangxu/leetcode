package leetcode;

/**
 * Created by Xinghuang Leon Xu on 10/26/2015.
 */
public class NimGame {

    public boolean canWinNim(int n) {
        if(maxValue(n)==1){
            return true;
        }
        return false;
    }

    private int maxValue(int n) {
        if(n<4){
            return 1;
        }
        for(int i=1;i<=3;i++){
            if(minValue(n-i)==1){
                return 1;
            }
        }
        return 0;
    }

    private int minValue(int n) {
        if(n<4){
            return -1;
        }
        for(int i=1;i<=3; i++) {
            if (maxValue(n - i) == -1) {
                return -1;
            }
        }
        return 1;
    }

}
