package cn.likole.entity;

import javax.persistence.*;

/**
 * Created by likole on 6/1/2017.
 */
@Entity
@Table(name = "second_hand_picture", schema = "e_pingou", catalog = "")
public class SecondHandPicture {
    private int pid;
    private String name;
    private int gid;

    @Id
    @Column(name = "pid", nullable = false)
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "gid", nullable = false)
    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SecondHandPicture that = (SecondHandPicture) o;

        if (pid != that.pid) return false;
        if (gid != that.gid) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + gid;
        return result;
    }
}
