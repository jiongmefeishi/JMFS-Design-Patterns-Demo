package me.jmfs.pattern.sdk.command;

import com.google.common.base.Preconditions;
import me.jmfs.pattern.sdk.command.util.AutoTuningLRUCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * implement the interface BeanPostProcessor for loading bean priority
 * 组件容器：实现接口BeanPostProcessor来加载bean优先级
 */
public class ComponentHolder implements PriorityOrdered {

    private ApplicationContext applicationContext;

    private static AutoTuningLRUCache<String, Object> cacheTypeBeanMap = new AutoTuningLRUCache<String, Object>("bean",
        100);
    private static AutoTuningLRUCache<String, Object> cacheNameBeanMap = new AutoTuningLRUCache<String, Object>("bean",
        100);

    public ComponentHolder(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public  <T> T getBeanByType(Class<T> clazz) {
        if (cacheTypeBeanMap.containsKey(clazz.getName())) {
            return (T)cacheTypeBeanMap.get(clazz.getName());
        } else {
            Object bean = applicationContext.getBean(clazz);
            cacheTypeBeanMap.put(clazz.getName(), bean);
            return (T)bean;
        }
    }

    public  Object getBeanByName(String beanName) {
        if (cacheNameBeanMap.containsKey(beanName)) {
            return cacheNameBeanMap.get(beanName);
        } else {
            Object bean = applicationContext.getBean(beanName);
            cacheNameBeanMap.put(beanName, bean);
            return bean;
        }
    }

    public  boolean containsBean(String beanName) {
        return applicationContext.containsBean(beanName);
    }

    public static String buildBeanNameByClassName(String className) {
        Preconditions.checkArgument(!StringUtils.isEmpty(className));
        int n = className.length();
        if (n == 1) {
            return className.toLowerCase();
        } else {
            return className.substring(0, 1).toLowerCase() + className.substring(1, n);
        }
    }

    /**
     * 获取通过注解注入的bean名称列表
     *
     * @param clazz
     * @return
     */
    private List<String> dependencyBeanNames(Class clazz) {
        List<Field> fieldList = new ArrayList<>();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
        }

        List<String> dependencyBeans = new ArrayList<>();
        for (Field field : fieldList) {
            if (field.isAnnotationPresent(Autowired.class)) {
                dependencyBeans.add(field.getName());
            }

            if (field.isAnnotationPresent(Resource.class)) {
                dependencyBeans.add(field.getName());
            }
        }

        return dependencyBeans;
    }

    /**
     * @param clazz
     * @return
     * @since 1.8
     */
    public  boolean isSpringBeanByAnnotation(Class clazz) {
        Annotation[] annotations = clazz.getAnnotationsByType(Component.class);
        if (annotations != null && annotations.length > 0) {
            return true;
        }

        annotations = clazz.getAnnotationsByType(org.springframework.stereotype.Repository.class);
        if (annotations != null && annotations.length > 0) {
            return true;
        }

        annotations = clazz.getAnnotationsByType(org.springframework.stereotype.Service.class);
        if (annotations != null && annotations.length > 0) {
            return true;
        }

        annotations = clazz.getAnnotationsByType(org.springframework.stereotype.Controller.class);
        if (annotations != null && annotations.length > 0) {
            return true;
        }

        return false;
    }

    @Override
    public int getOrder() {
        return -2;
    }
}
