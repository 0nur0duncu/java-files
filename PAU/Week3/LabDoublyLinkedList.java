public class LabDoublyLinkedList<T> extends DoublyLinkedList<T> {
    /**
     * Çift bağlı listenin istenilen konumuna eleman ekler
     * @param index konum
     * @param value eklenecek eleman
     */
    @Override
    public void insertAt(int index, T value) {
        if(index==0) addFirst(value);
        else if(index==size()) addLast(value);
        else{
            int i=0;
            Node<T> node=getHead();
            while(node!=null && i<index){
                node=node.next;//konum olarak 2.elemanda çıkacak.
                i++;
            }
            Node<T> newNode=new Node<>(value,node,node.previous);
            node.previous.next=newNode;
            node.previous=newNode;
            setSize(size()+1);
        }
    }

    /**
     * Verilen konumdaki elemanı siler
     * @param index silinecek elemanın konumu
     * @return silinen değer
     */
    @Override
    public T removeAt(int index) {
        if(index==0) return removeFirst();
        else if(index==size()-1) return removeLast();//son elemanın konumudan dolayı
        else{
            int i=0;
            Node<T> node=getHead();
            while(node!=null && i<index){
                node=node.next;//konum olarak 2.elemanda çıkacak.
                i++;
        }
        node.previous.next=node.next;
        node.next.previous=node.previous;
        setSize(size()-1);
        return node.value;
        }
    }
}
