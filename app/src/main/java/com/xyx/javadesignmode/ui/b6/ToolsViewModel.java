package com.xyx.javadesignmode.ui.b6;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("23 种设计模式（6）：模版方法模式\n" +
                "\n" +
                "定义：定义一个操作中算法的框架，而将一些步骤延迟到子类中，使得子类可以不改变算法的结构即可重定义该算法中的某些特定步骤。\n" +
                "类型：行为类模式。类图：\n" +
                " \n" +
                "[code=img]design/template.jpg\n" +
                "事实上，模版方法是编程中一个经常用到的模式。先来看一个例子，某日，程序员 A 拿到一个任务：给定一个整数数组，把数组中的数由小到大排序，然后把排序之后的结果打印出来。经过分析之后，这个任务大体上可分为两部分，排序和打印，打印功能好实现，排序就有点麻烦了。但是 A 有办法，先把打印功能完成，排序功能另找人做。\n" +
                "abstract class AbstractSort { [Tags]/**\n" +
                "[Tags]* 将数组 array 由小到大排序\n" +
                "[Tags]*\n" +
                "[Tags]* @param array [Tags]*/\n" +
                "protected abstract void sort(int[] array);\n" +
                "\n" +
                "public void showSortResult(int[] array) {\n this.sort(array);\n" +
                "System.out.print(\"排序结果：\");\n" +
                "for (int i = 0; i < array.length; i++) { \nSystem.out.printf(\"%3s\", array[i]);\n" +
                "}\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "写完后，A 找到刚毕业入职不久的同事 B 说：有个任务，主要逻辑我已经写好了，你把剩下的逻辑实现一下吧。于是把 AbstractSort 类给 B，让 B 写实现。B 拿过来一看，太简单了，\n" +
                "10 分钟搞定，代码如下：\n" +
                "class ConcreteSort extends AbstractSort {\n @Override\n" +
                "protected void sort(int[] array) {\n" +
                "for (int i = 0; i < array.length - 1; i++) { \nselectSort(array, i);\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "private void selectSort(int[] array, int index) { \nint MinValue = 32767; // 最小值变量\n" +
                "int indexMin = 0; // 最小值索引变量\n" +
                "int Temp; // 暂存变量\n" +
                "for (int i = index; i < array.length; i++) { \nif (array[i] < MinValue) { // 找到最小值\n" +
                "MinValue = array[i]; // 储存最小值\n" +
                " \n" +
                "indexMin = i;\n" +
                "}\n" +
                "}\n" +
                "Temp = array[index]; // 交换两数值array[index] = array[indexMin]; array[indexMin] = Temp;\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "写好后交给 A，A 拿来一运行：\n" +
                "\n" +
                "public class Client {\n" +
                "public static int[] a = { 10, 32, 1, 9, 5, 7, 12, 0, 4, 3 }; // 预设数据数组\n" +
                "\n" +
                "public static void main(String[] args) { \nAbstractSort s = new ConcreteSort();\n s.showSortResult(a);\n" +
                "}\n" +
                "}\n" +
                "\n" +
                "运行结果：\n" +
                "\n" +
                "排序结果：\t0\t1\t3\t4\t5\t7\t9 10 12 32\n" +
                "\n" +
                "运行正常。行了，任务完成。没错，这就是模版方法模式。大部分刚步入职场的毕业生应该都有类似 B 的经历。一个复杂的任务，由公司中的牛人们将主要的逻辑写好，然后把那些看上去比较简单的方法写成抽象的，交给其他的同事去开发。这种分工方式在编程人员水平层次比较明显的公司中经常用到。比如一个项目组，有架构师，高级工程师，初级工程师，则一般由架构师使用大量的接口、抽象类将整个系统的逻辑串起来，实现的编码则根据难度的不同分别交给高级工程师和初级工程师来完成。怎么样，是不是用到过模版方法模式？\n" +
                "模版方法模式的结构：\n" +
                "模版方法模式由一个抽象类和一个（或一组）实现类通过继承结构组成，抽象类中的方法分为三种：\n" +
                "抽象方法：父类中只声明但不加以实现，而是定义好规范，然后由它的子类去实现。\n" +
                "模版方法：由抽象类声明并加以实现。一般来说，模版方法调用抽象方法来完成主要的逻辑功能，并且，模版方法大多会定义为 final 类型，指明主要的逻辑功能在子类中不能被重写。钩子方法：由抽象类声明并加以实现。但是子类可以去扩展，子类可以通过扩展钩子方法来影响模版方法的逻辑。\n" +
                "抽象类的任务是搭建逻辑的框架，通常由经验丰富的人员编写，因为抽象类的好坏直接决定了程序是否稳定性。\n" +
                "实现类用来实现细节。抽象类中的模版方法正是通过实现类扩展的方法来完成业务逻辑。只要实现类中的扩展方法通过了单元测试，在模版方法正确的前提下，整体功能一般不会出现大的错误。\n" +
                "模版方法的优点及适用场景：\n" +
                " \n" +
                "容易扩展。一般来说，抽象类中的模版方法是不易反生改变的部分，而抽象方法是容易反生变化的部分，因此通过增加实现类一般可以很容易实现功能的扩展，符合开闭原则。\n" +
                "便于维护。对于模版方法模式来说，正是由于他们的主要逻辑相同，才使用了模版方法，假如不使用模版方法，任由这些相同的代码散乱的分布在不同的类中，维护起来是非常不方便的。\n" +
                "比较灵活。因为有钩子方法，因此，子类的实现也可以影响父类中主逻辑的运行。但是，在灵活的同时，由于子类影响到了父类，违反了里氏替换原则，也会给程序带来风险。这就对抽象类的设计有了更高的要求。\n" +
                "在多个子类拥有相同的方法，并且这些方法逻辑相同时，可以考虑使用模版方法模式。在程序的主框架相同，细节不同的场合下，也比较适合使用这种模式。\n\n\n\n\n\n\n\n\n\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}