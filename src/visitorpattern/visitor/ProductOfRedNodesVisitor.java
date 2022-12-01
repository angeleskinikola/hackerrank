package visitorpattern.visitor;

import visitorpattern.Color;
import visitorpattern.TreeLeaf;
import visitorpattern.TreeNode;

public class ProductOfRedNodesVisitor extends TreeVis {
    private long res = 1;
    public int getResult() {
        //implement this
        return (int) res;
    }

    public void visitNode(TreeNode node) {
        //implement this
        if (Color.RED.equals(node.getColor())) {
            res = (res * node.getValue()) % 1000000007;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if (Color.RED.equals(leaf.getColor())) {
            res = (res * leaf.getValue()) % 1000000007;
        }
    }
}
