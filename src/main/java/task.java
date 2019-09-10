import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

public class task{
    /**
     * task
     * ArrayList of tuple objects to store the tasks input by user
     * @author  Foo Chi Hen
     */
    private ArrayList<tuple> todo = new ArrayList<tuple>();

    public void add(String d){
        /**
         * Add
         * Create a tuple object and add to initialised ArrayList<tuple></tuple>
         * @params d the full command input by user
         */
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
        if (d.split("/",2).length > 1) {
            index = d.split("/",2)[1].indexOf(" ");
            note = d.split("/",2)[1].substring(0,index) + ": " + d.split("/",2)[1].substring(index + 1);
        }
        todo.add(new tuple(what_to_do, description[0].toUpperCase().charAt(0), note));
        String z = "Got it. I've added this task:";
        System.out.println(z);
//        System.out.println();
        if (note.equals("")) {
            System.out.println("[" + description[0].toUpperCase().charAt(0) + "][0] " + what_to_do );
        }
        else {
            if (todo.get(todo.size() - 1).date == null) {
                System.out.println("[" + description[0].toUpperCase().charAt(0) + "][0] " + what_to_do + " (" + note + ")");
            }
            else {
                System.out.println("[" + description[0].toUpperCase().charAt(0) + "][0] " + what_to_do + " (" + todo.get(todo.size() - 1).date.print() + ")");
            }
        }
        System.out.println("Now you have " + (todo.size()) + " in the list.");
    }

    public void loadadd(String a, String b, String c, String d) {
        tuple temp = new tuple(a,d.charAt(0),c);
        temp.done = Integer.parseInt(b);
        todo.add(temp);
    }
    public void list(){
        /**
         * List
         * Output the entire tuple objects in the ArrayList<tuple></tuple>
         * @author  Foo Chi Hen
         */
        for (int i = 1; i <= todo.size(); i++) {
            System.out.print(i + ".[" + todo.get(i-1).type + "][" + todo.get(i-1).done + "] " + todo.get(i-1).todo);
            if (todo.get(i-1).additional.equals("")){
                System.out.println();
            }
            else {
                if (todo.get(i-1).date == null) {
                    System.out.println("(" + todo.get(i-1).additional + ")");
                }
                else{
                    System.out.print("(" + todo.get(i-1).additional.split(" ")[0] + " ");
                    System.out.print(todo.get(i-1).date.print());
                    System.out.println(")");
                }
            }
        }
    }

    public void donezo(int a){
        /**
         * Done
         * Mark a task is done
         * @params a the index of the task on the list
         * @author  Foo Chi Hen
         */
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
    public void save() throws IOException {
        /**
         * save
         * Save information of tuple objects in ArrayList to a text file. Throws exception error if file not found
         * @author  Foo Chi Hen
         */
        File file = new File("C:\\Users\\fch\\Desktop\\2113\\duke-gradle-1\\master\\data\\duke.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter savefile = new BufferedWriter(new FileWriter(file));
        System.out.println(todo.size());
        for (int i = 0; i < todo.size(); i++) {
            savefile.write(todo.get(i).todo + "|" + Integer.toString(todo.get(i).done) + "|"  + todo.get(i).additional + "|" + todo.get(i).type + "|");
            savefile.newLine();
        }
        System.out.println("Tasks saved successfully");
        savefile.close();
    }
    public void load() throws IOException {
        /**
         * load
         * Load the saved information as tuple and add to ArrayList. Throws exception error if file not found,
         * or if there are already tasks in the ArrayList
         * @author  Foo Chi Hen
         */
        if (todo.isEmpty()) {
            String current;
            String[] temp;
            File file = new File("C:\\Users\\fch\\Desktop\\2113\\duke-gradle-1\\master\\data\\duke.txt");
            BufferedReader loadfile = new BufferedReader((new FileReader(file)));
            while ((current = loadfile.readLine()) != null) {
                temp = current.split("\\|");
                loadadd(temp[0], temp[1], temp[2], temp[3]);
            }
            list();
            System.out.println("Loaded successfully.");
        }
        else {
            System.out.println("There are already tasks in the list");
        }
    }
    public void delete(int i){
        /**
         * delete
         * Delete the task in the ArrayList determined by the user
         * @params i The index of the tuple on the list
         * @author  Foo Chi Hen
         */
        if (i <= todo.size() && i > 0){
            System.out.println("The task below has been successfully removed");
            System.out.print(i + ".[" + todo.get(i - 1).type + "][" + todo.get(i - 1).done + "] " + todo.get(i - 1).todo);
            if (todo.get(i - 1).additional.equals("")) {
                System.out.println();
            } else {
                if (todo.get(i - 1).date == null) {
                    System.out.println("(" + todo.get(i - 1).additional + ")");
                } else {
                    System.out.print("(" + todo.get(i - 1).additional.split(" ")[0] + " ");
                    System.out.print(todo.get(i - 1).date.print());
                    System.out.println(")");
                }
            }
            todo.remove(i - 1);
        }
        else {
            System.out.println("Out of range.");
        }
    }
    public void find(String a){
        /**
         * find
         * Output the tasks in the list that fit the keyword input by user
         * @params a the keyword to be used to find the relevant tasks
         * @author  Foo Chi Hen
         */
        String keyword = a.split(" ",2)[1];
        System.out.println("The following tasks matched your keyword(" + keyword + ")");
        for (int i = 0; i < todo.size(); i++) {
            if (todo.get(i).todo.contains(keyword)) {
                System.out.print(i + ".[" + todo.get(i).type + "][" + todo.get(i).done + "] " + todo.get(i).todo);
                if (todo.get(i).additional.equals("")) {
                    System.out.println();
                } else {
                    if (todo.get(i - 1).date == null) {
                        System.out.println("(" + todo.get(i).additional + ")");
                    } else {
                        System.out.print("(" + todo.get(i).additional.split(" ")[0] + " ");
                        System.out.print(todo.get(i).date.print());
                        System.out.println(")");
                    }
                }
            }
        }
    }
    public tuple get(int a){
        return todo.get(a);
    }
    public int size(){
        return todo.size();
    }
    public boolean isempty(){
        if (todo.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
