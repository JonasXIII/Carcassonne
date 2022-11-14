Board board;
Board storeBoard;
Carcassonne game;
PImage[] tiles = new PImage[24];
int GAMESIZE = 71;
int boarder = 0;
int TILESIZE = 80;
Boolean MOUSECLICKCLOSEGAME = false;
boolean SELECTGAME = false;

void setup() {
    surface.setTitle("Carcassonne!");
    surface.setResizable(true);
    surface.setLocation(50,50);
    surface.setSize(2400, 1300);
    imageMode(CENTER);

    // tiles[0] = loadImage("FancyTiles/Base_Game_C2_Tile_A.jpg");
    for(char i = 'A'; i < 'Y'; i++){
        
        String name = "FancyTiles/Base_Game_C2_Tile_" + i + ".jpg";
        tiles[i-'A'] = loadImage(name).get(6,6,98,98);
        //System.out.println("Adding to list" + (int)(i-'A'));
    }
    //System.out.println("Done Adding");    

    
    
    gameType(1);
    
    
}

void draw() {
    background(200);
    // image(tiles['A' - 'A'],100,100,TILESIZE,TILESIZE);
    int distX = 2*boarder + 1 + board.maxX - board.minX;
    int distY = 2*boarder + 1 + board.maxY - board.minY;
    //surface.setSize(distX*TILESIZE, distY*TILESIZE);
    for(int i = 0; i < distY; i++){
        for(int j = 0; j < distX; j++){
            Field field = board.board[i+board.minY][j+board.minX];
            if(field.set){
                pushMatrix();
                
                translate((j+boarder+(14+board.minX-50))*TILESIZE+TILESIZE/2, (i+boarder+(8+board.minY-50))*TILESIZE+TILESIZE/2);
                rotate(radians(90*(field.rotation)));
                //System.out.println("Printing ID: " + (int)field.tile.ID);
                image(tiles[field.tile.ID -'A'], 0, 0, TILESIZE, TILESIZE);
                if(field.highlighted){
                    stroke(color(255,0,0));
                    strokeWeight(2);
                    line(-TILESIZE/2, -TILESIZE/2, TILESIZE/2,-TILESIZE/2); 
                    line(-TILESIZE/2, -TILESIZE/2, -TILESIZE/2,TILESIZE/2);  
                    strokeWeight(4);
                    line(TILESIZE/2, TILESIZE/2, TILESIZE/2,-TILESIZE/2);
                    line(TILESIZE/2, TILESIZE/2, -TILESIZE/2,TILESIZE/2); 
                     
                }
                //rotate((PIE/2) * field.rotation);
                //translate(-((j+1)*100+50), -((i+1)*100+50));

                popMatrix();
            }
            
            
        }
    }
}

public void gameType(int type){
    game = new Carcassonne();
    board = game.board;
    noLoop();
    if(type == 0){
        board = game.runRandGame(GAMESIZE);
        redraw();
    } else if (type ==1){
        board = game.runCloseGame(GAMESIZE);
        redraw();
    } else if (type ==2){
        MOUSECLICKCLOSEGAME = true;
        redraw();
    }
    else if(type==3){
        SELECTGAME = true;
        redraw();
    }
}


void keyPressed(){
    if(SELECTGAME){
        if(keyCode==LEFT){

        } else if(keyCode == RIGHT){

        }
    }
}

void mousePressed() {
    if(MOUSECLICKCLOSEGAME){
        board = game.makeCloseMove();
        redraw();
    }
}
