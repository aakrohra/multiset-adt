public class Tree {
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
