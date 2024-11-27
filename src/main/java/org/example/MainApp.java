package org.example;

import processing.core.PApplet;
import processing.core.PImage;

public class MainApp extends PApplet {

    public int x = 200;
    public int y =200;
    public int velx = 0;
    public int vely = 0;
    public boolean grounded = false;
    public PImage mario;

    public static void main(String[] args) {
        // Include the full package name
        PApplet.main("org.example.MainApp");
    }

    public void settings() {
        size(1200, 800);
    }

    public void setup() {
        mario = loadImage("sprites/mario.png");
    }

    public void draw() {
        background(255);
        fill(200);
        rect(0, 700, 1200, 100);
        image(mario, x, y, 50, 50);
        x += velx;
        y += vely;
        if (velx > 0){
            velx -= 1;
        }
        else if (velx < 0){
            velx += 1;
        }
        if (y < 650 && vely < 15){
            vely += 1;
            grounded = false;
        }
        else if (y > 650){
            y = 650;
            grounded = true;
        }
        else {
            grounded = true;
        }
    }

    public void keyPressed() {
        if (keyCode == UP) {
            y -= 10;
        }
        if (keyCode == DOWN) {
            y += 10;
        }
        if (keyCode == LEFT && velx > -10) {
            velx = -10;
        }
        if (keyCode == RIGHT && velx < 10) {
            velx = 10;
        }
        if (key == ' ' && grounded){
            vely = -15;
            y -= 10;
            velx *= 2;
            grounded = false;
        }
    }
}
