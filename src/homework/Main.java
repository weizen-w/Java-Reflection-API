package homework;

/**
 * 06/09/2023 Java Reflection API
 *
 * @author Wladimir Weizen
 */
public class Main {
  public static void main(String[] args) {
    SqlGenerator sqlGenerator = new SqlGenerator();
    String sqlString = sqlGenerator.generateTable(Staff.class);

    System.out.println(sqlString);
  }
}
