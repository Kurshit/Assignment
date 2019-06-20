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

	java -jar build\libs\<>.jar


The app gets up on default localhost:8080 port.

Step 4: Open the browser and hit this API end point : http://localhost:8080/generatereport/sampleDataExcel.xlsx

YUser should see output on console as per below :

Case 2 : To feed custom inputfile with filetype as argument, do the following

Step 1: Extract the zip file - SapeFeeCalcKurshit.zip
Step 2: Open Folder SapeFeeCalcKurshit
Step 3: Keep the custom input file at this directory. E.g. sampleData.txt 
Step 4:  Run following command

	java -jar build\libs\<>.jar --filetype=txt


The app gets up on default localhost:8080 port.

Step 4: Open the browser and hit this API end point : http://localhost:8080/generatereport/sampleDataExcel.txt

YUser should see output on console as per below :
 
 
