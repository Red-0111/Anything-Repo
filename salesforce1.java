import java.util.*;

public class salesforce1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            int N = sc.nextInt();
            System.out.println(fun2(N));
        }
        
    }

    private static int fun2(int N){
        ArrayList<Integer> graph[]=new ArrayList[N+1];

        for(int i=1;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        for(int j=1;j<graph.length;j++){
            for(int i=1;i<graph.length;i++){
                if(j>i && j%i==0) graph[i].add(j);
            }
        }
        boolean visited[]=new boolean[N+1];
        count=0;
        dfs(1, visited, graph,N);
        return count;
    }
    static int count=0;

    private static void dfs(int i,boolean[] visited,ArrayList<Integer> graph[],int N){
        if(i==N){
            count++;
            return;
        }
        visited[i]=true;
        for(int node:graph[i]){
            if(visited[node]==false){
                dfs(node,visited,graph,N);
            }
        }
        visited[i]=false;
    }
}

