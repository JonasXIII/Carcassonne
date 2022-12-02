import java.util.ArrayList;
import java.util.*;

public class Board {
    Field[][] board = new Field[100][100];
    Set<Field> available = new HashSet<Field>();
    public int minX=50,maxX=50,minY=50,maxY=50;
    ArrayList<Field> highlighted = new ArrayList<Field>();

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
        Move initialMove = new Move(new Tile('D'), board[50][50], 0);
        makeMove(initialMove);
    }
    public Board clone(){  
        Board cloneBoard = new Board();
        cloneBoard.minX = minX;
        cloneBoard.maxX = maxX;
        cloneBoard.minY = minY;
        cloneBoard.maxY = maxY;
        for(int i = 0; i < 100; i++){
            for(int j = 0; j<100;j++){
                cloneBoard.board[i][j] = board[i][j].clone();
            }
        }
        for(Field field:available){
            cloneBoard.available.add(field.clone());
        }
        for(Field field:highlighted){
            cloneBoard.highlighted.add(field.clone());
        }
        return cloneBoard;
    }
    

    public void addNeighborsToAvailable(Field middle){
        for(int i = 0; i < 4; i++){
            if(!middle.neighbors[i].isSet()){
                available.add(middle.neighbors[i]);
                System.out.println("Adding " + middle.neighbors[i].x + "," + middle.neighbors[i].y);
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
        System.out.println("total available: " + available.size());
    }
}
