package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("WhatsApp Web");

        // Lista de chats a la izquierda
        ListView<Chat> chatList = new ListView<>();
        chatList.getItems().addAll(
                new Chat("Chat 1", new Image("file:C:/Users/Braddy/Downloads/imagen1.jpg")),
                new Chat("Chat 2", new Image("file:C:/Users/Braddy/Downloads/imagen1.jpg")),
                new Chat("Chat 3", new Image("file:C:/Users/Braddy/Downloads/imagen1.jpg")),
                new Chat("Chat 4", new Image("file:C:/Users/Braddy/Downloads/imagen1.jpg")),
                new Chat("Chat 5", new Image("file:C:/Users/Braddy/Downloads/imagen1.jpg"))
        );

        // Configurar para mostrar imagen y nombre del chat
        chatList.setCellFactory(param -> new ListCell<>() {
            private final ImageView imageView = new ImageView();

            @Override
            protected void updateItem(Chat item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    imageView.setImage(item.getImage());
                    imageView.setFitWidth(50);
                    imageView.setFitHeight(50);
                    setText(item.getName());
                    setGraphic(imageView);
                }
            }
        });

        // Lista de mensajes
        ListView<String> messageList = new ListView<>();
        messageList.setItems(FXCollections.observableArrayList(
                "Mensaje 1", "Mensaje 2", "Mensaje 3", "Mensaje 4", "Mensaje 5"
        ));

        // Área para escribir mensajes
        TextField inputField = new TextField();
        inputField.setPromptText("Escribe un mensaje...");

        // Contenedor principal
        BorderPane root = new BorderPane();
        root.setLeft(chatList);

        VBox centerBox = new VBox();
        centerBox.getChildren().addAll(messageList, inputField);
        root.setCenter(centerBox);

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class Chat {
        private final String name;
        private final Image image;

        public Chat(String name, Image image) {
            this.name = name;
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public Image getImage() {
            return image;
        }
    }
}
