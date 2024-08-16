/**
 * This class represent the registration of a student at the institution, including his grades
 * Child Object - Parent is Student, this is BonusStudent
 *
 * Attributes:
 *  name: Student Name
 *  id: Student ID
 *  courseReports: Student CourseReport Array
 *  mult: Bonus points rate
 */
public class BonusStudent extends Student {
    /**
     * Default Constructor
     *
     * name = null
     * courseReports = null
     * id = 0
     * mult = 1
     */
    public BonusStudent() {
        super();
        this.mult = 1;
    }
    /**
     * Regular Constructor
     *
     * @param name - Student Name
     * @param id - Student ID
     * @param numOfCourses - Length of Student CourseReport Array
     * @param mult - Bonus points rate
     */
    public BonusStudent(String name, int id, int numOfCourses, double mult) {
        super(name, id, numOfCourses);
        // Check mult is positive
        if(mult > 0){
            this.mult = mult;
        }
        else{
            this.mult = 1;
        }
    }
    /**
     * Copy Constructor
     *
     * @param other - Other BonusStudent Object we will copy from it
     */
    public BonusStudent(BonusStudent other) {
        super(((Student)other));
        this.mult = 1;
        if(other != null){
            this.mult = other.mult;
        }
    }
    /**
     * This function return the Mult Bonus points rate
     *
     * @return int - Bonus points
     */
    public double getMult() {
        return this.mult;
    }
    /**
     * This function set the Student's Bonus points Mult
     *
     * @param mult - Bonus points
     */
    public void setMult(double mult) {
        // Assert mult is positive
        if(mult > 0){
            this.mult = mult;
        }
    }
    /**
     * This function return Student's Final calculate grade
     * Calculate by Course Points
     *
     * @return double - Student's Course Reports Array
     */
    @Override
    public double getWeightedAverage(){
        // Get AVG from Father
        double avg = super.getWeightedAverage();
        // Calculate the AVG by BonusStudent
        double bonus = Math.floor(this.getNumOfPoints()/10.0) * this.mult;
        // Verify boundaries
        return Math.min(avg + bonus, 100);
    }
    // Mult Bonus Points Rate
    private double mult;
}
