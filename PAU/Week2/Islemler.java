import java.util.*;

/**
 * Islemler sınıfı içindeki 4 metodun yazılması istenmektedir
 */
public class Islemler {
    /**
     * Yığıtın elemnlarının sırasını tersine çevirir
     * @param s Tersine çevrilecek yığıt
     * @return Tersine çevirlmiş yığıtı döndürür
     */
    public static <T> Stack<T> tersCevir(Stack<T> s){
        Stack<T> yedek=(Stack<T>) s.clone();
        Stack<T> bos=new Stack<>();
        while(!yedek.isEmpty())
            bos.push(yedek.pop());
        return bos;
    }

    /**
     * İki yığıtın eşit olup olmadığını kontrol eder
     * @param s1 Birinci yığıt
     * @param s2 İkinci yığıt
     * @return İki yığıtın eşit olma durumunu döndürür
     */
    public static <T> boolean esit(Stack<T> s1, Stack<T> s2)
    {
        //Metodun gövdesini yazınız
        if(s1.size() !=s2.size())
            return false;
        Stack<T> yedek1=(Stack<T>) s1.clone();
        Stack<T> yedek2=(Stack<T>) s2.clone();
        while(!yedek1.isEmpty()){
            if(!yedek1.pop().equals(yedek2.pop()))
                   return false;
        }
        return true;
    }

    /**
     * Postfix ifadeyi değerlendirir. İşlemler tamsayılar üzerinde gerçekleşir. "7 5 /" işleminin sonucu 1'dir.
     * @param girdi Girdi ifadesi
     * @return İfadenin sonucu
     */
    public static int postfixDegerlendir(String girdi) {
        //Metodun gövdesini yazınız
        Stack<Integer> stack= new Stack<>();
        String[] semboller=splitToTokens(girdi);
        for(String o:semboller){
            if(o.equals("+") || o.equals("-")|| o.equals("*") || o.equals("/")){
                int d1=stack.pop();
                int d2=stack.pop();
                int sonuc=0;
                if(o.equals("+"))
                     sonuc=d1+d2;    
                if(o.equals("-"))
                     sonuc=d2-d1; 
                if(o.equals("*"))
                     sonuc=d1*d2; 
                if(o.equals("/"))
                     sonuc=d2/d1;
                stack.push(sonuc);
            }
            else{
                stack.push(Integer.parseInt(o));
            }
        }
        return stack.pop();
    }
    public static int oncelik(String o){
        if(o.equals("+") || o.equals("-")) return 1;
        else if(o.equals("*") || o.equals("/")) return 2;
        else return 0;
    }

    /**
     * Infix ifadeyi postfix'e dönüştürür.
     * @param girdi Infix girdi metni
     * @return Dönüştürülmüş postfix ifade
     */
    public static String infixToPostfix(String girdi){
        Stack<String> opstack= new Stack<>();
        ArrayList<String> cikti= new ArrayList<>();
        String[] semboller=splitToTokens(girdi);
        for(String s:semboller){
            if(s.equals("+") || s.equals("-")||s.equals("*") || s.equals("/")){
                while(opstack.size()>0 && oncelik(opstack.peek())>=oncelik(s)) cikti.add(opstack.pop());
                opstack.push(s);
            }
            else if(s.equals("(")) opstack.push(s);
            else if(s.equals(")")){
                while(opstack.size()>1 && !opstack.peek().equals("(")){
                    cikti.add(opstack.pop());
                opstack.pop();
                }
            }
            else cikti.add(s);    
        }
        while(!opstack.isEmpty()) cikti.add(opstack.pop());
        return String.join(" ",cikti);
    }
    /**
     * Infix ifadeyi sembollerine ayıran metod
     * @param girdi Infix ifade
     * @return Sembol dizisi
     */
    private static String[] splitToTokens(String girdi)
    {
        StringTokenizer t=new StringTokenizer(girdi, "+-*/^() ",true);
        List<String> tokenList=new ArrayList<>();
        while (t.hasMoreTokens()){
            String s=t.nextToken().trim();
            if(!s.equals(""))
                tokenList.add(s);
        }
        String [] tl=new String[tokenList.size()];
        tokenList.toArray(tl);
        return tl;
    }
    }

