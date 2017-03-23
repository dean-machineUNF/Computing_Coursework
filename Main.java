/**
 * @author Dean Rice (Michael) 
 * Main class for P1
 */
import java.io.*; // needed to read and parse input
public class Main 
{
    /**
     * reads and parses input, populates attributes of Presidents objects, and calls
     * methods that manipulate array of Presidents objects
     * @param none
     * @return void
     */
    public static void main(String[] args) throws IOException
    {
        int maxSize = 44;
        PresidentsMDrvr presidentsDrvr;
        presidentsDrvr = new PresidentsMDrvr(maxSize);

        FileReader fr = new FileReader("Presidents.txt");
        BufferedReader br = new BufferedReader(fr);
        
        int number = 0, yearsInOffice = 0;
        String inputString, name = null, code = null, party = null, homeState = null;
        
        inputString =  br.readLine();   
        
        int i = 0;
        while(inputString != null && i < maxSize)
        {
            //System.out.println("TEST");

            name = inputString.substring(2, 24).trim();	
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
            }
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
            
            /* System.out.print("This is a test print of the input parsing for president ");
            System.out.print("number: " + number + ", ");
            System.out.print("name: " + name + ", ");
            System.out.print("code: " + code + ", ");
            System.out.print("yearsInOffice: " + yearsInOffice + ", ");
            System.out.print("party: " + party + ", and ");
            System.out.println("homeState: " + homeState); */
          
            presidentsDrvr.insert(number, name, code, yearsInOffice, party, homeState);
            
            // System.out.println("TEST");
    
            i++;
            inputString = br.readLine();
        }//end while loop
        
        br.close();
        
        presidentsDrvr.displayArr();
        
        presidentsDrvr.sortByNumber();
        
        presidentsDrvr.displayArr();
        
        FileReader fr2 = new FileReader("Presidents.Search.txt");
            BufferedReader br2 = new BufferedReader(fr2);
           
        String inputString1 =  br2.readLine(); 
        String [] parties = new String [7];
        
        int j = 0;
        while (inputString1 != null)
            {
                parties[j] = inputString1.substring(0, 14).trim();
                //System.out.println(parties[j]);
                inputString1 =  br2.readLine(); 
                j++;
            }// end while loop
        
        presidentsDrvr.searchParty(parties);
        
        presidentsDrvr.sortByName();
        
        presidentsDrvr.displayArr();
        
        String [] names = new String [6];
        names[0] = "Abraham Lincoln"; 
        names[1] = "Andrew Jackson";
        names[2] = "Billy Bob";
        names[3] = "George Patton";
        names[4] = "Harry Truman";
        names[5] = "XXX"; 
        
        presidentsDrvr.searchName(names);
     
    }//end main(String [] args)
    
}//end class Main