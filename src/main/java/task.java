import java.util.ArrayList;

public class task{
    private ArrayList<tuple> todo = new ArrayList<tuple>();

    public void add(String d){
        todo.add(new tuple(d));
    }

    public void list(){
        for (int i = 1; i <= todo.size(); i++) {
            System.out.println(i + ".[" +  /*(char)(226156151 - todo.get(i-1).done * 4)*/ todo.get(i-1).done + "] " + todo.get(i-1).todo);
        }
    }

    public void donezo(int a){
        if (a > todo.size()){
            System.out.println("Out of range");
        }
        else if (todo.get(a - 1).done == 1) {
            System.out.println("Already done");
        }
        else {
            System.out.println("Nice! I've marked this task as done:");
            System.out.println("[1]" + todo.get(a - 1).todo);
            todo.get(a - 1).done = 1;
        }
    }

}
