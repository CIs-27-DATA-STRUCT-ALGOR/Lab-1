
import org.w3c.dom.Node;

public   class Deque<Item> {
    public DoubleNode head;// the head of the DoubleNode

    public Deque() {//constructor
        head = null;
    }

    public Deque(DoubleNode a) {// custom constructor
        head = a;

    }

    class DoubleNode {//DoubleNode class for creating a doubly node
        Item data;//stores the node data
        DoubleNode prev;//points to the previous node
        DoubleNode next;// points to the previous node

        DoubleNode(Item d) {
            data = d;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }//checks if the Deque is empty


    public void insertAtBeginning(Item new_data) {// insertes data at the beginning of the DoublNode

        DoubleNode new_Node = new DoubleNode(new_data);// create a node

        new_Node.next = head;//set the next node to the head
        new_Node.prev = null;// it's previous is null because it's now the head node

        if (head != null)//check if the head is not null if not set the current head previous to the new_node
            head.prev = new_Node;

        head = new_Node;//new_node is current head
    }


    public void InsertAfter(Item new_data, DoubleNode node) {// Insert after given node

        if (node == null) {//check if the node is null if so return nothing
            System.out.println("The given previous node cannot be NULL ");
            return;
        }


        DoubleNode new_node = new DoubleNode(new_data);//node to store the node we want to insert

        new_node.next = node.next;

        node.next = new_node;

        new_node.prev = node;

        if (new_node.next != null)
            new_node.next.prev = new_node;
    }

    public void removeFromBeginning() {// remove from the beginning
        DoubleNode first = head;
        if (head == null) {
            System.out.println("The Linked-List is empty can't remove from empty List");
            return;
        }
        head = head.next;
        first.next = null;

    }

    public void removeFromEnd() {//remove node from the end
        DoubleNode last = head;
        DoubleNode prevTolast = null;

        while (last.next != null) {
            prevTolast = last;
            last = last.next;

        }
        prevTolast.next = null;
    }

    public void insertBefore(Item new_data, DoubleNode node) {//insert before a given node
        if (node == null) {
            System.out.println("The Next Node Can't be NULL");
            return;
        }
        DoubleNode new_node = new DoubleNode(new_data);
        new_node.next = node;
        node.prev=new_node;
        if (node.prev != null) {
            new_node.prev = node.prev;
        }
    }

    public void print_All_Node(Deque.DoubleNode node) {//prints all node out
        while (node != null) {
            System.out.print(node.data + " <*******> ");
            node = node.next;
        }
    }


    void insertAtEnd(Item new_data) {//Insert's at the End

        DoubleNode new_node = new DoubleNode(new_data);

        DoubleNode last = head;


        new_node.next = null;


        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }

        while (last.next != null)
            last = last.next;

        last.next = new_node;

        new_node.prev = last;
    }

    public void remove(DoubleNode node) {//removes a node


        if (head == null) {
            return;
        }
        //
        node.prev.next=node.next;//set the next of the node to the right and attach is to the previous node next
        node.next.prev=node.prev;//set the previous of the node to the left and attach is to the next node previous
        node.data = null;


    }




        public void moveToFront(DoubleNode node)//moves to the front
        {
        // check id the head is null if so set the node we want to move to the head because there is no head
        if (head == null)
        {
            head = node;
            node.next = null;
            node.prev = null;
        }
        //breakes the ties between the  previous and next of the node we want  to move and attaches them.
        node.prev.next=node.next;//set the next of the node to the right and attach is to the previous node next
        node.next.prev=node.prev;//set the previous of the node to the left and attach is to the next node previous
        node.prev=null;
        node.next = head;
        head=node;


        }



        public void moveToEnd(DoubleNode node)//moves to the end
        {
            DoubleNode last=head;

            if (head == null) {
                head = node;
                node.next = null;
                node.prev = null;
            }



            while (last.next != null)
                last = last.next;
            last.next = node;
            node.next=null;
            node.prev=last.next;


        }


    }















