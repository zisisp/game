import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zpontikas on 2/13/2017.
 */
public class BreadthFirstAndDepthFirst {

    List<TreeNode> toCheck=new ArrayList<>();

    private static class TreeNode {
        final TreeNode left;
        final TreeNode right;
        private String value;
        public boolean visited;

        private TreeNode(TreeNode left, TreeNode right,String value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

    }
    private static TreeNode getTree() {
        TreeNode f=new TreeNode(null,null,"F");
        TreeNode e=new TreeNode(null,null,"E");
        TreeNode d=new TreeNode(null,null,"D");
        TreeNode b=new TreeNode(d,null,"B");
        TreeNode c=new TreeNode(e,f,"C");
        TreeNode a=new TreeNode(b,c,"A");
        return a;
    }

    public static void main(String[] args) {
        TreeNode testTree= getTree();
        String breadthFirst=breadthFirst(testTree);
        String depthFirst=depthFirst(getTree());
        System.out.println("breadthFirst = " + breadthFirst);
        System.out.println("depthFirst = " + depthFirst);
    }

    private static String breadthFirst(TreeNode a) {
        a.visited=true;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(a);
        StringBuilder sb=new StringBuilder();
        appendNode(a, sb);
        while (!stack.isEmpty()) {
            TreeNode notVisited=getNotVisitedNode(stack.peek());
            if (notVisited == null) {
                stack.pop();
            } else {
                notVisited.visited=true;
                appendNode(notVisited,sb);
                stack.push(notVisited);
            }
        }
        return sb.toString().replaceFirst(",","");
    }

    private static TreeNode getNotVisitedNode(TreeNode peek) {
        if (peek.left != null && !peek.left.visited) {
            return peek.left;
        } else if (peek.right != null && !peek.right.visited) {
            return peek.right;
        }
        else return null;
    }

    private static StringBuilder appendNode(TreeNode node, StringBuilder sb) {
        return sb.append(","+node.value);
    }

    private static String depthFirst(TreeNode a) {
        a.visited=true;
        LinkedList<TreeNode> queue=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        appendNode(a,sb);
        queue.push(a);
        TreeNode checkedNode;

        while (!queue.isEmpty()) {
            TreeNode removed= queue.remove();
            while ((checkedNode=getNotVisitedNode(removed))!=null) {
                checkedNode.visited=true;
                queue.push(checkedNode);
                appendNode(checkedNode,sb);
            }
        }
        return sb.toString().replaceFirst(",","");
    }
}
