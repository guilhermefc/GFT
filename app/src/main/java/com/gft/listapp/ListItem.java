package com.gft.listapp;

/**
 * Created by cleoir on 27/09/2017.
 */

public class ListItem {

    private String id;
    private String head;
    private String desc;

    public ListItem(String id, String head, String desc) {
        this.id = id;
        this.head = head;
        this.desc = desc;

    }

    public String getId(){
        return id;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }
}
