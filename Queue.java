/**
 * @author Dean Rice (Michael)
 * represents a queue
 */

import java.util.*; //needed to use ArrayList

public class Queue 
{
    
    private ArrayList<Presidents> queArrList;
    private int front,  rear,  nItems;
    
    /**
    * constructor builds array list to implement queue for Presidents objects, queue is empty 
    * @param  none
    * @return void 
    */
    public Queue()
    {
        queArrList = new ArrayList<Presidents>();
        front = 0; 
        rear = -1;
        nItems = 0;
    }//end constructor
    
    /**
    * increments rear, adds President object to queue 
    * @param  This method expects one Presidents object
    * @return void 
    */
    public void insert(Presidents a)
    {				
        queArrList.add(++rear, a);
        nItems++;                   
    }//end insert()
    
    /**
    * returns size of queue
    * @param  none
    * @return This method returns an integer 
    */
    public int length()
    {
        return nItems;
    }//end length()
    
    /**
    * deletes a Presidents object from the queue
    * @param  none
    * @return This method returns a Presidents object  
    */
    public Presidents remove()
    {
        nItems--;
        return queArrList.get(front++);
    }// end remove()
    
    /**
    * iterates through array list that implements queue and prints array list elements without altering the queue
    * @param  none
    * @return void 
    */
    public void displayQueue()
    {
        
        System.out.printf("%-14s %-16s %-1s \n", "Number", "Name", "Party");
        System.out.print("\n");
        int j = 0;
        for (j = 0; j < queArrList.size(); j++)
            System.out.print(queArrList.get(j));
        System.out.println("\n");
        
    }//end displayQueue()
    
    /**
    * makes queue into a priority queue by sorting queue elements by number attribute
    * @param  none
    * @return void 
    */
    public void sortByNumber()
    {
        Presidents[] queueCopy = new Presidents[queArrList.size()];
        Presidents tempPres3 = new Presidents(0, "blank", "blank", 0, "blank", "blank");
        int k;
        
        /*copy array list over to array for different functionality*/
        for (k = 0; k < queArrList.size(); k++)
        {
            Presidents tempPres = new Presidents(0, "blank", "blank", 0, "blank", "blank");
            queueCopy[k] = tempPres;
            queueCopy[k].changeNumber(queArrList.get(k).getNumber());
            queueCopy[k].changeName(queArrList.get(k).getName());
            queueCopy[k].changeParty(queArrList.get(k).getParty());
            //System.out.print(queueCopy[k]);
        }// end for loop
        
        //sort algorithm
        int min, highIndex, out;
        for (out = 0; out < queueCopy.length - 1; out++)
        {
            min = out;
            for (highIndex = out + 1; highIndex < queueCopy.length; highIndex++)
                if (queueCopy[highIndex].getNumber() < queueCopy[min].getNumber()) 
                {
                    tempPres3 = queueCopy[highIndex];
                    queueCopy[highIndex] = queueCopy[min];
                    queueCopy[min] = tempPres3;
                }// end if statements                    
        }//end outer for loop
      
        
        for (int x = 0; x < queueCopy.length; x++)
        {    
            // System.out.println(queueCopy[x]);
            queArrList.remove(x);
            queArrList.add(x, queueCopy[x]);
        }// end for loop    
        
    }// end sortByNumber()
    
    /**
    * adds Presidents object to queue, position in queue to be added is determined by number attribute of Presidents object
    * @param  This method expects one Presidents object
    * @return void 
    */
    public void insertByPriority (Presidents b)
    {
        int n = 0;
        
        if (nItems == 0)
        {
            queArrList.add(nItems, b);
            nItems++;
        }// end if statements
        else
        {
            for (n = nItems - 1; n >= 0; n--)
            {  
                if (n == nItems - 1)
                    queArrList.add(n + 1, queArrList.get(n));
                if (b.getNumber() < queArrList.get(n).getNumber())
                    queArrList.set(n + 1, queArrList.get(n));
                else 
                    break;
            }// end for loop
            
            queArrList.set(n + 1, b);
            nItems++;
                
        }// end else statements
     
    }// end insertByPriority()

} //end class Queue
