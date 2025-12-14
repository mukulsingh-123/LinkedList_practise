package LinkedList;


class Node{
   int data;
   Node next;

   Node(int data){
      this.data = data;
      this.next = null;
   }
}

public class basic{
    static Node head = null;

    public void addfirst(int data){
        Node newnode = new Node(data);
        if(head == null){
           head=newnode;
           return;
        }
        newnode.next = head;
        head = newnode;
    }

public void insert_at_last(int data){
    Node newnode = new Node(data);
    if(head == null){
        head = newnode;
        return;
    }
    Node temp = head;
    while(temp.next != null){
        temp = temp.next;
    }
    temp.next = newnode;
}

public void insert_at_any(int data, int k){
    Node newnode = new Node(data);
    if(k==0){
        newnode.next = head;
        head = newnode;
        return;
    }
    Node temp = head;
    int count = 0;
    while (temp != null && count < k - 1) {
        temp = temp.next;
        count++;
    }
     
    if(temp == null){
        System.out.println("please enter a valid index");
        return;
    }
    newnode.next = temp.next;
    temp.next = newnode;
}

public int total_size(){
    int count = 0;
    Node temp  = head;
    while(temp != null){
        count++;
        temp = temp.next;
    }
    return count;
}

public int removeFirst(){
    int size = total_size();
    if(size == 0){
        return Integer.MIN_VALUE;
    }
    if(size==1){
        int val = head.data;
        head = null;
        size = 0;
        return val;
    }
    int val = head.data ;
    head = head.next;
    size--;
    return val;
}

public int removeLast(){
    int size = total_size();
    if(size == 0){
        return Integer.MIN_VALUE;
    }
    if(size==1){
        int val = head.data;
        head = null;
        size = 0;
        return val;
    }
    Node temp = head;
    while(temp.next.next != null){
        temp = temp.next;
    }
    int val = temp.next.data;
    temp.next = null;
    size--;
    return val;
    
}

public int removeAtAny(int k){
    int size = total_size();
    if(size == 0){
        return Integer.MIN_VALUE;
    }
    if(size==1){
        int val = head.data;
        head = null;
        size = 0;
        return val;
    }
    int count = 0;
    Node temp = head;
    while(temp != null && count < k-1){
        temp = temp.next;
        count++;
    }
    int val = temp.next.data;
    temp.next = temp.next.next;
    size--;
    return val;
    
}

public boolean Search(int n){
    Node temp = head;
    while(temp != null){
        if(temp.data == n){
            return true;
        }
        temp = temp.next;
    }
    return false;
}
public void reverse(){
    Node prev = null;
    Node curr = head;
    while(curr != null){
        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    head = prev;
}  

    public void print(){
        Node temp  = head;
        while(temp != null){
           System.out.print(temp.data + " -> ");
           temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        basic ll = new basic();
        ll.insert_at_last(1);
        ll.insert_at_last(2);
        ll.insert_at_last(3);
        ll.insert_at_any(4, 2);
        ll.print();
        // ll.removeFirst();
        // ll.print();
        // ll.removeLast();
        // ll.print();
        // ll.removeAtAny(2);
        // System.out.println(ll.Search(5));
        ll.reverse();
        ll.print();
    }
}



// public  class insert_at_first {

//     static class Node {   // static nested class
//         int data;
//         Node next;

//         Node(int data) {
//             this.data = data;
//             this.next = null;
//         }
//     }

//     static Node head = null;  // static head

//     public static void addFirst(int data) {
//         Node newNode = new Node(data);
//         newNode.next = head;
//         head = newNode;
//     }

//     public static void printList() {
//         Node temp = head;
//         while (temp != null) {
//             System.out.print(temp.data + " -> ");
//             temp = temp.next;
//         }
//         System.out.println("null");
//     }

//     public static void main(String[] args) {
//         addFirst(1);
//         addFirst(2);
//         addFirst(3);
//         printList();
//     }
// }
