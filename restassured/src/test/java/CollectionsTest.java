import org.testng.annotations.Test;

import java.util.*;

public class CollectionsTest {

//ArrayList
    /*
    contains dupliacates
    Maintains Insertion Orders
     */

    @Test
    public static void arrayListTest()
    {
        List<String> topcompanies=new ArrayList<String>();
        System.out.println(topcompanies.isEmpty());
        topcompanies.add("Google");
        topcompanies.add("Microsoft");
        topcompanies.add("Apple");
        topcompanies.add("Tesla");
        topcompanies.add("Amazon");
       for (int i=0;i<topcompanies.size();i++)
       {
           topcompanies.get(i);
       }
        // System.out.println(topcompanies.isEmpty());

        Iterator<String> companiesIterator=topcompanies.iterator();
       while (companiesIterator.hasNext())
       {
           System.out.println(companiesIterator.next());
       }
    }

    @Test
    public static void linkedListTest()
    {
        List<String > humanSpecies=new LinkedList<String>();
        humanSpecies.add("Homo Sapiens");
        humanSpecies.add("Homo Erectus");
        humanSpecies.add("Homo Neanderthelensis");
        humanSpecies.add("Homo Habilis");

        Iterator<String> humanSpeciesiterator=humanSpecies.iterator();
        while (humanSpeciesiterator.hasNext())
        {
            System.out.println(humanSpeciesiterator.next());
        }


    }

}
