import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
/**
 * Verilen SocialNetwork sınıfı bir sosyal ağı temsil etmektedir. Sınıfın içinde bir kişinin ismini 
 * arkadaş listesine eşleyen bir Map türünde değişken bulunmaktadır.
 * Bu sınıfın sadece friendsOfFriends, mostPopular ve mostCommonFriends metotlarını değiştirin.
 * Diğer metot ve özellikler testlerin çalışması için gereklidir.
 */
public class SocialNetwork {
  // ************************ Lütfen bu aralıktaki kodları değiştirmeyin *************************
  // Her bir kişinin ismini arkadaş listesine eşleyen bir harita
  private Map<String, List<String>> adjacencyList;
  // Map nesnesi getter
  public Map<String, List<String>> getAdjacencyList() {
    return adjacencyList;
  }

  // Yapıcı
  public SocialNetwork() {
    adjacencyList = new HashMap<>();
  }

  // Sosyal ağa bir kişi ekler
  public void addPerson(String name) {
    if (!adjacencyList.containsKey(name)) {
      adjacencyList.put(name, new ArrayList<String>());
    }
  }

  // İki kişi arasında bir arkadaşlık ekler
  public void addFriendship(String person1, String person2) {
    addPerson(person1);
    addPerson(person2);
    if (!adjacencyList.get(person1).contains(person2)) {
      adjacencyList.get(person1).add(person2);
      adjacencyList.get(person2).add(person1);        
    }
  }

  // Graftaki köşe(vertex) ve kenarların(edge) string temsilini döndürür
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Vertices:\n");
    for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
      String person = entry.getKey();
      builder.append(person + "\n");
    }
    builder.append("\nEdges:\n");
    for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
      String person = entry.getKey();
      List<String> friends = entry.getValue();
      builder.append(person + ": [");
      for (int i = 0; i < friends.size(); i++) {
        String friend = friends.get(i);
        if (i == friends.size() - 1) {
          builder.append(friend);
        } else {
          builder.append(friend + ", ");
        }
      }
      builder.append("]\n");
    }
    return builder.toString();
  }
  // ************************ Lütfen bu aralıktaki kodları değiştirmeyin *************************

  /**
   * Bir kişinin arkadaşının arkadaşı olan, ancak o kişinin arkadaşı olmayan kişileri döndürür
   * 
   * @param name sorgulanacak kişinin ismi(graftaki bir vertex)
   * @return Arkadaşlarının arkadaşlarının listesi
   */
  public List<String> friendsOfFriends(String name) {
    List<String> willReturn = new ArrayList<>();
    List<String> closeFriends = new ArrayList<>();
    closeFriends.add(name);
    for(String friends:adjacencyList.get(name)) closeFriends.add(friends);
    for(String friends:adjacencyList.get(name)){
        for(String ffriends:adjacencyList.get(friends))
            if(!willReturn.contains(ffriends) && !closeFriends.contains(ffriends))
                willReturn.add(ffriends);
    }
    return willReturn;
  }

  /**
   * Graftaki kişileri arkadaş sayısına göre çoktan aza doğru sıralı olarak döndürür
   * 
   * @return Arkadaş sayısına göre azalan sırada kişilerin adlarının listesi
   */
  public List<String> mostPopular() {
    List<String> keys = new ArrayList<>(adjacencyList.keySet());
    List<Integer> values = new ArrayList<>();
    for(String nFriends:keys) values.add(adjacencyList.get(nFriends).size());
    for(int i=0;i < adjacencyList.size()-1;i++){
      int max = i;
      for(int j=i+1;j < adjacencyList.size();j++)
        if(values.get(j) > values.get(max)) max = j;
      String temp_k = keys.get(i);
      int temp_v = values.get(i);
      keys.set(i, keys.get(max));
      keys.set(max, temp_k);
      values.set(i, values.get(max));
      values.set(max, temp_v);
    }
    return keys;
  }

  /**
   * En çok ortak arkadaşı olan iki kişiyi liste içinde döndürür. Ortak arkadaş sayısı en çok olan 
   * ikiden fazla kişi olması durumunda herhangi ikisini döndürmek yeterlidir.
   * 
   * @return En çok ortak arkadaşı olan kişilerin isimlerinin bulunduğu liste. Listede 2 vertex bulunmalıdır.
   */
  public List<String> mostCommonFriends() {
    List<String> willReturn = new ArrayList<>();
    List<String> profiles = new ArrayList<>(adjacencyList.keySet());
    int hold = 0;
    for(int i=0;i<adjacencyList.size()-1;i++){
        for(int j=i+1;j<adjacencyList.size();j++){
            int counter = 0;
            for(String person1:adjacencyList.get(profiles.get(i)))
                for(String person2:adjacencyList.get(profiles.get(j)))
                    if(person1.equals(person2)) counter++;
            if(counter>hold){
                willReturn.clear();
                willReturn.add(profiles.get(i));
                willReturn.add(profiles.get(j));
                hold = counter;
            }
        }
    }
    return willReturn;
  }

}
