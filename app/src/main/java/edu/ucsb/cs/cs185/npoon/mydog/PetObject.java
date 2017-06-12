package edu.ucsb.cs.cs185.npoon.mydog;

import android.net.Uri;

/**
 * Created by wpollek on 6/11/17.
 */

public class PetObject {
    public static Uri petPic;
    public static String name;
    public static String breed;
    public static String info;
    public static int age;
    public static int phone;
    public static char size;
    public PetObject(Uri uri, String nm, String brd, String inf, int ag, int ph, char sz){
        this.petPic=uri;
        this.name=nm;
        this.breed=brd;
        this.info=inf;
        this.age=ag;
        this.phone=ph;
        this.size=sz;
    }
}
