public class Employee {

    private int id;
    private String nick;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }

    public Employee() {
    }

    public Employee(int id, String nick) {
        this.id = id;
        this.nick = nick;
    }

    @Override
    public String toString() {
        return "["+id+"] - " + nick +"";
    }
}
