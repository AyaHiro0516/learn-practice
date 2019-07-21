package org.ayahiro.practice.design_patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayahiro
 * @Description: 把多个对象组成树状结构来表示局部与整体，这样用户可以一样的对待单个对象和对象的组合。
 * @Create: 2019/7/19
 */
public class Composite {
    public static void main(String[] args) {
        ConcreteCompany root = new ConcreteCompany("北京总公司");
        root.add(new HRDepartment("总公司人力资源部"));
        root.add(new FinanceDepartment("总公司财务部"));

        ConcreteCompany comp = new ConcreteCompany("上海华东分公司");
        comp.add(new HRDepartment("华东分公司人力资源部"));
        comp.add(new FinanceDepartment("华东分公司财务部"));
        root.add(comp);

        ConcreteCompany comp1 = new ConcreteCompany("南京办事处");
        comp.add(new HRDepartment("南京办事处人力资源部"));
        comp.add(new FinanceDepartment("南京办事处财务部"));
        comp.add(comp1);

        root.display(1);
        root.work();
    }
}

//Component
abstract class Company {
    protected String name;

    public Company(String name) {
        this.name = name;
    }

    public abstract void add(Company company);

    public abstract void remove(Company company);

    public abstract void display(int depth);

    public abstract void work();
}

//Composite
class ConcreteCompany extends Company {
    private List<Company> companyList = new ArrayList<>();

    public ConcreteCompany(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {
        companyList.add(company);
    }

    @Override
    public void remove(Company company) {
        companyList.remove(company);
    }

    @Override
    public void display(int depth) {
        for (int i = 0; i < depth; ++i) {
            System.out.print('-');
        }
        System.out.println(name);
        for (Company component : companyList) {
            component.display(depth + 2);
        }
    }

    @Override
    public void work() {
        for (Company component : companyList) {
            component.work();
        }
    }
}

//Leaf
class HRDepartment extends Company {
    public HRDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {

    }

    @Override
    public void remove(Company company) {

    }

    @Override
    public void display(int depth) {
        for (int i = 0; i < depth; ++i) {
            System.out.print('-');
        }
        System.out.println(name);
    }

    @Override
    public void work() {
        System.out.println(name + " 员工招聘培训管理");
    }
}

class FinanceDepartment extends Company {
    public FinanceDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {

    }

    @Override
    public void remove(Company company) {

    }

    @Override
    public void display(int depth) {
        for (int i = 0; i < depth; ++i) {
            System.out.print('-');
        }
        System.out.println(name);
    }

    @Override
    public void work() {
        System.out.println(name + " 公司财务收支管理");
    }
}