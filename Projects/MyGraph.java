import java.util.*;
public class MyGraph {
    private int nVertices;
    private int transitiveMatrix[][];
    
    
    public MyGraph(int nVertices){
        
        transitiveMatrix = new int [nVertices+1][nVertices+1];
        this.nVertices = nVertices;
    }
   public void warshall(int adjacencyMatrix[][]){
       
        for (int i = 1; i <= nVertices; i++){
            for (int j = 1; j <= nVertices; j++){
                transitiveMatrix[i][j] = adjacencyMatrix[i][j];
            }
        }
        for (int k = 1; k <= nVertices; k++){
            for (int i = 1; i <= nVertices; i++){
                for (int j = 1; j <= nVertices; j++){
                    if (transitiveMatrix[i][k]+ transitiveMatrix[k][j] < transitiveMatrix[i][j]){
                        transitiveMatrix[i][j] = transitiveMatrix[i][k] + transitiveMatrix[k][j];
                    }
                }
            }
        }
        for (int i = 1; i <= nVertices; i++){
            System.out.print("\t"+ i);
        }
        
        System.out.println("");
        for (int i = 1; i <= nVertices; i++){
            System.out.print(i + "\t");
            for (int j = 1; j <= nVertices; j++){
                System.out.print(transitiveMatrix[i][j] + "\t");
            }
            System.out.println("");
        }
    }
   
   public static void main(String... arg){
            int adjacencyMatrix[][];
            int nVertices;
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter the number of vertices: ");
            nVertices = scan.nextInt();
            
            adjacencyMatrix = new int[nVertices + 1][nVertices + 1];
            System.out.println("Enter the Weighted Matrix for the graph");
            
            for (int i = 1; i <= nVertices; i++){
                for (int j = 1; j <= nVertices; j++){
                    adjacencyMatrix[i][j] = scan.nextInt();
                    if (i == j){
                        adjacencyMatrix[i][j] = 0;
                        continue;
                    }
                    if (adjacencyMatrix[i][j] == 0){
                        adjacencyMatrix[i][j] = 000;
                    }
                }
            }
            System.out.println("The Transitive Closure of Graph");
            MyGraph floydwarshall = new MyGraph(nVertices);
            floydwarshall.warshall(adjacencyMatrix);
            scan.close();
    }
   
}
