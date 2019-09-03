package com.xyx.javadesignmode.ui.b13;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("23 种设计模式（13）：迭代器模式\n" +
                "定义：提供一种方法访问一个容器对象中各个元素，而又不暴露该对象的内部细节。类型：行为类模式。\n" +
                "类图：\n" +
                "[code=img]design/iterator.jpg\n" +
                "如果要问 java 中使用最多的一种模式，答案不是单例模式，也不是工厂模式，更不是策略模式，而是迭代器模式，先来看一段代码吧：\n" +
                "\n" +
                "public static void print(Collection coll) { Iterator it = coll.iterator();\n" +
                "while (it.hasNext()) {\n" +
                "String str = (String) it.next(); System.out.println(str);\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "这个方法的作用是循环打印一个字符串集合，里面就用到了迭代器模式，java 语言已经完整地实现了迭代器模式，Iterator 翻译成汉语就是迭代器的意思。提到迭代器，首先它是与集合相关的，集合也叫聚集、容器等，我们可以将集合看成是一个可以包容对象的容器，例如\n" +
                "List，Set，Map，甚至数组都可以叫做集合，而迭代器的作用就是把容器中的对象一个一个地遍历出来。\n" +
                "迭代器模式的结构：\n" +
                "抽象容器：一般是一个接口，提供一个 iterator()方法，例如 java 中的 Collection 接口，\n" +
                "List 接口，Set 接口等。\n" +
                "具体容器：就是抽象容器的具体实现类，比如 List 接口的有序列表实现 ArrayList，List\n" +
                "接口的链表实现 LinkList，Set 接口的哈希列表的实现 HashSet 等。\n" +
                "抽象迭代器：定义遍历元素所需要的方法，一般来说会有这么三个方法：取得第一个元素的方法 first()，取得下一个元素的方法 next()，判断是否遍历结束的方法 isDone()（或者叫\n" +
                "hasNext()），移出当前对象的方法 remove()。\n" +
                "迭代器实现：实现迭代器接口中定义的方法，完成集合的迭代。代码实现：\n" +
                "\n" +
                "import java.util.ArrayList; import java.util.List;\n" +
                "\n" +
                "interface Iterator { public Object next();\n" +
                "\n" +
                "public boolean hasNext();\n" +
                "}\n" +
                "\n" +
                "class ConcreteIterator implements Iterator {\n" +
                " \n" +
                "private List list = new ArrayList(); \nprivate int cursor = 0;\n" +
                "\n" +
                "public ConcreteIterator(List list) {\n this.list = list;\n" +
                "}\n" +
                "\n" +
                "public boolean hasNext() {\n" +
                "if (cursor == list.size()) { \nreturn false;\n" +
                "}\n" +
                "return true;\n" +
                "}\n" +
                "\n" +
                "public Object next() { \nObject obj =  null;\n if (this.hasNext()) {\n" +
                "obj = this.list.get(cursor++);\n" +
                "}\n" +
                "return obj;\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "interface Aggregate {\n" +
                "public void add(Object obj); \npublic void remove(Object obj);\n" +
                "public Iterator iterator();\n" +
                "}\n" +
                "\n" +
                "class ConcreteAggregate implements Aggregate {\n private List list = new ArrayList();\n" +
                "\n" +
                "public void add(Object obj) { \nlist.add(obj);\n" +
                "}\n" +
                "\n" +
                "public Iterator iterator() {\n" +
                "return new ConcreteIterator(list);\n" +
                "}\n" +
                "\n" +
                "public void remove(Object obj) { \nlist.remove(obj);\n" +
                " \n" +
                "}\n" +
                "}\n" +
                "\n" +
                "public class Client {\n" +
                "public static void main(String[] args) { \nAggregate ag = new ConcreteAggregate();\n" +
                "ag.add(\"小明\");\n" +
                "ag.add(\"小红\");\n" +
                "ag.add(\"小刚\");\n" +
                "Iterator it = ag.iterator(); while (it.hasNext()) {\n" +
                "String str = (String) it.next(); System.out.println(str);\n" +
                "}\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "上面的代码中，Aggregate 是容器类接口，大家可以想象一下 Collection，List，Set 等，\n" +
                "Aggregate 就是他们的简化版，容器类接口中主要有三个方法：添加对象方法 add、删除对象方法 remove、取得迭代器方法 iterator。Iterator 是迭代器接口，主要有两个方法：取得迭代对象方法 next，判断是否迭代完成方法 hasNext，大家可以对比 java.util.List 和\n" +
                "java.util.Iterator 两个接口自行思考。\n" +
                "迭代器模式的优点有：\n" +
                "简化了遍历方式，对于对象集合的遍历，还是比较麻烦的，对于数组或者有序列表，我们尚可以通过游标来取得，但用户需要在对集合了解很清楚的前提下，自行遍历对象，但是对于\n" +
                "hash 表来说，用户遍历起来就比较麻烦了。而引入了迭代器方法后，用户用起来就简单的多了。\n" +
                "可以提供多种遍历方式，比如说对有序列表，我们可以根据需要提供正序遍历，倒序遍历两种迭代器，用户用起来只需要得到我们实现好的迭代器，就可以方便的对集合进行遍历了。封装性良好，用户只需要得到迭代器就可以遍历，而对于遍历算法则不用去关心。\n" +
                "迭代器模式的缺点：\n" +
                "对于比较简单的遍历（像数组或者有序列表），使用迭代器方式遍历较为繁琐，大家可能都有感觉，像 ArrayList，我们宁可愿意使用 for 循环和 get 方法来遍历集合。\n" +
                "迭代器模式的适用场景：\n" +
                "迭代器模式是与集合共生共死的，一般来说，我们只要实现一个集合，就需要同时提供这个集合的迭代器，就像 java 中的 Collection，List、Set、Map 等，这些集合都有自己的迭代器。假如我们要实现一个这样的新的容器，当然也需要引入迭代器模式，给我们的容器实现一个迭代器。\n" +
                "但是，由于容器与迭代器的关系太密切了，所以大多数语言在实现容器的时候都给提供了迭代器，并且这些语言提供的容器和迭代器在绝大多数情况下就可以满足我们的需要，所以现在需要我们自己去实践迭代器模式的场景还是比较少见的，我们只需要使用语言中已有的容器和迭代器就可以了。\n\n\n\n\n\n\n\n\n\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}