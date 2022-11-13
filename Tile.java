public class Tile {
    public enum Side{f,r,c};

    public char ID;
    public Side[] sides;
    public boolean[] connections;
    public boolean shield;
    public boolean abby;

    public String ImageID;

    public Tile(int id, Side top, Side right, Side bot, Side left, boolean[] connections, boolean sh, boolean ab){
        this.ID = (char) id;
        this.connections = connections;
        this.shield = sh;
        this.abby = ab;
        sides = new Side[]{top,right,bot,left};
    }

    public Tile(char id){
        ID = id;
        shield = false;
        abby = false;
        connections = new boolean[]{false,false,false,false,false,false};
        ImageID = "FancyTiles/Base_Game_C2_Tile_" + id;
        switch (id) {
            case 'A':
                abby = true;
                sides = new Side[]{Side.f,Side.f,Side.r,Side.f};
                break;
            case 'B':
                abby = true;
                sides = new Side[]{Side.f,Side.f,Side.f,Side.f};
                break;
            case 'C':
                shield = true;
                sides = new Side[]{Side.c,Side.c,Side.c,Side.c};
                connections[0] = true;
                connections[1] = true;
                connections[2] = true;
                connections[3] = true;
                connections[4] = true;
                connections[5] = true;
                break;
            case 'D':
                sides = new Side[]{Side.c,Side.r,Side.f,Side.r};
                connections[4] = true;
                break;
            case 'E':
                sides = new Side[]{Side.c,Side.f,Side.f,Side.f};
                break;
            case 'F':
                shield = true;
                sides = new Side[]{Side.f,Side.c,Side.f,Side.c};
                connections[4] = true;
                break;
            case 'G':
                sides = new Side[]{Side.f,Side.c,Side.f,Side.c};
                connections[4] = true;
                break;
            case 'H':
                sides = new Side[]{Side.f,Side.c,Side.f,Side.c};
                break;
            case 'I':
                sides = new Side[]{Side.c,Side.c,Side.f,Side.f};
                break;
            case 'J':
                sides = new Side[]{Side.c,Side.r,Side.r,Side.f};
                connections[3] = true;
                break;
            case 'K':
                sides = new Side[]{Side.c,Side.f,Side.r,Side.r};
                connections[5] = true;
                break;
            case 'L':
                sides = new Side[]{Side.c,Side.r,Side.r,Side.r};
                break;
            case 'M':
                shield = true;
                sides = new Side[]{Side.c,Side.c,Side.f,Side.f};
                connections[0] = true;
                break;
            case 'N':
                sides = new Side[]{Side.c,Side.c,Side.f,Side.f};
                connections[0] = true;
                break;
            case 'O':
                shield = true;
                sides = new Side[]{Side.c,Side.r,Side.r,Side.c};
                connections[2] = true;
                connections[3] = true;
                break;
            case 'P':
                sides = new Side[]{Side.c,Side.r,Side.r,Side.c};
                connections[2] = true;
                connections[3] = true;
                break;
            case 'Q':
                shield = true;
                sides = new Side[]{Side.c,Side.c,Side.f,Side.c};
                connections[0] = true;
                connections[2] = true;
                connections[4] = true;
                break;
            case 'R':
                sides = new Side[]{Side.c,Side.c,Side.f,Side.c};
                connections[0] = true;
                connections[2] = true;
                connections[4] = true;
                break;
            case 'S':
                shield = true;
                sides = new Side[]{Side.c,Side.c,Side.r,Side.c};
                connections[0] = true;
                connections[2] = true;
                connections[4] = true;
                break;
            case 'T':
                sides = new Side[]{Side.c,Side.c,Side.r,Side.c};
                connections[0] = true;
                connections[2] = true;
                connections[4] = true;
                break;
            case 'U':
                sides = new Side[]{Side.r,Side.f,Side.r,Side.f};
                connections[1] = true;
                break;
            case 'V':
                sides = new Side[]{Side.f,Side.f,Side.r,Side.r};
                connections[5] = true;
                break;
            case 'W':
                sides = new Side[]{Side.f,Side.r,Side.r,Side.r};
                break;
            case 'X':
                sides = new Side[]{Side.r,Side.r,Side.r,Side.r};
                break;
            default:
                break;
        }
    }

}
