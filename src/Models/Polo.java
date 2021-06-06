package Models;

import processing.core.PApplet;

import java.util.ArrayList;

public class Polo extends Automata implements Muvable {

    public Polo(int _posX, int _posY, PApplet _app) {
        super(_posX, _posY, AutomataKind.POLO, _app);
    }

    @Override
    public void move(int width, int high) {
        checkSpace(width, high);
        posX += velocityX;
        posY += velocityY;
    }

    public ArrayList<Integer> answer() {
        ArrayList<Integer> positions = new ArrayList<>();
        positions.add(posX);
        positions.add(posY);
        return positions;
    }

    private void checkSpace(int width, int high){
        if(posX >= width || posX <= 0) velocityX *= -1;
        if(posY >= high || posY <= 0) velocityY *= -1;
    }

}
