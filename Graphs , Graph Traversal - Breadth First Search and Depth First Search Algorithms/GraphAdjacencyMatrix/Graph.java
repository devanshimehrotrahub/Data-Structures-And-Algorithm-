
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
  ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
  int AdjacencyMatrix[][];

  public Graph(ArrayList<GraphNode> nodeList) {
    this.nodeList = nodeList;
    int len = nodeList.size();
    AdjacencyMatrix = new int[len][len];
  }

  public void addUndirectedEdge(int i, int j) {
    AdjacencyMatrix[i][j] = 1;
    AdjacencyMatrix[j][i] = 1;
  }

  public void printGraph() {
    System.out.print("   ");
    for (int i = 0; i < nodeList.size(); i++) {
      System.out.print(nodeList.get(i).name + " ");
    }
    System.out.println();
    for (int i = 0; i < AdjacencyMatrix.length; i++) {
      System.out.print(nodeList.get(i).name + ": ");
      for (int j = 0; j < AdjacencyMatrix.length; j++) {
        System.out.print(AdjacencyMatrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public ArrayList<GraphNode> getNeighbors(GraphNode node) {
    ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
    for (int i = 0; i < AdjacencyMatrix.length; i++) {
      if (AdjacencyMatrix[node.index][i] == 1) {
        neighbors.add(nodeList.get(i));
      }
    }
    return neighbors;
  }

  void bfsVisit(GraphNode node) {
    LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
    queue.add(node);
    while (!queue.isEmpty()) {
      GraphNode currentNode = queue.remove(0);
      currentNode.isVisited = true;

      System.out.print(currentNode.name + " ");

      ArrayList<GraphNode> neighbors = getNeighbors(currentNode);

      for (GraphNode neighbor : neighbors) {
        if (!neighbor.isVisited) {
          queue.add(neighbor);
          neighbor.isVisited = true;
        }
      }

    }
  }

  public void bfs() {
    bfsVisit(nodeList.get(0));
  }

  void dfsVisit(GraphNode node) {
    Stack<GraphNode> stack = new Stack<>();
    stack.push(node);
    while (!stack.isEmpty()) {
      GraphNode currentNode = stack.pop();
      currentNode.isVisited = true;

      System.out.print(currentNode.name + " ");

      ArrayList<GraphNode> neighbors = getNeighbors(currentNode);

      for (GraphNode neighbor : neighbors) {
        if (!neighbor.isVisited) {
          stack.push(neighbor);
          neighbor.isVisited = true;
        }
      }

    }
  }

  public void dfs() {
    dfsVisit(nodeList.get(0));
  }
}
