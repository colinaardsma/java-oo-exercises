import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class RobotWindow {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtXPosition;
	private JTextField txtYPosition;
	private JTextField txtSpeed;
	private JTextField txtOrientation;
	private JButton btnMakeRobot;
	private JList list;
	private DefaultListModel<Robot> listModel;
	private JTextField txtMove;
	private JLabel lblDistance;
	public double dist;
	public Robot r1;
	public Robot r2;


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
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listModel.get(list.getSelectedIndex()).moveUser(Integer.parseInt(txtMove.getText()));
			}
		});
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
		btnRotate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listModel.get(list.getSelectedIndex()).rotate();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnRotate, 6, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, btnRotate, 0, SpringLayout.WEST, btnNewButton);
		frame.getContentPane().add(btnRotate);
		
		dist = 1234.0;

		JButton btnDistanceToOther = new JButton("distance to other robot");
		btnDistanceToOther.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dist = r1.howFar(r2);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnDistanceToOther, 6, SpringLayout.SOUTH, btnRotate);
		springLayout.putConstraint(SpringLayout.WEST, btnDistanceToOther, 0, SpringLayout.WEST, btnNewButton);
		frame.getContentPane().add(btnDistanceToOther);
				
		txtName = new JTextField();
		txtName.setToolTipText("name (String)");
		springLayout.putConstraint(SpringLayout.WEST, txtName, 115, SpringLayout.EAST, btnCreateNewRobot);
		springLayout.putConstraint(SpringLayout.EAST, txtName, -10, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, txtName, 0, SpringLayout.NORTH, btnCreateNewRobot);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtXPosition = new JTextField();
		txtXPosition.setToolTipText("x position (int)");
		springLayout.putConstraint(SpringLayout.NORTH, txtXPosition, 9, SpringLayout.SOUTH, txtName);
		springLayout.putConstraint(SpringLayout.WEST, txtXPosition, 0, SpringLayout.WEST, txtName);
		springLayout.putConstraint(SpringLayout.EAST, txtXPosition, 0, SpringLayout.EAST, txtName);
		frame.getContentPane().add(txtXPosition);
		txtXPosition.setColumns(10);
		
		txtYPosition = new JTextField();
		txtYPosition.setToolTipText("y position (int)");
		springLayout.putConstraint(SpringLayout.NORTH, txtYPosition, 9, SpringLayout.SOUTH, txtXPosition);
		springLayout.putConstraint(SpringLayout.WEST, txtYPosition, 0, SpringLayout.WEST, txtName);
		springLayout.putConstraint(SpringLayout.EAST, txtYPosition, 0, SpringLayout.EAST, txtName);
		frame.getContentPane().add(txtYPosition);
		txtYPosition.setColumns(10);
		
		txtSpeed = new JTextField();
		txtSpeed.setToolTipText("speed (int)");
		springLayout.putConstraint(SpringLayout.WEST, txtSpeed, 0, SpringLayout.WEST, txtName);
		springLayout.putConstraint(SpringLayout.SOUTH, txtSpeed, -137, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtSpeed, 0, SpringLayout.EAST, txtName);
		frame.getContentPane().add(txtSpeed);
		txtSpeed.setColumns(10);
		
		txtOrientation = new JTextField();
		txtOrientation.setText("N/S/E/W");
		txtOrientation.setToolTipText("orientation (N/S/E/W)");
		springLayout.putConstraint(SpringLayout.NORTH, txtOrientation, 6, SpringLayout.SOUTH, txtSpeed);
		springLayout.putConstraint(SpringLayout.WEST, txtOrientation, 0, SpringLayout.WEST, txtName);
		springLayout.putConstraint(SpringLayout.EAST, txtOrientation, 0, SpringLayout.EAST, txtName);
		frame.getContentPane().add(txtOrientation);
		txtOrientation.setColumns(10);
		
		btnMakeRobot = new JButton("make robot");
		springLayout.putConstraint(SpringLayout.NORTH, btnMakeRobot, 6, SpringLayout.SOUTH, txtOrientation);
		springLayout.putConstraint(SpringLayout.WEST, btnMakeRobot, 0, SpringLayout.WEST, txtName);
		btnMakeRobot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtName.setVisible(false);
				txtXPosition.setVisible(false);
				txtYPosition.setVisible(false);
				txtSpeed.setVisible(false);
				txtOrientation.setVisible(false);
				btnMakeRobot.setVisible(false);

				Robot r = new Robot(txtName.getText(), Integer.parseInt(txtXPosition.getText()), Integer.parseInt(txtYPosition.getText()), Integer.parseInt(txtSpeed.getText()), txtOrientation.getText());
				listModel.add(listModel.size(), r);
			}
		});
		frame.getContentPane().add(btnMakeRobot);
		
		listModel = new DefaultListModel<Robot>();
		
 		list = new JList<>(listModel);
 		//problem in here somewhere
 		
 		list.setSelectedIndices(new int[]{0,1});
 		if (list.getModel().getSize() == 2) {
 			r1 = (Robot) list.getSelectedValuesList().toArray()[0];
 			r2 = (Robot) list.getSelectedValuesList().toArray()[1];
 		}
 		
		springLayout.putConstraint(SpringLayout.NORTH, list, -60, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, list, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, list, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, list, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(list);
		
		JLabel lblNamestring = new JLabel("name");
		springLayout.putConstraint(SpringLayout.NORTH, lblNamestring, 5, SpringLayout.NORTH, btnCreateNewRobot);
		frame.getContentPane().add(lblNamestring);
		
		JLabel lblXposint = new JLabel("xpos (int)");
		springLayout.putConstraint(SpringLayout.WEST, lblNamestring, 0, SpringLayout.WEST, lblXposint);
		springLayout.putConstraint(SpringLayout.NORTH, lblXposint, 5, SpringLayout.NORTH, btnNewButton);
		frame.getContentPane().add(lblXposint);
		
		JLabel lblYposint = new JLabel("ypos (int)");
		springLayout.putConstraint(SpringLayout.WEST, lblXposint, 0, SpringLayout.WEST, lblYposint);
		springLayout.putConstraint(SpringLayout.NORTH, lblYposint, 5, SpringLayout.NORTH, btnRotate);
		frame.getContentPane().add(lblYposint);
		
		JLabel lblSpeedint = new JLabel("speed (int)");
		springLayout.putConstraint(SpringLayout.WEST, lblYposint, 0, SpringLayout.WEST, lblSpeedint);
		springLayout.putConstraint(SpringLayout.NORTH, lblSpeedint, 5, SpringLayout.NORTH, btnDistanceToOther);
		springLayout.putConstraint(SpringLayout.WEST, lblSpeedint, 6, SpringLayout.EAST, btnDistanceToOther);
		frame.getContentPane().add(lblSpeedint);
		
		JLabel lblOrientation = new JLabel("orientation");
		springLayout.putConstraint(SpringLayout.NORTH, lblOrientation, 5, SpringLayout.NORTH, txtOrientation);
		springLayout.putConstraint(SpringLayout.WEST, lblOrientation, 0, SpringLayout.WEST, lblNamestring);
		frame.getContentPane().add(lblOrientation);
		
		txtMove = new JTextField();
		txtMove.setToolTipText("distance to move (int)");
		springLayout.putConstraint(SpringLayout.NORTH, txtMove, 6, SpringLayout.SOUTH, btnCreateNewRobot);
		springLayout.putConstraint(SpringLayout.WEST, txtMove, 6, SpringLayout.EAST, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, txtMove, 184, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(txtMove);
		txtMove.setColumns(10);
		
		lblDistance = new JLabel(Double.toString(dist));
		springLayout.putConstraint(SpringLayout.NORTH, lblDistance, 6, SpringLayout.SOUTH, btnDistanceToOther);
		springLayout.putConstraint(SpringLayout.WEST, lblDistance, 69, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblDistance);
		
		txtName.setVisible(false);
		txtXPosition.setVisible(false);
		txtYPosition.setVisible(false);
		txtSpeed.setVisible(false);
		txtOrientation.setVisible(false);
		btnMakeRobot.setVisible(false);

	}
}
