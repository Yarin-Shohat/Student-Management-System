/**
 * This class represent RuntimeException called AverageCalcException
 * This class is an exception (and therefore inherits a runtime exception)
 * which is a marking that a student's average cannot be calculated.
 * This class will receive in the constructor the name of the student whose average calculation failed.
 *
 * Attributes:
 *  name: Student Name
 */
public class AverageCalcException extends RuntimeException {
    /**
     * Default Constructor
     *
     * name = ""
     *
     */
    public AverageCalcException() {
        super("AVG failed");
        this.sName = "";
    }
    /**
     * Regular Constructor
     *
     * @param studentName - Student Name that created the Exception
     */
    public AverageCalcException(String studentName) {
        super("AVG failed");
        this.sName = studentName;
    }
    /**
     * Copy Constructor
     *
     * @param other - other AverageCalcException object
     */
    public AverageCalcException(AverageCalcException other) {
        super("AVG failed");
        if(other != null){
            this.sName = other.sName;
        }
    }
    /**
     * This function return the Student's Name that created the Exception
     *
     * @return String - Student's Name that created the Exception
     */
    public String getStudentName() {
        return this.sName;
    }
    // Student's Name that created the Exception
    private String sName;
}