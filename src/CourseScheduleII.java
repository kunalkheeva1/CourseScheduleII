import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {

    //method int which 2d array states that the subject b needs to be done first in order to do a
    // lets get into the list of list first, like, what subjects will be due after it
    static int[] courseSchedule(int n, int prerequisite [][]){
        //get a list of list and store all the elements in it
        ArrayList[] adj = new ArrayList[n];
        for(int i =0; i<n; i++){
            adj[i]= new ArrayList();
        }

        // get an array to return answer and one array to store the indegrees of the elements
        //indegree states that how many subjects can reach a given particular one
        int []ans = new int[n];
        int index =0, count=0;

        int [] inDegree = new int[n];
        for(int i=0; i<n; i++){
            inDegree[i]=0;
        }


        //now take all the first idexes as a and second ones as b
        //which means if I do b, then how many a subjects are open to me.
        //also increase the indegree of all the a's as we will be approaching them after doing b
        for(int i=0; i<prerequisite.length; i++){
            int a = prerequisite[i][0];
            int b = prerequisite[i][1];
            adj[b].add(a);
            inDegree[a]++;
        }


        //if the indegree is 0 then store it in the queue
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }


        //until the queue is empty, delete the element store it in answer,
        //check its connections, and remove there inDegrees, as the element is removed,
        //so it wont be acting as the connection with them
        // also take count int to measure the numbers, as it could be empty or infinity arrays
        // only return if the count is n
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
