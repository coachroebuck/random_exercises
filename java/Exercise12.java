import java.util.*;
import java.lang.Math;

//123*+4- 
//1 + 2 * 3 - 4 
//"1+2*(3^4-5)^(6+7*8)-9"
public class Exercise12 {
	
	public double evaluate(final String input) {
		
		final List<Character> operatorsList = new ArrayList<Character>();
		final List<Double> operandsList = new ArrayList<Double>();
		double result = 0;
		
		for(int i = 0; i < input.length(); i++) {
			Character c = input.charAt(i);

			System.out.println("next char=" + c);
			
			if(Character.isLetterOrDigit(c)) {
				operandsList.add(Double.parseDouble(c.toString()));
			}
			// If the scanned character is an '(', push it to the stack.
            else if (c == '(')
            	operatorsList.add(c);
             
            //  If the scanned character is an ')', pop and output from the stack 
            // until an '(' is encountered.
            else if (c == ')')
            {
            	Boolean didFindParentheses = false;
            	while(operatorsList.size() > 0 && !didFindParentheses) {
            		if(operatorsList.get(operatorsList.size() - 1) != '(') {
            			adjust(operatorsList, operandsList);
            		}
            		else {
            			didFindParentheses = true;
            		}
            	}

            	if(!didFindParentheses) {
            		return Integer.MIN_VALUE;
            	}
            	else {
            		operatorsList.remove(operatorsList.size() - 1);
            	}
            }
            // an operator is encountered
            else 
            {
            	Boolean canStop = false;
            	while(operatorsList.size() > 0 && !canStop) {
            		final int precedence1 = precedence(c);
            		final int precedence2 = precedence(operatorsList.get(operatorsList.size() - 1));
            		if(precedence1 <= precedence2) {
            			adjust(operatorsList, operandsList);
            		}
            		else {
            			canStop = true;
            		}
            	}

            	operatorsList.add(c);
            }
		}

    	while(operatorsList.size() > 0) {
            adjust(operatorsList, operandsList);
    	}

		return operandsList.remove(operandsList.size() - 1);
	}

	private void adjust(final List<Character> operatorsList,
		final List<Double> operandsList) {
			System.out.println("-------------------------------------------");
			listToString(operatorsList);
			listToString(operandsList);
			System.out.println("-------------------------------------------");
			
			final char ch = operatorsList.remove(operatorsList.size() - 1);
			final double a = operandsList.remove(operandsList.size() - 1);
			final double b = operandsList.remove(operandsList.size() - 1);
			final double answer = evaluate(a, ch, b);
			operandsList.add(answer);
	}

	private void listToString(final List list) {
		StringBuilder sb = new StringBuilder();
		for (Object s : list)
		{
		    sb.append(s.toString());
		    sb.append("\t");
		}

		System.out.println(sb.toString());
	}

	// A utility function to return precedence of a given operator
    // Higher returned value means higher precedence
    private double evaluate(final double a, 
    	final char ch,
    	final double b)
    {
        switch (ch)
        {
        case '+':
        	return a+b;
        case '-':
            return a-b;    
        case '*':
        	return a*b;
        case '/':
            return a/b;
        case '^':
            return Math.pow(a, b);
        }
        return -1;
    }

	// A utility function to return precedence of a given operator
    // Higher returned value means higher precedence
    private int precedence(final char ch)
    {
        switch (ch)
        {
        case '+':
        case '-':
            return 1;
      
        case '*':
        case '/':
            return 2;
      
        case '^':
            return 3;
        }
        return -1;
    }

	public String postFixNotation(final String input) {
		
		final StringBuilder sb = new StringBuilder();
		final List<Character> operatorsList = new ArrayList<Character>();
		
		for(int i = 0; i < input.length(); i++) {
			Character c = input.charAt(i);
			if(Character.isLetterOrDigit(c)) {
				sb.append(c);
			}
			// If the scanned character is an '(', push it to the stack.
            else if (c == '(')
            	operatorsList.add(c);
             
            //  If the scanned character is an ')', pop and output from the stack 
            // until an '(' is encountered.
            else if (c == ')')
            {
            	Boolean didFindParentheses = false;
            	while(operatorsList.size() > 0 && !didFindParentheses) {
            		if(operatorsList.get(operatorsList.size() - 1) != '(') {
            			sb.append(operatorsList.remove(operatorsList.size() - 1));
            		}
            		else {
            			didFindParentheses = true;
            		}
            	}

            	if(!didFindParentheses) {
            		return "Invalid expression";
            	}
            	else {
            		operatorsList.remove(operatorsList.size() - 1);
            	}
            }
            // an operator is encountered
            else 
            {
            	Boolean canStop = false;
            	while(operatorsList.size() > 0 && !canStop) {
            		final int precedence1 = precedence(c);
            		final int precedence2 = precedence(operatorsList.get(operatorsList.size() - 1));
            		if(precedence1 <= precedence2) {
            			sb.append(operatorsList.remove(operatorsList.size() - 1));
            		}
            		else {
            			canStop = true;
            		}
            	}

            	operatorsList.add(c);
            }
		}

    	while(operatorsList.size() > 0) {
			sb.append(operatorsList.remove(operatorsList.size() - 1));
    	}

		return sb.toString();
	}

    public static void main(String[] args) {
        final String input = args.length == 1 ? args[0] : "3+5";
		Exercise12 instance = new Exercise12(); 
		System.out.println(instance.postFixNotation(input));
		System.out.println(instance.evaluate(input));
    }
}