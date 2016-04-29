import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToolBar;

/**
 * 
 * @author gregbenj
 *
 */

@SuppressWarnings("serial")
public class StatsPopUp extends JDialog {

	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the stats popup window
	 */
	public static void main(String[] args) {
		try {
			StatsPopUp dialog = new StatsPopUp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StatsPopUp() {
		
		Statistics statGUI = new Statistics("NULL");
		
		setBounds(100, 100, 600, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			JTextArea textArea = new JTextArea();
			textArea.setFont(new Font("Monospaced", textArea.getFont().getStyle(), 12));
			textArea.setEditable(false);
			statGUI.viewStatsInGUI(textArea);
			scrollPane.setViewportView(textArea);
			{
				JToolBar toolBar = new JToolBar();
				scrollPane.setColumnHeaderView(toolBar);
				{
					JLabel lblNewLabel_2 = new JLabel("      ");
					toolBar.add(lblNewLabel_2);
				}
				{
					JLabel lblNewLabel = new JLabel("Player Name");
					toolBar.add(lblNewLabel);
				}
				{
					JLabel lblNewLabel_3 = new JLabel("                       ");
					toolBar.add(lblNewLabel_3);
				}
				{
					JLabel lblVictory = new JLabel("Victory");
					toolBar.add(lblVictory);
				}
				{
					JLabel lblNewLabel_4 = new JLabel("   ");
					toolBar.add(lblNewLabel_4);
				}
				{
					JLabel lblDays = new JLabel("Days");
					toolBar.add(lblDays);
				}
				{
					JLabel lblNewLabel_5 = new JLabel("   ");
					toolBar.add(lblNewLabel_5);
				}
				{
					JLabel lblNewLabel_6 = new JLabel("Buildings");
					toolBar.add(lblNewLabel_6);
				}
				{
					JLabel label = new JLabel("   ");
					toolBar.add(label);
				}
				{
					JLabel lblResources = new JLabel("Resources");
					toolBar.add(lblResources);
				}
				{
					JLabel lblNewLabel_1 = new JLabel("");
					toolBar.add(lblNewLabel_1);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);	
			}
		}
	}
}
