import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class save {
    private task temp;
    public save(task a) {
        temp = a;
    }
    public void savetask() throws IOException {
        File file = new File("C:\\Users\\fch\\Desktop\\2113\\duke-gradle-1\\master\\data\\duke.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter savefile = new BufferedWriter(new FileWriter(file));
        for (int i = 0; i < this.temp.size(); i++) {
            savefile.write(this.temp.get(i).todo + "|" + Integer.toString(this.temp.get(i).done) + "|"  + this.temp.get(i).additional + "|" + this.temp.get(i).type + "|");
            savefile.newLine();
        }
        System.out.println("Tasks saved successfully");
        savefile.close();
    }
}