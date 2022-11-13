import java.util.ArrayList;

public class Board {
    Field[][] board = new Field[100][100];
    ArrayList<Field> available = new ArrayList<Field>();
    public int minX,maxX,minY,maxY;

    public Board(){
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                board[i][j] = new Field(j,i);
            }
        }

        //ONLY LOOP OVER INNER SQUARE
        for(int i = 1; i < 99; i++){
            for(int j = 1; j < 99; j++){
                board[i][j].setNeighbors(board[i-1][j], board[i][j+1], board[i+1][j], board[i][j-1]);
            }
        }
        board[50][50].set(new Tile('D'), 0);
        addNeighborsToAvailable(board[50][50]);
        minX = 50;
        maxX = 50;
        minY = 50;
        maxY = 50;
    }

    public void addNeighborsToAvailable(Field middle){
        for(int i = 0; i < 4; i++){
            if(!middle.neighbors[i].isSet() && !available.contains(middle.neighbors[i])){
                available.add(middle.neighbors[i]);
            }
        }
    }

    public void removeFromAvailable(Field field){
        available.remove(field);
    }

    public ArrayList<Move> getPossibleMoves(Tile tile){
        ArrayList<Move> ret = new ArrayList<Move>();
        for(Field field: available){
            for(int i = 0; i < 4; i++){
                Move move = new Move(tile, field, i);
                if(isPossibleMove(move)){
                    //System.out.println("A possible move with rotation: " + i);
                    ret.add(move);
                }
            }
        }

        return ret;
    }

    public boolean isPossibleMove(Move move){
        for(int i = 0; i < 4; i++){
            Field neighbor = move.position.neighbors[i];
            if(neighbor.set){
                if(move.tile.sides[(i+4-move.rotation)%4] != neighbor.tile.sides[(i+6 - neighbor.rotation)%4]){
                    return false;
                }
            }
        }
        return true;
    }

    public void makeMove(Move move){
        
        //SET MIN AND MAX X AND Y
        int x = move.position.x;
        int y = move.position.y;
        if(x < minX){
            minX = x;
        }
        if(x > maxX){
            maxX = x;
        }
        if(y < minY){
            minY = y;
        }
        if(y > maxY){
            maxY = y;
        }
        addNeighborsToAvailable(move.position);

        removeFromAvailable(move.position);

        move.position.set(move.tile, move.rotation);
    }
}
