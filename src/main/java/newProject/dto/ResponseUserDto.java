package newProject.dto;

import newProject.domain.UserState;

public class ResponseUserDto {
    private Long id;
    private String username;
    private String password;
    private UserState state;

    public ResponseUserDto(Long id, String username, UserState state) {
        this.id = id;
        this.username = username;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }
}
