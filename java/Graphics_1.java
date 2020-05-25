import javafx.application.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.scene.media.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.geometry.*;
import java.io.File;

public class Graphics_1 extends Application
{
	VBox vbox2;
	ToggleButton musc,cate;
	Button buttons[];
	Button back;
	Label difficulty,muscles_cate;
	ComboBox<String> d_combobox;
	ComboBox<String> multi_box;
	String d_combo_val;
	String e_type;
	Stage window;
	Text prog_text[];
	private String button_clicked;
	Image image;
	ImageView view;
	public static void main(String[] args)
	{
		launch(args);
	}
	public void start(Stage primaryStage) throws Exception
	{
		window = primaryStage;
		window.initStyle(StageStyle.UTILITY);
		window.setTitle("Calisthenics");
		VBox vbox = new VBox(20);
		VBox vbox1 = new VBox(5);
		vbox2 = new VBox(20);
		vbox.setAlignment(Pos.TOP_CENTER);
		vbox1.setAlignment(Pos.TOP_CENTER);
		Scene scene = new Scene(vbox, 700, 600);
		Scene scene1 = new Scene(vbox2,800,700);
		prog_text = new Text[3];
		view = new ImageView();
        for(int i=0;i<3;i++)
        {
        	prog_text[i] = new Text();
        	prog_text[i].setFont(new Font(13));
        	prog_text[i].setWrappingWidth(200);
			prog_text[i].setTextAlignment(TextAlignment.JUSTIFY);
        }

		difficulty = new Label("Filter by Difficulty");
		muscles_cate = new Label("Filter by");
		d_combobox = new ComboBox<String>();
		multi_box = new ComboBox<String>();
		ToggleGroup group = new ToggleGroup();
		ToggleGroup group2 = new ToggleGroup();
		back = new Button("back");
		// musc = new ToggleButton("Muscles");
		cate = new ToggleButton("Categories");
		buttons = new Button[4];
		for(int i=0;i<4;i++)
		{
			buttons[i] = new Button();
			buttons[i].setMinWidth(700);
		}

		// musc.setToggleGroup(group);
		cate.setToggleGroup(group);

		vbox.getChildren().add(difficulty);
		d_combobox.setPromptText("Select Difficulty");
		d_combobox.getItems().addAll(new String("Beginner"),
			new String("Intermediate"),new String("Advanced"));
		d_combobox.getSelectionModel().selectedItemProperty().addListener((v,oldvalue,newvalue)->{
			vbox.getChildren().remove(vbox1);
			d_combo_val = newvalue;
		});
		// musc.setOnAction( e-> {
		// 	multi_box.getItems().clear();
		// 	multi_box.setPromptText("Select Filter");
  //   		multi_box.getItems().addAll(new String("Deltoid"),
		// 	new String("Back"),new String("Pecs"),new String("Tricep")
		// 	,new String("Biceps"));
		// });
		cate.setOnAction(e -> {
			multi_box.getItems().clear();
			multi_box.setPromptText("Select Filter");
    		multi_box.getItems().addAll(new String("Pushup"),new String("Pullup"),
			new String("Dips"),new String("Advanced exercises"));
		});
		multi_box.getSelectionModel().selectedItemProperty().addListener((v,oldvalue,newvalue)->{
			vbox1.getChildren().clear();
			vbox.getChildren().remove(vbox1);
			e_type = newvalue;
			prog_text[0].setText("Beginner:         3x5 reps");
			prog_text[1].setText("Intermediate:         3x10 reps");
			prog_text[2].setText("Advanced:         3x15 reps");
			if(d_combo_val.equals("Beginner")&&newvalue.equals("Pushup"))
			{
				buttons[0].setText("Knee push ups");
				buttons[1].setText("Elevated push ups");
				vbox1.getChildren().addAll(buttons[0],buttons[1]);
				vbox.getChildren().addAll(vbox1);
			}
			if(d_combo_val.equals("Beginner")&&newvalue.equals("Pullup"))
			{
				buttons[0].setText("Body row");
				buttons[1].setText("Assisted pull ups");
				vbox1.getChildren().addAll(buttons[0],buttons[1]);
				vbox.getChildren().addAll(vbox1);
			}
			if(d_combo_val.equals("Beginner")&&newvalue.equals("Dips"))
			{
				buttons[0].setText("Assisted Dips");
				buttons[1].setText("Chair Dip");
				vbox1.getChildren().addAll(buttons[0],buttons[1]);
				vbox.getChildren().addAll(vbox1);
			}
			if(d_combo_val.equals("Intermediate")&&newvalue.equals("Pushup"))
			{
				buttons[0].setText("Full push up");
				buttons[1].setText("Diamond push up");
				vbox1.getChildren().addAll(buttons[0],buttons[1]);
				vbox.getChildren().addAll(vbox1);
			}
			if(d_combo_val.equals("Intermediate")&&newvalue.equals("Pullup"))
			{
				buttons[0].setText("Full pull up");
				buttons[1].setText("Slow pull up");
				vbox1.getChildren().addAll(buttons[0],buttons[1]);
				vbox.getChildren().addAll(vbox1);
			}
			if(d_combo_val.equals("Intermediate")&&newvalue.equals("Dips"))
			{
				buttons[0].setText("Normal dips");
				buttons[1].setText("Low dips");
				vbox1.getChildren().addAll(buttons[0],buttons[1]);
				vbox.getChildren().addAll(vbox1);
			}
			if(d_combo_val.equals("Advanced")&&newvalue.equals("Pushup"))
			{
				buttons[0].setText("Explosive push up");
				buttons[1].setText("One arm push up");
				vbox1.getChildren().addAll(buttons[0],buttons[1]);
				vbox.getChildren().addAll(vbox1);
			}
			if(d_combo_val.equals("Advanced")&&newvalue.equals("Pullup"))
			{
				buttons[0].setText("Explosive pull up");
				buttons[1].setText("One arm pull up");
				vbox1.getChildren().addAll(buttons[0],buttons[1]);
				vbox.getChildren().addAll(vbox1);
			}
			if(d_combo_val.equals("Advanced")&&newvalue.equals("Dips"))
			{
				buttons[0].setText("Korean dips");
				buttons[1].setText("Ring dips");
				buttons[2].setText("RTO dips");
				vbox1.getChildren().addAll(buttons[0],buttons[1],buttons[2]);
				vbox.getChildren().addAll(vbox1);
			}
			if(newvalue.equals("Advanced exercises"))
			{
				buttons[0].setText("Muscle up");
				buttons[1].setText("Planche");
				buttons[2].setText("Human Flag");
				buttons[3].setText("L-sit");
				vbox1.getChildren().addAll(buttons[0],buttons[1],buttons[2],buttons[3]);
				vbox.getChildren().addAll(vbox1);
			}
			for(int i=0;i<4;i++)
			{
				final String buttonid=buttons[i].getText();
				buttons[i].setOnAction(e->{
					if(!buttonid.equals(""))
					{
						button_clicked = buttonid;
						if(button_clicked.equals("Planche")||button_clicked.equals("L-sit"))
						{
							prog_text[0].setText("Beginner:         1x5s");
							prog_text[1].setText("Intermediate:         2x10s");
							prog_text[2].setText("Advanced:         3x15s");
						}
						this.second_scene(window,scene,scene1);
					}
				});
			}
		});
		
		HBox hbox = new HBox(20);
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(muscles_cate,/*musc,*/cate);

		vbox.getChildren().add(d_combobox);
		vbox.getChildren().add(hbox);
		vbox.getChildren().add(multi_box);


		window.setScene(scene);
		scene.getStylesheets().add(Graphics_1.class.getResource("calisthenics.css").toExternalForm());
		window.show();
	}
	private void second_scene(Stage window,Scene scene, Scene scene1)
	{
		System.out.println(button_clicked);
		if(button_clicked.equals("Muscle up"))
		{
			image = new Image("/muscle-up.gif");
			view.setImage(image);
		}
		else if(button_clicked.equals("L-sit"))
		{
			image = new Image("https://thumbs.gfycat.com/AncientFeminineCurlew-size_restricted.gif");
			view.setImage(image);
		}
		view.setFitWidth(300);
        view.setPreserveRatio(true);
        view.setSmooth(true);
        view.setCache(true);


        vbox2.setAlignment(Pos.TOP_CENTER);

        Label label = new Label();
        label.setText(button_clicked);
        label.setFont(new Font(20));

        vbox2.getChildren().add(label);
        vbox2.getChildren().add(new Label("Progression"));
        vbox2.getChildren().add(prog_text[0]);
        vbox2.getChildren().add(prog_text[1]);
        vbox2.getChildren().add(prog_text[2]);
        vbox2.getChildren().add(view);
		vbox2.getChildren().add(back);
		back.setOnAction(e->{
			vbox2.getChildren().clear();
			window.setScene(scene);
			window.show();
		});
		window.setScene(scene1);
		window.show();
	}
}