public class deadline extends tuple {
    public String additional;
    public datetime date = null;
    public deadline(String todo, char a, String b) {
        super(todo,a,b);
        this.todo = todo;
        this.done = 0;
        this.type = a;
        this.additional = b;
        if (!(b.equals("")) && additional.split(" ").length >= 3) {
            if (additional.split(" ")[1].split("/").length == 3 && additional.split(" ").length == 3) {
                this.date = new datetime(this.additional.split(" ")[1].split("/")[0], this.additional.split(" ")[1].split("/")[1], this.additional.split(" ")[1].split("/")[2], this.additional.split(" ")[2]);
            }
            if (additional.split(" ")[2].split("/").length == 3 && additional.split(" ").length == 3) {
                this.date = new datetime(this.additional.split(" ")[2].split("/")[0], this.additional.split(" ")[2].split("/")[1], this.additional.split(" ")[2].split("/")[2], this.additional.split(" ")[1]);
            }
        }
    }
}
