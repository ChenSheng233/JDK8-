package com.chensheng.jdk8.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Hello world!
 *
 */
public class Java8Stream 
{
	static Integer result = null;
	
    public static void main( String[] args )
    {
        Integer[] nums = new Integer[] {0,1,2,3,4,5};
        
        Long count = Arrays.stream(nums).count();
        System.out.println(count);
        
        
        List<Integer> list = Arrays.stream(nums).filter(num -> num >2).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(ReflectionToStringBuilder.toString(list,ToStringStyle.MULTI_LINE_STYLE));
    
        // anyMatch方法：在nums数组是否存在任意元素满足 > 2
        boolean anyMatch = Arrays.stream(nums).anyMatch(num -> num >2);
        System.out.println(anyMatch);
        
        // allMatch方法：在nums数组全部元素是否满足 > 0
        boolean allMatch = Arrays.stream(nums).allMatch(num -> num >0);
        System.out.println(allMatch);
        
        // ifPresent方法：在ifPresent实现赋值
        Arrays.stream(nums).findAny().ifPresent(num -> result = num);
        System.out.println(result);
        
        Arrays.stream(nums).filter(num -> num >= 1).findAny().ifPresent(num -> result = num);
        System.out.println(result);
        
        
        list = null;
        list = Arrays.asList(nums);
       
    }


}
