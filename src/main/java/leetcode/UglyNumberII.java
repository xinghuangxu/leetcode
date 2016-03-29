package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xinghuang Leon Xu on 10/26/2015.
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        List<Integer> uglyNumberList = new ArrayList<Integer>();
        uglyNumberList.add(1);
        n--;
        int l1 = 0, l2 = 0, l3 = 0;
        while (n != 0) {
            int min1 = uglyNumberList.get(l1) * 2, min2 = uglyNumberList.get(l2) * 3, min3 = uglyNumberList.get(l3) * 5;
            int last = uglyNumberList.get(uglyNumberList.size() - 1);

            //it's better to get the minimum number then update l1,l2,l3 according to whether their values equal to min
            //See a more concise solution below
            if(last == min1) l1++;
            else if(last==min2) l2++;
            else if(last == min3) l3++;
            else if (min1 <= min2) {
                if(min1<=min3){
                    uglyNumberList.add(min1);
                    l1++;
                    n--;
                }else{
                    uglyNumberList.add(min3);
                    l3++;
                    n--;
                }
            }else{
                if(min1<=min3){
                    uglyNumberList.add(min2);
                    l2++;
                    n--;
                }else{
                    if(min2>=min3){
                        uglyNumberList.add(min3);
                        l3++;
                        n--;
                    }else{
                        uglyNumberList.add(min2);
                        l2++;
                        n--;
                    }
                }
            }
        }
        return uglyNumberList.get(uglyNumberList.size() - 1);
    }
//    public int nthUglyNumber(int n) {
//        List<Integer> uglyNums = new ArrayList();
//        uglyNums.add(1);
//        int r1 = 0, r2 = 0, r3 = 0, min, num;
//        for (int i = 0; i < n - 1; i++) {
//            int c1 = uglyNums.get(r1) * 2, c2 = uglyNums.get(r2) * 3, c3 = uglyNums.get(r3) * 5;
//            min = Math.min(c1, Math.min(c2, c3));
//            if (min == c1) {
//                r1++;
//            }
//            if (min == c2) {
//                r2++;
//            }
//            if (min == c3) {
//                r3++;
//            }
//            uglyNums.add(min);
//        }
//        return uglyNums.get(n - 1);
//    }
}
