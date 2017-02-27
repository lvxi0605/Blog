package edu.jxufe.lvxi.blog.core.persist.entity.article;

import edu.jxufe.lvxi.blog.core.persist.entity.system.UserEntity;

import java.sql.Timestamp;

/**
 * Created by lvxi on 2017/2/3.
 */
public class ArticleCategoryEntity {
    private long id;
    private byte no;
    private String name;
    private String icon;
    private String description;
    private byte isAvailabale;
    private byte isShow;
    private Timestamp createdDate;
    private Long parentId;
    private UserEntity createrUser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte getNo() {
        return no;
    }

    public void setNo(byte no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte getIsAvailabale() {
        return isAvailabale;
    }

    public void setIsAvailabale(byte isAvailabale) {
        this.isAvailabale = isAvailabale;
    }

    public byte getIsShow() {
        return isShow;
    }

    public void setIsShow(byte isShow) {
        this.isShow = isShow;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleCategoryEntity that = (ArticleCategoryEntity) o;

        if (id != that.id) return false;
        if (no != that.no) return false;
        if (isAvailabale != that.isAvailabale) return false;
        if (isShow != that.isShow) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (icon != null ? !icon.equals(that.icon) : that.icon != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) no;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) isAvailabale;
        result = 31 * result + (int) isShow;
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        return result;
    }

    public UserEntity getCreaterUser() {
        return createrUser;
    }

    public void setCreaterUser(UserEntity createrUser) {
        this.createrUser = createrUser;
    }
}
