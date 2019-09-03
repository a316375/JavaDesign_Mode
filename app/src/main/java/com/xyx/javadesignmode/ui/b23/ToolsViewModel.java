package com.xyx.javadesignmode.ui.b23;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("23 种设计模式（23）：代理模式\n" +
                "概述：\n" +
                "为其他对象提供一种代理以控制对这个对象的访问。类型：结构型模式。\n" +
                "适用性：\n" +
                "1、远程代理（RemoteProxy）为一个对象在不同的地址空间提供局部代表。\n" +
                "2、虚代理（VirtualProxy）根据需要创建开销很大的对象。\n" +
                "3、保护代理（ProtectionProxy）控制对原始对象的访问。\n" +
                "4、智能指引（SmartReference）取代了简单的指针，它在访问对象时执行一些附加操作。\n" +
                "参与者：\n" +
                "1、Proxy\n" +
                "保存一个引用使得代理可以访问实体。若 RealSubject 和 Subject 的接口相同，Proxy 会引用 Subject。\n" +
                "提供一个与 Subject 的接口相同的接口，这样代理就可以用来替代实体。控制对实体的存取，并可能负责创建和删除它。\n" +
                "其他功能依赖于代理的类型：\n" +
                "2、RemoteProxy 负责对请求及其参数进行编码，并向不同地址空间中的实体发送已编码的请求。\n" +
                "3、VirtualProxy 可以缓存实体的附加信息，以便延迟对它的访问。\n" +
                "4、ProtectionProxy 检查调用者是否具有实现一个请求所必需的访问权限。\n" +
                "5、Subject 定义 RealSubject 和 Proxy 的共用接口，这样就在任何使用 RealSubject 的地方都可以使用 Proxy。\n" +
                "6、RealSubject 定义 Proxy 所代表的实体。例子：\n" +
                "\n" +
                "public class ProxyObject implements Object {\nObject obj;\n" +
                "public ProxyObject() {\n" +
                " \n" +
                "System.out.println(\"这是代理类\"); obj = new ObjectImpl();\n" +
                "}\n" +
                "\n" +
                "public void action() {\n" +
                "System.out.println(\"代理开始\"); obj.action();\n" +
                "System.out.println(\"代理结束\");\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public interface Object {\n" +
                "\n" +
                "void action();\n" +
                "}\n" +
                "\n" +
                "public class ObjectImpl implements Object {\n" +
                "\n" +
                "public void action() {\nSystem.out.println(\"========\"); System.out.println(\"========\");\n" +
                "System.out.println(\"这是被代理的类\"); System.out.println(\"========\"); System.out.println(\"========\");\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "\n" +
                "public class Test {\n" +
                "\n" +
                "public static void main() {\n" +
                "Object obj = new ProxyObject(); obj.action();\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "result：\n" +
                "\n" +
                "这是代理类代理开始\n" +
                "========\n" +
                "========\n" +
                "这是被代理的类\n" +
                "========\n" +
                " \n" +
                "========\n" +
                "代理结束\n\n\n\n\n\n\n\n\n\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}