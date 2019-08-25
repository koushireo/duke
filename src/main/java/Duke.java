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
        String response = a.next();
        while (true) {
            System.out.println("____________________________________________________________");
            System.out.println(response);
            System.out.println("____________________________________________________________");
            response = a.next();
            if (response.equals("bye")) {
                break;
            }
        }
        System.out.println("____________________________________________________________");
        System.out.println("Bye! Hope to see you again.");
        System.out.println("____________________________________________________________");

    }
}