# Console
Console with a built-in graphical user interface which will allow user to execute a few commands as described below.

Screenshot from GUI:
![Screenshot](https://github.com/szemyxz/ConsoleWithGUI/blob/master/gui.png)

## All available commands in console
### dir
User can display the content of current working directory using a ***dir*** command.
Format of the display: type of the item (DIR|FILE) and name of the item.

**Example:**
```sh
>dir
Content of /home/user/project/console/target
DIR classes
DIR generated-sources
DIR maven-archiver
FILE shell-1.0.jar
DIR surefire
>
```

### cd
User can change the current working directory using a ***cd*** command with a parameter:
* **..** for parent directory
* Name of existing subdirectory

**Example:**
```sh
/home/user/project/console/target>cd classes
/home/user/project/console/target/classes>cd pl
This subdirectory does not exist
/home/user/project/console/target/classes>cd ..
/home/user/project/console/target>cd ..
/home/user/project/console>
```

### tree
User can display the directory structure of current working directory
and its subdirectories using a ***tree*** command.

**Example:**
 ```sh
>tree
 target
 -classes
 --com
 ---projects
 ----console
 -generated-source
 --annotations
 -maven-archiver
 -surefire
>
 ```
### ctdir
User can create a new directory in current working directory using a ***ctdir*** command.

**Example:**
 ```sh
>ctdir newDirectory
 Directory newDirectory is created!
>ctdir newDirectory
 newDirectory directory exist in this current working directory
>
 ```
### ctfile
User can create a new file in current working directory using a ***ctfile*** command.

**Example:**
 ```sh
>ctfile newfile
 newfile is created!
>ctfile newfile
 newfile already exists
>
 ```

### delete
User can delete files using a ***delete*** command with a parameter.
Possible values of the parameter:
* ***all*** will delete all files (also directory and his subdirectory!) in current working directory
* ***.**** will delete files ends with regex (eg. with extension .txt)
* ****.*** will delete files starts wit regex (eg. with ok*)
* Any other string will delete name of single file if exists

**Example:**
```sh
>delete nice
nice is deleted
>delete ok*
okay is deleted
oki is deleted
okk id deleted
>delete .txt
yes.txt is deleted
nope.txt is deleted
>delete nonexists
Delete operation has failed
>delete all
del.txt is deleted
end is deleted
>
```

### exit
User can terminate the application by using ***exit*** command.

**Example:**
```sh
>exit
Bye.
```

### unknown command
Any other command shall result in displaying

**Example:**
```sh
>hello computer
hello computer : unknown command
>why nothing works
why nothing works : unknown command
```

