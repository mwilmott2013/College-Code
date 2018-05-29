//Name: Matthew Wilmott
//Assignment 1A

import java.util.Scanner;
public class Assignment1A {
	public static void main(String[] args) {
		
		//Set up variables
		boolean onetoone = true;
		boolean onto = true;
		boolean reflexive = true;
		boolean symmetric = true;
		boolean transitive = true;
		boolean function = true;
		boolean functionOneToOne = true;
		boolean functionOnto = true;
		boolean xUsed = false;
		boolean contained = false;
		boolean containedTwo = false;
		int i = 0;
		int j = 0;
		int partitionCount = 0;
		
		//Create Matrix
		Scanner sc = new Scanner(System.in);
		int matrixSize = sc.nextInt();
		if (matrixSize <= 0) {
			System.out.println("ERROR: Invalid Size");
			return;
		}
		int[][] theMatrix = new int[matrixSize][matrixSize];
		while (sc.hasNext()) {
			i = sc.nextInt();
			j = sc.nextInt();
			if (i <= 0 || j <= 0) {
				System.out.println("ERROR: Invalid Input");
				return;
			}
			theMatrix[i-1][j-1] = 1;
		}
		
		//One to one
		for (int x = 0; x < theMatrix.length; x++) {
			for (int y = 0; y < theMatrix[x].length; y++) {
				if (theMatrix[x][y] == 1) {
					for (int z = 0; z < theMatrix[x].length; z++) {
						if (z == y) {
							continue;
						} else if (theMatrix[x][z] == 1) {
							onetoone = false;
						}
					}
				}
			}
		}
		
		//Onto
		int[] ontoArray = new int[matrixSize];
		for (int x = 0; x < theMatrix.length; x++) {
			for (int y = 0; y < theMatrix[x].length; y++) {
				if (theMatrix[x][y] == 1) {
					ontoArray[y] = 1;
				}
			}
		}
		for (int z = 0; z < ontoArray.length; z++) {
			if (ontoArray[z] == 0) {
				onto = false;
			}
		}
		
		//Reflexive
		for (int x = 0; x < theMatrix.length; x++) {
			if (theMatrix[x][x] != 1) {
				reflexive = false;
			}
		}
		
		//Symmetric
		for (int x = 0; x < theMatrix.length; x++) {
			for (int y = 0; y < theMatrix[x].length; y++) {
				if (theMatrix[x][y] == 1) {
					if (theMatrix[y][x] != 1) {
						symmetric = false;
					}
				}
			}
		}
		
		//Transitive
		for (int x = 0; x < theMatrix.length; x++) {
			for (int y = 0; y < theMatrix[x].length; y++) {
				if (theMatrix[x][y] == 1) {
					for (int z = 0; z < theMatrix.length; z++) {
						if (theMatrix[y][z] == 1) {
							if (theMatrix[x][z] != 1) {
								transitive = false;
							}
						}
					}
				}
			}
		}
		
		//Function
		for (int x = 0; x < theMatrix.length; x++) {
			for (int y = 0; y < theMatrix[x].length; y++) {
				if (theMatrix[x][y] == 1) {
					xUsed = true;
					for (int z = (y+1); z < theMatrix.length; z++) {
						if (theMatrix[x][z] == 1) {
							function = false;
							xUsed = false;
						}
					}
				}
			}
			if (!xUsed) {
				function = false;
			}
			xUsed = false;
		}
		if (function) {
			//check what the function is
			
			//function one to one
			for (int x = 0; x < theMatrix.length; x++) {
				for (int y = 0; y < theMatrix[x].length; y++) {
					if (theMatrix[x][y] == 1) {
						for (int z = 0; z < theMatrix[x].length; z++) {
							if (z == y) {
								continue;
							} else if (theMatrix[x][z] == 1) {
								functionOneToOne = false;
							}
						}
					}
				}
			}
			
			//function onto
			int[] functionOntoArray = new int[matrixSize];
			for (int x = 0; x < theMatrix.length; x++) {
				for (int y = 0; y < theMatrix[x].length; y++) {
					if (theMatrix[x][y] == 1) {
						functionOntoArray[x] = 1;
					}
				}
			}
			for (int z = 0; z < functionOntoArray.length; z++) {
				if (functionOntoArray[z] == 0) {
					functionOnto = false;
				}
			}
		}
		
		//Printing what the input is
		if (onetoone) {
			System.out.println("The input is One-to-One");
		} else {
			System.out.println("The input is not One-to-One");
		}
		if (onto) {
			System.out.println("The input is Onto");
		} else {
			System.out.println("The input is not Onto");
		}
		if (reflexive) {
			System.out.println("The input is Reflexive");
		} else {
			System.out.println("The input is not Reflexive");
		}
		if (symmetric) {
			System.out.println("The input is Symmetric");
		} else {
			System.out.println("The input is not Symmetric");
		}
		if (transitive) {
			System.out.println("The input is Transitive");
		} else {
			System.out.println("The input is not Transitive");
		}
		if (function) {
			System.out.println("The input is a Function");
			if (functionOneToOne){
				System.out.println("The Function is One-to-One");
			} else {
				System.out.println("The Function is not One-to-One");
			}
			if (functionOnto) {
				System.out.println("The Function is Onto");
			} else {
				System.out.println("The Function is not Onto");
			}
		} else {
			System.out.println("The input is not a Function");
		}
		
		//Printing Partitions
		if (reflexive && symmetric && transitive) {
			String[] equiv = new String[matrixSize];
			xUsed = false;
			for (int r = 0; r < equiv.length; r++) {
				equiv[r] = "empty";
			}
			for (int x = 0; x < theMatrix.length; x++) {
				for (int y = 0; y < theMatrix[x].length; y++) {
					if (theMatrix[x][y] == 1) {
						for (int a = 0; a < equiv.length; a++) {
							if (equiv[a].contains(Integer.toString((x+1))) || equiv[a].contains(Integer.toString((y+1)))) {
								contained = true;
							}
						}
						if (!contained) {
							if (x == y) {
								equiv[x] = Integer.toString((x+1));
							} else {
								equiv[x] = Integer.toString((x+1)) + " " + Integer.toString((y+1));
							}
							for (int z = (y+1); z < theMatrix.length; z++) {
								if (theMatrix[x][z] == 1) {
									for (int b = 0; b < equiv.length; b++) {
										if (equiv[b].contains(Integer.toString((z+1)))) {
											containedTwo = true;
										}
									}
									if (!containedTwo) {
										equiv[x] = equiv[x] + " " + Integer.toString((z+1));
									}
									containedTwo = false;
								}
							}
						}
					contained = false;
					}
				}
			}
			for (int d = 0; d < equiv.length; d++) {
				if (equiv[d] != "empty") {
					partitionCount++;
				}
			}
			if (partitionCount > 50) {
				System.out.println("Number of partitions: " + partitionCount);
			} else {
				for (int c = 0; c < equiv.length; c++) {
					if (equiv[c] != "empty") {
						System.out.println(equiv[c]);
					}
				}
			}
		}
	}
}
