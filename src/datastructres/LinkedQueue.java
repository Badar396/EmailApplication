/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructres;

/**
 *
 * @author Badar Muneer
 */
public class LinkedQueue
{
    private Node head;
    private int size;
    
    public LinkedQueue()
    {
        head=new Node();
        size=0;
    }
    
    public String first() 
    {
        if(size==0) throw new IllegalStateException();
        return head.next.data;
    }
    
    public String remove() 
    {
        String data=head.next.data;
        head.next=head.next.next;
        head.next.prev=head;
        --size;
        
        return data;
    }

    public void add(String value) 
    {
        head.prev.next=new Node(value,head,head.prev);
        head.prev=head.prev.next;
        ++size;
    }

    public int size() 
    {
        return size;
    }

    public boolean isEmpty() 
    {
        return (size()==0);
    }
    
    public class Node
    {
        Node next;
        Node prev;
        String data;
        
        public Node()
        {
            next=this;
            prev=this;
            data=null;
        }
        
        public Node(String data, Node next,Node prev)
        {
            this.data=data;
            this.next=next;
            this.prev=prev;
        }
    }
}
