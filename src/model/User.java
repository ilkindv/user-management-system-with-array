package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private final long id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private LocalDateTime registrationDate;
    private LocalDateTime updateDate;

    public User(long id, String name, String surname,
                LocalDate birthdate, LocalDateTime registrationDate, LocalDateTime updateDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.registrationDate = registrationDate;
        this.updateDate = updateDate;
    }

    public User(long id, String name, String surname,
                LocalDate birthdate, LocalDateTime registrationDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.registrationDate = registrationDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + birthdate +
                ", registrationDate=" + registrationDate +
                ", updateDate=" + updateDate +
                '}';
    }

    public void getInfo(){
        System.out.println(
                        "---------------------------------\n" +
                         id + ".User" + "\n" +
                        "Name: " + name + "\n" +
                        "Surname: " + surname + "\n" +
                        "Birthdate: " + birthdate + "\n" +
                        "Registration Date: " + registrationDate + "\n" +
                        "---------------------------------");
    }

    public void getInfoWithUpdateDate(){
        System.out.println(
                "---------------------------------\n" +
                        id + ".User" + "\n" +
                        "Name: " + name + "\n" +
                        "Surname: " + surname + "\n" +
                        "Birthdate: " + birthdate + "\n" +
                        "Registration Date: " + registrationDate + "\n" +
                        "Update Date: " + updateDate + "\n" +
                        "---------------------------------");
    }
}
