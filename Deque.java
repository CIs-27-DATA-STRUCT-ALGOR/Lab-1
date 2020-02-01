

    public   class Deque<Item> {
        DoubleNode head;

        class DoubleNode {
            Item data;
            DoubleNode prev;
            DoubleNode next;

            DoubleNode(Item d)
            {
                data = d;
            }
        }

        public void Insert_at_the_beginning(Item new_data)
        {

            DoubleNode new_Node = new DoubleNode(new_data);

            new_Node.next = head;
            new_Node.prev = null;

            if (head != null)
                head.prev = new_Node;

            head = new_Node;
        }



        public void InsertAfter(DoubleNode node, Item new_data)
        {

            if (node == null) {
                System.out.println("The given previous node cannot be NULL ");
                return;
            }


            DoubleNode new_node = new DoubleNode(new_data);

            new_node.next = node.next;

            node.next = new_node;

            new_node.prev = node;

            if (new_node.next != null)
                new_node.next.prev = new_node;
        }
        public void Remove_at_the_beginning()
        {
            DoubleNode first=head;
            if (head==null)
            {
                System.out.println("The Linked-List is empty can't remove from empty List");
                return;
            }
            head=head.next;
            first.next=null;

        }
        public void Remove_at_the_end()
        {
            DoubleNode last=head;
            DoubleNode prevTolast=null;

            while (last.next !=null)
            {
                prevTolast=last;
                last=last.next;

            }
            prevTolast.next=null;
        }
         public void InsertBefore(DoubleNode node, Item new_data)
         {
             if(node == null)
             {
                 System.out.println("The Next Node Can't be NULL");
                 return;
             }
             DoubleNode new_node=new DoubleNode(new_data);
             new_node.next=node;
             if (node.prev != null)
             {
                 new_node.prev=node.prev;
             }
         }

         public  void print_All_Node(DoubleNode node)
         {
             while (node!=null)
             {
                 System.out.print(node.data+" |<===> | ");
                 node=node.next;
             }
         }


        void Insert_at_the_end(Item new_data)
        {

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
        public void Remove_a_Node(int position)
        {
            // If linked list is empty
            if (head == null)
                return;

            DoubleNode temp = head;

            if (position == 0)
            {
                head = temp.next;
                return;
            }

            for (int i=0; temp!=null && i<position-1; i++)
                temp = temp.next;

            if (temp == null || temp.next == null)
                return;


            DoubleNode next = temp.next.next;

            temp.next = next;
        }
        public void Move_To_Front(DoubleNode node)
        {
            if (head==null)
            {
                head=node;
                node.next=null;
                node.prev=null;
            }
            node.prev=null;
            node.next=head;


        }













}
