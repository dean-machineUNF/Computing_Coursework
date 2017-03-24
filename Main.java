
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

            P5
 */

/**
 *
 * @author Dean
 */
public class Main 
{

    
    public static void main(String[] args) throws IOException 
    {
        FileInterface presHashTable1FI = new FileInterface();
        
        FileInterface presHashTable2FI = new FileInterface();
        
        HashTable presHashTable1 = new HashTable(presHashTable1FI.readPresidents(), 37);
        
        HashTable presHashTable2 = new HashTable(presHashTable2FI.readPresidents(), 23);
        
        System.out.println("Hash Table 1");
        System.out.println("Index  Value");
        System.out.println("-----------------");
        presHashTable1.displayHashTable();
        System.out.println("\n");
        
        System.out.println("Hash Table 2");
        System.out.println("Index  Value");
        System.out.println("-----------------");
        presHashTable2.displayHashTable();
        System.out.println("\n");
      
        
        presHashTable1.hashUpdate(presHashTable1FI.readPresidentsUpdate());
        
        //System.out.println(" Test ");
       
        presHashTable2.hashUpdate(presHashTable2FI.readPresidentsUpdate());
        
        
        System.out.println("Updated Hash Table 1");
        System.out.println("Index  Value");
        System.out.println("-----------------");
        presHashTable1.displayHashTable();
        System.out.println("\n");
        
        System.out.println("Updated Hash Table 2");
        System.out.println("Index  Value");
        System.out.println("-----------------");
        presHashTable2.displayHashTable();
        System.out.println("\n");
        
        
        System.out.println("Hash Table 1 Statistics");
        presHashTable1.displayUpdatedHashTableStats();// need to format output
        
        System.out.println("Hash Table 2 Statistics");
        presHashTable2.displayUpdatedHashTableStats();//need to format output
                
         //presHashTable1.displayHashTable();       
        
        //System.out.println("updated with adds \n");
        
       // presHashTable1.displayHashTable();
        
        //presHashTable2.displayHashTable();
        
    }
    
}
