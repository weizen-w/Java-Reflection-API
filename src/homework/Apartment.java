package homework;

import homework.annotations.*;

import java.util.Objects;

/**
 * 07/09/2023
 * Java Reflection API
 *
 * @author Wladimir Weizen
 */
public class Apartment {

  @Int
  @PrimaryKey
  private long id;
  @Int
  public int area;
  @Int
  public int rooms;
  @Int
  public int floor;
  @Varchar(maxLength = 255)
  @NotNull
  public String city;
  @Varchar(maxLength = 255)
  @NotNull
  public String street;
  @Varchar(maxLength = 255)
  @Unique
  @NotNull
  public String haus;

  public Apartment() {
  }

  public Apartment(int area, int rooms, int floor, String city, String street, String haus) {
    this.area = area;
    this.rooms = rooms;
    this.floor = floor;
    this.city = city;
    this.street = street;
    this.haus = haus;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getArea() {
    return area;
  }

  public void setArea(int area) {
    this.area = area;
  }

  public int getRooms() {
    return rooms;
  }

  public void setRooms(int rooms) {
    this.rooms = rooms;
  }

  public int getFloor() {
    return floor;
  }

  public void setFloor(int floor) {
    this.floor = floor;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getHaus() {
    return haus;
  }

  public void setHaus(String haus) {
    this.haus = haus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Apartment apartment = (Apartment) o;
    return id == apartment.id && area == apartment.area && rooms == apartment.rooms && floor == apartment.floor && Objects.equals(city, apartment.city) && Objects.equals(street, apartment.street) && Objects.equals(haus, apartment.haus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, area, rooms, floor, city, street, haus);
  }

  @Override
  public String toString() {
    return "Apartment{" +
        "id=" + id +
        ", area=" + area +
        ", rooms=" + rooms +
        ", floor=" + floor +
        ", city='" + city + '\'' +
        ", street='" + street + '\'' +
        ", haus='" + haus + '\'' +
        '}';
  }
}
