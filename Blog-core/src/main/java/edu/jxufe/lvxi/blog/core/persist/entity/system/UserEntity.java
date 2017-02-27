package edu.jxufe.lvxi.blog.core.persist.entity.system;

import edu.jxufe.lvxi.blog.core.persist.entity.article.ArticleCategoryEntity;
import edu.jxufe.lvxi.blog.core.persist.entity.article.ArticleEntity;

import java.util.Collection;

/**
 * Created by lvxi on 2017/2/3.
 */
public class UserEntity {
    private long id;
    private String account;
    private String nickname;
    private String email;
    private byte sex;
    private String icon;
    private String signature;
    private Collection<ArticleEntity> articleArticles;
    private Collection<ArticleCategoryEntity> articleArticleCategories;
    private Collection<RoleEntity> roles;
    private UserAuthEntity userAuth;
    private UserExtendEntity userExtend;
    private Collection<UserRoleEntity> userRoles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (sex != that.sex) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (icon != null ? !icon.equals(that.icon) : that.icon != null) return false;
        if (signature != null ? !signature.equals(that.signature) : that.signature != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) sex;
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (signature != null ? signature.hashCode() : 0);
        return result;
    }

    public Collection<ArticleEntity> getArticleArticles() {
        return articleArticles;
    }

    public void setArticleArticles(Collection<ArticleEntity> articleArticles) {
        this.articleArticles = articleArticles;
    }

    public Collection<ArticleCategoryEntity> getArticleArticleCategories() {
        return articleArticleCategories;
    }

    public void setArticleArticleCategories(Collection<ArticleCategoryEntity> articleArticleCategories) {
        this.articleArticleCategories = articleArticleCategories;
    }

    public Collection<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Collection<RoleEntity> roles) {
        this.roles = roles;
    }

    public UserAuthEntity getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(UserAuthEntity userAuth) {
        this.userAuth = userAuth;
    }

    public UserExtendEntity getUserExtend() {
        return userExtend;
    }

    public void setUserExtend(UserExtendEntity userExtend) {
        this.userExtend = userExtend;
    }

    public Collection<UserRoleEntity> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Collection<UserRoleEntity> userRoles) {
        this.userRoles = userRoles;
    }
}
