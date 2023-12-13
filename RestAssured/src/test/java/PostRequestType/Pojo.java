package PostRequestType;

public class Pojo {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String[] getCourses() {
        return Courses;
    }

    public void setCourses(String[] courses) {
        Courses = courses;
    }

    String location;
    String phone;
    String Courses[];
}
