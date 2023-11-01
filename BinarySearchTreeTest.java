package tester;

import java.util.Scanner;

import core.BinarySearchTree;
import core.BinarySearchTree.Node;

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			BinarySearchTree bTree = new BinarySearchTree();
			boolean exit = false;

			while (!exit) {
				System.out.println("choose any : \n" + "1)Add a element in tree\n" + "2)Is tree empty\n"
						+ "3)Display all by preOrder way\n" + "4)Display all by inOrder way\n"
						+ "5)Display all by postOrder way\n" + "6)Delete All nodes\n" + "7)Is contain element\n"
						+ "8)Get element's parent node and its child node if present\n" + "0)Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("enter an element");
						bTree.insert(sc.nextInt());
						System.out.println("successfully entered");
						break;
					case 2:
						System.out.println("Is Tree empty : " + bTree.isEmpty());
						break;
					case 3:
						bTree.preOrder();
						break;
					case 4:
						bTree.inOrder();
						break;
					case 5:
						bTree.postOrder();
						break;
					case 6:
						bTree.deleteAll();
						System.out.println("successfully delete all nodes");
						break;
					case 7:
						System.out.println("enter element to search in tree : ");
						System.out.println("Is element present :  " + bTree.isContainBinarySearch(sc.nextInt()));
						break;
					case 8:
						System.out.println("enter element : ");
						Node num[] = bTree.getNodeParrentChildNode(sc.nextInt());
						System.out.println(
								"Parant node value is : " + num[0] + " \nsearching element is if present : " + num[1] + ""
										+ "\nleft child if present : " + num[2] + "\nrigth child if present : " + num[3]);
						break;
					case 0:
						System.out.println("Thank you!!!");
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}

	}

}
