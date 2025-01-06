package jedi.core;

import java.util.*;

public class AgeComparator implements Comparator<Jedi> {
    @Override
    public int compare(Jedi o1, Jedi o2) {
        if(o1.getAge()==o2.getAge()){
            return o1.compareTo(o2);
        }else {
            return o1.getAge()-o2.getAge();
        }
    }
}
