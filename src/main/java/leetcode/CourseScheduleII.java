package leetcode;

import java.util.*;

/**
 * Created by Xinghuang Leon Xu on 11/1/2015.
 */
public class CourseScheduleII {

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

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,Node> map = new HashMap();
        int[] courses = new int[numCourses];
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
        int i=0;
        while(!stack.isEmpty()){
            Node tmp = stack.pop();
            if(map.containsKey(tmp.key)){
                courses[i++]=tmp.key;
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
        if(map.keySet().size()==0)return courses;
        return new int[]{};
    }

    /*
    class Node {
        int id;

        Node(int id) {
            this.id = id;
        }

        List<Node> parents = new ArrayList<Node>();
        List<Node> children = new ArrayList<Node>();

        void addChild(Node child) {
            children.add(child);
        }

        void addParent(Node parent) {
            parents.add(parent);
        }

        public void removeChildrenLinks() {
            for (Node child : children) {
                child.parents.remove(this);
            }
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Node> courses = new ArrayList(numCourses);
        Set<String> used = new HashSet<String>();
        for (int i = 0; i < numCourses; i++) {
            courses.add(new Node(i));
        }
        for (int i = 0; i < prerequisites.length; i++) {
            if (!used.contains(prerequisites[i][0] + "," + prerequisites[i][1])) {
                courses.get(prerequisites[i][0]).addParent(courses.get(prerequisites[i][1]));
                courses.get(prerequisites[i][1]).addChild(courses.get(prerequisites[i][0]));
                used.add(prerequisites[i][0] + "," + prerequisites[i][1]);
            }
        }
        int[] result = new int[numCourses];
        int curIndex = 0;
        Queue<Node> queue = new ArrayDeque<Node>();
        for (int i = 0; i < numCourses; i++) {
            if (courses.get(i).parents.isEmpty()) {
                queue.add(courses.get(i));
            }
        }
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            result[curIndex++] = tmp.id;
            tmp.removeChildrenLinks();
            for (Node child : tmp.children) {
                if (child.parents.isEmpty()) {
                    queue.add(child);
                }
            }
        }
        if (curIndex == numCourses) {
            return result;
        }
        return new int[0];
    }
    */
}
