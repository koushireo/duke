import java.util.ArrayList;

public class task{
    private ArrayList<String> todo = new ArrayList<String>();

    public void add(String d){
        todo.add(d);
    }

    public void list(){
        for (int i = 1; i <= todo.size(); i++) {
            System.out.println(i + ". " + todo.get(i-1));
        }
    }

}