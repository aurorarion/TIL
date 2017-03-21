package test.execute;

import list.MyLinkedList;
import list.MyList;

public class TestRun {

    public static void main(String[] args) {

        MyList<String> myList = new MyLinkedList<>();
        myList.add("가");
        myList.add("나");
        myList.add("다");
        myList.print();

        System.out.println(myList.indexOf("나"));
        System.out.println(myList.get(myList.indexOf("나")));

        myList.add("마");
        myList.add(myList.indexOf("마"),"라");
        myList.print();
        System.out.println(myList.contains("라"));

        myList.remove(0);
        myList.remove(myList.indexOf("라"));
        myList.print();

    }

}
