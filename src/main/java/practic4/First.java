package practic4;

public class First {
    private String id,idHuman,salary,gender;

    public First(String id, String idHuman, String salary, String gender) {
        this.id = id;
        this.idHuman = idHuman;
        this.salary = salary;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdHuman() {
        return idHuman;
    }

    public void setIdHuman(String idHuman) {
        this.idHuman = idHuman;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
