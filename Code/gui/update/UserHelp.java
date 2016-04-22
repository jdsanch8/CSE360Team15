
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * GUI to view help from menu
 * @author nathan kelly
 * @version 4.13.1100
 */
public class UserHelp {
	
	/**
	 * ...
	 * @author nathan kelly
	 * @version 4.13.1100
	 */
	public static void userHelp() {
			
		Stage help_stg = new Stage();
		
		//============================================================= title_lbl
		Label title_lbl = new Label("help()");
		title_lbl.setFont(Font.font("Cambria", 32));
		
		//============================================================= quit_btn
		Button quit_btn = new Button("Go Back");
		quit_btn.setOnAction(e-> {
//			if (UserConfirm.yesNoConfirm("Go Back?") ) {
				help_stg.close();
//			}
		});
		
		
		//============================================================= layout
		VBox layout = new VBox();
		layout.setSpacing(20);
//		layout.setPadding(new Insets(200, 0, 0, 100));
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().add(title_lbl);
		layout.getChildren().add(quit_btn);
		
		
		Scene intro_scn = new Scene(layout, 600, 600);
		
		
		//============================================================= rankings_stg
		help_stg.initModality(Modality.APPLICATION_MODAL);
		help_stg.setTitle("Rankings");
		help_stg.setOnCloseRequest(e-> {
			e.consume();
//			if (UserConfirm.yesNoConfirm("Are you done viewing rankings?") ) {
				help_stg.close();
//			}
		});
		help_stg.setMinHeight(600);
		help_stg.setMaxHeight(600);
		help_stg.setMinWidth(600);
		help_stg.setMaxWidth(600);
		help_stg.setScene(intro_scn);
		help_stg.show();
			
	}
	
}



