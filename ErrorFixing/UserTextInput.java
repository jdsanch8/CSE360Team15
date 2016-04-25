
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;

/**
 * GUI user text input pop up
 * @author nathan kelly
 * @version 4.22.1131
 */
public class UserTextInput {
	
	static String userResponse = ""; //to return on user confirm
	
	/**
	 * prompts user with a question and returns String with response
	 * @param message - yes/no prompt
	 * @return confirm - user response
	 * @author nathan kelly
	 * @version 4.11.1400
	 */
	public static String userTextInput(String message) {
				
		//============================================================= confirm_stg
		Stage userTextInput_stg = new Stage();
		userTextInput_stg.initModality(Modality.APPLICATION_MODAL);
		userTextInput_stg.setTitle("User Entry");
		userTextInput_stg.setMinWidth(250);
		userTextInput_stg.setMinHeight(250);
		
		//============================================================= message_lbl
		Label message_lbl = new Label();
		message_lbl.setText(message);
		
		//============================================================= userInput_txt
		TextField userInput_txt = new TextField();
		userInput_txt.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				if (e.getCode() == KeyCode.ENTER) {
					userResponse = userInput_txt.getText();
					if(userResponse.compareTo("") != 0) {
						userTextInput_stg.close();
					}
				}
				
			}
			
		});
	
		//============================================================= yes_btn
		Button enter_btn = new Button("Enter");
		enter_btn.setOnAction(e -> {
			userResponse = userInput_txt.getText();
			if(userResponse.compareTo("") != 0) {
				userTextInput_stg.close();
			}
		});
		
		//============================================================= no_btn
		Button cancel_btn = new Button("Cancel");
		cancel_btn.setOnAction(e -> {
			userResponse = "";
			userTextInput_stg.close();
		});
		
		//============================================================= menu_vbx
		VBox menu_vbx = new VBox();
		menu_vbx.setSpacing(20);
		menu_vbx.getChildren().addAll(message_lbl, userInput_txt, enter_btn, cancel_btn);
		menu_vbx.setAlignment(Pos.CENTER);
		
		//============================================================= textIn_vbx
		Scene textIn_scn = new Scene(menu_vbx);
		textIn_scn.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				if (e.getCode() == KeyCode.ESCAPE) {
					userTextInput_stg.close();
				}
			}
		});
		
		
		
		userTextInput_stg.setScene(textIn_scn);
		userTextInput_stg.showAndWait();
	
		return userResponse;
		
	}

	
}



