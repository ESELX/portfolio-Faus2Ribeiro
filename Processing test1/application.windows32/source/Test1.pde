int x, y, w, h, speedX, speedY;
int paddleX, paddleY, paddleW, paddleH, paddleS;
boolean up, down;

void setup() {
  size(800,800);
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

void draw() {
  background(0);
  
  drawCirle(); //para desenhar o círculo
  moveCircle(); //para mexer o círculo
  bounce(); //para o círculo fazer ricochete
  
  drawPaddle();
  movePaddle();
  restrictPaddle();
  colision();
  
 }

void drawPaddle() {
  fill(0,0,255);
  rect(paddleX, paddleY, paddleW, paddleH);
}

void movePaddle(){
  if(up) {
    paddleY = paddleY - paddleS;
  }
  if (down){
    paddleY = paddleY + paddleS;
  }
}

void restrictPaddle(){
  if(paddleY - paddleH/2 < 0){
    paddleY = paddleY + paddleS;
  }
  if(paddleY + paddleH/2 > height){
    paddleY = paddleY - paddleS;
  }
}

void colision(){
  if(x - w/2 < paddleX + paddleW/2) {
    speedX = -speedX;
  }
}

void drawCirle() {
  fill(255,0,0);
  stroke(255,255,255);
  ellipse(x, y, w, h);
}


void moveCircle() {
  x = x + speedX;
  y = y + speedY;
}

void bounce() {
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

void keyPressed() {
  if(key == 'w' || key == 'W') {
    up = true;
  }
   if(key == 's' || key == 'S') {
    down = true;
  }
}

void keyReleased(){
    if(key == 'w' || key == 'W') {
    up = false;
  }
   if(key == 's' || key == 'S') {
    down = false;
  }
}
