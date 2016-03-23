package leetcode;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by xinghuangxu on 3/22/16.
 */
public class IntegerToEnglishWords {


    private final String[] BELOW_TWENTY = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private final String[] BELOW_TEN = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    private final String[] BELOW_HUNDRED = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};


    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return recursiveHelper(num);
    }

    private String recursiveHelper(int num) {
        String result;
        if (num < 10) result = BELOW_TEN[num];
        else if (num < 20) result = BELOW_TWENTY[num - 10];
        else if (num < 100) result = BELOW_HUNDRED[num / 10] + " " + BELOW_TEN[num % 10];
        else if (num < 1000) result = BELOW_TEN[num / 100] + " Hundred " + recursiveHelper(num % 100);
        else if (num < 1000000) result = recursiveHelper(num / 1000) + " Thousand " + recursiveHelper(num % 1000);
        else if (num < 1000000000)
            result = recursiveHelper(num / 1000000) + " Million " + recursiveHelper(num % 1000000);
        else result = recursiveHelper(num / 1000000000) + " Billion " + recursiveHelper(num % 1000000000);
        return result.trim();
    }

//    public String numberToWords(int num) {
//        if (num == 0) return FIRST_NUM_TO_WORD[num];
//        String[] suffixArray = new String[]{"", "Thousand", "Million", "Billion", "Trillion", "Zillion"};
//        List<Integer> nums = breakNum(num);
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < nums.size(); i++) {
//            String word = convertToWords(nums.get(i));
//            if (word != ""){
//                if (i != 0) word += " " + suffixArray[i];
//                sb.insert(0, word + " ");
//            }
//        }
//        sb.deleteCharAt(sb.length() - 1);
//        return sb.toString();
//    }
//
//    private String convertToWords(Integer num) {
//        if (num == 0) {
//            return "";
//        }
//        StringBuilder sb = new StringBuilder();
//        if (num % 100 < 10) {
//            if (num % 100 != 0) sb.append(FIRST_NUM_TO_WORD[num % 100] + " ");
//            num = num / 100;
//        } else if (num % 100 < 20) {
//            sb.append(TENTH_NUM_TO_WORD[num % 100 - 10] + " ");
//            num = num / 100;
//        } else {
//            int firstNum = num % 10;
//            num = num / 10;
//            int secondNum = num % 10;
//            num = num / 10;
//            sb.append(SECOND_NUM_TO_WORD[secondNum] + " ");
//            if (firstNum != 0) sb.append(FIRST_NUM_TO_WORD[firstNum] + " ");
//        }
//        if (num != 0) {
//            sb.insert(0, FIRST_NUM_TO_WORD[num] + " Hundred ");
//        }
//        sb.deleteCharAt(sb.length() - 1); //remove last empty space
//        return sb.toString();
//    }
//
//    private static String[] TENTH_NUM_TO_WORD = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
//
//    private static String[] FIRST_NUM_TO_WORD = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
//
//    private static String[] SECOND_NUM_TO_WORD = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
//
//
//    private List<Integer> breakNum(int num) {
//        List<Integer> result = new ArrayList();
//        while (num != 0) {
//            result.add(num % 1000);
//            num = num / 1000;
//        }
//        return result;
//    }
}

/* My First Draft: Find mistakes in my code?
    public String numberToWords(int num) {
        String[] suffixArray = new String[]{"","Thousand","Million"};
        List<Integer> nums = breakNum(num);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<nums.size();i++){
            String word = convertToWords(nums.get(i));
            if(i!=0)word += " " + suffixArray[i];
            sb.prepend(word);
        }
    }

    private String convertToWords(Integer num){
        if(num == 0){
            return "";
        }
        String numStr = Integer.toString(num);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numStr.length;i++){
            sb.append(singleNumCharToWord(numStr.charAt(i)+" ");
        }
        sb.remove(sb.size()-1); //remove last empty space
        return sb.toString();
    }

    private static String[] FIRST_NUM_TO_WORD=new String[]{"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    private String singleNumCharToWord(Char num){
        return FIRST_NUM_TO_WORD[num-'0'];
    }

    private List<String> breakNum(int num){
        List<Integer> result = new ArrayList();
        while(num!=0){
            result.add(num%1000);
            num = num / 1000;
        }
        return result;
    }
 */
