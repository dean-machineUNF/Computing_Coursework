/**
 * @author Dean Rice (Michael)
 * represents a stack for P4
 */
public class Stack 
{
    private Node[] stackArr;
    private int maxSize;
    private int top;
    
   /**
    * constructor reserves space in array to implement stack for Node objects, passed param determines size, stack is empty  
    * @param  This method expects one integer
    * @return void 
    */
    public Stack(int s)
    {
        maxSize = s;
        stackArr = new Node[maxSize];
        top = -1;
    }//end constructor
    
    public boolean isEmpty()
    {
        if (top < 0)
            return true;
        else 
            return false;
    }
    
    
    
    
   /**
    * increments top, adds one Node object to the stack
    * @param  This method expects one Node object
    * @return void 
    */
    public void push(Node a)
    {
        stackArr[++top] = a;
    }// end push(Node a)
    
    /**
    * removes one Node object from the stack, decrements top
    * @param  none
    * @return This method returns removed Node object 
    */
    public Node pop()
    {
        if (top < 0)
        { 
            System.out.println("Stack is empty");
            Node tempNode = new Node("b", 0, "b", "b", "b", 0, "b", "b");
            return tempNode;
        }// end if statements
        else
            return stackArr[top--];
    }//end pop()
    
    /**
    * returns Node object at the top of the stack
    * @param  none
    * @return This method returns a Node object
    */
    public Node peek()
    {
         if (top < 0)
        { 
            System.out.println("Stack is empty");
            Node tempNode = new Node("b", 0, "b", "b", "b", 0, "b", "b");
            return tempNode;
        }// end if statements
         else return stackArr[top];
    }// end peek()
    
    public void displayStack()
    {
        for (int i = 0; i < stackArr.length; i++)
            System.out.print(stackArr[i].fData);
    }

}// class Stack
    