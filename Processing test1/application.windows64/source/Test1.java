import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Test1 extends PApplet {

int x, y, w, h, speedX, speedY;
int paddleX, paddleY, paddleW, paddleH, paddleS;
boolean up, down;

public void setup() {
  
  background(0);
  
  x = width/2;
  y = height/2;
  w = 50;
  h = 50;
  speedX = 7;
  speedY = 7;
  
  rectMode(CENTER);
  paddleX = 0;
  paddleY = height/2;
  paddleW = 30;
  paddleH = 100;
  paddleS = 10;
}

public void draw() {
  background(0);
  
  drawCirle(); //para desenhar o círculo
  moveCircle(); //para mexer o círculo
  bounce(); //para o círculo fazer ricochete
  
  drawPaddle();
  movePaddle();
  restrictPaddle();
  colision();
  
 }

public void drawPaddle() {
  fill(0,0,255);
  rect(paddleX, paddleY, paddleW, paddleH);
}

public void movePaddle(){
  if(up) {
    paddleY = paddleY - paddleS;
  }
  if (down){
    paddleY = paddleY + paddleS;
  }
}

public void restrictPaddle(){
  if(paddleY - paddleH/2 < 0){
    paddleY = paddleY + paddleS;
  }
  if(paddleY + paddleH/2 > height){
    paddleY = paddleY - paddleS;
  }
}

public void colision(){
  if(x - w/2 < paddleX + paddleW/2) {
    speedX = -speedX;
  }
}

public void drawCirle() {
  fill(255,0,0);
  stroke(255,255,255);
  ellipse(x, y, w, h);
}


public void moveCircle() {
  x = x + speedX;
  y = y + speedY;
}

public void bounce() {
  if( x > width - w/2) {
    speedX = -speedX;
  }
  
  else if ( x < 0 + w/2) {
    speedX = -speedX;
  }
  
  if( y > height - h/2) {
    speedY = -speedY;
  }
  
  else if( y < 0 - h/2) {
    speedY = -speedY;
  }
}

public void keyPressed() {
  if(key == 'w' || key == 'W') {
    up = true;
  }
   if(key == 's' || key == 'S') {
    down = true;
  }
}

public void keyReleased(){
    if(key == 'w' || key == 'W') {
    up = false;
  }
   if(key == 's' || key == 'S') {
    down = false;
  }
}
  public void settings() {  size(800,800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "Test1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
