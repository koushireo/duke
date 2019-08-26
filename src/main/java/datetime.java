public class datetime {
    private int day;
    private int month;
    private int year;
    private int time;
    public datetime(String a, String b, String c, String d) {
        this.day = Integer.parseInt(a);
        this.month = Integer.parseInt(b);
        this.year = Integer.parseInt(c);
        this.time = Integer.parseInt(d);
    }
    public String time_converter(int a) {
        int b = a/100;
        int c = a%100;
        String d;
        String e;
        if (b < 10){
            d = "0" + Integer.toString(b);
        }
        else {
            d = Integer.toString(b);
        }
        if (c < 10){
            e = "0" + Integer.toString(c);
        }
        else {
            e = Integer.toString(c);
        }
        if (a == 0000) {
            return "12:00 A.M.";
        }
        else if (a <= 1159) {
            return d + ":" + e + " A.M.";
        }
        else {
            return d + ":" + e + " P.M.";
        }
    }
    public String print() {
        String[] month = {
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"};
        String[] day = {"st","nd","rd","th","th","th","th","th","th","th","th","th","th","th","th","th","th","th","th","th","st","nd","rd","th","th","th","th","th","th","th","st"};
        return Integer.toString(this.day) + day[this.day - 1] + " of " + month[this.month - 1] + " " + Integer.toString(this.year) + ", " + time_converter(this.time);
    }
}