package chatAPP.controllers.viewObject;

public class UserVO {
    private Integer id;
    private String username;
    private String face_image;
    private String face_image_big;
    private String nickname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

}
