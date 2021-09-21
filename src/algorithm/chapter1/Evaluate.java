package algorithm.chapter1;

import java.lang.String;

import java.util.Scanner;
import java.util.Stack;

public class Evaluate {
    public static void main(String[] args)  {
        Stack<String> operators = new Stack<>();
        Stack<Double> values = new Stack<>();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs= str.split(" ");
        for (String s : strs) {
            if (s.equals("("))                 ;
            else if (s.equals("+")) operators.push(s);
            else if (s.equals("-")) operators.push(s);
            else if (s.equals("*")) operators.push(s);
            else if (s.equals("/")) operators.push(s);
            else if (s.equals("sqrt")) operators.push(s);
            else if (s.equals(")"))
            {
                String operator = operators.pop();
                double value = values.pop();
                if (operator.equals("+")) value = values.pop() + value;
                else if (operator.equals("-")) value = values.pop() - value;
                else if (operator.equals("*")) value = values.pop() * value;
                else if (operator.equals("/")) value = values.pop() / value;
                else if (operator.equals("sqrt")) value =  Math.sqrt(value);
                values.push(value);
            }
            else values.push(Double.parseDouble(s));
        }
        System.out.println(values.pop());
    }
}
