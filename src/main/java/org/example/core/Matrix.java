package org.example.core;

import org.example.factory.VegetableFactory;
import org.example.vegetables.*;


public class Matrix {
    private int rows;
    private int columns;
    private Vegetable[][] matrix;
    private VegetableFactory vegetableFactory;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Matrix(Vegetable[][] unparsedMatrix) {
        this.rows = unparsedMatrix.length;
        this.columns = unparsedMatrix[0].length > 0 ? unparsedMatrix[0].length : 0;
        this.vegetableFactory = vegetableFactory;
        this.matrix = unparsedMatrix;
    }

    private void parseMatrix(char[][] unparsedMatrix) {
        this.matrix = new Vegetable[this.rows][this.columns];
        for (int i = 0; i < unparsedMatrix.length; i++) {

            for (int j = 0; j < unparsedMatrix[0].length; j++) {
                this.matrix[i][j] = vegetableFactory.createVegetable(unparsedMatrix[i][j]);
            }
        }
    }

    public void growVegetables(int firstNinjaRow,int firstNinjaCol,int secondNinjaRow,int secondNinjaCol) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]!=null&&!matrix[i][j].isGrown()&& !(firstNinjaRow==i&&firstNinjaCol==j)&&!(secondNinjaRow==i &&secondNinjaCol==j)

                )
                    matrix[i][j].growIfNotGrown();
            }
        }
    }

    public boolean isVegetableGrown(int row, int col) {

        return this.matrix[row][col] != null && this.matrix[row][col].isGrown();

    }


    public Vegetable collectVegetable(int row, int col) {
        Vegetable vegetable = this.matrix[row][col];
        vegetable.setCurrentGrowth(0);
        return vegetable;
    }

    public boolean checkIfIsInMatrix(int row, int col) {
        if (row >= 0 && row < this.rows && col >= 0 && col < this.columns) return true;
else return false;
    }


}