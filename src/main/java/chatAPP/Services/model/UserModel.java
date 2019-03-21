package chatAPP.Services.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserModel {
    private Integer id;
    @NotBlank(message = "username cannot be empty.")
    private String username;
    @NotBlank(message = "password cannot be empty.")
    private String password;
    private String face_image;
    private String face_image_big;
    @NotBlank(message = "nickname cannot be empty.")
    private String nickname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String cid;

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

    public String getFace_image() {
        return face_image;
    }

    public void setFace_image(String face_image) {
        this.face_image = face_image;
    }

    public String getFace_image_big() {
        return face_image_big;
    }

    public void setFace_image_big(String face_image_big) {
        this.face_image_big = face_image_big;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
