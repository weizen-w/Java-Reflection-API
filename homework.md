## Homework

* Пример создания таблицы на SQL

```
CREATE TABLE Staff
(
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);
```

* id - идентификатор строки
* name - имя, не может быть null (пустым)
* email - почта, должна быть уникальной для всех строк и не быть null

## Что нужно сделать?

* Предусмотреть аннотации `@PrimaryKey`, `@Varchar(maxLength)`, `@Unique`, `@NotNull`
* Описать класс `Stuff`:

```
class Staff {
    @PrimaryKey
    private long id;
    
    @Varchar(maxLength = 255)
    @NotNull
    private String name;
    
    @NotNull
    @Unique
    private String email;
}
```

* Создать класс SqlGenerator
* Предусмотреть в нем метод 

```
public String generateTable(Class<?> tableClass);
```

* Если данному методу передать класс Staff, то он должен вернуть SQL-строку с созданием таблицы.
* Написать тест для двух разных классов, например, Staff и Apartment