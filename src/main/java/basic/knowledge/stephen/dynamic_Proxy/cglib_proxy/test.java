package basic.knowledge.stephen.dynamic_Proxy.cglib_proxy;



public class test {
    public static void main(String[] args) {
        CGlibProxy proxy = new CGlibProxy();
        ForumServiceImpl forumService = (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);
        forumService.remiveTopic(1);
        forumService.remiveTopic(12);
    }
}
