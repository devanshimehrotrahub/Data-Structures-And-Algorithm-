import java.util.*;

public class Graph {
  public ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

  public Graph(ArrayList<GraphNode> nodeList) {
    this.nodeList = nodeList;
  }

  public void addUndirectedEdge(int i, int j) {
    GraphNode first = nodeList.get(i);
    GraphNode second = nodeList.get(j);

    first.neighbors.add(second);
    second.neighbors.add(first);
  }

  public void printGraph() {
    for (GraphNode gn : nodeList) {
      System.out.print(gn.name + ": ");
      for (int n = 0; n < gn.neighbors.size(); n++) {
        if (n == (gn.neighbors.size() - 1))
          System.out.print(gn.neighbors.get(n).name);
        else
          System.out.print(gn.neighbors.get(n).name + " -> ");

      }
      System.out.println();
    }
  }

  void bfsVisit(GraphNode node) {
    LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
    queue.add(node);
    while (!queue.isEmpty()) {
      GraphNode currentNode = queue.remove(0);
      currentNode.isVisited = true;
      System.out.print(currentNode.name + " ");
      for (GraphNode neighbor : currentNode.neighbors) {
        if (!neighbor.isVisited) {
          queue.add(neighbor);
          neighbor.isVisited = true;
        }
      }
    }
  }

 
   public void bfs() {
    for (GraphNode node : nodeList) {
      if (!node.isVisited) {
        bfsVisit(node);
      }
    }
  }

  void dfsVisit(GraphNode node) {
    Stack<GraphNode> stack = new Stack<>();
    stack.push(node);
    while (!stack.isEmpty()) {
      GraphNode currentNode = stack.pop();
      currentNode.isVisited = true;
      System.out.print(currentNode.name + " ");
      for (GraphNode neighbor : currentNode.neighbors) {
        if (!neighbor.isVisited) {
          stack.push(neighbor);
          neighbor.isVisited = true;
        }
      }
    }
  }

  public void dfs() {
    for (GraphNode node : nodeList) {
      if (!node.isVisited) {
        dfsVisit(node);
      }
    }
  }

}
