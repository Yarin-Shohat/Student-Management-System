import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class Tests2 {
    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    // LIOR
    @Test(expected = NoSuchElementException.class)
    public void studentIteratorNextExceptionTest_1P() {
        Student s = new Student("A",1,2);
        Iterator<CourseReport> it = s.iterator();
        assertFalse("iterator should not have elements",it.hasNext());
        it.next();
    }
    @Test(expected =  AverageCalcException.class)
    public void studentAverageCalcExceptionTest_1P(){
        Student s = new Student("A",1,2);
        s.getWeightedAverage();
    }
    @Test
    public void gradingSystemCorruptedAverageTest_1P(){
        GradingSystem gradingSystem= new GradingSystem("BGU", 2);
        gradingSystem.addStudent(new Student());
        assertEquals("Average should be -1 in case with student who raises exception", -1, gradingSystem.getAverage(),0);
    }
    @Test
    public void corruptedAverageStudentNameTest_1P(){
        Student s = new Student("Adam",1,0);
        try{
            s.getWeightedAverage();
            fail("getWeightedAverage() should have thrown an exception");
        } catch (AverageCalcException ex){
            assertEquals("name do not match", "Adam", ex.getStudentName());
        }
    }
    @Test
    public void exceptionTest_1P(){
        AverageCalcException e = new AverageCalcException("");
        e.getStudentName();
    }

    // Mine
    // Student
    @Test(expected = NoSuchElementException.class)
    public void testStudentIteratorDflt(){
        Student s = new Student();
        Iterator<CourseReport> it = s.iterator();
        it.next();
    }
    @Test(expected = NoSuchElementException.class)
    public void testStudentIteratorReg(){
        Student s = new Student("Dan", 1, 0);
        Iterator<CourseReport> it = s.iterator();
        it.next();
    }
    @Test(expected = NoSuchElementException.class)
    public void testStudentIteratorReg2(){
        Student s = new Student("Dan", 1, 1);
        Iterator<CourseReport> it = s.iterator();
        it.next();
    }
    @Test(expected = NoSuchElementException.class)
    public void testStudentIteratorCopy1(){
        Student s0 = new Student();
        Student s = new Student(s0);
        Iterator<CourseReport> it = s.iterator();
        it.next();
    }
    @Test(expected = NoSuchElementException.class)
    public void testStudentIteratorCopy2(){
        Student s0 = new Student("Dan", 1, 0);
        Student s = new Student(s0);
        Iterator<CourseReport> it = s.iterator();
        it.next();
    }
    @Test(expected = NoSuchElementException.class)
    public void testStudentIteratorCopy3(){
        Student s0 = new Student("Dan", 1, 1);
        Student s = new Student(s0);
        Iterator<CourseReport> it = s.iterator();
        it.next();
    }

    // WithCourse
    CourseReport cs = new CourseReport();
    @Test(expected = NoSuchElementException.class)
    public void testStudentIteratorDfltWithCourse(){
        Student s = new Student();
        s.addCourse(cs);
        Iterator<CourseReport> it = s.iterator();
        it.next();
    }
    @Test(expected = NoSuchElementException.class)
    public void testStudentIteratorRegWithCourse(){
        Student s = new Student("Dan", 1, 0);
        s.addCourse(cs);
        Iterator<CourseReport> it = s.iterator();
        it.next();
    }
    @Test(expected = NoSuchElementException.class)
    public void testStudentIteratorReg2WithCourse(){
        Student s = new Student("Dan", 1, 1);
        s.addCourse(cs);
        Iterator<CourseReport> it = s.iterator();
        it.next();
        it.next();
    }
    @Test(expected = NoSuchElementException.class)
    public void testStudentIteratorCopy1WithCourse(){
        Student s0 = new Student();
        Student s = new Student(s0);
        s.addCourse(cs);
        Iterator<CourseReport> it = s.iterator();
        it.next();
    }
    @Test(expected = NoSuchElementException.class)
    public void testStudentIteratorCopy2WithCourse(){
        Student s0 = new Student("Dan", 1, 0);
        Student s = new Student(s0);
        s.addCourse(cs);
        Iterator<CourseReport> it = s.iterator();
        it.next();
    }
    @Test(expected = NoSuchElementException.class)
    public void testStudentIteratorCopy3WithCourse(){
        Student s0 = new Student("Dan", 1, 1);
        Student s = new Student(s0);
        s.addCourse(cs);
        Iterator<CourseReport> it = s.iterator();
        it.next();
        it.next();
    }

    // AVG:
    @Test(expected = AverageCalcException.class)
    public void testStudentIteratorDfltAVG(){
        Student s = new Student();
        s.getWeightedAverage();
    }
    @Test(expected = AverageCalcException.class)
    public void testStudentIteratorRegAVG(){
        Student s = new Student("Dan", 1, 0);
        s.getWeightedAverage();
    }
    @Test(expected = AverageCalcException.class)
    public void testStudentIteratorReg2AVG(){
        Student s = new Student("Dan", 1, 1);
        s.getWeightedAverage();
    }
    @Test(expected = AverageCalcException.class)
    public void testStudentIteratorCopy1AVG(){
        Student s0 = new Student();
        Student s = new Student(s0);
        s.getWeightedAverage();
    }
    @Test(expected = AverageCalcException.class)
    public void testStudentIteratorCopy2AVG(){
        Student s0 = new Student("Dan", 1, 0);
        Student s = new Student(s0);
        s.getWeightedAverage();
    }
    @Test(expected = AverageCalcException.class)
    public void testStudentIteratorCopy3AVG(){
        Student s0 = new Student("Dan", 1, 1);
        Student s = new Student(s0);
        s.getWeightedAverage();
    }

    // WithCourse
    @Test(expected = AverageCalcException.class)
    public void testStudentIteratorDfltWithCourseAVG(){
        Student s = new Student();
        s.addCourse(cs);
        s.getWeightedAverage();
    }
    @Test(expected = AverageCalcException.class)
    public void testStudentIteratorRegWithCourseAVG(){
        Student s = new Student("Dan", 1, 0);
        s.addCourse(cs);
        s.getWeightedAverage();
    }
    @Test(expected = AverageCalcException.class)
    public void testStudentIteratorReg2WithCourseAVG(){
        Student s = new Student("Dan", 1, 1);
        s.addCourse(cs);
        s.getWeightedAverage();
    }
    @Test(expected = AverageCalcException.class)
    public void testStudentIteratorCopy1WithCourseAVG(){
        Student s0 = new Student();
        Student s = new Student(s0);
        s.addCourse(cs);
        s.getWeightedAverage();
    }
    @Test(expected = AverageCalcException.class)
    public void testStudentIteratorCopy2WithCourseAVG(){
        Student s0 = new Student("Dan", 1, 0);
        Student s = new Student(s0);
        s.addCourse(cs);
        s.getWeightedAverage();
    }
    @Test(expected = AverageCalcException.class)
    public void testStudentIteratorCopy3WithCourseAVG(){
        Student s0 = new Student("Dan", 1, 1);
        Student s = new Student(s0);
        s.addCourse(cs);
        s.getWeightedAverage();
    }

    // AverageCalcException
    @Test
    public void testAverageCalcException(){
        AverageCalcException e = new AverageCalcException("Daniel");
        assertEquals(e.getStudentName(), "Daniel");
        assertTrue(e instanceof RuntimeException);
    }

    // GradingSystem
    @Test
    public void testGradingSystemDflt(){
        GradingSystem gs = new GradingSystem();
        assertEquals("Average should be -1", -1, gs.getAverage(), 0.0001);
    }
    @Test
    public void testGradingSystemReg1(){
        GradingSystem gs = new GradingSystem("BGU", 0);
        assertEquals("Average should be -1", -1, gs.getAverage(), 0.0001);
    }
    @Test
    public void testGradingSystemReg2(){
        GradingSystem gs = new GradingSystem("BGU", 1);
        assertEquals("Average should be -1", -1, gs.getAverage(), 0.0001);
    }
    @Test
    public void testGradingSystemCopy1(){
        GradingSystem gs0 = new GradingSystem();
        GradingSystem gs = new GradingSystem(gs0);
        assertEquals("Average should be -1", -1, gs.getAverage(), 0.0001);
    }
    @Test
    public void testGradingSystemCopy2(){
        GradingSystem gs0 = new GradingSystem("BGU", 0);
        GradingSystem gs = new GradingSystem(gs0);
        assertEquals("Average should be -1", -1, gs.getAverage(), 0.0001);
    }
    @Test
    public void testGradingSystemCopy3(){
        GradingSystem gs0 = new GradingSystem("BGU", 1);
        GradingSystem gs = new GradingSystem(gs0);
        assertEquals("Average should be -1", -1, gs.getAverage(), 0.0001);
    }

    // WithDfltStudents
    Student s1 = new Student();
    Student s2 = new Student();
    @Test
    public void testGradingSystemDfltWithDfltStudents(){
        GradingSystem gs = new GradingSystem();
        gs.addStudent(s1);
        gs.addStudent(s2);
        assertEquals("Average should be -1", -1, gs.getAverage(), 0.0001);
    }
    @Test
    public void testGradingSystemReg1WithDfltStudents(){
        GradingSystem gs = new GradingSystem("BGU", 0);
        gs.addStudent(s1);
        gs.addStudent(s2);
        assertEquals("Average should be -1", -1, gs.getAverage(), 0.0001);
    }
    @Test
    public void testGradingSystemReg2WithDfltStudents(){
        GradingSystem gs = new GradingSystem("BGU", 1);
        gs.addStudent(s1);
        gs.addStudent(s2);
        assertEquals("Average should be -1", -1, gs.getAverage(), 0.0001);
    }
    @Test
    public void testGradingSystemCopy1WithDfltStudents(){
        GradingSystem gs0 = new GradingSystem();
        GradingSystem gs = new GradingSystem(gs0);
        gs.addStudent(s1);
        gs.addStudent(s2);
        assertEquals("Average should be -1", -1, gs.getAverage(), 0.0001);
    }
    @Test
    public void testGradingSystemCopy2WithDfltStudents(){
        GradingSystem gs0 = new GradingSystem("BGU", 0);
        GradingSystem gs = new GradingSystem(gs0);
        gs.addStudent(s1);
        gs.addStudent(s2);
        assertEquals("Average should be -1", -1, gs.getAverage(), 0.0001);
    }
    @Test
    public void testGradingSystemCopy3WithDfltStudents(){
        GradingSystem gs0 = new GradingSystem("BGU", 1);
        GradingSystem gs = new GradingSystem(gs0);
        gs.addStudent(s1);
        gs.addStudent(s2);
        assertEquals("Average should be -1", -1, gs.getAverage(), 0.0001);
    }

    // WithRegStudents
    Student s3 = new Student("Daniel", 1, 2);
    @Test
    public void testGradingSystemDfltWithRegSrudents(){
        GradingSystem gs = new GradingSystem();
        gs.addStudent(s3);
        assertEquals("Average should be -1", -1, gs.getAverage(), 0.0001);
    }
    @Test
    public void testGradingSystemReg1WithRegSrudents(){
        GradingSystem gs = new GradingSystem("BGU", 0);
        gs.addStudent(s3);
        assertEquals("Average should be -1", -1, gs.getAverage(), 0.0001);
    }
    @Test
    public void testGradingSystemReg2WithRegSrudents(){
        GradingSystem gs = new GradingSystem("BGU", 1);
        gs.addStudent(s3);
        assertEquals("Average should be -1", -1, gs.getAverage(), 0.0001);
    }
    @Test
    public void testGradingSystemCopy1WithRegSrudents(){
        GradingSystem gs0 = new GradingSystem();
        GradingSystem gs = new GradingSystem(gs0);
        gs.addStudent(s3);
        assertEquals("Average should be -1", -1, gs.getAverage(), 0.0001);
    }
    @Test
    public void testGradingSystemCopy2WithRegSrudents(){
        GradingSystem gs0 = new GradingSystem("BGU", 0);
        GradingSystem gs = new GradingSystem(gs0);
        gs.addStudent(s3);
        assertEquals("Average should be -1", -1, gs.getAverage(), 0.0001);
    }
    @Test
    public void testGradingSystemCopy3WithRegSrudents(){
        GradingSystem gs0 = new GradingSystem("BGU", 1);
        GradingSystem gs = new GradingSystem(gs0);
        gs.addStudent(s3);
        assertEquals("Average should be -1", -1, gs.getAverage(), 0.0001);
    }

    @Test
    public void testGetAverage() {
        GradingSystem gradingSystem = new GradingSystem("Test University", 2);

        Student student1 = new Student("John Doe", 1, 2);
        student1.addCourse(new CourseReport("Programming Basics", 3, 85.5));
        student1.addCourse(new CourseReport("Data Structures", 4, 78));
        gradingSystem.addStudent(student1);

        Student student2 = new Student("Jane Smith", 2, 3);
        student2.addCourse(new CourseReport("Algorithm Design", 3, 90.0));
        student2.addCourse(new CourseReport("Database Management", 3, 82.5));
        student2.addCourse(new CourseReport("Software Engineering", 4, 88.0));
        gradingSystem.addStudent(student2);

        assertEquals(84.08214, gradingSystem.getAverage(), 0.001);
    }


}
