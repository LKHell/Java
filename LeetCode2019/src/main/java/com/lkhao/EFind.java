package com.lkhao;

import com.lkhao.eo.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * describe:
 *
 * @author 李坤澔
 *     date 2019-11-25
 */
public class EFind {
    private List<Employee> find(List<Employee> in, List<Employee> all) {
        List<Employee> result;

        Map<String, Employee> resultMap
            = new HashMap<>();
        for (Employee employee : in) {
            resultMap.put(employee.getId(), employee);
        }

        result = all.stream()
                    .filter(eo -> !resultMap.containsKey(eo.getId()))
                    .collect(Collectors.toList());
        return result;
    }
    @Test
    public void a(){
        Employee e = new Employee();
        e.setId("1");
        System.out.println(e.getId());
    }

    @Test
    public void BooleanHashCode(){
        Boolean x  = true;
        Character y = 1231;
        System.out.println(x.hashCode());
        x=false;
        System.out.println(y.hashCode()+" "+y);


        String originalString = "howtodoinjava";

//Replace one character
        System.out.println( originalString.replace("h", "H") );         //Howtodoinjava

//Replace all matching characters
        System.out.println( originalString.replace("o", "O") );
        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());
        System.out.println("C#".hashCode());
//Remove one character
        System.out.println( originalString.replace("h", "") );         //owtodoinjava

//Remove all matching characters
        System.out.println( originalString.replace("o", "") );         //hwtdinjava
    }
    @Test
    public void xx(){
//        List<String> y=new ArrayList<>(new String[]{"Larry", "Moe", "Curly"});
        List<String> x =Arrays.asList("Larry", "Moe", "Curly");
        x.remove("Larry");
        System.out.println(x);
    }




}
