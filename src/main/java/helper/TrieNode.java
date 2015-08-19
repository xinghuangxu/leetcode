package helper;

/**
 * Created by xinghuangxu on 8/18/15.
 */
class TrieNode {

    boolean isWord = false;

    TrieNode[] children = new TrieNode[26];

    void add(int location, String word) {
        if (location == word.length()) {
            isWord = true;
            return;
        }
        int index = word.charAt(location) - 'a';
        if (children[index] == null) {
            children[index] = new TrieNode();
        }
        children[index].add(location + 1, word);
    }

    // Initialize your data structure here.
    public TrieNode() {

    }

    public boolean search(int i, String word) {
        if(i == word.length()){
            return isWord;
        }
        if(children[word.charAt(i)-'a']!=null){
            return children[word.charAt(i)-'a'].search(i+1,word);
        }
        return false;
    }

    public boolean startsWith(int i, String prefix) {
        if(i == prefix.length()){
            return true;
        }else if(children[prefix.charAt(i)-'a']!=null){
            return children[prefix.charAt(i)-'a'].startsWith(i+1,prefix);
        }else{
            return false;
        }
    }
}