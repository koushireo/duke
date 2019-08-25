import java.util.ArrayList;

public class task{
    private ArrayList<tuple> todo = new ArrayList<tuple>();

    public void add(String d){
        String[] description = d.split(" ");
        String what_to_do = description[1];
        String note = "";
        int index;
        for (int i = 2; i < description.length; i ++) {
            if (description[i].charAt(0) == '/') {
                break;
            }
            else {
                what_to_do += " ";
                what_to_do += description[i];
            }
        }
        if (d.split("/").length > 1) {
            index = d.split("/")[1].indexOf(" ");
            note = d.split("/")[1].substring(0,index) + ": " + d.split("/")[1].substring(index + 1);
        }
        System.out.println("Got it. I've added this task:");
        if (note.equals("")) {
            System.out.println("[" + description[0].toUpperCase().charAt(0) + "][0] " + what_to_do );
        }
        else {
            System.out.println("[" + description[0].toUpperCase().charAt(0) + "][0] " + what_to_do + " ("  + note + ")");
        }
        System.out.println("Now you have " + todo.size() + " in the list.");
        todo.add(new tuple(what_to_do, description[0].toUpperCase().charAt(0), note));
    }

    public void list(){
        for (int i = 1; i <= todo.size(); i++) {
            System.out.print(i + ".[" + todo.get(i-1).type + "][" + todo.get(i-1).done + "] " + todo.get(i-1).todo);
            if (todo.get(i-1).additional.equals("")){
                System.out.println();
            }
            else {
                System.out.println("(" + todo.get(i-1).additional + ")");
            }
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
