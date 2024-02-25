import java.util.LinkedList;

public class SeperatedChainHash {
    public LinkedList<Integer>[] dizi;
    //nesne tipininn default değeri null
    //integer tipinin default değeri sıfırdır.
    public SeperatedChainHash() {//default değeri
        dizi=new LinkedList[23];
    }
    public SeperatedChainHash(int boyut) {//kendimiz boyutu belirleriz.
        dizi=new LinkedList[boyut];
    }
    public int hash(int deger){
        //dizinin boyutuna göre mod alır.
        return deger%dizi.length;
    }
    public void ekle(int deger){
        int konum=hash(deger);
        if(dizi[konum] == null)
            dizi[konum]=new LinkedList<>();
        dizi[konum].add(deger);    
    }
    public boolean sil(int deger){
        int konum=hash(deger);
        if(dizi[konum] == null)
            return false;
        else if(dizi[konum].contains(deger)){
            //dizi[konum].remove(new Integer(deger));//object tipinde
            dizi[konum].remove(dizi[konum].indexOf(deger));
            return true;
        }
        return false;
    }
    protected boolean isPrime(int sayi){
        for(int i=2;i<sayi/2;i++) //sayının yarısına ya da 
        //karekökünün +1 fazlasına gidilebilir.
            if(sayi%i==0) 
                return false;
        return true;
    }
    public void yenidenOzetle() {
        int newSize=2*dizi.length+1;
        while(!isPrime(newSize))
            newSize++;
        LinkedList<Integer>[] oldArray=dizi;
        dizi=new LinkedList[newSize];
        for(int i=0;i<oldArray.length;i++){
            if(oldArray[i] !=null){
                for(int value:oldArray[i]) ekle(value);
            }
        }
    }
}
