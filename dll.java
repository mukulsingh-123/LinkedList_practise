package LinkedList;
public class dll {
    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head = null;

    public static void Insert_At_first(int data){
        Node newnode = new Node (data);
        if(head == null){
            head = newnode;
            return;
        }
        newnode.next = head;
        newnode.next.prev = newnode;
        head = newnode;
    }
    public static void Insert_At_last(int data){
        Node newnode = new Node (data);
        if(head == null){
            head = newnode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newnode;
        newnode.prev = temp;
        newnode.next = null;
    }

    public static void Insert_At_any(int data, int idx){
        Node newnode = new Node (data);
        if(idx == 0){
            Insert_At_first(data);
            return;
        }
        Node temp = head;
        int count = 0;
        while(temp != null && count<idx-1){
            temp = temp.next;
            count++;
        }
        if(temp == null){
            System.out.println("enter a valid idx");
            return;
        }
        if(temp.next == null){
        temp.next = newnode;
        newnode.prev = temp;
        return;
    }
        newnode.next = temp.next;
        temp.next.prev = newnode;
        newnode.prev = temp;
        temp.next = newnode;
    }

    public static void print(){
        Node temp  = head;
        while(temp != null){
           System.out.print(temp.data + " -> ");
           temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        dll.Insert_At_first(1);
        dll.Insert_At_first(2);
        dll.Insert_At_first(3);
        dll.print();
        dll.Insert_At_last(4);
        dll.Insert_At_last(5);
        dll.print();
        dll.Insert_At_any(8, 2);
        dll.print();
    }

    
}
