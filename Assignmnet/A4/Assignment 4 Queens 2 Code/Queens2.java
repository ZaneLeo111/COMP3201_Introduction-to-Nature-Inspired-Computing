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
public class Queens2 {
    private static int boardSize = 10;

    // inverts the order of a series of genes in the genotype
    public static Integer[] inversionMutate(Integer[] genotype, double p) {
        double pro = Math.random();
        // System.out.println("pro: " + pro);

        if (pro <= p) {

            Random rd = new Random();
            int index1 = rd.nextInt(genotype.length);
            int index2 = rd.nextInt(genotype.length);
            while (index1 > index2) {
                index2 = rd.nextInt(genotype.length);
            }
            // print out the two points
            // System.out.println("point1: " + index1 + " point2: " + index2);

            while (index1 < index2) {
                int temp = genotype[index1];
                genotype[index1] = genotype[index2];
                genotype[index2] = temp;
                index1++;
                index2--;
            }
        }

        return genotype;
    }

    /*
     * performs fitness-proportional parent selection
     * also known as 'roulette wheel' selection
     * selects two parents that are different to each other
     */
    public static Integer[][] rouletteSelect(Integer[][] population) {
        Integer[][] parents = new Integer[2][boardSize];

        Random rand = new Random();
        double[] fitnessValues = new double[population.length];
        double totalFitness = 0.0;

        for (int i = 0; i < population.length; i++) {
            fitnessValues[i] = Queens.measureFitness(population[i]);
            totalFitness += fitnessValues[i];
        }

        for (int i = 0; i < 2; i++) {
            double sum = 0.0;
            int index = -1;
            double rouletteValue = rand.nextDouble() * totalFitness;

            for (int j = 0; j < population.length; j++) {
                sum += fitnessValues[j];
                if (sum >= rouletteValue) {
                    index = j;
                    break;
                }
            }

            if (index != -1) {
                parents[i] = population[index].clone();
            }
        }

        if (Arrays.equals(parents[0], parents[1])) {
            return rouletteSelect(population);
        }

        return parents;
    }

    /*
     * creates a new population through λ + μ survivor selection
     * given a population of size n, and a set of children of size m
     * this method will measure the fitness of all individual in the
     * combined population, and return the n fittest individuals
     * as the new population
     */
    public static Integer[][] survivorSelection(Integer[][] population, Integer[][] children) {
        Integer[][] newPop = new Integer[10][10];

        ArrayList<Integer[]> combinedPop = new ArrayList<>();
        combinedPop.addAll(Arrays.asList(population));
        combinedPop.addAll(Arrays.asList(children));

        combinedPop.sort((a, b) -> {
            double fitnessA = Queens.measureFitness(a);
            double fitnessB = Queens.measureFitness(b);
            return Double.compare(fitnessB, fitnessA);
        });

        for (int i = 0; i < 10; i++) {
            newPop[i] = combinedPop.get(i);
        }

        return newPop;
    }

    // counts the number of unique genotypes in the population
    public static int genoDiversity(Integer[][] population) {
        int uniqueTypes = 0;

        for (int i = 0; i < population.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (Arrays.equals(population[i], population[j])) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueTypes++;
            }
        }
        return uniqueTypes;
    }

}
