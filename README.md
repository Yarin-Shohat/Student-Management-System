# Student Grades and Course Management System

This repository contains a Java-based application for managing student records, courses, and grades. The system implements key Object-Oriented Programming (OOP) principles, handles exceptions, and includes functionality for file I/O operations such as serialization and deserialization of objects.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
  - [Student Management](#student-management)
  - [Course Management](#course-management)
  - [Grade Calculation](#grade-calculation)
  - [File I/O Operations](#file-i/o-operations)
- [Class Structure and Hierarchy](#class-structure-and-hierarchy)
- [Student Methods](#student-methods)
- [Course Report Methods](#course-report-methods)
- [Exception Handling](#exception-handling)
- [Testing](#testing)

## Introduction

The Student Grades and Course Management System is a comprehensive application designed to manage student records, including course enrollments and grade calculations. The system supports creating and managing student data, courses, and grades while providing robust mechanisms for calculating weighted averages. It leverages Java's serialization features to persist student data and course reports, ensuring that data can be saved and loaded as needed.

## Features

### Student Management
- Create and manage student records with attributes such as name, ID, and courses.
- Add and track courses for each student.
- Calculate weighted averages for student grades.

### Course Management
- Manage course data including course name, credit points, and grades.
- Save course data to text files and load it back into the system.

### Exception Handling
- Implements custom exceptions, such as `AverageCalcException`, to handle errors related to grade calculations.

### File I/O Operations
- Serialize and deserialize student data to/from files.
- Save and load course reports to/from text files.

## Installation

To use the Student Grades and Course Management System, clone the repository and include the relevant Java files in your project.

```bash
git clone https://github.com/YourUsername/Student-Management-System.git
```

Ensure your project is set up to compile and run Java code.

## Usage

### Student Management

```java
import your.package.Student;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("John Doe", 12345, 3);
        student.addCourse(new CourseReport("Math", 3, 95));
        student.addCourse(new CourseReport("History", 4, 85));
        student.addCourse(new CourseReport("Physics", 2, 75));
        
        System.out.println("Weighted Average: " + student.getWeightedAverage());
    }
}
```

### Course Management

```java
import your.package.CourseReport;

public class Main {
    public static void main(String[] args) {
        CourseReport courseReport = new CourseReport("Math", 3, 95);
        File file = new File("course.txt");

        // Save to text file
        courseReport.saveToTextFile(file);

        // Load from text file
        CourseReport loadedCourse = new CourseReport(file);
        
        System.out.println("Course loaded: " + loadedCourse.getName());
    }
}
```

### Grade Calculation

```java
try {
    double average = student.getWeightedAverage();
    System.out.println("Weighted Average: " + average);
} catch (AverageCalcException e) {
    System.err.println("Failed to calculate average for student: " + e.getStudentName());
}
```

### File I/O Operations

```java
// Serialize the student object
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
    oos.writeObject(student);
} catch (IOException e) {
    e.printStackTrace();
}

// Deserialize the student object
Student loadedStudent;
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
    loadedStudent = (Student) ois.readObject();
} catch (IOException | ClassNotFoundException e) {
    e.printStackTrace();
}
```

## Class Structure and Hierarchy

The system is designed with a clear class hierarchy that follows OOP principles. Below is an overview of the class structure, inheritance, and relationships between the classes:

### Inheritance Hierarchy

- **Student**
  - `GradStudent`: Inherits from `Student` and adds functionality or constraints specific to graduate students.
  - `BonusStudent`: Inherits from `Student` and adds functionality related to bonus points.

- **Exception Handling**
  - `AverageCalcException`: Inherits from `RuntimeException` and is used to signal errors in grade calculation.

### Class Relationships

- **Student**
  - **Attributes**:
    - `String name`: The name of the student.
    - `int id`: The student's ID (transient, meaning it won't be serialized).
    - `CourseReport[] courseReports`: An array of `CourseReport` objects that represent the courses the student is enrolled in.
  - **Uses**:
    - `CourseReport`: Each `Student` object has an array of `CourseReport` objects, representing the courses the student is taking.
    - `Student.StudentIterator`: An inner class that implements `Iterator<CourseReport>`, allowing for iteration over the `courseReports`.

- **CourseReport**
  - **Attributes**:
    - `String name`: The name of the course.
    - `int points`: The credit points of the course.
    - `double grade`: The grade achieved in the course.
  - **Uses**:
    - File I/O operations for saving and loading course data.

- **AverageCalcException**
  - **Attributes**:
    - `String sName`: The name of the student for whom the average calculation failed.
  - **Usage**:
    - Thrown by methods in the `Student` class when an issue arises during the calculation of the weighted average.

### Class Interactions

- **Serialization and Deserialization**:
  - The `Student` class implements `Serializable`, allowing it to be serialized to a file. The `id` attribute is marked as transient, meaning it is not included in the serialization process.
  - The `CourseReport` class includes methods for saving course information to a text file and reading it back from a file.

- **Custom Iterators**:
  - The `Student` class includes an inner class `StudentIterator` that allows for iteration over the `courseReports` array, enabling easy traversal of the courses a student is enrolled in.

- **Comparator Implementations**:
  - The `Student` class includes inner classes `AverageComparator` and `CoursePointsComparator`, which implement `Comparator<Student>` for comparing students based on their average grades or the number of course points they have accumulated.

## Student Methods

- `String getName()`: Returns the student's name.
- `void setName(String name)`: Sets the student's name.
- `int getId()`: Returns the student's ID.
- `void setId(int id)`: Sets the student's ID.
- `void addCourse(CourseReport courseReport)`: Adds a course report to the student's list of courses.
- `double getWeightedAverage() throws AverageCalcException`: Calculates and returns the student's weighted average grade.
- `int getSizeCourseReports()`: Returns the number of course reports the student has.
- `String toString()`: Returns a string representation of the student, including their courses.

## Course Report Methods

- `String getName()`: Returns the course name.
- `int getPoints()`: Returns the course credit points.
- `double getGrade()`: Returns the grade for the course.
- `void saveToTextFile(File file) throws IOException`: Saves the course report to a text file.
- `CourseReport(File file) throws IOException`: Constructs a course report from a text file.

## Exception Handling

### AverageCalcException

This custom exception is thrown when there is an issue calculating a student's average grade. It provides the student's name associated with the failed calculation, helping to identify issues in the data or calculation process.

## Testing

The project includes comprehensive JUnit tests located in `Tests1.java`, `Tests2.java`, and `Tests3.java`. These tests cover:

- Object creation and manipulation.
- Serialization and deserialization processes.
- File I/O operations for saving and loading course data.
- Correct implementation of custom exception handling.

These tests ensure that the system works as expected and that edge cases are properly handled.

## Conclusion

This project demonstrates a robust implementation of a student grade and course management system using Java. It leverages OOP principles, custom exception handling, and file I/O operations to provide a complete solution for managing student records and calculating grades.
