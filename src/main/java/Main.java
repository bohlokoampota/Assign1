import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ImageGalleryApp imageGalleryApp = new ImageGalleryApp();
        Scene scene = new Scene(imageGalleryApp.createContent().getParent(), 800, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setTitle("Image Gallery");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);}
}
