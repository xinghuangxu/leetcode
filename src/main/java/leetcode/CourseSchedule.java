package leetcode;

import lombok.AllArgsConstructor;

import java.util.*;

/**
 * Created by xinghuangxu on 8/18/15.
 */
public class CourseSchedule {

    class Node{
        int key;
        Node(int key){
            this.key = key;
        }
        int inDegree=0;
        List<Node> children=new ArrayList();

        public void add(Node child) {
            children.add(child);
            child.inDegree++;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,Node> map = new HashMap();
        for(int i=0;i<numCourses;i++){
            map.put(i,new Node(i));
        }
        for(int[] sequence: prerequisites){
            Node child = map.get(sequence[0]);
            Node parent = map.get(sequence[1]);
            parent.add(child);
        }
        Stack<Node> stack = new Stack();
        for(Integer key:map.keySet()){
            if(map.get(key).inDegree==0){
                stack.add(map.get(key));
            }
        }
        while(!stack.isEmpty()){
            Node tmp = stack.pop();
            if(map.containsKey(tmp.key)){
                map.remove(tmp.key);
                List<Node> children = tmp.children;
                for(Node child:children){
                    child.inDegree--;
                    if(child.inDegree==0){
                        stack.add(child);
                    }
                }
            }
        }
        if(map.keySet().size()==0)return true;
        return false;
    }
    /*
    private class Node{
        private Node(int id){
            this.id = id;
        }
        int id;
        int level=-1;
        List<Node> prerequisite = new ArrayList<Node>();
        List<Node> children= new ArrayList<Node>();

        public void addChildren(Node child){
            children.add(child);
        }

        public void addPrerequisite(Node node){
            prerequisite.add(node);
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || numCourses ==1) return true;
        Node[] nodes = new Node[numCourses];

        for(int i=0;i<numCourses;i++){
            nodes[i]=new Node(i);
        }

        //initialize nodes
        for(int i=0;i<prerequisites.length;i++){
            int[] pair = prerequisites[i];
            int destination = pair[0];
            int source = pair[1];
            nodes[source].addChildren(nodes[destination]);
            nodes[destination].addPrerequisite(nodes[source]);
        }

        //depth traversal
        List<Node> roots = new ArrayList();
        for(int i=0;i<nodes.length;i++){
            if(nodes[i].prerequisite.isEmpty()){
                roots.add(nodes[i]);
            }
        }
        if(roots.isEmpty())return false;
        return !findLoop(numCourses,roots);
    }

    private boolean findLoop(int numCourses, List<Node> roots) {
        List<Node> frontiers = roots;
        int level =0;
        boolean[] visited = new boolean[numCourses];
        int leftSteps = numCourses;
        while(!frontiers.isEmpty()){
            for(int i=0;i<frontiers.size();i++){
                visited[frontiers.get(i).id]=true;
            }
            if(leftSteps==0)return true;
            level++;
            List<Node> newFrontiers = new ArrayList<Node>();
            for(int i=0;i<frontiers.size();i++){
                for(int j=0;j<frontiers.get(i).children.size();j++){
                    int nodeLevel = frontiers.get(i).children.get(j).level;
                    if(nodeLevel!=level){
                        Node node = frontiers.get(i).children.get(j);
                        node.level = level;
                        newFrontiers.add(node);
                    }
                }
            }
            frontiers = newFrontiers;
            leftSteps--;
        }
        for(int i=0;i<numCourses;i++){
            if(!visited[i])return true;
        }
        return false;
    }
*/
}
