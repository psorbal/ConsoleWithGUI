# Console
Console with a built-in graphical user interface which will allow user to execute a few commands as described below.

## All available commands in console
### prompt
User can customize the presented prompt using a ***prompt*** command with a parameter.
Possible values of the parameter:
* ***$cwd*** will result in displaying a path to current working directory in the prompt
* ***reset*** will reset the prompt to default ($ sign)
* Any other string will display the parameter in the prompt.

**Example:**
```sh
[MyShell] $>prompt nice
[MyShell] nice>prompt reset
[MyShell] $>prompt $cwd
[MyShell] /home/user/project/console/target>prompt end
[MyShell] end>prompt reset
[MyShell] $>
```

### dir
User can display the content of current working directory using a ***dir*** command.
Format of the display: type of the item (DIR|FILE) and name of the item.

**Example:**
```sh
[MyShell] $>dir
Content of /home/user/project/console/target
DIR classes
DIR generated-sources
DIR maven-archiver
FILE shell-1.0.jar
DIR surefire
[MyShell] $>
```

### cd
User can change the current working directory using a ***cd*** command with a parameter:
* **..** for parent directory
* Name of existing subdirectory

**Example:**
```sh
[MyShell] $>prompt $cwd
[MyShell] /home/user/project/console/target>cd classes
[MyShell] /home/user/project/console/target/classes>cd pl
This subdirectory does not exist
[MyShell] /home/user/project/console/target/classes>cd ..
[MyShell] /home/user/project/console/target>cd ..
[MyShell] /home/user/project/console>
```

### tree
User can display the directory structure of current working directory
and its subdirectories using a ***tree*** command.

**Example:**
 ```sh
 [MyShell] $>tree
 target
 -classes
 --com
 ---projects
 ----console
 -generated-source
 --annotations
 -maven-archiver
 -surefire
 [MyShell] $>
 ```
### ctdir
User can create a new directory in current working directory using a ***ctdir*** command.

**Example:**
 ```sh
 [MyShell] $>ctdir newDirectory
 Directory newDirectory is created!
 [MyShell] $>ctdir newDirectory
 newDirectory directory exist in this current working directory
 [MyShell] $>
 ```
### ctfile
User can create a new file in current working directory using a ***ctfile*** command.

**Example:**
 ```sh
 [MyShell] $>ctfile newfile
 newfile is created!
 [MyShell] $>ctfile newfile
 newfile already exists
 [MyShell] $>
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
[MyShell] $>delete nice
nice is deleted
[MyShell] $>delete ok*
okay is deleted
oki is deleted
okk id deleted
[MyShell] $>delete .txt
yes.txt is deleted
nope.txt is deleted
[MyShell] end>delete nonexists
Delete operation has failed
[MyShell] $>delete all
del.txt is deleted
end is deleted
[MyShell] $>
```

### exit
User can terminate the application by using ***exit*** command.

**Example:**
```sh
[MyShell] $>exit
Bye.
```

### unknown command
Any other command shall result in displaying

**Example:**
```sh
[MyShell] $>hello computer
hello computer : unknown command
[MyShell] $>why nothing works
why nothing works : unknown command
```

