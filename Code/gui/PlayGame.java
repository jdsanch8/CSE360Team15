
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * GUI to host gameplay elements
 * @author nathan kelly
 * @version 4.11.1400
 */
public class PlayGame {
	
	/**
	 * ...
	 * @author nathan kelly
	 * @version 4.11.1400
	 */
	public static void playGame() {
			
		Stage playGame_stg = new Stage();
		
		//============================================================= title_lbl
		Label title_lbl = new Label("playGame()");
		title_lbl.setFont(Font.font("Cambria", 32));
		
		//============================================================= quit_btn
		Button quit_btn = new Button("Quit");
		quit_btn.setOnAction(e-> {
			if (UserConfirm.yesNoConfirm("[temp] go back?") ) {
				playGame_stg.close();
			}
		});
		
		//============================================================= menu_vbx
		VBox menu_vbx = new VBox();
		menu_vbx.setSpacing(20);
//		layout.setPadding(new Insets(200, 0, 0, 100));
		menu_vbx.setAlignment(Pos.CENTER);
		menu_vbx.getChildren().add(title_lbl);
		menu_vbx.getChildren().add(quit_btn);

		Scene intro_scn = new Scene(menu_vbx, 600, 600);
		
		//============================================================= rankings_stg
		playGame_stg.initModality(Modality.APPLICATION_MODAL);
		playGame_stg.setTitle("DiceGame15");
		playGame_stg.setMinHeight(600);
		playGame_stg.setMaxHeight(600);
		playGame_stg.setMinWidth(600);
		playGame_stg.setMaxWidth(600);
		playGame_stg.setScene(intro_scn);
		playGame_stg.show();
			
	}
	
}




