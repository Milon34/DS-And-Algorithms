package com.milon.java_live_course.DS_ALGO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Prims_Algorithms {
    private boolean unsettled[];
    private boolean settled[];
    private int numberOfVertices;
    private int adjacencyMatrix[][];
    private int key[];
    public static final int INFINITE=999;
    private int parent[];
    public Prims_Algorithms(int numberOfVertices){
        this.numberOfVertices=numberOfVertices;
        unsettled=new boolean[numberOfVertices+1];
        settled=new boolean[numberOfVertices+1];
        adjacencyMatrix=new int[numberOfVertices+1][numberOfVertices+1];
        key=new int[numberOfVertices+1];
        parent=new int[numberOfVertices+1];
    }
    public int getUnsettledCount(boolean unsettled[]){
        int count=0;
        for (int index=0;index<unsettled.length;index++){
            if (unsettled[index]){
                count++;
            }
        }
        return count;
    }
    public void primsAlgorithms(int adjacencyMatrix[][]){
        int evaluationVertex;
        for ( int source=1;source<=numberOfVertices;source++){
            for (int destination=1;destination<=numberOfVertices;destination++){
                this.adjacencyMatrix[source][destination]=adjacencyMatrix[source][destination];
            }
        }
        for (int index=1;index<=numberOfVertices;index++){
            key[index]=INFINITE;

        }
        key[1]=0;
        unsettled[1]=true;
        parent[1]=1;
        while (getUnsettledCount(unsettled)!=0){
            evaluationVertex=getMimumKeyVertexFromUnsettled(unsettled);
            unsettled[evaluationVertex]=false;
            settled[evaluationVertex]=true;
            evaluateNeighbours(evaluationVertex);
        }
    }
    public int getMimumKeyVertexFromUnsettled(boolean[] unsettled){
        int min=Integer.MAX_VALUE;
        int node=0;
        for (int vertex=1;vertex<=numberOfVertices;vertex++){
            if (unsettled[vertex]==true && key[vertex]<min){
                node=vertex;
                min=key[vertex];
            }
        }
        return node;
    }
    public  void evaluateNeighbours(int evaluationVertex ){
        for (int destinationVertex=1;destinationVertex<=numberOfVertices;destinationVertex++){
            if (settled[destinationVertex]==false){
                if (adjacencyMatrix[evaluationVertex][destinationVertex]!=INFINITE){
                    if (adjacencyMatrix[evaluationVertex][destinationVertex]<key[destinationVertex]){
                        key[destinationVertex]=adjacencyMatrix[evaluationVertex][destinationVertex];
                        parent[destinationVertex]=evaluationVertex;
                    }
                    unsettled[destinationVertex]=true;
                }
            }
        }
    }
public void printMinimumSpanningTree(){
    System.out.println("SOURCE  : DESTINATION = WEIGHT");
    for (int vertex=2;vertex<=numberOfVertices;vertex++){
        System.out.println(parent[vertex] + "\t:\t"+vertex +"\t:\t"+adjacencyMatrix[parent[vertex]][vertex]);
    }

}
public static void main(String[] args){
        int adjacency_Matrix[][];
        int number_of_vertices;
    Scanner sc=new Scanner(System.in);
    try {
        System.out.println("Entre the number of vertices:");
        number_of_vertices = sc.nextInt();
        adjacency_Matrix = new int[number_of_vertices + 1][number_of_vertices + 1];


        System.out.println("Enter the weighted matrix for the graph:");
        for (int i = 1; i <= number_of_vertices; i++) {
            for (int j = 1; j <= number_of_vertices; j++) {
                adjacency_Matrix[i][j] = sc.nextInt();
                if (i == j) {
                    adjacency_Matrix[i][j] = 0;
                    continue;
                }
                if (adjacency_Matrix[i][j] == 0) {
                    adjacency_Matrix[i][j] = INFINITE;
                }
            }
        }
        Prims_Algorithms prims = new Prims_Algorithms(number_of_vertices);
        prims.primsAlgorithms(adjacency_Matrix);
        prims.printMinimumSpanningTree();
    }catch (InputMismatchException inputMisMatch){
        System.out.println("Wrong Input Format.");
    }
    sc.close();
}

}
