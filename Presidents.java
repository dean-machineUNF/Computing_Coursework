/**
 * @author Dean Rice (Michael)
 * Represents a president.
 */
public class Presidents 
{
    /** attributes of Presidents objects*/
    private int number, yearsInOffice;
    private String name, code, party, homeState;      
            
    /**
    * constructor reserves space for Presidents objects' attributes
    * @param  This method expects two integers and four Strings 
    * @return void
    */
    public Presidents (int number, String name, String code, int yearsInOffice, String party, String homeState)
    {
            
        this.number = number;
        this.name = name;
        this.code = code;
        this.yearsInOffice = yearsInOffice;
        this.party = party;
        this.homeState = homeState;
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
    * formats and prints number, name, and party attributes
    * @param  none 
    * @return This method returns an empty String
    */
    public String toString()
    { 
        System.out.printf( "%3s" + "      " + "%-21s %-13s %n", number, name, party); 
        return ""; 
    }//end toString()  

}//end class Presidents

