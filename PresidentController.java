/**
 *
 * @author Dean Rice
 * represents array of Presidents objects used for P3
 */
public class PresidentController
{
    
    private President [] myPresidents;
    private President tempPres; 
    
    /**
    * constructor receives array of Presidents objects from input class and stores them in PresidentsArray object
    * @param  This method expects one array of Presidents objects
    * @return void 
    */
    public PresidentController(President[] a)
    {
        myPresidents = new President[a.length];
        for (int i = 0; i < myPresidents.length; i++)
            myPresidents[i] = a[i];
    }// end constructor
    
    /**
    * provides length of PresidentsArray array   
    * @param  none
    * @return returns an integer  
    */
    public int length()
    {
        return myPresidents.length;
    }//end length()
    
    
    /**
    * prints data of objects in PresidentsArray array according to toString method of Presidents class   
    * @param  NA
    * @return void 
    */
    public void displayArr()
    {
        System.out.printf( "%-14s %-14s %-20s %n", "Last Name", "First Name", "Homestate");
        System.out.println("");
        for(int i = 0; i < myPresidents.length; i++)
            System.out.print(myPresidents[i]);
    }//end displayArr()
    
    
    /**
    * allows user access to a Presidents object in PresidentsArray array
    * @param  this method expects one integer
    * @return returns a Presidents object
    */
    public President getPresident(int a)
    {
        tempPres = new President("blank", 0, "blank", "blank", "blank", 0, "blank", "blank");
        tempPres.changeCode(myPresidents[a].getCode());
        tempPres.changeHomeState(myPresidents[a].getHomeState());
        tempPres.changeLastName(myPresidents[a].getLastName());
        tempPres.changeFirstName(myPresidents[a].getFirstName());
        tempPres.changeNumber(myPresidents[a].getNumber());
        tempPres.changeParty(myPresidents[a].getParty());
        tempPres.changeYearsInOffice(myPresidents[a].getYearsInOffice());
        return tempPres;
    }//end getPresident()
}
