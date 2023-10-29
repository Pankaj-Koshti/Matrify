 /* Copyright (C) 2023 - All Rights Reserved
   You may use, distribute and modify this code under the
 * terms of the XYZ license
 */
package comoany;

import java.util.Scanner;
class Main
{
   public static void main(String[] args)
   {
       Scanner scanner = new Scanner(System.in);
       int[][] matrix1 = new int[2][2];      
       int[][] matrix2 = new int[2][2];      
       System.out.println("**Welcome to Matric_Calculator**");
       // Input for the first matrix
       System.out.println("Input the first matrix:");
       for (int i = 0; i < 2; i++)
       {
           for (int j = 0; j < 2; j++)
           {
               System.out.println("Enter the element at row "+(i+1)+", column "+(j+1));
               matrix1[i][j] = scanner.nextInt();
           }
       }

       // Input for the second matrix
       System.out.println("Input the second matrix:");
       for (int i = 0; i < 2; i++) 
       {
           for (int j = 0; j < 2; j++) 
           {
               System.out.println("Enter the element at row "+(i+1)+", column "+(j+1));
               matrix2[i][j] = scanner.nextInt();
           }
       }

       // Menu for matrix operations
       while (true) 
       {
           System.out.println("Matrix Calculator Menu:");
           System.out.println("1. Addition");
           System.out.println("2. Subtraction");
           System.out.println("3. Multiplication");
           System.out.println("4. Square of a matrix");
           System.out.println("5. Inverse (for 2x2 matrix)");
           System.out.println("6. Transpose");
           System.out.println("7. Properties (Symmetric, skew symmetric, orthogonal etc.)");
           System.out.println("8. Exit");
           System.out.print("Enter your choice: ");
           int choice = scanner.nextInt();

           switch (choice) 
           {
               case 1:
                   // Matrix Addition
                   int[][] resultAddition = addMatrices(matrix1, matrix2);
                   displayMatrix(resultAddition);
                   break;
               case 2:
                   // Matrix Subtraction
                   int[][] resultSubtraction = subtractMatrices(matrix1, matrix2);
                   displayMatrix(resultSubtraction);
                   break;
               case 3:
                   // Matrix Multiplication
                   int[][] resultMultiplication = multiplyMatrices(matrix1, matrix2);
                   displayMatrix(resultMultiplication);
                   break;
               case 4:
            	   //Square of a matrix
            	   int[][] resultSquare = multiplyMatrices(matrix1, matrix1);
            	   displayMatrix(resultSquare);
            	   break;
               case 5:
                   // Matrix Inverse (for 2x2 matrix)
                   double[][] resultInverse = inverseMatrix(matrix1);
                   displayMatrix(resultInverse);
                   break;
               case 6:
                   // Matrix Transpose
                   int[][] resultTranspose = transposeMatrix(matrix1);
                   displayMatrix(resultTranspose);
                   break;
                   
               case 7:
            	   // Symmetricity, skew, orthogonal
            	   isSymmetric(matrix1);
            	   isSkewSymmetric(matrix1);
            	   identity(matrix1);
            	   break;
               case 8:
                   // Exit the program
                   System.out.println("Exiting Matrix Calculator...");
                   System.exit(0);
               default:
                   System.out.println("Invalid choice. Please enter a valid option.");
           }
       }
   }

   // Matrix addition
   public static int[][] addMatrices(int[][] A, int[][] B) 
   {
       int[][] result = new int[2][2];
       for (int i = 0; i < 2; i++) 
       {
           for (int j = 0; j < 2; j++) 
           {
               result[i][j] = A[i][j] + B[i][j];
           }
       }
       return result;
   }

   // Matrix subtraction
   public static int[][] subtractMatrices(int[][] A, int[][] B) 
   {
       int[][] result = new int[2][2];
       for (int i = 0; i < 2; i++) 
       {
           for (int j = 0; j < 2; j++) 
           {
               result[i][j] = A[i][j] - B[i][j];
           }
       }
       return result;
   }

   // Matrix multiplication
   public static int[][] multiplyMatrices(int[][] A, int[][] B) 
   {
       int[][] result = new int[2][2];
       for (int i = 0; i < 2; i++) 
       {
           for (int j = 0; j < 2; j++) 
           {
               result[i][j] = 0; 
               for (int k = 0; k < 2; k++) 
               {
                   result[i][j] += A[i][k] * B[k][j];
               }
           }
       }
       return result;
   }

   // Inverse of a 2x2 matrix
   public static double[][] inverseMatrix(int[][] A) 
   {
       double det = A[0][0] * A[1][1] - A[0][1] * A[1][0];
       if (det == 0) 
       {
           System.out.println("Matrix is not invertible, because the determinant of this matrix is zero!");
           System.exit(1);
       }
       double[][] result = new double[2][2];
       result[0][0] = A[1][1] / det;
       result[0][1] = -A[0][1] / det;
       result[1][0] = -A[1][0] / det;
       result[1][1] = A[0][0] / det;
       return result;
   }

   // Transpose of a matrix
   public static int[][] transposeMatrix(int[][] A) 
   {
       int[][] result = new int[2][2];
       for (int i = 0; i < 2; i++) {
           for (int j = 0; j < 2; j++) 
           {
               result[i][j] = A[j][i];
           }
       }
       return result;
   }
   
   public static void isSymmetric(int[][] A) 
   {
	   int f = 0;
	   for (int i = 0; i < 2; i++) 
	   {
           for (int j = 0; j < 2; j++) 
           {
               if (A[i][j] != A[j][i]) 
               {
                    f = 1;
               }
           }
       }
	   if(f==0) 
	   {		   
		   System.out.println("Symmetric: true");
	   }
	   else {
		   System.out.println("Symmetric: false");
	   }
   }
   
   public static void isSkewSymmetric(int[][] A) 
   {
	   int f = 0;
	   for (int i = 0; i < 2; i++) 
	   {
           for (int j = 0; j < 2; j++) 
           {
               if (A[i][j] == (-1)*A[j][i]) 
               {
                    f = 1;
               }
           }
       }
	   if(f==1) 
	   {		   
		   System.out.println("Skew symmetric: true");
	   }
	   else {
		   System.out.println("Skew symmetric: false");
	   }
   }
    
   public static boolean orthogonal(int[][] A) 
   {
	   int[][] B = transposeMatrix(A);
	   int[][] C = multiplyMatrices(A, B);
	   for(int i=0; i< 2; i++) {
		   for(int j=0; j< 2; j++) 
		   {
			   if(i==j && C[i][j]!=1) 
			   {
				   return false;
			   }
			   if(i!=j && C[i][j]!=0) 
			   {
				   return false;
			   }			   
		   }
	   }
	   return true;
   }
   public static void identity(int[][] A) 
   {
	   boolean b = orthogonal(A);
	   System.out.println("Matrix is orthogonal:"+b);
   }
   // Display a matrix
   public static void displayMatrix(int[][] matrix) 
   {
       for (int i = 0; i < 2; i++) 
       {
           for (int j = 0; j < 2; j++) 
           {
               System.out.print(matrix[i][j] + " ");
           }
           System.out.println();
       }
   }

   // Overloaded method to display a double matrix
   public static void displayMatrix(double[][] matrix) 
   {
       for (int i = 0; i < 2; i++) 
       {
           for (int j = 0; j < 2; j++) 
           {
               System.out.print(matrix[i][j] + " ");
           }
           System.out.println();
       }
   }
}