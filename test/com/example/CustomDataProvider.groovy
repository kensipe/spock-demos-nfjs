package com.example

/**
 *
 * @author kensipe
 */
class CustomDataProvider implements Iterator{
    def list = [[1,2,3], [1,99, 100], ['Bat', 'man', 'Batman']]
    int position = 0

    @Override
    boolean hasNext() {
        position < list.size()
    }

    @Override
    Object next() {
        list[position++]
    }

    @Override
    void remove() {
    }

//    def close() { println "closing"}
}
