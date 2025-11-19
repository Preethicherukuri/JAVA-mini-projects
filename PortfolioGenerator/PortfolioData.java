package Assignments.PortfolioGenerator;

public class PortfolioData {

    private String name;
    private String about;
    private String email;
    private String phone;
    private String skills;
    private String projects;

    public PortfolioData(String name, String about, String email, String phone, String skills, String projects) {
        this.name = name;
        this.about = about;
        this.email = email;
        this.phone = phone;
        this.skills = skills;
        this.projects = projects;
    }

    public String getName() { return name; }
    public String getAbout() { return about; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    public String[] getSkills() {
        return skills.split(",");
    }

    public String[] getProjects() {
        return projects.split(",");
    }
}
