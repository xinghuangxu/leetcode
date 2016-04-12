package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xinghuangxu on 3/21/16.
 */
public class CreateMaximumNumber {




//    public int[] maxNumber2(int[] nums1, int[] nums2, int k) {
//        List[] nums1SubListList = new List[k + 1];
//        List[] nums2SubListList = new List[k + 1];
//        List<Integer> maxNumberWithK = findMaxNumberSingleArray(nums1, k);
//        findMaxNumberWithDifferentLength(nums1SubListList, maxNumberWithK);
//        maxNumberWithK = findMaxNumberSingleArray(nums2, k);
//        findMaxNumberWithDifferentLength(nums2SubListList, maxNumberWithK);
//
//        List<List<Integer>> possibleCandidates = new ArrayList(k + 1);
//        for (int i = 0; i <= k; i++) {
//            List<Integer> mergeResult = mergeTwoArray(nums1SubListList[i], nums2SubListList[k - i]);
//            if (mergeResult != null && mergeResult.size() == k) {
//                possibleCandidates.add(mergeResult);
//            }
//        }
//        List<Integer> resultList = findMaxNumerInCandidateArray(possibleCandidates, k);
//        int[] resultArray = new int[k];
//        for (int i = 0; i < k; i++) {
//            resultArray[i] = resultList.get(i);
//        }
//        return resultArray;
//    }


    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> possibleCandidates = new ArrayList(k + 1);
        for (int i = 0; i <= k; i++) {
            if (i <= nums1.length && (k - i) <= nums2.length) {
                possibleCandidates.add(mergeTwoArray(findMaxNumberSingleArray(nums1, i), findMaxNumberSingleArray(nums2, k - i)));
            }
        }
        List<Integer> resultList = findMaxNumerInCandidateArray(possibleCandidates, k);
        int[] resultArray = new int[k];
        for (int i = 0; i < k; i++) {
            resultArray[i] = resultList.get(i);
        }
        return resultArray;
    }

    private List<Integer> findMaxNumerInCandidateArray(List<List<Integer>> possibleCandidates, int k) {
        for (int i = 0; i < k; i++) {
            int maxAtI = Integer.MIN_VALUE;
            for (int j = 0; j < possibleCandidates.size(); j++) {
                if (possibleCandidates.get(j).get(i) > maxAtI) {
                    maxAtI = possibleCandidates.get(j).get(i);
                }
            }
            for (int j = 0; j < possibleCandidates.size(); ) {
                if (possibleCandidates.get(j).get(i) < maxAtI) {
                    possibleCandidates.remove(j);
                } else {
                    j++;
                }
            }
        }
        return possibleCandidates.get(0);
    }

    private List<Integer> mergeTwoArray(List<Integer> l1, List<Integer> l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        List<Integer> result = new ArrayList(l1.size() + l2.size());
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) > l2.get(j)) {
                result.add(l1.get(i));
                i++;
            } else if (l1.get(i) < l2.get(j)) {
                result.add(l2.get(j));
                j++;
            } else {
                if (compare(l1, i + 1, l2, j + 1)) {
                    result.add(l1.get(i));
                    i++;
                } else {
                    result.add(l2.get(j));
                    j++;
                }
            }
        }
        while (i < l1.size()) {
            result.add(l1.get(i));
            i++;
        }
        while (j < l2.size()) {
            result.add(l2.get(j));
            j++;
        }
        return result;
    }

    private boolean compare(List<Integer> l1, int i, List<Integer> l2, int j) {
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) > l2.get(j)) {
                return true;
            } else if (l1.get(i) < l2.get(j)) {
                return false;
            }
            i++;
            j++;
        }
        if (i == l1.size()) return false;
        return true;
    }

    private List<Integer> findMaxNumberSingleArray(int[] nums1, int k) {
        List<Integer> result = new ArrayList(k);
        int startIndex = 0;
        for (int i = 0; i < k; i++) {
            int currentMaxIndex = startIndex;
            startIndex++;
            while (nums1.length - startIndex >= k - i && startIndex < nums1.length) {
                if (nums1[startIndex] > nums1[currentMaxIndex]) {
                    currentMaxIndex = startIndex;
                }
                startIndex++;
            }
            result.add(nums1[currentMaxIndex]);
            startIndex = currentMaxIndex + 1;
        }
        return result;
    }

//    private void findMaxNumberWithDifferentLength(List[] numsSubListList, List<Integer> numList) {
//        int lastDecreasePosition = 0;
//        while (!numList.isEmpty()) {
//            List<Integer> copy = new ArrayList<Integer>(numList);
//            numsSubListList[copy.size()] = copy;
//            lastDecreasePosition = 0;
//            while (lastDecreasePosition + 1 < numList.size() && numList.get(lastDecreasePosition) >= numList.get(lastDecreasePosition + 1)) {
//                lastDecreasePosition++;
//            }
//            numList.remove(lastDecreasePosition);
//
//        }
//    }



//    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//        return maxNumberSub(nums1, nums2, k, -1, -1);
//    }
//
//    private int[] maxNumberSub(int[] nums1, int[] nums2, int k, int firstStart, int secondStart) {
//        int[] result = new int[k];
//        int firstArrayMaxValue, secondArrayMaxValue;
//        for (int i = 0; i < k; i++) {
//            //find the max in the first array
//            int maxIndexInFirstArray = findMaxInArrayWithStartingPointAndK(nums1, firstStart, k - nums2.length + secondStart + 1 - i);
//            //find the max in the second array
//            int maxIndexInSecondArray = findMaxInArrayWithStartingPointAndK(nums2, secondStart, k - nums1.length + firstStart + 1 - i);
//            if (maxIndexInFirstArray == nums1.length) {
//                firstArrayMaxValue = Integer.MIN_VALUE;
//            } else {
//                firstArrayMaxValue = nums1[maxIndexInFirstArray];
//            }
//            if (maxIndexInSecondArray == nums2.length) {
//                secondArrayMaxValue = Integer.MIN_VALUE;
//            } else {
//                secondArrayMaxValue = nums2[maxIndexInSecondArray];
//            }
//            if (firstArrayMaxValue < secondArrayMaxValue) {
//                secondStart = maxIndexInSecondArray;
//                result[i] = secondArrayMaxValue;
//            } else if (firstArrayMaxValue == secondArrayMaxValue) {
//                int[] subResult1 = maxNumberSub(nums1, nums2, k - i - 1, firstStart, maxIndexInSecondArray);
//                int[] subResult2 = maxNumberSub(nums1, nums2, k - i - 1, maxIndexInFirstArray, secondStart);
//                int[] subResult = getBiggerArrayByComparing(subResult1, subResult2);
//                result[i] = firstArrayMaxValue;
//                for (int j = i + 1; j < k; j++) {
//                    result[j] = subResult[j - i - 1];
//                }
//                return result;
//            } else {
//                firstStart = maxIndexInFirstArray;
//                result[i] = firstArrayMaxValue;
//            }
//        }
//        return result;
//    }
//
//    private int[] getBiggerArrayByComparing(int[] subResult1, int[] subResult2) {
//        for (int i = 0; i < subResult1.length; i++) {
//            if (subResult1[i] < subResult2[i]) {
//                return subResult2;
//            } else if (subResult1[i] > subResult2[i]) {
//                return subResult1;
//            }
//        }
//        return subResult1;
//    }
//
//    private int findMaxInArrayWithStartingPointAndK(int[] array, int startIndex, int k) {
//        int length = array.length;
//        int maxIndex = startIndex + 1;
//        startIndex = startIndex + 2;
//        while (length - startIndex >= k && startIndex < length) {
//            if (array[startIndex] > array[maxIndex]) {
//                maxIndex = startIndex;
//            }
//            startIndex++;
//        }
//        return maxIndex;
//    }
}
