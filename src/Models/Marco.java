package Models;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Hashtable;

public class Marco extends Automata implements Muvable {

    ArrayList<ArrayList<Integer>> polosPositions = new ArrayList<>();
    Hashtable<Integer, Double> polosDistances = new Hashtable<>();
    public Marco(int _posX, int _posY, PApplet _app) {
        super(_posX, _posY, AutomataKind.MARCO, _app);
    }

    @Override
    public void move(int width, int high) {
        if(polosPositions.size() == 0) return;
        calcDistancesFromPolos();
        ArrayList<Integer> positionOfCloser = polosPositions.get(getLesserDistance());
        System.out.println(positionOfCloser);
    }

    public boolean ask() {
        return true;
    }

    private void calcDistancesFromPolos(){
        for(int i = 0; i < polosPositions.size(); i ++){
            int difInX = polosPositions.get(i).get(0) - posX;
            int difInY = polosPositions.get(i).get(1) - posY;
            double distanceFromPolo = Math.sqrt(difInX^2 + difInY^2);
            polosDistances.put(i,distanceFromPolo);
        }
    }

    private int getLesserDistance(){
        int minor = 0;
        for(int i = 0; i < polosDistances.size(); i++){
            if(polosDistances.get(i) < minor) minor = i;
        }
        return minor;
    }


}
