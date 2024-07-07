// singly linkedlist

import java.util.Scanner;

public class linkedlist {
    public static class Node{
        int data;
        Node next;
         Node(int data){ // creating a constructor which will create a node object
            this.data = data;
            this.next = null;
        }
    }
    Scanner sc = new Scanner(System.in);
    public static class sLinkedlist{ // data structure
    public static Node head = null;
    public static Node tail = null;
    
    void createList(int n){ // this method will create a linkedlist of size n. 
            for(int i=0;i<n;i++){
             System.out.println("Enter data");
             Scanner sc = new Scanner(System.in);
             int data= sc.nextInt();
            Node newNode = new Node(data); //Creating a new node 
             if(head == null){
                 //If list is empty, both head and tail will point to new node 
                 head = tail = newNode;
             }
             else{
           tail.next = newNode;// new node will add at the end of list
           tail = newNode;    //newNode will become new tail of the list 
             }
         }
     }
    void insertAtEnd(int data){ // this method will add a new node to the list 
        Node newNode = new Node(data); //Creating a new node 
        if(head == null){
            //If list is empty, both head and tail will point to new node 
            head = tail = newNode;
        }
        else{
      tail.next = newNode;// new node will add at the end of list
      tail = newNode;    //newNode will become new tail of the list 
        }
    }
    void insertAtBeg(int data){
        Node newNode = new Node(data);
        if(head == null){//If list is empty, both head and tail will point to new node 
            head = tail = newNode;

        }
        else{
            newNode.next= head;
            head = newNode;
            
        }
    }
    void insertAtPos(int data, int pos){
         Node newNode = new Node(data);
         Node temp = head;
         if(head == null){//If list is empty, both head and tail will point to new node 
            head = tail = newNode;
            return;

        }else if(pos ==  countNode()){
            insertAtEnd(data);
            return;

        }
        else if(pos == 0){
            insertAtBeg(data);
            return;
        }
        else if(pos<0 || pos>countNode()){
            System.out.println("invalid position");
        }
        else{
            for(int i= 1;i<=pos-1;i++){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next= newNode;

        }
         


    }
    int getElement(int pos){ // return the element of any given index
        Node temp = head;
        if(head == null){
            System.out.println("no element");
            return -1;

        } else if(pos<0 || pos>countNode()){
            System.out.println("invalid position");
            return -1;
        }
        else{
           for(int i=1;i<=pos;i++){
            temp = temp.next;
           }
          
        }
         return temp.data;
    }
    void deletAtPos(int pos){
        if(pos == 0){
            head = head.next;
            return;
        }
         Node temp = head;
         if(head == null){
            System.out.println("no node");
         }else if(pos<0 || pos>countNode()){
            System.out.println("invalid position");
        }else{
        for(int i=1;i<=pos-1;i++){
            temp=temp.next;
        }
        temp.next = temp.next.next;
        tail = temp;
    
    }
}

    void display(){ // printing the list
        Node temp = head;
        if(head == null){
            System.out.println("empty list");
            return;
        }
        else{
        while(temp != null){
            System.out.print(temp.data +"->");
            temp = temp.next;
        }
        System.out.print("X");
    }
}
    public static void displayRecursive(Node head){// printing the list using recusive function
        Node temp= head;
        if(temp == null){
             return;
        }
        System.out.print(temp.data + "->");
        displayRecursive(temp.next);

    }
     public static void displayReverse(Node head){// printing the list in reverse order
        Node temp= head;
        if(temp == null){
             return;
        }
        displayReverse(temp.next);
        System.out.print(temp.data + "->");
      

    }
  int countNode(){
        Node temp = head;
        int count = 0;
        if(head == null){
            return 0;

        }
        else{
            while(temp != null){
                count++;
                temp = temp.next;
            }
        }
        return count;
    }
}
    
        public static void main(String args[]){
       sLinkedlist ll = new sLinkedlist();
       System.out.println("Enter size of linked list");
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       ll.createList(n);
       ll.display();
        System.out.println();
        ll.deletAtPos(0);
         ll.display();
         System.out.println();
         System.out.println("tail is :"+ll.tail.data);
          System.out.println("head is "+ll.head.data);
        //System.out.println(ll.getElement(10));
        // displayRecursive(a);
         System.out.println();
        // displayReverse(a);
        // System.out.println();
        System.out.println(ll.countNode());
    }
}
    
    

