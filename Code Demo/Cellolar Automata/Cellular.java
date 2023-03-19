/******************************************************************************
 *  Compilation:  javac Cellular.java
 *  Execution:    java Cellular n
 *  
 *  Simulates and prints n steps of the Rule 90 cellular automaton.
 *
 *  Sample output:  java Cellular 10
 *
 *              *         
 *             * *        
 *            *   *       
 *           * * * *      
 *          *       *     
 *         * *     * *    
 *        *   *   *   *   
 *       * * * * * * * *  
 *      *               * 
 *
 *
 *  Copyright © 2000–2017, Robert Sedgewick and Kevin Wayne.
 ******************************************************************************/

public class Cellular { 
   public static void main(String[] args) { 
      int n = Integer.parseInt(args[0]);
      int numCells = 2 * n;

      boolean[] cells = new boolean[numCells];      // cellular automaton at time t
      boolean[] old   = new boolean[numCells];      // cellular automaton at time t-1
      cells[numCells/2] = true;
  
      for (int t = 1; t < n; t++) {

         // draw current row
         for (int i = 0; i < numCells; i++) {
             if(cells[i]) System.out.print("*");
            else         System.out.print(" ");
         }
         System.out.println("");

         // save current row
         for (int i = 0; i < numCells; i++)
            old[i] = cells[i];

         // update cells according to rule 90
         for (int i = 1; i < numCells - 1; i++)
            cells[i] = old[i-1] ^ old[i+1];      // ^ means XOR
      }
   }
}
