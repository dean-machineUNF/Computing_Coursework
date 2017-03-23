
/**
 * @author Dean Rice 
 * Represents a president
 */
public class President
{
    /** attributes of Presidents objects*/
    private int number, yearsInOffice;
    private String name, code, party, homeState, lastName, firstName, transaction;      
    private int presCounter;       
    /**
    * constructor reserves space for President objects' attributes
    * @param  This method expects two integers and four Strings 
    * @return void
    */
    public President (String transaction, int number, String firstName, String lastName, String code, int yearsInOffice, String party, String homeState)
    {
        this.transaction = transaction;    
        this.number = number;
        this.name = name;
        this.code = code;
        this.yearsInOffice = yearsInOffice;
        this.party = party;
        this.homeState = homeState;
        this.firstName = firstName; 
        this.lastName = lastName; 
        presCounter++;
        
    } //end constructor
    
   
    /**
    * allows user to change number attribute 
    * @param  This method expects one integer 
    * @return void
    */
    public void changeNumber(int updateNumber)
    {
        number = updateNumber;
    }//end changeNumber(int updateNumber)
   
               
    /**
    * allows user to access number attribute
    * @param  none
    * @return This method returns an integer
    */
    public int getNumber()
    {
        return number;
    }//end getNumber()
    
    public void changeTransaction(String updateTransaction)
    {
        transaction = updateTransaction;
    } 
    
    /**
    * allows user to access transaction attribute
    * @param  none
    * @return This method returns a String
    */
    public String getTransaction()
    {
        return transaction;
    }//end getTransaction()           
    
    /**
    * allows user to change name attribute
    * @param  This method expects one String
    * @return void 
    */
    public void changeName(String updateName)
    {
        name = updateName;
    }//end changeName(String updateName) 
    
    /**
    * allows user to access name attribute
    * @param  none
    * @return This method returns a String
    */
    public String getName()
    {
        return name;
    }//end getName()
    
    /**
    * allows user to change firstName attribute
    * @param  This method expects one String
    * @return void
    */
    public void changeFirstName(String updateFirstName)
    {
        firstName = updateFirstName;
    }// end changeFirstName()
    
    /**
    * allows user to access firstName attribute
    * @param none
    * @return returns a String
    */
    public String getFirstName()
    {
        return firstName;
    }// end getFirstName()
    
    /**
    * allows user to change lastName attribute
    * @param  This method expects one String
    * @return void
    */
    public void changeLastName(String updateLastName)
    {
        lastName = updateLastName;
    }//end changeLastName
    
    /**
    * allows user to access lastName attribute
    * @param  none
    * @return returns a String 
    */
    public String getLastName()
    {
        return lastName;
    }// end getLastName()
    
          
    /**
    * allows user to change code attribute
    * @param  This method expects one String
    * @return void
    */
    public void changeCode(String updateCode)
    {
        code = updateCode;
    }//end changeCode(String updateCode)
    
               
    /**
    * allows user to access code attribute
    * @param  none 
    * @return This method returns a String 
    */
    public String getCode()
    {
        return code;
    }//end getCode
        
               
    /**
    * allows user to change yearsInOffice attribute
    * @param  This method expects one integer 
    * @return void
    */
    public void changeYearsInOffice(int updateYearsInOffice)
    {
        yearsInOffice = updateYearsInOffice;
    }//end changeYearsInOffice(int updateYearsInOffice)
        
            
    /**
    * allows user to access yearsInOffice attribute
    * @param  none 
    * @return This method returns an integer
    */
    public int getYearsInOffice()
    {
        return yearsInOffice;
    }//end getYearsInOffice()
   
               
    /**
    *  allows user to change party attribute
    * @param  This method expects one String 
    * @return void
    */
    public void changeParty(String updateParty)
    {
        party = updateParty;
    }//end changeParty(String updateParty)
            
               
    /**
    * allows user to access party attribute
    * @param  none
    * @return This method returns a String
    */
    public String getParty()
    {
        return party;
    }//end getParty()
        
               
    /**
    * allows user to change homeState attribute
    * @param  This method expects one String
    * @return void
    */
    public void changeHomeState(String updateHomeState)
    {
        homeState = updateHomeState;
    }//end changeHomeState(String updateHomeState)
        
               
    /**
    * allows user to access homeState attribute
    * @param  none
    * @return This method returns a String 
    */
    public String getHomeState()
    {
        return homeState;
    }//end getHomeState()
       
               
    /**
    * formats and prints lastName, firstName, and homeState attributes
    * @param  none 
    * @return This method returns an empty String
    */
    public String toString()
    { 
        
        System.out.printf( "%-14s %-14s %-20s  %-20s %n", lastName, party, number, yearsInOffice); 
        return ""; 
    }//end toString()  

}//end class Presidents

