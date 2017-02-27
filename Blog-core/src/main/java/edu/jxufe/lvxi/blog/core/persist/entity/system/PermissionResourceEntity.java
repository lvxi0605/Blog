package edu.jxufe.lvxi.blog.core.persist.entity.system;

import java.util.Collection;

/**
 * Created by lvxi on 2017/2/3.
 */
public class PermissionResourceEntity {
    private int id;
    private int permissionId;
    private int resourceId;
    private PermissionEntity permission;
    private ResourceEntity resource;
    private Collection<RolePermissionResourceEntity> rolePermissionResources;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermissionResourceEntity that = (PermissionResourceEntity) o;

        if (id != that.id) return false;
        if (permissionId != that.permissionId) return false;
        if (resourceId != that.resourceId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + permissionId;
        result = 31 * result + resourceId;
        return result;
    }

    public PermissionEntity getPermission() {
        return permission;
    }

    public void setPermission(PermissionEntity permission) {
        this.permission = permission;
    }

    public ResourceEntity getResource() {
        return resource;
    }

    public void setResource(ResourceEntity resource) {
        this.resource = resource;
    }

    public Collection<RolePermissionResourceEntity> getRolePermissionResources() {
        return rolePermissionResources;
    }

    public void setRolePermissionResources(Collection<RolePermissionResourceEntity> rolePermissionResources) {
        this.rolePermissionResources = rolePermissionResources;
    }
}
