package Models;

import processing.core.PApplet;

public class Automata implements Runnable {
    int posX;
    int posY;
    int velocityX;
    int velocityY;
    Runnable automatas[];
    AutomataKind kind;
    PApplet app;

    public Automata(int _posX, int _posY, AutomataKind _kind, PApplet _app){
        posX = _posX;
        posY = _posY;
        kind = _kind;
        app = _app;
        setVelocities();
    }
    @Override
    public void run() {

    }

    public void setVelocities(){
        if(kind == AutomataKind.MARCO){
            velocityX = 2;
            velocityY = 2;
        }
        else {
            velocityX = 1;
            velocityY = 1;
        }
    }

    public void draw(int R, int G, int B, int size){
        app.fill(R,G,B);
        app.circle(posX, posY, size);
    }
}
