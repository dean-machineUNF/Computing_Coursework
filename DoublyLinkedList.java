/**
 *
 * @author Dean Rice
 * represents a Doubly Linked List for P3
 */
public class DoublyLinkedList 
{
    private Node first;
    private Node last;
    
    
    /**
    * constructor sets Node pointers first and last to null  
    * @param  This method expects one integer
    * @return void 
    */
    public DoublyLinkedList()
    {
        first = null;
        last = null;
    }// end constructor
    
    /**
    * allows user to test if Linked List is empty, returns true if empty
    * @param none
    * @return returns a boolean value 
    */
    public boolean isEmpty()
    {
        return first == null;
    }// end isEmpty()
    
    /**
    * inserts Presidents object into last Node in Linked List 
    * @param  This method expects six strings and two integers
    * @return void 
    */
    public void insertLast(String transaction, int number, String lastName, String firstName, String code, int yearsInOffice, String party, String homeState)
    {
        Node newNode = new Node(transaction, number, lastName, firstName, code, yearsInOffice, party, homeState);
        
        if (isEmpty())
            first = newNode;
        else
        {
            last.next = newNode;
            newNode.previous = last;
            newNode.next = null;
            
        }// end else
        last = newNode;
    }// end insertLast()
    
    /**
    * inserts Presidents object into Node (ordered by lastName) in Linked List  
    * @param  This method expects six strings and two integers
    * @return void 
    */
     public void insertOrdered(String transaction, int number, String lastName, String firstName, String code, int yearsInOffice, String party, String homeState)
    {
        //Node tempNode = new Node(transaction, number, lastName, firstName, code, yearsInOffice, party, homeState);
        Node newNode = new Node(transaction, number, lastName, firstName, code, yearsInOffice, party, homeState);
        Node current = first;
        Node previous = null; 
        int count = 0;
        
        
        while (current != null && newNode.dData.getLastName().compareTo(current.dData.getLastName()) > 0)
        {
            previous = current;   
            current = current.next;
            count++;       
        }//end while
        if (newNode.dData.getLastName().compareTo(current.dData.getLastName()) == 0 && newNode.dData.getFirstName().compareTo(current.dData.getFirstName()) == 0)
        {
               
            System.out.printf("%-14s %-14s %-20s %n", newNode.dData.getTransaction(), newNode.dData.getLastName(), "Dupe Add Attempted");
        }//end if
        else if (previous == null)
        {
            first = newNode;
            System.out.printf("%-14s %-14s %-20s %n", newNode.dData.getTransaction(), newNode.dData.getLastName(), count);
        }//end else if
        else
        {
            previous.next = newNode;
            System.out.printf("%-14s %-14s %-20s %n", newNode.dData.getTransaction(), newNode.dData.getLastName(), count);
        }// end else
        newNode.next = current;
        
    }//end insertOrdered()
    
     /**
    * deletes Node from Linked List 
    * @param  This method expects one Presidents object
    * @return void 
    */
    public void delete(Presidents key)
    {
        Node current = first;  
        int count = 0;
        //move through items in LL to find item to be deleted
        while (current != null && current.dData.getLastName().compareTo(key.getLastName()) != 0)
        {
            current = current.next;
            count++;
            if (current == null)
                System.out.printf("%-14s %-14s %-20s %n", key.getTransaction(), key.getLastName(), "Transaction Not Found");
               
        }//end while
        //deletion if first in list
        if (key.getLastName().equalsIgnoreCase(first.dData.getLastName()))
        {
            first = current.next;
            System.out.printf("%-14s %-14s %-20s %n", key.getTransaction(), key.getLastName(), count);
        }//end if
        else if (current != null)
            current.previous.next = current.next;
        //deletion if last in list
        if (current != null && current.dData.getLastName().equalsIgnoreCase(last.dData.getLastName()))
        {
            last = current.previous;
            System.out.printf("%-14s %-14s %-20s %n", key.getTransaction(), key.getLastName(), count);
        }//end if
        else if (current != null)
        {
            current.next.previous = current.previous;
            System.out.printf("%-14s %-14s %-20s %n", key.getTransaction(), key.getLastName(), count);
        }// end else if
    }//end delete() 
    
    /**
    * displays Nodes in Linked List using forward pointers 
    * @param  none
    * @return void 
    */
    public void displayForward()
    {
        System.out.println("Doubly-Linked List Displayed Using Forward Pointers");
        System.out.println("");
        System.out.printf("%-14s %-14s %-20s %n", "Last Name", "First Name", "Home State"); 
        System.out.println("");
        Node current = first;
        while (current != null)
        {
            current.displayNode();
            //System.out.println("next: " + current.next + " " + current + " prev: " + current.previous);
            current = current.next;
        }// end while
        System.out.println("\n");
    }// end displayForward()
    
    /**
    * displays Nodes in Linked List using rearward pointers 
    * @param  none
    * @return void 
    */
    public void displayBackward()
    {
        System.out.println("Doubly-Linked List Displayed Using Rearward Pointers");
        System.out.println("");
        System.out.printf("%-14s %-14s %-20s %n", "Last Name", "First Name", "Home State"); 
        System.out.println("");
        Node current = last;
        while (current != null)
        {
            current.displayNode();
            current = current.previous;
        }// end while
        System.out.println("\n");
    }// end displayBackward()
    
}//end class DoublyLinkedList
