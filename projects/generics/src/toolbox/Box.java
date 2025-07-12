package toolbox;

import java.util.ArrayList;
import java.util.List;

public class Box<T>{

    private final List<T> items = new ArrayList<>();

    public Box(){

    }

    public void add(T item){
        items.add(item);
    }

    public T get(int index){
        return items.get(index);
    }

    public int size(){
       return items.size();
    }

    @Override
    public String toString(){
        return items.toString();
    }
}