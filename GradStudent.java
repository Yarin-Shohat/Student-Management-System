/**
 * This class represent the registration of a student at the institution, including his grades
 * Child Object - Parent is Student, this is GradStudent
 *
 * Attributes:
 *  name: Student Name
 *  id: Student ID
 *  courseReports: Student CourseReport Array
 *  bonus: Bonus points
 */
public class GradStudent extends Student {
    /**
     * Default Constructor
     *
     * name = null
     * courseReports = null
     * id = 0
     * bonus = 0
     */
    public GradStudent() {
        super();
        this.bonus = 0;
    }
    /**
     * Regular Constructor
     *
     * @param name - Student Name
     * @param id - Student ID
     * @param numOfCourses - Length of Student CourseReport Array
     * @param bonus - Bonus points
     */
    public GradStudent(String name, int id, int numOfCourses, double bonus) {
        super(name, id, numOfCourses);
        this.bonus = Math.max(0, bonus);
    }
    /**
     * Copy Constructor
     *
     * @param other - Other Student Object we will copy from it
     */
    public GradStudent(GradStudent other) {
        super(((Student)other));
        this.bonus = 0;
        if(other != null){
            this.bonus = other.bonus;
        }
    }
    /**
     * This function return the Bonus points
     *
     * @return int - Bonus points
     */
    public double getBonus() {
        return this.bonus;
    }
    /**
     * This function set the Student's Bonus points
     *
     * @param bonus - Bonus points
     */
    public void setBonus(double bonus) {
        // Assert bonus is non-negative
        if(bonus >= 0){
            this.bonus = bonus;
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
        // Calculate the AVG by GradStudent
        if(this.getNumOfPoints() >= 10){
            avg = Math.min(avg + bonus, 100);
        }
        else{
            avg = Math.max(avg - bonus, 0);
        }
        return avg;
    }
    // Bonus Points
    private double bonus;
}
