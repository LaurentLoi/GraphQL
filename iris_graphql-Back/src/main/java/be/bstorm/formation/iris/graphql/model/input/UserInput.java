package be.bstorm.formation.iris.graphql.model.input;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class UserInput {
    private String username;
    private String password;
    private String email;

    public String getUsername() {
        return username;
    }

    public UserInput setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserInput setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserInput setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserInput)) return false;
        UserInput userInput = (UserInput) o;
        return Objects.equal(username, userInput.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("username", username)
                .add("password", password)
                .add("email", email)
                .toString();
    }
}
