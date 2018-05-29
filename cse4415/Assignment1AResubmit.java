//Name: Matthew Wilmott
//Assignment 1A Resubmission

import java.util.Scanner;
import java.lang.Runtime;
public class Assignment1AResubmit {
	public static void main(String[] args) {
		Runtime initRuntime = Runtime.getRuntime();
		long initializeTime = System.currentTimeMillis();
		//Set up variables
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
		long endInitTime = System.currentTimeMillis();
		System.out.println("Initialize Time: " + (endInitTime - initializeTime));
		System.out.println("Memory Used after Initialize: " + (initRuntime.totalMemory() - initRuntime.freeMemory()));
		boolean first = oneToOne(theMatrix);
		boolean second = onto(theMatrix);
		boolean third = reflexive(theMatrix);
		boolean fourth = symmetric(theMatrix);
		boolean fifth = transitive(theMatrix);
		boolean sixth = function(theMatrix);
		boolean xUsed = false;
		boolean contained = false;
		boolean containedTwo = false;
		
		//Printing what the input is
		if (first) {
			System.out.println("The input is One-to-One");
		} else {
			System.out.println("The input is not One-to-One");
		}
		
		if (second) {
			System.out.println("The input is Onto");
		} else {
			System.out.println("The input is not Onto");
		}
		
		if (third) {
			System.out.println("The input is Reflexive");
		} else {
			System.out.println("The input is not Reflexive");
		}
		
		if (fourth) {
			System.out.println("The input is Symmetric");
		} else {
			System.out.println("The input is not Symmetric");
		}
		
		if (fifth) {
			System.out.println("The input is Transitive");
		} else {
			System.out.println("The input is not Transitive");
		}
		
		if (sixth) {
			System.out.println("The input is a Function");
			boolean seventh = functionOneToOne(theMatrix);
			boolean eigth = functionOnto(theMatrix);
			if (seventh)	{
				System.out.println("The Function is One-to-One");
			} else {
				System.out.println("The Function is not One-to-One");
			}
			if (eigth) {
				System.out.println("The Function is Onto");
			} else {
				System.out.println("The Function is not Onto");
			}
		} else {
			System.out.println("The input is not a Function");
		}
		
		if (third && fourth && fifth) {
			Runtime runtime = Runtime.getRuntime();
			long startTime = System.currentTimeMillis();
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
				long endTime = System.currentTimeMillis();
				System.out.println("Partitions Time: " + (endTime - startTime));
				System.out.println("Memory Used after Partitions: " + (runtime.totalMemory() - runtime.freeMemory()));
			} else {
				for (int c = 0; c < equiv.length; c++) {
					if (equiv[c] != "empty") {
						System.out.println(equiv[c]);
					}
				}
				long endTime = System.currentTimeMillis();
				System.out.println("Partitions Time: " + (endTime - startTime));
				System.out.println("Memory Used after Partitions: " + (runtime.totalMemory() - runtime.freeMemory()));
			}
		}
	}
		
		//One to one
		public static boolean oneToOne (int[][] theMatrix) {
			Runtime runtime = Runtime.getRuntime();
			long startTime = System.currentTimeMillis();
			for (int x = 0; x < theMatrix.length; x++) {
				for (int y = 0; y < theMatrix[x].length; y++) {
					if (theMatrix[x][y] == 1) {
						for (int z = 0; z < theMatrix[x].length; z++) {
							if (z == y) {
								continue;
							} else if (theMatrix[x][z] == 1) {
								long endTime = System.currentTimeMillis();
								System.out.println("One-to-One Time: " + (endTime - startTime));
								System.out.println("Memory Used after One-to-One: " + (runtime.totalMemory() - runtime.freeMemory()));
								return false;
							}
						}
					}
				}
			}
			long endTime = System.currentTimeMillis();
			System.out.println("One-to-One Time: " + (endTime - startTime));
			System.out.println("Memory Used after One-to-One: " + (runtime.totalMemory() - runtime.freeMemory()));
			return true;
		}
		
		//Onto
		public static boolean onto (int[][] theMatrix) {
			Runtime runtime = Runtime.getRuntime();
			long startTime = System.currentTimeMillis();
			int matrixSize = theMatrix.length;
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
					long endTime = System.currentTimeMillis();
					System.out.println("Onto Time: " + (endTime - startTime));
					System.out.println("Memory Used after Onto: " + (runtime.totalMemory() - runtime.freeMemory()));
					return false;
				}
			}
			long endTime = System.currentTimeMillis();
			System.out.println("Onto Time: " + (endTime - startTime));
			System.out.println("Memory Used after Onto: " + (runtime.totalMemory() - runtime.freeMemory()));
			return true;
		}
		
		//Reflexive
		public static boolean reflexive (int[][] theMatrix) {
			Runtime runtime = Runtime.getRuntime();
			long startTime = System.currentTimeMillis();
			for (int x = 0; x < theMatrix.length; x++) {
				if (theMatrix[x][x] != 1) {
					long endTime = System.currentTimeMillis();
					System.out.println("Reflexive Time: " + (endTime - startTime));
					System.out.println("Memory Used after Reflexive: " + (runtime.totalMemory() - runtime.freeMemory()));
					return false;
				}
			}
			long endTime = System.currentTimeMillis();
			System.out.println("Reflexive Time: " + (endTime - startTime));
			System.out.println("Memory Used after Reflexive: " + (runtime.totalMemory() - runtime.freeMemory()));
			return true;
		}
		
		//Symmetric
		public static boolean symmetric (int[][] theMatrix) {
			Runtime runtime = Runtime.getRuntime();
			long startTime = System.currentTimeMillis();
			for (int x = 0; x < theMatrix.length; x++) {
				for (int y = 0; y < theMatrix[x].length; y++) {
					if (theMatrix[x][y] == 1) {
						if (theMatrix[y][x] != 1) {
							long endTime = System.currentTimeMillis();
							System.out.println("Symmetric Time: " + (endTime - startTime));
							System.out.println("Memory Used after Symmetric: " + (runtime.totalMemory() - runtime.freeMemory()));
							return false;
						}
					}
				}
			}
			long endTime = System.currentTimeMillis();
			System.out.println("Symmetric Time: " + (endTime - startTime));
			System.out.println("Memory Used after Symmetric: " + (runtime.totalMemory() - runtime.freeMemory()));
			return true;
		}
		
		
		//Transitive
		public static boolean transitive (int[][] theMatrix) {
			Runtime runtime = Runtime.getRuntime();
			long startTime = System.currentTimeMillis();
			for (int x = 0; x < theMatrix.length; x++) {
				for (int y = 0; y < theMatrix[x].length; y++) {
					if (theMatrix[x][y] == 1) {
						for (int z = 0; z < theMatrix.length; z++) {
							if (theMatrix[y][z] == 1) {
								if (theMatrix[x][z] != 1) {
									long endTime = System.currentTimeMillis();
									System.out.println("Transitive Time: " + (endTime - startTime));
									System.out.println("Memory Used after Transitive: " + (runtime.totalMemory() - runtime.freeMemory()));
									return false;
								}
							}
						}
					}
				}
			}
			long endTime = System.currentTimeMillis();
			System.out.println("Transitive Time: " + (endTime - startTime));
			System.out.println("Memory Used after Transitive: " + (runtime.totalMemory() - runtime.freeMemory()));
			return true;
		}
		
		//Function
		public static boolean function (int[][] theMatrix) {
			Runtime runtime = Runtime.getRuntime();
			long startTime = System.currentTimeMillis();
			for (int x = 0; x < theMatrix.length; x++) {
				for (int y = 0; y < theMatrix[x].length; y++) {
					if (theMatrix[x][y] == 1) {
						for (int z = (y+1); z < theMatrix.length; z++) {
							if (theMatrix[x][z] == 1) {
								long endTime = System.currentTimeMillis();
								System.out.println("Function Time: " + (endTime - startTime));
								System.out.println("Memory Used after Function: " + (runtime.totalMemory() - runtime.freeMemory()));
								return false;
							}
						}
					}
				}
			}
			long endTime = System.currentTimeMillis();
			System.out.println("Function Time: " + (endTime - startTime));
			System.out.println("Memory Used after Function: " + (runtime.totalMemory() - runtime.freeMemory()));
			return true;
		}
		//check what the function is
			
		//function one to one
		public static boolean functionOneToOne (int[][] theMatrix) {
			Runtime runtime = Runtime.getRuntime();
			long startTime = System.currentTimeMillis();
			for (int x = 0; x < theMatrix.length; x++) {
				for (int y = 0; y < theMatrix[x].length; y++) {
					if (theMatrix[x][y] == 1) {
						for (int z = 0; z < theMatrix[x].length; z++) {
							if (z == y) {
								continue;
							} else if (theMatrix[x][z] == 1) {
								long endTime = System.currentTimeMillis();
								System.out.println("Function One-to-One Time: " + (endTime - startTime));
								System.out.println("Memory Used after Function One-to-One: " + (runtime.totalMemory() - runtime.freeMemory()));
								return false;
							}
						}
					}
				}
			}
			long endTime = System.currentTimeMillis();
			System.out.println("Function One-to-One Time: " + (endTime - startTime));
			System.out.println("Memory Used after Function One-to-One: " + (runtime.totalMemory() - runtime.freeMemory()));
			return true;
		}
			
		//function onto
		public static boolean functionOnto (int[][] theMatrix) {
			Runtime runtime = Runtime.getRuntime();
			long startTime = System.currentTimeMillis();
			int matrixSize = theMatrix.length;
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
					long endTime = System.currentTimeMillis();
					System.out.println("Function Onto Time: " + (endTime - startTime));
					System.out.println("Memory Used after Function Onto: " + (runtime.totalMemory() - runtime.freeMemory()));
					return false;
				}
			}
			long endTime = System.currentTimeMillis();
			System.out.println("Function Onto Time: " + (endTime - startTime));
			System.out.println("Memory Used after Function Onto: " + (runtime.totalMemory() - runtime.freeMemory()));
			return true;
		}
		
	}
