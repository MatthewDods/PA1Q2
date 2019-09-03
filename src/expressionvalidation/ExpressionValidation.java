/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expressionvalidation;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author 420190038
 */
public class ExpressionValidation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter expression to validate:");
        String expression = sc.next();
        
        System.out.println("Enter both characters to validate against - eg: () or {}.");
        String charPair = sc.next();
        Stack stack = new Stack();
        int a = 0;
        if (charPair.length() == 2) {
            for (int i=0; i < expression.length(); i++) {
                if (expression.charAt(i) == charPair.charAt(0)) {
                    stack.push(expression.charAt(i));
                } else if (expression.charAt(i) == charPair.charAt(1)) {
                    if (stack.empty()) {
                        a++;
                        break;
                    } else {
                        stack.pop();   
                    }
                }
            }
            if (stack.empty() && a == 0) {
                System.out.println("\nValidation complete. This expression is acceptable.");
            } else if (a > 0){
                System.out.println("\nThere were too many closing brackets. Expression failed.");
            }else{
                System.out.println("\nThere were unclosed brackets. Expression failed.");
            }
        } else {
            System.out.println("\nPlease enter two brackets as shown. EG: (), {}, [].\n");
            ExpressionValidation.main(args);
        }
        
    }  
}
    
