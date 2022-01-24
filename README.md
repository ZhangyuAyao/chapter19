# chapter19
IO
![image.png](https://note.youdao.com/yws/res/4/WEBRESOURCE32f6962d9275382c180a57007d582414)

---

# 文件
- 什么是文件？
文件就是==保存数据的地方==

- 文件流
文件在程序中是以流的形式来操作的
![image.png](https://note.youdao.com/yws/res/f/WEBRESOURCE9ea983844c4b66ea59fecb3a807be51f)
流：数据在数据源（文件）和程序（内存）之间经历的路径
输入流：数据从数据源（文件）到程序（内存）的路径
输出流：数据从程序（内存）到数据源（文件）的路径

## 常用文件操作
- 相关方法
1. new File(String pathname)//根据路径构建一个File对象
2. new File(File parent, String child)//根据父目录文件+子路径构建
3. new File(String parent, String child) 根据父目录+子路径构建

```
    @Test
    public void create01() {
        String filePath = "d:\\news1.txt";
        File file = new File(filePath);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式2 new File(File parent, String child)//根据父目录文件+子路径构建
    //e:\\news2.txt
    @Test
    public void create02() {
        File parentFile = new File("d:\\");//这里只是在内存里面创建了一个file对象
        String fileName = "news2.txt";
        File file = new File(parentFile, fileName);
        try {
            file.createNewFile();//只有在执行了 file.createNewFile 才会真正地在磁盘创建文件
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    //方式3 new File(String parent, String child) 根据父目录+子路径构建
    public void create03() {
        String parentPath = "d:\\";
        String fileName = "news3.txt";

        File file = new File(parentPath, fileName);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
File file = new File(stringPath) 只是创建一个文件在内存中
file.createNewFile 才真正将内存中的文件写入磁盘
- 获取文件的相关信息
1. file.getName 
2. file.getAbsoulutePath 
3. file.getParent 
4. file.length 文件的大小（字节）
5. file.exists
6. file.isFile
7. file.isDirectory

- 目录的操作和文件删除
1. mikdir创建一级目录
2. mkdirs创建多级目录
3. delete删除空目录或文件

---

# IO流原理及流的分类
- java IO流原理
1. I/O是input和output的的缩写，I/O技术是非常常用的技术，用于处理数据传输。如读/写文件，网络通讯等
2. java程序中，对于数据的输入/输出操作以“流（Stream）”的方式进行
3. java.io包下提供了各种"流"类和接口，用以获取不同种类的数据，并通过方法输入或输出数据
4. 输入input：读取外部数据（磁盘，光盘等存储设备的数据）到程序（内存）中。
5. 输出output：将程序（内存）数据输出到磁盘、光盘等存储设备中

![image.png](https://note.youdao.com/yws/res/a/WEBRESOURCEfb467dd12e6af70b8451d731b08eb72a)

- 流的分类
1. 按操作数据单位不同分为：字节流（8bit）二进制文件，字符流（按字符）文本文件
2. 按数据流的流向不同分为：输入流，输出流
3. 按流的角色的不同分为：节点流，处理流/包装流

![image.png](https://note.youdao.com/yws/res/2/WEBRESOURCEcc9abc5ef43f9d53747f4a95d10c7ab2)
==1. java的IO流涉及40多个类，实际上非常规则，都是从如上4个抽象基类派生的
2. 由这四个类派生出来的子类名称都是以其父类名作为子类名后缀==

![image.png](https://note.youdao.com/yws/res/3/WEBRESOURCEfc6091264036a029fb1a4c5217534b43)
> 这里要注意理解流的含义：要注意和文件区分开来，类似于外卖小哥的存在，用于输送货物。



## FileInputStream
![image.png](https://note.youdao.com/yws/res/5/WEBRESOURCEc13667cf6222438bc1835fd03684cb05)
案例：使用输入流从文件中输入字符到控制台

```
    String filePath = "d:\\hello.txt";
    //1. 创建字节流，绑定对应的文件
    FileInputStream fileInputStream = new FileInputStream(filePath);
    
    //2. read()方法返回一个一个字节，一般使用while循环读取
    readData = fileInputStream.read();

    //3. read(byte[] b)读取文件、提高读取效率。将字节依次读入长度为8的数组byte中.返回值readLen是实际返回的长度，如果已经到头了，则返回-1
    byte[] buf = new byte[8]; 
    readLen = fileInputStream.read(buf)
    
    
```
具体代码：

```
   @Test
    public void readFile01() {
        String filePath = "d:\\hello.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建 FileInputStream 对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取一个字节的数据，如果没有输入可用，此方法将阻止。
            //如果返回-1，表示读取完毕
            try {
                while ((readData = fileInputStream.read()) != -1) {
                    System.out.print((char)readData);//转成char显示
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //关闭文件流，释放资源
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 使用read(byte[] b)读取文件、提高读取效率
     */
    @Test
    public void readFile02() {
        String filePath = "d:\\hello.txt";
        int readData = 0;
        //字节数组
        byte[] buf = new byte[8]; //一次读取8个字节
        int readLen = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建 FileInputStream 对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取一个字节的数据，如果没有输入可用，此方法将阻止。
            //如果返回-1，表示读取完毕
            try {
                while ((readLen = fileInputStream.read(buf)) != -1) {
                    System.out.print(new String(buf, 0, readLen));//显示
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //关闭文件流，释放资源
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
```

## FileOutputStream
![image.png](https://note.youdao.com/yws/res/a/WEBRESOURCE92a855c4c3650e5485a5e4f23259aeda)
案例：使用输出流将内存中的字符输出到文件中
```
    String filePath = "d:\\a.txt";

    //1. new FileOutPutStream(filePath)创建方式，当写入内容时，会覆盖原来的内容

    //2. new FileOutPutStream(filePath, true)创建方式，当写入内容时，会追加到文件后面
    fileOutputStream = new FileOutputStream(filePath, true)

    //写入单个字符
    fileOutputStream.write('H');

    //写入多个字符
    String str =  "hello, world!";
    fileOutputStream.write(str.getBytes());
    //指定写入的字符长度
    fileOutputStream.write(str.getBytes(), 0, str.length());

```
具体代码：

```
    @Test
    public void writeFile() {
        String filePath = "d:\\a.txt";
        FileOutputStream fileOutputStream = null;

        try {
            //老师说明
            //1. new FileOutPutStream(filePath)创建方式，当写入内容时，会覆盖原来的内容
            //2. new FileOutPutStream(filePath, true)创建方式，当写入内容时，会追加到文件后面
            //得到 FileOutPutStream对象
            fileOutputStream = new FileOutputStream(filePath, true);
            //1. 写入一个字节
            //fileOutputStream.write('H'); //char可以自动转成int
            //2. 写入字符串
            String str =  "hello, world!";
            //fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.write(str.getBytes(), 0, str.length());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

```
## 拷贝文件
拷贝过程：
1. 通过输入流，将文件输入到内存中
2. 通过输出流，将内存中的数据输出到文件中

## IO流体系图-常用的类
- FileReader 和 FileWriter
FileReader 和 FileWriter 是字符流，即按照字符来操作io

- FileReader相关方法：
1. new FileReader（File/String)
2. read 每次读取单个字符，返回该字符，如果文件末尾返回-1
3. read(char[])：批量读取多个字符到数组，返回读取到的字符数，如果到文件末尾返回-1
    1）new String（char[]):将char[]转换成String
    2）new String（char[], off, len)：将char[]的指定部分转换成String

![image.png](https://note.youdao.com/yws/res/a/WEBRESOURCE83f3d1046586918aa43a16895834958a)

- FileWriter的相关方法

1. new FileWriter(File/String):覆盖模式，相当于流的指针在首端
2. new FileWriter(File/String, true):追加模式，相当于流的指针在尾端
3. write(int):写入单个字符
4. write(char[])：写入指定数组
5. write(char[], off, len):写入指定数组的指定部分
6. write(String): 写入整个字符串
7. write(String, off, len):写入字符串的指定部分
相关API：String类：toCharArray: 将 String 转换成 char[]
> 注意：FileWriter使用后，必须要关闭（close)或刷新(flush),否则写入不到指定的文件！

![image.png](https://note.youdao.com/yws/res/e/WEBRESOURCE9a4e2334bb3dab757bb68f293b547a6e)

---
# 节点流和处理流
- 基本介绍
1. 节点流可以从一个特定的数据源==读写数据==，如FileReader、FileWriter

![image.png](https://note.youdao.com/yws/res/5/WEBRESOURCE175c813db5d2c8fb37bd1083ab8dbd55)

2. 处理流（也叫==包装流==）是“连接”在已存在的流（节点流或处理流）之上，为程序员提供更为强大的读写功能，也更加灵活，如BufferedReader、BufferedWriter

![image.png](https://note.youdao.com/yws/res/5/WEBRESOURCE0aecc9e44561b8dfb7180c95bd3ef3c5)

![image.png](https://note.youdao.com/yws/res/7/WEBRESOURCE90765574ed111d7f1706be5f61ac32e7)
例如：BufferedReader 类中，有属性Reader，即可以封装一个节点流，该节点流可以是任意的。只要是Reader 子类就可以。因此处理流的功能相当强大

```
    //这里Writer 的子类，如下图的字符流、数组流、管道流等都可以作为参数传入BufferedReader()中。

    BufferedReader(Writer)
```
![image.png](https://note.youdao.com/yws/res/d/WEBRESOURCE7f9b4bac5e117055ef88145a16a4ff2d)

- 节点流和处理流的区别和联系
1. 节点流是底层流/低级流，直接跟数据源相接
2. 处理流（==包装流==）包装节点流，既可以消除不同节点流的实现差异，也可以提供更方便的方法来完成输入输出
3. 处理流（也叫包装流）对节点流进行包装，使用了修饰器设计模式，不会直接与数据源相连【==修饰器设计模式==】

- 处理流的功能主要体现在以下两个方面：
1. 性能的提高：主要以增加缓冲的方式来提高输入输出的效率
2. 操作的便捷：处理流可能提供了一系列便捷的方法来一次输入输出大批量的数据，使用更加灵活方便

==模拟修饰器设计模式==
1. 抽象类Reader
2. 节点流FileReader、StringReader继承了Reader
3. 处理流（包装流），里面增加一个Reader类型的成员，则节点流因为继承了 FileReader 和 StringReader 可以在包装流中对不同的节点流进行处理

## 处理流
### BufferedReader 和 BufferedWriter

```
    br = new BufferedReader(new FileReader(srcFilePath));
    bw = new BufferedWriter(new FileWriter(destFilePath));


    //说明：readLine 读取一行内容，但是没有换行
    while ((line = br.readLine()) != null) {
        //每读取一行，就写入
        bw.write(line);
        //插入一个换行
        bw.newLine();
    }
```

- BufferedReader 和 BufferedWriter 属于==字符流==，是按照字符来读取数据的
- 关闭时处理流，只需要关闭外层流即可

> 1. BufferedReader 和 BufferedWriter 是按照字符串操作
> 2. 不要去操作二进制文件 [声音、视频、doc、pdf 等等]，可能会造成文件损坏

### BufferedInputStream 和 BufferedOutputStream
BufferedInputStream 和 BufferedOutputStream 是字节流，可以用于处理二进制文件[声音、视频、doc、pdf 等等]


> 思考：字节流可以操作二进制文件，可以操作文本文件吗？
> 当然可以


```
    bis = new BufferedInputStream(new FileInputStream(srcFilePath));
    bos = new BufferedOutputStream(new FileOutputStream(destFilePath));

    //循环的读取文件，并写入到 destFilePath
    byte[] buff = new byte[1024];
    int readLen = 0;

    while ((readLen = bis.read(buff)) != -1) {
        bos.write(buff, 0, readLen);
    }
```
