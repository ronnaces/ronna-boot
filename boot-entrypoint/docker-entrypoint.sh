#!/bin/bash
################################################
# docker-entrypoint
# @author KunLong-Luo
# @version 1.0.0
# @since 2023-03-16 10:50:00
################################################

OPTIONS="\
-XX:+UseZGC \
-XX:ZCollectionInterval=120 \
-XX:ZAllocationSpikeTolerance=4 \
-XX:-ZProactive \
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
-XX:HeapDumpPath=./errorDump.hprof \
-Xlog:safepoint=trace,classhisto*=trace,age*=info,gc*=info:file=./gc-%t.log:time,level,tid,tags:filesize=5M"

exec java ${OPTIONS} -jar ./app.jar && 1
