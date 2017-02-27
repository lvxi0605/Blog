package edu.jxufe.lvxi.blog.core.persist.entity.article;

import edu.jxufe.lvxi.blog.core.persist.entity.system.UserEntity;

import java.sql.Timestamp;

/**
 * Created by lvxi on 2017/2/3.
 */
public class ArticleEntity {
    private long id;
    private long categoryId;
    private String identity;
    private byte writeType;
    private byte viewLevel;
    private Timestamp createdDate;
    private Timestamp alertDate;
    private String title;
    private String subTitle;
    private String summary;
    private String content;
    private byte alloweCommentLevel;
    private String recommendLevel;
    private long clickCount;
    private long commentCount;
    private long collectCount;
    private long topCount;
    private long downCount;
    private ArticleCategoryEntity articleCategory;
    private UserEntity createUser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public byte getWriteType() {
        return writeType;
    }

    public void setWriteType(byte writeType) {
        this.writeType = writeType;
    }

    public byte getViewLevel() {
        return viewLevel;
    }

    public void setViewLevel(byte viewLevel) {
        this.viewLevel = viewLevel;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(Timestamp alertDate) {
        this.alertDate = alertDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte getAlloweCommentLevel() {
        return alloweCommentLevel;
    }

    public void setAlloweCommentLevel(byte alloweCommentLevel) {
        this.alloweCommentLevel = alloweCommentLevel;
    }

    public String getRecommendLevel() {
        return recommendLevel;
    }

    public void setRecommendLevel(String recommendLevel) {
        this.recommendLevel = recommendLevel;
    }

    public long getClickCount() {
        return clickCount;
    }

    public void setClickCount(long clickCount) {
        this.clickCount = clickCount;
    }

    public long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }

    public long getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(long collectCount) {
        this.collectCount = collectCount;
    }

    public long getTopCount() {
        return topCount;
    }

    public void setTopCount(long topCount) {
        this.topCount = topCount;
    }

    public long getDownCount() {
        return downCount;
    }

    public void setDownCount(long downCount) {
        this.downCount = downCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleEntity that = (ArticleEntity) o;

        if (id != that.id) return false;
        if (categoryId != that.categoryId) return false;
        if (writeType != that.writeType) return false;
        if (viewLevel != that.viewLevel) return false;
        if (alloweCommentLevel != that.alloweCommentLevel) return false;
        if (clickCount != that.clickCount) return false;
        if (commentCount != that.commentCount) return false;
        if (collectCount != that.collectCount) return false;
        if (topCount != that.topCount) return false;
        if (downCount != that.downCount) return false;
        if (identity != null ? !identity.equals(that.identity) : that.identity != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (alertDate != null ? !alertDate.equals(that.alertDate) : that.alertDate != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (subTitle != null ? !subTitle.equals(that.subTitle) : that.subTitle != null) return false;
        if (summary != null ? !summary.equals(that.summary) : that.summary != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (recommendLevel != null ? !recommendLevel.equals(that.recommendLevel) : that.recommendLevel != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (categoryId ^ (categoryId >>> 32));
        result = 31 * result + (identity != null ? identity.hashCode() : 0);
        result = 31 * result + (int) writeType;
        result = 31 * result + (int) viewLevel;
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (alertDate != null ? alertDate.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (subTitle != null ? subTitle.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (int) alloweCommentLevel;
        result = 31 * result + (recommendLevel != null ? recommendLevel.hashCode() : 0);
        result = 31 * result + (int) (clickCount ^ (clickCount >>> 32));
        result = 31 * result + (int) (commentCount ^ (commentCount >>> 32));
        result = 31 * result + (int) (collectCount ^ (collectCount >>> 32));
        result = 31 * result + (int) (topCount ^ (topCount >>> 32));
        result = 31 * result + (int) (downCount ^ (downCount >>> 32));
        return result;
    }

    public ArticleCategoryEntity getArticleCategory() {
        return articleCategory;
    }

    public void setArticleCategory(ArticleCategoryEntity articleCategory) {
        this.articleCategory = articleCategory;
    }

    public UserEntity getCreateUser() {
        return createUser;
    }

    public void setCreateUser(UserEntity createUser) {
        this.createUser = createUser;
    }
}
