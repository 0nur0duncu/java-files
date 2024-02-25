import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Bu sınıf SocialNetwork sınıfını IDE içinde test etmenizi sağlayacak çeşitli özellik ve metotlarla verilmiştir.
 * Bu dosyayı istediğiniz gibi değiştirip kullanabilirsiniz, değerlendirmeye etkisi yoktur.
 */
public class Odev3IDETester {
    // random class
  public static Random r = new Random();

  // array of names
  static String[] names = { "John", "Jane", "Smith", "Kate", "Chris", "Sofia", "Michael", "Emily", "Matthew", "Olivia",
      "David", "Ava", "James", "Isabella", "Joseph", "Sophia", "William", "Mia", "Benjamin", "Charlotte", "Logan",
      "Abigail", "Lucas", "Emily", "Elijah" };

  // array of last names
  static String[] lastnames = { "Doe", "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia",
      "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez", "Perez", "Wilson", "Moore", "Taylor", "Anderson",
      "Thomas", "Jackson", "White", "Harris", "Martin" };

  // method that generates a random person
  public static String generateRandomPerson() {
    // generate a random index for the names and lastnames arrays
    int randomIndex1 = r.nextInt(names.length);
    int randomIndex2 = r.nextInt(lastnames.length);

    // get a random name and last name
    String randomName = names[randomIndex1];
    String randomLastname = lastnames[randomIndex2];

    // concatenate the name and last name and return the result
    return randomName + " " + randomLastname;
  }

  // method that generates a random social network graph with a random number of
  // vertices between 10 and 25, and a random number of edges between (numVertices
  // * (numVertices - 1)) / 2 and numVertices * (numVertices - 1) / 4
  public static SocialNetwork generateRandomGraph(int numVertices) {

    // generate a random number of edges between (numVertices * (numVertices - 1)) /
    // 2 and numVertices * (numVertices - 1) / 4
    int minEdges = (numVertices * (numVertices - 1)) / 4;
    int maxEdges = numVertices * (numVertices - 1) / 2;
    int numEdges = minEdges + r.nextInt(maxEdges - minEdges + 1);

    // create a new SocialNetwork object
    SocialNetwork network = new SocialNetwork();

    // add vertices to the graph
    String[] people = new String[numVertices];
    for (int i = 0; i < numVertices; i++) {
      people[i] = generateRandomPerson();
      network.addPerson(people[i]);
    }

    // add random edges to the graph
    for (int i = 0; i < numEdges; i++) {
      // generate random indexes for the vertices
      int randomIndex1 = r.nextInt(numVertices);
      int randomIndex2 = r.nextInt(numVertices);

      // ensure that the indices are different
      while (randomIndex1 == randomIndex2) {
        randomIndex2 = r.nextInt(numVertices);
      }

      // get the names of the vertices
      String person1 = people[randomIndex1];
      String person2 = people[randomIndex2];

      // add an edge between the vertices
      network.addFriendship(person1, person2);
    }

    // return the generated social network graph
    return network;
  }

  /**
   * Bu metod parametre olarak aldığı iki listenin içinde aynı elemanların olup olmadığını test eder. 
   * Bu işlem listeler sıralandıktan sonra birer birer karşılaştırılarak yapılır.
   * Hata errorMessage değişkenine yazılır.
   * 
   * @param list1 Birinci liste
   * @param list2 İkinci liste
   * @param errorMessage Hata mesajı
   * @return İki liste aynı elemanları barındırıyorsa true, aksi halde false
   */
  public static boolean testEqualLists(List<String> list1, List<String> list2, StringBuilder errorMessage) {
    if (list1 == null || list2 == null) {
      errorMessage.append(": iki listeden bir tanesi null");
      return false;
    }
    if (list1.size() != list2.size()) {
      errorMessage.append(": listelerin boyutları farklı");
      return false;
    }

    // Create a copy of the list1 and sort it
    List<String> sortedList1 = new ArrayList<>(list1);
    Collections.sort(sortedList1);

    // Create a copy of the list2 and sort it
    List<String> sortedList2 = new ArrayList<>(list2);
    Collections.sort(sortedList2);

    // Compare the two sorted lists for equality
    for (int i = 0; i < sortedList1.size(); i++) {
      if (!sortedList1.get(i).equals(sortedList2.get(i))) {
        errorMessage.append(": " + i + " indisinde farklı elemanlar var\n");
        errorMessage.append("Liste 1 eleman: "+ sortedList1.get(i)+"\n");
        errorMessage.append("Liste 2 eleman: "+ sortedList2.get(i)+"\n");
        return false;
      }
    }
    return true;
  }

  /**
   * Bu metot sosyal ağ içindeki kişilerden rastgle birisinin ismini döndürür.
   * @param network Sosyal ağ
   * @return Rastgele isim
   */
  public static String getRandomName(SocialNetwork network) {
    ArrayList<String> namesList = new ArrayList<>(network.getAdjacencyList().keySet());
    return namesList.get(r.nextInt(namesList.size()));
  }

  private static SocialNetwork sampleGraph1() {
    // Create a new SocialNetwork object
    SocialNetwork socialNetwork = new SocialNetwork();

    // Add some people to the social network
    socialNetwork.addPerson("Alice");
    socialNetwork.addPerson("Bob");
    socialNetwork.addPerson("Carol");
    socialNetwork.addPerson("Dave");
    socialNetwork.addPerson("Eve");

    // Add some friendships to the social network
    socialNetwork.addFriendship("Alice", "Bob");
    socialNetwork.addFriendship("Bob", "Carol");
    socialNetwork.addFriendship("Carol", "Dave");
    socialNetwork.addFriendship("Dave", "Eve");
    socialNetwork.addFriendship("Eve", "Alice");

    return socialNetwork;
  }

  public static SocialNetwork sampleGraph2() {
    // Create a new social network
    SocialNetwork socialNetwork = new SocialNetwork();
  
    // Add some people to the social network
    socialNetwork.addPerson("Alice");
    socialNetwork.addPerson("Bob");
    socialNetwork.addPerson("Carol");
    socialNetwork.addPerson("Dave");
    socialNetwork.addPerson("Eve");
    socialNetwork.addPerson("Frank");
    socialNetwork.addPerson("Gina");
    socialNetwork.addPerson("Hannah");
  
    // Add some friendships to the social network
    socialNetwork.addFriendship("Alice", "Bob");
    socialNetwork.addFriendship("Alice", "Carol");
    socialNetwork.addFriendship("Alice", "Dave");
    socialNetwork.addFriendship("Alice", "Eve");
    socialNetwork.addFriendship("Bob", "Carol");
    socialNetwork.addFriendship("Bob", "Dave");
    socialNetwork.addFriendship("Bob", "Eve");
    socialNetwork.addFriendship("Carol", "Dave");
    socialNetwork.addFriendship("Carol", "Eve");
    socialNetwork.addFriendship("Dave", "Eve");
    socialNetwork.addFriendship("Eve", "Frank");
    socialNetwork.addFriendship("Frank", "Gina");
    socialNetwork.addFriendship("Gina", "Hannah");

    return socialNetwork;
  }  

  public static void main(String[] args) {
    // Aşağıdaki graflar test için kullanılabilir
    SocialNetwork ornek1 = sampleGraph1();
    SocialNetwork ornek2 = sampleGraph2();
    SocialNetwork ornek3 = generateRandomGraph(10);
    //friendsOfFriends
    System.out.println(ornek1.friendsOfFriends(getRandomName(ornek1)));
    //mostPopular
    System.out.println(ornek2.mostPopular());
    //mostCommonFriends
    System.out.println(ornek3.mostCommonFriends());
  }
  
}
