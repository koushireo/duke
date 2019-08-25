/**
 * My <b>class</b>.
 * @see Duke
 */

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
        while (true) {
            System.out.println("____________________________________________________________");
            if (instruction[0].equals("list")){
                System.out.println("Here are the tasks in your list:");
                todo.list();
            }
            else if (instruction[0].equals("done")){
                int b = Integer.parseInt(instruction[1]);
                todo.donezo(b);
            }
            else if (instruction[0].equals("todo") || instruction[0].equals("deadline") || instruction[0].equals("event") ){
                if (instruction.length < 2){
                    System.out.println("Please fill in the description of " + instruction[0]);
                }
                else if (!instruction[0].equals("todo") && !response.contains("/")){
                    System.out.println("Please fill in the time for " + instruction[0]);
                }
                else {
                    todo.add(response);
                }
            }
            else{
                System.out.println("Unrecognised command");
            }
            System.out.println("____________________________________________________________");
            response = a.nextLine();
            instruction = response.split(" ");
            if (response.equals("bye")) {
                break;
            }
        }
        System.out.println("____________________________________________________________");
        System.out.println("Bye! Hope to see you again.");
        System.out.println("____________________________________________________________");

    }
}