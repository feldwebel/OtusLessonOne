package application;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        MyArrayList<String> list = new MyArrayList<String>(10);
        list.add("zhopa");
        list.add("muravei");
        list.add(1, "[eq");

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        System.out.println(list.indexOf("[eq"));
        System.out.println(list.lastIndexOf("[eq"));


        System.out.println("-------");
        String[] arr = new String[1];
        ;
        System.out.println(list.toArray(arr).length);

        list.remove("muravei");

        System.out.println(list.contains("muravei"));


    }
}
