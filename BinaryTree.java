/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dean
 */
public class BinaryTree 
{
    private Node root;
    private int count;
    
    public BinaryTree()
    {
        root = null;
    }// end constructor
    
    public void find(int key)
    {
        
    } //end find()
    
    public void insert (President a)
    {
        count++;
        Node newNode;
        newNode = new Node(a.getTransaction(),a.getNumber(), a.getLastName(), a.getFirstName(), a.getCode(), a.getYearsInOffice(), a.getParty(), a.getHomeState());
       
        
        if (root == null)
            root = newNode;
        else 
        {
            Node current;
            current = root;
            Node parent;
            while (true)
            {
                parent = current;
                if (newNode.fData.getLastName().compareTo(current.fData.getLastName()) < 0) // go left?
                {
                    current = current.leftChild;
                    if (current == null)
                    {
                        parent.leftChild = newNode;
                        return;
                    } // end nested if
                
                }// end if go left
                
                else 
                {
                    current = current.rightChild;
                    if (current == null)
                    {
                        parent.rightChild = newNode;
                        return;
                    }// end if
                    
                }// end nested else
                    
            }// end while
        
        }// end else
        
        
    } // end insert()
    
    private Node getSuccessor(Node delNode)
    {
        Node successorParent;
        successorParent = delNode;
        Node successor;
        successor = delNode;
        Node current;
        current = delNode.rightChild;
        
        while (current != null)
        {
            successorParent = successor;
            successor = current;
            current = current.leftChild;            
        }// end while
        
        if (successor != delNode.rightChild)
        {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }//end if
        return successor;
    }// end getSuccessor()
    
    
    public boolean delete(String key)
    {
        count--;
        
        Node current;
        current = root;
        Node parent;
        parent = root;
        boolean isLeftChild;
        isLeftChild = true;
        
        while (! current.fData.getLastName().equalsIgnoreCase(key))
        {
            parent = current;
            if (key.compareTo(current.fData.getLastName()) < 0)
            {
                isLeftChild = true;
                current = current.leftChild;
            }
            else
            {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null)
                return false;
        }// end while
        // found node to delete
        
        // if no children, delete node
        if (current.leftChild == null && current.rightChild == null)
        {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.leftChild = null;
            else 
                parent.rightChild = null;
        }// end if
        
        //if no right child, replace with left subtree
        else if (current.rightChild == null)
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else 
                parent.rightChild = current.leftChild;
        
        // if no left child, replace with right subtree
        else if (current.leftChild == null)
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else 
                parent.rightChild = current.rightChild;
        
        else // two children, so replace with inorder sequence 
        {
            //get successor of node to delete (current)
            Node successor;
            successor = getSuccessor(current);
            
            //connect parent of current to successor instead
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else 
                parent.rightChild = successor;
            
            //connect successor to current's left child
            successor.leftChild = current.leftChild;
        }//end else two children
        
        // (successor cannot have a left child
        return true; // delete successful
     
    }// end delete()

    public void displayIterativeNLR() // Preorder  
    {
        System.out.printf("%-20s %-15s %8s \n" , "President's Name", "Party", "Years In Office");
        System.out.print("\n");
        
        Stack myStack = new Stack(count);
        Node current;
        current = root;
        while (true)
        {
            if (current != null)
            {
                myStack.push(current);
                System.out.printf("%-20s %-15s %8s \n" , current.fData.getLastName(), current.fData.getParty(), current.fData.getYearsInOffice());
                current = current.leftChild;
            }// end if
            else
            {
                
            
                if (myStack.isEmpty())
                    return;
                current = myStack.pop();
                
                
                current = current.rightChild;
            }// end else
            
        } // end while
        
    }// end displayIterativeNLR()
    
    public void displayIterativeLNR() //Inorder
    {
        System.out.printf("%-20s %-15s %8s \n" , "President's Name", "Party", "Years In Office");
        System.out.print("\n");
        
        Stack myStack = new Stack(count);
        Node current;
        current = root;
        while (true)
        {
            if (current != null)
            {
                myStack.push(current);
                current = current.leftChild;
            }// end if
            else
            {
                if (myStack.isEmpty())
                    return;
                current = myStack.pop();
                System.out.printf("%-20s %-15s %8s \n" , current.fData.getLastName(), current.fData.getParty(), current.fData.getYearsInOffice());
                
                current = current.rightChild;
            }// end else
            
        } // end while
        
    }// end displayIterativeNLR()
    
        
        
    public void displayIterativeLRN() 
    {
        System.out.printf("%-20s %-15s %8s \n" , "President's Name", "Party", "Years In Office");
        System.out.print("\n");
        
        if( root == null ) 
            return; 
        Stack myStack = new Stack(count);
        Node current = root; 
        while( true ) 
        {
            if( current != null ) 
            { 
                if( current.rightChild != null )
                    myStack.push(current.rightChild); 
                myStack.push( current );
                current = current.leftChild; 
                continue; 
            } // end if
            if(myStack.isEmpty( ) )
                return; 
            current = myStack.pop( ); 
            if( current.rightChild != null && ! myStack.isEmpty( ) && current.rightChild == myStack.peek( ) ) 
            { 
                myStack.pop( ); 
                myStack.push( current ); 
                current = current.rightChild; 
            }// end if 
            else 
            {
                System.out.printf("%-20s %-15s %8s \n" , current.fData.getLastName(), current.fData.getParty(), current.fData.getYearsInOffice());
                current = null; 
            }// end else
            
        }// end while
        
    }// end displayIterativeNLR()

    
    public void traverse(int traverseType)
    {
        switch(traverseType)
        {
            case 1: 
                    System.out.printf("%-20s %-15s %8s \n" , "President's Name", "Party", "Years In Office");
                    System.out.print("\n");
                    preOrder(root);
                    break;
            case 2: 
                    System.out.printf("%-20s %-15s %8s \n" , "President's Name", "Party", "Years In Office");
                    System.out.print("\n");
                    inOrder(root);
                    break;
            case 3: 
                    System.out.printf("%-20s %-15s %8s \n" , "President's Name", "Party", "Years In Office");
                    System.out.print("\n");
                    postOrder(root);
                    break;
        }// end switch
        System.out.println();
        
    }// end traverse()
    
    public void preOrder(Node localRoot)
    {
        if (localRoot != null)
        {
            System.out.printf("%-20s %-15s %8s \n" , localRoot.fData.getLastName(), localRoot.fData.getParty(), localRoot.fData.getYearsInOffice());
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }// end preOrder()
    
    public void inOrder(Node localRoot)
    {
        if (localRoot != null)
        {
            
            inOrder(localRoot.leftChild);
            System.out.printf("%-20s %-15s %8s \n" , localRoot.fData.getLastName(), localRoot.fData.getParty(), localRoot.fData.getYearsInOffice());
            inOrder(localRoot.rightChild);
        }
    }// end inOrder()
    
    public void postOrder(Node localRoot)
    {
        if (localRoot != null)
        {
            
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.printf("%-20s %-15s %8s \n" , localRoot.fData.getLastName(), localRoot.fData.getParty(), localRoot.fData.getYearsInOffice());
        }
    }// end postOrder()
    
   
    
    
    
}//end class BinaryTree 
