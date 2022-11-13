import java.util.ArrayList;
import java.util.Collections;

public class Pile {
    ArrayList<Tile> pile = new ArrayList<Tile>();
    public Pile(int foo){
        pile.add(new Tile(0,Tile.Side.r, Tile.Side.r, Tile.Side.r, Tile.Side.r, new boolean[]{false,false,false,false,false,false}, false, false));
        pile.add(new Tile(1,Tile.Side.c, Tile.Side.c, Tile.Side.c, Tile.Side.c, new boolean[]{true,true,true,true,true,true}, true, false));
        pile.add(new Tile(6,Tile.Side.c, Tile.Side.c, Tile.Side.f, Tile.Side.c, new boolean[]{true,false,true,false,true,false}, true, false));
        pile.add(new Tile(7,Tile.Side.c, Tile.Side.c, Tile.Side.r, Tile.Side.c, new boolean[]{true,false,true,false,true,false}, false, false)); 
        pile.add(new Tile(15,Tile.Side.f, Tile.Side.c, Tile.Side.f, Tile.Side.c, new boolean[]{false,false,false,false,true,false}, false, false));  
          
        for(int i=0;i<4;i++){
            pile.add(new Tile(2,Tile.Side.f, Tile.Side.f, Tile.Side.f, Tile.Side.f, new boolean[]{true,true,true,true,true,true}, false, true));}
        for(int i=0;i<2;i++){
            pile.add(new Tile(3,Tile.Side.f, Tile.Side.f, Tile.Side.r, Tile.Side.f, new boolean[]{true,false,true,false,true,false}, false, true));}
        for(int i=0;i<4;i++){
            pile.add(new Tile(4,Tile.Side.f, Tile.Side.r, Tile.Side.r, Tile.Side.r,new boolean[]{false,false,false,false,false,false},false,false));}
        for(int i=0;i<3;i++){
            pile.add(new Tile(5,Tile.Side.c, Tile.Side.c, Tile.Side.f, Tile.Side.c,new boolean[]{true,false,true,false,true,false},false,false));}
        for(int i=0;i<2;i++){
            pile.add(new Tile(8,Tile.Side.c, Tile.Side.c, Tile.Side.r, Tile.Side.c,new boolean[]{true,false,true,false,true,false},true,false));}
        for(int i=0;i<8;i++){
            pile.add(new Tile(9,Tile.Side.r, Tile.Side.f, Tile.Side.r, Tile.Side.f,new boolean[]{false,true,false,false,false,false},false,false));}
        for(int i=0;i<3;i++){
            pile.add(new Tile(10,Tile.Side.c, Tile.Side.f, Tile.Side.f, Tile.Side.c,new boolean[]{false,false,true,true,false,false},false,false));}
        for(int i=0;i<2;i++){
            pile.add(new Tile(11,Tile.Side.c, Tile.Side.f, Tile.Side.f, Tile.Side.c,new boolean[]{false,false,true,true,false,false},true,false));}
        for(int i=0;i<3;i++){
            pile.add(new Tile(12,Tile.Side.c, Tile.Side.r, Tile.Side.r, Tile.Side.c,new boolean[]{false,false,true,true,false,false},false,false));}
        for(int i=0;i<2;i++){
            pile.add(new Tile(13,Tile.Side.c, Tile.Side.r, Tile.Side.r, Tile.Side.c,new boolean[]{false,false,true,true,false,false}, true, false));}
        for(int i=0;i<9;i++){
            pile.add(new Tile(14,Tile.Side.f, Tile.Side.f, Tile.Side.r, Tile.Side.r,new boolean[]{true,false,false,false,false,true},false,false));}
        for(int i=0;i<2;i++){
            pile.add(new Tile(16,Tile.Side.f, Tile.Side.c, Tile.Side.f, Tile.Side.c,new boolean[]{false,false,false,false,true,false},true,false));}
        for(int i=0;i<3;i++){
            pile.add(new Tile(17,Tile.Side.c, Tile.Side.r, Tile.Side.r, Tile.Side.f,new boolean[]{false,false,false,true,false,false},false,false));}
        for(int i=0;i<3;i++){
            pile.add(new Tile(18,Tile.Side.c, Tile.Side.f, Tile.Side.r, Tile.Side.r,new boolean[]{false,false,false,false,false,true},false,false));}
        for(int i=0;i<5;i++){
            pile.add(new Tile(19,Tile.Side.c, Tile.Side.f, Tile.Side.f, Tile.Side.f,new boolean[]{false,false,false,true,true,true},false,false));}
        for(int i=0;i<2;i++){
            pile.add(new Tile(20,Tile.Side.c, Tile.Side.c, Tile.Side.f, Tile.Side.f,new boolean[]{false,false,false,false,false,true},false,false));}
        for(int i=0;i<3;i++){
            pile.add(new Tile(21,Tile.Side.f, Tile.Side.c, Tile.Side.f, Tile.Side.c,new boolean[]{false,true,false,false,false,false},false,false));}
        for(int i=0;i<3;i++){
            pile.add(new Tile(22,Tile.Side.c, Tile.Side.r, Tile.Side.r, Tile.Side.r, new boolean[]{false,false,false,false,false,false}, false, false));}
        for(int i=0;i<3;i++){
            pile.add(new Tile(23,Tile.Side.c, Tile.Side.r, Tile.Side.f, Tile.Side.r,new boolean[]{false,false,false,false,true,false},false,false));}
        Collections.shuffle(pile);
        //System.out.println(pile.size());
    }

    public Pile(){
        addPile('A', 2);
        addPile('B', 4);
        addPile('C', 1);
        addPile('D', 3);
        addPile('E', 5);
        addPile('F', 2);
        addPile('G', 1);
        addPile('H', 3);
        addPile('I', 2);
        addPile('J', 3);
        addPile('K', 3);
        addPile('L', 3);
        addPile('M', 2);
        addPile('N', 3);
        addPile('O', 2);
        addPile('P', 3);
        addPile('Q', 1);
        addPile('R', 3);
        addPile('S', 2);
        addPile('T', 1);
        addPile('U', 8);
        addPile('V', 9);
        addPile('W', 4);
        addPile('X', 1);
        Collections.shuffle(pile);
    }

    private void addPile(char id, int count){
        for(int i = 0; i < count; i++){
            pile.add(new Tile(id));
        }
    }
    public Tile draw(){
        return pile.remove(0);
    }
}
