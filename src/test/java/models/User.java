package models;

public class User {
    private String email;
    private String password;


    public static class BuilderUser {
        private Project newProject;

        public static class Builder {
            private User newUser;

            public Builder() {
                newUser = new User();
            }

            public Builder withEmail(String email) {
                newUser.email = email;
                return this;
            }

            public Builder withPassword(String password) {
                newUser.password = password;
                return this;
            }

            public User build() {
                return newUser;
            }

        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
