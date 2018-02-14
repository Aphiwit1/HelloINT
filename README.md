# HelloINT

https://www.youtube.com/watch?v=NT8r1Z_6IcA&feature=youtu.be

# สิ่งที่จำเป็นต้องมี
 - Tomcat
 - Maven
 
# โครงสร้างฐานข้อมูลของโปรเจค
 - Database Name : HelloWorld
 - Table Name : hello
 - สามารถดู sql command ที่ใช้ได้ในไฟล์ hello.sql
 
# สิ่งที่ต้องทำก่อนการ deploy
หลังจากที่ clone ตัวโปรเจคลงมาแล้ว ให้เปิด bash และเข้าไปที่ directory ของโปรเจค โดยใช้คำสั่ง
```bash
cd ./src/main/resources
```

และใช้คำสั่ง
```bash
cp env.example.properties env.properties
```

จากนั้นใช้ text editor เข้าไปแก้ไขไฟล์ env.properties ที่สร้างมาเมื่อขึ้นตอนก่อนหน้า
```bash
CAREERITY_DB_IP=        \\ip address ของ database ที่จะเข้าไปเชื่อมต่อ
CAREERITY_DB_NAME=      \\ชื่อของ database
CAREERITY_DB_USER=      \\username ที่ใช้เข้าถึง database
CAREERITY_DB_PASS=      \\password ที่ใช้เข้าถึง database
CAREERITY_DB_PORT=      \\port ของ database
```

กลับมาที่ directory ของโปรเจคโดยใช้คำสั่ง
```bash
cd ../../..
```

# Deploy ลง tomcat
ทำการ download dependency ของตัวโปรเจคโดยใช้คำสั่ง
```bash
mvn install
```

ในการ depoly นั้นสามารถแก้ context path จะไป depoly ได้โดยเข้าไปแก้ที่ไฟล์ pom.xml ที่ tag path
```bash
.
.
<configuration>
  <url>http://127.0.0.1:8080/manager/text</url>
  <server>TomcatServer</server>
  <path>/${project.artifactId}</path>
</configuration>
.
.
```

เข้าไปที่ ${MAVEN_HOME}/conf และเปิดไฟล์ settings.xml ด้วย text editor
และเพิ่ม field ที่ tag server ดังนี้
```bash
 <server>
 .
 .
   <server>
      <id>TomcatServer</id>
      <username>admin</username>      \\username ที่ใช้ login tomcat
      <password>password</password>   \\password ที่ใช้ login tomcat
   </server>
</server>
```

สามารถ deploy ลง tomcat ได้โดยใช้คำสั่ง
```bash
mvn tomcat7:deploy
```
เมื่อต้องการอัพเดตโปรเจคให้ใช้คำสั่ง
```bash
mvn tomcat7:redeploy
```
เมื่อต้องการยกเลิกการ deploy ให้ใช้คำสั่ง
```bash
mvn tomcat7:undeploy
```

