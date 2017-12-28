package com.zbb.common.base.utils.copyproperties;


import java.lang.reflect.Field;
import java.util.*;

/**
 * 属性拷贝
 */
public class DalBeanMapper {

    public static <S,T> T mapTo(S s, Class<T> target){
        if(s == null || target == null) return null;
        try {
            T targetInstance = target.newInstance();
            BeanClass beanClass = BeanClass.getClass(s.getClass(), target); // 获取源对象 目标对象的之间关系
            List<DalValueMapper> dalValueMappers = DalValueMapper.getValues(beanClass);
            for (DalValueMapper valueMapper : dalValueMappers) {
                CopyWay.setPerpoties(s, targetInstance, valueMapper.sourceField, valueMapper.targetField, valueMapper.way);
            }
            return targetInstance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static class DalValueMapper{
        private static final Map<BeanClass, List<DalValueMapper>> map = new HashMap<>();

        private Field sourceField;

        private Field targetField;

        private CopyWay way;

        private DalValueMapper(Field sourceField, Field targetField){
            this.sourceField = sourceField;
            this.targetField = targetField;
            this.way = CopyWay.getWay(sourceField, targetField);
        }

        static List<DalValueMapper>  getValues(BeanClass beanClass){
            List<DalValueMapper> dalValueMappers = new ArrayList<>();
            map.computeIfAbsent(beanClass, k -> {
                List<BeanSet> sourceBeanSets = BeanSet.getBeanSet(beanClass.sourceClass);
                List<BeanSet> targetBeanSets = BeanSet.getBeanSet(beanClass.targetClass);
                for (BeanSet sourceBeanSet : sourceBeanSets) {
                    for (BeanSet targetBeanSet : targetBeanSets) {
                        if(sourceBeanSet.sourceName.equals(targetBeanSet.targetName)){
                            dalValueMappers.add(new DalValueMapper(sourceBeanSet.field, targetBeanSet.field));
                        }
                    }
                }
                return dalValueMappers;
            });
            return dalValueMappers;
        }
    }

    private static class BeanSet{
        private static final Map<Class<?>, List<BeanSet>> Maps = new HashMap<>();

        private Field field;

        private String sourceName;

        private String targetName;

        private BeanSet(Field field, ValueMap valueMap){
            this.field = field;
            field.setAccessible(true); // 反射时 访问私有变量
            if(valueMap == null){
                sourceName = targetName = this.field.getName();
            }else{
                sourceName = "".equals(valueMap.sourceName()) ? "".equals(valueMap.value()) ? field.getName():valueMap.value() : valueMap.sourceName();
                targetName = "".equals(valueMap.targetName()) ? "".equals(valueMap.value()) ? field.getName():valueMap.value() : valueMap.sourceName();
            }
        }

        static List<BeanSet> getBeanSet(Class<?> bclass){
            List<BeanSet> beanSets = new ArrayList<>();
            Maps.computeIfAbsent(bclass, k -> {
                Field[] fields = bclass.getDeclaredFields();
                for (Field field : fields) {
                    beanSets.add(new BeanSet(field,field.getAnnotation(ValueMap.class)));
                }
                return beanSets;
            });
            return beanSets;
        }

    }

    private static class BeanClass{
        private static final List<BeanClass> beanClassList = new ArrayList<>();

        private Class<?> sourceClass;

        private Class<?> targetClass;

        private BeanClass(Class<?> sourceClass, Class<?> targetClass){
            this.sourceClass = sourceClass;
            this.targetClass = targetClass;
        }

        static <S,T> BeanClass getClass(Class<S> sourceClass, Class<T> targetClass){
            for (BeanClass beanClass : beanClassList) {
                if(beanClass.sourceClass.equals(sourceClass) && beanClass.targetClass.equals(targetClass)){
                    return beanClass;
                }
            }
            synchronized (BeanClass.class){
                BeanClass beanClass = new BeanClass(sourceClass, targetClass);
                beanClassList.add(beanClass);
                return beanClass;
            }
        }
    }

}

