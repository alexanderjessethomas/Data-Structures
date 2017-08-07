/**
 * A Student object which can be inserted into the BST.
 *
 * @author Jean-Paul Labadie
 * @since 11/11/2015
 */
public interface Student {

    /**
     * Initialize a Student object with the given name and gpa.
     * There are no constraints for these values.
     * @param name the students name
     * @param gpa the students gpa
     */
    void init(String name, double gpa);

    //getters and setters for gpa
    double getGPA();
    void setGPA(double gpa);

    // getters and setters for name
    String getName();
    void setName(String name);

    /**
     *
     * @return String "(name:gpa)" sans quotes
     */
    String toString();
}
