#!/bin/bash
################################################
# docker-entrypoint
# @author KunLong-Luo
# @version 1.0.0
# @since 2023-03-16 10:50:00
################################################

OPTIONS="\
-Dio.netty.noUnsafe=true \
-XX:+UseG1GC \
-XX:+UseContainerSupport \
-XX:InitialRAMPercentage=40.0 \
-XX:MinRAMPercentage=40.0 \
-XX:MaxRAMPercentage=40.0 \
-XX:MaxGCPauseMillis=100 \
-XX:MaxMetaspaceSize=256m \
-XX:CompressedClassSpaceSize=128m \
-XX:MaxDirectMemorySize=64m \
-XX:InitialCodeCacheSize=64m \
-XX:MetaspaceSize=128m \
-XX:ReservedCodeCacheSize=64m \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=./ \
-XX:+PrintGCDetails \
-XX:+PrintGCTimeStamps \
-XX:+PrintGCDateStamps \
-Xloggc:./gc.log \
-XX:+UseGCLogFileRotation \
-XX:NumberOfGCLogFiles=5 \
-XX:GCLogFileSize=3M \
-XX:+PrintHeapAtGC \
-XX:+PrintTenuringDistribution"

exec java ${OPTIONS} -jar ./app.jar && 1
