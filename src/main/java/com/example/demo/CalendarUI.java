package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CalendarUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Pane p1 = new Pane();
//        p1.getChildren().add(new Button("open book"));
        Scene scene = new Scene(p1, 1000, 300);
        stage.setTitle("5 day layout");
        stage.setScene(scene);

        //displays the days of the week like a calendar
        Rectangle title = new Rectangle(0,0, 1000,75);
        title.setFill(Color.DARKRED);
        p1.getChildren().add(title);
        Text mainTitle = new Text(400, 50,"Day Planner");
        mainTitle.setFont(new Font(40));
        p1.getChildren().add(mainTitle);

        //day 1
        Rectangle day1 = new Rectangle(0, 75, 200,225);
        day1.setStroke(Color.BLUE);
        day1.setFill(new Color(.5,.5,.9,.1));
        p1.getChildren().add(day1);

        day1.setOnMouseClicked(actionEvent ->{
            Stage s1Stage = new Stage();
            Pane inD1 = new Pane();
            Scene inD1notes = new Scene(inD1,500,700);

            Button writeInD1 = new Button(" start to write");
            writeInD1.setLayoutX(50);
            writeInD1.setLayoutY(100);
            inD1.getChildren().add(writeInD1);
            writeInD1.setOnMouseClicked(writing->{

                test dayPlanner1 = new test();
                try {
                    dayPlanner1.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });

            Button loadIn1 = new Button("load task");
            loadIn1.setLayoutX(400);
            loadIn1.setLayoutY(100);
            inD1.getChildren().add(loadIn1);
            loadIn1.setOnMouseClicked(loading->{
                    loadTasks(inD1);
            });

            Button back1 = new Button("Done");
            back1.setLayoutX(235);
            back1.setLayoutY(670);
            inD1.getChildren().add(back1);
            back1.setOnMouseClicked(e-> s1Stage.close());

            s1Stage.setScene(inD1notes);
            s1Stage.setTitle("day");
            s1Stage.show();

        });

        //day 2
        Rectangle day2 = new Rectangle(200,75, 200,225);
        day2.setStroke(Color.BLUE);
        day2.setFill(new Color(.5,.5,.9,.1));
        p1.getChildren().add(day2);

        day2.setOnMouseClicked(actionEvent ->{
            Stage s2Stage = new Stage();
            Pane inD2 = new Pane();
            Scene inD2notes = new Scene(inD2,500,700);

            Button writeInD2 = new Button(" start to write");
            writeInD2.setLayoutX(50);
            writeInD2.setLayoutY(100);
            inD2.getChildren().add(writeInD2);
            writeInD2.setOnMouseClicked(writing->{

                test dayPlanner2 = new test();
                try {
                    dayPlanner2.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });

            Button loadIn2 = new Button("load task");
            loadIn2.setLayoutX(400);
            loadIn2.setLayoutY(100);
            inD2.getChildren().add(loadIn2);
            loadIn2.setOnMouseClicked(loading->{
                loadTasks(inD2);
            });

            Button back2 = new Button("Done");
            back2.setLayoutX(235);
            back2.setLayoutY(670);
            inD2.getChildren().add(back2);
            back2.setOnMouseClicked(e-> s2Stage.close());

            s2Stage.setScene(inD2notes);
            s2Stage.setTitle("day 2");
            s2Stage.show();

        });

        //day 3
        Rectangle day3 = new Rectangle(400,75,200,225);
        day3.setStroke(Color.BLUE);
        day3.setFill(new Color(.5,.5,.9,.1));
        p1.getChildren().add(day3);

        day3.setOnMouseClicked(actionEvent ->{
            Stage s3Stage = new Stage();
            Pane inD3 = new Pane();
            Scene inD3notes = new Scene(inD3,500,700);

            Button writeInD3 = new Button(" start to write");
            writeInD3.setLayoutX(50);
            writeInD3.setLayoutY(100);
            inD3.getChildren().add(writeInD3);
            writeInD3.setOnMouseClicked(writing->{

                test dayPlanner3 = new test();
                try {
                    dayPlanner3.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });

            Button loadIn3 = new Button("load task");
            loadIn3.setLayoutX(400);
            loadIn3.setLayoutY(100);
            inD3.getChildren().add(loadIn3);
            loadIn3.setOnMouseClicked(loading->{
                loadTasks(inD3);
            });

            Button back3 = new Button("Done");
            back3.setLayoutX(235);
            back3.setLayoutY(670);
            inD3.getChildren().add(back3);
            back3.setOnMouseClicked(e-> s3Stage.close());

            s3Stage.setScene(inD3notes);
            s3Stage.setTitle("day 3");
            s3Stage.show();

        });

        //day4
        Rectangle day4 = new Rectangle(600,75, 200,225);
        day4.setStroke(Color.BLUE);
        day4.setFill(new Color(.5,.5,.9,.1));
        p1.getChildren().add(day4);

        day4.setOnMouseClicked(actionEvent ->{
            Stage s4Stage = new Stage();
            Pane inD4 = new Pane();
            Scene inD4notes = new Scene(inD4,500,700);

            Button writeInD4 = new Button(" start to write");
            writeInD4.setLayoutX(50);
            writeInD4.setLayoutY(100);
            inD4.getChildren().add(writeInD4);
            writeInD4.setOnMouseClicked(writing->{

                test dayPlanner4 = new test();
                try {
                    dayPlanner4.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            Button loadIn4 = new Button("load task");
            loadIn4.setLayoutX(400);
            loadIn4.setLayoutY(100);
            inD4.getChildren().add(loadIn4);
            loadIn4.setOnMouseClicked(loading->{
                loadTasks(inD4);
            });

            Button back4 = new Button("Done");
            back4.setLayoutX(235);
            back4.setLayoutY(670);
            inD4.getChildren().add(back4);
            back4.setOnMouseClicked(e-> s4Stage.close());

            s4Stage.setScene(inD4notes);
            s4Stage.setTitle("day 4");
            s4Stage.show();

        });

        //day5
        Rectangle day5 = new Rectangle(800,75,200,225);
        day5.setStroke(Color.BLUE);
        day5.setFill(new Color(.5,.5,.9,.1));
        p1.getChildren().add(day5);

        day5.setOnMouseClicked(actionEvent ->{
            Stage s5Stage = new Stage();
            Pane inD5 = new Pane();
            Scene inD5notes = new Scene(inD5,500,700);

            Button writeInD5 = new Button(" start to write");
            writeInD5.setLayoutX(50);
            writeInD5.setLayoutY(100);
            inD5.getChildren().add(writeInD5);
            writeInD5.setOnMouseClicked(writing->{

                test dayPlanner5 = new test();
                try {
                    dayPlanner5.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });

            Button loadIn5 = new Button("load task");
            loadIn5.setLayoutX(400);
            loadIn5.setLayoutY(100);
            inD5.getChildren().add(loadIn5);
            loadIn5.setOnMouseClicked(loading->{
                loadTasks(inD5);
            });

            Button back5 = new Button("Done");
            back5.setLayoutX(235);
            back5.setLayoutY(670);
            inD5.getChildren().add(back5);
            back5.setOnMouseClicked(e-> s5Stage.close());

            s5Stage.setScene(inD5notes);
            s5Stage.setTitle("day 5");
            s5Stage.show();

        });

        stage.show();
    }

    private void loadTasks(Pane pane) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select tasks file to load");
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                double y = 100;
                while ((line = reader.readLine()) != null) {
                    Text taskText = new Text(50, y, line);
                    y += 20;
                    pane.getChildren().add(taskText);
                }
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Error occurred while loading tasks.");
                alert.showAndWait();
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}