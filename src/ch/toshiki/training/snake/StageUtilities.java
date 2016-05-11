package ch.toshiki.training.snake;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class StageUtilities {

	public static void closeStage(Node node) {
		Scene scene = node.getScene();
		Window window = scene.getWindow();
		Stage stage = (Stage) window;
		stage.close();
	}

}
