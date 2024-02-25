public class LabBinarySearchTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    public LabBinarySearchTree(){
        //Bu metodu değiştirmeyin
    }
    public LabBinarySearchTree(BTNode<T> root) {
        //Bu metodu değiştirmeyin
        super(root);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        BTNode<T> node=clone(getRoot());//private olduğu için böyle kullanıldı.
        LabBinarySearchTree<T> lbst=new LabBinarySearchTree<>(node);
        return lbst;
    }
    private BTNode<T> clone(BTNode<T> node){
        if(node==null){
            return null;
        }
        BTNode<T> left=clone(node.left);
        BTNode<T> right=clone(node.right);
        return new BTNode<>(node.value,left,right);
    }
    

    @Override
    public BTNode<T> successor(T value) {
        BTNode<T> node= find(getRoot(),value);
        if(node==null) return null;
        node=node.right;
        if(node==null) return null;
        while(node.left !=null){
            node=node.left;
        }

        return node;
    }

    @Override
    public BTNode<T> predecessor(T value) {
        BTNode<T> node= find(getRoot(),value);
        if(node==null) return null;
        node=node.left;
        if(node==null) return null;
        while(node.right !=null){
            node=node.right;
        }

        return node;
    }

    @Override
    public BTNode<T> findParent(BTNode<T> node) {
        BTNode<T> current =getRoot();
        while(current != null){
            if(current.left ==node || current.right == node){
                return current;
            }
            else if(node.value.compareTo(current.value)>0){
                current =current.right;
            }
            else current =current.left;
        }
        return null;
    }
    
}
