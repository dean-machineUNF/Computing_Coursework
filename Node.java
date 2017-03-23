/**
 * Defines Nodes in Binary Tree for P4
 * @author Dean Rice
 */
public class Node 
{
    
    President fData = new President("y", 0, "y", "y", "y", 0, "blank", "blank");
    public Node leftChild = null;
    public Node rightChild = null;
    
    /**
    * constructor receives attributes of President objects and stores data in Node objects  
    * @param  This method expects six strings and two integers
    * @return void 
    */
    public Node(String transaction, int number, String lastName, String firstName, String code, int yearsInOffice, String party, String homeState)
    {
        fData.changeTransaction(transaction);
        fData.changeCode(code);
        fData.changeHomeState(homeState);
        fData.changeLastName(lastName);
        fData.changeFirstName(firstName);
        fData.changeNumber(number);
        fData.changeParty(party);
        fData.changeYearsInOffice(yearsInOffice);
    }// end constructor
    
    /**
    * prints data of Node objects according to toString method of Presidents class   
    * @param  NA
    * @return void 
    */
    public void displayNode()
    {
        
        System.out.print(fData.toString());
    }//end displayNode()
    
}// end class Node
