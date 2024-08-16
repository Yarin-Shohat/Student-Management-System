import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * This class represent the registration of a student at the institution, including his grades
 *
 * Attributes:
 *  name: Student Name
 *  id: Student ID
 *  courseReports: Student CourseReport Array
 */
public class Student implements Iterable<CourseReport>, Serializable {
    /**
     * Default Constructor
     *
     * name = null
     * courseReports = null
     * id = 0
     */
    public Student() {
        // Set Default members
        this.name = null;
        this.courseReports = null;
        this.id = 0;
    }
    /**
     * Regular Constructor
     *
     * @param name - Student Name
     * @param id - Student ID
     * @param numOfCourses - Length of Student CourseReport Array
     */
    public Student(String name, int id, int numOfCourses) {
        // Set members
        // # Set name
        this.name = name;
        // # Set courseReports
        numOfCourses = Math.max(0, numOfCourses); // Check numOfCourses is natural number
        this.courseReports = new CourseReport[numOfCourses];
        // Reset the Array
        for (int i = 0; i < numOfCourses; i++) {
            this.courseReports[i] = null;
        }
        // # Set id
        this.id = id;
    }
    /**
     * Copy Constructor
     *
     * @param other - Other Student Object we will copy from it
     */
    public Student(Student other) {
        this();
        if (other != null) {
            // # Set name
            this.name = other.name;
            // # Set id
            this.id = other.id;
            if(other.courseReports != null){
                // # Set courseReports
                this.courseReports = new CourseReport[other.courseReports.length];
                // Copy the Course Reports to new array
                for (int i = 0; i < other.courseReports.length; i++) {
                    this.courseReports[i] = null;
                    // Check we not copy null
                    if(other.courseReports[i] != null) {
                        this.courseReports[i] = new CourseReport(other.courseReports[i]);
                    }
                }
            }
        }
    }
    /**
     * This function return the Student's Name
     *
     * @return String - Student's Name
     */
    public String getName() {
        return this.name;
    }
    /**
     * This function set the Student's Name
     *
     * @param name - Student's Name
     */
    public void setName(String name) {
        // Check name isn't null
        if (name != null) {
            this.name = name;
        }
    }
    /**
     * This function return Student's ID
     *
     * @return int - Student's ID
     */
    public int getId() {
        return this.id;
    }
    /**
     * This function set the Student's ID
     *
     * @param id - Student's ID
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * This function return Student's Course Reports Array
     *
     * @return CourseReport[] - Student's Course Reports Array
     */
    public CourseReport[] getCourseReports() {
        return courseReports;
    }
    /**
     * This function add Course Report to the Student's Course Reports Array
     *
     * @param courseReport - Student's new Course Report
     */
    public void addCourse(CourseReport courseReport) {
        // Check Course Report isn't null
        if (courseReport != null) {
            // Check our courseReports Array isn't null
            if(this.courseReports != null ){
                // Find empty place
                for (int i = 0; i < this.courseReports.length; i++) {
                    if (this.courseReports[i] == null) {
                        // Found empty place!
                        this.courseReports[i] = new CourseReport(courseReport);
                        return;
                    }
                }
            }
        }
    }
    /**
     * This function return Student's Final calculate grade
     * Calculate by Course Points
     * Method can throw AverageCalcException
     *
     * @return double - Student's Course Reports Array
     */
    public double getWeightedAverage() throws AverageCalcException{
        // Check our courseReports Array is null
        if (this.courseReports == null) {
            throw new AverageCalcException(this.name);
        }
        // Check our courseReports Array is 0 length
        if (this.courseReports.length == 0) {
            throw new AverageCalcException(this.name);
        }
        // Sum of grades multiple points
        double totalGrades = 0;
        // Sum of Points
        double totalPoints = 0;
        for (int i = 0; i < this.courseReports.length; i++) {
            // Check the Report isn't null
            if (this.courseReports[i] != null) {
                // Add values
                totalGrades += this.courseReports[i].getGrade() * this.courseReports[i].getPoints();
                totalPoints += this.courseReports[i].getPoints();
            }
        }
        if (totalPoints == 0) { throw new AverageCalcException(this.name); }
        // Return avg
        if(totalGrades / totalPoints > 100) return 100;
        else if (totalGrades / totalPoints < 0) return 0;
        return totalGrades / totalPoints;
    }
    /**
     * This function return the number of CourseReports that the Student has
     *
     * @return int - number of CourseReports
     */
    public int getSizeCourseReports(){
        int size = 0;
        // Check CourseReports arr isn't null
        if (this.courseReports != null) {
            for (int i = 0; i < this.courseReports.length; i++) {
                // Check CourseReports isn't null
                if (this.courseReports[i] != null) {
                    // Add to size
                    size += 1;
                }
            }
        }
        return size;
    }
    /**
     * This function return the number of credits points the student is taking
     * By the courses he toked
     *
     * @return int - Credits Points
     */
    protected int getNumOfPoints() {
        int credits = 0;
        // Check courseReports isn't;t null
        if (this.courseReports != null) {
            for (int i = 0; i < this.courseReports.length; i++) {
                // Check course isn't null
                if (this.courseReports[i] != null) {
                    credits += this.courseReports[i].getPoints();
                }
            }
        }
        return credits;
    }
    /**
     * This function return String that describe the Object CourseReport
     * Format:  <name>: <id> [CourseReport1, CourseReport2, ...]
     *
     * @return String - Describe Student Object
     */
    @Override
    public String toString() {
        String out = "";
        // Add the Object data to string that will return
        out += this.name + ": " + this.id + " [";
        // Add courseReports - Check isn't null
        if(this.courseReports != null){
            for (int i = 0; i < this.courseReports.length; i++) {
                // Check courseReport isn't null
                if(this.courseReports[i] != null){
                    if(i > 0) out += ", ";
                    // Add courseReports String
                    out += this.courseReports[i].toString();
                }
            }
        }
        return out + "]";
    }
    /**
     * This function Check if this object has the same courseReports like other
     * Don't check Backward - Only one Direction
     * Private Function
     *
     * @param other - Other Object we want to check if has all courseReports that this has
     *
     * @return boolean - if other has all courseReports that this has
     */
    private boolean equalsCourseReports(Object other){
        // Check other isn't null
        if(other == null) return false;
        // Check we don't compare object with himself
        if(other == this) return true;
        // Check we are instance of other Student
        if(!(other instanceof Student)) return false;
        // Check if one of the array is null
        boolean this_courseReportsNull = this.courseReports == null;
        boolean other_courseReportsNull = ((Student)other).courseReports == null;
        if(this_courseReportsNull || other_courseReportsNull){
            // If one of them is null, check the other has 0 courses
            boolean SameCourseReportSize = this.getSizeCourseReports() == ((Student) other).getSizeCourseReports();
            return SameCourseReportSize;
        }
        // this and other courseReports arr isn't null
        for(int i = 0; i < this.courseReports.length; i++){
            boolean courseFound = false;
            // Skip the current iteration if this.courseReports[i] is null
            if(this.courseReports[i] == null) continue;
            for(int j = 0; j < ((Student) other).courseReports.length; j++){
                // Skip the current iteration if other.courseReports[j] is null
                if(((Student) other).courseReports[j] == null) continue;
                // Check if the course found
                if(this.courseReports[i].equals(((Student) other).courseReports[j])){
                    // If found, break the inner loop with true value
                    courseFound = true;
                    break;
                }
            }
            // If we don't found the course - They are not equal
            if(!courseFound) return false;
        }
        // If found match to all courseReports from this to other - return true
        return true;
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
        // Check we are instance of other Student
        if(!(other instanceof Student)) return false;
        // Check if one of the names is null
        boolean EqualName = false;
        if(this.name == null || ((Student) other).name == null){
            // Check both null
            EqualName = ((this.name == null) && (((Student) other).name == null));
        }
        else{
            // Both names aren't null
            EqualName = this.name.contentEquals(((Student)other).name);
        }
        boolean EqualId = (this.id == ((Student)other).id);
        boolean EqualCourseReports = (this.equalsCourseReports(other) && ((Student) other).equalsCourseReports(this));
        return EqualName && EqualId && EqualCourseReports;
    }
    /**
     * This function write the student object
     *
     * @param out - Other Object we want to check if this is equal to that object
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        if(out == null) return;
        out.defaultWriteObject(); // Default serialization of non-transient fields
    }
    /**
     * This function read the student object
     *
     * @param in - Other Object we want to check if this is equal to that object
     */
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        if(in == null) return;
        in.defaultReadObject(); // Default deserialization of non-transient fields
        this.id = 0;
    }
    /**
     * This function Iterator over CourseReports
     *
     * @return Iterator - of CourseReports
     */
    @Override
    public Iterator<CourseReport> iterator() {
        return new StudentIterator(this.courseReports);
    }
    // Student's Name
    private String name;
    // Student's ID
    private transient int id;
    // Student's Course Reports Array
    private CourseReport[] courseReports;
    /**
     * Internal Class for Iterator on the courseReports Array
     */
    public static class StudentIterator implements Iterator<CourseReport> {
        // Student's Course Reports Array
        private CourseReport[] courseReports;
        // The next Index to Iterate
        private int nextIndex;
        // The Size of the Array
        private int size;
        /**
         * Iterator Constructor
         *
         * @param courseReports - Student CourseReport Array
         */
        public StudentIterator(CourseReport[] courseReports) {
            this.courseReports = courseReports;
            if(courseReports == null){
                this.size = 0;
            }
            else{
                this.size = courseReports.length;
            }
            this.nextIndex = 0;
        }
        /**
         * This function return True or False if the Iterator has next element(CourseReport)
         *
         * @return boolean - if has next element
         */
        @Override
        public boolean hasNext() {
            // Check we don't iter null array
            if(this.courseReports == null) return false;
            if(this.nextIndex >= this.size) return false;
            // Check the next index is not null
            while(this.nextIndex < this.size && this.courseReports[this.nextIndex] == null){
                this.nextIndex++;
            }
            return this.nextIndex < this.size;
        }
        /**
         * This function return the next item in the Iterator
         * Method can throw NoSuchElementException
         *
         * @return CourseReport - the next object
         */
        @Override
        public CourseReport next() throws NoSuchElementException{
            // Check that has next
            if(this.courseReports == null || !hasNext()) throw  new NoSuchElementException();
            // Get the next
            CourseReport TheNext = this.courseReports[nextIndex];
            nextIndex++; // Increase next index
            return TheNext;
        }
    }
    /**
     * Internal Class for Comparator the AVG Grades
     */
    public static class AverageComparator implements Comparator<Student> {
        /**
         * This function compare 2 Students AVG Grades
         * By Compare compare(Student s1, Student s2):
         * if s1.AVG>s2.AVG return 1
         * if s1.AVG=s2.AVG return 0
         * if s1.AVG<s2.AVG return -1
         *
         * @param s1 - First Students we compare
         * @param s2 - Second Students we compare
         *
         * @return int - if equal(0)/greater(1)/smaller(-1)
         */
        public int compare(Student s1, Student s2) {
            // Check we ain't null
            if(s1 == null || s2 == null){
                if(s1 == null && s2 == null) return 0;
                else if(s1 == null) return -1; // s2 is bigger
                else if(s2 == null) return 1; // s1 is bigger
            }

            // Compare AVG
            if(s1.getWeightedAverage() > s2.getWeightedAverage()){
                return 1;
            }
            else if(s1.getWeightedAverage() < s2.getWeightedAverage()){
                return -1;
            }
            return 0;
        }
    }
    /**
     * Internal Class for Comparator the Points
     */
    public static class CoursePointsComparator implements Comparator<Student> {
        /**
         * This function compare 2 Students Points
         * By Compare compare(Student s1, Student s2):
         * if s1.Points>s2.Points return 1
         * if s1.Points=s2.Points return 0
         * if s1.Points<s2.Points return -1
         *
         * @param s1 - First Students we compare
         * @param s2 - Second Students we compare
         *
         * @return int - if equal(0)/greater(1)/smaller(-1)
         */
        public int compare(Student s1, Student s2) {
            // Check we ain't null
            if(s1 == null || s2 == null){
                if(s1 == null && s2 == null) return 0;
                else if(s1 == null) return -1; // s2 is bigger
                else if(s2 == null) return 1; // s1 is bigger
            }
            // Compare Points
            if(s1.getNumOfPoints() > s2.getNumOfPoints()){
                return 1;
            }
            else if(s1.getNumOfPoints() < s2.getNumOfPoints()){
                return -1;
            }
            return 0;
        }
    }
}