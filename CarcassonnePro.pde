Board board;
Carcassonne game;
PImage[] tiles = new PImage[24];
int GAMESIZE = 71;
int boarder = 0;
int TILESIZE = 80;

void setup() {
    surface.setTitle("Carcassonne!");
    surface.setResizable(true);
    surface.setLocation(400,100);
    surface.setSize(1000, 800);
    surface.setFrameRate(10);
    imageMode(CENTER);

    tiles[0] = loadImage("FancyTiles/Base_Game_C2_Tile_A.jpg");
    for(char i = 'A'; i < 'Y'; i++){
        
        String name = "FancyTiles/Base_Game_C2_Tile_" + i + ".jpg";
        tiles[i-'A'] = loadImage(name).get(6,6,98,98);
        //System.out.println("Adding to list" + (int)(i-'A'));
    }
    //System.out.println("Done Adding");    

    game = new Carcassonne();
    board = game.runCloseGame(GAMESIZE);
    
}

void draw() {
    // image(tiles['A' - 'A'],100,100,TILESIZE,TILESIZE);
    int distX = 2*boarder + 1 + board.maxX - board.minX;
    int distY = 2*boarder + 1 + board.maxY - board.minY;
    surface.setSize(distX*TILESIZE, distY*TILESIZE);
    for(int i = 0; i < distY; i++){
        for(int j = 0; j < distX; j++){
            Field field = board.board[i+board.minY][j+board.minX];
            if(field.set){
                pushMatrix();
                
                translate((j+boarder)*TILESIZE+TILESIZE/2, (i+boarder)*TILESIZE+TILESIZE/2);
                rotate(radians(90*(field.rotation)));
                //System.out.println("Printing ID: " + (int)field.tile.ID);
                image(tiles[field.tile.ID -'A'], 0, 0, TILESIZE, TILESIZE);
                //rotate((PIE/2) * field.rotation);
                //translate(-((j+1)*100+50), -((i+1)*100+50));

                popMatrix();
            }
        }
    }
}

// void mousePressed() {
//     game.makeCloseMove();
// }
