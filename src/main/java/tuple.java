public class tuple {
    public String todo;
    public int done;
    public char type;
    public String additional;
    public tuple(String todo, char a, String b) {
        this.todo = todo;
        this.done = 0;
        this.type = a;
        this.additional = b;
    }
}