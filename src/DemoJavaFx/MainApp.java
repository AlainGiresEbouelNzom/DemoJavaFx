package DemoJavaFx;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application
{

	

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		VBox root = new VBox(30);
		Label label =  new Label("Hello world");
		TextField textField1 =  new TextField("text field 1");
		TextField textField2 =  new TextField("text field 2");
		
		root. getChildren().addAll(label, textField1, textField2);
		root.setPadding(new Insets(10));
		
		
		/*Binding unidirctionnel*/
		label.textProperty().bind(textField1.textProperty());
//		textField1.textProperty().bind(textField2.textProperty());
		
		/*Binding bidirectionnel(1ere méthode)*/
//		textField1.textProperty().bindBidirectional(textField2.textProperty() );
		
		/*Binding bidirectionnel (2e méthode)*/
		Bindings.bindBidirectional(textField1.textProperty(), textField2.textProperty());
		
		
		Scene scene = new Scene(root, 300, 200 );
		
		
		primaryStage.setTitle("Demo JavaFx");		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.centerOnScreen();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

}
