package example03;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ObjectCreator is works...")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class ObjectCreatorTest {

    private ObjectCreator creator;

    @BeforeEach
    public void setUp() {
        creator = new ObjectCreator();
    }

    @DisplayName("create():")
    @Nested
    public class Create {

        @Test
        void return_correct_object_on_bill_class() {
            Bill expected = new Bill(12345, 86.7, LocalDate.of(2022, 2, 13));
            Bill actual = creator.create(Bill.class);

            assertEquals(expected, actual);
        }

        @Test
        void return_correct_object_on_document_class() {
            Document expected = new Document(LocalDate.of(2022, 5, 13),
                    LocalDate.of(2023, 5, 13));

            Document actual = creator.create(Document.class);
            assertEquals(expected, actual);
        }

        @Test
        void throws_exception_on_class_without_empty_constructor() {
            assertThrows(IllegalArgumentException.class, () -> creator.create(Integer.class));
        }

    }


}