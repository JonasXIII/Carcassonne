import java.util.ArrayList;

public class SelectGame {
    Board store;
    Board[] options;
    int curChoice = 0;
    
    public SelectGame(Board board){
        store = board;

    }

    public Board suplyOptions(Board[] boards){
        options = boards;
        curChoice = 0;
        return suplyCur();
    }

    public Board getNext(){
        curChoice++;
        if(curChoice==options.length){
            curChoice=0;
        }
        return suplyCur();
    }

    public Board getLast(){
        curChoice--;
        if(curChoice==-1){
            curChoice=options.length-1;
        }
        return suplyCur();
    }

    public Board select(){
        store = options[curChoice];
        store.highlighted = new ArrayList<Field>();
        curChoice = 0;
        return store;
    }


    private Board suplyCur(){
        return options[curChoice];
    }

}
