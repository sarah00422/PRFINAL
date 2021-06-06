package Models;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class World {
    public Marco marco;
    public ArrayList<Polo> polos;
    PApplet app;
    int polosNumber = 20;
    int width;
    int high;
    int elementSize = 10;

    public World(PApplet _app, int _width, int _high){
        app = _app;
        high = _high;
        width = _width;
        polos = new ArrayList<>();
        marco = new Marco(width/2, high/2, app);
        for(int i = 0 ; i <= polosNumber; i++){
            Polo polo = new Polo(Utils.getRandomNumber(0, width),Utils.getRandomNumber(0, high), app);
            polos.add(polo);
            Thread thread = new Thread(polo);
            thread.start();
        }
    }

    public void initialize() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ArrayList<ArrayList<Integer>> newPositions = new ArrayList<>();
                if(marco.ask()){
                    for(Polo polo : polos){
                        newPositions.add(polo.answer());
                    }
                }
                marco.polosPositions = newPositions;
            }
        }, 0, 2000);
    }

    public void drawElements(){
        marco.draw(255, 0,0, elementSize );
        for (Polo polo : polos) {
            polo.draw(0, 255, 0, elementSize);
        }
    }


}
