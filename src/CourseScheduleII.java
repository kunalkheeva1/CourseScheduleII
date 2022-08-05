import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {


    static int[] courseSchedule(int n, int prerequisite [][]){
        ArrayList[] adj = new ArrayList[n];
        for(int i =0; i<n; i++){
            adj[i]= new ArrayList();
        }
        int []ans = new int[n];
        int index =0, count=0;

        int [] inDegree = new int[n];
        for(int i=0; i<n; i++){
            inDegree[i]=0;
        }

        for(int i=0; i<prerequisite.length; i++){
            int a = prerequisite[i][0];
            int b = prerequisite[i][1];
            adj[b].add(a);
            inDegree[a]++;
        }



        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
         int current = q.remove();
         ans[index] = current;
         index++;
         count++;

         for(int i=0; i<adj[current].size(); i++){
             int connection = (int)adj[current].get(i);
             inDegree[connection]--;
             if(inDegree[connection]==0){
                 q.add(connection);
             }
         }
        }
        if(count == n){
            return ans;
        }
        else{
            return new int[0];
        }




    }



    public static void main(String[] args) {

    }
}
