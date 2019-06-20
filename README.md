#### Transaction Fees Calculator

This application calculates the transaction fees and generates the invoice details for given transaction.

Framework Used :

This has been build using Spring Boot Framework - 2.1.6.RELEASE

Design: 

This application uses input file to process the results. The input file could be in wither in .txt, .csv or .xlsx format.

These various file types have been handles using Strategy Design Pattern. Also, instead of separating csv values using comma separator, we can use our own separator like | or any special character.

The file type and separator are to be ingested making use of application.properties or can be passed through command line arguement.

The default file type I have used is xlsx and comma separator. 

For the demo purpose, I have kept following three files on project directory. 

.txt - sampleData.txt
.xlsx - sampleDataExcel.xlsx
.csv with PIPE separator - sampleDataPIPE.csv 


#### How to Run the Program:

Case 1 : To run default sampleDataExcel.xlsx file

Step 1: Extract the zip file - SapeFeeCalcKurshit.zip
Step 2: Open Folder SapeFeeCalcKurshit
Step 3: Open command prompt and run following command on console 

	java -jar build\libs\SapeFeeCalcKurshit-0.0.1-SNAPSHOT.jar


The app gets up on default localhost:8080 port.

Step 4: Open the browser and hit this API end point : http://localhost:8080/generatereport/sampleDataExcel.xlsx

YUser should see output on console as per below :

Case 2 : To feed custom inputfile with filetype as argument, do the following

Step 1: Extract the zip file - SapeFeeCalcKurshit.zip
Step 2: Open Folder SapeFeeCalcKurshit
Step 3: Keep the custom input file at this directory. E.g. sampleData.txt 
Step 4:  Run following command

	java -jar build\libs\SapeFeeCalcKurshit-0.0.1-SNAPSHOT.jar --filetype=excel


The app gets up on default localhost:8080 port.

Step 4: Open the browser and hit this API end point : http://localhost:8080/generatereport/sampleDataExcel.xlsx

User should see output on console as per below :

The Calculated Fees:
Client Id | Transaction Type | Transaction Date | Priority | Processing Fee    |
--------------------------------------------------------------------------------
AP	| BUY	| Fri Nov 03 00:00:00 IST 13	| true	| 500	|
--------------------------------------------------------------------------------
AP	| BUY	| Thu Nov 09 00:00:00 IST 13	| true	| 500	|
--------------------------------------------------------------------------------
AP	| BUY	| Sun Nov 12 00:00:00 IST 13	| true	| 500	|
--------------------------------------------------------------------------------
AP	| DEPOSIT	| Mon Nov 06 00:00:00 IST 13	| true	| 500	|
--------------------------------------------------------------------------------
AP	| DEPOSIT	| Sun Nov 19 00:00:00 IST 13	| true	| 500	|
--------------------------------------------------------------------------------
AP	| SELL	| Sat Nov 25 00:00:00 IST 13	| true	| 500	|
--------------------------------------------------------------------------------
AS	| BUY	| Mon Nov 06 00:00:00 IST 13	| false	| 50	|
--------------------------------------------------------------------------------
AS	| DEPOSIT	| Thu Nov 02 00:00:00 IST 13	| false	| 50	|
--------------------------------------------------------------------------------
AS	| SELL	| Tue Nov 07 00:00:00 IST 13	| false	| 100	|
--------------------------------------------------------------------------------
AS	| SELL	| Fri Nov 10 00:00:00 IST 13	| false	| 100	|
--------------------------------------------------------------------------------
AS	| SELL	| Mon Nov 13 00:00:00 IST 13	| false	| 100	|
--------------------------------------------------------------------------------
AS	| SELL	| Mon Nov 20 00:00:00 IST 13	| false	| 100	|
--------------------------------------------------------------------------------
GS	| BUY	| Wed Nov 08 00:00:00 IST 13	| true	| 500	|
--------------------------------------------------------------------------------
GS	| BUY	| Thu Nov 23 00:00:00 IST 13	| true	| 500	|
--------------------------------------------------------------------------------
GS	| DEPOSIT	| Sat Nov 11 00:00:00 IST 13	| true	| 500	|
--------------------------------------------------------------------------------
GS	| WITHDRAW	| Wed Nov 01 00:00:00 IST 13	| true	| 500	|
--------------------------------------------------------------------------------
GS	| WITHDRAW	| Sun Nov 05 00:00:00 IST 13	| true	| 500	|
--------------------------------------------------------------------------------
GS	| WITHDRAW	| Sun Nov 26 00:00:00 IST 13	| true	| 500	|
--------------------------------------------------------------------------------
HJ	| SELL	| Sat Nov 04 00:00:00 IST 13	| false	| 100	|
--------------------------------------------------------------------------------
HJ	| WITHDRAW	| Thu Nov 30 00:00:00 IST 13	| false	| 100	|
--------------------------------------------------------------------------------

 
 
