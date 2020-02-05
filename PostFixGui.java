import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PostFixGui extends JFrame{
	
	private JButton add;
	private JButton subtract;
	private JButton multiply;
	private JButton divide;
	private JButton mod;
	private JButton exponent;
	private JButton convert;
	private JButton lParen;
	private JButton rParen;
	private JButton clear;
	
	private JButton zero;
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton seven;
	private JButton eight;
	private JButton nine;
	
	private JTextArea showField;
	private JScrollPane show;
	
	private JTextArea resultField;
	private JScrollPane result;
	
	private JLabel instructions;
	
	private JPanel buttonTray;
	private JPanel padder;
	
	private JPanel numberTray;
	private JPanel numberPadder;
	
	private InfixToPostfixConvertor test;
	private static String infixInput;
	
	public PostFixGui(){
		infixInput ="";
		//buttons for the operators
		instructions = new JLabel("Create your infix expression to "
				+ "convert to postfix with the buttons below");
		add = new JButton("+");
		subtract = new JButton("-");
		multiply = new JButton("*");
		divide = new JButton("/");
		mod = new JButton("%");
		exponent = new JButton("^");
		convert = new JButton("Convert to Postfix");
		lParen = new JButton("(");
		rParen = new JButton (")");
		clear = new JButton("Clear");
		
		// buttons for all the numbers
		zero = new JButton("0");
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
				
		buttonTray = new JPanel(); //button tray holds the buttons
		padder = new JPanel();
		buttonTray.setLayout(new GridLayout(2,5,10,10));
		padder.setLayout(new FlowLayout(FlowLayout.LEADING,20,5)); //makes gaps for the tray
		
		//adding all operator buttons to a tray
		buttonTray.add(add);
		buttonTray.add(subtract);
		buttonTray.add(multiply);
		buttonTray.add(divide);
		buttonTray.add(mod);
		buttonTray.add(exponent);
		buttonTray.add(lParen);
		buttonTray.add(rParen);
		buttonTray.add(convert);
		buttonTray.add(clear);
		padder.add(buttonTray);
		
		numberTray = new JPanel();
		numberPadder = new JPanel();
		numberTray.setLayout(new GridLayout(4,3));
		numberPadder.setLayout(new GridLayout(4,3));
		
		//adding all number buttons to a tray
		numberTray.add(zero);
		numberTray.add(one);
		numberTray.add(two);
		numberTray.add(three);
		numberTray.add(four);
		numberTray.add(five);
		numberTray.add(six);
		numberTray.add(seven);
		numberTray.add(eight);
		numberTray.add(nine);
		numberPadder.add(numberTray);
		
		//settin the jtextarea
		resultField = new JTextArea();
		result = new JScrollPane(resultField);
		result.setPreferredSize(new Dimension(200,500));
		
		//adding all components to the gui
		add(instructions,BorderLayout.NORTH);
		add(result);
		add(padder, BorderLayout.SOUTH);
		add(numberPadder,BorderLayout.EAST);
		
		//add button handlers to each of the buttons
		ButtonHandler buttonhandler = new ButtonHandler();
		add.addActionListener(buttonhandler);
		subtract.addActionListener(buttonhandler);
		multiply.addActionListener(buttonhandler);
		divide.addActionListener(buttonhandler);
		mod.addActionListener(buttonhandler);
		exponent.addActionListener(buttonhandler);
		convert.addActionListener(buttonhandler);
		lParen.addActionListener(buttonhandler);
		rParen.addActionListener(buttonhandler);
		clear.addActionListener(buttonhandler);
		zero.addActionListener(buttonhandler);
		one.addActionListener(buttonhandler);
		two.addActionListener(buttonhandler);
		three.addActionListener(buttonhandler);
		four.addActionListener(buttonhandler);
		five.addActionListener(buttonhandler);
		six.addActionListener(buttonhandler);
		seven.addActionListener(buttonhandler);
		eight.addActionListener(buttonhandler);
		nine.addActionListener(buttonhandler);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1100,500);
		setVisible(true);
		
		
	}


private class ButtonHandler implements ActionListener{
	
	//action performed
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="+") {
			resultField.setText(resultField.getText()+"+");
			infixInput+="+";
		}
		else if(e.getActionCommand()=="-") {
			resultField.setText(resultField.getText()+"-");
			infixInput+="-";
		}
		else if(e.getActionCommand()=="*") {
			resultField.setText(resultField.getText()+"*");
			infixInput+="*";
		}
		else if(e.getActionCommand()=="/") {
			resultField.setText(resultField.getText()+"/");
			infixInput+="/";
		}
		else if(e.getActionCommand()=="%") {
			resultField.setText(resultField.getText()+"%");
			infixInput+="%";
		}
		else if(e.getActionCommand()=="^") {
			resultField.setText(resultField.getText()+"^");
			infixInput+="^";
		}
		else if(e.getActionCommand()=="(") {
			resultField.setText(resultField.getText()+"(");
			infixInput+="(";
		}
		else if(e.getActionCommand()==")") {
			resultField.setText(resultField.getText()+")");
			infixInput+=")";
		}
		else if(e.getActionCommand()=="Convert to Postfix") {
			test = new InfixToPostfixConvertor(infixInput);
			resultField.setText(resultField.getText()+"\nPostfix is: "+test.returnPostfix() );
			infixInput="";
			resultField.setText(resultField.getText()+"\n");
		}
		else if(e.getActionCommand()=="Clear") {
			resultField.setText(null);
			infixInput="";
		}
		else if(e.getActionCommand()=="0") {
			resultField.setText(resultField.getText()+"0");
			infixInput+="0";
		}
		else if(e.getActionCommand()=="1") {
			resultField.setText(resultField.getText()+"1");
			infixInput+="1";
		}
		else if(e.getActionCommand()=="2") {
			resultField.setText(resultField.getText()+"2");
			infixInput+="2";
		}
		else if(e.getActionCommand()=="3") {
			resultField.setText(resultField.getText()+"3");
			infixInput+="3";
		}
		else if(e.getActionCommand()=="4") {
			resultField.setText(resultField.getText()+"4");
			infixInput+="4";
		}
		else if(e.getActionCommand()=="5") {
			resultField.setText(resultField.getText()+"5");
			infixInput+="5";
		}
		else if(e.getActionCommand()=="6") {
			resultField.setText(resultField.getText()+"6");
			infixInput+="6";
		}
		else if(e.getActionCommand()=="7") {
			resultField.setText(resultField.getText()+"7");
			infixInput+="7";
		}
		else if(e.getActionCommand()=="8") {
			resultField.setText(resultField.getText()+"8");
			infixInput+="8";
		}
		else if(e.getActionCommand()=="9") {
			resultField.setText(resultField.getText()+"9");
			infixInput+="9";
		}
		
		
		
		
		
	}
	
}
}
