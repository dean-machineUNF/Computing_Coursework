/**
 * Defines Nodes in Linked List for P3
 * @author Dean Rice
 */
public class Node 
{
    Presidents dData = new Presidents("y", 0, "y", "y", "y", 0, "blank", "blank");
    public Node next;
    public Node previous;
    
    /**
    * constructor receives attributes of Presidents objects and stores data in Node objects  
    * @param  This method expects six strings and two integers
    * @return void 
    */
    public Node(String transaction, int number, String lastName, String firstName, String code, int yearsInOffice, String party, String homeState)
    {
        dData.changeTransaction(transaction);
        dData.changeCode(code);
        dData.changeHomeState(homeState);
        dData.changeLastName(lastName);
        dData.changeFirstName(firstName);
        dData.changeNumber(number);
        dData.changeParty(party);
        dData.changeYearsInOffice(yearsInOffice);
    }// end constructor
    
    /**
    * prints data of Node objects according to toString method of Presidents class   
    * @param  NA
    * @return void 
    */
    public void displayNode()
    {
        System.out.print(dData.toString());
    }//end displayNode()
    
}// end class Node
