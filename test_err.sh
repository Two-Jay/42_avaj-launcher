#/bin/bash

err_file_list=( "err_AircraftType_00" "err_AircraftType_01" "err_AircraftType_02" "err_AircraftType_03" "err_AircraftType_04"
    "err_count_00" "err_count_01" "err_count_02" "err_height_00" "err_height_01" "err_leaked_00" "err_leaked_01" "err_leaked_02" "err_leaked_03" "err_leaked_04"
    "err_negetive_00" "err_negetive_01" "err_negetive_02" "err_nodata")

for err_file in ${err_file_list[@]}; do
    echo "Test $err_file"
    bash run.sh $err_file
done

# if simulation.txt is not exist, then echo "SUCCESS" on console with green color
# or echo "FAIL" with red color
if [ ! -f simulation.txt ]; then
    echo -e "\033[32mSUCCESS\033[0m"
else
    echo -e "\033[31mFAIL\033[0m"
fi
