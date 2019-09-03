package com.xyx.javadesignmode.ui.b15;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("23 种设计模式（15）：备忘录模式 定义：在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。 这样就可以将该对象恢复到原先保存的状态 类型：行为类模式。 类图： [code=img]design/memo.jpg 我们在编程的时候，经常需要保存对象的中间状态，当需要的时候，可以恢复到这个状态。 比如，我们使用 Eclipse 进行编程时，假如编写失误（例如不小心误删除了几行代码），我们 希望返回删除前的状态，便可以使用 Ctrl+Z 来进行返回。这时我们便可以使用备忘录模式来 实现。 [color=blue]备忘录模式的结构： 发起人：记录当前时刻的内部状态，负责定义哪些属于备份范围的状态，负责创建和恢复备 忘录数据。 备忘录：负责存储发起人对象的内部状态，在需要的时候提供发起人需要的内部状态。 管理角色：对备忘录进行管理，保存和提供备忘录。 通用代码实现： \n" +
                " \n" +
                "class Originator {\nprivate String state = \"\"; \n" +
                " \n" +
                " public String getState() {\n return state;  } \n" +
                " \n" +
                " public void setState(String state) {\n this.state = state;  } \n" +
                " \n" +
                " public Memento createMemento() {\n return new Memento(this.state);  } \n" +
                " \n" +
                " public void restoreMemento(Memento memento) {\n this.setState(memento.getState());  } } \n" +
                " \n" +
                "class Memento {\nprivate String state = \"\"; \n" +
                " \n" +
                " public Memento(String state) {\n this.state = state;  } \n" +
                " \n" +
                " public String getState() {\n return state;  } \n" +
                " \n" +
                " public void setState(String state) {\n this.state = state;  } } \n" +
                " \n" +
                "class Caretaker {\nprivate Memento memento; \n" +
                " \n" +
                " public Memento getMemento() {\n return memento;  } \n" +
                " \n" +
                " public void setMemento(Memento memento) {\n this.memento = memento;  } } \n" +
                " \n" +
                "public class Client11 {\npublic static void main(String[] args) {\n Originator originator = new Originator();   \n originator.setState(\"状态 1\");   \n System.out.println(\"初始状态:\" + originator.getState());  \n  Caretaker caretaker = new Caretaker();  \n  caretaker.setMemento(originator.createMemento());   \n originator.setState(\"状态 2\"); \n   System.out.println(\"改变后状态:\" + originator.getState()); \n   originator.restoreMemento(caretaker.getMemento());  \n  System.out.println(\"恢复后状态:\" + originator.getState());  } } \n" +
                " \n" +
                "代码演示了一个单状态单备份的例子，逻辑非常简单：Originator 类中的 state 变量需要备 份，以便在需要的时候恢复；Memento 类中，也有一个 state 变量，用来存储 Originator 类 中 state 变量的临时状态；而 Caretaker 类就是用来管理备忘录类的，用来向备忘录对象中 写入状态或者取回状态。 [color=blue]多状态多备份备忘录： 通用代码演示的例子中，Originator 类只有一个 state 变量需要备份，而通常情况下，发起 人角色通常是一个 javaBean，对象中需要备份的变量不止一个，需要备份的状态也不止一个， 这就是多状态多备份备忘录。实现备忘录的方法很多，备忘录模式有很多变形和处理方式， 像通用代码那样的方式一般不会用到，多数情况下的备忘录模式，是多状态多备份的。其实\n" +
                "实现多状态多备份也很简单，最常用的方法是，我们在 Memento 中增加一个 Map 容器来存储 所有的状态，在 Caretaker 类中同样使用一个 Map 容器才存储所有的备份。 下面我们给出一个多状态多备份的例子： \n" +
                " \n" +
                "class Originator {\nprivate String state1 = \"\";  \n private String state2 = \"\";  \n private String state3 = \"\"; \n" +
                " \n" +
                " public String getState1() {\n return state1;  } \n" +
                " \n" +
                " public void setState1(String state1) {\n this.state1 = state1;  } \n" +
                " \n" +
                " public String getState2() {\n return state2;  } \n" +
                " \n" +
                " public void setState2(String state2) {\n this.state2 = state2;  } \n" +
                " \n" +
                " public String getState3() {\n return state3;  } \n" +
                " \n" +
                " public void setState3(String state3) {\n this.state3 = state3;  } \n" +
                " \n" +
                " public Memento createMemento() {\n return new Memento(BeanUtils.backupProp(this));  } \n" +
                " \n" +
                " public void restoreMemento(Memento memento) {\n BeanUtils.restoreProp(this, memento.getStateMap());  } \n" +
                " \n" +
                " public String toString() {\n return \"state1=\" + state1 + \"state2=\" + state2 + \"state3=\" + state3;  } \n" +
                "} \n" +
                " \n" +
                "class Memento {\nprivate Map<String, Object> stateMap; \n" +
                " \n" +
                " public Memento(Map<String, Object> map) {\n this.stateMap = map;  } \n" +
                " \n" +
                " public Map<String, Object> getStateMap() {\n return stateMap;  } \n" +
                " \n" +
                " public void setStateMap(Map<String, Object> stateMap) {\n this.stateMap = stateMap;  } } \n" +
                " \n" +
                "class BeanUtils {\npublic static Map<String, Object> backupProp(Object bean) {\n Map<String, Object> result = new HashMap<String, Object>();   try {\n  BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());    PropertyDescriptor[] descriptors = beanInfo      .getPropertyDescriptors();    for (PropertyDescriptor des : descriptors) {\n   String fieldName = des.getName();     Method getter = des.getReadMethod();     Object fieldValue = getter.invoke(bean, new Object[] {});     if (!fieldName.equalsIgnoreCase(\"class\")) {\n    result.put(fieldName, fieldValue);     }    } \n" +
                " \n" +
                "  } catch (Exception e) {\n  e.printStackTrace();   }   return result;  } \n" +
                " \n" +
                " public static void restoreProp(Object bean, Map<String, Object> propMap) {\n try {\n  BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());  \n   PropertyDescriptor[] descriptors = beanInfo \n" +
                "     .getPropertyDescriptors();  \n   for (PropertyDescriptor des : descriptors) {\n   String fieldName = des.getName();    \n  if (propMap.containsKey(fieldName)) {\n    Method setter = des.getWriteMethod();    \n   setter.invoke(bean, new Object[] { propMap.get(fieldName) });     }    }   }  \ncatch (Exception e) {\n  e.printStackTrace();   }  } } \n" +
                " \n" +
                "class Caretaker {\nprivate Map<String, Memento> memMap = new HashMap<String, Memento>(); \n" +
                " \n" +
                " public Memento getMemento(String index) {\n return memMap.get(index);  } \n" +
                " \n" +
                " public void setMemento(String index, Memento memento) {\n this.memMap.put(index, memento);  } } \n" +
                " \n" +
                "class Client {\npublic static void main(String[] args) {\n Originator ori = new Originator(); \n   Caretaker caretaker = new Caretaker();  \n  ori.setState1(\"中国\");    \nori.setState2(\"强盛\");  \n  ori.setState3(\"繁荣\");  \n  System.out.println(\"===初始化状态===\\n\" + ori); \n" +
                " \n" +
                "  caretaker.setMemento(\"001\", ori.createMemento());  \n  ori.setState1(\"软件\");   \n ori.setState2(\"架构\");  \n  ori.setState3(\"优秀\"); \n   System.out.println(\"===修改后状态===\\n\" + ori); \n" +
                " \n" +
                "  ori.restoreMemento(caretaker.getMemento(\"001\")); \n   System.out.println(\"===恢复后状态===\\n\" + ori);  } \n" +
                "} \n" +
                " \n" +
                "备忘录模式的优点有： 1，当发起人角色中的状态改变时，有可能这是个错误的改变，我们使用备忘录模式就可以把 这个错误的改变还原。 2，备份的状态是保存在发起人角色之外的，这样，发起人角色就不需要对各个备份的状态进 行管理。  \n备忘录模式的缺点： 1，在实际应用中，备忘录模式都是多状态和多备份的，发起人角色的状态需要存储到备忘录 对象中，对资源的消耗是比较严重的。 2，如果有需要提供回滚操作的需求，使用备忘录模式非常适合，比如 jdbc 的事务操作，文 本编辑器的 Ctrl+Z 恢复等。\n\n\n\n\n\n\n\n\n\n ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}