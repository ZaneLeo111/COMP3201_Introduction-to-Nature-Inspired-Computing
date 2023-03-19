import java.lang.Math;
import java.util.*;

/* YOU NEED TO ADD YOUR CODE TO THIS CLASS, REMOVING ALL DUMMY CODE
 *
 * DO NOT CHANGE THE NAME OR SIGNATURE OF ANY OF THE EXISTING METHODS
 * (Signature includes parameter types, return types and being static)
 *
 * You can add private methods to this class if it makes your code cleaner,
 * but this class MUST work with the UNMODIFIED Tester2.java class.
 *
 * This is the ONLY class that you can submit for your assignment.
 *
 * MH DOC_20.23.03.06
 */
public class Queens2
{
    private static int boardSize = 10;
    
    // inverts the order of a series of genes in the genotype
    public static Integer[] inversionMutate(Integer[] genotype, double p)
    {
        // YOUR CODE GOES HERE
        // DUMMY CODE TO REMOVE: (pretends to invert first test genotype)
        genotype = new Integer[]{ 1, 2, 3, 8, 7, 6, 5, 4, 9, 10 };
        // END OF YOUR CODE
        
        return genotype;
    }
    
    /* performs fitness-proportional parent selection
     * also known as 'roulette wheel' selection
     * selects two parents that are different to each other
     */
    public static Integer[][] rouletteSelect(Integer[][] population)
    {
        Integer [][] parents = new Integer [2][boardSize];
        
        // YOUR CODE GOES HERE
        // DUMMY CODE TO REMOVE:
        parents[0] = new Integer[]{ 10, 6, 4, 2, 8, 5, 9, 1, 3, 7 };
        parents[1] = new Integer[]{ 9, 4, 3, 1, 2, 5, 10, 7, 8, 6 };
        // END OF YOUR CODE
        
        return parents;
    }
    
    /* creates a new population through λ + μ survivor selection
     * given a population of size n, and a set of children of size m
     * this method will measure the fitness of all individual in the
     * combined population, and return the n fittest individuals
     * as the new population
     */
    public static Integer[][] survivorSelection(Integer[][] population, Integer [][] children)
    {
        Integer [][] newPop = new Integer [10][10];
        
        // YOUR CODE GOES HERE
        // DUMMY CODE TO REMOVE:
        newPop [0] = new Integer[]{ 10, 6, 4, 2, 8, 5, 9, 1, 3, 7 };
        newPop [1] = new Integer[]{ 9, 4, 3, 1, 2, 5, 10, 7, 8, 6 };
        newPop [2] = new Integer[]{ 9, 4, 3, 1, 2, 5, 10, 7, 8, 6 };
        newPop [3] = new Integer[]{ 9, 5, 6, 10, 8, 7, 1, 3, 2, 4 };
        newPop [4] = new Integer[]{ 9, 5, 6, 10, 8, 7, 1, 3, 2, 4 };
        newPop [5] = new Integer[]{ 3, 2, 7, 4, 10, 1, 8, 9, 6, 5 };
        newPop [6] = new Integer[]{ 10, 9, 8, 6, 7, 2, 3, 4, 1, 5 };
        newPop [7] = new Integer[]{ 7, 8, 9, 1, 10, 2, 3, 4, 5, 6 };
        newPop [8] = new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        newPop [9] = new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        
        
        // END OF YOUR CODE
        
        return newPop;
    }
    
    // counts the number of unique genotypes in the population
    public static int genoDiversity(Integer[][] population)
    {
        int uniqueTypes = 0;
        
        // YOUR CODE GOES HERE
        // DUMMY CODE TO REMOVE:
        uniqueTypes = 6;
        // END OF YOUR CODE
        
        return uniqueTypes;
    }
}
