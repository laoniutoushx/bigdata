# 一、Hadoop





### Hadoop集群快速搭建（基于虚拟机）





本地运行 hadoop 问题

1. 设置 hadoop.home.dir

   ```
   System.setProperty("hadoop.home.dir", "G:\\hadoop-3.2.2");
   ```

2. 设置

   ```
   winutils.exe 放到 hadoop bin目录下
   ```

3. access报错

   粘贴源码 org.apache.hadoop.io.nativeio.NativeIO 类，重写 access 方法

   ```
   public static boolean access(String path, AccessRight desiredAccess)
   throws IOException {
   //            return access0(path, desiredAccess.accessRight());
   	return true;
   }
   ```

   

#### 提交 MapReduce 程序到集群并运行

1. mvn -package 打包程序 hadoop-test-1.0-SNAPSHOT

2. 上传到服务器

3. 提交 MapReduce 作业

   基本命令

   > ##### hadoop	jar	{jarFile}	[mainClass]	args
   >
   > ​	-jarFile: MapReduce 运行程序jar包
   >
   > ​	-mainClass：jar包中main函数所在类类名
   >
   > ​	-args：程序调用需要的参数【输入输出路径】

   ```
   进入 hadoop 目录中执行：
   cd /home/hadoop/app/hadoop-3.2.2
   
   执行作业：
   bin/hadoop jar hadoop-test-1.0-SNAPSHOT.jar sos.haruhi.hadoop.WordCount /text/hadoop-hadoop-datanode-hadoop01.log /text/output1
   
   执行作业：
   bin/hadoop jar hadoop-test-2.0-SNAPSHOT.jar wordcount /text/hadoop-hadoop-datanode-hadoop01.log /text/output2
   ```

   | bin/hadoop     | jar  | hadoop-test-1.0-SNAPSHOT.jar | sos.haruhi.hadoop.WordCount | /text/hadoop-hadoop-datanode-hadoop01.log | /text/output1 |
   | -------------- | ---- | ---------------------------- | --------------------------- | ----------------------------------------- | ------------- |
   | hadoop执行文件 | jar  | 项目jar名称                  | main方法所在类              | 输入文件在hadoop中路径                    | 输出文件路径  |

4. 查看执行结果

   ```
   bin/hdfs dfs -cat /text/output1/*
   ```

   