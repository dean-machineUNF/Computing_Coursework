
import java.io.*; // needed to read and parse input
/*
 * P_5
 */

/**
 *
 * @author Dean
 */
public class FileInterface {
    
    private int count;
    
    /**
    * constructor sets count to 0
    * @param none
    * @return void
    */
    public FileInterface()
    {
        count = 0;
    }// end constructor
    
    
    
     /**
    * reads and parses info from ??????.txt, builds array of updated Presidents objects 
    * @param none
    * @return This method returns an array of updated Presidents objects
    */
    public President[] readPresidents() throws IOException
    {
        
        FileReader frCount = new FileReader("HashHeap.txt");
        BufferedReader brCount = new BufferedReader(frCount);
       
        String inputStringCount = brCount.readLine();
        
        //used to find size of array needed
        count = 0;
        while(inputStringCount != null)
        {
            inputStringCount = brCount.readLine();
            count++;    
        }// end while 
       
        int maxSize = count;
        
        //System.out.println("myPresArr size Counter: " + count);
        
        
        President [] myPresArr = new President[maxSize]; 

        FileReader fr = new FileReader("HashHeap.txt");
        BufferedReader br = new BufferedReader(fr);
        
        int number = 0;
        int yearsInOffice = 0;
        int probeCount = 0;
        String number1 = null;
        String yearsInOffice1 = null;
        String inputString, name = null, firstName = null, lastName = null, party = null, transaction = null, homeState = null;
        
        inputString =  br.readLine();   
        
        int i = 0;
        while(inputString != null && i < maxSize)
        {
            //System.out.println("TEST");

            String[] stringArr = inputString.split(",");
            
            //for (int r = 0; r < stringArr.length; r++)
                //System.out.println(stringArr[r]);
            
            number1 = stringArr[0];
            lastName = stringArr[1];
            yearsInOffice1 = stringArr[2];
            party = stringArr[3];
            homeState = stringArr[4];
            
            number = Integer.parseInt(number1);
            yearsInOffice = Integer.parseInt(yearsInOffice1);
            
           /* try {
                number = Integer.parseInt(inputString.substring(0, 2));
                } catch (NumberFormatException e) 
                    {
                       number = Integer.parseInt(inputString.substring(0, 1));
                    }*/
  
            
            /*
            System.out.print("This is a test print of the input parsing for president ");
            System.out.print("number: " + number + ", ");
            System.out.print("name: " + name + ", ");
            System.out.print("party: " + party + " " );
            */
          
            int blankHashKey = 0;
            President tempPres = new President(blankHashKey, transaction, number, firstName, lastName, probeCount, yearsInOffice, party, homeState);
            myPresArr[i] = tempPres;
            
            // System.out.println("TEST");
    
            i++;
            inputString = br.readLine();
        }//end while loop
        
        
       // for (int k = 0; k < myPresArr.length; k++)
         //   System.out.println(myPresArr[k]);
        
        return myPresArr;
             
    }// end readPresidents()
    
    /**
    * reads and parses info from Presidents.Update.txt, builds array of updated Presidents objects 
    * @param none
    * @return This method returns an array of updated Presidents objects
    */
    public President[] readPresidentsUpdate() throws IOException
    {
        FileReader frCount1 = new FileReader("HashHeapUpdate.txt");
        BufferedReader brCount1 = new BufferedReader(frCount1);
        
         String inputStringCount = brCount1.readLine();
        
        //used to find size of array needed
        count = 0;
        while(inputStringCount != null)
        {
            inputStringCount = brCount1.readLine();
            count++;    
        }// end while 
        
        
        int maxSize = count;
       
        President [] myPresUpdateArr = new President [maxSize]; 

        int number = 0, hashKey = 0, yearsInOffice = 0, probeCount = 0;
        String inputString, tempYearsInOffice, tempNumber, firstName = null, lastName = null, party = null, transaction = null, homeState = null;
        
        FileReader fr = new FileReader("HashHeapUpdate.txt");
        BufferedReader br = new BufferedReader(fr);
        
        inputString =  br.readLine();   
        
        int i = 0;
        while(inputString != null && i < maxSize)
        {
            //System.out.println("TEST");

            String[] stringArr = inputString.split(",");
            
            transaction = stringArr[0];
            if (transaction.equalsIgnoreCase("a"))
            {
                tempNumber = stringArr[1];
                lastName = stringArr[2];
                tempYearsInOffice = stringArr[3];
                party = stringArr[4];
                homeState = stringArr[5];
                number = Integer.parseInt(tempNumber);
                yearsInOffice = Integer.parseInt(tempYearsInOffice);
                
            }// end if
            else 
                if (transaction.equalsIgnoreCase("d"))
                {
                    lastName = stringArr[1];
                    party = "blank";
                    number = -1;
                    yearsInOffice = -1;
                    
                }// end else
            
            
            
           /* try {
                number = Integer.parseInt(inputString.substring(0, 2));
                } catch (NumberFormatException e) 
                    {
                       number = Integer.parseInt(inputString.substring(0, 1));
                    }*/
  
            
            /*
            System.out.print("This is a test print of the input parsing for president ");
            System.out.print("number: " + number + ", ");
            System.out.print("name: " + name + ", ");
            System.out.print("party: " + party + " " );
            */
          
            
            President tempPres = new President(hashKey, transaction, number, firstName, lastName, probeCount, yearsInOffice, party, homeState);
            myPresUpdateArr[i] = tempPres;
            
            // System.out.println("TEST");
    
            i++;
            inputString = br.readLine();
        }//end while loop
        
        //System.out.println("count " + count);
        //System.out.println("array length " + myPresUpdateArr.length);
        /*
        for (int x = 0; x < myPresUpdateArr.length; x++)
            System.out.println(myPresUpdateArr[x].getNumber() + " " + myPresUpdateArr[x].getLastName() + " " + myPresUpdateArr[x].getTransaction());
        */
        return myPresUpdateArr;
             
    }// end readPresidentsUpdate()
    
    
    
}
