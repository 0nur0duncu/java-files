public class Odev1Ogrenci extends DoublyLinkedList<Ilan> {
    /**
     * Bu metot bağlı listeye ekleme yaparken ilanların günlerinin küçükten büyüğe doğru sıralı olmasını sağlar
     * @param ilan Eklenecek ilan
     */
    public void guneGoreSiraliEkle(Ilan ilan) {
        if(isEmpty()) addFirst(ilan);//başlangıç düğümü için
        else{
            if(ilan.getGun()<=getHead().value.getGun()) addFirst(ilan);
            else if(ilan.getGun()>=getTail().value.getGun()) addLast(ilan);
            else{
                Node<Ilan> node=getHead();
                while(node!=null){
                    if(ilan.getGun()<=node.value.getGun()) break;
                    node=node.next;
                }
                Node<Ilan> newNode=new Node<>(ilan,node,node.previous);
                node.previous.next=newNode;
                node.previous=newNode;
                setSize(size()+1);
            }
        }
    }
    /**
     * Bu metot bağlı listeye ekleme yaparken ilanların fiyatlarının küçükten büyüğe doğru sıralı olmasını sağlar
     * @param ilan Eklenecek ilan
     */
    public void fiyataGoreSiraliEkle(Ilan ilan){
        if(isEmpty()) addFirst(ilan);//başlangıç düğümü için
        else{
            if(ilan.getFiyat()<=getHead().value.getFiyat()) addFirst(ilan);
            else if(ilan.getFiyat()>=getTail().value.getFiyat()) addLast(ilan);
            else{
                Node<Ilan> node=getHead();
                while(node!=null){
                    if(ilan.getFiyat()<=node.value.getFiyat()) break;
                    node=node.next;
                }
                Node<Ilan> newNode=new Node<>(ilan,node,node.previous);
                node.previous.next=newNode;
                node.previous=newNode;
                setSize(size()+1);
            }
        }
    }

    /**
     * Bu metot bağlı listeye ekleme yaparken ilanların günlerine göre sıralama yapar, eğer günleri aynı ise fiyatlarına göre kendi aralarında küçükten büyüğe sıralama yapar
     * @param ilan
     */
    public void guneVeFiyataGoreSiraliEkle(Ilan ilan) {
        if(isEmpty()) addFirst(ilan);//başlangıç düğümü için
        else{
            if(ilan.getGun()<getHead().value.getGun()) addFirst(ilan);
            else if(ilan.getGun()>getTail().value.getGun()) addLast(ilan);
            else{
                Node<Ilan> node=getHead();
                while(node!=null){
                    if(node==getHead() && ilan.getGun()==node.value.getGun()&&ilan.getFiyat()<node.value.getFiyat()){
                        addFirst(ilan);
                        break;
                    } 
                    else if(node==getTail() && ilan.getGun()==node.value.getGun() && ilan.getFiyat()>node.value.getFiyat()){
                        addLast(ilan);
                        break;
                    }
                    else if(ilan.getGun()<node.value.getGun()){
                        Node<Ilan> newNode=new Node<>(ilan,node,node.previous);
                        node.previous.next=newNode;
                        node.previous=newNode;
                        setSize(size()+1);
                        break; 
                    }
                    else if(ilan.getGun()==node.value.getGun()){
                        if(ilan.getFiyat()<=node.value.getFiyat()){
                            Node<Ilan> newNode=new Node<>(ilan,node,node.previous);
                            node.previous.next=newNode;
                            node.previous=newNode;
                            setSize(size()+1);
                            break;
                        }
                    }
                    node=node.next;
                }
            }
        }
    }
}