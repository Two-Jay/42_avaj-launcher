#/bin/bash

# if $1 is not exist, then echo "Usage: run.sh [scenario file]"
if [ ! $1 ]; then
    echo "Usage: run.sh [scenario file name in resource/scenario without .txt]"
    echo "Example: bash run.sh subject_scenario"
    exit 0
fi
# Clean
if [ $1 = "clean" ]; then
    # Clean
    find * -name "*.class" -delete
    rm -f sources.txt
elif [ $1 = "fclean" ]; then
    # Clean
    find * -name "*.class" -delete
    rm -f sources.txt
    rm -f simulation.txt
else
    # Compile
    find * -name "*.java" > sources.txt
    javac @sources.txt
    java kr.ft.avaj.simulator.main $PWD/resource/scenario/$1.txt
fi


