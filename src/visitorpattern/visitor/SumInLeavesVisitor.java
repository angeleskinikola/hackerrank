package visitorpattern.visitor;

import visitorpattern.TreeLeaf;
import visitorpattern.TreeNode;

public class SumInLeavesVisitor extends TreeVis {
    private int res = 0;
    public int getResult() {

        return res;
    }

    public void visitNode(TreeNode node) {
        //implement this

    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        res += leaf.getValue();
    }
}
