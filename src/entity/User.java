package entity;

public class User implements Comparable<User> {
    private int userId;
    private String username;
    private String password;
    private char vip;
    private char role;

    public User(int userId, String username, String password, char vip, char role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.vip = vip;
        this.role = role;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getVip() {
        return vip;
    }

    public void setVip(char role) {
        this.vip = vip;
    }

    public char getRole() {
        return role;
    }

    public void setRole(char role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", vip=" + vip +
                ", role=" + role +
                '}';
    }

    @Override
    public int compareTo(User o) {
        if (userId > o.userId) {
            return 1;
        } else if (userId == o.userId) {
            return 0;
        } else {
            return -1;
        }
    }
}
