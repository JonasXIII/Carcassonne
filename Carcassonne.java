import java.util.ArrayList;
import java.util.Collections;

public class Carcassonne {
    
    Board board = new Board();
    Pile pile = new Pile();

    public Carcassonne(){

    }

    public Board runRandGame(int numTiles){
        for(int i = 0; i < numTiles; i++){
            makeRandMove();
        }
        return board;
    }

    public Board runCloseGame(int numTiles){
        for(int i = 0; i < numTiles; i++){
            makeCloseMove();
        }
        return board;
    }


    public Board makeRandMove(){
        Tile tile = pile.draw();
        ArrayList<Move> moves = board.getPossibleMoves(tile);
        Collections.shuffle(moves);
        Move moveToMake = moves.remove(0);
        //System.out.println("Chose move with rotation: " + moveToMake.rotation);
        board.makeMove(moveToMake);
        return board;
    }

    public Board makeCloseMove(){
        Tile tile = pile.draw();
        ArrayList<Move> moves = board.getPossibleMoves(tile);
        Move moveToMake = null;
        for(Move move: moves){
            moveToMake = moves.get(0);
            int moveDist = (int)(50-move.position.x)*(50-move.position.x) + (50-move.position.y)*(50-move.position.y);
            int moveToMakeDist = (int)(50-moveToMake.position.x)*(50-moveToMake.position.x) + (50-moveToMake.position.y)*(50-moveToMake.position.y);
            if(moveDist < moveToMakeDist){
                moveToMake = move;
            }
        }
        if(moveToMake!=null){
            board.makeMove(moveToMake);
        }
        return board;
    }

    public Board[] getPossibleBoards(){
        Tile tile = pile.draw();
        ArrayList<Move> moves = board.getPossibleMoves(tile);
        Collections.shuffle(moves);
        Board[] output = new Board[moves.size()];
        for(int i = 0; i< moves.size(); i++){
            
            output[i] = board.clone();
            output[i].makeMove(moves.get(i));
            output[i].board[moves.get(i).position.x][moves.get(i).position.y].highlighted=true;
        }


        return output;
    }
}
