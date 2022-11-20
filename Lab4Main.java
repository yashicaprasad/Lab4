import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Lab4Main {
	public static void main(String[] args) {
		try {

			BST test = new BST();

			Dollar[] dollarArray = new Dollar[20];
			dollarArray = new Dollar[] { new Dollar(57.12), new Dollar(23.44), new Dollar(87.43), new Dollar(68.99),
					new Dollar(111.22), new Dollar(44.55), new Dollar(77.77), new Dollar(18.36), new Dollar(543.21),
					new Dollar(20.21), new Dollar(345.67), new Dollar(36.18), new Dollar(48.48), new Dollar(101.00),
					new Dollar(11.00), new Dollar(21.00), new Dollar(51.00), new Dollar(1.00), new Dollar(251.00),
					new Dollar(151.00) };

			test.setRoot(new BSTNode(dollarArray[0]));
			int j = 0;
			for (int i = 19; i >= 1; i--) {
				test.insert(test.getRoot(), dollarArray[i]);
				j += 1;
			}

			FileWriter myWriter = new FileWriter("lab4.txt");

			System.out.println("\nbreadthFirst traversal");
			myWriter.write("\nbreadthFirst traversal \n");
			test.breadthFirst(myWriter);
			System.out.println("\ninOrder traversal \n");
			myWriter.write("\ninOrder traversal \n");
			test.inOrder(myWriter);
			System.out.println("\npreOrder traversal");
			myWriter.write("\npreOrder traversal \n");
			test.preOrder(myWriter);
			System.out.println("\npostOrder traversal");
			myWriter.write("\npostOrder traversal \n");
			test.postOrder(myWriter);

			System.out.println("\nEnter \"add double\" to add a Dollar object to the BST \n");
			System.out.println("Enter \"delete double\" to delete a Dollar object from the BST \n");
			System.out.println("Enter \"search double\" to check if a Dollar object is present in the BST \n");
			myWriter.write("Enter \"add double\" to add a Dollar object to the BST \n");
			myWriter.write("Enter \"delete double\" to delete a Dollar object from the BST \n");
			myWriter.write("Enter \"search double\" to check if a Dollar object is present in the BST \n");
			myWriter.write("Enter \"in|pre|post|breadth\" to print corresponding traversal \n");
			myWriter.write("Enter \"quit\" to exit the program \n");
			myWriter.write("Enter \"print\" to print all traversals \n");

			System.out.printf("Please enter a command: ");
			Scanner myObj = new Scanner(System.in);
			String input = myObj.nextLine();
			myWriter.write("\n" + "Please enter a command: " + input + " \n");

			while (!input.equals("quit")) {

				String[] separatedInput = input.split(" ");

				if (Objects.equals(separatedInput[0], "add")) {
					test.insert(test.getRoot(), new Dollar(Double.parseDouble(separatedInput[1])));
					// test.printTree(test.getRoot());
					test.inOrder(myWriter);

				} else if (Objects.equals(separatedInput[0], "delete")) {
					test.delete(test.getRoot(), new Dollar(Double.parseDouble(separatedInput[1])));
					test.inOrder(myWriter);
				} else if (Objects.equals(separatedInput[0], "in")) {
					test.inOrder(myWriter);
				} else if (Objects.equals(separatedInput[0], "pre")) {
					test.preOrder(myWriter);
				} else if (Objects.equals(separatedInput[0], "post")) {
					test.postOrder(myWriter);
				} else if (Objects.equals(separatedInput[0], "breadth")) {
					test.breadthFirst(myWriter);
				} else if (Objects.equals(separatedInput[0], "print")) {
					test.printTree(test.getRoot(), myWriter);
				} else if (Objects.equals(separatedInput[0], "search")) {
					test.search(test.getRoot(), new Dollar(Double.parseDouble(separatedInput[1])));
					System.out.println(test.search(test.getRoot(), new Dollar(Double.parseDouble(separatedInput[1]))));
					Boolean b = test.search(test.getRoot(), new Dollar(Double.parseDouble(separatedInput[1])));
					myWriter.write(b.toString());
				} else {
					System.out.printf("Invalid Input\n");
					myWriter.write("Invalid Input \n");

				}

				System.out.printf("Please enter a command: ");
				input = myObj.nextLine();
				myWriter.write("\n" + "Please enter a command: " + input + " \n");

			}
			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
}
