/**
 * reads input from outside files
 * @author Dean
 */
import java.io.*; // needed to read and parse input
public class FileInterface 
{
    /**
    * reads and parses info from TreePres.txt, builds array of Presidents objects 
    * @param none
    * @return This method returns an array of Presidents objects
    */
    public President[] readPresidents() throws IOException
    {
       // int maxSize = 44;
        
        int count = 0;
        
        
        FileReader frCount = new FileReader("TreePres.txt");
        BufferedReader brCount = new BufferedReader(frCount);
       
        String inputStringCount = brCount.readLine();
        
        while(inputStringCount != null)
        {
            inputStringCount = brCount.readLine();
            count++;
            
        }
        int maxSize = count;
        
        
        President [] myPresArr = new President[maxSize]; 

        FileReader fr = new FileReader("TreePres.txt");
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
          
            
            President tempPres = new President(transaction, number, firstName, lastName, code, yearsInOffice, party, homeState);
            myPresArr[i] = tempPres;
            
            // System.out.println("TEST");
    
            i++;
            inputString = br.readLine();
        }//end while loop
        
        return myPresArr;
    
    }// end readPresident()
    
}