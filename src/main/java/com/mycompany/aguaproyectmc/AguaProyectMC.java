/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.aguaproyectmc;

import org.apache.commons.math3.optim.linear.*;
import org.apache.commons.math3.optim.MaxIter;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.PointValuePair;


public class AguaProyectMC {

    public static void main(String[] args) {
        
        long presaLitros;
        boolean infinityBucle;
        Datos datos = new Datos();
        presaLitros = datos.litrosMaxPresa;
        infinityBucle = datos.infinityBucle;
        
//        while(infinityBucle){
//            
//            
//            
//        } 
//                                                                     //Mun    1   |    2   |    3  |   4
        ///SIMPLEX                                                    //COL  1, 2, 3| 1, 2, 3|1, 2, 3| 1, 2, 3
        LinearObjectiveFunction f = new LinearObjectiveFunction(new double[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 0);

        // Define constraints
        LinearConstraintSet constraints = new LinearConstraintSet(
                new LinearConstraint[]{ 
                        new LinearConstraint(new double[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, Relationship.LEQ, 9),
                        new LinearConstraint(new double[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, Relationship.LEQ, 9),  
                        new LinearConstraint(new double[]{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, Relationship.LEQ, 9),
                        new LinearConstraint(new double[]{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, Relationship.LEQ, 9),
                        new LinearConstraint(new double[]{0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0}, Relationship.LEQ, 9),
                        new LinearConstraint(new double[]{0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, Relationship.LEQ, 9),
                        new LinearConstraint(new double[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, Relationship.LEQ, 9),
                        new LinearConstraint(new double[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0}, Relationship.LEQ, 9),
                        new LinearConstraint(new double[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, Relationship.LEQ, 9),
                        new LinearConstraint(new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, Relationship.LEQ, 9),
                        new LinearConstraint(new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, Relationship.LEQ, 9),
                        new LinearConstraint(new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, Relationship.LEQ, 9),
                        new LinearConstraint(new double[]{1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, Relationship.LEQ, 27),
                        new LinearConstraint(new double[]{0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0}, Relationship.LEQ, 27),
                        new LinearConstraint(new double[]{0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, Relationship.LEQ, 27),
                        new LinearConstraint(new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1}, Relationship.LEQ, 27),
                        
               
                }
        );

        // Create a linear optimizer
        SimplexSolver solver = new SimplexSolver();
        PointValuePair solution = solver.optimize(new MaxIter(100), f, constraints, GoalType.MAXIMIZE, new NonNegativeConstraint(true));

        // Print the results
        for (int i = 0; i < 12; i++) {
           System.out.println("x"+(i+1)+" = " + solution.getPoint()[i]);
        }

        System.out.println("Maximum value: " + solution.getValue());
        
    }
}
