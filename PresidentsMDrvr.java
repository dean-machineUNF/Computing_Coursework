/**
 * @author Dean Rice (Michael)
 * contains methods for manipulating array of Presidents objects
 */
public class PresidentsMDrvr 
{
    private Presidents[] myPresidents;//array for Presidents objects
    private int nElems;//element counter
    
    /**
    * constructor reserves space in array for Presidents objects, passed param determines size  
    * @param  This method expects one integer
    * @return void 
    */
    public PresidentsMDrvr(int max)
    {
        myPresidents = new Presidents[max];
        nElems = 0;
    }//end constructor
    
    /**
    * instantiates Presidents object 
    * @param  This method expects two integers and four Strings 
    * @return void 
    */
    public void insert(int number, String name, String code, int yearsInOffice, String party, String homeState)
    {
        myPresidents[nElems] = new Presidents(number, name, code, yearsInOffice, party, homeState);
        nElems++;
    }//end insert(int number, String name, String code, int yearsInOffice, String party, String homeState)
    
    /**
    * iterates through array elements and prints each one
    * @param  none 
    * @return void 
    */
    public void displayArr()
    {
        System.out.printf( "%-6s %-20s %-18s %n", "Number", "Name", "Party");
        System.out.println("");
        for(int i = 0; i < 44; i++)
            System.out.println(myPresidents[i]);
    }//end displayArr()
    
    /**
    * sorts array (ascending) by Presidents objects' number attributes  
    * @param  none
    * @return void
    */
    public void sortByNumber()
    {
        Presidents temp1 = new Presidents(0, "t", "t", 0, "t", "t");
               
        int length = myPresidents.length;
        for (int i = 1; i < length; i++)
            for (int j = 0; j < length - i; j++)
                if(myPresidents[j].getNumber() > myPresidents[j + 1].getNumber())
                {    
                    temp1 = myPresidents[j];
                    myPresidents[j] = myPresidents[j + 1];
                    myPresidents[j + 1] = temp1;
                }// end if statements      
            
        System.out.println("");
        System.out.println("");
        System.out.printf("%30s %n", "Sorted Presidents Array");   
        System.out.println("");
    }//end sortByNumber()  
        
    /**
    * searches party attributes of Presidents objects for match to search key(s) (passed as param)
    * @param  This method expects an array of String(s) 
    * @return void
    */   
    public void searchParty(String[] a)
    {
        String[] parties = new String[a.length];
        for (int i = 0; i < parties.length; i++)
            parties [i] = a[i]; 
            
        Presidents tempPres = new Presidents(0, "t", "t", 0, "t", "t");
        int [] partySearchCountArr = new int [7];
              
        /*search alghorithm*/
        for (int k = 0; k < parties.length; k++)
        {
            int count = 0;
            for (int j = 0; j < myPresidents.length; j++)
            {
                tempPres = myPresidents[j];
                String tempParty = tempPres.getParty();
                if (tempParty.equals(parties[k]))
                {
                    count++;
                    partySearchCountArr[k] = count;
                }//end if statement
            }//end nested for loop
        }//end for loop
             
        System.out.println("");
        System.out.println("");
        System.out.printf( "%45s %n", "Results of Sequential Search on Party");
        System.out.println("");
        System.out.printf( "%-20s %-12s %-1s %n", "Search Argument", "Result", "Number of Hits");
        System.out.println("");
            
        for (int m = 0; m < parties.length; m++)
            if (partySearchCountArr[m] > 0)
                System.out.printf("%-20s %-12s %4s %-1s %n", parties[m], "Found", partySearchCountArr[m], "occurences");
            else
                System.out.printf("%-20s %-12s %n", parties[m], "Not Found"); 
    }//end searchParty()
        
    /**
    * sorts array (ascending) by Presidents objects' name attribute
    * @param  none
    * @return void
    */
    public void sortByName()
    {
        Presidents temp3 = new Presidents(0, "t", "t", 0, "t", "t");
            
        /*sort algorithm*/
        int length = myPresidents.length;
        for (int i = 1; i < length; i++)
            for (int j = 0; j < length - i; j++)
                if(myPresidents[j].getName().compareTo(myPresidents[j + 1].getName()) > 0)
                {    
                    temp3 = myPresidents[j];
                    myPresidents[j] = myPresidents[j + 1];
                    myPresidents[j + 1] = temp3;
                }// end if statements      
            
        System.out.println("");
        System.out.println("");
        System.out.printf("%30s %n", "Sorted Presidents Array");
        System.out.println("");
    }//end sortByName()  
        
    /**
    * searches name attributes of Presidents objects for match to search key(s) (passed as param)
    * @param  This method expects an array of String(s)
    * @return void 
    */
    public void searchName(String [] a)
    {
        String [] names = new String [a.length];
        for (int i = 0; i < names.length; i++)
            names [i] = a[i]; 
        
        /*search algorithm*/
        String [] nameFound = new String [6];
        int [] numProbes = new int [6];
        int j = 0;
        for (j = 0; j < names.length; j++)
        {    
            int lowerBound = 0;
            int upperBound = nElems - 1;
            int currentIndex = 0;   
            int count = 0;
            while (true)
            {
                currentIndex = (upperBound + lowerBound) / 2;    
                numProbes[j] = count;
                if (myPresidents[currentIndex].getName().equals(names[j]))
                {
                    nameFound[j] = "Found";
                    break;   
                }
                else 
                    if (lowerBound > upperBound)
                    {
                        nameFound[j] = "Not Found";
                        break;
                    } 
                    else 
                        if (myPresidents[currentIndex].getName().compareTo(names[j]) < 0)
                            lowerBound = currentIndex + 1; //look in upper half
                        else
                            if (myPresidents[currentIndex].getName().compareTo(names[j]) > 0)
                                upperBound = currentIndex - 1; //look in lower half               
                count++;
            }//end while loop            
        }//end for loop
        
        System.out.println("");
        System.out.println("");
        System.out.printf( "%44s %n", "Results of Binary Search on Name");
        System.out.println("");
        System.out.printf( "%-18s %-19s %-1s %n", "Search Argument", "Found or Not Found", "Number of Probes");
        System.out.println("");
        for (int k = 0; k < names.length; k++)
            System.out.printf("%-24s %-28s %1s %n", names[k], nameFound[k], numProbes[k]);  
    }//end searchName()
            
}//end class PresidentsMDrvr
            
            
            
    
    
