#!/bin/bash
  
mvn clean package
rm -f *.log

declare -a gc=("SerialGC" "ParallelGC" "ConcMarkSweepGC" "G1GC")

for i in "${gc[@]}"
do
    cmd="java -jar -Xmx512m -Xms512m -XX:+Use$i target/L104-1.0-SNAPSHOT.jar"
    printf "\n$i\n"
    printf "$cmd\n"
    $cmd | tee "$i.log"
done
