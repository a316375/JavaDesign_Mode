package com.xyx.javadesignmode.ui.a3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("设计模式六大原则（3）：\n" +
                "定义：高层模块不应该依赖低层模块，二者都应该依赖其抽象；抽象不应该依赖细节；细节应该依赖抽象。\n" +
                "问题由来：类 A 直接依赖类 B，假如要将类 A 改为依赖类 C，则必须通过修改类 A 的代码来达成。这种场景下，类 A 一般是高层模块，负责复杂的业务逻辑；类 B 和类 C 是低层模块，负责基本的原子操作；假如修改类 A，会给程序带来不必要的风险。\n" +
                "解决方案：将类 A 修改为依赖接口 I，类 B 和类 C 各自实现接口 I，类 A 通过接口 I 间接与类\n" +
                "B 或者类 C 发生联系，则会大大降低修改类 A 的几率。\n" +
                "基于这样一个事实：相对于细节的多变性，抽象的东西要稳定的多。以抽象为基础搭建起来的架构比以细节为基础搭建起来的架构要稳定的多。在 java 中，抽象指的是接口或者抽象类，细节就是具体的实现类，使用接口或者抽象类的目的是制定好规范和契约， 而不去涉及任何具体的操作，把展现细节的任务交给他们的实现类去完成。\n" +
                "的核心思想是面向接口编程，我们依旧用一个例子来说明面向接口编程比相对于面向实现编程好在什么地方。场景是这样的，母亲给孩子讲故事，只要给她一本书，她就可以照着书给孩子讲故事了。代码如下：\n" +
                "\n" +
                "class Book {\n" +
                "public String getContent() {\n" +
                "return \"很久很久以前有一个阿拉伯的故事……\";\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "class Mother {\n" +
                " \n" +
                "public void narrate(Book book) {\n" +
                "System.out.println(\"妈妈开始讲故事\"); System.out.println(book.getContent());\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class Client6 {\n" +
                "public static void main(String[] args) { \nMother mother = new Mother(); mother.narrate(new Book());\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "运行结果：\n" +
                "\n" +
                "妈妈开始讲故事\n" +
                "很久很久以前有一个阿拉伯的故事……\n" +
                "\n" +
                "运行良好，假如有一天，需求变成这样：不是给书而是给一份报纸，让这位母亲讲一下报纸上的故事，报纸的代码如下：\n" +
                "\n" +
                "class Newspaper {\n" +
                "public String getContent() {\n" +
                "return \"林书豪 38+7 领导尼克斯击败湖人……\";\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "这位母亲却办不到，因为她居然不会读报纸上的故事，这太荒唐了，只是将书换成报纸，居然必须要修改 Mother 才能读。假如以后需求换成杂志呢？换成网页呢？还要不断地修改\n" +
                "Mother，这显然不是好的设计。原因就是 Mother 与 Book 之间的耦合性太高了，必须降低他们之间的耦合度才行。\n" +
                "我们引入一个抽象的接口 IReader。读物，只要是带字的都属于读物：\n" +
                "\n" +
                "interface IReader {\n" +
                "public String getContent();\n" +
                "}\n" +
                "\n" +
                "Mother 类与接口 IReader 发生依赖关系，而 Book 和 Newspaper 都属于读物的范畴，他们各自都去实现 IReader 接口，这样就符合了，代码修改为：\n" +
                "\n" +
                "class Newspaper implements IReader { \npublic String getContent() {\n" +
                "return \"林书豪 17+9 助尼克斯击败老鹰……\";\n" +
                "}\n" +
                " \n" +
                "}\n" +
                "\n" +
                "class Book implements IReader { \npublic String getContent() {\n" +
                "return \"很久很久以前有一个阿拉伯的故事……\";\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "class Mother {\n" +
                "public void narrate(IReader reader) {\n" +
                "System.out.println(\"妈妈开始讲故事\"); System.out.println(reader.getContent());\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class Client {\n" +
                "public static void main(String[] args) { \nMother mother = new Mother(); \nmother.narrate(new Book());\n mother.narrate(new Newspaper());\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "运行结果：\n" +
                "\n" +
                "妈妈开始讲故事\n" +
                "很久很久以前有一个阿拉伯的故事…… 妈妈开始讲故事\n" +
                "林书豪 17+9 助尼克斯击败老鹰……\n" +
                "\n" +
                "这样修改后，无论以后怎样扩展 Client 类，都不需要再修改 Mother 类了。这只是一个简单的例子，实际情况中，代表高层模块的 Mother 类将负责完成主要的业务逻辑，一旦需要对它进行修改，引入错误的风险极大。所以遵循可以降低类之间的耦合性，提高系统的稳定性，降低修改程序造成的风险。\n" +
                "采用给多人并行开发带来了极大的便利，比如上例中，原本 Mother 类与 Book\n" +
                "类直接耦合时，Mother 类必须等 Book 类编码完成后才可以进行编码，因为 Mother 类依赖于\n" +
                "Book 类。修改后的程序则可以同时开工，互不影响，因为 Mother 与 Book 类一点关系也没有。参与协作开发的人越多、项目越庞大，采用依赖导致原则的意义就越重大。现在很流行的 TDD 开发模式就是最成功的应用。\n" +
                "传递依赖关系有三种方式，以上的例子中使用的方法是接口传递，另外还有两种传递方式： 构造方法传递和 setter 方法传递，相信用过 Spring 框架的，对依赖的传递方式一定不会陌生。\n" +
                "在实际编程中，我们一般需要做到如下 3 点：\n" +
                "1、低层模块尽量都要有抽象类或接口，或者两者都有。\n" +
                " \n" +
                "2、变量的声明类型尽量是抽象类或接口。\n" +
                "3、使用继承时遵循里氏替换原则。\n" +
                "的核心就是要我们面向接口编程，理解了面向接口编程，也就理解了依赖倒置。\n\n\n\n\n\n\n\n\n\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}