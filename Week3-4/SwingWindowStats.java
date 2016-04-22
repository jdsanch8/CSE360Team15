import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;



public class SwingWindowStats {

	private JFrame frame1;
	protected JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingWindowStats window = new SwingWindowStats();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingWindowStats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame1.
	 */
	private void initialize() {
		
		Statistics statGUI = new Statistics("NULL");
		/*
		JFrame frame0 = new JFrame("Main Menu");
		frame0.setBounds(100, 100, 600, 500);
		frame0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel0 = new JPanel();
		frame0.getContentPane().add(panel0, BorderLayout.NORTH);
		
		JButton btnNewButton0 = new JButton("View Statistics");
		panel0.add(btnNewButton0);
		
		btnNewButton0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		
		*/
		frame1 = new JFrame("Player Statistics");
		frame1.setBounds(100, 100, 600, 500);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame1.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JButton btnNewButton = new JButton("Go Back to Main Menu");
		panel_1.add(btnNewButton);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("  Player Name                           Victory   Days   Buildings   Resources       ");
		panel.add(lblNewJgoodiesLabel);

		JScrollPane scrollPane = new JScrollPane();
		frame1.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", textArea.getFont().getStyle(), 12));
		//textArea.setLineWrap(true);
		textArea.setEditable(false);
		//textArea.setTabSize(2);
		statGUI.viewStatsInGUI(textArea);
		scrollPane.setViewportView(textArea);
		
	}

}
