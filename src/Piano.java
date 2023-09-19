
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import application.AppController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Piano extends Application {
    public static void main(String[] args) throws Exception {
        launch();
    }

    @Override
    public void start(Stage stage) {
        try {
            URL url = new File("src/resources/fxmlFiles/pianoFigure.fxml")
                                .toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);

            Parent root = loader.load();
            Scene scene = new Scene(root, 905, 400);

            AppController control = new AppController();
            control.initiate(root);
            loader.setController(control);
            AppController controller = loader.getController();

            scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
                @Override
                public void handle(KeyEvent event) {
                    controller.key = event;
                    controller.t.start();
                }
            });

            stage.setScene(scene);
            stage.setTitle("PIANO");
            Image icon = new Image(new FileInputStream(new File("src/resources/images/icon.png")));
            stage.getIcons().add(icon);
            stage.setResizable(false);
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
