package br.ufu.util;

import java.util.LinkedList;

public class OrderedList<T extends Comparable> extends LinkedList<T> {

    @Override
    public boolean add(T t) {
        for (int i = 0; i < this.size(); i++) {
            T aux = get(i);

            if (t.compareTo(aux) <= 0) {
                super.add(i, t);
                return true;
            }
        }
        return super.add(t);
    }


}