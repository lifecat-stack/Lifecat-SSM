package srsjava.util;
/**
 * @name 时间戳
 * @author ten
 * @description 获得当前时间
 */
public class DateUtil {
 
    public static java.sql.Timestamp d2t(java.util.Date d) {
        if (null == d)
            return null;
        return new java.sql.Timestamp(d.getTime());
    }
 
    public static java.util.Date t2d(java.sql.Timestamp t) {
        if (null == t)
            return null;
        return new java.util.Date(t.getTime());
    }
}