package homework;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("SqlGenerator is works...")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
public class SqlGeneratorTest {

  private SqlGenerator generator;

  @BeforeEach
  public void setUp() {
    generator = new SqlGenerator();
  }

  @DisplayName("create():")
  @Nested
  public class Create {

    @Test
    void return_correct_string_on_staff_class() {
      String expected =
          "CREATE TABLE Staff (" +
              "id INT PRIMARY KEY," +
              " name VARCHAR(255) NOT NULL," +
              " email VARCHAR(255) UNIQUE NOT NULL" +
              ")";
      String actual = generator.generateTable(Staff.class);

      assertEquals(expected, actual);
    }

    @Test
    void return_correct_string_on_apartment_class() {
      String expected =
          "CREATE TABLE Apartment (" +
              "id INT PRIMARY KEY," +
              " area INT," +
              " rooms INT," +
              " floor INT," +
              " city VARCHAR(255) NOT NULL," +
              " street VARCHAR(255) NOT NULL," +
              " haus VARCHAR(255) UNIQUE NOT NULL" +
              ")";
      String actual = generator.generateTable(Apartment.class);

      assertEquals(expected, actual);
    }

    @Test
    void throws_exception_on_class_without_empty_constructor() {
      assertThrows(IllegalArgumentException.class, () -> generator.generateTable(Integer.class));
    }
  }
}
