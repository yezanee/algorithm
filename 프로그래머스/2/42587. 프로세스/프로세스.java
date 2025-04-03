import java.util.*;

class Solution {
    public static class Document {
        int prior;
        int index;
        
        Document(int prior, int index) {
            this.prior = prior;
            this.index = index;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Document> queue = new LinkedList<>(); // 실행 대기 큐
        boolean isPrior;
        int result = 0;
        
        for(int i=0; i<priorities.length; i++) {
            queue.add(new Document(priorities[i], i)); // 우선순위랑 위치 큐에 저장
        }
                      
        while(!queue.isEmpty()) {
            Document save = queue.poll(); // 대기 중인 프로세스 하나 꺼냄.
            isPrior = false;
        
            for(Document doc : queue) {
                if(doc.prior > save.prior) {
                    isPrior = true;
                    break;
                }
            }
            
            if (isPrior) { // 큐에 다시 넣기
                queue.add(save);
            } else {
                // 없다면 그대로 실행 후 종료
                result++;
                
                if(save.index == location) {
                    break;
                }
            }            
        }

        return result;
    }
}