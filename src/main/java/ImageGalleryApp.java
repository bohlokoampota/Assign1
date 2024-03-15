import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ImageGalleryApp {
    private StackPane imagePane;
    private VBox thumbnailPane;

    public Node createContent() {
        imagePane = new StackPane();
        imagePane.getStyleClass().add("image-pane");

        thumbnailPane = new VBox(10);
        thumbnailPane.setAlignment(Pos.CENTER);
        thumbnailPane.setPadding(new Insets(20));

        // Load and add images
        for (int i = 1; i <= 9; i++) {
            Image thumbnail = new Image(getClass().getResourceAsStream("images/thumb" + i + ".jpg"));
            ImageView thumbnailView = new ImageView(thumbnail);
            thumbnailView.setFitWidth(100);
            thumbnailView.setFitHeight(100);
            int finalI = i;
            thumbnailView.setOnMouseClicked(event -> displayFullImage(finalI));
            thumbnailPane.getChildren().add(thumbnailView);
        }

        BorderPane layout = new BorderPane();
        layout.setLeft(thumbnailPane);
        layout.setCenter(imagePane);
        return layout;
    }
    private void displayFullImage(int index) {
        Image fullImage = new Image(getClass().getResourceAsStream("images/image" + index + ".jpg"));
        ImageView fullImageView = new ImageView(fullImage);
        fullImageView.setFitWidth(600);
        fullImageView.setFitHeight(400);
        imagePane.getChildren().clear();
        imagePane.getChildren().add(fullImageView);
        Label backButton = new Label("Back to Thumbnails");
        backButton.getStyleClass().add("back-button");
        backButton.setOnMouseClicked(event -> imagePane.getChildren().setAll(thumbnailPane));
        imagePane.getChildren().add(backButton);
    }
}
