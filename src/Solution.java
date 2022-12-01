import visitorpattern.*;
import visitorpattern.visitor.FancyVisitor;
import visitorpattern.visitor.ProductOfRedNodesVisitor;
import visitorpattern.visitor.SumInLeavesVisitor;

import java.util.*;

public class Solution {

    private static int[] values;
    private static Color[] colors;
    private static Map<Integer, Set<Integer>> edges = new HashMap<>();

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner scanner = new Scanner(System.in);
        int numberOfNodes = scanner.nextInt();
        values = new int[numberOfNodes + 1];
        colors = new Color[numberOfNodes + 1];
        for (int i = 1; i <= numberOfNodes; i++) {
            values[i] = scanner.nextInt();
        }
        for (int i = 1; i <= numberOfNodes; i++) {
            colors[i] = scanner.nextInt() == 0 ? Color.RED : Color.GREEN;
        }
        for (int i = 1; i < numberOfNodes; i++) {
            int nodeOne = scanner.nextInt();
            int nodeTwo = scanner.nextInt();
            if (edges.containsKey(nodeOne)) {
                edges.get(nodeOne).add(nodeTwo);
            } else {
                Set<Integer> nodeEdges = new HashSet<>();
                nodeEdges.add(nodeTwo);
                edges.put(nodeOne, nodeEdges);
            }
            if (edges.containsKey(nodeTwo)) {
                edges.get(nodeTwo).add(nodeOne);
            } else {
                Set<Integer> nodeEdges = new HashSet<>();
                nodeEdges.add(nodeOne);
                edges.put(nodeTwo, nodeEdges);
            }
        }

        TreeNode root = new TreeNode(values[1], colors[1], 0);
        for (int i : edges.get(1)) {
            edges.get(i).remove(1);
            connectEdge(root, i);
        }
        return root;
    }

    private static void connectEdge(TreeNode parent, int nodeToConnect) {
        if (edges.get(nodeToConnect).size() == 0) {
            TreeLeaf leaf = new TreeLeaf(values[nodeToConnect], colors[nodeToConnect], parent.getDepth() + 1);
            parent.addChild(leaf);
            return;
        }
        TreeNode node = new TreeNode(values[nodeToConnect], colors[nodeToConnect], parent.getDepth() + 1);
        parent.addChild(node);
        for (int child : edges.get(nodeToConnect)) {
            edges.get(child).remove(nodeToConnect);
            connectEdge(node, child);
        }
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }

}