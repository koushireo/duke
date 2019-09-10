public class tuple {
    /**
     * task tuple
     * Accepts input and pass input thru parser before doing the appropriate function
     * @params todo description of the task
     * @params a defined as the type of task(T - Todo, D - Deadline, E - Event)
     * @params b additional notes such as info about when the task should be done by or when is the event
     * @author  Foo Chi Hen
     */
    public String todo;
    public int done;
    public char type;
    public String additional;
    public datetime date = null;
    public tuple(String todo, char a, String b) {
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