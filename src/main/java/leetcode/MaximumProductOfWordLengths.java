package leetcode;

/**
 * Created by xinghuangxu on 3/23/16.
 */
public class MaximumProductOfWordLengths {
    //solution with bit

    public int maxProduct(String[] words) {
        int maxProdWordLengths = 0;
        int size = words.length;
        int[] values = new int[size];
        for (int i = 0; i < size; i++) {
            String w = words[i];
            values[i] = 0;
            for (int j = 0; j < w.length(); j++) {
                values[i] = values[i] | 1 << (w.charAt(j) - 'a');
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if ((values[i] & values[j]) == 0) {
                    int tmpProd = words[i].length() * words[j].length();
                    if (tmpProd > maxProdWordLengths) {
                        maxProdWordLengths = tmpProd;
                    }
                }
            }
        }
        return maxProdWordLengths;
    }


    boolean[][] map = new boolean[26][];

    public int maxProduct2(String[] words) {
        int size = words.length;
        int[] lengthArray = new int[size];
        for (int i = 0; i < 26; i++) {
            map[i] = new boolean[size];
        }
        for (int i = 0; i < size; i++) {
            lengthArray[i] = words[i].length();
        }
        setBooleanMap(words);

        int maxProdWordLengths = 0;
        for (int i = 0; i < size; i++) {
            boolean[] wordsContainSameChar = new boolean[size];
            String w = words[i];
            for (int j = 0; j < w.length(); j++) {
                int charIndex = w.charAt(j) - 'a';
                boolean[] wordsContainingChar = map[charIndex];
                for (int k = i + 1; k < size; k++) {
                    if (wordsContainingChar[k]) {
                        wordsContainSameChar[k] = true;
                    }
                }
            }
            for (int j = i + 1; j < size; j++) {
                if (!wordsContainSameChar[j]) {
                    int prod = lengthArray[i] * lengthArray[j];
                    if (prod > maxProdWordLengths) {
                        maxProdWordLengths = prod;
                    }
                }
            }
        }

        return maxProdWordLengths;
    }

    private void setBooleanMap(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            for (int j = 0; j < w.length(); j++) {
                int charIndex = w.charAt(j) - 'a';
                map[charIndex][i] = true;
            }
        }
    }
}
