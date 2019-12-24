package com.hzm;

public class Student {
    private String name;
    private char sex;

    private Student() {}

    private static Student student = null;

    public static Student CreateStu() {
        if (student == null){
            synchronized (Student.class) {
                if (student == null) {
                    return new Student();
                }
            }
        }

        return student;

    }

}
