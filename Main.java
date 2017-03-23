/**
 * @author Dean Rice 
 * Main class for P3
 */

import java.io.IOException;// needed to read and parse input

public class Main 
{
     /**
     * receives presidents objects from Input class and passes them into a PresidentsArray array, manipulates array, builds and manipulates stack, builds and manipulates a doubly linked list
     * @param none
     * @return void
     */
    
    public static void main(String [] args) throws IOException
    {
        FileInterface myFileInterface = new FileInterface();
        
        PresidentController myPresController = new PresidentController(myFileInterface.readPresidents());
        
        //myPresController.displayArr();
        
        BinaryTree presBinaryTree = new BinaryTree();
        
        //System.out.println("");
        
        for (int i = 0; i < myPresController.length(); i++)
        {
            presBinaryTree.insert(myPresController.getPresident(i));
            //System.out.println(myPresController.getPresident(i));
        }
          
               
        System.out.println("Task 3: Iterative NLR Scan \n");
           
        presBinaryTree.displayIterativeNLR();
        
        System.out.println("\n");
           
        System.out.println("Task 4: Iterative LNR Scan \n");
        
        presBinaryTree.displayIterativeLNR();// works but need to format it
        
        System.out.println("\n");
           
        System.out.println("Task 5: Iterative LRN Scan \n");
        
        presBinaryTree.displayIterativeLRN();
        System.out.println("\n");
       
        int preOrder = 1;
        int inOrder = 2;
        int postOrder = 3;
        
        System.out.println("Task 6: Recursive NLR Scan");
        presBinaryTree.traverse(preOrder);// NLR Recursive Preorder
        
        System.out.println("\nTask 7: Recursive LNR Scan");
        presBinaryTree.traverse(inOrder);// LNR Recursive Inorder
        
        System.out.println("\nTask 8: Recursive LRN Scan");
        presBinaryTree.traverse(postOrder);// LRN Recursive Postorder
       
        System.out.println("\nAfter deleting nodes with zero children");
        System.out.print("\n");
        presBinaryTree.delete("Nixon");
        presBinaryTree.traverse(inOrder);
       
        //reset binary search tree for one child deletes
        presBinaryTree.insert(myPresController.getPresident(12));
        //presBinaryTree.traverse(2);
       
        System.out.println("\nAfter deleting nodes with one child");
        System.out.print("\n");
        presBinaryTree.delete("Grant");
        presBinaryTree.delete("Taylor");
        presBinaryTree.traverse(inOrder);
       
        //reset binary search tree for two children deletes
        presBinaryTree.insert(myPresController.getPresident(4));
        presBinaryTree.insert(myPresController.getPresident(7));
        //presBinaryTree.traverse(2);
       
        System.out.println("\nAfter deleting nodes with two children");
        System.out.print("\n");
        presBinaryTree.delete("Clinton");
        presBinaryTree.delete("Van_Buren");
        presBinaryTree.traverse(inOrder);
    
    }//end main()
    
}//end class Main