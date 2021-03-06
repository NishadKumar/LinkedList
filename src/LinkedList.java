import java.util.HashSet;


public class LinkedList {
	
	Node head;	
	static class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	//prints list's size 
	public int listSize(){
		if(head == null)
			return 0;
		int count = 0;
		Node current = head;
		while(current!=null){
			current = current.next;
			count++;
		}
		return count;
	}
	
	
	
	public int getCount(){
		return getCountRec(head);
	}
	
	//recursive approach to get size of the list
	public int getCountRec(Node node) {
		// TODO Auto-generated method stub
		//Base Case
		if(node == null)
			return 0;
		
		return 1+getCountRec(node.next);
	}
	
	//prints the entire linked list
	public void printList(){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	//method to insert a node in the front(position 1)
	public Node push(int new_data){
		if(head == null){
			Node new_node = new Node(new_data);
			head = new_node;
			return head;
		}
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
		return head;
	}
	
	//method to insert a node before a particular node
	public void insertAfter(Node prev_node, int new_data){
		if(prev_node == null){
			System.out.println("The given previous node cannot be null");
			return;
		}
		
		Node new_node = new Node(new_data);
		new_node.next = prev_node.next;
		prev_node.next = new_node;
		
	}
	
	//method to insert a node at a given position
	public Node insertAtPosition(Node head, int data, int position){
		if(position == 1){
			push(data);
			return head;
		}
		Node new_node = new Node(data);
		Node previous = head;
		int count = 1;
		while(count<position - 1){
			previous = previous.next;
			count++;
		}
		
		Node current = previous.next;
		new_node.next = current;
		previous.next = new_node;
		return head;
	}
	
	//method to insert a node at the end of the list
	public void append(int new_data){
		Node new_node = new Node(new_data);
		if(head == null){
			head  = new Node(new_data);
			return;
		}
		new_node.next = null;
		Node last = head;
		while(last.next!=null){
			last = last.next;
		}
		
		last.next = new_node;
		return;
		
	}
	
	//method to search an element using non-recursive appraoch.
	public int search(Node head, int x){
		Node current = head;
		int count = 0;
		while(current!=null){
			if(current.data == x){
				return count;	//data found
			}
			current = current.next;
			count++;
		}		
		return -1;	//data not found	
	}
	
	
	//method to search for an element using recursion
	public boolean recursiveSearch(Node head, int x){
		//Base case
		if(head == null)
			return false;
		
		if(head.data == x)
			return true;
		
		return recursiveSearch(head.next,x);
	}
	
	
	//method to print middle element in a traditional approach calculating the mid length()
	public int printMiddleElement(Node head){
		if(head == null)
			return -1;
		int size = listSize();
		if(size == 1 || size == 2)
			return head.data;
		int count = 0;
		Node current = head;
		while(count!=size/2){
			current = current.next;
			count++;
		}
		return current.data;
	}
	
	//method to print middle of the linked list using 2 pointers(efficient way)
	public void printMiddle(){
		Node slow_ptr = head;
		Node fast_ptr = head;
		
		if(head!=null){
			while(fast_ptr!=null && fast_ptr.next!=null){
				fast_ptr = fast_ptr.next.next;
				slow_ptr = slow_ptr.next;
			}
			
			System.out.println("The middle element is [" +slow_ptr.data+"]\n");
		}
	}
	
	//method to print Nth node from the end of a linked list
	public int printNthNodeFromLast(Node head, int n){
		int fromFirst = listSize()-n;
		int count = 0;
		Node current = head;
		while(count!=fromFirst){
			current = current.next;
			count++;
		}
		
		return current.data;
	}
	
	
	//method that detects a loop in the linked list if any
	public int detectLoop(){
		Node slow_p = head, fast_p = head;
		while(slow_p!=null && fast_p!=null && fast_p.next!=null){
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			if(slow_p == fast_p){
				System.out.println("Found loop!");
				return 1;
			}
		}
		return 0;
	}
	
	//method that counts the number of occurrences of a particular data in the list
	public int repeatedData(int data){
		int count = 0;
		if(head == null)
			return 0;

		Node temp = head;
		while(temp!= null){
			if(temp.data == data){
				count++;
			}
			temp = temp.next;
		}	
		return count;
	}
	
	public void delete(int pos){
		if(head == null){
			return;
		}
		
		int count = 1;
		Node temp = head;
		while(count!=pos-1){
			temp = temp.next;
			count++;
		}
		Node next = temp.next.next;
		temp.next = next;
	}
	
	//method to reverse a linked list
	public Node reverse(Node node){
		Node current = head;
		Node previous = null;
		Node next = null;
		
		while(current!=null){
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}	
		return previous;
	}
	
	public void deleteNode(Node node_ptr){
		Node temp = node_ptr.next;
		node_ptr.data = temp.data;
		node_ptr.next = temp.next;
		temp = null;
	}
	
	public void printReverse(Node head){
		if(head == null)
			return;
		
		printReverse(head.next);
		System.out.print(head.data+" ");
	}
	public void removeDuplicates(Node head){
		HashSet<Integer> hs = new HashSet<Integer>();
		Node current = head;
		Node prev = null;
		while(current!=null){
			int curVal = current.data;
			if(hs.contains(curVal)){
				prev.next = current.next;
			}else{
				hs.add(curVal);
				prev = current;
			}
			current = current.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList llist = new LinkedList();
		
		llist.push(17);
		
		llist.push(44);
		llist.append(37);
		llist.append(44);
		llist.append(97);
		llist.append(44);
		llist.append(7);
		
		llist.printList();
		System.out.println();
		
		System.out.println("The size of linked list is: "+llist.listSize());
		System.out.println("Element found at position "+(llist.search(llist.head, 37)+1));
		int middleElement = llist.printMiddleElement(llist.head);
		if(middleElement == -1){
			System.out.println("No elements in the list. Please insert nodes to the list.");
			}else{
				System.out.println("The middle element of the linked list is: "+middleElement);
			}
		int nthNode = llist.printNthNodeFromLast(llist.head, 2);
		System.out.println(nthNode);
		System.out.println();
		llist.printList();
		llist.printMiddle();
		
		System.out.println("The total number of times 44 is repeated in the linked list is: "+llist.repeatedData(44));
		System.out.println();
		llist.push(38);
		llist.push(62);
		llist.printList();
		llist.delete(2);
		System.out.println();
		//llist.printList();
		
		//llist.head = llist.reverse(llist.head);
		System.out.println();
		llist.printList();
		llist.deleteNode(llist.head);
		System.out.println();
		llist.printList();
		System.out.println();
		llist.printReverse(llist.head);
		llist.removeDuplicates(llist.head);
		System.out.println();
		llist.printList();
		
	}

}
