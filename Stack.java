/**
 * @author Dean Rice (Michael)
 * represents a stack
 */
public class Stack 
{
    private Presidents[] stackArr;
    private int maxSize;
    private int top;
    
   /**
    * constructor reserves space in array to implement stack for Presidents objects, passed param determines size, stack is empty  
    * @param  This method expects one integer
    * @return void 
    */
    public Stack(int s)
    {
        maxSize = s;
        stackArr = new Presidents[maxSize];
        top = -1;
    }//end constructor
    
   /**
    * increments top, adds one Presidents object to the stack
    * @param  This method expects one Presidents object
    * @return void 
    */
    public void push(Presidents a)
    {
        stackArr[++top] = a;
    }// end push(Presidents a)
    
    /**
    * removes one Presidents object from the stack, decrements top
    * @param  none
    * @return This method returns removed Presidents object 
    */
    public Presidents pop()
    {
        if (top < 0)
        { 
            System.out.println("Stack is empty");
            Presidents tempPres = new Presidents(0, "blank", "blank", 0, "blank", "blank");
            return tempPres;
        }// end if statements
        else
            return stackArr[top--];
    }//end pop()
    
    /**
    * returns Presidents object at the top of the stack
    * @param  none
    * @return This method returns a Presidents object
    */
    public Presidents peek()
    {
         if (top < 0)
        { 
            System.out.println("Stack is empty");
            Presidents tempPres = new Presidents(0, "blank", "blank", 0, "blank", "blank");
            return tempPres;
        }// end if statements
         else return stackArr[top];
    }// end peek()
    
    /**
    * iterates through objects in the stack array and prints them without altering the stack 
    * @param  none
    * @return void 
    */
    public void displayStack()
    {   
        System.out.printf("%-14s %-16s %-1s \n", "Number", "Name", "Party");
        System.out.print("\n");
        System.out.println("Top of stack: ");
        int j = 0;
        for (j = stackArr.length - 1; j >= 0; j--)
            System.out.print(stackArr[j]);
        System.out.println("Bottom of stack");
        System.out.println("\n");
    }//end displayStack()
    
}//end Stack
