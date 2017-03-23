/**
 * reads input from outside files
 * @author Dean
 */
import java.io.*; // needed to read and parse input
public class Input 
{
    /**
    * reads and parses info from Presidents.txt, builds array of Presidents objects 
    * @param none
    * @return This method returns an array of Presidents objects
    */
    public Presidents[] readPresidents() throws IOException
    {
        int maxSize = 44;
        Presidents [] myPresArr = new Presidents[maxSize]; 

        FileReader fr = new FileReader("Presidents.txt");
        BufferedReader br = new BufferedReader(fr);
        
        int number = 0, yearsInOffice = 0;
        String inputString, transaction = null, name = null, firstName = null, lastName = null, code = null, party = null, homeState = null;
        
        inputString =  br.readLine();   
        
        int i = 0;
        while(inputString != null && i < maxSize)
        {
            //System.out.println("TEST");

            name = inputString.substring(2, 24).trim();	
            String[] firstAndLast = name.split("\\s+");
            firstName = firstAndLast[0];
            lastName = firstAndLast[1];
            switch (inputString.substring(25, 26)) 
            {
                case "a":
                    code = inputString.substring(25, 26).trim();
                    break;
                case "b":
                    code = inputString.substring(25, 26).trim();
                    break;
                case "c":
                    code = inputString.substring(25, 26).trim();
                    break;
                default:
                    code = "NA";;
            }// end switch
            party = inputString.substring(29, 48).trim();
            homeState = inputString.substring(49, 62).trim();
            
            try {
                number = Integer.parseInt(inputString.substring(0, 2));
                } catch (NumberFormatException e) 
                    {
                       number = Integer.parseInt(inputString.substring(0, 1));
                    }
  
            try {
                yearsInOffice =  Integer.parseInt(inputString.substring(27, 29));
                } catch (NumberFormatException e)
                    {
                    yearsInOffice = Integer.parseInt(inputString.substring(27, 28));    
                    }
            
            /*System.out.print("This is a test print of the input parsing for president ");
            System.out.print("number: " + number + ", ");
            System.out.print("name: " + name + ", ");
            System.out.print("code: " + code + ", ");
            System.out.print("yearsInOffice: " + yearsInOffice + ", ");
            System.out.print("party: " + party + ", and ");
            System.out.println("homeState: " + homeState); */
          
            
            Presidents tempPres = new Presidents(transaction, number, firstName, lastName, code, yearsInOffice, party, homeState);
            myPresArr[i] = tempPres;
            
            // System.out.println("TEST");
    
            i++;
            inputString = br.readLine();
        }//end while loop
        
        return myPresArr;
  
    }// end readPresidents()
    
    
    /**
    * reads and parses info from Presidents.Update.txt, builds array of updated Presidents objects 
    * @param none
    * @return This method returns an array of updated Presidents objects
    */
    public Presidents[] readPresidentsUpdate() throws IOException
    {
        int maxSize = 9;
        Presidents [] myPresUpdateArr = new Presidents[maxSize]; 

        FileReader fr = new FileReader("Presidents.Update.txt");
        BufferedReader br = new BufferedReader(fr);
        
        int number = 0, yearsInOffice = 0;
        String inputString, name = null, firstName = null, lastName = null, party = null, transaction = null, homeState = null, code = null;
        
        inputString =  br.readLine();   
        
        int i = 0;
        while(inputString != null && i < maxSize)
        {
            //System.out.println("TEST");

            String[] stringArr = inputString.split(",");
            
            transaction = stringArr[0];
            
            name = stringArr[1];
            String[] firstAndLast = name.split("\\s+");
            firstName = firstAndLast[0];
            lastName = firstAndLast[1];
            
            party = stringArr[2];
            
            homeState = stringArr[3];
            
            
            
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
          
            
            Presidents tempPres = new Presidents(transaction, number, firstName, lastName, code, yearsInOffice, party, homeState);
            myPresUpdateArr[i] = tempPres;
            
            // System.out.println("TEST");
    
            i++;
            inputString = br.readLine();
        }//end while loop
        
        return myPresUpdateArr;
             
    }// end readPresidentsUpdate()
          
}// end class Input