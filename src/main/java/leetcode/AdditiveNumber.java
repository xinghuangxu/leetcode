package leetcode;

/**
 * Created by xinghuangxu on 4/2/16.
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        int size = num.length();
        Long first, second;
        if (num == null || num.length() == 0) return false;
        for (int i = 0; i <= size / 2; i++) {
            if (i + 1 > 1 && num.charAt(0) == '0') return false;
            first = Long.parseLong(num.substring(0, i + 1));
            for (int j = i + 1; j - i <= size / 2 && j < size; j++) {
                if (j - i > 1 && num.charAt(i + 1) == '0') continue;
                second = Long.parseLong(num.substring(i + 1, j + 1));
                String tmp = num.substring(j + 1);
                if (!tmp.equals("") && isAdditiveSequence(num.substring(j + 1), first, second)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAdditiveSequence(String substring, Long first, Long second) {
        if (substring.length() == 0) return true;
        Long sum = first + second;
        String tmp = sum + "";
        if (tmp.length() > 1 && substring.charAt(0) == '0') return false;
        if (tmp.length() <= substring.length() && substring.substring(0, tmp.length()).equals(tmp)) {
            return isAdditiveSequence(substring.substring(tmp.length()), second, sum);
        }
        return false;
    }
}
