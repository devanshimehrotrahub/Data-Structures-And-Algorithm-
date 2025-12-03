import java.util.ArrayList;

public class GraphNode {
   public String name;
   public int index;
   public ArrayList<GraphNode> neighbors = new ArrayList();

   public GraphNode(String var1, int var2) {
      this.name = var1;
      this.index = var2;
   }
}
