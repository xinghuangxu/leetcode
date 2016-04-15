package leetcode;

import java.util.*;

/**
 * Created by xinghuangxu on 4/13/16.
 */
public class AlienDictionary {

    class Node{
        Character c;
        Node(Character c){
            this.c = c;
        }
        int inDegree =0;
        List<Node> children = new ArrayList();

        public void add(Node child) {
            children.add(child);
            child.inDegree++;
        }
    }


    public String alienOrder(String[] words) {
        List<Integer> locations = new ArrayList(words.length);
        for(int i=0;i<words.length;i++){
            locations.add(i);
        }


        List<List<Character>> ordersList = new ArrayList();
        findAlienOrder(locations, words, 0, ordersList);


        Map<Character, Node> map = new HashMap();
        for(String s:words){
            for(int i=0;i<s.length();i++){
                if(!map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),new Node(s.charAt(i)));
                }
            }
        }
        for(List<Character> orders: ordersList){
            if(!map.containsKey(orders.get(0))){
                map.put(orders.get(0),new Node(orders.get(0)));
            }
            for(int i=0;i<orders.size()-1;i++){

                Node parent = map.get(orders.get(i));
                Node child = map.get(orders.get(i+1));
                parent.add(child);
            }
        }
        List<Node> orderNodes = new LinkedList();
        Stack<Node> zeroInDegreeNodes = new Stack();
        for(Character key:map.keySet()){
            //insert(map.get(key),orderNodes);
            if(map.get(key).inDegree==0){
                zeroInDegreeNodes.add(map.get(key));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!zeroInDegreeNodes.isEmpty()){
            Node tmp = zeroInDegreeNodes.pop();
            if(map.containsKey(tmp.c)){
                sb.append(tmp.c);
                List<Node> children = tmp.children;
                for(Node node:children){
                    node.inDegree--;
                    if(node.inDegree==0){
                        zeroInDegreeNodes.add(node);
                    }
                }
                map.remove(tmp.c);
            }
        }

        for(Node node:orderNodes){
            sb.append(node.c);
        }
        if(map.keySet().size()!=0)return "";
        return sb.toString();
    }

    private void findAlienOrder(List<Integer> locations, String[] words, int curIndex, List<List<Character>> ordersList) {
        List<Character> orders = new ArrayList();
        Map<Character, List<Integer>> maps = new HashMap<Character, List<Integer>>();
        char prev = ' ';
        for(int i:locations){
            if(words[i].length()>curIndex){
                char c = words[i].charAt(curIndex);
                if(!maps.containsKey(c)){
                    maps.put(c, new ArrayList());
                }
                if(prev!=c){
                    orders.add(c);
                    prev = c;
                }
                maps.get(c).add(i);
            }
        }
        if(orders.size()>1){
            ordersList.add(orders);
        }
        for(Character key:maps.keySet()) {
            if (maps.get(key).size() > 1) {
                findAlienOrder(maps.get(key), words, curIndex + 1, ordersList);
            }
        }
    }
}
