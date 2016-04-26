
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
		Label title_lbl = new Label("Game Objective\n\n"
				+ "The objective of the game is to build a farm. In order to gain the ability to do this,\n"
				+ "you first need to build a house, a well, and a fence. You can build these structures by\n"
				+ "using your resources of, wood and stone, which are acquired through each dice roll. If\n"
				+ "you choose to build the optional structures, mill and mine, you can receive additional\n"
				+ "resources on each dice roll. The mill will provide additional wood and the mine will\n"
				+ "provide additional stone. Additionally, on each dice roll, you consume food and once you\n"
				+ "run out of food the game ends. You can limit your food losses by building a well. A fence\n"
				+ "will limit your resource losses in the event that your roll yields a disaster and a house\n"
				+ "will increase your acquired resources in the event that your roll yields food, wood or stone.\n"
				+ "Let's get building!");
		title_lbl.setFont(Font.font("Cambria", 14));
		
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


