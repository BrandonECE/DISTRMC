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
        
        while(infinityBucle){
            
            
            
        }
        
        ///SIMPLEX
        LinearObjectiveFunction f = new LinearObjectiveFunction(new double[]{3, 2, 3}, 0); // Objective function: 3x + 2y

        // Define constraints
        LinearConstraintSet constraints = new LinearConstraintSet(
                new LinearConstraint[]{ 
                        new LinearConstraint(new double[]{1, 1, 2}, Relationship.LEQ, 5), // x + y ≤ 5
                        new LinearConstraint(new double[]{2, 1, 3}, Relationship.LEQ, 8)  // 2x + y ≤ 8
                }
        );

        // Create a linear optimizer
        SimplexSolver solver = new SimplexSolver();
        PointValuePair solution = solver.optimize(new MaxIter(100), f, constraints, GoalType.MAXIMIZE, new NonNegativeConstraint(true));

        // Print the results
        System.out.println("x1 = " + solution.getPoint()[0]);
        System.out.println("x2 = " + solution.getPoint()[1]);
        System.out.println("x3 = " + solution.getPoint()[2]);
        System.out.println("Maximum value: " + solution.getValue());
        
    }
}
