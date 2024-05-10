package com.example.demo;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskCode extends Application {

    private TextField[] taskInputs;
    private Spinner<Integer>[] prioritySpinners;
    private List<File> selectedFiles = new ArrayList<>();
    private TextField dateInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("5-Day Planner");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        String[] daysOfWeek = {"task", "task", "task", "task", "task"};
        taskInputs = new TextField[5];
        prioritySpinners = new Spinner[5];

        for (int i = 0; i < 5; i++) {
            Label dayLabel = new Label(daysOfWeek[i] + ": ");
            grid.add(dayLabel, 0, i);

            taskInputs[i] = new TextField();
            grid.add(taskInputs[i], 1, i);

            Label priorityLabel = new Label("Priority:");
            grid.add(priorityLabel, 2, i);

            SpinnerValueFactory<Integer> valueFactory =
                    new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
            prioritySpinners[i] = new Spinner<>(valueFactory);
            grid.add(prioritySpinners[i], 3, i);
        }

        Label dateLabel = new Label("Date:");
        grid.add(dateLabel, 0, 5);

        dateInput = new TextField();
        grid.add(dateInput, 1, 5);

        Button saveButton = new Button("Save");
        grid.add(saveButton, 1, 6);
        saveButton.setOnAction(e -> saveTasks());

        Button loadButton = new Button("Load Tasks");
        grid.add(loadButton, 2, 6);
        loadButton.setOnAction(e -> loadTasks());

        Button deleteButton = new Button("Delete Files");
        grid.add(deleteButton, 3, 6);
        deleteButton.setOnAction(e -> deleteFiles());

        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    private void saveTasks() {
        List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String task = taskInputs[i].getText().trim();
            if (!task.isEmpty()) {
                int priority = prioritySpinners[i].getValue();
                tasks.add(new Task(task, priority));
            }
        }

        Collections.sort(tasks);

        StringBuilder content = new StringBuilder();

        for (Task t : tasks) {
            content.append("Priority ").append(t.getPriority()).append(": ").append(t.getTask()).append("\n");
        }

        String date = dateInput.getText().trim();
        if (date.isEmpty()) {
            date = "Untitled";
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName(date + ".txt");
        File selectedFile = fileChooser.showSaveDialog(null);

        if (selectedFile != null) {
            try (FileWriter writer = new FileWriter(selectedFile)) {
                writer.write(content.toString());
                writer.flush();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Tasks saved to " + selectedFile.getAbsolutePath());
                alert.showAndWait();
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Error occurred while saving tasks.");
                alert.showAndWait();
            }
        }
    }

    private void loadTasks() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select tasks file to load");
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                VBox content = new VBox();
                while (true) {
                    String line = reader.readLine();
                    if (line == null) break;
                    content.getChildren().add(new Label(line));
                }
                Scene scene = new Scene(content, 300, 200);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Tasks for " + selectedFile.getName());
                stage.show();
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Error occurred while loading tasks.");
                alert.showAndWait();
            }
        }
    }

    private void deleteFiles() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select files to delete");
        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(null);

        if (selectedFiles != null && !selectedFiles.isEmpty()) {
            for (File file : selectedFiles) {
                if (file.exists()) {
                    if (file.delete()) {
                        System.out.println("Deleted: " + file.getAbsolutePath());
                    } else {
                        System.out.println("Failed to delete: " + file.getAbsolutePath());
                    }
                }
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Files deleted successfully.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No files selected for deletion.");
            alert.showAndWait();
        }
    }


    class Task implements Comparable<Task> {
        private String task;
        private int priority;

        public Task(String task, int priority) {
            this.task = task;
            this.priority = priority;
        }

        public String getTask() {
            return task;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.priority, other.priority);
        }
    }
}