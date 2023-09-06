package example03;

/**
 * 9/4/2023
 * Java Reflection API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {
    public static void main(String[] args) {
        ObjectCreator creator = new ObjectCreator();
        Bill bill = creator.create(Bill.class);
        Document document = creator.create(Document.class);

        System.out.println(bill);
        System.out.println(document);
    }
}
