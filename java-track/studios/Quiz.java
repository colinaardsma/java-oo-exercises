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
import javax.swing.JPanel;
import javax.swing.JRadioButton;

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
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 45, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				num1Val = 6;
			}
		});
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 163, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 54, SpringLayout.WEST, frame.getContentPane());
		
		textField = new JTextField();
		panel.add(textField);
		springLayout.putConstraint(SpringLayout.NORTH, textField, 33, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 168, SpringLayout.WEST, frame.getContentPane());
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 107, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -93, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, panel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, panel_1);
		frame.getContentPane().add(panel_1);
		
		JRadioButton rdbtnButton = new JRadioButton("Button");
		panel_1.add(rdbtnButton);
		
		JRadioButton rdbtnButton_1 = new JRadioButton("Button");
		panel_1.add(rdbtnButton_1);
		
		JPanel panel_2 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_2, 6, SpringLayout.SOUTH, panel_1);
		springLayout.putConstraint(SpringLayout.WEST, panel_2, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_2, -31, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_2, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel_2);
		
		JLabel num1 = new JLabel(Integer.toString(num1Val));
		panel_2.add(num1);
		springLayout.putConstraint(SpringLayout.NORTH, num1, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, num1, 0, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, num1);
		
		JLabel label = new JLabel("+");
		panel_2.add(label);
		springLayout.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label, 89, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label, -272, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 33, SpringLayout.SOUTH, label);
		
		JLabel num2 = new JLabel("");
		panel_2.add(num2);
		springLayout.putConstraint(SpringLayout.NORTH, num2, 26, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, num2, 135, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, num2, -220, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, num2, -19, SpringLayout.NORTH, panel);
	}
}
