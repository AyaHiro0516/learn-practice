package org.ayahiro.practice.design_patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayahiro
 * @Description: 在对象间定义一个一对多的联系性，由此当一个对象改变了状态，所有其他相关的对象会被通知并且自动刷新。
 * @Create: 2019/7/27
 */
public class Observer {
    public static void main(String[] args) {
        WeChatAccounts accounts = new WeChatAccounts("X博士");

        WeChatClient user1 = new WeChatClient("ayahiro");
        WeChatClient user2 = new WeChatClient("bxy0516");
        WeChatClient user3 = new WeChatClient("tom");

        accounts.subscribe(user1);
        accounts.subscribe(user2);
        accounts.subscribe(user3);

        accounts.publishArticles("article1", "something1");

        accounts.unsubscribe(user1);
        accounts.publishArticles("article2", "something2");
    }
}

//Observer
interface Subscriber {
    void receive(String publisher, String articleName);
}

//ConcreteObserver
class WeChatClient implements Subscriber {
    private String username;

    public WeChatClient(String username) {
        this.username = username;
    }

    @Override
    public void receive(String publisher, String articleName) {
        System.out.println(String.format("用户<%s> 接收到 <%s>微信公众号 的推送，文章标题为 <%s>", username, publisher, articleName));
    }
}

//Subject
class Publisher {
    private List<Subscriber> subscribers;
    private boolean pubStatus = false;

    public Publisher() {
        subscribers = new ArrayList<>();
    }

    public void subscribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        if (this.subscribers.contains(subscriber)) {
            this.subscribers.remove(subscriber);
        }
    }

    public void notifySubscribers(String publisher, String articleName) {
        if (!this.pubStatus) {
            return;
        }
        for (Subscriber subscriber : this.subscribers) {
            subscriber.receive(publisher, articleName);
        }
        this.clearPubStatus();
    }

    protected void setPubStatus() {
        this.pubStatus = true;
    }

    protected void clearPubStatus() {
        this.pubStatus = false;
    }
}

//ConcreteSubject
class WeChatAccounts extends Publisher {
    private String name;

    public WeChatAccounts(String name) {
        this.name = name;
    }

    public void publishArticles(String articleName, String content) {
        System.out.println(String.format("\n<%s>微信公众号 发布了一篇推送，文章名称为 <%s>，内容为 <%s> ", this.name, articleName, content));
        setPubStatus();
        notifySubscribers(this.name, articleName);
    }
}

