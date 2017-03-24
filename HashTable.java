/*
 *defines hash table for P_5 
 *
 */
import java.lang.*;
import java.util.ArrayList;
        
/**
 *
 * @author Dean
 */
public class HashTable 
{
    
    private President[] hashTableArr;
    private President[] invalidUpdates;
    private int hashKey;
    private int hashTableSize;
    private int arrSize;
    
    
    public HashTable(President[] inputArr, int hashTableSize1)
    {
        hashTableSize = hashTableSize1;
        hashTableArr = new President[hashTableSize];
        invalidUpdates = new President[hashTableSize];
        hashKey = hashTableSize1;
        arrSize = hashTableSize1;
        
        for (int y = 0; y < hashTableArr.length; y++)
        {
            President populateHashTablePres = new President (0, "blank",0 , "blank", "blank", 0, 0, "blank", "blank"); 
            hashTableArr[y] = populateHashTablePres;
        }// end for
        
        
        
        President tempPres;  
        for (int i = 0; i < inputArr.length; i++)
        {
            tempPres = new President(inputArr[i].getHashKey(), inputArr[i].getTransaction(),inputArr[i].getNumber() , inputArr[i].getFirstName(), inputArr[i].getLastName(), inputArr[i].getProbeCount(), inputArr[i].getYearsInOffice(), inputArr[i].getParty(), inputArr[i].getHomeState());
            //System.out.println(tempPres);
            hash(tempPres);
        }//end for
            
        
        
    }// end constructor
    
    public void hash (President unhashedPres)
    {
        int count = 0;
        //System.out.println("\n");
        //System.out.println("\n");
        // System.out.println("hash method reached");
        int hashIndex;
        //System.out.print(unhashedPres.getLastName());
        hashIndex = hashFunc1(unhashedPres.getLastName());
        
        System.out.println("hashFunc1 return value: " + hashIndex + " " + unhashedPres.getLastName());
        if (hashTableArr[hashIndex].getLastName().equalsIgnoreCase("blank"))
        {
            hashTableArr[hashIndex].changeLastName(unhashedPres.getLastName());
            hashTableArr[hashIndex].changeNumber(unhashedPres.getNumber());
            hashTableArr[hashIndex].changeYearsInOffice(unhashedPres.getYearsInOffice());
            hashTableArr[hashIndex].changeParty(unhashedPres.getParty());
            hashTableArr[hashIndex].changeHomeState(unhashedPres.getHomeState());
            hashTableArr[hashIndex].changeHashKey(hashIndex);
            hashTableArr[hashIndex].changeTransaction(unhashedPres.getTransaction());
            count++;
        }// end if
        else
            while (hashIndex < hashTableArr.length && !hashTableArr[hashIndex].getLastName().equalsIgnoreCase("blank"))
            {
                hashIndex = hashIndex + 1;
                count++;
            }
        
        if (hashIndex < hashTableArr.length)
        {
            hashTableArr[hashIndex].changeLastName(unhashedPres.getLastName());
            hashTableArr[hashIndex].changeNumber(unhashedPres.getNumber());
            hashTableArr[hashIndex].changeYearsInOffice(unhashedPres.getYearsInOffice());
            hashTableArr[hashIndex].changeParty(unhashedPres.getParty());
            hashTableArr[hashIndex].changeHomeState(unhashedPres.getHomeState());
            hashTableArr[hashIndex].changeHashKey(hashIndex);
            hashTableArr[hashIndex].changeTransaction(unhashedPres.getTransaction());
            count++;
        }// end if
        else 
        {
            hashIndex = 0;
            while (hashIndex < hashTableArr.length && !hashTableArr[hashIndex].getLastName().equalsIgnoreCase("blank"))
            { 
                hashIndex = hashIndex + 1;
                count++;
            }
            
            hashTableArr[hashIndex].changeLastName(unhashedPres.getLastName());
            hashTableArr[hashIndex].changeNumber(unhashedPres.getNumber());
            hashTableArr[hashIndex].changeYearsInOffice(unhashedPres.getYearsInOffice());
            hashTableArr[hashIndex].changeParty(unhashedPres.getParty());
            hashTableArr[hashIndex].changeHomeState(unhashedPres.getHomeState());
            hashTableArr[hashIndex].changeHashKey(hashIndex);
            hashTableArr[hashIndex].changeTransaction(unhashedPres.getTransaction());
            count++;
        }// end else
        
        
        hashTableArr[hashIndex].changeProbeCount(count);
        System.out.println("This is the count " + hashTableArr[hashIndex].getProbeCount());
        //System.out.print(hashTableArr[hashIndex].getHashKey() + " " + hashTableArr[hashIndex] + "\n");    
    }// end hash()
    
    public int hashFunc1(String key)
    {
        
        int hashVal = 0;
        int pow27 = 1;
        int letterTotal = 0;
        key = key.toLowerCase();
        
        for (int j = key.length() - 1; j>=0; j--)
        {
            int letter = key.charAt(j) - 96;
            letterTotal = letterTotal + letter;
            hashVal += pow27 * letter;
            pow27 *= 27;
        }// end for
        
        //System.out.println("letter total: " + letterTotal);
        return Math.abs(hashVal % arrSize);
        
    }// end hashFunc1()
    
    public void displayHashTable()
    {
        for (int q = 0; q < hashTableArr.length; q++)
            if (!hashTableArr[q].getLastName().equals("blank"))
                System.out.println(q + "     " + hashTableArr[q].getLastName());
            else 
                System.out.println(q + " ");
        
    }// end displayHashTable()
    
    public void displayUpdatedHashTableStats()
    {
      
           
        for (int u = 0; u < hashTableArr.length; u++)
        {
            //String tempTransaction = hashTableArr[u].getTransaction();
            //System.out.println(tempTransaction);
            if (hashTableArr[u].getTransaction() != null)
                if (hashTableArr[u].getTransaction().equalsIgnoreCase("a"))
                {
                    hashTableArr[u].changeTransaction("Add");
                    //System.out.println(hashTableArr[u].getTransaction());
                }
            
            if (invalidUpdates[u] != null)
                System.out.println(invalidUpdates[u].getLastName() + "    " +  "Delete                Not Found");
            if (!hashTableArr[u].getLastName().equals("blank") && hashTableArr[u].getTransaction() != null && !hashTableArr[u].getTransaction().equalsIgnoreCase("blank"))
                System.out.println(hashTableArr[u].getLastName() + "    " + hashTableArr[u].getTransaction() + "   " + hashTableArr[u].getProbeCount());
           
        }
        
        
    }
    
    
    
    public void hashUpdate(President [] updateArr)
    {
        //System.out.println("Test");
        
        for (int v = 0; v < updateArr.length; v++)
            if (updateArr[v].getTransaction().equalsIgnoreCase("a"))
                hash(updateArr[v]);
            else if (updateArr[v].getTransaction().equalsIgnoreCase("d"))
                delete(updateArr[v]);
    }// end hashUpdate()
    
    public void delete (President toBeDeleted)
    {
        //for (int w = 0; w < hashTableArr.length; w++)
          //  if (hashTableArr[])
        int deleteKey;
        deleteKey = hashFunc1(toBeDeleted.getLastName());
        System.out.println(toBeDeleted.getLastName() + " delete: " + deleteKey);
        if (hashTableArr[deleteKey].getLastName().equalsIgnoreCase(toBeDeleted.getLastName()))
        {   
            System.out.println(hashTableArr[deleteKey].getLastName() + " deleted");
            hashTableArr[deleteKey].changeLastName("*" + hashTableArr[deleteKey].getLastName());
            hashTableArr[deleteKey].changeTransaction("Delete");
            System.out.println(hashTableArr[deleteKey].getLastName());
        }//end if 
        else 
            while (deleteKey < hashTableArr.length - 1 && !hashTableArr[deleteKey].getLastName().equalsIgnoreCase(toBeDeleted.getLastName()))
            {
                deleteKey = deleteKey + 1;
                //System.out.print("inside while loop that searches for synonym");
            }
        //System.out.println("exit while");
        if (hashTableArr[deleteKey].getLastName().equalsIgnoreCase(toBeDeleted.getLastName()))
        {   
            System.out.println(hashTableArr[deleteKey].getLastName() + " deleted");
            hashTableArr[deleteKey].changeLastName("*" + hashTableArr[deleteKey].getLastName());
            hashTableArr[deleteKey].changeTransaction("Delete");
            System.out.println(hashTableArr[deleteKey].getLastName());
        }//end if 
        else if (deleteKey == hashTableArr.length - 1)
        {
            //System.out.println("enter if that resets sequential search for synonym");
            deleteKey = 0;
            while (deleteKey < hashTableArr.length - 1 && !hashTableArr[deleteKey].getLastName().equalsIgnoreCase(toBeDeleted.getLastName()))
            {
                deleteKey = deleteKey + 1;
                //System.out.println("enter while for reset search"); 
            }
            if (deleteKey == hashTableArr.length - 1)
            {
                
                toBeDeleted.changeHashKey(hashFunc1(toBeDeleted.getLastName()));
                invalidUpdates[toBeDeleted.getHashKey()] = toBeDeleted;
                System.out.println(toBeDeleted.getLastName() + " not found");
                hashTableArr[deleteKey].changeTransaction("Delete");
            } // end nested if
            else 
            {
                //System.out.println("enter else that deletes synonym");
                System.out.println(hashTableArr[deleteKey].getLastName() + " deleted");
                hashTableArr[deleteKey].changeLastName("*" + hashTableArr[deleteKey].getLastName());
                hashTableArr[deleteKey].changeTransaction("Delete");
                System.out.println(hashTableArr[deleteKey].getLastName());
        
            }// end else       
        }// end if
    }// delete()
}
