package com.zbb.common.base.utils.copyproperties;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * 源对象与目标对象属性拷贝时的属性对应关系，可扩展
 */
public enum CopyWay {
    N,toString,toInt,toBoolean, timeToDate, calToDate, dateToCal, dateToTime;

    public static CopyWay getWay(Field sourceField, Field targetField){
        String sField = sourceField.getType().getSimpleName();
        String tField = targetField.getType().getSimpleName();
        if("int".equals(tField) || "Integer".equals(tField) ){
            return toInt;
        }else if("String".equals(tField)){
            return toString;
        }else if("Date".equals(tField) && "Calendar".equals(sField)){
            return calToDate;
        }else if("Date".equals(tField) && "Timestamp".equals(sField)){
            return timeToDate;
        }else if("Boolean".equals(tField) && ("Integer".equals(sField)|| "int".equals(sField))){
            return toBoolean;
        }else{
            return N;
        }


    }

    public static void setPerpoties(Object source, Object targetInstance, Field sourceField, Field targetField, CopyWay way) {
        try {
            Object object = sourceField.get(source);
            if(object == null) return;
            switch(way){
                case N:
                    targetField.set(targetInstance, object);
                    break;
                case toString:
                    targetField.set(targetInstance, String.valueOf(object));
                    break;
                case calToDate:
                    Calendar calendar = (Calendar)object;
                    targetField.set(targetInstance, calendar.getTime());
                    break;
                case timeToDate:
                    Timestamp timestamp =  (Timestamp) object;
                    targetField.set(targetInstance, new Date(timestamp.getTime()));
                case toInt:
                    targetField.set(targetInstance, Integer.valueOf(object.toString()));
                    break;
                case toBoolean:
                    targetField.set(targetInstance, Integer.valueOf(object.toString())==1 ? Boolean.valueOf(true) : Boolean.valueOf(false));
                    break;
                default:
                    break;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
