import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class Tests3 {
    @Test(timeout = 2000)
    public void studentSerializeTest_1P() {
        Student s = new Student("Dad", 1, 2);
        CourseReport cr = new CourseReport("IOOP", 5, 95);
        s.addCourse(cr);
        try (FileOutputStream fileOut = new FileOutputStream("student.dat");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Student loadedStudent;
        try (FileInputStream fileIn = new FileInputStream("student.dat");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            loadedStudent = (Student) in.readObject();
        } catch (IOException | ClassNotFoundException i) {
            throw new RuntimeException(i);
        }

        assertEquals("ID was saved and loaded", 0, loadedStudent.getId());
        assertEquals("Name was saved or loaded improperly", "Dad", loadedStudent.getName());
        assertEquals("array is not in the corrrect size", 2, loadedStudent.getCourseReports().length);
        assertTrue("course was not loaded properly", loadedStudent.getCourseReports()[0].equals(cr));
    }
    @Test(timeout = 2000)
    public void courseReportTextSaveTest_1P() throws IOException {
        File file= new File("c.txt");
        CourseReport cr = new CourseReport("OOP", 5, 95);
        try {
            cr.saveToTextFile(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CourseReport loaded = new CourseReport(file);
        assertTrue("loaded course is not identical to the one printed to file", cr.equals(loaded));
    }

    // MINE
    // Course Report
    @Test
    public void testCourseReportDfltCtor() throws IOException {
        File file= new File("c.txt");
        CourseReport cr = new CourseReport();
        try {
            cr.saveToTextFile(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CourseReport loaded = new CourseReport(file);
        assertTrue("loaded course is not identical to the one printed to file", cr.equals(loaded));
    }
    @Test
    public void testCourseReportCopyDfltCtor() throws IOException {
        File file = new File("c.txt");
        CourseReport cr = new CourseReport(new CourseReport());
        try {
            cr.saveToTextFile(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CourseReport loaded = new CourseReport(file);
        assertTrue("loaded course is not identical to the one printed to file", cr.equals(loaded));
    }
    @Test
    public void testCourseReportCopyCtor() throws IOException {
        File file = new File("c.txt");
        CourseReport cr = new CourseReport(new CourseReport("OOP", 1, 5));
        try {
            cr.saveToTextFile(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CourseReport loaded = new CourseReport(file);
        assertTrue("loaded course is not identical to the one printed to file", cr.equals(loaded));
    }
    @Test
    public void testCourseReportCtor() throws IOException {
        File file = new File("c.txt");
        CourseReport cr = new CourseReport("OOP", 1, 5);
        try {
            cr.saveToTextFile(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CourseReport loaded = new CourseReport(file);
        assertTrue("loaded course is not identical to the one printed to file", cr.equals(loaded));
    }

    // Student
    @Test
    public void testStudentDfltCtor(){
        Student originalStudent = new Student();

        // Serialize the student object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            oos.writeObject(originalStudent);
        } catch (IOException e) {
            fail("Serialization failed: " + e.getMessage());
        }

        // Deserialize the student object
        Student deserializedStudent = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
            deserializedStudent = (Student) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            fail("Deserialization failed: " + e.getMessage());
        }

        // Validate the deserialized object
        assertNotNull(deserializedStudent);
        assertEquals(originalStudent.getName(), deserializedStudent.getName());
        assertEquals(originalStudent.getSizeCourseReports(), deserializedStudent.getSizeCourseReports());
        assertEquals("ID field should be transient and null after deserialization", 0, deserializedStudent.getId());
    }
    @Test
    public void testStudentRegCtor(){
        Student originalStudent = new Student("null", 1, 2);

        // Serialize the student object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            oos.writeObject(originalStudent);
        } catch (IOException e) {
            fail("Serialization failed: " + e.getMessage());
        }

        // Deserialize the student object
        Student deserializedStudent = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
            deserializedStudent = (Student) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            fail("Deserialization failed: " + e.getMessage());
        }

        // Validate the deserialized object
        assertNotNull(deserializedStudent);
        assertEquals(originalStudent.getName(), deserializedStudent.getName());
        assertEquals(originalStudent.getSizeCourseReports(), deserializedStudent.getSizeCourseReports());
        assertEquals("ID field should be transient and null after deserialization", 0, deserializedStudent.getId());
    }
    @Test
    public void testStudentRegCtor2(){
        Student originalStudent = new Student("name1", 1, 2);

        // Serialize the student object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            oos.writeObject(originalStudent);
        } catch (IOException e) {
            fail("Serialization failed: " + e.getMessage());
        }

        // Deserialize the student object
        Student deserializedStudent = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
            deserializedStudent = (Student) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            fail("Deserialization failed: " + e.getMessage());
        }

        // Validate the deserialized object
        assertNotNull(deserializedStudent);
        assertEquals(originalStudent.getName(), deserializedStudent.getName());
        assertEquals(originalStudent.getSizeCourseReports(), deserializedStudent.getSizeCourseReports());
        assertEquals("ID field should be transient and null after deserialization", 0, deserializedStudent.getId());
    }
    @Test
    public void testStudentCopyCtor(){
        Student originalStudent = new Student(new Student());

        // Serialize the student object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            oos.writeObject(originalStudent);
        } catch (IOException e) {
            fail("Serialization failed: " + e.getMessage());
        }

        // Deserialize the student object
        Student deserializedStudent = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
            deserializedStudent = (Student) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            fail("Deserialization failed: " + e.getMessage());
        }

        // Validate the deserialized object
        assertNotNull(deserializedStudent);
        assertEquals(originalStudent.getName(), deserializedStudent.getName());
        assertEquals(originalStudent.getSizeCourseReports(), deserializedStudent.getSizeCourseReports());
        assertEquals("ID field should be transient and null after deserialization", 0, deserializedStudent.getId());
    }

    @Test
    public void testStudentSerialization() {
        Student originalStudent = new Student("John Doe", 12345, 3);
        originalStudent.addCourse(new CourseReport("Math", 3, 95));
        originalStudent.addCourse(new CourseReport("History", 4, 85));
        originalStudent.addCourse(new CourseReport("Physics", 2, 75));

        // Serialize the student object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            oos.writeObject(originalStudent);
        } catch (IOException e) {
            fail("Serialization failed: " + e.getMessage());
        }

        // Deserialize the student object
        Student deserializedStudent = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
            deserializedStudent = (Student) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            fail("Deserialization failed: " + e.getMessage());
        }

        assertNotNull(deserializedStudent);
        // Course
        assertEquals(originalStudent.getCourseReports()[0].getName(), deserializedStudent.getCourseReports()[0].getName());
        assertEquals(originalStudent.getCourseReports()[0].getPoints(), deserializedStudent.getCourseReports()[0].getPoints());
        assertEquals(originalStudent.getCourseReports()[0].getGrade(), deserializedStudent.getCourseReports()[0].getGrade(), 0.001);
        // Student
        assertEquals(originalStudent.getName(), deserializedStudent.getName());
        assertEquals(originalStudent.getCourseReports().length, deserializedStudent.getCourseReports().length);
        assertEquals("ID field should be transient and null after deserialization", 0, deserializedStudent.getId());
    }

    @Test
    public void testCourseReportSaveToTextFile() {
        CourseReport report = new CourseReport("Math", 3, 95);
        File file = new File("c.txt");

        // Save to text file
        try {
            report.saveToTextFile(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CourseReport loaded = new CourseReport(file);
        assertTrue("loaded course is not identical to the one printed to file", report.equals(loaded));
    }

    @Test
    public void testCourseReportFileConstructor() {
        File file = new File("c.txt");

        // Write sample data to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("[Math, 3, 95.0]");
        } catch (IOException e) {
            fail("Writing to text file failed: " + e.getMessage());
        }

        // Use the constructor to read the file
        CourseReport report = null;
        try {
            report = new CourseReport(file);
        } catch (Exception e) {
            fail("Reading from text file failed: " + e.getMessage());
        }

        // Validate the object
        assertNotNull(report);
        assertEquals("Math", report.getName());
        assertEquals(3, report.getPoints());
        assertEquals(95.0, report.getGrade(), 0.001);}

}
