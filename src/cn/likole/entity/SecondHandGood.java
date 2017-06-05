package cn.likole.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by likole on 6/1/2017.
 */
@Entity
@Table(name = "second_hand_good", schema = "e_pingou", catalog = "")
public class SecondHandGood {
    private int gid;
    private String name;
    private String description;
    private Double price;
    private byte sold;
    private int category;
    private Set<SecondHandPicture> pictures;
    private int uid;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "gid")
    public Set<SecondHandPicture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<SecondHandPicture> pictures) {
        this.pictures = pictures;
    }

    @Id
    @Column(name = "gid", nullable = false)
    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }


    @Basic
    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "sold", nullable = false)
    public byte getSold() {
        return sold;
    }

    public void setSold(byte sold) {
        this.sold = sold;
    }

    @Basic
    @Column(name = "category", nullable = false)
    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SecondHandGood that = (SecondHandGood) o;

        if (gid != that.gid) return false;
        if (sold != that.sold) return false;
        if (category != that.category) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (int) sold;
        result = 31 * result + category;
        return result;
    }

    @Basic
    @Column(name = "uid", nullable = false)
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
