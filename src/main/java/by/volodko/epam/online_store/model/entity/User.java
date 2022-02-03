package by.volodko.epam.online_store.model.entity;

public class User {
    private long userId;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String birthdayDate;
    private String comment;
    private Role role;
    private Status status;
    private UserDiscount discount;

    public User() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UserDiscount getDiscount() {
        return discount;
    }
    public void setDiscount(UserDiscount discount) {
        this.discount = discount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        if (birthdayDate != null ? !birthdayDate.equals(user.birthdayDate) : user.birthdayDate != null) return false;
        if (comment != null ? !comment.equals(user.comment) : user.comment != null) return false;
        if (role != user.role) return false;
        if (status != user.status) return false;
        return discount == user.discount;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (birthdayDate != null ? birthdayDate.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("userId=").append(userId);
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", birthdayDate='").append(birthdayDate).append('\'');
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", role=").append(role);
        sb.append(", status=").append(status);
        sb.append(", discount=").append(discount);
        sb.append('}');
        return sb.toString();
    }


    public static class UserBuilder {
        private User user;

        public UserBuilder() {
            user = new User();
        }

        public User build() {
            return user;
        }

        public UserBuilder setId(long id) {
            user.userId = id;
            return this;
        }

        public UserBuilder setLogin(String login) {
            user.login = login;
            return this;
        }

        public UserBuilder setEmail(String email) {
            user.email = email;
            return this;
        }

        public UserBuilder setPassword(String password) {
            user.password = password;
            return this;
        }

        public UserBuilder setName(String name) {
            user.name = name;
            return this;
        }

        public UserBuilder setLastName(String surName) {
            user.surname = surName;
            return this;
        }

        public UserBuilder setPhone(String phone) {
            user.phoneNumber = phone;
            return this;
        }


        public UserBuilder setBirthdayDate(String birthday) {
            user.birthdayDate = birthday;
            return this;
        }

        public UserBuilder setComment(String comment) {
            user.comment = comment;
            return this;
        }

        public UserBuilder setStatus(Status status) {
            user.status = status;
            return this;
        }

        public UserBuilder setRole(Role role) {
            user.role = role;
            return this;
        }
        public UserBuilder setDiscount (UserDiscount discount){
            user.discount = discount;
            return this;
        }

    }
}
