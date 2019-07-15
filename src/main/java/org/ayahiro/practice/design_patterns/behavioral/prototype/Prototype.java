package org.ayahiro.practice.design_patterns.behavioral.prototype;

import java.io.*;

/**
 * @Author ayahiro
 * @Description: 用原型实例指定创建对象的种类，并且通过拷贝这些原型,创建新的对象。
 * @Create: 2019/7/15
 */
public class Prototype {
    public static void main(String[] args) {
        Resume resume1 = new Resume("bxy");
        resume1.setPersonalInfo("male", "21");
        resume1.setWorkExperience("2017-2021", "NUIST");

        System.out.println(resume1.toString());
        try {
            //深克隆实现1
            Resume resume2 = (Resume) resume1.clone();
            System.out.println(resume1.workExperience == resume2.workExperience);

            //深克隆实现2
            ByteArrayOutputStream byteOut=new ByteArrayOutputStream();
            ObjectOutputStream objOut=new ObjectOutputStream(byteOut);
            objOut.writeObject(resume1);

            ByteArrayInputStream byteIn=new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream objIn=new ObjectInputStream(byteIn);
            Resume resume3=(Resume)objIn.readObject();
            System.out.println(resume1.workExperience == resume3.workExperience);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Resume implements Serializable, Cloneable {
    String name;
    String sex;
    String age;
    WorkExperience workExperience;

    public Resume(String name) {
        this.name = name;
        workExperience = new WorkExperience();
    }

    public void setPersonalInfo(String sex, String age) {
        this.sex = sex;
        this.age = age;
    }

    public void setWorkExperience(String workDate, String company) {
        workExperience.workDate = workDate;
        workExperience.company = company;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", workExperience=" + workExperience +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Resume resume = (Resume) super.clone();
        if (workExperience != null) {
            resume.workExperience = (WorkExperience) workExperience.clone();
        }
        return resume;
    }
}

class WorkExperience implements Serializable, Cloneable {
    String workDate;
    String company;

    @Override
    public String toString() {
        return "WorkExperience{" +
                "workDate='" + workDate + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}