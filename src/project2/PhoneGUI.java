// A00279259 N.Palej

package project2;

import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.SwingConstants;
import javax.swing.border.Border;



@SuppressWarnings("serial")
public class PhoneGUI extends JFrame implements ActionListener  {
	
	Container cp;
	
	// List to retrieve phones
	List<Phone> phoneList;
	
	JButton b1 = new JButton("SHOW");
	JButton b2 = new JButton("CLEAR");
	JLabel l1 = new JLabel("Show all Phones", SwingConstants.CENTER);
	JLabel l2 = new JLabel(" ", SwingConstants.CENTER);
	
	public PhoneGUI() {
		setTitle("Natalia Palej A0027959");
		
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		cp = getContentPane();
		cp.setLayout(gridBag);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		b1.setPreferredSize(new Dimension(150, 30));
		b1.setBackground(Color.PINK);
		b1.addActionListener(this);
		b2.setPreferredSize(new Dimension(150, 30));
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		l1.setPreferredSize(new Dimension(150, 30));
		l1.setBorder(blackline);
		
		c.gridx = 0;
		c.gridy = 0;
		gridBag.setConstraints(l1, c);
		cp.add(l1);
		
		c.gridx = 0;
		c.gridy = 1;
		gridBag.setConstraints(l2, c);
		cp.add(l2);
		
		c.gridx = 0;
		c.gridy = 2;
		gridBag.setConstraints(b1, c);
		cp.add(b1);
		
		c.gridx = 1;
		c.gridy = 2;
		gridBag.setConstraints(b2, c);
		cp.add(b2);
		
		setSize(500, 400); 
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(b1)) {
			System.out.println("Button clicked.");
			l1.setText("Phones Table");
			// Retrieve list of phones 
			l2.setText(""); 
        }
		else {
			System.out.println("Something's wrong");
		}
	}
	
	public static void main(String[] args) {
		new PhoneGUI();
	}

}
