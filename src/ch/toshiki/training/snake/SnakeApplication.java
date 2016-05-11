package ch.toshiki.training.snake;

import javafx.application.Application;
import javafx.stage.Stage;

public class SnakeApplication extends Application {

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		StageSceneLoader.loadScene(stage, "start/StartView.fxml");
		stage.setTitle("Snake");
		stage.show();
	}

}
