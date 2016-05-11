package ch.toshiki.training.snake.game;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameStage extends Stage {

	public GameStage() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("GameView.fxml"));

		Scene scene = new Scene(root);
		setTitle("Snake");
		setScene(scene);
		show();

	}
}
