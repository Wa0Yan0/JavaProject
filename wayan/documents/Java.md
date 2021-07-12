## java 基础


### 1.缩写补全代码
- main函数：psvm 
- 输出：sout 
- 遍历数组：正序：fori   倒叙：forr



### 2.快捷键的使用

| 功能 | 快捷键 |
| ------------ | ----------- |
| 自动修正代码 | Alt + Enter |
| 删除光标所在行 | Ctrl + Y |
| 复制光标所在行内容 | Ctrl + D |
| 格式化代码 | Alt + L |
| 单行注释 | Ctrl + / |
| 多行注释 | Ctrl + Shift + / |
| 自动生成代码 | Alt + Ins |
| 移动当前代码行 | Alt + Shift + 上下箭头 |
| 显示提示 | Alt + / |
| 统一重命名 | Shift + F6 |
| 自动生成代码 | Alt + Insert |



### 3.基础语法

#### 数组
- 数组初始化
```java
// 数组的定义
int[] array = new int[300]; // 动态初始化

//静态初始化
int[] array;
array = new int[] {5, 15, 25};

//省略初始化 不能拆分两个部分
int[] array = {5, 15, 25}; 
```

- 存储结构

1. 栈(Stack)：存放方法中的局部变量
2. 堆(Heap)：存放new出来的东西
3. 方法区(Method Area)：存储.Class相关信息
4. 本地方法栈(Native Method Stack)：与操作系统相关
5. 寄存器(pc Register)：与CPU相关



#### 类

-  创建类
```java
public class Phone {
    // 成员变量
    String brand;
    double price;
    String color;

    //成员方法
    public void call(String name){
        System.out.println("给" + name + "打电话");
    }

    public void sendMessage(){
        System.out.println("群发短信");
    }

}
```
-  创建对象
```java
public static void main(String[] args) {
        // 实例化类
        Phone phone = new Phone();
    
        // 类的属性调用
        phone.brand = "华为";
        phone.price = 59999;
        phone.color = "星河银";

        // 类d方法调用
        phone.call("王岩");
        phone.sendMessage();

    }
```

#### private

- 定义
```java
public class Person {
    // 定义私有变量
    private int age;
    private boolean male;
    
    // 对私有变量赋值  方法名：setXxx
    public void setAge(int num) {
        if (num > 0) {
            age = num;
        }else{
            System.out.println("数据不合理");
        }
    }

    // 获取私有变量   方法名：getXxx
    public int getAge() {
        return age;
	}
    
    // 如果是boolean类型 获取方法名改为：isXxx   赋值方法set不变
    public boolean isMale(){
		return male;
    }
}
```
- 调用
```java
 public static void main(String[] args) {
        Person person = new Person();
        person.setAge(20);
        int age = person.getAge();
        System.out.println("年龄：" + age);
}
```

####  构造方法
- 标准类的定义
```java
public class Person {
    // 定义私有变量
    private String name;
    private int age;

    public Person(){
        System.out.println("调用的是无参构造函数");
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("调用的是有参构造函数");
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    // 对私有变量赋值  方法名：setXxx
    public void setAge(int age) {
        this.age = age;
    }

    // 获取私有变量   方法名：getXxx
    public int getAge() {
        return age;
    }
}
```
- 调用
```java
public static void main(String[] args) {
        // 调用无参构造函数
        Person person = new Person();

        // 调用有参构造函数
        Person person1 = new Person("wayan", 21);

        person1.setAge(22);
        System.out.println("姓名: " + person1.getName() + "年龄：" + person1.getAge());
}
```

#### 匿名对象
```java
// 只能使用一次
new Person().name = ""
```

#### 键盘输入
```java
// 导包
import java.util.Scanner;
// 实例化
Scanner sc = new Scanner(System.in);
// 调用
int i = sc.nextInt(); // 返回int型
String str = sc.next(); // 返回string型
```

#### Random
```java
import java.util.Random;
Random r = new Random();
int num = r.nextInt(); // 范围 -2147483648~2147483647
int num = r.nextInt(10); // 范围 0~9
int num = r.nextInt(10) + 1; // 范围 1~10
```

#### ArrayList
- 自动装箱：基本类型 --> 包装类型
- 自动拆箱：包装类型 --> 基本类型 
- 可存储数据类型：Byte Short Integer Long Float Double Character Boolean

```java
// 创建一个Arraylist
ArrayList<String> arrayList = new ArrayList<>();

// 添加数据
arrayList.add("王岩");
arrayList.add("高勋");

// 查看添加状态
boolean success = arrayList.add("张三");

// 删除数据
arrayList.remove(2);

// Arraylist长度
arrayList.size();

// 获取ArrayList中数据
String name = arrayList.get(1);

// 遍历ArrayList
for (int i = 0; i < arrayList.size(); i++) {
    System.out.println(arrayList.get(i));
}
```

#### 字符串
- 对于引用类型来说，==进行的是地址的比较
- 双引号直接写的字符串在常量池中，new的不在池中
- 字符串比较
```java
String str1 = "wayan";
String str2 = "Wayan";
// 比较字符串是否相等，如果相等为true，否则为false
// "abc".equals(str1) 推荐使用
str1.equals(str2);
// 忽略大小写
str1.equalsIgnoreCase(str2);
```
- 字符串的匹配
```java
String str1 = "wayan";
String str2 = "gaoxun";

// 字符串长度 5
int length =str1.length();

// 拼接字符串 wayangaoxun
String str3 = str1.concat(str2);

// 索引单个字符 a
char ch = str1.charAt(1);

// 查找首次匹配到的文本索引位置 2
int index = str1.indexOf("yan");
```

- 字符串的截取
```java
String str1 = "HelloWorld";
//从索引位置开始截取  World
String str2 = str1.substring(5);

// 4为起始索引 7为最终索引 oWo
String str3 = str1.substring(4, 7);
```

- 字符串的转换
```java
String str1 = "HelloWorld";

// 转换成字符数组
char[] chars = str1.toCharArray();

// 转换成字节数组
byte[] bytes = str1.getBytes();

// 替换
String str2 = str1.replace("o", "*");
```

- 字符串的分割
```java
String str1 = "abc,abc,abc";

// 以逗号分割字符串
String[] array = str1.split(",");
```

#### 工具类
- Arrays工具
```java
import java.util.Arrays;

int[] array1 = {10, 20, 30};

// 按默认格式转变成字符串
String intStr = intArray.toString(array1);

// 排序
Arrays.sort(array1);
```

- 数学工具
```java
//获取绝对值 2.5
Math.abs(-2.5)
// 向上取整 3
Math.ceil(2.5)
// 向下取整 2
Math.floor(2.5)
// 四舍五入 3
Math.round(2.6)
```

#### 继承
- 继承关键字：extends
- 获取父类成员：super.
- 子类重载父类构造：super();		注：只有子类构造才能调用父类构造，且必须是第一句
- 检验重写装饰器： @Override

#### 抽象方法

```java
// 抽象类
public abstract class Animal {
    // 抽象方法
    public abstract void eat();
}

// 继承抽象父类
public class Cat extends Animal{
	// 重写父类抽象方法
    @Override
    public void eat(){
        System.out.println("猫吃鱼");
    }
}
```

#### 接口
```java
// 接口类
public interface MyInterface {
    // 常量,必须赋值,命名必须大写,用下划线分割,可以省略public static final
    public static final int NUM = 10;
    
    // 定义抽象方法,可以省略public abstract
    public abstract void method();

    // 定义默认方法
    public default void methodDefault(){
        System.out.println("默认方法");
        methodPrivate();
    }

    // 定义静态方法
    public static void methodStatic(){
        System.out.println("静态方法");
        methodStaticPrivate();
    }

    // 定义普通私有方法，解决代码重复问题
    private void methodPrivate(){
        System.out.println("private");
        System.out.println("private");
    }

    // 定义静态私有方法，解决代码重复问题
    private static void methodStaticPrivate(){
        System.out.println("staticPrivate");
        System.out.println("staticPrivate");
    }

}

// 实现类
public class MyImpl implements MyInterface{
    @Override
    public void method() {
        System.out.println("重写抽象方法");
    }

    @Override
    public void methodDefault() {
        System.out.println("重写默认方法");
    }
}

// 主类
public static void main(String[] args) {
        MyImpl my = new MyImpl();
        my.method();
        my.methodDefault();
        MyInterface.methodStatic();
}
```
#### 对象向下转型
```java
 public static void main(String[] args) {
        getPet(new Cat());
        getPet(new Dog());
    }

    public static void getPet(Animal animal){
        // 判断向下转型是否是本来的类
        if(animal instanceof Dog){
            Dog dog = (Dog) animal;
            dog.eat();
            dog.watchHouse();
        }

        if(animal instanceof Cat){
            Cat cat = (Cat) animal;
            cat.eat();
            cat.playMouse();
        }
}
```

#### 内部类
- 四种权限修饰符

| file path            | public | protected | default | private |
| -------------------- | ------ | --------- | ------- | ------- |
| 同一个类(我自己)     | YES    | YES       | YES     | YES     |
| 同一个包(我邻居)     | YES    | YES       | YES     | NO      |
| 不同包子类(我儿子)   | YES    | YES       | NO      | NO      |
| 不同包非子类(陌生人) | YES    | NO        | NO      | NO      |

- 成员内部类
```java
// 外部类
public class Outer {
    int num = 10; // 外部成员变量
    // 成员内部类
    public class Inner{
        int num = 20; // 内部类成员变量
        public void methodInner(){
            int num = 30; // 局部变量
            System.out.println(num); // 30 局部
            System.out.println(this.num); // 20 内部
            System.out.println(Outer.this.num); // 1o 外部
        }

    }
}

public static void main(String[] args) {
        // 实例化内部类
        Outer.Inner inner = new Outer().new Inner();
        inner.methodInner();
}
```
- 局部内部类
```java
// 外部类
public class Outer {
    final int num = 10; // 外部成员变量
    // 外部类方法
    public void methodOuter(){
        // 局部内部类    ---生存周期只在方法内
        class Inner{
            public void methodInner(){
                System.out.println(num); // num 必须是final类型
            }
        }
        // 实例化
        Inner inner = new Inner();
        inner.methodInner();
    }
}
```
- 匿名内部类
```java
public static void main(String[] args) {
        // 匿名内部类
        MyInterface my = new MyInterface(){
            @Override
            public void method() {
                System.out.println("匿名内部类");
            }
        };
        my.method();
}

public static void main(String[] args) {
        // 匿名对象
        new MyInterface(){
            @Override
            public void method() {
                System.out.println("匿名对象");
            }
        }.method();
}
```

#### 重写Objects类
- toString
```java
public class Person {
    private String str1;
    private String str2;

    @Override
    public String toString() {
        return "Person{" +
                "str1='" + str1 + '\'' +
                ", str2='" + str2 + '\'' +
                '}';
    }
}

public static void main(String[] args) {
        Person person = new Person("abc", "11");
        String str = person.toString();
        System.out.println(str); 
}
```

- equals
```java
public class Person {
    private String str1;
    private String str2;

    @Override
    public boolean equals(Object o) {
        // 判断是否为本类
        if (this == o) return true;
        // 判断本类是否为空
        if (o == null || getClass() != o.getClass()) return false;
        // 向下转型
        Person person = (Person) o;
        // 本类和其他类进行比较
        return Objects.equals(str1, person.str1) && Objects.equals(str2, person.str2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str1, str2);
    }
}

public static void main(String[] args) {
        Person person = new Person("abc", "11");
        Person person2 = new Person("abc", "12");
        boolean bool = person.equals(person2);
        System.out.println(bool); // false
}
```
- Objects.equals方法：可以避免空指针报错
```java
public static void main(String[] args) {
       String str1 = null;
       String str2 = "abc";
       boolean bool = Objects.equals(str1, str2);
       System.out.println(bool); // false
    }
```

#### 时间类
- y  年  M  月  d  日  H  时  m  分  s  秒

```java
  public static void main(String[] args) throws ParseException {
        // 获取毫秒值		1622082391414
        Date dateTime = new Date();
        long time = dateTime.getTime();
        System.out.println(time);

        // 将毫秒值转换成日期		Thu May 27 10:26:31 CST 2021
        Date date = new Date(time);
        System.out.println(date);

        // 格式化后的日期		2021年05月27日 10时26分31秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String dateFormat = sdf.format(date);
        System.out.println(dateFormat);

        // 日期解析		Thu May 27 10:26:31 CST 2021
        Date dateParse = sdf.parse(dateFormat);
        System.out.println(dateParse);
  }


```

- 计算天数差
```java
public static void main(String[] args) throws ParseException {
        // 键盘读入
        Scanner sc = new Scanner(System.in);
        String date = sc.next();
        
        // 用SimpleDateFormat里的parse方法解析日期
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateParse = dateFormat.parse(date);  // Tue May 25 00:00:00 CST 2021
        long birthTime = dateParse.getTime();  
        
        // 获取当前日期
        long todayTime = new Date().getTime();
        long time = todayTime - birthTime;
        
        // 把毫秒转化成天
        int day = (int)(time/1000/60/60/24);
        System.out.println(day);
}
```
Calendar
```java
 public static void main(String[] args) throws ParseException {
        // 获取Calendar对象
        Calendar calendar = Calendar.getInstance();

        // 设置年月日 9999 10 9
        calendar.set(Calendar.YEAR,9999);
        calendar.set(Calendar.MONTH,9);
        calendar.set(Calendar.DATE,9);
        calendar.set(8888,8,8);

        // 年份+2 月分-3    2023 3 27
        calendar.add(Calendar.YEAR, 2);
        calendar.add(Calendar.MONTH, -2);

        // 获取当前年月日  2021 5 27
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        System.out.println(year +" "+ month +" " + day);
     
      	//获取当前时间
        Date time = calendar.getTime();
}
```

#### System
```java
  		// 获取当前毫秒值
        long time = System.currentTimeMillis();
        System.out.println(time);

        // 复制数组
        int[] str = {1,2,3,4,5};    // 原数组
        int[] dest = {6,7,8,9,10};  // 目标数组	
        // 复制前[6, 7, 8, 9, 10]
        System.out.println("复制前" + Arrays.toString(dest));
        // 把原数组从0开始的3个元素复制到目标数组上
        System.arraycopy(str,0,dest,0,3);
        // 复制后[1, 2, 3, 9, 10]
        System.out.println("复制后" + Arrays.toString(dest));
```

#### StringBuilder
```java
 public static void main(String[] args) throws ParseException {
        // 实例化StringBuilder
        StringBuilder bu1 = new StringBuilder();
        // 添加字符串（可以是任意类型）
        StringBuilder bu2 = bu1.append("abc");
        System.out.println(bu1 == bu2); // 比较的是地址值

        String str1 = "hello";
        System.out.println("str1:" + str1);

        // String --> StringBuilder
        StringBuilder bu = new StringBuilder(str1);
        bu.append("Wa").append("Yan");
        System.out.println("bu:" + bu);

        // StringBuilder --> String
        String str2 = bu.toString();
        System.out.println("str2:" + str2);
}
```

#### Collection
- 定义使用
```java
 public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();  // 多态
        // 添加
        collection.add("王岩");

        // 移除
        collection.remove("王岩");

        // 判断对象是否在集合中存在
        boolean existFlag = collection.contains("王岩");

        // 判断集合是否为空
        boolean emptyFlag = collection.isEmpty();

        // 集合元素个数
        int num = collection.size();

        // 将集合转成数组
        Object[] array = collection.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        // 清空元素,保留集合
        collection.clear();
}
```
- Collections工具类
```java
  public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        // 往集合中一次性添加多个元素
        Collections.addAll(list,"a","b","c");

        // 打乱集合中元素顺序
        Collections.shuffle(list);

        // 排序 默认升序
//        Collections.sort(list);

        // 重写比较器 o1-o2升序 o2-o1降序
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.charAt(0)-o2.charAt(0);
            }
        });
		
        // 对类对象进行排序
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("b王岩",20));
        people.add(new Person("a高勋",20));
		
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int flag = o1.getAge() - o2.getAge();
                if(flag == 0){
                    return o1.getName().charAt(0) - o2.getName().charAt(0);
                }
                return flag;
            }
        });
        
        System.out.println(people);
    }
```

#### 增强for循环
```java
public static void main(String[] args) {
        // 集合
        Collection<String> collArrayList = new ArrayList<>();
        collArrayList.add("王岩");
        collArrayList.add("高勋");
        collArrayList.add("孙磊");

        // 遍历 增强for循环 只能是集合或数组
        for (String s:
                collArrayList) {
            System.out.println(s);
        }
        
        // 数组
        int[] numList = {1,2,3,4};
        
        // 遍历 增强for循环 只能是集合或数组
        for (int i:
             numList) {
            System.out.println(i);
        }
}
```

#### 泛型
- 泛型：是一个未知的数据类型 常用E表示
- 泛型类
```java
// 泛型类 E表示未知的类型
public class GenericClass <E>{
    private E e;

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}

public static void main(String[] args) {
        // 定义为Integer类型
        GenericClass<Integer> intGc = new GenericClass<>();
        intGc.setE(10);
        System.out.println(intGc.getE());

        // 定义为String类型
        GenericClass<String> strGc = new GenericClass<>();
        strGc.setE("王岩");
        System.out.println(strGc.getE());
}
```
- 泛型方法
```java
// 泛型类 E表示未知的类型
public class GenericClass {
    public <E> void genericMethod(E e){
        System.out.println(e);
    }
    public static <E> void staticGenMed(E e){
        System.out.println(e);
    }
}
public static void main(String[] args) {
        GenericClass gen = new GenericClass();
        gen.genericMethod("王岩");    // String
        gen.genericMethod(21);       // Integer
        GenericClass.staticGenMed("高勋");    // String
        GenericClass.staticGenMed(20);      // Integer
}
```
- 泛型接口
```java
// 接口
public interface GenInterface<E> {
    public abstract void method(E e);
}

// 实现类
public class GenericClass<E> implements GenInterface<E>{
    @Override
    public void method(E e) {
        System.out.println(e);
    }
}

// 主类
 public static void main(String[] args) {
        GenericClass<String> strGen = new GenericClass<>();
        strGen.method("王岩");

        GenericClass<Integer> intGen = new GenericClass<>();
        intGen.method(21);

}
```
- 泛型通配符
```java
public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("王岩");

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);

        printArray(strList);
        printArray(intList);
    }

    public static void printArray(ArrayList<?> arrayList){
        for (Object o : arrayList) {
            System.out.println(o);
        }
}
```

#### 集合
- ArrayList： 查询快，增删慢
- LinkedList：增删快，查询慢
```java
 public static void main(String[] args) {
        LinkedList<String> link = new LinkedList<>();
        // 插入数据
        link.push("王岩");

        // 在开头插入数据
        link.addFirst("高勋");

        // 在结尾插入数据
        link.addLast("孙磊");

        // 判断是否为空
        if(!link.isEmpty()){
            // 获取第一个元素
            String name1 = link.getFirst();
            // 获取最后一个元素
            String name2 = link.getLast();
        }
        
        // 删除第一个
        String fistName = link.removeFirst();
        // 删除最后一个
        String lastName = link.removeLast();
}
```

- HashSet：查询速度快 无序 不允许插入重复元素
- LinkedHashSet：有序 不允许插入重复元素
```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

	// 重写toString方法
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
	// 重写equals和hashCode方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public static void main(String[] args) {
        Person one = new Person("王岩", 21);
        Person two = new Person("王岩", 21);
        Person three = new Person("高勋", 20);
        HashSet<Person> person = new HashSet<>();
        person.add(one);
        person.add(two);
        person.add(three);
        System.out.println(person); // [Person{name='王岩', age=21}, Person{name='高勋', age=20}]
}
```

#### 可变参数
- 参数个数不确定
```java
 public static void main(String[] args) {
        show(1.5,1,2,3);
    }
    /*
        注意：
        1.一个方法，只能有一个可变参数
        2.一个方法，有多个参数时，可变参数数必须放末尾  
    */
    public static void show(double num,int...arr){
        System.out.println(num);
        for (int i : arr) {
            System.out.println(i);
        }
}
```

#### HashMap
```java
public static void main(String[] args) {
        // HashMap<key,value>
        HashMap<String,String> map = new HashMap<>();
        // 添加数据
        map.put("name","王岩");
        map.put("age","21");

        // 根据对应key删除
		map.remove("age");

        // 获取数据
        String name = map.get("name");

        // 判断是否存在对应的key
        boolean flag = map.containsKey("name");

        // 第一种 遍历
        // 把key取出来存储到Set集合中
        Set<String> set = map.keySet();

        // 遍历所有的key 用map.get()方法获取去对应的value值
        for (String key : set) {
            String value = map.get(key);
            System.out.println(key+""+value);
        }

        // 第二种 遍历
        Set<Map.Entry<String, String>> entrySet = map.entrySet();

        for (Map.Entry<String, String> entry : entrySet) {
            // 获取key
            String key = entry.getKey();
            // 获取value
            String value = entry.getValue();
            System.out.println(key+""+value);
        }
}
```

- 练习 统计字符个数

```java
public static void main(String[] args) {
        String str = new Scanner(System.in).next();
        HashMap<Character, Integer> map = new HashMap<>();
    	// 将字符串装换成字符数据
        for (char c : str.toCharArray()) {
            // 判断c在哈希表中是否存在
            if(!map.containsKey(c)){
                map.put(c,1);	// 不存在，赋初值
            }else{
                // 存在 获取key对应的value值加1
                Integer value = map.get(c);
                map.put(c,++value);
            }
        }
		// 遍历h
        Set<Character> set = map.keySet();
        for (Character key : set) {
            Integer value = map.get(key);
            System.out.println(key + ":" + value);
        }
}
```

#### debug
- F8：逐行执行程序
- F7：进入到方法
- Shift + F8：跳出方法
- F9:：跳到下一个断点
- Ctrl + F2：推出debug模式

#### 集合练习 --扑克牌
```java
 public static void main(String[] args) {
        // 存储牌的索引和牌
        HashMap<Integer,String> poker = new HashMap<>();
        // 存储牌的索引 洗牌的时候有用
        ArrayList<Integer> pokerIndex = new ArrayList<>();
        // 定义两个list集合存储花色和数字
        List<String> colors = List.of("♠", "♥", "♣", "♦");
        List<String> numbers = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        int index = 0;
        // 组合牌
        poker.put(index, "大王");
        pokerIndex.add(index);
        poker.put(++index, "小王");
        pokerIndex.add(index);
        for (String number : numbers) {
            for (String color : colors) {
                poker.put(++index, color+number);
                pokerIndex.add(index);
            }
        }
     
        // 打乱索引
        Collections.shuffle(pokerIndex);

        // 定义3个用户和一个底牌
        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        ArrayList<Integer> diPai = new ArrayList<>();

        // 发牌
        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer value = pokerIndex.get(i);
            if(i>=51){
                diPai.add(value);
            }else if(i%3 == 0){
                player1.add(value);
            }else if(i%3 == 1){
                player2.add(value);
            }else if(i%3 == 2){
                player3.add(value);
            }
        }

        // 看牌
        showPoker("周星驰", poker, player1);
        showPoker("刘德华", poker, player2);
        showPoker("周润发", poker, player3);
        showPoker("底牌", poker, diPai);

    }

    // 遍历
    public static void showPoker(String name, HashMap<Integer,String> poker, ArrayList<Integer> player){
        Collections.sort(player);
        System.out.print(name + ": ");
        for (Integer index : player) {
            System.out.print(poker.get(index) + " ");
        }
        System.out.println();
}

/*
z：
    周星驰: ♣2 ♦2 ♠A ♣A ♠K ♥K ♣K ♦J ♣10 ♦9 ♣8 ♦7 ♠6 ♥6 ♦6 ♠5 ♦5 
    刘德华: 小王 ♠2 ♥A ♦A ♠J ♥J ♣J ♠10 ♥10 ♦10 ♦8 ♠7 ♣7 ♦4 ♠3 ♥3 ♣3 
    周润发: 大王 ♥2 ♦K ♠Q ♥Q ♦Q ♠9 ♥9 ♣9 ♠8 ♥8 ♥7 ♣6 ♣5 ♠4 ♥4 ♦3 
    底牌: ♣Q ♥5 ♣4 
*/
```

#### 异常处理
```java
   public static void tackleException(Object obj){
        // 判断传递是否是null
        Objects.requireNonNull(obj, "传递的对象是null");

        // 多次次异常，一次捕获，一次处理
        try{
            // 可能会产生异常的代码
        }catch (Exception e){
            // 异常处理的逻辑
        }finally {
            // 无论是否出现异常，都会执行
        }

        // 多次异常，一次捕获，多次处理
        // 注：子类关系要放在上面
        try {

        }catch (ArrayIndexOutOfBoundsException e){

        }catch (IndexOutOfBoundsException e){

        }
}
```
- 自定义异常类
```java
/*
    Exception: 编译期异常
    RuntimeException: 运行时异常
*/
public class RegisterException extends Exception{
    public RegisterException(){
        super();
    }
    public RegisterException(String message){
        super(message);
    }
}

 public static void main(String[] args) {
        String[] users = {"王岩", "高勋", "孙类"};
        String name = new Scanner(System.in).next();
        register(name, users);
    }

    public static void register(String name, String[] users) {
        for (String user : users) {
            if (user.equals(name)) {
                try {
                    throw new RegisterException(name + "已被注册");
                } catch (RegisterException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
        System.out.println("注册成功");
}
```

#### 多线程
- 并发：多个事件在同一时间段内轮流发生
- 并行：多个事件同时发生
- 进程： 在内存中运行的应用程序，至少有一个进程
- 线程：是进程中的一个执行单元，一个进程包含多个线程
- 创建线程
  - 第一种方式 - 继承
```java
public class myThread extends Thread{
    public myThread(){

    }
    public myThread(String name){
        // 给线程重命名
        super(name);
    }
    @Override
    public void run() {
        // 第一种获取该线程的名称
        String name = getName();
        System.out.println(name);

        // 第二种获取该线程和名称
        Thread t = Thread.currentThread();
        System.out.println(t);
        System.out.println(t.getName());

    }
}

public static void main(String[] args) {
        // 第一种 设置线程名字
        myThread mt = new myThread("wayan");
        mt.start();

        // 第二种 设置线程名字
        myThread mt2 = new myThread();
        mt2.setName("gaoxun");
        mt2.start();
		
    	// 线程睡眠
    	 try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println(Thread.currentThread().getName());
}
```
  - 第二种方式  - 接口
```java
public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "--> " + i);
        }
    }
}

public static void main(String[] args) {
        RunnableImpl run = new RunnableImpl();
        Thread thread = new Thread(run);
        thread.start();
}
```
  - 第三种方式  - 匿名内部类
```java
public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                // 重写run方法
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
               // 重写run方法
            }
        }).start();
}
```

#### 解决线程安全问题
- 同步代码块
```java
public class RunnableImpl implements Runnable {
    // 创建一个锁对象
    Object obj = new Object();

    @Override
    public void run() {
            // 同步代码块    -解决线程安全问题
            synchronized (obj) {
             	// 可能存在安全的代码
            }
    }
}
```
- 同步方法
```java
public class RunnableImpl implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if(ticket <= 0){
                break;
            }else{
                safeLock();
            }
        }
    }
    
    // 同步方法
    public synchronized void safeLock() {
      	// 可能存在安全问题的代码
    }
```
- ReentrantLock
```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableImpl implements Runnable {
    private int ticket = 100;

    // 创建锁对象
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            // 获取锁
            lock.lock();
            try{
             	// 可能存在安全问题的代码
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                // 释放锁
                lock.unlock();
            }
        }
    }
}
```

#### 线程状态
- 生产者和消费者
```java
public static void main(String[] args) {
        BaoZi baozi = new BaoZi();
        new Customer(baozi).start();
        new Customer(baozi).start();
        new Supplier(baozi).start();
}

public class BaoZi {
    String pi;
    String xie;
    boolean flag = false;
}

public class Supplier extends Thread{
    // 定义一个包子
    private BaoZi baozi;

    public Supplier(BaoZi baozi){
        this.baozi= baozi;
    }

    @Override
    public void run() {
        while(true){
            // 同步代码块
            synchronized(baozi){
                // 判断包子的状态,如果有包子就等待
                if (baozi.flag == true){
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 如果没有包子，开始做包子，设置包子的材料
                switch(new Random().nextInt(2)+1){
                    case 1: baozi.pi = "薄皮";baozi.xie = "豆沙";break;
                    case 2: baozi.pi = "凉皮";baozi.xie = "肉";break;
                }
                System.out.println("包子铺正在做："+ baozi.pi + baozi.xie + "包");
                // 等三秒，做好包子
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(baozi.pi + baozi.xie + "包，做好了！");
                //将包子的状态设置为true
                baozi.flag = true;
                // 唤醒消费之线程
                baozi.notify();
            }
        }
    }
}

public class Customer extends Thread{
    private BaoZi baozi;

    public Customer(BaoZi baozi){
        this.baozi = baozi;
    }

    @Override
    public void run() {
        while(true){
            // 同步代码块
            synchronized (baozi){
                // 判断包子的状态，如果没有包子，就等待,否则，吃包子
                if(baozi.flag == false){
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.println(Thread.currentThread().getName() + ": 拿到了一个" + baozi.pi + baozi.xie + "包");
                    System.out.println("--------------------------");
                    // 设置包子的状态为false
                    baozi.flag = false;
                    // 唤醒供应商线程
                    baozi.notify();
                }
            }
        }
    }
}


```

#### 线程池
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public static void main(String[] args) {
        // 创建线程池
        ExecutorService ex = Executors.newFixedThreadPool(2);
        // 创建线程任务
        PoolImpl pool = new PoolImpl();
        // 开启线程任务
        ex.submit(pool);
        // 关闭线程
        ex.shutdown();
}
```

#### Lambda表达式
- ()： 接口中抽象方法的参数列表
- ->：传递
- {}：重写接口的抽象方法体
```java
public static void main(String[] args) {
        // 用匿名内部类创建多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        // 用Lambda表达式创建多线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();

        // 优化Lambda 能够推导 接口中只有一个抽象方法
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
        
        // 带参数的lambda
        int num = invokeCalculator(10, 20, (a, b) -> a + b); // 重写接口方法
        System.out.println(num);
    }

    public static int invokeCalculator(int a, int b, Calculator c) {
        return c.sum(a, b);
}

public interface Calculator {
    public abstract int sum(int a, int b);
}
```

#### 文件
- 获取文件的基本信息
```java
import java.io.File;

public static void main(String[] args) {
        File f1 = new File("D:\\Java\\JavaProject\\Data\\one.xlsx");
        File f2 = new File("Data\\one.xlsx");

        // 获取绝对路劲   D:\Java\Data\one.xlsx
        String f1absolutePath = f1.getAbsolutePath();

        // 是什么路劲，就获取什么路径 等同于 toString方法     one.xlsx
        String f2Path = f2.getPath();

        // 获取文件名或目录名    one.xlsx
        String name = f1.getName();

        // 获取文件大小(字节)
        long size = f1.length();

        // 判断这个路径是否存在
        if(f1.exists()){
            // 判断是否是文件夹
            if (f1.isDirectory()){
                System.out.println("这是文件夹");
            }
            // 判断是否是文件
            if (f1.isFile()){
                System.out.println("这是文件");
            }
        }else{
            System.out.println("该路径不存在");
        }
    
     	// 获取指定路径下的所有文件和文件夹的名称
        String[] fileNames = new File("D:\\Java\\JavaProject\\Data").list();
        for (String name : fileNames) {
            System.out.println(name);
        }

        // 获取指定路径下的所有文件和文件夹，并封装成file对象
        File[] fileObjs = new File("D:\\Java\\JavaProject\\Data").listFiles();
        for (File fileObj : fileObjs) {
            System.out.println(fileObj);
        }
    
}
```
- 创建文件和文件夹
```java
 public static void main(String[] args) {
        try {
            // 创建文件
            boolean f1Status = new File("Data\\two.xlsx").createNewFile();
            System.out.println("f1Status:" + f1Status);
            
            // 创建目录
            boolean dirStatus = new File("Data\\excel").mkdirs();
            System.out.println("dirStatus:" + dirStatus);
            
            // 删除文件
            boolean delStatus = new File("Data\\excel").delete();
            System.out.println("delStatus:" + delStatus);

        } catch (IOException e) {
            e.printStackTrace();
        }
}
```

- 遍历出所有的文件
```java
public static void main(String[] args) {
        getAllFile(new File("D:\\Java\\JavaProject\\Data"));
    }
    public static void getAllFile(File dir){
        // 获取指定路径下的所有文件和文件夹，并封装成file对象
        File[] fileObjs = dir.listFiles();
        for (File fileObj : fileObjs) {
            // 如果是目录，继续调用此函数
            if(fileObj.isDirectory()){
                getAllFile(fileObj);
            }else{
                // 判断文件是否以.xlsx结尾
                if(fileObj.getName().toLowerCase().endsWith(".xlsx")){
                    System.out.println(fileObj);
                }
            }

        }
}
```
- 文件过滤器
```java
 public static void main(String[] args) {
        getAllFile(new File("Data"));
    }

    public static void getAllFile(File dir) {
        // 第一种文件过滤器
        File[] fileObjs = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".xlsx");
            }
        });
        // 对应的lambda表达式
       File[] fileObjs = dir.listFiles(
           pathname -> pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".xlsx"));
       
       // 第二种文件过滤器
       File[] fileObjs = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File d, String name) {
                return new File(d, name).isDirectory() || name.toLowerCase().endsWith(".xlsx");
            }
        });
        // 对应的lambda表达式
       File[] fileObjs = dir.listFiles(
           (d,name) -> new File(d,name).isDirectory() || name.toLowerCase().endsWith(".xlsx"));
        
        // 遍历
        for (File fileObj : fileObjs) {
            // 如果是目录在j
            if (fileObj.isDirectory()) {
                getAllFile(fileObj);
            } else {
                System.out.println(fileObj);
            }
        }
}
```

- 文件写入
```java
// 写入单个字节  
try {
       // 创建文件流对象，参数是地址
       FileOutputStream fos = new FileOutputStream("Data\\num.txt");
       // 字节
       fos.write(97);
       fos.close();
  } catch (Exception e) {
       e.printStackTrace();
  }

// 写入多个字节
try {
      // 创建文件流对象，参数是地址
      FileOutputStream fos = new FileOutputStream("Data\\num.txt", true);
      for (int i = 0; i < 10; i++) {
         // String --> Bytes
         byte[] bytes = "王岩\r\n".getBytes();
         // 字节数组
         fos.write(bytes);
      }
         fos.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
```

#### 字节流
- 文件读取
```java
// 读取文件中的一个字节 
public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("Data\\num.txt");
        // 读取文件中的一个字节，读取到文件末尾返回-1
        int len = 0;
        while((len = fis.read()) != -1){
            System.out.println((char)len);
        }
        fis.close();
}

// 一次性读入多个字节
 public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("Data\\num.txt");
        // 先开辟1kb的空间，如果超过1kb会再开辟一个1kb的空间
        byte[] bytes = new byte[1024];
        int len = 0; // 记录文件长度
        while ((len = fis.read(bytes)) != -1) {
            // 将bytes类型转换成String类型, 从0开始，到文件总长度结束
            System.out.print(new String(bytes,0, len));
        }
        fis.close();
}
```
- 案例 -- 复制文件
```java
public static void main(String[] args) throws IOException {
        // 设置开始时间
        long startTime = System.currentTimeMillis();
        // 创建读入流
        FileInputStream fis= new FileInputStream("Data\\7.jpg");
        // 创建写入流
        FileOutputStream fos = new FileOutputStream("Data\\8.jpg");
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len = fis.read(bytes)) != -1){
            // 写入数据，直到文件读取结束为止
            fos.write(bytes,0,len);
        }
        //关闭写入流
        fos.close();
        //关闭读入流
        fis.close();
        // 设置结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("复制该图片花了" + (endTime-startTime) + "毫秒");
}


// 优化后
 public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("Data\\7.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Data\\8.jpg"))){
            byte[] bytes = new byte[1024];
            int len = 0;
            while((len=bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
        }catch (IOException e){
            System.out.println(e);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("一共用时：" + (endTime-startTime) + "毫秒");

}
```
#### 字符流

- 文件的读取
```java
// 读取
        try(FileReader fr = new FileReader("Data\\num.txt");){
            int len = 0;
            char[] name = new char[1024];
            while((len = fr.read(name)) != -1){
                System.out.println(new String(name, 0, len));
            }
        }catch (IOException e){
            System.out.println(e);
        }
```
- 文件的写入
```java
 // 写入
        try(FileWriter fw = new FileWriter("Data\\String.txt",true);){
            for (int i = 0; i < 10; i++) {
                fw.write("高勋" + "\r\n");
            }
            // 将数据从内存缓冲区写入硬盘，写完还可以继续使用
            fw.flush();
            char[] c = {'a','b','c'};
            fw.write(c,0,2); // j
        }catch (IOException e){
            System.out.println(e);
        }
```

- Properties集合:存储字符流，key value
```java
 public static void main(String[] args) {
        // 创建Properties集合对象
        Properties prop = new Properties();

        // 添加数据
        prop.setProperty("王岩","21");

        // 新建字符输入流
        try(FileWriter fw = new FileWriter("Data\\String.txt");){
            // 将数据写入
            prop.store(fw,"data save");
        }catch (IOException e){
            System.out.println(e);
        }

        // 新建字符读入流
        try (FileReader fr = new FileReader("Data\\String.txt")){
            //读取数据
            prop.load(fr);
        }catch (IOException e){
            System.out.println(e);
        }

        // 遍历 Properties集合
        Set<String> set = prop.stringPropertyNames();
        for (String key : set) {
            //获取数据
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }

}
```

#### 缓冲流
- 字节缓冲输出流
1.创建FileOutputStream对象，绑定路径
2.创建BufferedOutputStream对象，绑定FileOutputStream对象
3.调用BufferedOutputStream对象的write()和flush()方法
4.释放资源
```java
String str = "把字节数据写入内部缓冲区中";
try(FileOutputStream fos = new FileOutputStream("Data\\byte.txt");
BufferedOutputStream bos = new BufferedOutputStream(fos)){
      bos.write(str.getBytes());
      bos.flush();
}catch(IOException e){
      System.out.println(e);
}
```
- 字节缓冲输入流
1.创建FileInputStream对象，绑定路径
2.创建BufferedInputStream对象，绑定FileInputStream对象
3.调用BufferedInputStream对象的read()
4.释放资源
```java
try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("Data\\byte.txt"))) {
    byte[] bytes = new byte[1024];
    int len = 0;
    while ((len = bis.read(bytes)) != -1)
        System.out.println(new String(bytes,0,len));
} catch (Exception e) {
    System.out.println(e);
}
```
- 字符缓冲输出流
1.创建FileWriter对象，绑定路径
2.创建BufferedWriter对象，绑定FileWriter对象
3.调用BufferedWriter对象中的write()和flush()
4.释放资源
```java
try (BufferedWriter bw = new BufferedWriter(new FileWriter("Data\\String.txt"))) {
    for (int i = 0; i < 10; i++) {
        bw.write("王岩");
        bw.newLine();
        bw.flush();
    }
    } catch (IOException e) {
        e.printStackTrace();
}
```
- 字符缓冲输入流
1.创建FileReader对象，绑定路径
2.创建BufferedReader对象，绑定FileReader对象
3.调用BufferedReader对象中的read()和readLine()
4.释放资源
```java
try (BufferedReader br = new BufferedReader(new FileReader("Data\\String.txt"))) {
    String line;
    while ((line = br.readLine()) != null) {
          System.out.println(line);
    }
} catch (IOException e) {
        e.printStackTrace();
}
```
#### 编码转换
- 输入流
```java
InputStreamReader isr = new InputStreamReader(new FileInputStream("Data\\gbk.txt"), "GBK")
```
- 输出流
```java
OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("Data\\utf-8.txt"), "utf-8")
```

#### 对象流
- 对象序列流
```java
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data\\obj.txt"));
oos.writeObject(new Person("王岩",21));
```
- 对象反序列化流
```java
ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data\\obj.txt"))
Object obj = ois.readObject();
Person person = (Person)obj;
```
- 类配置
```java
public class Person implements Serializable
{
    private static final long serialVersionUID = 1L; // 加入序列版本号
    private transient int age;	// 不被序列化
}

```
- 集合序列化和反序列化
```java
	    ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("王岩", 21));
        list.add(new Person("高勋", 21));
        list.add(new Person("孙磊", 21));
		// 写
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data\\obj.txt"));) 		 {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
		// 读
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data\\obj.txt"))) {
            Object obj = ois.readObject();
            ArrayList<Person> arrayList = (ArrayList<Person>) obj;
            System.out.println(arrayList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
```

#### 打印流
```java
PrintStream ps = new PrintStream("Data\\ps.txt");
ps.write(); // 对照ASCII码表输出
ps.println(); // 原样输出
System.setOut(ps) //指定打印位置
```

#### 文件上传到服务器
- 服务器
```java
public class Server {
    public static void main(String[] args) {
        try {
            // 创建服务器
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true) {
                // 监听客户端
                Socket clientSocket = serverSocket.accept();
                // 监听到一个客户端就开启一个线程
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // 接收客户端发送来的数据，并保存到本地
                            InputStream webIS = clientSocket.getInputStream();
                            // 判断服务器上传文件夹是否存在
                            File file = new File("Data\\server\\upload");
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            // 定义名字
                            String fileName = "localhost" + System.currentTimeMillis() + new Random().nextInt(999) + ".jpg";
                            System.out.println(fileName);
                            // 创建本地字节缓冲输出流
                            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file + "\\" + fileName));
                            int len = 0;
                            byte[] bytes = new byte[1024];
                            while ((len = webIS.read(bytes)) != -1) {
                                // 写入服务器上传文件夹
                                bos.write(bytes, 0, len);
                            }
                            System.out.println("已保存到本地");
                            // 返回客户端数据
                            OutputStream webOS = clientSocket.getOutputStream();
                            webOS.write((file + "\\" + fileName + "上传成功！！！").getBytes());

                            bos.close();
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
```
- 客户端
```java
public class Client {
    public static void main(String[] args) {
        try {
            // 创建客户端
            Socket socket = new Socket("127.0.0.1", 8888);
            // 创建本地流
            BufferedInputStream bos = new BufferedInputStream(new FileInputStream("Data\\7.jpg"));

            // 从本地获取数据,发送给服务器
            OutputStream os = socket.getOutputStream();
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = bos.read(bytes)) != -1) {
                os.write(bytes,0,len);
            }
            socket.shutdownOutput();

            // 接收服务器发来的数据
            InputStream is  = socket.getInputStream();
            while ((len = is.read(bytes)) != -1) {
                System.out.println(new String(bytes,0,len));
            }

            bos.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

#### 函数接口
- @FunctionalInterface：检测接口是否是一个函数式接口
```java
@FunctionalInterface
public interface MyInterface {
    public abstract void method();
}
```
- lambda表达式可以延迟执行，减少性能浪费

- lambda Thread 重写Runnable方法
```java
public static void main(String[] args) {
	startThread(()-> System.out.println(Thread.currentThread().getName() + "--> 线程启动"));
}
public static void startThread(Runnable run){
	new Thread(run).start();
}
```
- lambda Comparator 重写compare(String o1, String o2)方法
```java
public static void main(String[] args) {
	String[] arr = {"a","aa","aaa"};
	Arrays.sort(arr, (o1, o2) -> o2.length()-o1.length());
	System.out.println(Arrays.toString(arr));
}
```
- Supplier接口：创建指定类型的数据
```java
//创建方法,让Supplier<>函数接口作为参数
public static int getMax(Supplier<Integer> sup){
	sup.get();
}

//调用方法，重写Supplier<>函数接口
int maxValue = getMax(()->{
	//函数接口方法体
});
```

- Consumer接口：处理接收到的数据
```java
// 创建方法，让Consumer函数作为参数
public static void printInfo(String str, Consumer<String> con1, Consumer<String> con2){
	//连接两个函数接口
	con1.andThen(con2).accept(str);
}

// 调用方法
printInfo(str, (str)->{
	//函数接口体
},(str)->{
	//函数接口体
});
```

- Predicate接口： 判断数据类型是否满足条件
```java
// 定义一个方法，让Predicate接口作为参数
public static boolean filter(String s, Predicate<String> pre1, Predicate<String> pre2){
	return pre1.and(pre2).test(s); // and or !
} 

//调用方法
String s = "abcde"
boolean b = filter(s,(String s)->s.length)()>5,(String s)->s.contains("a"));
```

- Function接口 apply方法：将一种数据类型转换成另一种数据类型
```java
public static int convert_type(String s, Function<String,Integer> function){
	return function.apply(s);
}
```

####  Stream流
- 转换成Stream流
```java
// 把数据转化为Stream流
Integer[] arr = {1,3,4,5};
Stream<Integer> arrStream = Stream.of(arr);
        
// 把list集合转换成Stream流
List<String> list = new ArrayList<>();
Stream listStream = list.stream();

// 把set集合转换成stream流
Set<String> set = new HashSet<>();
Stream<String> setStream = set.stream();

// 把map集合转换成stream流
Map<String,String> map = new HashMap<>();
// 获取键
Set<String> keySet = map.keySet();
Stream<String> keySetStream = keySet.stream();
// 获取值
Collection<String> values = map.values();
Stream<String> valueStream = values.stream();
// 获取键值对
Set<Map.Entry<String,String>> entries = map.entrySet();
Stream<Map.Entry<String,String>> entryStream = entries.stream();
```

- 使用Stream流
```java
// forEach：对流进行遍历，终结
stream.forEach(name -> System.out.println(name));

// filter: 过滤满足条件的数据，生成新的流，延迟
Stream<String> stream2 = stream.filter(name -> name.startsWith("王"));

// map: 映射，将一种数据类型转换成另一种数据类型，生成新的流，延迟
Stream<Integer> stream2 = stream.map(num->Integer.parseInt(num));

// count: 用于统计Stream流中的个数，终结
long conut = stream.count();

// limit: 截取流中的元素，返回一个新的流，延迟
Stream<String> stream2 = stream.limit(2);

// skip: 跳过前n个元素
Stream<String> stream2 = stream.skip(2);

// concat:将两个流组合到一起，返回一个新的流
Stream<String> stream2 = Stream.concat(stream,stream1);

```

#### 方法的引用
- 通过对象名引用成员方法
```java
// 类，定义一个成员方法，功能：输出大写字符串
public class MethodObj {
    public void PrintUpperCaseString(String s){
        System.out.println(s.toUpperCase());
    }
}

// 接口，定义一个抽象方法，功能：自定义
@FunctionalInterface
public interface Printable {
    public abstract void print(String s);
}

// 主类
public class StudyTest {
    // 定义一个方法，将接口作为参数，功能：调用接口的抽象方法
    public static void printString(String s, Printable p){
        p.print(s);
    }

    public static void main(String[] args) {
        String s = "HelloWorld";
        // 实例化类
        MethodObj  mo = new MethodObj();
        // 调用方法，重写接口的抽象方法，对象已经存在，成员方法已经存在
        // 直接通过对象名应用成员方法
        printString(s,mo::PrintUpperCaseString);
    }
}


```

- 通过supper引用父类成员方法
```java
public interface Greetable {
    public abstract void greet();
}

// 父类，定义一个成员方法，功能：打印输出字符串
public class Human {
    public void say(){
        System.out.println("Hello!!!");
    }
}

// 子类继承父类，重写父类方法
public class Man extends Human{
    @Override
    public void say() {
        System.out.println("Hello,I am a man");
    }
    // 定义一个成员方法，参数:函数接口
    public void method(Greetable g){
        g.greet();
    }

    // 定义一个成员方法，调用接口函数，通过supper引用父类函数
    public void invSuperFun(){
        method(super::say);
    }
}

public class StudyTest {
    public static void main(String[] args) {
        new Man().say();
        new Man().invSuperFun();
    }
}
```

- 类的构造方法引用
```java
public class StudyTest {
    public static Human create(String s, Greetable g){
        Human human = g.createHuman(s);
        return human;
    }
    public static void main(String[] args) {
        Human human = create("王岩", Human::new);
        System.out.println(human.getName());
    }
}
```

#### Junit测试

![image-20210709205433927](C:\Users\ASUS\AppData\Roaming\Typora\typora-user-images\image-20210709205433927.png)

```java
public class CalculatorTest {
    /**
     * 初始化方法：用于资源的申请，最先执行
     */
    @Before
    public void init(){
        System.out.println("init....");
    }
    
    /**
     *测试add方法
     */
    @Test
    public void testAdd(){
        Calculator c = new Calculator();
        int num = c.add(1,2);
        System.out.println(num);
        // 断言：参数1：期望的结果 参数2：实际的结果
        Assert.assertEquals(3,num);
    }

    /**
     * 释放资源的方法：最后执行
     */
    @After
    public void close(){
        System.out.println("close...");
    }
}
```



#### 反射

- **获取Class实例**

方法一：调用运行时类的属性 .class
```java
Class person = Person.class;
```
方法二：通过运用时类的对象，调用getClass()
```java
Class person = new Person().getClass();
```
方法三：调用Class的静态方法：forName(String classPath)
```java
 Class person = Class.forName("cn.wayan.one.learn.Person");
```
方法四：使用类加载器：ClassLoader
```java
Class person = Person.class.getClassLoader().loadClass("cn.wayan.one.learn.Person");
```




- **类加载器**

1. 获取**系统类加载器**加载自定义类
```java
 ClassLoader appClassLoader = PersonTest.class.getClassLoader();
```
2. 获取**扩展类加载器**
```java
 ClassLoader platFormClassLoader = PersonTest.class.getClassLoader().getParent();
```



- **读取配置文件**

方法一：文件流
```java
Properties pros = new Properties();
FileInputStream fis = new FileInputStream("admin.properties");
pros.load(fis);
        
// 读取配置文件中的数据，getProperty()：通过key获取value
String user = pros.getProperty("user");
String password = pros.getProperty("password");
System.out.println("user="+user+"  password="+password);
```
方法二：ClassLoader
```java
Properties pros = new Properties();
InputStream is = PersonTest.class.getClassLoader().getResourceAsStream("admin1.properties");
pros.load(is);

// 读取配置文件中的数据，getProperty()：通过key获取value
String user = pros.getProperty("user");
String password = pros.getProperty("password");
System.out.println("user="+user+"  password="+password);
```



- **通过反射创建类对象**

.getDeclaredConstructor().newInstance()：创建空参类对象
```java
Person person = Person.class.getDeclaredConstructor().newInstance();
```

