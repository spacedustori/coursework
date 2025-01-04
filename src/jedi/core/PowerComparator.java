package jedi.core;

import java.util.*;

public class PowerComparator implements Comparator<Jedi> {
    @Override
    public int compare(Jedi o1, Jedi o2) {
        return (int)(o1.getPower()-o2.getPower());
    }
}