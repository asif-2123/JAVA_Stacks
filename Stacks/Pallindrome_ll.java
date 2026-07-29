import java.util.*;
public class Pallindrome_ll {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=next;
        }
    }
    static class Linked_List{
        static Node head=null;
        
        public static boolean isEmpty(){
            return head==null;
        }
        public static void add(int data){
            Node newNode=new Node(data);
            if(head==null){
                head=newNode;
                return;
            }
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }
    
    public static boolean isPallindrome(Node head){
        Stack<Integer> s=new Stack<>();
        Node temp=head;
        while(temp!=null){
            s.push(temp.data);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.data!=s.pop()){
                return false;
            }
            temp=temp.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Linked_List list= new Linked_List();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(1);
        System.out.println(isPallindrome(list.head));
    }
}
