package user;

import java.util.Objects;

public class UsersConstructor extends Users {

    private String email;
    private String gender;
    private String name;
    private String status;

    public UsersConstructor(String email, String gender, String name, String status) {
        this.email = email;
        this.gender = gender;
        this.name = name;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersConstructor that = (UsersConstructor) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(name, that.name) &&
                Objects.equals(status, that.status);
    }

    @Override
    public String toString() {
        return "UsersConstructor{" +
                "email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
