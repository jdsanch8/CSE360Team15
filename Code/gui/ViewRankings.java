
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * GUI to view game rankings
 * @author nathan kelly
 * @version 4.11.1400
 */
public class ViewRankings {
	
	/**
	 * ...
	 * @author nathan kelly
	 * @version 4.11.1400
	 */
	public static void viewRankings() {
			
		Stage rankings_stg = new Stage();
		
		//============================================================= title_lbl
		Label title_lbl = new Label("viewRankings()");
		title_lbl.setFont(Font.font("Cambria", 32));
		
		//============================================================= quit_btn
		Button quit_btn = new Button("Quit");
		quit_btn.setOnAction(e-> {
			if (UserConfirm.yesNoConfirm("Are you done viewing rankings?") ) {
				rankings_stg.close();
			}
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
		rankings_stg.initModality(Modality.APPLICATION_MODAL);
		rankings_stg.setTitle("Rankings");
		rankings_stg.setOnCloseRequest(e-> {
			e.consume();
			if (UserConfirm.yesNoConfirm("Are you done viewing rankings?") ) {
				rankings_stg.close();
			}
		});
		rankings_stg.setMinHeight(600);
		rankings_stg.setMaxHeight(600);
		rankings_stg.setMinWidth(600);
		rankings_stg.setMaxWidth(600);
		rankings_stg.setScene(intro_scn);
		rankings_stg.show();
			
	}
	
}




