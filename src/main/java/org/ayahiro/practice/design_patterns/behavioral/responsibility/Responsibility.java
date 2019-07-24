package org.ayahiro.practice.design_patterns.behavioral.responsibility;

/**
 * @Author ayahiro
 * @Description: 为解除请求的发送者和接收者之间耦合，而使多个对象都有机会处理这个请求。将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它。
 * @Create: 2019/7/24
 */
public class Responsibility {
    public static void main(String[] args) {
        CommonManager commonManager=new CommonManager("commonManager");
        Director director=new Director("director");
        GeneralManager generalManager=new GeneralManager("generalManager");

        commonManager.setSuperior(director);
        director.setSuperior(generalManager);

        Request request1=new Request("请假", 1);
        Request request2=new Request("请假", 4);
        Request request3=new Request("请假", 8);

        commonManager.requestApplications(request1);
        commonManager.requestApplications(request2);
        commonManager.requestApplications(request3);

    }
}

class Request {
    String type;
    int number;

    public Request(String type, int number) {
        this.type = type;
        this.number = number;
    }
}

abstract class Manager {
    protected String name;

    protected Manager superior;

    public Manager(String name) {
        this.name = name;
    }

    public void setSuperior(Manager superior) {
        this.superior = superior;
    }

    abstract public void requestApplications(Request request);
}

class CommonManager extends Manager {
    public CommonManager(String name) {
        super(name);
    }

    @Override
    public void requestApplications(Request request) {
        if (request.type.equals("请假") && request.number <= 2) {
            System.out.println("请求：" + request.type + ", 数量：" + request.number + ", 被"+name+"批准。");
        } else {
            if (superior != null) {
                superior.requestApplications(request);
            }
        }
    }
}

class Director extends Manager {
    public Director(String name) {
        super(name);
    }

    @Override
    public void requestApplications(Request request) {
        if (request.type.equals("请假") && request.number <= 5) {
            System.out.println("请求：" + request.type + ", 数量：" + request.number + ", 被"+name+"批准。");
        } else {
            if (superior != null) {
                superior.requestApplications(request);
            }
        }
    }
}

class GeneralManager extends Manager {
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void requestApplications(Request request) {
        if (request.type.equals("请假")) {
            System.out.println("请求：" + request.type + ", 数量：" + request.number + ", 被"+name+"批准。");
        } else {
            if (superior != null) {
                superior.requestApplications(request);
            }
        }
    }
}
