import java.util.ArrayList;
import java.util.List;

class Project {
    private String name;
    private int daysToComplete;
    private boolean completedOnTime;

    public Project(String name, int daysToComplete, boolean completedOnTime) {
        this.name = name;
        this.daysToComplete = daysToComplete;
        this.completedOnTime = completedOnTime;
    }

    public int getDaysToComplete() {
        return daysToComplete;
    }

    public boolean isCompletedOnTime() {
        return completedOnTime;
    }
}

class Student {
    private String name;
    private List<Project> projects;

    public Student(String name) {
        this.name = name;
        this.projects = new ArrayList<>();
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfProjectsCompletedOnTime() {
        int count = 0;
        for (Project project : projects) {
            if (project.isCompletedOnTime()) {
                count++;
            }
        }
        return count;
    }

    public int getNumberOfProjectsCompletedLate() {
        int count = 0;
        for (Project project : projects) {
            if (!project.isCompletedOnTime()) {
                count++;
            }
        }
        return count;
    }

    public double getAverageTimeToCompleteProjects() {
        int totalDays = 0;
        for (Project project : projects) {
            totalDays += project.getDaysToComplete();
        }
        return (double) totalDays / projects.size();
    }
}

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("John");
        student1.addProject(new Project("Project 1", 5, true));
        student1.addProject(new Project("Project 2", 7, false));

        Student student2 = new Student("Alice");
        student2.addProject(new Project("Project 3", 6, true));
        student2.addProject(new Project("Project 4", 8, false));

        // Calculate and display statistics for each student
        displayStudentStatistics(student1);
        displayStudentStatistics(student2);
    }

    public static void displayStudentStatistics(Student student) {
        System.out.println("Student: " + student.getName());
        System.out.println("Projects completed on time: " + student.getNumberOfProjectsCompletedOnTime());
        System.out.println("Projects completed late: " + student.getNumberOfProjectsCompletedLate());
        System.out.println("Average time to complete projects: " + student.getAverageTimeToCompleteProjects() + " days\n");
    }
}
