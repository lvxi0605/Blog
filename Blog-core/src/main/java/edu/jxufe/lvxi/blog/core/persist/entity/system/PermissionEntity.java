package edu.jxufe.lvxi.blog.core.persist.entity.system;

import java.util.Collection;

/**
 * Created by lvxi on 2017/2/3.
 */
public class PermissionEntity {
    private int id;
    private String name;
    private String code;
    private String description;
    private boolean availabale;

    public boolean isAvailabale() {
        return availabale;
    }

    public void setAvailabale(boolean availabale) {
        this.availabale = availabale;
    }

    private Collection<PermissionResourceEntity> permissionResources;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermissionEntity that = (PermissionEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Collection<PermissionResourceEntity> getPermissionResources() {
        return permissionResources;
    }

    public void setPermissionResources(Collection<PermissionResourceEntity> permissionResources) {
        this.permissionResources = permissionResources;
    }
}
