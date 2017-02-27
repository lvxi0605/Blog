package edu.jxufe.lvxi.blog.web.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

/**
 * Created by lvxi on 2017/2/9.
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
//        String username = (String) token.getPrincipal();
//
//        Element element = passwordRetryCache.get(username);
//        if(element == null) {
//            element = new Element(username , new AtomicInteger(0));
//            passwordRetryCache.put(element);
//        }
//        AtomicInteger retryCount = (AtomicInteger)element.getObjectValue();
//        if(retryCount.incrementAndGet() > 5) {
////if retry count > 5 throw
//            throw new ExcessiveAttemptsException();
//        }
        boolean matches = super.doCredentialsMatch(token, info);
//        if(matches) {
////clear retry count
//            passwordRetryCache.remove(username);
//        }
        return matches;
    }
}
