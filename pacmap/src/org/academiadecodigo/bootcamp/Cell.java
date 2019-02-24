package org.academiadecodigo.bootcamp;

public class Cell {

    private int col;
    private int row;
    private boolean empty = true;

    public Cell(int col,int row){
        this.col = col;
        this.row = row;
    }

    public void setFull() {
        this.empty = false;
    }

    public void setEmpty(){
        this.empty = true;
    }

    public boolean isEmpty() {
        return empty;
    }


    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }



}