# Java Gauge Example

## Articles written about this project

## Project Setup

* Install Chocolatey by executing the following Command Prompt as Administrator:

```
@"%SystemRoot%\System32\WindowsPowerShell\v1.0\powershell.exe" -NoProfile -InputFormat None -ExecutionPolicy Bypass -Command "iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))" && SET "PATH=%PATH%;%ALLUSERSPROFILE%\chocolatey\bin"
```

* Install Gauge by executing the following command:

```
choco install gauge
```

* execute following commands:

```
gauge install java
gauge install html-report 
```

* Clone the project
* Navigate to the project directory

## Running Tests with report

```
run sampleTest.spec file
```