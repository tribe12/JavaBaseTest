package cn.wgh.designpattern.structural.composite;

/**
 * Created by wgh on 2020/12/26.
 */
public abstract class Node {
    abstract public void p();

    public static void printTree(Node node, int depth) {
        if (node != null) {
            for (int i = 0; i < depth; i++) {
                if (i != depth - 1) {
                    System.out.print("  ");
                } else {
                    System.out.print("|__");
                }
            }
            node.p();

            if (node instanceof BranchNode) {
                BranchNode branchNode = (BranchNode) node;

                for (Node n : branchNode.nodes) {
                    printTree(n, depth + 1);
                }
            }
        }
    }



    public static void printTree2(Node node, int depth) {
        if (node != null) {
            for (int i = 0; i < depth; i++) {
                if (i != depth - 1) {
                   /* if(){

                    }else{

                    }*/
                    System.out.print("  ");
                } else {
                    System.out.print("|__");
                }
            }
            node.p();

            if (node instanceof BranchNode) {
                BranchNode branchNode = (BranchNode) node;
                for (int i = 0; i < branchNode.nodes.size(); i++) {
                    if (i!=branchNode.nodes.size()-1){
                        System.out.print("|");
                    }
                    printTree2(branchNode.nodes.get(i), depth + 1);
                }
              /*  for (Node n : branchNode.nodes) {
                    printTree2(n, depth + 1);
                }*/
            }
        }
    }
}
