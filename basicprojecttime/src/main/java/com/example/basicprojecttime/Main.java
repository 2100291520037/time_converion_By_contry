package com.example.basicprojecttime;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Time Zone Converter");

        Label defaultTZLabel = new Label("Default Time Zone: ");
        Label defaultTZValueLabel = new Label();

        Label dateTimeLabel = new Label("Current Date and Time: ");
        Label dateTimeValueLabel = new Label();

        Label timeZoneLabel = new Label("Time Zone: ");
        ComboBox<String> timeZoneComboBox = new ComboBox<>();

        Button convertButton = new Button("Convert");
        Label convertedDateTimeLabel = new Label("Converted Date and Time: ");
        Label convertedDateTimeValueLabel = new Label();

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        vbox.getChildren().addAll(defaultTZLabel, defaultTZValueLabel, dateTimeLabel, dateTimeValueLabel,
                timeZoneLabel, timeZoneComboBox, convertButton, convertedDateTimeLabel, convertedDateTimeValueLabel);

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");

        Date dt = new Date();
        defaultTZValueLabel.setText(TimeZone.getDefault().getID());
        dateTimeValueLabel.setText(dateFormat.format(dt));

        List<String> availableTimeZones = Arrays.asList(TimeZone.getAvailableIDs());
        timeZoneComboBox.getItems().addAll(availableTimeZones);

        convertButton.setOnAction(e -> {
            String selectedTimeZone = timeZoneComboBox.getValue();
            TimeZone selectedTZ = TimeZone.getTimeZone(selectedTimeZone);
            dateFormat.setTimeZone(selectedTZ);

            Calendar cal = new GregorianCalendar();
            cal.setTime(dt);
            cal.setTimeZone(selectedTZ);

            String convertedDateTime = dateFormat.format(cal.getTime());
            convertedDateTimeValueLabel.setText(convertedDateTime);
        });
    }
}

