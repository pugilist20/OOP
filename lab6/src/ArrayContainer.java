import java.util.ArrayList;

public class ArrayContainer {
    private ArrayList<TFigure> arrayList;

    public ArrayContainer() {
        this.arrayList = new ArrayList<>();
    }

    public void add(TFigure figure) {
        arrayList.add(figure);
    }

    public TFigure get(int index) {
        return arrayList.get(index);
    }
    public int size(){
        return arrayList.size();
    }
    public void remove(int index){
        arrayList.remove(index);
    }
}
