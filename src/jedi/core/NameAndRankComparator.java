package jedi.core;

import java.util.*;

public class NameAndRankComparator implements Comparator<Jedi> {

    @Override
    public int compare(Jedi o1, Jedi o2) {
        if(!o1.getRank().equals(o2.getRank())){
            return o1.getRank().ordinal()-o2.getRank().ordinal();
        }
        else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}