import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class Tests1 {
    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);
    // ##################### Lior
    //Helpers
    CourseReport GetCourseReport1() {
        return new CourseReport("IOOP", 1, 90);
    }
    CourseReport GetCourseReport2() {
        return new CourseReport("AP", 2, 93);
    }
    CourseReport GetCourseReport3() {
        return new CourseReport("SUMO", 25, 90);
    }
    CourseReport GetCourseReport4() {
        return new CourseReport("SUMO", 24, 90.56);
    }
    GradStudent GetGradStudent() {
        return new GradStudent("Amy Stake", 1, 2, 5);
    }
    BonusStudent GetBonusStudent() {
        return new BonusStudent("Chris P. Bacon", 2, 2, 3);
    }
    Student GetStudent() {
        return new Student("Chris P. Bacon", 2, 3);
    }
    @Test
    public void courseReportEquality_1P() {
        CourseReport c1 = GetCourseReport3();
        CourseReport c2 = GetCourseReport4();
        assertNotEquals("Non-equal courses are reported equals", c1, c2);
    }
    @Test
    public void courseReportToString_1P() {
        CourseReport c2 = GetCourseReport4();
        assertEquals("toString problems", "[SUMO, 24, 90.56]", c2.toString());
    }
    @Test
    public void gradStudentCtr_1P() {
        GradStudent s1 = GetGradStudent();
        assertEquals("incorrect name", "Amy Stake", s1.getName());
        assertEquals("incorrect id", 1, s1.getId());
        assertEquals("incorrect bonus", 5, s1.getBonus(), 0);
    }
    @Test
    public void gradStudentAverage_1P() {
        GradStudent s1 = GetGradStudent();
        s1.addCourse(GetCourseReport1());
        s1.addCourse(GetCourseReport2());
        assertEquals("Grad student average is incorrect", 87, s1.getWeightedAverage(), 0);
    }
    @Test
    public void bonusStudent_1P() {
        BonusStudent s1 = GetBonusStudent();
        assertEquals("incorrect name", "Chris P. Bacon", s1.getName());
        assertEquals("incorrect id", 2, s1.getId());
        assertEquals("incorrect mult", 3, s1.getMult(), 0);
    }
    @Test
    public void bonusStudentAverage_1P() {
        BonusStudent s2 = GetBonusStudent();
        s2.addCourse(GetCourseReport3());
        assertEquals("Bonus student average is incorrect", 96, s2.getWeightedAverage(), 0);
    }
    @Test
    public void studentEquality_1P() {
        Student s1 = GetBonusStudent();
        Student s2 = GetStudent();
        assertTrue("Equal students with no courses are reported not equal", s1.equals(s2) && s2.equals(s1));
        s1.addCourse(GetCourseReport1());
        assertFalse("Students with different courses are reported equal", s1.equals(s2) && s2.equals(s1));
        s1.addCourse(GetCourseReport2());
        s2.addCourse(GetCourseReport2());
        s2.addCourse(GetCourseReport1());
        assertTrue("Students with same courses are reported not equal", s1.equals(s2) && s2.equals(s1));
    }
    @Test
    public void studentToString_1P() {
        Student s1 = GetBonusStudent();
        assertEquals("student toString is wrong", "Chris P. Bacon: 2 []", s1.toString());
        s1.addCourse(GetCourseReport1());
        assertEquals("student toString is wrong", "Chris P. Bacon: 2 [[IOOP, 1, 90.0]]", s1.toString());
        s1.addCourse(GetCourseReport2());
        assertEquals("student toString is wrong", "Chris P. Bacon: 2 [[IOOP, 1, 90.0], [AP, 2, 93.0]]", s1.toString());
    }

    // ################### Mine
    // Helpers
    public CourseReport[] createCourseReports() {
        CourseReport[] courseReports = new CourseReport[5];
        courseReports[0] = new CourseReport("Programming Basics", 3, 85.5);
        courseReports[1] = new CourseReport("Data Structures", 4, 78);
        courseReports[2] = new CourseReport("Algorithm Design", 3, 90.0);
        courseReports[3] = new CourseReport("Database Management", 3, 82.5);
        courseReports[4] = new CourseReport("Software Engineering", 4, 88.0);
        return courseReports;
    }
    public Student[] createStudents() {
        Student[] students = new Student[5];
        students[0] = createStudent1();
        students[1] = createStudent2();
        students[2] = createStudent3();
        students[3] = createStudent4();
        students[4] = createStudent5();
        return students;
    }
    public Student createStudent1() {
        Student student = new Student("John Doe", 1, 2);
        student.addCourse(createCourseReports()[0]);
        student.addCourse(createCourseReports()[1]);
        return student;
    }
    public Student createStudent2() {
        Student student = new Student("Jane Smith", 2, 3);
        student.addCourse(createCourseReports()[0]);
        student.addCourse(createCourseReports()[2]);
        return student;
    }
    public Student createStudent3() {
        Student student = new Student("Alice Johnson", 3, 3);
        student.addCourse(createCourseReports()[1]);
        student.addCourse(createCourseReports()[3]);
        return student;
    }
    public Student createStudent4() {
        Student student = new Student("Bob Brown", 4, 2);
        student.addCourse(createCourseReports()[2]);
        return student;
    }
    public Student createStudent5() {
        Student student = new Student("Emily Davis", 5, 2);
        student.addCourse(createCourseReports()[3]);
        student.addCourse(createCourseReports()[4]);
        return student;
    }
    public GradingSystem[] createGradingSystems() {
        GradingSystem[] gradingSystems = new GradingSystem[5];
        gradingSystems[0] = createGradingSystem1();
        gradingSystems[1] = createGradingSystem2();
        gradingSystems[2] = createGradingSystem3();
        gradingSystems[3] = createGradingSystem4();
        gradingSystems[4] = createGradingSystem5();
        return gradingSystems;
    }
    public GradingSystem createGradingSystem1() {
        GradingSystem gradingSystem = new GradingSystem("University A", 3);
        gradingSystem.addStudent(createStudent1());
        gradingSystem.addStudent(createStudent2());
        return gradingSystem;
    }
    public GradingSystem createGradingSystem2() {
        GradingSystem gradingSystem = new GradingSystem("University B", 2);
        gradingSystem.addStudent(createStudent3());
        return gradingSystem;
    }
    public GradingSystem createGradingSystem3() {
        GradingSystem gradingSystem = new GradingSystem("University C", 2);
        gradingSystem.addStudent(createStudent4());
        return gradingSystem;
    }
    public GradingSystem createGradingSystem4() {
        GradingSystem gradingSystem = new GradingSystem("University D", 1);
        gradingSystem.addStudent(createStudent5());
        return gradingSystem;
    }
    public GradingSystem createGradingSystem5() {
        GradingSystem gradingSystem = new GradingSystem("University E", 1);
        gradingSystem.addStudent(createStudent1());
        gradingSystem.addStudent(createStudent3());
        return gradingSystem;
    }

    CourseReport[] courseReports = createCourseReports();
    Student[] students = createStudents();
    GradingSystem[] gradingSystems = createGradingSystems();

    // CourseReport Class
    @Test
    public void CourseReportTestDefaultCtor(){
        CourseReport cr = new CourseReport();
        assertEquals("incorrect name", null, cr.getName());
        assertEquals("incorrect points", 0, cr.getPoints());
        assertEquals("incorrect grade", 0, cr.getGrade(),0);

    }
    @Test
    public void CourseReportTestCtor(){
        CourseReport cr = new CourseReport("Check Check", 2, 80.5);
        assertEquals("incorrect name", "Check Check", cr.getName());
        assertEquals("incorrect points", 2, cr.getPoints());
        assertEquals("incorrect grade", 80.5, cr.getGrade(),0);
    }
    @Test
    public void CourseReportTestCtor2(){
        CourseReport cr = new CourseReport(null, 2, 80.5);
        assertEquals("incorrect name", null, cr.getName());
        assertEquals("incorrect points", 2, cr.getPoints());
        assertEquals("incorrect grade", 80.5, cr.getGrade(),0);
    }
    @Test
    public void CourseReportTestCopyCtor(){
        // courseReports[0] = new CourseReport("Programming Basics", 3, 85.5);
        CourseReport cr = new CourseReport(courseReports[0]);
        assertEquals("incorrect name", "Programming Basics", cr.getName());
        assertEquals("incorrect points", 3, cr.getPoints());
        assertEquals("incorrect grade", 85.5, cr.getGrade(),0);
    }
    @Test
    public void CourseReportTestCopyCtor2(){
        // courseReports[0] = new CourseReport("Programming Basics", 3, 85.5);
        CourseReport cr = new CourseReport(null, 2, 80.5);
        CourseReport copy = new CourseReport(cr);
        assertEquals("incorrect name", null, copy.getName());
        assertEquals("incorrect points", 2, copy.getPoints());
        assertEquals("incorrect grade", 80.5, copy.getGrade(),0);
    }
    @Test
    public void CourseReportTestSetters(){
        // courseReports[1] = new CourseReport("Data Structures", 4, 78);
        CourseReport cr = new CourseReport(courseReports[1]);
        // Grade
        cr.setGrade(101);
        assertEquals("incorrect grade", 100, cr.getGrade(),0);
        cr.setGrade(-1);
        assertEquals("incorrect grade", 0, cr.getGrade(),0);
        // Points
        cr.setPoints(0);
        assertEquals("incorrect points", 4, cr.getPoints(),0);
        cr.setPoints(-1);
        assertEquals("incorrect points", 4, cr.getPoints(),0);
        // Name
        cr.setName("OOP");
        assertEquals("incorrect name", "OOP", cr.getName());
        cr.setName(null);
        assertEquals("incorrect name", "OOP", cr.getName());
    }
    @Test
    public void CourseReportTestToString(){
        // [Data Structures, 4, 78.0]
        // courseReports[1] = new CourseReport("Data Structures", 4, 78);
        CourseReport cr = new CourseReport(courseReports[1]);
        assertEquals("incorrect ToString", "[Data Structures, 4, 78.0]", cr.toString());
    }
    @Test
    public void CourseReportTestEquals(){
        // courseReports[1] = new CourseReport("Data Structures", 4, 78);
        CourseReport cr = new CourseReport(courseReports[1]);
        CourseReport cr2 = new CourseReport("Data Structures", 4, 78);
        assertTrue("incorrect equals", cr.equals(cr2));
        assertTrue("incorrect equals", cr2.equals(cr));
    }
    @Test
    public void CourseReportTestEquals2(){
        // courseReports[1] = new CourseReport("Data Structures", 4, 78);
        // courseReports[2] = new CourseReport("Algorithm Design", 3, 90.0);
        CourseReport cr = new CourseReport(courseReports[1]);
        CourseReport cr2 = new CourseReport(courseReports[2]);
        assertFalse("incorrect equals", cr.equals(cr2));
        assertFalse("incorrect equals", cr2.equals(cr));
    }
    @Test
    public void CourseReportTestEquals3_Similar(){
        // courseReports[1] = new CourseReport("Data Structures", 4, 78);
        CourseReport cr = new CourseReport(courseReports[1]);
        CourseReport cr2 = new CourseReport("Data Structures", 5, 78);
        assertFalse("incorrect equals", cr.equals(cr2));
        assertFalse("incorrect equals", cr2.equals(cr));
        cr2 = new CourseReport("Data Structures Lior Gay", 4, 78);
        assertFalse("incorrect equals", cr.equals(cr2));
        assertFalse("incorrect equals", cr2.equals(cr));
        cr2 = new CourseReport("Data Structures", 4, 5);
        assertFalse("incorrect equals", cr.equals(cr2));
        assertFalse("incorrect equals", cr2.equals(cr));
    }

    // Student Class
    @Test
    public void StudentTestDefaultCtor(){
        Student s = new Student();
        assertEquals("incorrect name", null, s.getName());
        assertEquals("incorrect getCourseReports", null, s.getCourseReports());
        assertEquals("incorrect grade", 0, s.getId(),0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", null, ex.getStudentName());
        }
        s.addCourse(null);
        s.addCourse(createCourseReports()[0]);
    }
    @Test
    public void StudentTestCtor(){
        /*
        // courseReports[0] = new CourseReport("Programming Basics", 3, 85.5);
        // courseReports[1] = new CourseReport("Data Structures", 4, 78);
        Student student = new Student("John Doe", 1, 2);
        student.addCourse(createCourseReports()[0]);
        student.addCourse(createCourseReports()[1]);
        */
        Student s = new Student("John Doe", 1, 2);
        assertEquals("incorrect name", "John Doe", s.getName());
        assertEquals("incorrect ID", 1, s.getId(),0);
        assertEquals("Incorrect courseReports length", 2, s.getCourseReports().length);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", "John Doe", ex.getStudentName());
        }
    }
    @Test
    public void StudentTestCtor2(){
        /*
        // courseReports[0] = new CourseReport("Programming Basics", 3, 85.5);
        // courseReports[1] = new CourseReport("Data Structures", 4, 78);
        Student student = new Student("John Doe", 1, 2);
        student.addCourse(createCourseReports()[0]);
        student.addCourse(createCourseReports()[1]);
        */
        Student s = new Student(null, 1, 2);
        assertEquals("incorrect name", null, s.getName());
        assertEquals("incorrect ID", 1, s.getId(),0);
        assertEquals("Incorrect courseReports length", 2, s.getCourseReports().length);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", null, ex.getStudentName());
        }
    }
    @Test
    public void StudentTestCopyCtor(){
        // students[0] = new Student("John Doe", 1, 2);
        Student s = new Student(students[0]);
        assertEquals("incorrect name", "John Doe", s.getName());
        assertEquals("incorrect ID", 1, s.getId(),0);
        assertEquals("Incorrect courseReports length", 2, s.getCourseReports().length);
        assertEquals("incorrect avg", 81.21428, s.getWeightedAverage(),0.0001);
        s.addCourse(null);
    }
    @Test
    public void StudentTestCopyCtor2(){
        Student s = new Student(null);
        assertEquals("incorrect name", null, s.getName());
        assertEquals("incorrect getCourseReports", null, s.getCourseReports());
        assertEquals("incorrect grade", 0, s.getId(),0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", null, ex.getStudentName());
        }
        s.addCourse(null);
        s.addCourse(createCourseReports()[0]);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", null, ex.getStudentName());
        }

    }
    @Test
    public void StudentTestCopyCtor3(){
        // students[0] = new Student("John Doe", 1, 2);
        Student s = new Student(new Student());
        assertEquals("incorrect name", null, s.getName());
        assertEquals("incorrect getCourseReports", null, s.getCourseReports());
        assertEquals("incorrect grade", 0, s.getId(),0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", null, ex.getStudentName());
        }
        s.addCourse(null);
        s.addCourse(createCourseReports()[0]);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", null, ex.getStudentName());
        }
    }
    @Test
    public void StudentTestSetters(){
        // students[0] = new Student("John Doe", 1, 2);
        Student s = new Student(students[0]);
        s.setId(123);
        s.setName("Daniel Doe");
        assertEquals("incorrect name", "Daniel Doe", s.getName());
        assertEquals("incorrect ID", 123, s.getId(),0);
        s.setName(null);
        assertEquals("incorrect name", "Daniel Doe", s.getName());
    }
    @Test
    public void StudentTestAddCourseNoPlace(){
    /*  // courseReports[0] = new CourseReport("Programming Basics", 3, 85.5);
        // courseReports[1] = new CourseReport("Data Structures", 4, 78);
        Student student = new Student("John Doe", 1, 2);
        student.addCourse(createCourseReports()[0]);
        student.addCourse(createCourseReports()[1]);
        */
        Student student = new Student("John Doe", 1, 0);
        student.addCourse(createCourseReports()[0]);
        student.addCourse(createCourseReports()[1]);
        try{
            student.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", "John Doe", ex.getStudentName());
        }
    }
    @Test
    public void StudentTestAddCourse(){
    /*  // courseReports[0] = new CourseReport("Programming Basics", 3, 85.5);
        // courseReports[1] = new CourseReport("Data Structures", 4, 78);
        Student student = new Student("John Doe", 1, 2);
        student.addCourse(createCourseReports()[0]);
        student.addCourse(createCourseReports()[1]);
        */
        Student student = new Student("John Doe", 1, 2);
        student.addCourse(null);
        student.addCourse(createCourseReports()[0]);
        assertEquals("incorrect avg", 85.5, student.getWeightedAverage(),0.0001);
        student.addCourse(createCourseReports()[1]);
        assertEquals("incorrect avg", 81.21428, student.getWeightedAverage(),0.0001);
        student.addCourse(createCourseReports()[1]);
        assertEquals("incorrect avg", 81.21428, student.getWeightedAverage(),0.0001);
    }

    // BonusStudent Class
    @Test
    public void BonusStudentTestDefaultCtor(){
        BonusStudent s = new BonusStudent();
        assertEquals("incorrect name", null, s.getName());
        assertEquals("incorrect getCourseReports", null, s.getCourseReports());
        assertEquals("incorrect id", 0, s.getId(),0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", null, ex.getStudentName());
        }
        assertEquals("incorrect mult", 1, s.getMult(),0);
    }
    @Test
    public void BonusStudentTestCtor(){
        BonusStudent s = new BonusStudent("Dani", 123, 1, 2);
        assertEquals("incorrect name", "Dani", s.getName());
        assertEquals("incorrect ID", 123, s.getId(),0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", "Dani", ex.getStudentName());
        }
        assertEquals("incorrect mult", 2, s.getMult(),0);
    }
    @Test
    public void BonusStudentTestCtor2(){
        BonusStudent s = new BonusStudent("Dani", 123, 1, 0);
        assertEquals("incorrect name", "Dani", s.getName());
        assertEquals("incorrect ID", 123, s.getId(),0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", "Dani", ex.getStudentName());
        }
        assertEquals("incorrect mult", 1, s.getMult(),0.0001);
    }
    @Test
    public void BonusStudentTestCtor3(){
        BonusStudent s = new BonusStudent("Dani", 123, -1, -1);
        assertEquals("incorrect name", "Dani", s.getName());
        assertEquals("incorrect ID", 123, s.getId(),0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", "Dani", ex.getStudentName());
        }
        assertEquals("incorrect mult", 1, s.getMult(),0.0001);
    }
    @Test
    public void BonusStudentTestCtor4(){
        BonusStudent s = new BonusStudent(null, 123, 1, 1);
        assertEquals("incorrect name", null, s.getName());
        assertEquals("incorrect ID", 123, s.getId(),0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", null, ex.getStudentName());
        }
        assertEquals("incorrect mult", 1, s.getMult(),0.0001);
    }
    @Test
    public void BonusStudentTestCopyCtor(){
        BonusStudent s = new BonusStudent(null);
        assertEquals("incorrect name", null, s.getName());
        assertEquals("incorrect getCourseReports", null, s.getCourseReports());
        assertEquals("incorrect id", 0, s.getId(),0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", null, ex.getStudentName());
        }
        assertEquals("incorrect mult", 1, s.getMult(),0);
    }
    @Test
    public void BonusStudentTestCopyCtor2(){
        BonusStudent s = new BonusStudent(new BonusStudent());
        assertEquals("incorrect name", null, s.getName());
        assertEquals("incorrect getCourseReports", null, s.getCourseReports());
        assertEquals("incorrect id", 0, s.getId(),0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", null, ex.getStudentName());
        }
        assertEquals("incorrect mult", 1, s.getMult(),0);
    }
    @Test
    public void BonusStudentTestCopyCtor3(){
        BonusStudent s = new BonusStudent("Dani", 123, 0, 1);
        BonusStudent copy = new BonusStudent(s);
        assertEquals("incorrect name", "Dani", copy.getName());
        assertNotEquals("incorrect getCourseReports", null, copy.getCourseReports());
        assertEquals("incorrect id", 123, copy.getId(),0);
        try{
            copy.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", "Dani", ex.getStudentName());
        }
        assertEquals("incorrect mult", 1, copy.getMult(),0);
    }
    @Test
    public void BonusStudentTestCopyCtor4(){
        BonusStudent s = new BonusStudent("Dani", 123, 1, 1);
        BonusStudent copy = new BonusStudent(s);
        assertEquals("incorrect name", "Dani", copy.getName());
        assertNotEquals("incorrect getCourseReports", null, copy.getCourseReports());
        assertEquals("incorrect id", 123, copy.getId(),0);
        try{
            copy.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", "Dani", ex.getStudentName());
        }
        assertEquals("incorrect mult", 1, copy.getMult(),0);
    }
    @Test
    public void BonusStudentTestSetters(){
        BonusStudent s = new BonusStudent();
        s.setName("Dani");
        assertEquals("incorrect name", "Dani", s.getName());
        assertEquals("incorrect getCourseReports", null, s.getCourseReports());
        s.setName(null);
        assertEquals("incorrect name", "Dani", s.getName());
        s.setId(123);
        assertEquals("incorrect id", 123, s.getId(),0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", "Dani", ex.getStudentName());
        }
        s.setMult(20);
        assertEquals("incorrect mult", 20, s.getMult(),0.0001);
        s.setMult(0);
        assertEquals("incorrect mult", 20, s.getMult(),0.0001);
        s.setMult(-1);
        assertEquals("incorrect mult", 20, s.getMult(),0.0001);
    }
    @Test
    public void BonusStudentTestAvg(){
        BonusStudent s = new BonusStudent("Yossi", 456, 4, 2);
        // courseReports[3] = new CourseReport("Database Management", 3, 82.5);
        // courseReports[4] = new CourseReport("Software Engineering", 4, 88.0);
        // courseReports[1] = new CourseReport("Data Structures", 4, 78);
        s.addCourse(courseReports[3]);
        s.addCourse(courseReports[4]);
        assertEquals("incorrect name", "Yossi", s.getName());
        assertEquals("incorrect ID", 456, s.getId(),0);
        assertEquals("incorrect avg", 85.64285, s.getWeightedAverage(),0.0001);
        assertEquals("incorrect mult", 2, s.getMult(),0);
        s.addCourse(courseReports[1]);
        assertEquals("incorrect avg", 84.8636363, s.getWeightedAverage(),0.0001);
    }

    // GradStudent Class
    @Test
    public void GradStudentTestDefaultCtor(){
        GradStudent s = new GradStudent();
        assertEquals("incorrect name", null, s.getName());
        assertEquals("incorrect getCourseReports", null, s.getCourseReports());
        assertEquals("incorrect id", 0, s.getId(),0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", null, ex.getStudentName());
        }
        assertEquals("incorrect bonus", 0, s.getBonus(),0);
    }
    @Test
    public void GradStudentTestCtor(){
        GradStudent s = new GradStudent("Dani", 123, 1, 2);
        assertEquals("incorrect name", "Dani", s.getName());
        assertEquals("incorrect ID", 123, s.getId(),0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", "Dani", ex.getStudentName());
        }
        assertEquals("incorrect bonus", 2, s.getBonus(),0);
    }
    @Test
    public void GradStudentTestCtor2(){
        GradStudent s = new GradStudent("Dani", 123, 1, 0);
        assertEquals("incorrect name", "Dani", s.getName());
        assertEquals("incorrect ID", 123, s.getId(),0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", "Dani", ex.getStudentName());
        }
        assertEquals("incorrect bonus", 0, s.getBonus(),0.0001);
    }
    @Test
    public void GradStudentTestCtor3(){
        GradStudent s = new GradStudent("Dani", 123, -1, -1);
        assertEquals("incorrect name", "Dani", s.getName());
        assertEquals("incorrect ID", 123, s.getId(),0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", "Dani", ex.getStudentName());
        }
        assertEquals("incorrect bonus", 0, s.getBonus(),0.0001);
    }
    @Test
    public void GradStudentTestCtor4(){
        GradStudent s = new GradStudent(null, 123, 1, 1);
        assertEquals("incorrect name", null, s.getName());
        assertEquals("incorrect ID", 123, s.getId(),0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", null, ex.getStudentName());
        }
        assertEquals("incorrect bonus", 1, s.getBonus(),0.0001);
    }
    @Test
    public void GradStudentTestCopyCtor(){
        GradStudent s = new GradStudent(null);
        assertEquals("incorrect name", null, s.getName());
        assertEquals("incorrect getCourseReports", null, s.getCourseReports());
        assertEquals("incorrect id", 0, s.getId(),0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", null, ex.getStudentName());
        }
        assertEquals("incorrect bonus", 0, s.getBonus(),0);
    }
    @Test
    public void GradStudentTestCopyCtor2(){
        GradStudent s = new GradStudent(new GradStudent());
        assertEquals("incorrect name", null, s.getName());
        assertEquals("incorrect getCourseReports", null, s.getCourseReports());
        assertEquals("incorrect id", 0, s.getId(),0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", null, ex.getStudentName());
        }
        assertEquals("incorrect bonus", 0 , s.getBonus(),0);
    }
    @Test
    public void GradStudentTestCopyCtor3(){
        GradStudent s = new GradStudent("Dani", 123, 0, 1);
        GradStudent copy = new GradStudent(s);
        assertEquals("incorrect name", "Dani", copy.getName());
        assertNotEquals("incorrect getCourseReports", null, copy.getCourseReports());
        assertEquals("incorrect id", 123, copy.getId(),0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", "Dani", ex.getStudentName());
        }
        assertEquals("incorrect bonus", 1, copy.getBonus(),0);
    }
    @Test
    public void GradStudentTestCopyCtor4(){
        GradStudent s = new GradStudent("Dani", 123, 1, 1);
        GradStudent copy = new GradStudent(s);
        assertEquals("incorrect name", "Dani", copy.getName());
        assertNotEquals("incorrect getCourseReports", null, copy.getCourseReports());
        assertEquals("incorrect id", 123, copy.getId(),0);
        try{
            copy.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", "Dani", ex.getStudentName());
        }
        assertEquals("incorrect bonus", 1, copy.getBonus(),0);
    }
    @Test
    public void GradStudentTestSetters(){
        GradStudent s = new GradStudent();
        s.setName("Dani");
        assertEquals("incorrect name", "Dani", s.getName());
        assertEquals("incorrect getCourseReports", null, s.getCourseReports());
        s.setName(null);
        assertEquals("incorrect name", "Dani", s.getName());
        s.setId(123);
        assertEquals("incorrect id", 123, s.getId(),0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", "Dani", ex.getStudentName());
        }
        s.setBonus(20);
        assertEquals("incorrect mult", 20, s.getBonus(),0.0001);
        s.setBonus(-1);
        assertEquals("incorrect mult", 20, s.getBonus(),0.0001);
        s.setBonus(20);
        assertEquals("incorrect mult", 20, s.getBonus(),0.0001);
        s.setBonus(0);
        assertEquals("incorrect mult", 0, s.getBonus(),0.0001);
    }
    @Test
    public void GradStudentTestAvg(){
        GradStudent s = new GradStudent("Yossi", 456, 4, 5);
        // courseReports[3] = new CourseReport("Database Management", 3, 82.5);
        // courseReports[4] = new CourseReport("Software Engineering", 4, 88.0);
        // courseReports[1] = new CourseReport("Data Structures", 4, 78);
        s.addCourse(courseReports[3]);
        s.addCourse(courseReports[4]);
        assertEquals("incorrect name", "Yossi", s.getName());
        assertEquals("incorrect ID", 456, s.getId(),0);
        assertEquals("incorrect avg", 80.64285, s.getWeightedAverage(),0.0001);
        assertEquals("incorrect mult", 5, s.getBonus(),0);
        s.addCourse(courseReports[1]);
        assertEquals("incorrect avg", 87.8636363, s.getWeightedAverage(),0.0001);
    }

    // GradingSystem Class
    @Test
    public void GradingSystemTestDefaultCtor(){
        GradingSystem gradingSystem = new GradingSystem();
        assertEquals("incorrect name", null, gradingSystem.getName());
        assertEquals("incorrect students arr", null, gradingSystem.getStudents());
        assertEquals("incorrect avg", -1, gradingSystem.getAverage(),0);
    }
    @Test
    public void GradingSystemTestCtor(){
        GradingSystem gradingSystem = new GradingSystem("University A", 3);
        assertEquals("incorrect name", "University A", gradingSystem.getName());
        assertEquals("incorrect avg", -1, gradingSystem.getAverage(),0);
    }
    @Test
    public void GradingSystemTestCtor2(){
        GradingSystem gradingSystem = new GradingSystem(null, 3);
        assertEquals("incorrect name", null, gradingSystem.getName());
        assertEquals("incorrect avg", -1, gradingSystem.getAverage(),0);
    }
    @Test
    public void GradingSystemTestCopyCtor(){
        GradingSystem gradingSystem = new GradingSystem("University A", 3);
        GradingSystem copy = new GradingSystem(gradingSystem);
        assertEquals("incorrect name", "University A", copy.getName());
        assertEquals("incorrect avg", -1, copy.getAverage(),0);
    }
    @Test
    public void GradingSystemTestSetters(){
        GradingSystem gradingSystem = new GradingSystem("University A", 3);
        gradingSystem.setName("University B");
        assertEquals("incorrect name", "University B", gradingSystem.getName());
        gradingSystem.setName(null);
        assertEquals("incorrect name", "University B", gradingSystem.getName());
    }
    @Test
    public void GradingSystemTestAddCourseNoPlace(){
        GradingSystem gradingSystem = new GradingSystem();
        gradingSystem.addStudent(createStudent1());
        gradingSystem.addStudent(createStudent2());
        assertEquals("incorrect avg", -1, gradingSystem.getAverage(),0);
    }
    @Test
    public void GradingSystemTestAddCourseNoPlace2(){
        GradingSystem gradingSystem = new GradingSystem("University 0", 0);
        gradingSystem.addStudent(createStudent1());
        gradingSystem.addStudent(createStudent2());
        assertEquals("incorrect avg", -1, gradingSystem.getAverage(),0);
    }
    @Test
    public void testGetAverage() {
        GradingSystem gradingSystem = new GradingSystem("Test University", 2);

        // Create some students and add them to the grading system
        Student student1 = new Student("John Doe", 1, 2);
        student1.addCourse(new CourseReport("Programming Basics", 3, 85.5));
        student1.addCourse(new CourseReport("Data Structures", 4, 78));
        gradingSystem.addStudent(student1);

        Student student2 = new Student("Jane Smith", 2, 3);
        student2.addCourse(new CourseReport("Algorithm Design", 3, 90.0));
        student2.addCourse(new CourseReport("Database Management", 3, 82.5));
        student2.addCourse(new CourseReport("Software Engineering", 4, 88.0));
        gradingSystem.addStudent(student2);

        // Test the getAverage() method
        assertEquals(84.08214, gradingSystem.getAverage(), 0.001); // using delta for double comparison
    }

    @Test
    public void testStudentEquals() {
        CourseReport[] courses1 = { new CourseReport("Math", 3, 95), new CourseReport("History", 4, 88) };
        CourseReport[] courses2 = { new CourseReport("Math", 3, 95), new CourseReport("History", 4, 88) };
        CourseReport[] courses3 = { new CourseReport("Math", 3, 85), new CourseReport("History", 4, 78) };

        Student student1 = new Student("John Doe", 123, 3);
        student1.addCourse(courses1[0]);
        student1.addCourse(courses1[1]);
        Student student2 = new Student("John Doe", 123, 4);
        student2.addCourse(courses2[0]);
        student2.addCourse(courses2[1]);
        Student student3 = new Student("Jane Doe", 456, 5);
        student3.addCourse(courses3[0]);
        student3.addCourse(courses3[1]);

        // Reflexive
        assertTrue(student1.equals(student1));

        // Symmetric
        assertTrue(student1.equals(student2));
        assertTrue(student2.equals(student1));

        // Transitive
        Student student4 = new Student("John Doe", 123, 4);
        assertFalse(student2.equals(student4));
        assertFalse(student1.equals(student4));

        student4.addCourse(courses2[0]);
        student4.addCourse(courses2[1]);
        assertTrue(student1.equals(student2));
        assertTrue(student2.equals(student4));
        assertTrue(student1.equals(student4));

        // Different students
        assertFalse(student1.equals(student3));

        // Null comparison
        assertFalse(student1.equals(null));

        // Different object type
        assertFalse(student1.equals("some string"));
    }

    @Test
    public void testBonusStudentEquals() {
        CourseReport[] courses1 = { new CourseReport("Math", 3, 95), new CourseReport("History", 4, 88) };
        CourseReport[] courses2 = { new CourseReport("Math", 3, 95), new CourseReport("History", 4, 88) };
        CourseReport[] courses3 = { new CourseReport("Math", 3, 85), new CourseReport("History", 4, 78) };

        BonusStudent bonusStudent1 = new BonusStudent("John Doe", 123, courses1.length, 2.0);
        bonusStudent1.addCourse(courses1[0]);
        bonusStudent1.addCourse(courses1[1]);
        BonusStudent bonusStudent2 = new BonusStudent("John Doe", 123, courses2.length+2, 2.0);
        bonusStudent2.addCourse(courses2[0]);
        bonusStudent2.addCourse(courses2[1]);
        BonusStudent bonusStudent3 = new BonusStudent("Jane Doe", 456, courses3.length+10, 1.5);
        bonusStudent3.addCourse(courses3[0]);
        bonusStudent3.addCourse(courses3[1]);

        // Reflexive
        assertTrue(bonusStudent1.equals(bonusStudent1));

        // Symmetric
        assertTrue(bonusStudent1.equals(bonusStudent2));
        assertTrue(bonusStudent2.equals(bonusStudent1));

        // Transitive
        BonusStudent bonusStudent4 = new BonusStudent("John Doe", 123, courses1.length+8, 2.0);
        bonusStudent4.addCourse(courses1[0]);
        bonusStudent4.addCourse(courses1[1]);
        assertTrue(bonusStudent1.equals(bonusStudent2));
        assertTrue(bonusStudent2.equals(bonusStudent4));
        assertTrue(bonusStudent1.equals(bonusStudent4));

        // Different students
        assertFalse(bonusStudent1.equals(bonusStudent3));

        // Null comparison
        assertFalse(bonusStudent1.equals(null));

        // Different object type
        assertFalse(bonusStudent1.equals("some string"));
    }

    @Test
    public void testGradStudentEquals() {
        CourseReport[] courses1 = { new CourseReport("Math", 3, 95), new CourseReport("History", 4, 88) };
        CourseReport[] courses2 = { new CourseReport("Math", 3, 95), new CourseReport("History", 4, 88) };
        CourseReport[] courses3 = { new CourseReport("Math", 3, 85), new CourseReport("History", 4, 78) };

        GradStudent gradStudent1 = new GradStudent("John Doe", 123, courses1.length+5, 5.0);
        GradStudent gradStudent2 = new GradStudent("John Doe", 123, courses2.length+3, 5.0);
        GradStudent gradStudent3 = new GradStudent("Jane Doe", 456, courses3.length, 3.0);

        gradStudent1.addCourse(courses1[0]);
        gradStudent1.addCourse(courses1[1]);
        gradStudent2.addCourse(courses2[0]);
        gradStudent2.addCourse(courses2[1]);
        gradStudent3.addCourse(courses3[0]);
        gradStudent3.addCourse(courses3[1]);

        // Reflexive
        assertTrue(gradStudent1.equals(gradStudent1));

        // Symmetric
        assertTrue(gradStudent1.equals(gradStudent2));
        assertTrue(gradStudent2.equals(gradStudent1));

        // Transitive
        GradStudent gradStudent4 = new GradStudent("John Doe", 123, courses1.length, 5.0);
        gradStudent4.addCourse(courses1[0]);
        gradStudent4.addCourse(courses1[1]);
        assertTrue(gradStudent1.equals(gradStudent2));
        assertTrue(gradStudent2.equals(gradStudent4));
        assertTrue(gradStudent1.equals(gradStudent4));

        // Different students
        assertFalse(gradStudent1.equals(gradStudent3));

        // Null comparison
        assertFalse(gradStudent1.equals(null));

        // Different object type
        assertFalse(gradStudent1.equals("some string"));
    }
    @Test
    public void testStudentEqualsWithDifferentIDs() {
        CourseReport[] courses1 = { new CourseReport("Math", 3, 95), new CourseReport("History", 4, 88) };

        Student student1 = new Student("John Doe", 123, 3);
        student1.addCourse(courses1[0]);
        student1.addCourse(courses1[1]);

        Student student2 = new Student("John Doe", 124, 3);
        student2.addCourse(courses1[0]);
        student2.addCourse(courses1[1]);

        assertFalse(student1.equals(student2));
    }

    @Test
    public void testStudentEqualsWithDifferentNames() {
        CourseReport[] courses1 = { new CourseReport("Math", 3, 95), new CourseReport("History", 4, 88) };

        Student student1 = new Student("John Doe", 123, 3);
        student1.addCourse(courses1[0]);
        student1.addCourse(courses1[1]);

        Student student2 = new Student("Jane Doe", 123, 3);
        student2.addCourse(courses1[0]);
        student2.addCourse(courses1[1]);

        assertFalse(student1.equals(student2));
    }

    @Test
    public void testStudentEqualsWithDifferentCourses() {
        CourseReport[] courses1 = { new CourseReport("Math", 3, 95), new CourseReport("History", 4, 88) };
        CourseReport[] courses2 = { new CourseReport("Math", 3, 85), new CourseReport("History", 4, 78) };

        Student student1 = new Student("John Doe", 123, 3);
        student1.addCourse(courses1[0]);
        student1.addCourse(courses1[1]);

        Student student2 = new Student("John Doe", 123, 3);
        student2.addCourse(courses2[0]);
        student2.addCourse(courses2[1]);

        assertFalse(student1.equals(student2));
    }

    @Test
    public void testBonusStudentEqualsWithDifferentMultipliers() {
        CourseReport[] courses1 = { new CourseReport("Math", 3, 95), new CourseReport("History", 4, 88) };

        BonusStudent bonusStudent1 = new BonusStudent("John Doe", 123, courses1.length, 2.0);
        bonusStudent1.addCourse(courses1[0]);
        bonusStudent1.addCourse(courses1[1]);

        BonusStudent bonusStudent2 = new BonusStudent("John Doe", 123, courses1.length, 3.0);
        bonusStudent2.addCourse(courses1[0]);
        bonusStudent2.addCourse(courses1[1]);

        assertTrue(bonusStudent1.equals(bonusStudent2));
    }

    @Test
    public void testGradStudentEqualsWithDifferentBonus() {
        CourseReport[] courses1 = { new CourseReport("Math", 3, 95), new CourseReport("History", 4, 88) };

        GradStudent gradStudent1 = new GradStudent("John Doe", 123, courses1.length + 5, 5.0);
        gradStudent1.addCourse(courses1[0]);
        gradStudent1.addCourse(courses1[1]);

        GradStudent gradStudent2 = new GradStudent("John Doe", 123, courses1.length + 5, 3.0);
        gradStudent2.addCourse(courses1[0]);
        gradStudent2.addCourse(courses1[1]);

        assertTrue(gradStudent1.equals(gradStudent2));
    }

    @Test
    public void testStudentEqualsWithEmptyCourseLists() {
        Student student1 = new Student("John Doe", 123, 3);
        Student student2 = new Student("John Doe", 123, 3);

        assertTrue(student1.equals(student2));

        student1.addCourse(new CourseReport("Math", 3, 95));
        assertFalse(student1.equals(student2));

        student2.addCourse(new CourseReport("Math", 3, 95));
        assertTrue(student1.equals(student2));
    }

    @Test
    public void testBonusStudentEqualsWithDifferentNumberOfCourses() {
        CourseReport[] courses1 = { new CourseReport("Math", 3, 95), new CourseReport("History", 4, 88) };

        BonusStudent bonusStudent1 = new BonusStudent("John Doe", 123, courses1.length, 2.0);
        bonusStudent1.addCourse(courses1[0]);
        bonusStudent1.addCourse(courses1[1]);

        BonusStudent bonusStudent2 = new BonusStudent("John Doe", 123, courses1.length + 1, 2.0);
        bonusStudent2.addCourse(courses1[0]);
        bonusStudent2.addCourse(courses1[1]);
        bonusStudent2.addCourse(new CourseReport("Science", 2, 92));

        assertFalse(bonusStudent1.equals(bonusStudent2));
    }

    @Test
    public void testGradStudentEqualsWithDifferentNumberOfCourses() {
        CourseReport[] courses1 = { new CourseReport("Math", 3, 95), new CourseReport("History", 4, 88) };

        GradStudent gradStudent1 = new GradStudent("John Doe", 123, courses1.length + 5, 5.0);
        gradStudent1.addCourse(courses1[0]);
        gradStudent1.addCourse(courses1[1]);

        GradStudent gradStudent2 = new GradStudent("John Doe", 123, courses1.length + 5, 5.0);
        gradStudent2.addCourse(courses1[0]);
        gradStudent2.addCourse(courses1[1]);
        gradStudent2.addCourse(new CourseReport("Science", 2, 92));

        assertFalse(gradStudent1.equals(gradStudent2));
    }
    @Test
    public void testStudentEqualsWithNullAttributes() {
        Student student1 = new Student(null, 123, 3);
        Student student2 = new Student(null, 123, 3);
        assertTrue(student1.equals(student2));

        student1.addCourse(new CourseReport("Math", 3, 95));
        student2.addCourse(new CourseReport("Math", 3, 95));
        assertTrue(student1.equals(student2));

        student2.setName("John Doe");
        assertFalse(student1.equals(student2));
    }

    @Test
    public void testBonusStudentEqualsWithNullAttributes() {
        BonusStudent bonusStudent1 = new BonusStudent(null, 123, 3, 2.0);
        BonusStudent bonusStudent2 = new BonusStudent(null, 123, 3, 2.0);
        assertTrue(bonusStudent1.equals(bonusStudent2));

        bonusStudent1.addCourse(new CourseReport("Math", 3, 95));
        bonusStudent2.addCourse(new CourseReport("Math", 3, 95));
        assertTrue(bonusStudent1.equals(bonusStudent2));

        bonusStudent2.setName("John Doe");
        assertFalse(bonusStudent1.equals(bonusStudent2));
    }

    @Test
    public void testGradStudentEqualsWithNullAttributes() {
        GradStudent gradStudent1 = new GradStudent(null, 123, 3, 5.0);
        GradStudent gradStudent2 = new GradStudent(null, 123, 3, 5.0);
        assertTrue(gradStudent1.equals(gradStudent2));

        gradStudent1.addCourse(new CourseReport("Math", 3, 95));
        gradStudent2.addCourse(new CourseReport("Math", 3, 95));
        assertTrue(gradStudent1.equals(gradStudent2));

        gradStudent2.setName("John Doe");
        assertFalse(gradStudent1.equals(gradStudent2));
    }

    @Test
    public void testStudentEqualsWithCoursesInDifferentOrder() {
        CourseReport[] courses1 = { new CourseReport("Math", 3, 95), new CourseReport("History", 4, 88) };
        CourseReport[] courses2 = { new CourseReport("History", 4, 88), new CourseReport("Math", 3, 95) };

        Student student1 = new Student("John Doe", 123, 3);
        student1.addCourse(courses1[0]);
        student1.addCourse(courses1[1]);

        Student student2 = new Student("John Doe", 123, 3);
        student2.addCourse(courses2[0]);
        student2.addCourse(courses2[1]);

        assertTrue(student1.equals(student2));
    }

    @Test
    public void testBonusStudentEqualsWithCoursesInDifferentOrder() {
        CourseReport[] courses1 = { new CourseReport("Math", 3, 95), new CourseReport("History", 4, 88) };
        CourseReport[] courses2 = { new CourseReport("History", 4, 88), new CourseReport("Math", 3, 95) };

        BonusStudent bonusStudent1 = new BonusStudent("John Doe", 123, courses1.length, 2.0);
        bonusStudent1.addCourse(courses1[0]);
        bonusStudent1.addCourse(courses1[1]);

        BonusStudent bonusStudent2 = new BonusStudent("John Doe", 123, courses2.length, 2.0);
        bonusStudent2.addCourse(courses2[0]);
        bonusStudent2.addCourse(courses2[1]);

        assertTrue(bonusStudent1.equals(bonusStudent2));
    }

    @Test
    public void testGradStudentEqualsWithCoursesInDifferentOrder() {
        CourseReport[] courses1 = { new CourseReport("Math", 3, 95), new CourseReport("History", 4, 88) };
        CourseReport[] courses2 = { new CourseReport("History", 4, 88), new CourseReport("Math", 3, 95) };

        GradStudent gradStudent1 = new GradStudent("John Doe", 123, courses1.length + 5, 5.0);
        gradStudent1.addCourse(courses1[0]);
        gradStudent1.addCourse(courses1[1]);

        GradStudent gradStudent2 = new GradStudent("John Doe", 123, courses2.length + 5, 5.0);
        gradStudent2.addCourse(courses2[0]);
        gradStudent2.addCourse(courses2[1]);

        assertTrue(gradStudent1.equals(gradStudent2));
    }

    @Test
    public void testStudentEqualsWithSameCoursesButDifferentCredits() {
        CourseReport course = new CourseReport("Math", 3, 95);

        Student student1 = new Student("John Doe", 123, 3);
        student1.addCourse(course);

        Student student2 = new Student("John Doe", 123, 4);
        student2.addCourse(course);

        assertTrue(student1.equals(student2));
    }

    @Test
    public void testBonusStudentEqualsWithSameCoursesButDifferentCredits() {
        CourseReport course = new CourseReport("Math", 3, 95);

        BonusStudent bonusStudent1 = new BonusStudent("John Doe", 123, 3, 2.0);
        bonusStudent1.addCourse(course);

        BonusStudent bonusStudent2 = new BonusStudent("John Doe", 123, 4, 2.0);
        bonusStudent2.addCourse(course);

        assertTrue(bonusStudent1.equals(bonusStudent2));
    }

    @Test
    public void testGradStudentEqualsWithSameCoursesButDifferentCredits() {
        CourseReport course = new CourseReport("Math", 3, 95);

        GradStudent gradStudent1 = new GradStudent("John Doe", 123, 3, 5.0);
        gradStudent1.addCourse(course);

        GradStudent gradStudent2 = new GradStudent("John Doe", 123, 4, 5.0);
        gradStudent2.addCourse(course);

        assertTrue(gradStudent1.equals(gradStudent2));
    }

    @Test
    public void Test1(){
        Student student1 = new Student("John Doe", 123, 3);
        GradStudent student2 = new GradStudent("John Doe", 123, 3, 2.0);
        BonusStudent student3 = new BonusStudent("John Doe", 123, 4, 2.0);
        assertTrue(student1.equals(student2));
        assertTrue(student2.equals(student3));
        assertTrue(student1.equals(student3));

        CourseReport course1 = new CourseReport("Math", 3, 100);
        CourseReport course2 = new CourseReport("Math", 3, 100);
        CourseReport course3 = new CourseReport("Math", 3, 100);
        assertTrue(course1.equals(course2));
        assertTrue(course2.equals(course3));

        GradingSystem gs = new GradingSystem("Something", 10);
        CourseReport course4 = new CourseReport("SC", 3, 50);
        CourseReport course5 = new CourseReport("SCE", 3, 70);
        CourseReport course6 = new CourseReport("aaa", 3, 90);
        CourseReport course7 = new CourseReport("bbb", 3, 68);
        student1.addCourse(course1);
        student1.addCourse(course2);
        student1.addCourse(course3);

        student2.addCourse(course4);
        student2.addCourse(course5);
        student2.addCourse(course6);

        student3.addCourse(course7);
        student3.addCourse(course4);
        student3.addCourse(course5);
        student3.addCourse(course6);

        gs.addStudent(student1);
        gs.addStudent(student2);
        gs.addStudent(student3);

    }

}
