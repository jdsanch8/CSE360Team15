
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javax.swing.JDialog;

/**
 * main class and launcher for starting GUI
 * @author nathan kelly
 * @version 4.11.1400
 *
 */
public class DiceGame15 extends Application {

	/**
	 * ...?
	 * @param args
	 * @author nathan kelly
	 * @version 4.11.1400
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * GUI for main menu and starting point for app
	 * @param Stage mainMenu_stg - used for main menu
	 * @author nathan kelly
	 * @version 4.22.1138
	 */
	@Override
	public void start(Stage mainMenu_stg) throws Exception {

		//============================================================= title_lbl
		Label title_lbl = new Label("Welcome to DiceGame15");
		title_lbl.setFont(Font.font("Cambria", 32));

		//============================================================= start_btn
		Button newGame_btn = new Button("New Game");
		newGame_btn.setOnAction(e -> {
			String userName = UserTextInput.userTextInput("Enter your name: ");
			WindowBuilderTest frame = new WindowBuilderTest(userName);
			frame.setVisible(true);
		});


		//============================================================= viewRankings_btn
		Button viewRankings_btn = new Button("View Rankings");
		viewRankings_btn.setOnAction(e-> {
			StatsPopUp dialog = new StatsPopUp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		});

		viewRankings_btn.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				if (e.getCode() == KeyCode.ENTER) {
					StatsPopUp dialog = new StatsPopUp();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
			}
		});

		//============================================================= help_btn
		Button help_btn = new Button("Help");
		help_btn.setOnAction(e-> {
			UserHelp.userHelp();
		});

		help_btn.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				if (e.getCode() == KeyCode.ENTER) {
					UserHelp.userHelp();
				}
			}
		});

		//============================================================= quit_btn
		Button quit_btn = new Button("Quit");
		quit_btn.setOnAction(e-> {
			if (UserConfirm.yesNoConfirm("Are you sure you want to quit?") ) {
				mainMenu_stg.close();
			}
		});

		quit_btn.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				if (e.getCode() == KeyCode.ENTER) {
					if (UserConfirm.yesNoConfirm("Are you sure you want to quit?") ) {
						mainMenu_stg.close();
					}
				}
			}
		});

		//============================================================= menu_vbx
		VBox menu_vbx = new VBox();
		menu_vbx.setSpacing(20);
		menu_vbx.setPadding(new Insets(200, 0, 0, 100));
		menu_vbx.getChildren().addAll(title_lbl, newGame_btn, viewRankings_btn, help_btn, quit_btn);

		//============================================================= intro_scn
		Scene intro_scn = new Scene(menu_vbx, 600, 600);
		intro_scn.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				if (e.getCode() == KeyCode.ESCAPE) {
					if (UserConfirm.yesNoConfirm("Are you sure you want to quit?") ) {
						mainMenu_stg.close();
					}
				}
			}
		});

		//============================================================= mainMenu_stg
		mainMenu_stg.setTitle("Main Menu");
		mainMenu_stg.setOnCloseRequest(e -> {
			e.consume();
			if (UserConfirm.yesNoConfirm("Are you sure you want to quit?") ) {
				mainMenu_stg.close();
			}
		});
		mainMenu_stg.setMinHeight(600);
		mainMenu_stg.setMaxHeight(600);
		mainMenu_stg.setMinWidth(600);
		mainMenu_stg.setMaxWidth(600);
		mainMenu_stg.setScene(intro_scn);
		mainMenu_stg.show();

	}

}



