/*
 * /* Copyright 2016 Marcus Adriano, Vitor Hugo
 * *
 * *   Licensed under the Apache License, Version 2.0 (the "License");
 * *   you may not use this file except in compliance with the License.
 * *   You may obtain a copy of the License at
 *
 * *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * *   Unless required by applicable law or agreed to in writing, software
 * *   distributed under the License is distributed on an "AS IS" BASIS,
 * *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * *   See the License for the specific language governing permissions and
 * *   limitations under the License.
 */
package com.mv.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

public class Stack<E> implements Serializable{
    
    final private LinkedList<E> mList;
    
    public Stack() {
        mList = new LinkedList<>();
    }

    final public E pop() {
        E e = mList.get(mList.size() - 1);
        mList.remove(mList.size() - 1);
        return e;
    }
    
    final public void push(E e) {
        mList.add(e);
    }
    
    final public E peek() {
        return mList.peek();
    }
    
    final public int size() {
        return mList.size();
    }
    
    final public boolean isEmpty() {
        return mList.isEmpty();
    }
    
    final public Collection<E> getAll() {
        return mList;
    }
    
    final public void clear() {
        mList.clear();
    }
}
