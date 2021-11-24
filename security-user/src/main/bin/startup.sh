cd /opt/lc-security

#java -Xms2G -Xmx2G -Xmn1G -jar security-user-1.0.0-SNAPSHOT.jar

# Serial + Serial Old: 单线程、低延迟
java -Xms2G -Xmx2G -Xmn1G -XX:+UseSerialGC -jar security-user-1.0.0-SNAPSHOT.jar

# Parallel Scavenge + Parallel Scavenge Old: 多线程、高吞吐量
java -Xms2G -Xmx2G -Xmn1G -XX:+UseParallelGC -XX:+UseParallelOldGC -jar security-user-1.0.0-SNAPSHOT.jar

# CMS + ParNew: 多线程、低延迟
java -Xms2G -Xmx2G -Xmn1G -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -jar security-user-1.0.0-SNAPSHOT.jar

# G1
java -Xms2G -Xmx2G -Xmn1G -XX:+UseG1GC -XX:MaxGCPauseMillis=50 -jar security-user-1.0.0-SNAPSHOT.jar