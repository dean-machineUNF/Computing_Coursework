/**
 * @author Dean Rice 
 * Main class for P3
 */

import java.io.IOException;// needed to read and parse input

public class Main 
{
     /**
     * receives presidents objects from Input class and passes them into a PresidentsArray array, manipulates array, builds and manipulates stack, builds and manipulates a doubly linked list
     * @param none
     * @return void
     */
    public static void main(String [] args) throws IOException
    {
        Input myInput = new Input();
        
        PresidentsArray myPresArr = new PresidentsArray(myInput.readPresidents());
        
        //myPresArr.displayArr();
        
        myPresArr.sortByLastName();
        
        //myPresArr.displayArr();
    
        
        DoublyLinkedList presidentsLinkedList = new DoublyLinkedList();
        
        String rep = "Republican";
        for (int i = 0; i < myPresArr.length(); i++)
        {
            String tempParty = myPresArr.getPresident(i).getParty();
            //System.out.println(tempParty);
            
            
            if (tempParty.equalsIgnoreCase(rep))   
                presidentsLinkedList.insertLast(myPresArr.getPresident(i).getTransaction(), myPresArr.getPresident(i).getNumber(), myPresArr.getPresident(i).getLastName(), myPresArr.getPresident(i).getFirstName(), myPresArr.getPresident(i).getCode(), myPresArr.getPresident(i).getYearsInOffice(), myPresArr.getPresident(i).getParty(), myPresArr.getPresident(i).getHomeState());
        }// end for
        
        
        presidentsLinkedList.displayForward(); 
   
        presidentsLinkedList.displayBackward(); 
        
        Input myInput1 = new Input();
        Presidents [] presUpdateArr = myInput1.readPresidentsUpdate();
        
       /* for (int x = 0; x < presUpdateArr.length; x++)
        {
            System.out.println(presUpdateArr[x].getTransaction());
            System.out.println(presUpdateArr[x].getLastName());
            System.out.println(presUpdateArr[x].getFirstName());
            
            System.out.println(presUpdateArr[x].getParty());
            System.out.println(presUpdateArr[x].getHomeState());
        }// end for
       */
        
        Stack stackLinkedListUpdate = new Stack(presUpdateArr.length);
        
        /*pushes updated presidents objects onto stack*/
        for (int k = 0; k < presUpdateArr.length; k++)
            stackLinkedListUpdate.push(presUpdateArr[k]); 
        
        System.out.println("Input Stack for Updating Doubly-Linked List");
        System.out.print("\n");
        stackLinkedListUpdate.displayStack();
        
        System.out.println("Transactions Attempted \n");
        System.out.printf( "%-14s %-14s %-20s %n", "Transaction", "Last Name", "Number of Preceding Items in List");
        System.out.println("");
        for (int k = 0; k < presUpdateArr.length; k++)
            if (stackLinkedListUpdate.peek().getTransaction().equals("A"))
                presidentsLinkedList.insertOrdered(stackLinkedListUpdate.peek().getTransaction(), stackLinkedListUpdate.peek().getNumber(), stackLinkedListUpdate.peek().getLastName(), stackLinkedListUpdate.peek().getFirstName(), stackLinkedListUpdate.peek().getCode(), stackLinkedListUpdate.peek().getYearsInOffice(), stackLinkedListUpdate.peek().getParty(), stackLinkedListUpdate.pop().getHomeState());
            else if (stackLinkedListUpdate.peek().getTransaction().equals("D"))
                 presidentsLinkedList.delete(stackLinkedListUpdate.pop()); 
            else 
                System.out.printf("%-14s %-14s %-20s %n", stackLinkedListUpdate.pop().getTransaction(), "", "Invalid Transaction Type");
                //System.out.println(stackLinkedListUpdate.pop().getTransaction() + " Invalid Transaction Type");
        
        System.out.println("\n\nUpdated Doubly Linked List");
        System.out.println("");
        presidentsLinkedList.displayForward();
        
        presidentsLinkedList.displayBackward();
        
        

      
       
       
       
       
       
    }
    
}
