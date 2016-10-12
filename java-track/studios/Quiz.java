import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JFormattedTextField;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Quiz {

	private JFrame frame;
	private JTextField textField;
	private int num1Val;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quiz window = new Quiz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Quiz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel num1 = new JLabel(Integer.toString(num1Val));
		springLayout.putConstraint(SpringLayout.NORTH, num1, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, num1, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(num1);
		
		JLabel label = new JLabel("+");
		springLayout.putConstraint(SpringLayout.WEST, label, 6, SpringLayout.EAST, num1);
		springLayout.putConstraint(SpringLayout.SOUTH, label, 0, SpringLayout.SOUTH, num1);
		frame.getContentPane().add(label);
		
		JLabel num2 = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, num2, 0, SpringLayout.NORTH, num1);
		springLayout.putConstraint(SpringLayout.WEST, num2, 6, SpringLayout.EAST, label);
		frame.getContentPane().add(num2);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				num1Val = 6;
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 33, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, num1);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 75, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 54, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 33, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 41, SpringLayout.EAST, btnNewButton);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}

}
