import java.util.LinkedList;

public class ListContainer {
    private LinkedList<TFigure> linkedList;

    public ListContainer() {
        this.linkedList = new LinkedList<>();
    }
    public void add(TFigure figure) {
        linkedList.add(figure);
    }

    public TFigure get(int index) {
        return linkedList.get(index);
    }
    public  int size(){
        return linkedList.size();
    }
    public void remove(int index){
        linkedList.remove(index);
    }
}
