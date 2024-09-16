import java.util.ArrayList;
import java.util.List;

public class Tree {
    private Integer root;
    private ArrayList<Tree> subtrees;

    public Tree(int root, ArrayList<Tree> subtrees) {
        this.root = root;
        if (subtrees.isEmpty()) {
            this.subtrees = new ArrayList<>();
        } else {
            this.subtrees = subtrees;
        }
    }

    public boolean treeIsEmpty() {
        return (this.root == null);
    }

    public int getTotal() {
        if (this.treeIsEmpty()) { return 0; }
        else {
            int size = 1;
            for (Tree subtree : this.subtrees) {
                size += subtree.getTotal();
            }
            return size;
        }
    }

    public int count(int item) {
        if (this.treeIsEmpty()) { return 0; }
        else {
            int num = 0;
            if (this.root == item) { num += 1; }
            for (Tree subtree : this.subtrees) {
                num += subtree.count(item);
            }
            return num;
        }
    }

    @Override
    public String toString() {
        return this.toStringHelp(0);
    }

    public String toStringHelp(int depth) {
        if (this.treeIsEmpty()) { return ""; }
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < depth; i++) { sb.append(" "); }
            sb.append(this.root).append(System.lineSeparator());
            for (Tree subtree : this.subtrees) {
                sb.append(subtree.toStringHelp(depth + 1));
            }
            return sb.toString();
        }
    }

    public List<Integer> leaves() {
        if (this.treeIsEmpty()) { return new ArrayList<>(); }
        else if (this.subtrees.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(this.root);
            return temp;
        } else {
            ArrayList<Integer> leaves = new ArrayList<>();
            for (Tree subtree : this.subtrees) {
                leaves.addAll(subtree.leaves());
            }
            return leaves;
        }
    }
  
    /*
    TODO avg, equals, contains, leaves, mutated ones
     */
    private Integer root;
    private ArrayList<Tree> subtrees;

    /** Returns whether other is equal to the current tree
     * @param other the other object being checked
     */
    public boolean equals(Tree other){
        if (this.treeIsEmpty() && other.treeIsEmpty){
            return true;
        } else if (this.treeIsEmpty() || other.treeIsEmpty) {
            return false;
        } else {
            if (root.equals(other.root)) return false;
            if (subtrees.size() != other.size()) return false;
            return subtrees == other.subtrees;
        }
    }

    /*
    TODO toCompare ????
     */

    /**
    * Return whether obj is in this tree
    * @param obj object to be checked if they are in the tree or not
    */
    @Override
    public boolean contains(Object obj) {
        if (root == null) {
            return false;
        } else if (root.equals(obj)) {
            return true;
        } else {
            for (Tree i : subtrees){
                if (i.contains(obj)) return true;
            }
            return false;
        }
        return super.equals(obj);
    }
}
