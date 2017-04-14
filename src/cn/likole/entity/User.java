package cn.likole.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by likole on 4/14/2017.
 */
@Entity
public class User {
    private int uid;
    private String nick;
    private String phone;
    private String password;
    private String qq;
    private String avater;
    private String name;
    private Byte phoneValid;

    @Id
    @Column(name = "uid", nullable = false)
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "nick", nullable = true, length = 15)
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 11)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "qq", nullable = true, length = 12)
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Basic
    @Column(name = "avater", nullable = true, length = 100)
    public String getAvater() {
        return avater;
    }

    public void setAvater(String avater) {
        this.avater = avater;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone_valid", nullable = true)
    public Byte getPhoneValid() {
        return phoneValid;
    }

    public void setPhoneValid(Byte phoneValid) {
        this.phoneValid = phoneValid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (uid != user.uid) return false;
        if (nick != null ? !nick.equals(user.nick) : user.nick != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (qq != null ? !qq.equals(user.qq) : user.qq != null) return false;
        if (avater != null ? !avater.equals(user.avater) : user.avater != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (phoneValid != null ? !phoneValid.equals(user.phoneValid) : user.phoneValid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid;
        result = 31 * result + (nick != null ? nick.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (qq != null ? qq.hashCode() : 0);
        result = 31 * result + (avater != null ? avater.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phoneValid != null ? phoneValid.hashCode() : 0);
        return result;
    }
}
