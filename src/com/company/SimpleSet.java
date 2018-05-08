package com.company;

import java.util.HashSet;
import java.util.Set;

public class SimpleSet
{
    public static void main(String[] args)
    {
        SimpleSet simpleSet= new SimpleSet();
        simpleSet.run();
    }
    public void run()
    {
        Set<Integer> mySet= new HashSet<>();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        mySet.add(4);
        mySet.add(5);

        System.out.println(mySet);
        mySet.add(3);
        System.out.println(mySet);

    }
}
