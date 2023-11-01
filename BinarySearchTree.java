package core;

public class BinarySearchTree {
	private Node root;
	
	public static class Node{
		private int value;
		private Node left;
		private Node right;
		
		public Node() {
			value=0;
			left=right=null;
		}
		
		public Node(int ele) {
			value=ele;
			left=right=null;
		}
		public String toString() {
			return "value : "+value;
		}
		
	}
	
	public BinarySearchTree() {
		root=null;
	}
	
	public boolean isEmpty() {
		return root==null;
	}
	
	public void insert(int ele) {
		Node newNode = new Node(ele);
		if(isEmpty()) {
			root=newNode;
		}
		else {
			insert(root,newNode);
		}
	}
	private void insert(Node node, Node newnNode) {
		if(newnNode.value<node.value) {
			if(node.left==null) {
				node.left=newnNode;
			}
			else {
				insert(node.left,newnNode);
			}
		}
		else {
			if(node.right==null) {
				node.right=newnNode;
			}
			else {
				insert(node.right,newnNode);
			}
		}
	}
	
	public void deleteAll() {
		if(isEmpty()) {
			System.out.println("tree already empty");
			return;
		}
		else {
			deleteAll(root);
		}
	}
	//postorder traversal
	private void deleteAll(Node node) {
		if(node==null) {
			return;
		}
		deleteAll(node.left);
		deleteAll(node.right);
		node.left=null;
		node.right=null;
		node=null;
	}
	public boolean isContainBinarySearch(int key) {
		if(isEmpty()) {
			throw new RuntimeException("tree is empty!!!");
		}
		
		Node trav=root;
		while(trav!=null) {
			if(trav.value==key) {
				return true;
			}
			if(trav.value>key) {
				trav=trav.left;
			}
			else {
				trav=trav.right;
			}
		}
		return false;
	}
	
	public Node[] getNodeParrentChildNode(int key) {
		if(isEmpty()) {
			throw new RuntimeException("tree is empty!!!");
		}
		
		Node trav=root,parent=null;
		
		while(trav!=null) {
			if(trav.value==key) {
				
				return new Node[] {parent,trav,trav.left,trav.right};
			}
				parent=trav;
			if(trav.value>key) {
				trav=trav.left;
			}
			else {
				trav=trav.right;
			}
		}
		return new Node[] {null,null,null,null};
	}
	
	

	
	public void preOrder() {
		if(isEmpty()) {
			System.out.println("tree is empty!!");
			return;
		}
		preOrder(root);
		System.out.println();
	}
	private void preOrder(Node node) {
		if(node==null) {
			return;
		}
		System.out.print(node.value+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void inOrder() {
		if(isEmpty()) {
			System.out.println("tree is empty!!!");
			return;
		}
		inOrder(root);
		System.out.println();
	}
	private void inOrder(Node node) {
		if(node==null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.value+" ");
		inOrder(node.right);
	}
	
	public void postOrder() {
		if(isEmpty()) {
			System.out.println("tree is empty!!!");
			return;
		}
		postOrder(root);
		System.out.println();
	}
	private void postOrder(Node node) {
		if(node==null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value+" ");
	}
	
	

}
