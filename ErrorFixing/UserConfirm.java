
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;

/**
 * GUI user confirmation prompt
 * @author nathan kelly
 * @version 4.27.2347
 */
public class UserConfirm {

	static boolean confirm = false; //to return on user confirm

	/**
	 * prompts user with a yes/no question and returns true or false from user
	 * @param message - yes/no prompt
	 * @return confirm - user response
	 * @author nathan kelly
	 * @version 4.27.2330
	 */
	public static boolean yesNoConfirm(String message) {

		//============================================================= confirm_stg
		Stage confirm_stg = new Stage();
		confirm_stg.initModality(Modality.APPLICATION_MODAL);
		confirm_stg.setTitle("Confirm Choice");
		confirm_stg.setMinWidth(250);
		confirm_stg.setMinHeight(250);

		//============================================================= message_lbl
		Label message_lbl = new Label();
		message_lbl.setText(message);

		//============================================================= yes_btn
		Button yes_btn = new Button("Yes");
		yes_btn.setOnAction(e -> {
			confirm = true;
			confirm_stg.close();
		});
		
		yes_btn.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				if (e.getCode() == KeyCode.ENTER) {
					confirm = true;
					confirm_stg.close();
				}
			}
		});

		//============================================================= no_btn
		Button no_btn = new Button("No");
		no_btn.setOnAction(e -> {
			confirm = false;
			confirm_stg.close();
		});
		
		no_btn.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				if (e.getCode() == KeyCode.ENTER) {
					confirm = false;
					confirm_stg.close();
				}
			}
		});

		//============================================================= menu_vbx
		VBox menu_vbx = new VBox();
		menu_vbx.setSpacing(20);
		menu_vbx.getChildren().addAll(message_lbl, yes_btn, no_btn);
		menu_vbx.setAlignment(Pos.CENTER);

		//============================================================= scene
		Scene scene = new Scene(menu_vbx);
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				if (e.getCode() == KeyCode.ESCAPE) {
					confirm = false;
					confirm_stg.close();
				}
			}
		});



		confirm_stg.setScene(scene);
		confirm_stg.showAndWait();

		return confirm;

	}

	public static boolean locConfirm(String message) {

			//============================================================= confirm_stg
			Stage confirm_stg = new Stage();
			confirm_stg.initModality(Modality.APPLICATION_MODAL);
			confirm_stg.setTitle("Confirm Choice");
			confirm_stg.setMinWidth(250);
			confirm_stg.setMinHeight(250);

			//============================================================= message_lbl
			Label message_lbl = new Label();
			message_lbl.setText(message);

			//============================================================= yes_btn
			Button yes_btn = new Button("Forest");
			yes_btn.setOnAction(e -> {
				confirm = true;
				confirm_stg.close();
			});

			//============================================================= no_btn
			Button no_btn = new Button("Mountain");
			no_btn.setOnAction(e -> {
				confirm = false;
				confirm_stg.close();
			});

			//============================================================= menu_vbx
			VBox menu_vbx = new VBox();
			menu_vbx.setSpacing(20);
			menu_vbx.getChildren().addAll(message_lbl, yes_btn, no_btn);
			menu_vbx.setAlignment(Pos.CENTER);

			//============================================================= scene
			Scene scene = new Scene(menu_vbx);
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent e) {
					if (e.getCode() == KeyCode.ENTER) {
						confirm = true;
						confirm_stg.close();
					}
					else if (e.getCode() == KeyCode.ESCAPE) {
						confirm = false;
						confirm_stg.close();
					}
				}
			});



			confirm_stg.setScene(scene);
			confirm_stg.showAndWait();

			return confirm;

	}


}



