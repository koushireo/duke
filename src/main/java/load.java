import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class load {
    task temp = new task();
    public void loadtask() throws IOException {
        /**
         * load
         * Load the saved information as tuple and add to ArrayList. Throws exception error if file not found,
         * or if there are already tasks in the ArrayList. Returns the initiated ArrayList
         * @author  Foo Chi Hen
         */
        String current;
        String[] temp1;
        File file = new File("C:\\Users\\fch\\Desktop\\2113\\duke-gradle-1\\master\\data\\duke.txt");
        BufferedReader loadfile = new BufferedReader((new FileReader(file)));
        while ((current = loadfile.readLine()) != null) {
            temp1 = current.split("\\|");
            temp.loadadd(temp1[0], temp1[1], temp1[2], temp1[3]);
        }
        temp.list();
        System.out.println("Loaded successfully.");
    }
    public task giveback(){
        return this.temp;
    }
}