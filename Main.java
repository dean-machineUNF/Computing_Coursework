/**
 * @author Dean Rice (Michael)
 * Main class for P2
 */
import java.io.IOException;// needed to read and parse input

public class Main 
{
     /**
     * receives presidents objects from Input class, instantiates stacks and queues, and calls
     * methods that manipulate stacks and queues
     * @param none
     * @return void
     */
    public static void main(String [] args) throws IOException
    {
        Input myInput = new Input();
        Presidents [] presArr = myInput.readPresidents();
        
        /*for (int i = 0; i < presArr.length; i++)
            System.out.println(presArr[i]);*/
        
        Queue republicans = new Queue();
        Queue democrats = new Queue();
        Queue whigs = new Queue();
        String rep = "Republican";
        String dem = "Democrat";
        String w = "Whig";
        
        /*inserts presidents objects into their respective queues*/
        int j = 0;
        for (j = 0; j < presArr.length; j++) 
        {
            String tempParty = presArr[j].getParty();
        
            if (tempParty.equals(rep))
                republicans.insert(presArr[j]);
                //System.out.println(presArr[j]);
            else
                if (tempParty.equals(dem))
                    democrats.insert(presArr[j]);
                else
                    if (tempParty.equals(w))
                        whigs.insert(presArr[j]);              
        }//end for loop
        
        System.out.println("Queue 1: Democrats");
        System.out.println("");
        democrats.displayQueue();
        
        System.out.println("Queue 2: Republicans");
        System.out.println("");
        republicans.displayQueue();
              
        System.out.println("Queue 3: Whigs");
        System.out.println("");
        whigs.displayQueue();
        
        democrats.sortByNumber();
        republicans.sortByNumber();
        whigs.sortByNumber();
       
        System.out.println("Sorted Priority Queues");
        System.out.print("\n");
        System.out.println("Queue 1: Democrats \n");
        democrats.displayQueue();
        System.out.println("Queue 2: Republicans \n");
        republicans.displayQueue();
        System.out.println("Queue 3: Whigs \n");
        whigs.displayQueue();
        
        Input myInput1 = new Input();
        Presidents [] presUpdateArr = myInput1.readPresidentsUpdate();
        Stack stackQueUpdate = new Stack(presUpdateArr.length);
        
        /*pushes updated presidents objects onto stack*/
        for (int k = 0; k < presUpdateArr.length; k++)
            stackQueUpdate.push(presUpdateArr[k]); 
        
        System.out.println("Input Stack for Updating Priority Queues");
        System.out.print("\n");
        stackQueUpdate.displayStack();
            
        /*inserts updated presidents objects into their respective priority queues*/
        for (int m = 0; m < 8; m++)
        {
            String tempParty = stackQueUpdate.peek().getParty();
            //System.out.println(tempParty);
            //System.out.println(stackQueUpdate.pop());
            if (tempParty.equals(rep))
                republicans.insertByPriority(stackQueUpdate.pop());
                //System.out.println(presUpdateArr[m]);
            else
                if (tempParty.equals(dem))
                    democrats.insertByPriority(stackQueUpdate.pop());
                else
                    if (tempParty.equals(w))
                        whigs.insertByPriority(stackQueUpdate.pop());
        }// end for loop
        
        
        
        System.out.println("Updated Priority Queues: \n");
        System.out.println("Queue 1: Democrats \n");
        democrats.displayQueue();
        
        System.out.println("Queue 2: Republicans \n");
        republicans.displayQueue();
      
        System.out.println("Queue 3: Whigs \n");
        whigs.displayQueue();
        
      
    }//end main(String [] args)
    
}//end class Main
    

