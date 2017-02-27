package edu.jxufe.lvxi.blog.core.persist.entity.system;

/**
 * Created by lvxi on 2017/2/3.
 */
public class RolePermissionResourceEntity {
    private int id;
    private int permissionResourceId;
    private int roleId;
    private PermissionResourceEntity permissionResource;
    private RoleEntity role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPermissionResourceId() {
        return permissionResourceId;
    }

    public void setPermissionResourceId(int permissionResourceId) {
        this.permissionResourceId = permissionResourceId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolePermissionResourceEntity that = (RolePermissionResourceEntity) o;

        if (id != that.id) return false;
        if (permissionResourceId != that.permissionResourceId) return false;
        if (roleId != that.roleId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + permissionResourceId;
        result = 31 * result + roleId;
        return result;
    }

    public PermissionResourceEntity getPermissionResource() {
        return permissionResource;
    }

    public void setPermissionResource(PermissionResourceEntity permissionResource) {
        this.permissionResource = permissionResource;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
