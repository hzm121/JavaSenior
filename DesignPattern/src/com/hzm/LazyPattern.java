package com.hzm;

public class LazyPattern {
    private static Student student;
    public Student CreateStu(){
        synchronized (this){
            if (student == null){
                return student = new Student();
            }else {
                return student;
            }
        }
    }
}
