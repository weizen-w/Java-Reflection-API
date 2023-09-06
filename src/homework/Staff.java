package homework;

import java.util.Objects;

/**
 * 06/09/2023 Java Reflection API
 *
 * @author Wladimir Weizen
 */
class Staff {
  @Int
  @PrimaryKey
  private long id;
  @Varchar(maxLength = 255)
  @NotNull
  private String name;
  @Varchar(maxLength = 255)
  @Unique
  @NotNull
  private String email;

  public Staff() {
  }

  public Staff(long id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Staff staff = (Staff) o;
    return id == staff.id && Objects.equals(name, staff.name) && Objects.equals(email, staff.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email);
  }

  @Override
  public String toString() {
    return "Staff{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
