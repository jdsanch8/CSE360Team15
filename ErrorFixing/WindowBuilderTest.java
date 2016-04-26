//package gui;

//import java.awt.BorderLayout;
//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;


//import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


//import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
//import javax.swing.Action;
import javax.swing.JTextField;
//import java.awt.GridBagLayout;
//import java.awt.GridBagConstraints;
//import java.awt.Insets;
//import java.awt.GridLayout;
//import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


//import java.awt.Choice;
//import javax.swing.JComboBox;
import javax.swing.JOptionPane;


/**
 * Create the frame. */
@SuppressWarnings("serial")
public class WindowBuilderTest extends JFrame {


	private JPanel contentPane;
	private JTextField txtFood;
	private JTextField txtStone;
	private JTextField txtWood;
	private JTextField txtDays;
	private JTextField txtTmp;
	private JTextField txtTmp_1;
	private JTextField txtMine;
	private JTextField txtMill;


	public void setMult(String in){
		txtTmp.setText(in);
	}

	public void setEvent(String in){
		txtTmp_1.setText(in);
	}

	public void setMill(String in){
		txtMill.setText(in);
	}

	public void setMine(String in){
		txtMine.setText(in);
	}

	public WindowBuilderTest(String name) {

		Game engine = new Game(name);
		boolean loc = UserConfirm.locConfirm("Pick your starting location: Forest gives wood; Mountains gives stone.");
		if(loc)
			engine.setWood(5);
		else
			engine.setStone(5);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Roll Dice");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int mult = engine.rollMult();
				txtTmp.setText("\nYou've rolled " + mult);
				txtTmp_1.setText(engine.rollEvent(mult));
				txtMill.setText(engine.rollMill(mult));
				txtMine.setText(engine.rollMine(mult));


				txtFood.setText("Food: " + engine.getFood());
				txtStone.setText("Stone: " + engine.getStone()) ;
				txtWood.setText("Wood: " + engine.getWood());
				txtDays.setText("Days: " + engine.getDays());

				if(engine.getFood() <= 0){
					JOptionPane.showMessageDialog(null, "You have starved to death and lost!");
					engine.endGame();
					dispose();
				}

			}
		});

		JButton btnBuildHouse = new JButton("Build House");
		btnBuildHouse.setToolTipText("Wood: 5\tStone: 5");
		btnBuildHouse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!engine.buildHouse())
					txtTmp.setText("Not Enough Resources!");
				else
					btnBuildHouse.setVisible(false);
				txtFood.setText("Food: " + engine.getFood());
				txtStone.setText("Stone: " + engine.getStone()) ;
				txtWood.setText("Wood: " + engine.getWood());
				txtDays.setText("Days: " + engine.getDays());
			}
		});

		JButton btnBuildFence = new JButton("Build Fence");
		btnBuildFence.setToolTipText("Wood: 5\tStone: 2");
		btnBuildFence.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!engine.buildFence())
					txtTmp.setText("Not Enough Resources!");
				else
					btnBuildFence.setVisible(false);
				txtFood.setText("Food: " + engine.getFood());
				txtStone.setText("Stone: " + engine.getStone()) ;
				txtWood.setText("Wood: " + engine.getWood());
				txtDays.setText("Days: " + engine.getDays());
			}
		});

		JButton btnBuildFarm = new JButton("Build Farm");
		btnBuildFarm.setToolTipText("Food: 3\tWood: 3\tStone: 3");
		btnBuildFarm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!engine.buildFarm()){
					if (engine.requiredBuildingsStatus() != ""){
						txtTmp.setText("The following buildings are required before building a farm: " + engine.requiredBuildingsStatus());
					}
					else{
						txtTmp.setText("Not Enough Resources!");
					}
				}
				else{
					btnBuildFarm.setVisible(false);
					JOptionPane.showMessageDialog(null, "You have won!");
					dispose();
				}
				txtFood.setText("Food: " + engine.getFood());
				txtStone.setText("Stone: " + engine.getStone()) ;
				txtWood.setText("Wood: " + engine.getWood());
				txtDays.setText("Days: " + engine.getDays());

			}
		});

		JButton btnNewButton_1 = new JButton("Build Well");
		btnNewButton_1.setToolTipText("Wood: 2\tStone: 5");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!engine.buildWell())
					txtTmp.setText("Not Enough Resources!");
				else
					btnNewButton_1.setVisible(false);
				txtFood.setText("Food: " + engine.getFood());
				txtStone.setText("Stone: " + engine.getStone()) ;
				txtWood.setText("Wood: " + engine.getWood());
				txtDays.setText("Days: " + engine.getDays());
			}
		});

		JButton btnBuildMine = new JButton("Build Mine");
		btnBuildMine.setToolTipText("Wood: 5");
		btnBuildMine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!engine.buildMine())
					txtTmp.setText("Not Enough Resources!");
				else
					btnBuildMine.setVisible(false);
				txtFood.setText("Food: " + engine.getFood());
				txtStone.setText("Stone: " + engine.getStone()) ;
				txtWood.setText("Wood: " + engine.getWood());
				txtDays.setText("Days: " + engine.getDays());
			}
		});

		JButton btnBuildMill = new JButton("Build Mill");
		btnBuildMill.setToolTipText("Stone: 5");
		btnBuildMill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!engine.buildMill())
					txtTmp.setText("Not Enough Resources!");
				else
					btnBuildMill.setVisible(false);
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

		txtTmp = new JTextField();
		txtTmp.setText("");
		txtTmp.setColumns(10);

		txtTmp_1 = new JTextField();
		txtTmp_1.setText("");
		txtTmp_1.setColumns(10);

		txtMine = new JTextField();
		txtMine.setText("");
		txtMine.setColumns(10);

		txtMill = new JTextField();
		txtMill.setText("");
		txtMill.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtMill, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
								.addComponent(txtMine, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
								.addGap(184))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(txtTmp_1)
												.addComponent(txtTmp)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(txtFood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(txtStone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(txtWood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(txtDays, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
														.addContainerGap(193, Short.MAX_VALUE))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(btnBuildMine)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnBuildMill)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnBuildFence)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnNewButton_1)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnBuildHouse)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(btnBuildFarm)
																.addContainerGap(59, Short.MAX_VALUE))
																.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
																		.addContainerGap(230, Short.MAX_VALUE)
																		.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
																		.addGap(217))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtFood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtStone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtWood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDays, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(12)
								.addComponent(txtTmp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtTmp_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtMine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(txtMill, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(130)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnBuildMine)
										.addComponent(btnBuildMill)
										.addComponent(btnBuildFence)
										.addComponent(btnNewButton_1)
										.addComponent(btnBuildHouse)
										.addComponent(btnBuildFarm))
										.addGap(58))
				);
		contentPane.setLayout(gl_contentPane);
	}

	@SuppressWarnings("unused")
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}