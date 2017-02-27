package edu.jxufe.lvxi.blog.core.persist.entity.system;

import java.sql.Timestamp;

/**
 * Created by lvxi on 2017/2/3.
 */
public class UserRoleEntity {
    private long id;
    private long userId;
    private int roleId;
    private Timestamp authorizedDate;
    private Timestamp deadline;
    private long authorizerId;
    private boolean availabale;
    private UserEntity user;
    private RoleEntity role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Timestamp getAuthorizedDate() {
        return authorizedDate;
    }

    public void setAuthorizedDate(Timestamp authorizedDate) {
        this.authorizedDate = authorizedDate;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public long getAuthorizerId() {
        return authorizerId;
    }

    public void setAuthorizerId(long authorizerId) {
        this.authorizerId = authorizerId;
    }

    public boolean isAvailabale() {
        return availabale;
    }

    public void setAvailabale(boolean availabale) {
        this.availabale = availabale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoleEntity that = (UserRoleEntity) o;

        if (userId != that.userId) return false;
        if (roleId != that.roleId) return false;
        if (authorizerId != that.authorizerId) return false;
        if (authorizedDate != null ? !authorizedDate.equals(that.authorizedDate) : that.authorizedDate != null)
            return false;
        if (deadline != null ? !deadline.equals(that.deadline) : that.deadline != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + roleId;
        result = 31 * result + (authorizedDate != null ? authorizedDate.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (int) (authorizerId ^ (authorizerId >>> 32));
        return result;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
