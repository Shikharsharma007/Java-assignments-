
import java.util.*;

class Course {
    String code;
    int capacity;

    HashSet<String> enrolled = new HashSet<>();
    ArrayList<String> prerequisites = new ArrayList<>();
    LinkedList<String> waitlist = new LinkedList<>();

    Course(String code, int capacity, List<String> prerequisites) {
        this.code = code;
        this.capacity = capacity;
        this.prerequisites.addAll(prerequisites);
    }
}

public class CourseRegistrationPortal {

    HashMap<String, Course> courses = new HashMap<>();
    HashMap<String, HashSet<String>> completed = new HashMap<>();

    void addCourse(String code, int capacity, List<String> prerequisites) {
        courses.put(code, new Course(code, capacity, prerequisites));
    }

    void markCompleted(String student, String course) {
        completed.computeIfAbsent(student, k -> new HashSet<>())
                 .add(course);
    }

    boolean eligible(String student, Course course) {
        return completed.getOrDefault(student, new HashSet<>())
                        .containsAll(course.prerequisites);
    }

    String register(String student, String code) {
        Course c = courses.get(code);

        if (c == null)
            return "Course not found";

        if (c.enrolled.contains(student) || c.waitlist.contains(student))
            return "Already registered or waitlisted";

        if (!eligible(student, c))
            return "Prerequisites not completed";

        if (c.enrolled.size() < c.capacity) {
            c.enrolled.add(student);
            return "Registration successful";
        }

        c.waitlist.addLast(student);
        return "Course full; added to waitlist";
    }

    void drop(String student, String code) {
        Course c = courses.get(code);

        if (c == null || !c.enrolled.remove(student))
            return;

        while (c.enrolled.size() < c.capacity && !c.waitlist.isEmpty()) {
            String next = c.waitlist.removeFirst();

            if (eligible(next, c)) {
                c.enrolled.add(next);
                break;
            }
        }
    }

    public static void main(String[] args) {
        CourseRegistrationPortal portal = new CourseRegistrationPortal();

        portal.addCourse("CSE201", 2, Arrays.asList("CSE101"));

        portal.markCompleted("S101", "CSE101");
        portal.markCompleted("S102", "CSE101");
        portal.markCompleted("S103", "CSE101");

        System.out.println(portal.register("S101", "CSE201"));
        System.out.println(portal.register("S102", "CSE201"));
        System.out.println(portal.register("S103", "CSE201"));

        portal.drop("S101", "CSE201");

        System.out.println("Enrolled: " +
            portal.courses.get("CSE201").enrolled);

        System.out.println("Waitlist: " +
            portal.courses.get("CSE201").waitlist);
    }
}
