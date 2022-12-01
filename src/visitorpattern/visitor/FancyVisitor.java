package visitorpattern.visitor;

import visitorpattern.Color;
import visitorpattern.TreeLeaf;
import visitorpattern.TreeNode;

public class FancyVisitor extends TreeVis {
    private int evenNonLeafNodes = 0;
    private int greenLeafNodes = 0;

    public int getResult() {
        //implement this
        return Math.abs(evenNonLeafNodes - greenLeafNodes);
    }

    public void visitNode(TreeNode node) {
        //implement this
        if (node.getDepth() % 2 == 0) {
            evenNonLeafNodes += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if (Color.GREEN.equals(leaf.getColor())) {
            greenLeafNodes += leaf.getValue();
        }
    }
}
