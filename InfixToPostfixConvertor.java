import java.io.*;
import java.util.*;

public class InfixToPostfixConvertor{
	
	private static Stack stack;
	private static String infix;
	private static StringBuffer postfix;
	
	public InfixToPostfixConvertor(String infix) {
		this.infix = infix;
		stack = new Stack(infix.length());
		postfix = new StringBuffer();
	}
	
	public static void toPostfix() {
		convert();
		printPostfix();
	}
	
	public static String returnPostfix() {
		convert();
		String temp = postfix.toString();
		StringBuilder result = new StringBuilder();
		for(int i =0; i<temp.length();i++) {
			if(i>0) {
				result.append(" ");
			}
			result.append(temp.charAt(i));
		}
		
		String temp2 = result.toString();
		return temp2;
	}
	
	private static void convert() {
		for (int i = 0; i<infix.length(); ++i)
        {
            char c = infix.charAt(i);
             
             // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c))
                 postfix.append(c);
              
            // If the scanned character is an '(', push it to the stack.
            else if (isLeftPar(c))
                stack.push(c);
             
            //  If the scanned character is an ')', pop and output from the stack 
            // until an '(' is encountered.
            else if (isRightPar(c))
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                    postfix.append(stack.pop());
                 
                if (!stack.isEmpty() && stack.peek() != '(')
                	     System.out.println("Invalid Expression");// invalid expression                
                else
                    stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && precendence(c) <= precendence(stack.peek()))
                    postfix.append(stack.pop());
                stack.push(c);
            }
      
        }
      
        // pop all the operators from the stack
        while (!stack.isEmpty())
            postfix.append(stack.pop());
       
	}
	
	private static void printPostfix() {
		System.out.println(postfix);
	}
	
	private static boolean isOperator(char s) {
		switch(s) {
		case '+': case'-': case '*': case '/': case'^': case'%':return true;
		default: return false;
		
		}
	}
	
	private static boolean isLeftPar(char l) {
		if(l=='(')
			return true;
		else
			return false;		
	}
	
	private static boolean isRightPar(char r) {
		if(r==')')
			return true;
		else
			return false;
	}
	
	private static boolean isExponent(char e) {
		if(e=='^')
			return true;
		else
			return false;
	}
	
	private static int precendence(char p) {
		if(p=='+'||p=='-')
			return 1;
		else if(p=='*'||p=='/'||p=='%')
			return 2;
		else if(p=='^')
			return 3;
		else 
			return -1;
	}
}

class Stack{
	
	private int max;
	private char[] stackArray;
	private int top;
	
	public Stack(int max) {
		this.max = max;
		stackArray = new char[max];
		top = -1;
	}
	
	public void push(char c) {
		stackArray[++top]=c;
	}
	
	public char pop() {
		return stackArray[top--];
	}
	
	public char peek() {
		return stackArray[top];
	}
	
	public int size() {
		return top+1;
	}
	
	public char peekIndex(int index) {
		return stackArray[index];
	}
	
	public boolean isEmpty() {
		if(top==-1)
			return true;
		else
			return false;
	}
	
	public void displayStack(String s) {
		System.out.print(s);
		System.out.print("Stack (bottom--> top: ");
		for(int i=0; i<size(); i++) {
			System.out.print(peekIndex(i));
			System.out.print(" ");
		}
		System.out.println("");
	}
	
	
	
	
}

