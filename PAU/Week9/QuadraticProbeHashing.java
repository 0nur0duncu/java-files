public class QuadraticProbeHashing<T> {
    public HashEntry<T>[] dizi;
    public int elemanSayisi;

    public QuadraticProbeHashing() {
        dizi=new HashEntry[23];
    }
    public QuadraticProbeHashing(int boyut){
        dizi=new HashEntry[boyut];
    }
    public int hash(T deger) {
        return deger.hashCode()%dizi.length;
    }

    public void ekle(T eleman){
        int i=0;
        int h =hash(eleman);
        while(dizi[(h+i*i)%dizi.length] != null && dizi[(h+i*i)% dizi.length].isActive) i++;
        dizi[(h+i*i)% dizi.length] = new HashEntry(eleman);
    }

    public boolean sil(T eleman){
        int i=0;
        int h =hash(eleman);
        while(dizi[(h+i*i)%dizi.length] != null){
            if(dizi[(h+i*i)%dizi.length].value.equals(eleman) && dizi[(h+i*i)%dizi.length].isActive){
                dizi[(h+i*i)%dizi.length].isActive = false;
                return true;
            }
            i++;}
        return false;
    }

}
