package com.example.demo;
// Demonstrate a list view.

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.collections.*;

public class ListViewDemo extends Application {

    public static void main(String[] args) {launch();}

    @Override
    public void start(Stage stage) {
        stage.setTitle("ListView Demo");

        // vertical and horizontal gaps of 10.
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 200, 270);
        stage.setScene(scene);
        Label response = new Label("Select Computer Type");

        // Create an ObservableList of entries for the list view.
        /**Список элементов, подлежащих отображению, задается параметром список,
         который представляет собой объект типа ObservableList.
         Вероятно, простейший способ создания объекта ObservableList для списка
         Listview — использование метода observableArrayList(), работающего
         по принципу фабрики объектов. Он определен как статический метод в классе
         FXCollections
         public static <E> ObservableList<E> observableArrayList() {
         return observableList(new ArrayList());
         для создания списка строк применяется метод observableArrayList().
         }*/
        ObservableList<String> computerTypes =
                FXCollections.observableArrayList("Smartphone", "Tablet", "Notebook",
                        "Desktop", "Телефон", "Барабан", "Револьвер" );

        // Create the list view.
        /**Создание списка, который отображает элементы
         из объекта computerTypes
         объект ObservableList используется для инициализации списка ListView*/
        ListView<String> lvComputers = new ListView<>(computerTypes);

        // Set the preferred height and width Списка.
        /**устанавливаются предпочтительные значения ширины и
         высоты компонента.*/
        lvComputers.setPrefSize(100, 170);

        // Get the list view selection model.
        //получение модели выбора для списка
        //создание объекта абстрактного класса MultipleSelectionModel<T>?
        MultipleSelectionModel<String> lvSelModel =
                lvComputers.getSelectionModel();
        //вызов метода setSelectionMode(SelectionMode var1)
        // для объекта класса MultipleSelectionModel<T>
        lvSelModel.setSelectionMode(SelectionMode.MULTIPLE);

        // Use a change listener to respond to a change of selection within a list view.
//для модели вызывается метод SelectedltemProperty() и регистрируется слушатель событий.
        lvSelModel.selectedItemProperty().addListener(
/*                new ChangeListener<String>() { //Обработка событий изменений
                    public void changed(ObservableValue<? extends String> changed,
                                        String oldVal, String newVal) */
                    (changed, oldVal, newVal) -> {
                        // Display the selection.
                        response.setText("Computer selected is " + newVal);
                });
//не работает
        ObservableList<String> list = lvSelModel.getSelectedItems();
        for (String string:list) {
            String str = "Computer selected is ";
            str += string;
            response.setText(str);
        };

        Button button = new Button("Close Button");
        button.setOnAction(e -> stage.close());
        stage.getIcons().add(new Image("duke.png"));
        // Add the label and list view to the scene graph.
        rootNode.getChildren().addAll(lvComputers, response, button);
        stage.show();
    }
}