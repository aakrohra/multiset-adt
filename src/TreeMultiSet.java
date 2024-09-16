public class TreeMultiSet extends MultiSet {
    private Tree tree;
    public TreeMultiSet(){
        this.tree = new Tree();
    }
    /**
     * Add the given item to this multiset.
     *
     * @param item the item to add
     */
    @Override
    void add(Integer item) {
        tree.insert(item);
    }

    /**
     * Remove the given item from this multiset.
     * @param item the item to remove
     */
    @Override
    void remove(Integer item) {
        tree.delete_item(item);
    }
    /**
     * Return if the given item is contained in the multiset
     * @param item the item that is checked
     */
    @Override
    boolean contains(Integer item) {
        return tree.contains(item);
    }

    /**
     * Return if this multiset is empty
     */
    @Override
    boolean isEmpty() {
        return tree.treeIsEmpty();
    }

    /**
     * Count the number of given items in this multiset
     * @param item the item to count
     */
    @Override
    int count(Integer item) {
        return tree.count();
    }

    /**
     * Return size of this multiset
     */
    @Override
    int size() {
        return tree.getTotal();
    }

}
