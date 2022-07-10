public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Не задано имя.");
        } else {
            this.name = name;
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalStateException("Не задана фамилия.");
        } else {
            this.surname = surname;
        }
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age <= 0 || age > 123) {
            throw new IllegalStateException("Задано некорректное значение возраста.");
        } else {
            this.age = age;
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }


    public Person build() throws IllegalStateException {
        Person person;
        if (name == null || surname == null) {
            throw new IllegalStateException("Не заданы имя и/или фамилия.");
        }
        if (age >= 0 && address != null) {
            person = new Person(name, surname, age, address);
        } else if (age >= 0) {
            person = new Person(name, surname, age);
        } else if (address != null) {
            person = new Person(name, surname, address);
        } else {
            person = new Person(name, surname);
        }
        return person;
    }


}
