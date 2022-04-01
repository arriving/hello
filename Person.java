
public class Person {

    String name;

    public Person(String name) {
        this.name = name;
    }

    public void say(String word) {
        System.out.println(this.name + " says: " + word);
    }

}
