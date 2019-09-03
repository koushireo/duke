public class parser {
    private int action;
    public void setaction(String a){
        if (a.equals("list")){
            this.action = 1;
        }
        else if (a.equals("done")){
            this.action = 2;
        }
        else if (a.equals("todo") || a.equals("deadline") || a.equals("event")) {
            this.action = 3;
        }
        else if (a.equals("save")) {
            this.action = 4;
        }
        else if (a.equals("load")) {
            this.action = 5;
        }
        else if(a.equals("delete")){
            this.action = 6;
        }
        else if(a.equals("find")){
            this.action = 7;
        }
        else{
            this.action = 8;
        }
    }
    public int getaction(){
        return this.action;
    }
}