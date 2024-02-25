public class Traversal {
    public static<T> String inOrder(BTNode<T> node) {
        if(node == null) return "";
        String sol=inOrder(node.left);
        String sag=inOrder(node.right);
        String donen=sol+" "+node.value+sag;
        return donen;
    }

    public static<T> String preOrder(BTNode<T> node) {
        if(node == null) return "";
        String sol=preOrder(node.left);
        String sag=preOrder(node.right);
        String donen=node.value+" "+sol+sag;
        return donen;
    }

    public static<T> String postOrder(BTNode<T> node) {
        if(node == null) return "";
        String sol=postOrder(node.left);
        String sag=postOrder(node.right);
        String donen=sol+sag+node.value+" ";
        return donen;
    }
}
