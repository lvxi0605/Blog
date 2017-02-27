package edu.jxufe.lvxi.blog.core.persist.entity.system;

import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by lvxi on 2017/2/3.
 */
public class ResourceEntity {
    private int id;
    private Integer parentId;
    private String identity;
    private String name;
    private String icon;
    private String description;
    private String url;
    private Timestamp createdDate;
    private long createrId;
    private boolean availabale;
    private Collection<PermissionResourceEntity> permissionResources;
    private ResourceEntity parentResource;
    private Collection<ResourceEntity> childrenResources;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public long getCreaterId() {
        return createrId;
    }

    public void setCreaterId(long createrId) {
        this.createrId = createrId;
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

        ResourceEntity that = (ResourceEntity) o;

        if (id != that.id) return false;
        if (createrId != that.createrId) return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;
        if (identity != null ? !identity.equals(that.identity) : that.identity != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (icon != null ? !icon.equals(that.icon) : that.icon != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (identity != null ? identity.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (int) (createrId ^ (createrId >>> 32));
        return result;
    }

    public Collection<PermissionResourceEntity> getPermissionResources() {
        return permissionResources;
    }

    public void setPermissionResources(Collection<PermissionResourceEntity> permissionResources) {
        this.permissionResources = permissionResources;
    }

    public ResourceEntity getParentResource() {
        return parentResource;
    }

    public void setParentResource(ResourceEntity parentResource) {
        this.parentResource = parentResource;
    }

    public Collection<ResourceEntity> getChildrenResources() {
        return childrenResources;
    }

    public void setChildrenResources(Collection<ResourceEntity> childrenResources) {
        this.childrenResources = childrenResources;
    }
}
