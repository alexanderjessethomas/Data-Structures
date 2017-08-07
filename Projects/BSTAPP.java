
public class BSTAPP {
	public static void main(String[] args){
        MyBinarySearchTree tree = new MyBinarySearchTree();
        MyStudent student = new MyStudent();
        student.setGPA(4.0);
        student.setName("John Doe");
        MyStudent student2 = new MyStudent();
        student.setGPA(4.0);
        student.setName("Crazy Student");
        tree.insert(student2.getGPA(), student2);
        tree.find(3.0);
    }
}
