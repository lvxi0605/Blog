package edu.jxufe.lvxi.blog.core.persist.entity.system;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Future;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by lvxi on 2017/2/3.
 */
public class RoleEntity {
    private Integer id;
    @NotEmpty
    @Length(max = 20)
    private String name;
    @NotEmpty
    @Length(max = 20)
    private String code;
    private String icon;
    @Length(max = 100)
    private String description;
    private boolean availabale;
    private Timestamp createdDate;
    @Future
    private Timestamp deadline;
    private long createrId;
    private UserEntity createrUser;
    private Collection<RolePermissionResourceEntity> rolePermissionResources;
    private Collection<UserRoleEntity> userRoles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public boolean isAvailabale() {
        return availabale;
    }

    public void setAvailabale(boolean availabale) {
        this.availabale = availabale;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public long getCreaterId() {
        return createrId;
    }

    public void setCreaterId(long createrId) {
        this.createrId = createrId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (id != that.id) return false;
        if (createrId != that.createrId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (icon != null ? !icon.equals(that.icon) : that.icon != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (deadline != null ? !deadline.equals(that.deadline) : that.deadline != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id==null?0:id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (int) (createrId ^ (createrId >>> 32));
        return result;
    }

    public UserEntity getCreaterUser() {
        return createrUser;
    }

    public void setCreaterUser(UserEntity createrUser) {
        this.createrUser = createrUser;
    }

    public Collection<RolePermissionResourceEntity> getRolePermissionResources() {
        return rolePermissionResources;
    }

    public void setRolePermissionResources(Collection<RolePermissionResourceEntity> rolePermissionResources) {
        this.rolePermissionResources = rolePermissionResources;
    }

    public Collection<UserRoleEntity> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Collection<UserRoleEntity> userRoles) {
        this.userRoles = userRoles;
    }
}
