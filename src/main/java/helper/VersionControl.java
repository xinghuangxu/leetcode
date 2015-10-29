package helper;

/**
 * Created by Xinghuang Leon Xu on 10/29/2015.
 */
public class VersionControl {
    public boolean isBadVersion(int version){
        if(version>=1702766719){
            return true;
        }
        return false;
    }
}
