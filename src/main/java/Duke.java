/**
 * My <b>class</b>.
 * @see Duke
 */

import java.io.IOException;
import java.util.Scanner;

public class Duke {
    /** Not a javadoc (ignored). */

    /**
     * Doubles the value.
     * The long and detailed explanation what the method does.
     *
     * @param value for doubling.
     * @return double value.
     */

    /** Extra javadoc (ignored). */

    public static void main(String[] args) {
        task todo = new task();
        parser parse = new parser();
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
        Scanner a = new Scanner(System.in);
        String response = a.nextLine();
        String[] instruction = response.split(" ");
        parse.setaction(instruction[0]);
        DukeException handle = new DukeException();
        while (true) {
            if (response.equals("bye")) {
                break;
            }
            System.out.println("____________________________________________________________");
            if (parse.getaction() == 1){
                System.out.println("Here are the tasks in your list:");
                todo.list();
            }
            else if (parse.getaction() == 2){
                int b = Integer.parseInt(instruction[1]);
                todo.donezo(b);
            }
            else if (parse.getaction() == 3){
                if (instruction.length < 2){
                    handle.lackDescription(instruction[0]);
                }
                else if (!instruction[0].equals("todo") && !response.contains("/")){
                    handle.lackTime(instruction[0]);
                }
                else {
                    todo.add(response);
                }
            }
            else if (parse.getaction() == 4) {
                try {
                    save temp = new save(todo);
                    temp.savetask();
                }
                catch (IOException e) {
                    handle.failSave();
                }
            }
            else if (parse.getaction() == 5) {
                if (!todo.isempty()){
                    handle.noLoad();
                }
                else {
                    try {
                        load loadtemp = new load();
                        loadtemp.loadtask();
                        todo = loadtemp.giveback();
                    } catch (IOException e) {
                        handle.failLoad();
                    }
                }
            }
            else if(parse.getaction() == 6){
                todo.delete(Integer.parseInt(instruction[1]));
            }
            else if(parse.getaction() == 7){
                todo.find(response);
            }
            else{
                System.out.println("Unrecognised command");
            }
            System.out.println("____________________________________________________________");
            response = a.nextLine();
            instruction = response.split(" ");
            parse.setaction(instruction[0]);
        }
        System.out.println("____________________________________________________________");
        System.out.println("Bye! Hope to see you again.");
        System.out.println("____________________________________________________________");

    }
}