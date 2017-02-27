package edu.jxufe.lvxi.blog.core.persist.entity.system;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

/**
 * Created by lvxi on 2017/2/3.
 */
public class UserAuthEntity {
    private long id;
    @NotNull(message = "账户不能为空!")
    @Pattern( regexp = "^[_A-z0-9]{4,30}$" ,message = "用户名要是英文字母,数字,下划线_,长度4-30位。")
    private String account;
    @NotNull(message = "密码不能为空!")
    private String password;
    private String salt;
    private boolean activatedEmail;
    private boolean lockedAccount;
    private Timestamp unlockDate;
    private Timestamp lockedDate;
    private boolean needCaptcha;
    //private UserEntity user;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


    public Timestamp getUnlockDate() {
        return unlockDate;
    }

    public void setUnlockDate(Timestamp unlockDate) {
        this.unlockDate = unlockDate;
    }

    public Timestamp getLockedDate() {
        return lockedDate;
    }

    public void setLockedDate(Timestamp lockedDate) {
        this.lockedDate = lockedDate;
    }

    public boolean isActivatedEmail() {
        return activatedEmail;
    }

    public void setActivatedEmail(boolean activatedEmail) {
        this.activatedEmail = activatedEmail;
    }

    public boolean isLockedAccount() {
        return lockedAccount;
    }

    public void setLockedAccount(boolean lockedAccount) {
        this.lockedAccount = lockedAccount;
    }

    public boolean isNeedCaptcha() {
        return needCaptcha;
    }

    public void setNeedCaptcha(boolean needCaptcha) {
        this.needCaptcha = needCaptcha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAuthEntity that = (UserAuthEntity) o;

        if (id != that.id) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (salt != null ? !salt.equals(that.salt) : that.salt != null) return false;
        if (unlockDate != null ? !unlockDate.equals(that.unlockDate) : that.unlockDate != null) return false;
        if (lockedDate != null ? !lockedDate.equals(that.lockedDate) : that.lockedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (unlockDate != null ? unlockDate.hashCode() : 0);
        result = 31 * result + (lockedDate != null ? lockedDate.hashCode() : 0);
        return result;
    }
/*
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
*/
}
