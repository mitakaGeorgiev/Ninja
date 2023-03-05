package org.example.core;

import org.example.factory.VegetableFactory;
import org.example.factory.VegetableFactoryImpl;
import org.example.io.ConsoleInputReader;
import org.example.io.ConsoleOutputWriter;
import org.example.io.InputReader;
import org.example.io.OutputWriter;
import org.example.ninjas.Directions;
import org.example.ninjas.Ninja;
import org.example.vegetables.Vegetable;


public class GameManager {
    private Matrix matrix;
    private Ninja currentPlayer;
    private Ninja otherPlayer;
    private VegetableFactory vegetableFactory;
    private boolean isRunning;
    private InputReader inputReader;
    private OutputWriter outputWriter;
    private NinjaNotifier ninjaNotifier;


    public GameManager(VegetableFactory vegetableFactory,InputReader inputReader,OutputWriter outputWriter,NinjaNotifier ninjaNotifier) {
        this.vegetableFactory = new VegetableFactoryImpl();
        this.inputReader = new ConsoleInputReader();
        this.outputWriter = new ConsoleOutputWriter();
        this.ninjaNotifier=new NinjaNotifier();
    }

    private Vegetable[][] parseMatrix(char[][] unparsedMatrix, String firstNinjaName, String secondNinjaName) {
        Vegetable[][] parsedMatrix = new Vegetable[unparsedMatrix.length][unparsedMatrix[0].length > 0 ? unparsedMatrix[0].length : 0];

        for (int i = 0; i < unparsedMatrix.length; i++) {

            for (int j = 0; j < unparsedMatrix.length; j++) {
                if (unparsedMatrix[i][j] == firstNinjaName.charAt(0)) {
                    this.currentPlayer = new Ninja(firstNinjaName);
                    currentPlayer.setRowPosition(i);
                    currentPlayer.setColumnPosition(j);
                    this.ninjaNotifier.addNinjaObserver(currentPlayer);

                } else if (unparsedMatrix[i][j] == secondNinjaName.charAt(0)) {
                    this.otherPlayer = new Ninja(secondNinjaName);
                    otherPlayer.setRowPosition(i);
                    otherPlayer.setColumnPosition(j);
                    this.ninjaNotifier.addNinjaObserver(otherPlayer);
                } else parsedMatrix[i][j] = this.vegetableFactory.createVegetable(unparsedMatrix[i][j]);

            }
        }
        return parsedMatrix;
    }

    private void initialiseGameField(char[][] unparsedMatrix, String firstNinja, String secondNinja) {
        this.matrix = new Matrix(this.parseMatrix(unparsedMatrix, firstNinja, secondNinja));
    }

    public void run() {

        initialiseGame();
        this.isRunning = true;
        while (isRunning) {
            String direction = this.inputReader.readline();
            this.processMove(direction);
        }

    }

    public void processPlayerMove(Directions currentDirecion) {
        switch (currentDirecion) {
            case UP -> {
                if (this.matrix.checkIfIsInMatrix(this.currentPlayer.getRowPosition() - 1, this.currentPlayer.getColumnPosition()))
                    this.currentPlayer.setRowPosition(currentPlayer.getRowPosition() - 1);
            }
            case DOWN -> {
                if (this.matrix.checkIfIsInMatrix(this.currentPlayer.getRowPosition() + 1, this.currentPlayer.getColumnPosition()))
                    this.currentPlayer.setRowPosition(currentPlayer.getRowPosition() + 1);
            }
            case LEFT -> {
                if (this.matrix.checkIfIsInMatrix(this.currentPlayer.getRowPosition() , this.currentPlayer.getColumnPosition()-1))
                    this.currentPlayer.setColumnPosition(currentPlayer.getColumnPosition() - 1);
            }
            case RIGHT -> {
                if (this.matrix.checkIfIsInMatrix(this.currentPlayer.getRowPosition() , this.currentPlayer.getColumnPosition()+1))
                    this.currentPlayer.setColumnPosition(currentPlayer.getColumnPosition() + 1);

            }
        }
        currentPlayer.setStamina(currentPlayer.getStamina() - 1);

        if (currentPlayer.getRowPosition() == otherPlayer.getRowPosition()
                && currentPlayer.getColumnPosition() == otherPlayer.getColumnPosition())
        { battle(currentPlayer, otherPlayer);
        this.isRunning = false;}

        if (this.matrix.isVegetableGrown(this.currentPlayer.getRowPosition(), this.currentPlayer.getColumnPosition()))
            this.currentPlayer.addVegetableToBag(
                    this.matrix.collectVegetable(
                            this.currentPlayer.getRowPosition(),
                            this.currentPlayer.getColumnPosition()));


        if (this.currentPlayer.getStamina() == 0) {
            this.ninjaNotifier.Notify(currentPlayer);
            currentPlayer.eatFromBackpack();

            switchPlayers();
        }
        this.matrix.growVegetables(currentPlayer.getRowPosition(),currentPlayer.getColumnPosition(),otherPlayer.getRowPosition(),otherPlayer.getColumnPosition());
    }


    private void processMove(String directions) {
        for (int i = 0; i < directions.length(); i++) {
            Directions currentDirecion = Directions.getDirection(directions.charAt(i));
            this.processPlayerMove(currentDirecion);
        }

    }

    private void initialiseGame() {

        String firstNinja = (inputReader.readline());
        String secondNinja = (inputReader.readline());

        String matrixDimentions = inputReader.readline();
        String[] matrixDimentionsSplited = matrixDimentions.split(" ");

        char[][] unparsedMatrix = new char[Integer.parseInt(matrixDimentionsSplited[0])][Integer.parseInt(matrixDimentionsSplited[1])];

        for (int i = 0; i < unparsedMatrix.length; i++) {
            String currentInput = inputReader.readline();
            for (int j = 0; j < unparsedMatrix.length; j++) {
                unparsedMatrix[i][j] = currentInput.charAt(j);
            }
        }
        this.initialiseGameField(unparsedMatrix, firstNinja, secondNinja);
    }

    public void switchPlayers() {
        Ninja temp = this.currentPlayer;
        this.currentPlayer = this.otherPlayer;
        this.otherPlayer = temp;


    }

    void battle(Ninja currentPlayer, Ninja otherPlayer) {
        if (currentPlayer.getPower() >= otherPlayer.getPower())
            this.outputWriter.writeLine(this.currentPlayer.toString());
        else this.outputWriter.writeLine(this.otherPlayer.toString());

    }


}


