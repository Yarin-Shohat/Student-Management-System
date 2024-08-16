import java.io.*;

/**
 * This class represent the report on the student's achievements in the course
 *
 * Attributes:
 *  name: Course Name
 *  points: Course Credits
 *  grade: Student Grade
 */
public class CourseReport implements Comparable<CourseReport>, Serializable {
    /**
     * Default Constructor
     *
     * name = null
     * points = 0
     * grade = 0
     */
    public CourseReport() {
        // Set Default members
        this.name = null;
        this.points = 0;
        this.grade = 0;
    }
    /**
     * Regular Constructor
     *
     * @param name - Course Name
     * @param points - Course Credits
     * @param grade - Student Grade
     */
    public CourseReport(String name, int points, double grade) {
        // Set members
        // # Set name
        this.name = name;
        // # Set points
        this.points = Math.max(points, 0);
        // # Set grade
        grade = Math.max(0, grade);
        grade = Math.min(100, grade);
        this.grade = grade;
    }
    /**
     * Copy Constructor
     *
     * @param other - Other CourseReport Object we will copy from it
     */
    public CourseReport(CourseReport other) {
        // Call Default Constructor
        this();
        // If other not null, copy values
        if (other != null) {
            this.name = other.name;
            this.points = other.points;
            this.grade = other.grade;
        }
    }
    /**
     * Constructor From File
     *
     * @param file - File object contain path to file that contain name, points and grade of other CourseReport
     */
	public CourseReport(File file) {
        this();
        // Check that the file is exist
        if(file == null) return;
        if(!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // Get the data
            String line = reader.readLine();
            if (line != null) {
                // Split the string to get each member
                String[] list = line.split(", ");
                if (list.length == 3) {
                    // Get Name
                    this.name = list[0].substring(1, list[0].length());
                    // Check name is null - change to real null
                    if(this.name.contentEquals("null")) this.name = null;
                    // Get Points
                    this.points = Integer.parseInt(list[1]);
                    // Get Grade
                    this.grade = Double.parseDouble(list[2].substring(0, list[2].length()-1));
                }
            }
        }
        catch (IOException e) {
            return;
        }
    }
    /**
     * This function return the Grade of the Student in this Course
     *
     * @return double - student grade
     */
    public double getGrade() {
        return this.grade;
    }
    /**
     * This function set the Student Grade in the Course
     *
     * @param grade - Student new Grade
     */
    public void setGrade(double grade) {
        if (grade < 0) {
            // Min grade is 0
            this.grade = 0;
        }
        else if (grade > 100) {
            // Max grade is 100
            this.grade = 100;
        }
        else{
            this.grade = grade;
        }
    }
    /**
     * This function return the Course Name
     *
     * @return String - Course Name
     */
    public String getName() {
        return this.name;
    }
    /**
     * This function set the Course Name
     *
     * @param name - Course Name
     */
    public void setName(String name) {
        // Check name isn't null
        if (name != null) {
            this.name = name;
        }
    }
    /**
     * This function return Course Credits Points
     *
     * @return int - Course Credits Points
     */
    public int getPoints() {
        return this.points;
    }
    /**
     * This function set Course Credits Points
     *
     * @param points - Course Credits Points
     */
    public void setPoints(int points) {
        // If points is 0 and below - Ignore input
        if (points > 0) {
            this.points = points;
        }
    }
    /**
     * This function return String that describe the Object CourseReport
     * Format:  [<name>, <points>, <grade>]
     *
     * @return String - Describe CourseReport Object
     */
    @Override
    public String toString() {
        String out = "";
        // Add the Object data to string that will return
        out += "[" + this.name + ", " + this.points + ", " + this.grade + "]";
        return out;
    }
    /**
     * This function Check if given Object is equal to this object
     * True only if all the values are equal
     *
     * @param other - Other Object we want to check if this is equal to that object
     *
     * @return boolean - if the objects are equal
     */
    @Override
    public boolean equals(Object other) {
        // Check other isn't null
        if(other == null) return false;
        // Check we don't compare object with himself
        if(other == this) return true;
        // Check we are instance of other CourseReport
        if(!(other instanceof CourseReport)) return false;
        // Check Equals values
        boolean EqualName;
        if(this.name == null || ((CourseReport) other).getName() == null){
            EqualName = this.name == null && ((CourseReport) other).getName() == null;
        }
        else{
            EqualName = this.name.contentEquals(((CourseReport)other).name);
        }
        boolean EqualPoint = this.points == ((CourseReport)other).points;
        boolean EqualGrade = this.grade == ((CourseReport)other).grade;
        // Return if equal
        return EqualName && EqualPoint && EqualGrade;
    }
    /**
     * This function Check if given Object is equal/greater/smaller than the current object
     * By Compare a.compareTo(b):
     * if a>b return 1 - a after b
     * if a=b return 0
     * if a<b return -1 - a before b
     *
     * @param o - Other Object we want to check if this is equal to that object
     *
     * @return int - if equal(0)/greater(1)/smaller(-1)
     */
    @Override
    public int compareTo(CourseReport o) {
        // Check for null object
        if(o == null) return 1; // this is bigger
        // Compare Grade First
        if(this.grade > o.getGrade()) return 1;
        else if(this.grade < o.getGrade()) return -1;
            // If Grade is equal - Compare Points
        else if(this.points > o.getPoints()) return 1;
        else if(this.points < o.getPoints()) return -1;
            // If Grade and Points is equal - Compare Name
        else if (this.name == null && o.name == null) {
            // Both Null - Equal Objects
            return 0;
        }
        // Check if one of the names is Null
        else if(this.name == null || o.name == null){
            if(this.name == null){
                return -1; // other is bigger
            }
            else { // if o.name == null
                return 1; // this is bigger
            }
        }
        return this.name.compareTo(o.name);
    }
    /**
     * Saving to a text file will be done by calling this method
     *
     * @param file - file object we will write to it
     */
	public void saveToTextFile(File file) throws IOException {
        // Check that the file is exist
        if(file == null) return;
        // Protect from exception - let her go
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // write
            writer.write(this.toString());
        }
    }
    // Course Name
    private String name;
    // Course Credits Points
    private int points;
    // Course Grade for Student
    private double grade;
}
