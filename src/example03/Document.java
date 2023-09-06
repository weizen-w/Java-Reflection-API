package example03;

import java.time.LocalDate;
import java.util.Objects;

/**
 * 9/4/2023
 * Java Reflection API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Document {

    @DefaultValue("2022-05-13")
    private LocalDate start;

    @DefaultValue("2023-05-13")
    private LocalDate finish;

    public Document() {
    }

    Document(LocalDate start, LocalDate finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "Document{" +
                "start=" + start +
                ", finish=" + finish +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document document)) return false;

        if (!Objects.equals(start, document.start)) return false;
        return Objects.equals(finish, document.finish);
    }

    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (finish != null ? finish.hashCode() : 0);
        return result;
    }
}
