package View;

import Listeners.ViewListenable;
import Model.lecturer;

import Model.lecturer.degreeType;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler;

public class View implements ProgramViewable{
	private ArrayList<ViewListenable> allListeners; 
	private ArrayList<Button> btnsList; 

	private BorderPane bpMain, bpSec,bpTh; 
	private GridPane gridPane;
	private VBox vb;
	private HBox hbMulti, hb; 
	private ScrollPane sp ;
	private ToggleGroup tg;

	private Button 
	btnLecturer,btnUnion, btnCollage, 
	addPLecturer,addOLecturer, addCollage ,editP ,editO ,addLecturertoCollage,deleteLecturer,
	sortByName, sortByID, startTheProgram,sendMessage,Gifts,
	getTheWinners, Done,Send;

	private RadioButton typ1, typ2, typ3,typ4;
	private Label lblProgram, lbl, l1,l2,l3,l4,l5,l6,winners;
	private Stage secondaryStage,ThirdStage; 
	private TextField tf1,tf2,tf3,tf4,tf5;
	int checker = 0;

	public View(Stage primaryStage) {

		allListeners = new ArrayList<ViewListenable>();
		btnsList = new ArrayList<Button>();

		lblProgram = new Label("Program");
		lblProgram.setTextFill(Color.DARKBLUE);
		lblProgram.setFont(new Font("Arial", 30));
		lblProgram.setPadding((new Insets(0, 0, 0, 185)));
		lblProgram.setAlignment(Pos.CENTER); 

		btnLecturer = new Button("Lecturers");						btnLecturer.setPrefSize(300, 50);				btnLecturer.setStyle("-fx-font-size: 1.7em; ");
		btnCollage = new Button("Colleges");						btnCollage.setPrefSize(300, 50);				btnCollage.setStyle("-fx-font-size: 1.7em; ");
		btnUnion = new Button("Union");		                    	btnUnion.setPrefSize(300, 50);		            btnUnion.setStyle("-fx-font-size: 1.7em; ");


		addPLecturer = new Button("Add Lecturer");					addPLecturer.setPrefSize(110, 10);				addPLecturer.setStyle("-fx-font-size: 1em; ");
		addOLecturer = new Button("Add Outsider Lecturer");			addOLecturer.setPrefSize(110, 10);				addOLecturer.setStyle("-fx-font-size: 1em; ");
		addCollage = new Button("Add Collage");						addCollage.setPrefSize(110, 10);				addCollage.setStyle("-fx-font-size: 1em; ");
		editP = new Button("Edit PermanentsUnion");			    	editP.setPrefSize(110, 10);				        editP.setStyle("-fx-font-size: 1em; ");
		editO = new Button("Edit OutSidersUnion");				    editO.setPrefSize(110, 10);			        	editO.setStyle("-fx-font-size: 1em; ");
		sendMessage = new Button("Send message");					sendMessage.setPrefSize(110, 10);				sendMessage.setStyle("-fx-font-size: 1em; ");
		Gifts= new Button("Gifts on holidays");						Gifts.setPrefSize(110, 10);				Gifts.setStyle("-fx-font-size: 1em; ");
		sortByName = new Button("Sort By Name");			     	sortByName.setPrefSize(110, 10);				sortByName.setStyle("-fx-font-size: 1em; ");
		sortByID = new Button("Sort By ID");				    	sortByID.setPrefSize(110, 10);					sortByID.setStyle("-fx-font-size: 1em; ");
		

		getTheWinners = new Button("Which Union is better?");		getTheWinners.setPrefSize(150, 10);		        getTheWinners.setStyle("-fx-font-size: 1em; ");
		startTheProgram = new Button("Start The Program");	        startTheProgram.setPrefSize(150, 10);	    	startTheProgram.setStyle("-fx-font-size: 1em; ");

		btnsList.add(btnLecturer);	btnsList.add(btnCollage); btnsList.add(btnUnion);

		vb = new VBox();	vb.setSpacing(40);	vb.setPadding(new Insets(10));	vb.setAlignment(Pos.CENTER);	vb.getChildren().addAll(btnsList);	
		hb = new HBox();	hb.setAlignment(Pos.CENTER);	hb.getChildren().addAll(getTheWinners,startTheProgram);


		for (	Button b : btnsList) { 

			b.setOnAction(new EventHandler<ActionEvent>() {
				@Override 
				public void handle(ActionEvent arg0) {
					if(checker == 0) {
						showStartTheGame();
					}else {
						sp = new ScrollPane();
						secondaryStage = new Stage();			
						bpSec = new BorderPane();

						lbl = new Label(b.getText());
						lbl.setTextFill(Color.DARKBLUE);
						lbl.setFont(new Font("Arial", 25));	
						BorderPane.setAlignment(lbl, Pos.CENTER);
						bpSec.setTop(lbl);
						hbMulti = new HBox(); 
						if(b.getText().equals("Lecturers")) {
							hbMulti.getChildren().addAll(addPLecturer,addOLecturer, sortByName, sortByID);
							hbMulti.setAlignment(Pos.CENTER);
							bpSec.setBottom(hbMulti);
							bpSec.setCenter(null);
							sp.setContent(new Label(fireViewWantsAllLecturers()));
							sort(sortByName,b);sort(sortByID,b);
							Add(addPLecturer); Add(addOLecturer);
						}
						if(b.getText().equals("Colleges")) {
							hbMulti.getChildren().addAll(addCollage, sortByName,sendMessage,Gifts);
							hbMulti.setAlignment(Pos.CENTER);
							bpSec.setBottom(hbMulti); 
							sp.setContent(null);
							sp.setContent(new Label(fireViewWantsAllCollages()));
							sort(sortByName,b);
							Add(addCollage);
							Add(sendMessage);
							Add(Gifts);
						}
						if(b.getText().equals("Union")) {
							hbMulti.getChildren().addAll(editP, editO);								
							hbMulti.setAlignment(Pos.CENTER);
							bpSec.setBottom(hbMulti); 
							sp.setContent(null);
							sp.setContent(new Label(fireViewWantsAllUnions()));
							sort(sortByName,b);
							Add(editO);Add(editP);
						}
						bpSec.setCenter(sp);

						Scene secondaryScene = new Scene(bpSec, 500, 600);
						secondaryStage.setScene(secondaryScene);
						secondaryStage.show();							
						secondaryStage.setResizable(false);
					}
				}
			});

		}
		startTheProgram.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(checker==0) {
					fireViewAskToStartTheProgram();
					checker++;
				}
				else
					showTheGameHasAlreadyStarted();
			}
		});

		getTheWinners.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				secondaryStage = new Stage();			

				if(checker == 0){
					showStartTheGame();
				}
				else {
					bpSec = new BorderPane();
					lbl = new Label();
					String str = fireViewWantsTheWinners();
					
					lbl.setText(str);
					lbl.setTextFill(Color.RED);
					lbl.setFont(new Font("Arial", 20));
			
					winners = new Label("Better Group");
					winners.setTextFill(Color.DARKBLUE);
					winners.setFont(new Font("Arial", 30));
					winners.setAlignment(Pos.CENTER); 

					bpSec.setCenter(lbl);
					BorderPane.setAlignment(lbl, Pos.CENTER);
					bpSec.setTop(winners);
					BorderPane.setAlignment(winners, Pos.CENTER);

					Scene secondaryScene = new Scene(bpSec, 500, 600);
					secondaryStage.setScene(secondaryScene);
					secondaryStage.show();							
					secondaryStage.setResizable(false);
				}
			}
		});

		bpMain = new BorderPane();
		bpMain.setCenter(vb);
		bpMain.setBottom(hb);
		bpMain.setTop(lblProgram); 

		Scene scene = new Scene(bpMain, 500, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	public void sort(Button button, Button source){
		if(button.getText().equals("Sort By Name")) {
			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					Label l = new Label(fireViewAsksToSortByName(source.getText()));
					sp.setContent(l);
				}
			});
		}
		if(button.getText().equals("Sort By ID")) {
			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					Label l = new Label(fireViewAsksToSortByID());
					sp.setContent(l);
				}
			});
		}

	}

	public void Add(Button button){
		ThirdStage = new Stage();			
		bpTh = new BorderPane();
		tg = new ToggleGroup();
		addLecturertoCollage = new Button("Add Lecturer");
		deleteLecturer = new Button("Delete Lecturer");
		Send= new Button("Send");
		typ1 = new RadioButton();typ2 = new RadioButton();typ3 = new RadioButton();typ4 = new RadioButton();
		tf1 =new TextField();tf2 =new TextField();tf3 =new TextField();tf4 =new TextField();tf5 =new TextField();
		l1 =new Label();l2 =new Label();l3 =new Label();l4 =new Label();l5 =new Label();l6 =new Label();
		button.setOnAction(new EventHandler<ActionEvent>() {
			ArrayList<lecturer> a ;
			
			@Override
			public void handle(ActionEvent arg0) {
				Done = new Button("Done");
				if(button.getText().equals("Add Lecturer")) {
					gridPane = new GridPane();
					typ1.setText(degreeType.values()[0].name());typ1.setToggleGroup(tg);
					typ2.setText(degreeType.values()[1].name());typ2.setToggleGroup(tg);
					typ3.setText(degreeType.values()[2].name());typ3.setToggleGroup(tg);
					typ4.setText(degreeType.values()[3].name());typ4.setToggleGroup(tg);
					

					l1.setText("Name:");l2.setText("ID:");l3.setText("Specialization:");l4.setText("DegreeType:");l5.setText("Committe:");
					l6.setText("Salary Per Month:");
					gridPane.add(l1, 0, 0);                 	gridPane.add(tf1, 1, 0); 
					gridPane.add(l2, 0, 1);	                    gridPane.add(tf2, 1, 1); 
					gridPane.add(l3, 0, 2);	                    gridPane.add(tf3, 1, 2); 
					gridPane.add(l5, 0, 3);	                    gridPane.add(tf4, 1, 3); 
					gridPane.add(l4, 0, 4);	                    gridPane.add(typ1, 1, 4);
					gridPane.add(typ2, 1, 5); 
					gridPane.add(typ3, 1, 6);					gridPane.add(typ4, 1, 7);
					gridPane.add(l6, 0, 8);	                    gridPane.add(tf5, 1, 8); 
				}
				if(button.getText().equals("Add Outsider Lecturer")) {
					gridPane = new GridPane();
					typ1.setText(degreeType.values()[0].name());typ1.setToggleGroup(tg);
					typ2.setText(degreeType.values()[1].name());typ2.setToggleGroup(tg);
					typ3.setText(degreeType.values()[2].name());typ3.setToggleGroup(tg);
					typ4.setText(degreeType.values()[3].name());typ4.setToggleGroup(tg);
					

					l1.setText("Name:");l2.setText("ID:");l3.setText("Specialization:");l4.setText("DegreeType:");l5.setText("Salary Per Hour:");
					l6.setText("Total Work Hours:");
					gridPane.add(l1, 0, 0);                 	gridPane.add(tf1, 1, 0); 
					gridPane.add(l2, 0, 1);	                    gridPane.add(tf2, 1, 1); 
					gridPane.add(l3, 0, 2);	                    gridPane.add(tf3, 1, 2); 
					gridPane.add(l5, 0, 3);	                    gridPane.add(tf4, 1, 3); 
					gridPane.add(l4, 0, 4);	                    gridPane.add(typ1, 1, 4);
					gridPane.add(typ2, 1, 5); 
					gridPane.add(typ3, 1, 6);					gridPane.add(typ4, 1, 7);
					gridPane.add(l6, 0, 8);	                    gridPane.add(tf5, 1, 8); 
					tf5.setText("Max 14 Hours");
				}

				if(button.getText().equals("Add Collage")) {
					gridPane = new GridPane();
					l1.setText("Name:");l3.setText("Lecturers:");
					gridPane.add(l1, 0, 0); gridPane.add(tf1, 1, 0); 
					tf3.setText("Lecturer Name");
					tf3.setStyle("-fx-text-inner-color: gray;");
					tf3.setOnMouseClicked(event ->{tf3.setText("");tf3.setStyle("-fx-text-inner-color: black;");});
					gridPane.add(l3, 0, 3); gridPane.add(tf3, 1, 3);gridPane.add(addLecturertoCollage, 2, 3);
					a = new ArrayList<lecturer>();
					addLecturertoCollage.setOnAction(event-> {
						lecturer ll = fireViewAsksLecturerByName(tf3.getText());
						if(ll != null)
							a.add(ll);
						tf3.setText("");tf3.setStyle("-fx-text-inner-color: black;");
						tf3.setText("Lecturer Name");
						tf3.setStyle("-fx-text-inner-color: gray;");
						tf3.setOnMouseClicked(event2 ->{tf3.setText("");tf3.setStyle("-fx-text-inner-color: black;");});
					});
				}
				if(button.getText().equals("Send message")) {
					gridPane = new GridPane();
					l1.setText("College Name:");l2.setText("Enter message:");
					gridPane.add(l1, 0, 0); gridPane.add(tf1, 1, 0);
					gridPane.add(l2, 0, 1); gridPane.add(tf2, 1, 1);
					gridPane.add(Send,1,2);
					
				}
 
				
				if(button.getText().equals("Gifts on holidays")) {
					
					JOptionPane.showMessageDialog(null, "on holidays workers get a gift card: permanent workers get 500 shekel and outsider workers get 300 shekel.");
						
				}

				if(button.getText().equals("Edit PermanentsUnion")) {
					gridPane = new GridPane();
					l1.setText("Chairman:");l2.setText("Add Lecturer:");l3.setText("Remove Lecturer:");
					gridPane.add(l1, 0, 0); gridPane.add(tf1, 1, 0);
					tf2.setText("Lecturer Name");
					tf2.setStyle("-fx-text-inner-color: gray;");
					tf2.setOnMouseClicked(event ->{tf2.setText("");tf2.setStyle("-fx-text-inner-color: black;");});
					gridPane.add(l3, 0, 3); gridPane.add(tf3, 1, 3);gridPane.add(addLecturertoCollage, 2, 3);
					a = new ArrayList<lecturer>();
					addLecturertoCollage.setOnAction(event-> {
						lecturer ll = fireViewAsksPLecturerByName(tf3.getText());
						if(ll != null)
							a.add(ll);
						tf2.setText("");tf3.setStyle("-fx-text-inner-color: black;");
						tf2.setText("Lecturer Name");
						tf2.setStyle("-fx-text-inner-color: gray;");
						tf2.setOnMouseClicked(event2 ->{tf3.setText("");tf3.setStyle("-fx-text-inner-color: black;");});
					});
					tf3.setText("Lecturer Name");
					tf3.setStyle("-fx-text-inner-color: gray;");
					tf3.setOnMouseClicked(event ->{tf3.setText("");tf3.setStyle("-fx-text-inner-color: black;");});
					gridPane.add(l3, 0, 3); gridPane.add(tf3, 1, 3);gridPane.add(deleteLecturer, 2, 3);
					a = new ArrayList<lecturer>();
					deleteLecturer.setOnAction(event-> {
						lecturer ll = fireViewAsksPLecturerByName(tf3.getText());
						if(ll != null)
							a.remove(ll);
						tf3.setText("");tf3.setStyle("-fx-text-inner-color: black;");
						tf3.setText("Lecturer Name");
						tf3.setStyle("-fx-text-inner-color: gray;");
						tf3.setOnMouseClicked(event2 ->{tf3.setText("");tf3.setStyle("-fx-text-inner-color: black;");});
					});
				}
				if(button.getText().equals("Edit OutSidersUnion")) {
					gridPane = new GridPane();
					l1.setText("Chairman:");l2.setText("Add Lecturer:");l3.setText("Remove Lecturer:");
					gridPane.add(l1, 0, 0); gridPane.add(tf1, 1, 0);
					tf2.setText("Lecturer Name");
					tf2.setStyle("-fx-text-inner-color: gray;");
					tf2.setOnMouseClicked(event ->{tf2.setText("");tf2.setStyle("-fx-text-inner-color: black;");});
					gridPane.add(l3, 0, 3); gridPane.add(tf3, 1, 3);gridPane.add(addLecturertoCollage, 2, 3);
					a = new ArrayList<lecturer>();
					addLecturertoCollage.setOnAction(event-> {
						lecturer ll = fireViewAsksOLecturerByName(tf3.getText());
						if(ll != null)
							a.add(ll);
						tf2.setText("");tf3.setStyle("-fx-text-inner-color: black;");
						tf2.setText("Lecturer Name");
						tf2.setStyle("-fx-text-inner-color: gray;");
						tf2.setOnMouseClicked(event2 ->{tf3.setText("");tf3.setStyle("-fx-text-inner-color: black;");});
					});
					tf3.setText("Lecturer Name");
					tf3.setStyle("-fx-text-inner-color: gray;");
					tf3.setOnMouseClicked(event ->{tf3.setText("");tf3.setStyle("-fx-text-inner-color: black;");});
					gridPane.add(l3, 0, 3); gridPane.add(tf3, 1, 3);gridPane.add(deleteLecturer, 2, 3);
					a = new ArrayList<lecturer>();
					deleteLecturer.setOnAction(event-> {
						lecturer ll = fireViewAsksOLecturerByName(tf3.getText());
						if(ll != null)
							a.remove(ll);
						tf3.setText("");tf3.setStyle("-fx-text-inner-color: black;");
						tf3.setText("Lecturer Name");
						tf3.setStyle("-fx-text-inner-color: gray;");
						tf3.setOnMouseClicked(event2 ->{tf3.setText("");tf3.setStyle("-fx-text-inner-color: black;");});
					});
				}
				gridPane.setAlignment(Pos.CENTER);
				bpTh.setCenter(gridPane);
				bpTh.setBottom(Done);
				Done.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						if(button.getText().equals("Add Lecturer")) {
							if(tf1.getText().isEmpty()||tf2.getText().isEmpty()||tf3.getText().isEmpty()||tf4.getText().isEmpty()||tg.getSelectedToggle() == null)
								showOneOrMoreOfTheFieldsIsNull();
							else
								fireViewWantToAddPLecturer(tf1.getText(),Integer.parseInt((tf2.getText())),degreeType.valueOf(((RadioButton)tg.getSelectedToggle()).getText()),tf3.getText(),Integer.parseInt(tf5.getText()),0,tf4.getText());
						}
						if(button.getText().equals("Add Outsider Lecturer")) {
							if(tf1.getText().isEmpty()||tf2.getText().isEmpty()||tf3.getText().isEmpty()||tf4.getText().isEmpty()||tg.getSelectedToggle() == null)
								showOneOrMoreOfTheFieldsIsNull();
							else
								fireViewWantToAddOLecturer(tf1.getText(),Integer.parseInt((tf2.getText())),degreeType.valueOf(((RadioButton)tg.getSelectedToggle()).getText()),tf3.getText(),Integer.parseInt(tf4.getText()),Integer.parseInt(tf5.getText()));
						}
						if(button.getText().equals("Add Collage")) {
							if(tf1.getText().isEmpty()||tf2.getText().isEmpty()||tf4.getText().isEmpty())
								showOneOrMoreOfTheFieldsIsNull();
							else
								fireViewWantToAddCollage(tf1.getText(),a);
						}
						
						if(button.getText().equals("Edit OutSidersUnion")) {
							if(tf1.getText().isEmpty()||tf2.getText().isEmpty()||tf3.getText().isEmpty())
								showOneOrMoreOfTheFieldsIsNull();
							else
								fireViewWantToEditPunion(tf1.getText(),a);
						}
						if(button.getText().equals("Edit PermanentsUnion")) {
							if(tf1.getText().isEmpty()||tf2.getText().isEmpty()||tf3.getText().isEmpty())
								showOneOrMoreOfTheFieldsIsNull();
							else
								fireViewWantToEditOunion(tf1.getText(),a);
						}
						ThirdStage.close();
						secondaryStage.close();
					}
				});
				BorderPane.setAlignment(Done, Pos.CENTER);
				Scene ThirdScene = new Scene(bpTh, 500, 500);
				ThirdStage.setScene(ThirdScene);
				ThirdStage.show();							
				ThirdStage.setResizable(false);
			}
		});
	}

	private String fireViewAsksToSortByName(String source) {
		for (ViewListenable l : allListeners)
			return l.ViewAsksToSortByName(source);
		return null;
	}
	private String fireViewAsksToSortByID() {
		for (ViewListenable l : allListeners)
			return l.ViewAsksToSortByID();
		return null;
	}
	private void fireViewWantToAddPLecturer(String name, int id, degreeType type, String specialization, int salaryPerMonth, int numOfYears,String committe) {
		for (ViewListenable l : allListeners)
			l.ViewWantToAddPLecturer(name, id,type,specialization,salaryPerMonth,numOfYears,committe);
	}
	private void fireViewWantToAddOLecturer(String name, int id, degreeType type, String specialization, int salaryPerHour, int numOfhours) {
		for (ViewListenable l : allListeners)
			l.ViewWantToAddOLecturer(name, id,type,specialization,(salaryPerHour*numOfhours));
	}
	private void fireViewWantToAddCollage(String name, ArrayList<lecturer> lecturer)  {
		for (ViewListenable l : allListeners)
			l.ViewWantToAddCollege(name,lecturer);
	}
	private void fireViewWantToEditPunion(String name, ArrayList<lecturer> lecturer)  {
		for (ViewListenable l : allListeners)
			l.ViewWantToEditPunion( name,lecturer);
	}
	private void fireViewWantToEditOunion(String name,ArrayList<lecturer> lecturer)  {
		for (ViewListenable l : allListeners)
			l.ViewWantToEditOunion( name, lecturer);
	}

	private String fireViewWantsAllUnions() {
		for (ViewListenable l : allListeners)
			return l.ViewWantsAllUnions();		
		return null;
	}
	private String fireViewWantsAllCollages() {
		for (ViewListenable l : allListeners)
			return l.ViewWantsAllColleges();
		return null;
	}
	private String fireViewWantsAllLecturers() {
		for (ViewListenable l : allListeners)
			return l.ViewWantsAllLecturers();
		return null;		
	}
	private void fireViewAskToStartTheProgram() {
		for (ViewListenable l : allListeners)
			l.ViewAskToStartTheOlympic();	
	}
	private lecturer fireViewAsksLecturerByName(String name) {
		for (ViewListenable l : allListeners)
			return l.ViewAsksLecturerByName(name);
		return null;
	}
	private lecturer fireViewAsksPLecturerByName(String name) {
		for (ViewListenable l : allListeners)
			return l.ViewAsksPLecturerByName(name);
		return null;
	}
	private lecturer fireViewAsksOLecturerByName(String name) {
		for (ViewListenable l : allListeners)
			return l.ViewAsksOLecturerByName(name);
		return null;
	}

	
	private String fireViewWantsTheWinners() {
		for (ViewListenable l : allListeners)
			return l.ViewWantsTheWinners();
		return null;
	}

	@Override
	public void registerListener(ViewListenable l) {
		allListeners.add(l);
	}

	private void showStartTheGame() {
		JOptionPane.showMessageDialog(null, "Start The Program First!!");

	}
	private void showTheGameHasAlreadyStarted() {
		JOptionPane.showMessageDialog(null, "The Program Has Already Started");
	}
	private void showOneOrMoreOfTheFieldsIsNull() {
		JOptionPane.showMessageDialog(null, "Fill All The Fields");
	}
	private void showDelieveredMessage() {
		JOptionPane.showMessageDialog(null,"Message delievered");
	}
}
