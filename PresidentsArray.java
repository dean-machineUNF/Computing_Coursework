/**
 *
 * @author Dean Rice
 * represents array of Presidents objects used for P3
 */
public class PresidentsArray 
{
    
    Presidents [] myPresidents;
    Presidents tempPres; 
    
    /**
    * constructor receives array of Presidents objects from input class and stores them in PresidentsArray object
    * @param  This method expects one array of Presidents objects
    * @return void 
    */
    public PresidentsArray(Presidents[] a)
    {
        myPresidents = new Presidents[a.length];
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
        for(int i = 0; i < 44; i++)
            System.out.print(myPresidents[i]);
    }//end displayArr()
    
    
    /**
    * allows user access to a Presidents object in PresidentsArray array
    * @param  this method expects one integer
    * @return returns a Presidents object
    */
    public Presidents getPresident(int a)
    {
        tempPres = new Presidents("blank", 0, "blank", "blank", "blank", 0, "blank", "blank");
        tempPres.changeCode(myPresidents[a].getCode());
        tempPres.changeHomeState(myPresidents[a].getHomeState());
        tempPres.changeLastName(myPresidents[a].getLastName());
        tempPres.changeFirstName(myPresidents[a].getFirstName());
        tempPres.changeNumber(myPresidents[a].getNumber());
        tempPres.changeParty(myPresidents[a].getParty());
        tempPres.changeYearsInOffice(myPresidents[a].getYearsInOffice());
        return tempPres;
    }
    
    
    /**
    * sorts PresidentsArray array by last name of Presidents objects   
    * @param none
    * @return void 
    */
    public void sortByLastName()
    {
        Presidents temp3 = new Presidents("t", 0, "t", "t", "t", 0, "t", "t");
            
        /*sort algorithm*/
        int length = myPresidents.length;
        for (int i = 1; i < length; i++)
            for (int j = 0; j < length - i; j++)
                if(myPresidents[j].getLastName().compareTo(myPresidents[j + 1].getLastName()) > 0)
                {    
                    temp3 = myPresidents[j];
                    myPresidents[j] = myPresidents[j + 1];
                    myPresidents[j + 1] = temp3;
                }// end if statements      
           
    }//end sortByLastName()  
        
}// end PresidentsArray class
