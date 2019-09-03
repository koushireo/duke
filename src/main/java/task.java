import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class task{
    private ArrayList<tuple> todo = new ArrayList<tuple>();

    public ArrayList<String> add(String d){
        ArrayList<String> temp = new ArrayList<String>();
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
            temp.add("[" + description[0].toUpperCase().charAt(0) + "][0] " + what_to_do );
        }
        else {
            if (todo.get(todo.size() - 1).date == null) {
                temp.add("[" + description[0].toUpperCase().charAt(0) + "][0] " + what_to_do + " (" + note + ")");
            }
            else {
                temp.add("[" + description[0].toUpperCase().charAt(0) + "][0] " + what_to_do + " (" + todo.get(todo.size() - 1).date.print() + ")");
            }
        }
        temp.add("Now you have " + (todo.size()) + " in the list.");
        return temp;
    }

    public ArrayList<String> list(){
        ArrayList<String> temp1 = new ArrayList<String>();
        String temp = "";
        for (int i = 1; i <= todo.size(); i++) {
            temp = temp.concat(Integer.toString(i) + ".[" + todo.get(i-1).type + "][" + todo.get(i-1).done + "] " + todo.get(i-1).todo);
            if (todo.get(i-1).additional.equals("")){
                temp1.add(temp);
                temp = "";
            }
            else {
                if (todo.get(i-1).date == null) {
                    temp = temp.concat("(" + todo.get(i-1).additional + ")");
                    temp1.add(temp);
                    temp = "";
                }
                else{
                    temp = temp.concat("(" + todo.get(i-1).additional.split(" ")[0] + " ");
                    temp = temp.concat(todo.get(i-1).date.print());
                    temp = temp.concat(")");
                    temp1.add(temp);
                    temp = "";
                }
            }
        }
        System.out.println(temp);
        return temp1;
    }

    public ArrayList<String> donezo(int a){
        ArrayList<String> temp = new ArrayList<String>();
        if (todo.get(a - 1).done == 1) {
            temp.add("Already done");
        }
        else {
            temp.add("I've marked this task as done:");
            temp.add("[1]" + todo.get(a - 1).todo);
            todo.get(a - 1).done = 1;
        }
        return temp;
    }
    public ArrayList<String> save() throws IOException {
        //File file = new File("C:\\Users\\fch\\Desktop\\2113\\duke-gradle-1\\master\\data\\duke.txt");
        File file = new File("data\\duke.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter savefile = new BufferedWriter(new FileWriter(file));
        System.out.println(todo.size());
        for (int i = 0; i < todo.size(); i++) {
            savefile.write(todo.get(i).todo + "|" + Integer.toString(todo.get(i).done) + "|"  + todo.get(i).additional + "|" + todo.get(i).type + "|");
            savefile.newLine();
        }
        ArrayList<String> temp = new ArrayList<String>();
        temp.add("Tasks saved successfully");
        savefile.close();
        return temp;
    }
    public ArrayList<String> load() throws IOException {
        ArrayList<String> temp1 = new ArrayList<String>();
        if (todo.isEmpty()) {
            String current;
            String[] temp;
            //File file = new File("C:\\Users\\fch\\Desktop\\2113\\duke-gradle-1\\master\\data\\duke.txt");
            File file = new File("data\\duke.txt");
            BufferedReader loadfile = new BufferedReader((new FileReader(file)));
            while ((current = loadfile.readLine()) != null) {
                temp = current.split("\\|");
                loadadd(temp[0], temp[1], temp[2], temp[3]);
            }
            list();
            temp1.add("Loaded successfully.");
        }
        else {
            temp1.add("There are already tasks in the list");
        }
        return temp1;
    }

    public void loadadd(String a, String b, String c, String d) {
        tuple temp = new tuple(a,d.charAt(0),c);
        temp.done = Integer.parseInt(b);
        todo.add(temp);
    }

    public ArrayList<String> delete(int i) {
        ArrayList<String> temp = new ArrayList<String>();
        String temp1 = "";
        temp.add("The task below has been successfully removed");
        temp1 = temp1.concat(i + ".[" + todo.get(i - 1).type + "][" + todo.get(i - 1).done + "] " + todo.get(i - 1).todo);
        if (todo.get(i - 1).additional.equals("")) {
            temp.add(temp1);
        } else {
            if (todo.get(i - 1).date == null) {
                temp1 = temp1.concat("(" + todo.get(i - 1).additional + ")");
                temp.add(temp1);
            } else {
                temp1 = temp1.concat("(" + todo.get(i - 1).additional.split(" ")[0] + " ");
                temp1 = temp1.concat(todo.get(i - 1).date.print() + ")");
                temp.add(temp1);
            }
        }
        todo.remove(i - 1);
        return temp;
    }
    public ArrayList<String> find(String a){
        ArrayList<String> temp = new ArrayList<String>();
        String temp1 = "";
        temp.add("The following tasks matched your keyword(" + a + ")");
        for (int i = 0; i < todo.size(); i++) {
            if (todo.get(i).todo.contains(a)) {
                temp1 = temp1.concat(i + ".[" + todo.get(i).type + "][" + todo.get(i).done + "] " + todo.get(i).todo);
                if (todo.get(i).additional.equals("")) {
                } else {
                    if (todo.get(i - 1).date == null) {
                        temp1 = temp1.concat("(" + todo.get(i).additional + ")");
                    } else {
                        temp1 = temp1.concat("(" + todo.get(i).additional.split(" ")[0] + " ");
                        temp1 = temp1.concat(todo.get(i).date.print() + ")");
                    }
                }
            }
            if (!temp1.equals("")) {
                temp.add(temp1);
            }
            temp1 = "";
        }
        return temp;
    }
    public int size(){
        return todo.size();
    }
}
