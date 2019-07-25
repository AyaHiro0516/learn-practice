package org.ayahiro.practice.design_patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author ayahiro
 * @Description: 提供一种方法顺序访问一个聚合对象中各个元素, 而又不需暴露该对象的内部表示。
 * @Create: 2019/7/25
 */
public class Iterator {
    public static void main(String[] args) {
        MyIterable myIterable = new MyIterableImpl();
        myIterable.add(1);
        myIterable.add("bxy");
        myIterable.add(new Date());
        myIterable.add(777.777);
        MyIterator myIterator = myIterable.getIterator();
        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }
        System.out.println(myIterable.get(2));
    }
}

//Iterator
interface MyIterator {
    boolean hasNext();

    Object next();
}

//ConcreteIterator
class MyIteratorImpl implements MyIterator {
    private List<Object> list;
    private int pos = 0;
    private Object currentObject;

    public MyIteratorImpl(List<Object> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return pos < list.size();
    }

    @Override
    public Object next() {
        return currentObject = list.get(pos++);
    }
}

//Container
interface MyIterable {
    MyIterator getIterator();

    void add(Object object);

    Object get(int index);
}

//ConcreteContainer
class MyIterableImpl implements MyIterable {
    private List<Object> list;

    public MyIterableImpl() {
        list = new ArrayList<>();
    }

    @Override
    public MyIterator getIterator() {
        return new MyIteratorImpl(list);
    }

    @Override
    public void add(Object object) {
        list.add(object);
    }

    @Override
    public Object get(int index) {
        return list.get(index);
    }
}



