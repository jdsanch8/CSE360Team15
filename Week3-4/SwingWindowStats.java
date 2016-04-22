import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



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

		
		
		frame1 = new JFrame("Player Statistics");
		frame1.setBounds(100, 100, 600, 500);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_2 = new JPanel();
		frame1.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Go Back to Main Menu");
		panel_2.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		JPanel panel = new JPanel();
		frame1.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("      Player Name                       Victory   Days   Buildings   Resources       ");
		panel.add(lblNewLabel);
		

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
