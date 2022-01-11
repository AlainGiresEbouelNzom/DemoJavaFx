package DemoJavaFx;

import java.util.concurrent.Callable;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainApp extends Application
{
	private Button addGirlFriend;
	private Button removeGirlFriend;
	private int girlFriendCount = 3;
	private Label label;
	

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		VBox root = new VBox(30);
		
		
		/*Background*/
		root.setBackground(new Background( new BackgroundFill(Color.web("#91cad8"), null, null)));
		
		/*création d'une police de caractére(Font)*/
		Font MyFont = new Font("Caveat", 16);
		
		root.setAlignment(Pos.CENTER);
		//root.setMargin(label, new Insets(24));
		
		root.setPadding(new Insets(25));
		
		label =  new Label("initial Number of gilrfriends : " + girlFriendCount);
		
		/*utilisation d'une police avec la classe Font*/
		label.setFont(Font.font("Lobster", 16));
		
		
		TextField textField1 =  new TextField("text field 1");
		TextField textField2 =  new TextField("text field 2");
		
		IntegerBinding integerBinding = Bindings.createIntegerBinding(new Callable<Integer>()
		{			
			@Override
			public Integer call() throws Exception
			{
				int value1 = textField1.getText().trim().isEmpty() ? 0 : Integer.parseInt(textField1.getText());
				int value2;
				
				if(textField2.getText().trim().isEmpty())
					value2 = 0;
				else
					value2 = Integer.parseInt(textField2.getText());
				
				return value1 + value2;
			}
		}, textField1.textProperty(), textField2.textProperty());
		
		label.textProperty().bind(integerBinding.asString());
		
		
		HBox root2 = new HBox(20);
		
		/*Alignement d'un élément (Centrer)*/
		root2.setAlignment(Pos.CENTER);
		
		addGirlFriend =  new Button("Add girlfriend");
		removeGirlFriend =  new Button("Remove girlfriend");
		
		root. getChildren().addAll(label, textField1, textField2,  root2);
		root2.getChildren().addAll(addGirlFriend, removeGirlFriend);
		
		/*Utilisation d'une police personnalisée*/
		addGirlFriend.setFont(MyFont);
		removeGirlFriend.setFont(MyFont);
		
		/*Couleur des bouttons*/
		addGirlFriend.setBackground(new Background(new BackgroundFill(Color.web("#e43737"), null, null)));
		removeGirlFriend.setBackground(new Background(new BackgroundFill(Color.web("#e43737"), null, null)));
				
		
		
		
		/*Binding unidirctionnel*/
		//label.textProperty().bind(textField1.textProperty());
//		textField1.textProperty().bind(textField2.textProperty());
		
		/*Binding bidirectionnel(1ere méthode)*/
//		textField1.textProperty().bindBidirectional(textField2.textProperty() );
		
		/*Binding bidirectionnel (2e méthode)*/
//		Bindings.bindBidirectional(textField1.textProperty(), textField2.textProperty());
		
		addGirlFriend.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent arg0)
			{
				girlFriendCount++;	
				setGirlfriend();				
			}
		});;
		
		removeGirlFriend.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent arg0)
			{
				if(girlFriendCount > 0)
				{	
					girlFriendCount--;	
					setGirlfriend();
				}
								
			}
		});;
		
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Demo JavaFx");		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.centerOnScreen();
	}
	
	private void setGirlfriend()
	{
		label.setText(" Number of gilrfriends : " + girlFriendCount);
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

}
