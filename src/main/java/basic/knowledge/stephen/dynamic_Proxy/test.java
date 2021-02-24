package basic.knowledge.stephen.dynamic_Proxy;


import basic.knowledge.stephen.dynamic_Proxy.cglib_proxy.CGlibProxy;
import basic.knowledge.stephen.dynamic_Proxy.cglib_proxy.ForumServiceImpl;

public class test {
    public static void main(String[] args) {
        CGlibProxy proxy = new CGlibProxy();
        ForumServiceImpl forumService = (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);
        forumService.remiveTopic(1);
        forumService.remiveTopic(12);
    }
}
