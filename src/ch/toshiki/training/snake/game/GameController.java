package ch.toshiki.training.snake.game;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Predicate;

import ch.toshiki.training.snake.StageUtilities;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class GameController implements Initializable {

	@FXML
	private Button quitButton;
	@FXML
	private Button ruleButton;
	@FXML
	private Rectangle head;
	@FXML
	private Rectangle body;
	@FXML
	private Rectangle body1;
	@FXML
	private GridPane grid;

	private Timer timer;

	public void quitGame() {
		// TODO implementation quit game
		System.out.println("quit Game");
		StageUtilities.closeStage(quitButton);

	}

	private Direction currentDirection = Direction.Up;

	private ArrayList<Rectangle> allBodyParts = new ArrayList<Rectangle>();

	public void getColumn(KeyEvent e) {

		if (e.getCode() == KeyCode.ESCAPE) {
			quitButton.setDisable(false);
			ruleButton.setDisable(false);
			timer.cancel();
		}

		if (e.getCode() == KeyCode.UP) {
			currentDirection = Direction.Up;
		} else if (e.getCode() == KeyCode.LEFT) {
			currentDirection = Direction.Left;
		} else if (e.getCode() == KeyCode.RIGHT) {
			currentDirection = Direction.Right;
		} else if (e.getCode() == KeyCode.DOWN) {
			currentDirection = Direction.Down;
		}
	}

	public void showRules() {
		// TODO implementation rules
		System.out.println("Rules of Game");

	}

	public void startGame() {
		// TODO implementation start game
		System.out.println("start the game");
		allBodyParts.add(body);
		allBodyParts.add(body1);

		// TODO temp
		quitButton.setDisable(true);
		ruleButton.setDisable(true);

		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				int lastBodyRow = grid.getRowIndex(head);
				int lastBodyColumn = grid.getColumnIndex(head);

				int newRow = lastBodyRow;
				int newColumn = lastBodyColumn;

				switch (currentDirection) {
				case Right:
					newColumn++;
					break;
				case Down:
					newRow++;
					break;
				case Left:
					newColumn--;
					break;
				case Up:
					newRow--;
					break;
				default:
					break;
				}

				if (newColumn == -1) {
					newColumn = 29;
				} else if (newColumn == 30) {
					newColumn = 0;
				} else if (newRow == -1) {
					newRow = 20;
				} else if (newRow == 21) {
					newRow = 0;
				}

				// TODO check if touched bodyPart

				Predicate<Rectangle> areAtSamePosition = new Predicate<Rectangle>() {
					@Override
					public boolean test(Rectangle t) {
						int headRow = grid.getRowIndex(head);
						int headColumn = grid.getColumnIndex(head);

						int otherRow = grid.getRowIndex(t);
						int otherColumn = grid.getColumnIndex(t);

						return headRow == otherRow && headColumn == otherColumn;
					}
				};

				if (allBodyParts.stream().anyMatch(areAtSamePosition)) {

					quitButton.setDisable(false);
					ruleButton.setDisable(false);
					timer.cancel();
					return;
				}

				grid.setColumnIndex(head, newColumn);
				grid.setRowIndex(head, newRow);

				for (Rectangle bodyPart : allBodyParts) {
					int temp1 = lastBodyColumn;
					int temp2 = lastBodyRow;

					lastBodyColumn = grid.getColumnIndex(bodyPart);
					lastBodyRow = grid.getRowIndex(bodyPart);

					grid.setColumnIndex(bodyPart, temp1);
					grid.setRowIndex(bodyPart, temp2);
				}
			}
		};

		timer = new Timer();
		timer.scheduleAtFixedRate(task, 0_500, 0_500);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		startGame();
	}
}
