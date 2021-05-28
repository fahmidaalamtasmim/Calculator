import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class main_calculator implements ActionListener{

	JFrame f;
	JTextField tf;
	JButton[]nbs = new JButton[10];// array for number buttons 
	JButton[]fbs = new JButton[9];// array for function buttons
	JButton addb,subb,mulb,divb;
	JButton decimalb,eqalb,deleteb,clearb,negb;
	JPanel p;
	
	Font myFont = new Font("Ink free",Font.BOLD,30);
	
	double num1=0, num2=0, result=0;
	char operator;
	
	// constructor of the class
	main_calculator(){
		
		// Frame
		f = new JFrame("CALCULATOR");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(420,550);
		f.setLayout(null);
		
		// TextField
		tf = new JTextField();
		tf.setBounds(50,25,300,50);
		tf.setFont(myFont);
		tf.setEditable(false);// cannot write on the text-field but if you click on the button you can write
		
		//  function Buttons
		addb = new JButton("+");
		subb = new JButton("-");
		mulb = new JButton("*");
		divb = new JButton("/");
		decimalb = new JButton(".");
		eqalb = new JButton("=");
		deleteb = new JButton("Delete");
		clearb = new JButton("CLR");
		negb = new JButton("(-)");
		// adding buttons to the Array of Function Buttons
		fbs[0]=addb;
		fbs[1]=subb;
		fbs[2]=mulb;
		fbs[3]=divb;
		fbs[4]=decimalb;
		fbs[5]=eqalb;
		fbs[6]=deleteb;
		fbs[7]=clearb;
		fbs[8]=negb;
		
		// function button
		for(int i = 0 ; i < 9 ; i++) {
			fbs[i].addActionListener(this);
			fbs[i].setFont(myFont);
			fbs[i].setFocusable(false);
		}
		
		// number buttons 
		for(int i = 0 ; i < 10 ; i++) {
			nbs[i]=new JButton(String.valueOf(i));
			nbs[i].addActionListener(this);
			nbs[i].setFont(myFont);
			nbs[i].setFocusable(false);
		}
		
		// delete button and clear button
		negb.setBounds(50,430,100,50);
		deleteb.setBounds(150,430,100,50);
		clearb.setBounds(250,430,100,50);
		
		
		// JPanel
		p= new JPanel();
		p.setBounds(50,100,300,300);
		p.setLayout(new GridLayout(4,4,10,10));
     //p.setBackground(Color.GRAY);
		
		
		//adding number buttons on the panel
		p.add(nbs[1]);
		p.add(nbs[2]);
		p.add(nbs[3]);
		p.add(nbs[4]);
		p.add(nbs[5]);
		p.add(nbs[6]);
		p.add(nbs[7]);
		p.add(nbs[8]);
		p.add(nbs[9]);
		p.add(nbs[0]);
	// adding function buttons in the panel
		p.add(fbs[0]);
		p.add(fbs[1]);
		p.add(fbs[2]);
		p.add(fbs[3]);
		p.add(fbs[4]);
		p.add(fbs[5]);
		p.add(fbs[6]);
		p.add(fbs[7]);
		
		
		f.add(negb);
		f.add(p);
		f.add(deleteb);
		f.add(clearb);
		f.add(tf);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
	
		main_calculator cal = new main_calculator();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// adding functionalities on number buttons
		for(int i = 0;i<10;i++) {
			if (e.getSource()==nbs[i]) {

				tf.setText(tf.getText().concat(String.valueOf(i)));
			}
		}
		
		//adding functionalities to decimal button
		if(e.getSource()==decimalb) {
			tf.setText(tf.getText().concat("."));
		}
		
		
		// adding functionalities to add button
		if(e.getSource()==addb) {
			num1 = Double.parseDouble(tf.getText());
			operator = '+';
			tf.setText("");
		}
		// adding functionalities to subtract button
				if(e.getSource()==subb) {
					num1 = Double.parseDouble(tf.getText());
					operator = '-';
					tf.setText("");
				}
		// adding functionalities to multiply button
				if(e.getSource()==mulb) {
					num1 = Double.parseDouble(tf.getText());
					operator = '*';
					tf.setText("");
				}	
	// adding functionalities to divide button
				if(e.getSource()==divb) {
					num1 = Double.parseDouble(tf.getText());
					operator = '/';
					tf.setText("");
				}
	// adding functionalities to equal button
		if(e.getSource()==eqalb) {
			
			num2 = Double.parseDouble(tf.getText());
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			
			tf.setText(String.valueOf(result));
			num1=result;
		}
		
		
		// adding functionalities to clear button				
		if(e.getSource()==clearb) {
			tf.setText("");
		}
		// adding functionalities to delete button
		if(e.getSource()==deleteb) {
			String string = tf.getText();
			tf.setText("");
			for(int i = 0 ;    i < string.length()-1;    i++) {
				
				tf.setText(tf.getText()+string.charAt(i));
			}
		}
		// adding functionalities to negative button
		if(e.getSource()==negb) {
			
			double temp = Double.parseDouble(tf.getText());
			temp *=-1;
			tf.setText(String.valueOf(temp));
			
		}
	}

}
