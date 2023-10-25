// A00279259 N.Palej
package project2;

import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;
import javax.swing.*;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PhoneGUI extends JFrame implements ActionListener, Serializable {
	Container cp;

	GridBagLayout gridBag = new GridBagLayout();
	GridBagConstraints c = new GridBagConstraints();

	JButton b1 = new JButton("SHOW");
	JButton b2 = new JButton("CLEAR");
	JLabel l1 = new JLabel("Show all Phones", SwingConstants.CENTER);
	JLabel l2 = new JLabel(" ", SwingConstants.CENTER);
	JLabel l3 = new JLabel(" ", SwingConstants.CENTER);

	JPanel phonePanel = new JPanel();

	public PhoneGUI() {
		setTitle("Natalia Palej A0027959");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cp = getContentPane();
		cp.setLayout(gridBag);
		cp.setBackground(Color.white);
		c.fill = GridBagConstraints.HORIZONTAL;

		b1.setBackground(Color.DARK_GRAY);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		b2.setBackground(Color.red);
		b2.addActionListener(this);

		c.gridx = 0;
		c.gridy = 0;
		gridBag.setConstraints(l1, c);
		cp.add(l1);

// Add empty line between
		c.gridx = 0;
		c.gridy = 1;
		gridBag.setConstraints(l2, c);
		cp.add(l2);

// Phone labels panel
		phonePanel.setLayout(new BoxLayout(phonePanel, BoxLayout.Y_AXIS));
		c.gridx = 0;
		c.gridy = 2;
		gridBag.setConstraints(phonePanel, c);
		cp.add(phonePanel);

		c.gridx = 0;
		c.gridy = 3;
		gridBag.setConstraints(b1, c);
		cp.add(b1);

// Add empty line between
		c.gridx = 0;
		c.gridy = 4;
		gridBag.setConstraints(l3, c);
		cp.add(l3);

		c.gridx = 0;
		c.gridy = 5;
		gridBag.setConstraints(b2, c);
		cp.add(b2);

		setSize(800, 500);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(b1)) {
			System.out.println("Show button clicked.");
			l1.setText("Phones Table");
// Retrieve list of phones
			List<Phone> phoneList = getPhoneList();
			if (!phoneList.isEmpty()) {
				for (Phone phone : phoneList) {
// Create new label for each object 
					JLabel phoneLabel = new JLabel(phone.printDetails(), SwingConstants.CENTER);
// Add the label to phone panel
					phonePanel.add(phoneLabel);
				}
				phonePanel.setVisible(true);
			} else {
				System.out.println("List empty");
			}
		} else if (e.getSource().equals(b2)) {
			System.out.println("Clear button clicked.");
			l1.setText("Show Phones Table:");

// Delete phones list
			phonePanel.removeAll();
			phonePanel.setVisible(false);
		} else {
			System.out.println("Something's wrong");
		}
	}

// Call deserialisePhones method from TestPhone class
	public List<Phone> getPhoneList() {
		return TestPhone.deserialisePhones();
	}

	public static void main(String[] args) {
		new PhoneGUI();
	}
}
