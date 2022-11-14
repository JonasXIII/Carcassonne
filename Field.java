public class Field {
    Tile tile;
    int rotation;
    Field[] neighbors = new Field[4];
    boolean set = false;
    boolean highlighted = false;
    public int x,y;
    
    public Field(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setNeighbors(Field top, Field right, Field bot, Field left){
        neighbors[0] = top;
        neighbors[1] = right;
        neighbors[2] = bot;
        neighbors[3] = left;
    }

    public void set(Tile tile, int rotation){
        this.tile = tile;
        this.rotation = rotation;
        set = true;
    }

    public boolean isSet(){
        return set;
    }

    public Field clone(){
        Field clonedField = new Field(x,y);
        clonedField.tile = tile;
        clonedField.rotation = rotation;
        clonedField.setNeighbors(neighbors[0], neighbors[1], neighbors[2], neighbors[3]);
        clonedField.set = set;
        clonedField.highlighted = highlighted;
        return clonedField;
    }
}
