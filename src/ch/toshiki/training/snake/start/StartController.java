package ch.toshiki.training.snake.start;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ch.toshiki.training.snake.StageSceneLoader;
import ch.toshiki.training.snake.StageUtilities;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartController implements Initializable {

	@FXML
	private Button exitButton;

	public void start() throws IOException {
		Stage stage = new Stage();
		StageSceneLoader.loadScene(stage, "game/GameView.fxml");
		stage.setTitle("Snake");
		stage.show();
	}

	public void exit() {
		// TODO implementation exit
		System.out.println("exit the game");
		StageUtilities.closeStage(exitButton);

	}

	public void about() {
		// TODO implementation about
		System.out.println("about the game");

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
