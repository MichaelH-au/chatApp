package chatAPP.model;

public class Users {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.id
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.username
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.password
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.face_image
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    private String faceImage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.face_image_big
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    private String faceImageBig;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.nickname
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    private String nickname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.qrcode
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    private String qrcode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.cid
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    private String cid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.id
     *
     * @return the value of users.id
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.id
     *
     * @param id the value for users.id
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.username
     *
     * @return the value of users.username
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.username
     *
     * @param username the value for users.username
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.password
     *
     * @return the value of users.password
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.password
     *
     * @param password the value for users.password
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.face_image
     *
     * @return the value of users.face_image
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    public String getFaceImage() {
        return faceImage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.face_image
     *
     * @param faceImage the value for users.face_image
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage == null ? null : faceImage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.face_image_big
     *
     * @return the value of users.face_image_big
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    public String getFaceImageBig() {
        return faceImageBig;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.face_image_big
     *
     * @param faceImageBig the value for users.face_image_big
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    public void setFaceImageBig(String faceImageBig) {
        this.faceImageBig = faceImageBig == null ? null : faceImageBig.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.nickname
     *
     * @return the value of users.nickname
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.nickname
     *
     * @param nickname the value for users.nickname
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.qrcode
     *
     * @return the value of users.qrcode
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    public String getQrcode() {
        return qrcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.qrcode
     *
     * @param qrcode the value for users.qrcode
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.cid
     *
     * @return the value of users.cid
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    public String getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.cid
     *
     * @param cid the value for users.cid
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }
}