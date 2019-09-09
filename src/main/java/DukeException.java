public class DukeException {
    public void lackDescription(String a){
        System.out.println("Please fill in the description of " + a);
    }
    public void lackTime(String a){
        System.out.println("Please fill in the time for " + a);
    }
    public void failSave(){
        System.out.println("Save failed");
    }
    public void failLoad(){
        System.out.println("Load failed");
    }
    public void noLoad(){
        System.out.println("There are already tasks in the list");
    }
}
