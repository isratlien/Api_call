package Repository.localRepo.dbModel;

public class GetApiDbModel {
    private String Name;

    private int Id;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String Job) {
       this.Job = Job;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    private String Job;
    private int salary;
}
