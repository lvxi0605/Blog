package edu.jxufe.lvxi.blog.core.persist.dao.base;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by lvxi on 2017/2/3.
 */
public class BaseDao<T> {
    private Logger logger = Logger.getLogger(BaseDao.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;
    private Class entityClass;

    public BaseDao() {
        //获取T实体类类型
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    /**
     * 保存对象，返回id
     * @param obj
     * @return
     */
    public Serializable save(T obj){
        return hibernateTemplate.save(obj);
    }

    /**
     * 获取实体对象
     * @param id
     * @return
     */
    public T get(Serializable id){
        return (T) hibernateTemplate.get(entityClass,id);
    }

    /**
     * 查询单个对象
     * @param hql
     * @param param
     * @return
     */
    public Object uniqueQuery(final  String hql, final Object... param){
        return hibernateTemplate.execute(new HibernateCallback<Object>() {
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(hql).setMaxResults(1);
                if (param != null) {
                    for (int i = 0; i < param.length; i++) {
                        query.setParameter(i, param[i]);
                    }
                }
                return query.uniqueResult();
            }
        });
    }

    /**
     * 通过hql查询
     * @param hql HQL查询语句
     * @param param 参数列表
     * @return 查询列表对象
     */
    public List query(String hql, Object... param){
         return hibernateTemplate.find(hql,param);
    }



}
