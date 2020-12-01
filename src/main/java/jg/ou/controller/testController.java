package jg.ou.controller;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import jg.ou.commom.Student;

public class testController {
    
    public static void main(String[] args) throws Exception{
//    	studentDao stuDao = new studentDao();
//    	List<Student> list = stuDao.queryAll();
//    	Student stu = new Student(0,0,12,null,null);
    	Student stu = new Student();
    	checkObjFieldIsNull(stu);
//    	Student stu = new Student();
//    	List<Student> list = stuDao.queryInfoByData(stu);
//    	for(Student item : list ) {
//    		System.out.println(item);
//    	}
    	
    	
	}
    
	public static void checkObjFieldIsNull(Student obj) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		// 第一步:获取操作类
		//Class clazz = obj.getClass();
		// 第二步：获取此类的所有的公共（public）的字段，返回 Field 对象的一个数组
		System.out.println(obj.getClass());
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			
//			// 第三步：获取字段的名称
//			String fieldValue = field.getName();
//			System.out.println(fieldValue);
//			System.out.println(field);
	        String key = field.getName();
	        PropertyDescriptor descriptor = new PropertyDescriptor(key, obj.getClass());
	        Method method = descriptor.getReadMethod();
	        Object value = method.invoke(obj);

	        System.out.println(key + ":" + value);
		}                                                                                                  

//	    boolean flag = false;
//	    for(Field f : obj.getClass().getDeclaredFields()){
//	    	System.out.println(f);
//	        f.setAccessible(true);
//	        System.out.println(f.getName());
//	        if(f.get(obj) == null){
//	            flag = true;
//	            return flag;
//	        }
//	    }
//	    return flag;
	}
}
