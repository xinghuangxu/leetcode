package leetcode;

import helper.VersionControl;

/**
 * Created by Xinghuang Leon Xu on 10/29/2015.
 */
public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        long left = 1, right = n, middle;
        while (left!=right) {
            middle = (left + right) / 2;
            if (isBadVersion((int)middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return (int)left;
    }

    private int findFirstBadVersion(int left, int right) {
        if (left >= right) {
            return left;
        }
        int middle = (left + right) / 2;
        if (isBadVersion(middle)) {
            return findFirstBadVersion(left, middle);
        } else {
            return findFirstBadVersion(middle + 1, right);
        }

    }
}
