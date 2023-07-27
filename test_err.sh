#/bin/bash

err_file_list=( "err_AircraftType_00" "err_AircraftType_01" "err_AircraftType_02" "err_AircraftType_03" "err_AircraftType_04"
    "err_count_00" "err_count_01" "err_count_02" "err_height_00" "err_height_01" "err_leaked_00" "err_leaked_01" "err_leaked_02" "err_leaked_03" "err_leaked_04"
    "err_negetive_00" "err_negetive_01" "err_negetive_02" "err_nodata")

success_count=0
for err_file in ${err_file_list[@]}; do
    echo "Test $err_file start ..."
    bash run.sh $err_file
    if [ $? -eq 1 ]; then
        echo -e "\033[32mSUCCESS\033[0m"
        success_count=$((success_count+1))
        sleep 0.5
    else
        echo -e "\033[31mFAIL\033[0m"
    fi
done

if [ $success_count -eq ${#err_file_list[@]} ]; then
    echo -e "\033[32mAll test cases passed!\033[0m"
else
    echo -e "\033[31m$(( ${#err_file_list[@]} - $success_count )) test cases failed!\033[0m"
fi