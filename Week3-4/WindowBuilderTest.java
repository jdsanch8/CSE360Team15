import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Choice;
import javax.swing.JComboBox;

/**
 * Create the frame. */
 public class WindowBuilderTest extends JFrame {

	private JPanel contentPane;
	private JTextField txtFood;
	private JTextField txtStone;
	private JTextField txtWood;
	private JTextField txtDays;

	public WindowBuilderTest(String name) {
		Game engine = new Game(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Roll Dice");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				engine.rollDice();
				txtFood.setText("Food: " + engine.getFood());
				txtStone.setText("Stone: " + engine.getStone()) ;
				txtWood.setText("Wood: " + engine.getWood());
				txtDays.setText("Days: " + engine.getDays());
			}
		});

		JButton btnBuildHouse = new JButton("Build House");
		btnBuildHouse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				engine.buildHouse();
				txtFood.setText("Food: " + engine.getFood());
				txtStone.setText("Stone: " + engine.getStone()) ;
				txtWood.setText("Wood: " + engine.getWood());
				txtDays.setText("Days: " + engine.getDays());
			}
		});

		JButton btnBuildFence = new JButton("Build Fence");
		btnBuildFence.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				engine.buildFence();
				txtFood.setText("Food: " + engine.getFood());
				txtStone.setText("Stone: " + engine.getStone()) ;
				txtWood.setText("Wood: " + engine.getWood());
				txtDays.setText("Days: " + engine.getDays());
			}
		});

		JButton btnBuildFarm = new JButton("Build Farm");
		btnBuildFarm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				engine.buildFarm();
				txtFood.setText("Food: " + engine.getFood());
				txtStone.setText("Stone: " + engine.getStone()) ;
				txtWood.setText("Wood: " + engine.getWood());
				txtDays.setText("Days: " + engine.getDays());
			}
		});

		JButton btnNewButton_1 = new JButton("Build Well");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				engine.buildWell();
				txtFood.setText("Food: " + engine.getFood());
				txtStone.setText("Stone: " + engine.getStone()) ;
				txtWood.setText("Wood: " + engine.getWood());
				txtDays.setText("Days: " + engine.getDays());
			}
		});

		JButton btnBuildMine = new JButton("Build Mine");
		btnBuildMine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				engine.buildMine();
				txtFood.setText("Food: " + engine.getFood());
				txtStone.setText("Stone: " + engine.getStone()) ;
				txtWood.setText("Wood: " + engine.getWood());
				txtDays.setText("Days: " + engine.getDays());
			}
		});

		JButton btnBuildMill = new JButton("Build Mill");
		btnBuildMill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				engine.buildMill();
				txtFood.setText("Food: " + engine.getFood());
				txtStone.setText("Stone: " + engine.getStone()) ;
				txtWood.setText("Wood: " + engine.getWood());
				txtDays.setText("Days: " + engine.getDays());
			}
		});

		txtFood = new JTextField();
		txtFood.setText("Food: " + engine.getFood());
		txtFood.setColumns(10);

		txtStone = new JTextField();
		txtStone.setText("Stone: " + engine.getStone()) ;
		txtStone.setColumns(10);

		txtWood = new JTextField();
		txtWood.setText("Wood: " + engine.getWood());
		txtWood.setColumns(10);

		txtDays = new JTextField();
		txtDays.setText("Days: " + engine.getDays());

		txtDays.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(221)
					.addComponent(btnBuildHouse)
					.addContainerGap(274, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(359, Short.MAX_VALUE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnBuildMill)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnBuildFence)
									.addGap(128)
									.addComponent(btnBuildFarm, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
							.addComponent(btnNewButton_1)))
					.addGap(79))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(74)
					.addComponent(btnBuildMine)
					.addContainerGap(429, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(txtFood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtStone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtWood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtDays, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(184, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtStone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtWood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDays, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(95)
							.addComponent(btnBuildHouse)
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBuildFence)
								.addComponent(btnBuildFarm))
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBuildMine)
								.addComponent(btnBuildMill))
							.addGap(49))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addGap(118)))
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		contentPane.setLayout(gl_contentPane);
	}
}