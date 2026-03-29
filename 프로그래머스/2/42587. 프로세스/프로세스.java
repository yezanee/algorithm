import java.util.*;

class Node {
    int index;
    int priority;
    
    Node(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Node> queue = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++) {
            queue.add(new Node(i, priorities[i]));
        }
        
        int count = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            boolean hasHigher = false;

            for (Node node : queue) {
                if (node.priority > current.priority) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.add(current);
            } else {
                count++;
                if (current.index == location) {
                    return count;
                }
            }
        }
        
        return count;
    }
}