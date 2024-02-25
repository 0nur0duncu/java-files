public class Odev2Ogrenci {
    /**
     * maximum metodu kök düğümü verilen ikili ağacın içindeki en büyük değeri bulur. 
     * Verilen ağaç arama ağacı olmayabilir. Bu nedenle sürekli sağa giderek en büyük
     * değeri bulamayabilirsiniz. Problemi özyineleme(recursion) kullanarak çözebilirsiniz,
     * sadece while döngüsü işe yaramayacaktır.
     * @param node Ağacın kök düğümü
     * @return Ağaçtaki en büyük değer
     */
    public static int maksimum(BTNode<Integer> node) {
        if(node == null) return 0;
        int sol=maksimum(node.left);
        int sag=maksimum(node.right);
        if(sol>=sag && sol>=node.value) return sol;
        else if(sag>=sol && sag>=node.value) return sag;
        else return node.value;
    }
    /**
     * Ağacın düğümlerindeki değerlerin toplamını hesaplar
     * @param node Ağacın kök düğümü
     * @return Ağaçtaki düğümlerin değerlerinin toplamı
     */
    public static int toplam(BTNode<Integer> node) {
        if(node == null) return 0;
        int sol=toplam(node.left);
        int sag=toplam(node.right);
        return node.value+sol+sag;
    }

    /**
     * Ağaçtaki düğüm sayısını verir.
     * @param node Ağacın kök düğümü
     * @return Düğüm sayısını döndürür
     */
    public static int dugumSayisi(BTNode<Integer> node) {
        if(node == null) return 0;
        int sol=dugumSayisi(node.left);
        int sag=dugumSayisi(node.right);
        int nodes=sol+sag+1;
        return nodes;
    }

    /**
     * Ağacın yüksekliğini verir
     * @param node Ağacın kök düğümü
     * @return Ağacın yüksekliği
     */
    public static int yukseklik(BTNode<Integer> node) {
        if(node == null) return 0;
        int sol=yukseklik(node.left);
        int sag=yukseklik(node.right);
        if(sag>=sol) return sag+1;
        else return sol+1;
    }
}