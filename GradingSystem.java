/**
 * This class represent a database for the records of all students in the institution.
 *
 * Attributes:
 *  name: Institution Name
 *  students: Student's Array of the Institution
 */
public class GradingSystem {
    /**
     * Default Constructor
     *
     * name = null
     * students = null
     */
    public GradingSystem() {
        // Set Default members
        this.name = null;
        this.students = null;
    }
    /**
     * Regular Constructor
     *
     * @param name - Institution Name
     * @param studentCount - Student numbers in the Institution
     */
    public GradingSystem(String name, int studentCount) {
        // Set members
        // # Set name
        this.name = name;
        // # Set students
        studentCount = Math.max(studentCount, 0); // Check studentCount is natural number
        this.students = new Student[studentCount];
        // Reset the Array
        for (int i = 0; i < studentCount; i++) {
            this.students[i] = null;
        }
    }
    /**
     * Copy Constructor
     *
     * @param other - Other GradingSystem Object we will copy from it
     */
    public GradingSystem(GradingSystem other) {
        this();
        if (other != null) {
            // # Set name
            this.name = other.name;
            if(other.students != null){
                // # Set students
                this.students = new Student[other.students.length];
                // Copy the Student to new array
                for (int i = 0; i < other.students.length; i++) {
                    this.students[i] = null;
                    // Check we not copy null
                    if (other.students[i] != null) {
                        // Found empty place! - Check Type
                        Student student = other.students[i];
                        if(student instanceof GradStudent){
                            this.students[i] = new GradStudent((GradStudent)student);
                        }
                        else if(student instanceof BonusStudent){
                            this.students[i] = new BonusStudent((BonusStudent)student);
                        }
                        else{
                            this.students[i] = new Student(student);
                        }
                        return;

                    }
                }
            }
        }
    }
    /**
     * This function return the Institution's Name
     *
     * @return String - Institution's Name
     */
    public String getName() {
        return this.name;
    }
    /**
     * This function set the Institution's Name
     *
     * @param name - Institution's Name
     */
    public void setName(String name) {
        // Check name isn't null
        if (name != null) {
            this.name = name;
        }
    }
    /**
     * This function return Institution's Student's Array
     *
     * @return Student[] - Student's Array
     */
    public Student[] getStudents() {
        return students;
    }
    /**
     * This function add Student to the Student's Array
     *
     * @param student - Student's Array
     */
    public void addStudent(Student student) {
        // Check Student isn't null
        if (student != null) {
            // Check our students Array isn't null
            if(this.students != null){
                // Find empty place
                for (int i = 0; i < this.students.length; i++) {
                    if(this.students[i] == null){
                        // Found empty place! - Check Type
                        if(student instanceof GradStudent){
                            this.students[i] = new GradStudent((GradStudent)student);
                        }
                        else if(student instanceof BonusStudent){
                            this.students[i] = new BonusStudent((BonusStudent)student);
                        }
                        else{
                            this.students[i] = new Student(student);
                        }
                        return;
                    }
                }
            }
        }
    }
    /**
     * This function return Average of all the students Weighted Average
     * Calculate even between all students
     *
     * @return double - Average of all the students
     */
    public double getAverage() {
        // Check our students Array is null
        if(this.students == null){
            return -1;
        }
        // Check our students Array is 0 length
        if(this.students.length == 0){
            return -1;
        }
        // Sum if all Weighted Average
        double sumGrades = 0;
        // Number of students we sum
        int studentsNumber = 0;
        for (int i = 0; i < this.students.length; i++) {
            // Check student isn't null
            if(this.students[i] != null){
                // Add values
                try{
                    sumGrades += this.students[i].getWeightedAverage();
                    studentsNumber++;
                }
                catch(AverageCalcException e){
                    // If got exception, return -1
                    return -1;
                }
            }
        }
        if(studentsNumber == 0){ return -1; }
        // Return avg
        if(sumGrades/studentsNumber > 100){
            // AVG Can't be over 100
            return 100;
        }
        else if (sumGrades/studentsNumber < 0){
            // AVG can't be under 0
            return 0;
        }
        return sumGrades/studentsNumber;
    }
    // Institution's Name
    private String name;
    // Student's Array of the Institution
    private Student[] students;
}
