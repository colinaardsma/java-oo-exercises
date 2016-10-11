import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.List;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class RobotWindow {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtXPosition;
	private JTextField txtYPosition;
	private JTextField txtSpeed;
	private JTextField txtOrientation;
	private JButton btnMakeRobot;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RobotWindow window = new RobotWindow();
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
	public RobotWindow() {
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
		
		JButton btnNewButton = new JButton("move");
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCreateNewRobot = new JButton("create new robot");
		btnCreateNewRobot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtName.setVisible(true);
				txtXPosition.setVisible(true);
				txtYPosition.setVisible(true);
				txtSpeed.setVisible(true);
				txtOrientation.setVisible(true);
				btnMakeRobot.setVisible(true);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 6, SpringLayout.SOUTH, btnCreateNewRobot);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, btnCreateNewRobot);
		springLayout.putConstraint(SpringLayout.NORTH, btnCreateNewRobot, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnCreateNewRobot, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnCreateNewRobot);
		
		JButton btnRotate = new JButton("rotate");
		springLayout.putConstraint(SpringLayout.NORTH, btnRotate, 6, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, btnRotate, 0, SpringLayout.WEST, btnNewButton);
		frame.getContentPane().add(btnRotate);
		
		JButton btnDistanceToOther = new JButton("distance to other robot");
		springLayout.putConstraint(SpringLayout.NORTH, btnDistanceToOther, 6, SpringLayout.SOUTH, btnRotate);
		springLayout.putConstraint(SpringLayout.WEST, btnDistanceToOther, 0, SpringLayout.WEST, btnNewButton);
		frame.getContentPane().add(btnDistanceToOther);
		
		txtName = new JTextField();
		txtName.setText("name (String)");
		springLayout.putConstraint(SpringLayout.NORTH, txtName, 0, SpringLayout.NORTH, btnCreateNewRobot);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtXPosition = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtName, 0, SpringLayout.WEST, txtXPosition);
		springLayout.putConstraint(SpringLayout.WEST, txtXPosition, 153, SpringLayout.EAST, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, txtXPosition, -10, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtName, 0, SpringLayout.EAST, txtXPosition);
		txtXPosition.setText("x position (int)");
		springLayout.putConstraint(SpringLayout.NORTH, txtXPosition, 0, SpringLayout.NORTH, btnNewButton);
		frame.getContentPane().add(txtXPosition);
		txtXPosition.setColumns(10);
		
		txtYPosition = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtYPosition, 0, SpringLayout.NORTH, btnRotate);
		springLayout.putConstraint(SpringLayout.WEST, txtYPosition, 150, SpringLayout.EAST, btnRotate);
		springLayout.putConstraint(SpringLayout.EAST, txtYPosition, -10, SpringLayout.EAST, frame.getContentPane());
		txtYPosition.setText("y position (int)");
		frame.getContentPane().add(txtYPosition);
		txtYPosition.setColumns(10);
		
		txtSpeed = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtSpeed, 42, SpringLayout.EAST, btnDistanceToOther);
		springLayout.putConstraint(SpringLayout.EAST, txtSpeed, -10, SpringLayout.EAST, frame.getContentPane());
		txtSpeed.setText("speed (int)");
		springLayout.putConstraint(SpringLayout.NORTH, txtSpeed, 0, SpringLayout.NORTH, btnDistanceToOther);
		frame.getContentPane().add(txtSpeed);
		txtSpeed.setColumns(10);
		
		txtOrientation = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtOrientation, 6, SpringLayout.SOUTH, txtSpeed);
		springLayout.putConstraint(SpringLayout.WEST, txtOrientation, 241, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtOrientation, -10, SpringLayout.EAST, frame.getContentPane());
		txtOrientation.setText("orientation (N/S/E/W)");
		frame.getContentPane().add(txtOrientation);
		txtOrientation.setColumns(10);
		
		btnMakeRobot = new JButton("make robot");
		btnMakeRobot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Robot r = new Robot(txtName.getText(), Integer.parseInt(txtXPosition.getText()), Integer.parseInt(txtYPosition.getText()), Integer.parseInt(txtSpeed.getText()), txtOrientation.getText());
				list.
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnMakeRobot, 6, SpringLayout.SOUTH, txtOrientation);
		springLayout.putConstraint(SpringLayout.EAST, btnMakeRobot, -93, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnMakeRobot);
		
		JList<Robot> list = new JList<>();
		springLayout.putConstraint(SpringLayout.NORTH, list, 35, SpringLayout.SOUTH, btnDistanceToOther);
		springLayout.putConstraint(SpringLayout.WEST, list, 32, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, list, -66, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, list, -6, SpringLayout.WEST, btnMakeRobot);
		frame.getContentPane().add(list);
		
		txtName.setVisible(false);
		txtXPosition.setVisible(false);
		txtYPosition.setVisible(false);
		txtSpeed.setVisible(false);
		txtOrientation.setVisible(false);
		btnMakeRobot.setVisible(false);

	}
}
