The ana_code includes the analytical command and code. The Hive_analysis includes the analysis using Hive like correlation, avg values. 
The three txt starting with Hive_table are the commands used to create tables. The scala_regression_correlation txt are the commands to do the regression and correlation analysis.

In data_ingest, since we use fixed dataset from NYC open data, so what we need is only scp and put them in hdfs.

The ETL code used by Haoliang Tian have three parts. The first part(first_clean) cleans the data for the analysis that counts the borough
The reclean counts the borough and the purpose is to adjust the first cleaning to allow the joining in Hive table.
The third part is the clean_no_borough which does not count the borough, since there are a lot of invalid data record if count borough.

The profiling code is just the profiling code.

The screenshots include the screenshot of our command and the name of the screen shot shows what the command is doing.

The test_code include the chicago folder which is the cleaning code of chicago dataset. We decide to not use this dataset finally, so it is not that useful.

The raw data are in /user/ht1128/project/nyc_crash.csv
/user/ht1128/project/new_nyc_temp_crash_edit.csv
/user/ht1128/project/nyc_temp_full_new.csv
/user/ht1128/project/raw_data/nyc_weather.csv
/user/ht1128/project/raw_data/chicago_weather.csv