package agh.ics.oop.presenter;

import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationApp;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static agh.ics.oop.OptionsParser.parse;

public class SimulationPresenter implements MapChangeListener {

    @FXML
    private Label infoLabel;
    @FXML
    private GridPane mapGrid;
    @FXML
    private TextField moves;

    private WorldMap worldMap;
    private int width;
    private int height;
    private final int mapMaxHeight = 600;
    private final int mapMaxWidth = 600;
    private int mapWidth;
    private int mapHeight;
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    private void makeGrid(){
        mapGrid.getColumnConstraints().add(new ColumnConstraints(width));
        mapGrid.getRowConstraints().add(new RowConstraints(height));
        Label label = new Label("y/x");
        mapGrid.add(label, 0, 0);
        GridPane.setHalignment(label, HPos.CENTER);
    }

    private void updateBounds(){
        minX = worldMap.getCurrentBounds().lowerLeft().getX();
        minY = worldMap.getCurrentBounds().lowerLeft().getY();
        maxX = worldMap.getCurrentBounds().upperRight().getX();
        maxY = worldMap.getCurrentBounds().upperRight().getY();

        mapWidth = maxX-minX+1;
        mapHeight = maxY-minY+1;

        width = Math.round(mapMaxWidth/mapWidth);
        height = Math.round(mapMaxHeight/mapHeight);
        height = Math.min(height, width)-10;
        width = height;
    }

    public void edges(){
        for(int i=0; i<mapWidth; i++){
            Label label = new Label(Integer.toString(i+minX));
            GridPane.setHalignment(label, HPos.CENTER);
            mapGrid.getColumnConstraints().add(new ColumnConstraints(width));
            mapGrid.add(label, i+1, 0);
        }

        for(int i=0; i<mapHeight; i++){
            Label label = new Label(Integer.toString(maxY-i));
            GridPane.setHalignment(label, HPos.CENTER);
            mapGrid.getRowConstraints().add(new RowConstraints(height));
            mapGrid.add(label, 0, i+1);
        }
    }

    public void addElements(){
        for (int i = minX; i <= maxX; i++) {
            for (int j = maxY; j >= minY; j--) {
                Vector2d pos = new Vector2d(i, j);
                if (worldMap.isOccupied(pos)) {
                    mapGrid.add(new Label(worldMap.objectAt(pos).toString()), i - minX + 1, maxY - j + 1);
                }
                else {
                    mapGrid.add(new Label(" "), i - minX + 1, maxY - j + 1);
                }
                GridPane.setHalignment(mapGrid.getChildren().get(mapGrid.getChildren().size() - 1), HPos.CENTER);
            }
        }
    }

    private void drawMap(){
        updateBounds();
        makeGrid();
        edges();
        addElements();
    }

    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0)); // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        setWorldMap(worldMap);
        Platform.runLater(() -> {
            clearGrid();
            drawMap();
            infoLabel.setText(message);
        });
    }

    @FXML
    private void onSimulationStartClicked() throws InterruptedException {
        String movesString = moves.getText();
        List<MoveDirection> directions = parse(movesString.split(" "));
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        GrassField map = new GrassField(6);
        map.addObserver(this);
        Simulation simulation = new Simulation(positions,directions,map);
        SimulationEngine simulationEngine = new SimulationEngine(List.of(simulation));
        new Thread(simulationEngine::runSync).start();
    }

}
