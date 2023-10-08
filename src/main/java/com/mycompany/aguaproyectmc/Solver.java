
package com.mycompany.aguaproyectmc;

import org.apache.commons.math3.optim.MaxIter;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear. *;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

public class Solver {
    
    public double process(){
        
        double d = 0;
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
        PointValuePair solution = solver.optimize(new MaxIter(100), f, constraints, GoalType.MINIMIZE, new NonNegativeConstraint(true));

        // Print the results
        System.out.println("x1 = " + solution.getPoint()[0]);
        System.out.println("x2 = " + solution.getPoint()[1]);
        System.out.println("x3 = " + solution.getPoint()[2]);
        System.out.println("Maximum value: " + solution.getValue());
        return d;
    }
    
}
