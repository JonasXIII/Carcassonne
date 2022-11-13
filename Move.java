public class Move {
    Tile tile;
    int rotation;
    Field position;

    public Move(Tile tile, Field position, int rotation){
        this.tile = tile;
        this.position = position;
        this.rotation = rotation;
    }
}
