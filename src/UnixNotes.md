*********************UNIX/Linux  *****************************


- Intro:
    - There are various Unix variants available in the market. Solaris Unix, Linux(free)
    - OS = Kernal
    - Kernal is heart of OS as it talks direclty talk to hardware.
    - User uses shell to talk with Kernal
    - Shell is utilty that process request,  shell interprets the command and calls the program that you want
    - Command and Utilties :  There are 250 commands for day to day use like cp, mv , cat and grep.
    - Files and Direcotry :  These files and directories are organized in to tree like filesystme.
    - /etc/profile maintained by Sytem Admin of Unix that has shell initialization info required by all users on system.


- File Management:
    - Three basic types of files
    - Ordinary Files : file on system that contains data, text etc.
    - Directory : It stores both sprecial and oridnary files like FOLDER.
    - Special Files : file provides access to hardware such as hard drives , CD-ROM , modems.

    - Listing Files:
      $ls : list files and dircotry in current path or folder or direcotry
      $ls -l : to get more info about listed files.
      --> First Column : shows file type and permission givne to file.
      --> Second Column : number of meory blocks taken by the file or dir.
      --> Third Column : owner of file
      --> Fourth Column : group owner of file
      --> Fifth Column : size in bytes
      --> Sixth Column : date and tiem for created or modified.
      --> Seventh Column : file or direcotry name.

      e.g. drwxr-xr-x  11  amrood   amrood  4096  May 29 2007  zlib-1.2.3
      Here lines begins wiht 'd' ==> drwxr-xr-x i.e. Its Direcotry file. Like wise it can be
      - 'b' - block input/output device file file i.e. physical device.
      - 'c' - char i.e. Row input/output.....
      - 'I' - Symbolic file such as link to another file.
      - 'P' - Named pipe a mechanism for interprocess communication
      - '-' - Regular file e..g text , ASCII , binary , executable file etc..
      $ ls ch*.doc: file starts with ch with .doc
      $ ls *.doc : all files with .doc

    - Hidden File : File which has first char is '.' , Shell uses these files to store configuration.
        -  common hidden files .profile (Bourne shell ( sh) initialization script) , .rhosts(he remote shell configuration file)
        -  $ls -a will list hiddne files.
        -  when  list files there are below files comes
           '.' i..e current folder/direcotry`
           '..' i.e parent direcotry.

    - Creating / Edit / View / properties / Copy / Rename / Delete Files:

      -> "vi" editor is used in Unix system to create file.
      -> $ vi filename_test command will create and open file once its opened press "i" for edit and then write in to file
      -> $ cat filename_test comnand will display content of file.
      -> $ wc filename_test will tell count of total lines, word and char in file.
      -> $ cp sourcefile destinationfile will copy file.
      -> $ mv oldfile newfile will rename old file wiht new file name
      -> $ rm filename_test will delete it. $rm file1 file2 file3 will delete all.

    - Search files :

        - Piple '|' (filter) and grep command.
        - | is taking input from fist command and send it to next one. e.g. see in grep e.g.
        - grep searches for files based on pattern (regex pattern)
            -  $ls -l | grep "Aug" i.e. list via search only file info contains "Aug"
            -  $ls -l | grep -i "carol.*aug" (-i makes in case insensitive)
            -  $ls -l | grep "Aug" | sort +4n (sorts all files in your directory modified in August by the order of size)
               -rw-rw-r--  1 carol doc      1605 Aug 23 07:35 macros
               -rw-rw-r--  1 john  doc      2488 Aug 15 10:51 intro
               --> Remember : $ls-l list out info and this 4 is belongs to cloumn # of that list.

- Direcotry Management:
    - All files and other direcotires are organized as Tree structure.
    - the Root '/' under all direcotires and files reside.
    - when you login first it starts with Home Direcotry. Most of work does under this Home Direcotry and its subdirectories.
    - From anywhere type $cd ~ OR $ cd ~ tatodara  will take you to the home.
    - also $cd - will talke you to the last direcory.
    - Absoulte path e.g : it starts with / bcs its start with Root.
      /etc/passwd
      /users/sjones/chem/notes
    - Relative path e.g. : it DOES NOT start with / as its belongs to current working direcory.
      chem/notes
      personal/res
    - $ pwd will print current working dircotry.
    - $ls direcotryName will list direcotry.
    - $mkdir dirName will create direcotry.
    - $mkdir /tmp/dirName will create directory in temp folder.
    - $mkdir docs pub will create 2 folder docs and pub.
    - $mkdir -p /tmp/doc1/pub1/dirName will create all direcotry/subdirecotry before creates dirName if not exists.
    - $rmdir dirName will remove folder.
    - $cd /usr/local/bin changes to directory /usr/local/bin  from whereever its now.
    - $mv olddirName newDirName to rename.
    - '. ' is current direcotry and '..' is direcotry one level above current one.

- File Permission:
    - Evey file in unix has below attributes.
    - Owner premission -
    - Group permission
    - Other or World permission - users who dont belongs owner or part of any group.
    - $ls -l will shows permission of file. e.g. drwxr-xr--- or  -rwxr-xr--
      e.g.
      "-rwxr-xr--"
      rwx ( 2 to 4) , owner permission, read, write and execute
      r-x( 5 to 7) , group permission, read and execute only
      r--(8 to 10),  everyone read only..

      	'-' this represent regular files like txt, pdf etc and 'd' represent direcotry.

      "-rwxrwxrwx" (i.e. read,write ,excute for all)

    - changing permission via commad "chmod" (change mode)
        - two ways to use symbolic or absolute mode
        - Symbolic Mode:
            - $chmod o+wx test_file.txt # add permisssion
              "-rwxrwxr--" to "-rwxrwxrwx" (here o+wx ,o i.e others)

            - $chmod u-x test_file.txt to remove permission
              "-rwxrwxr--" to "-rw-rwxr--" (here u-x ,u i.e user)
              $chmod g = rx  test_file.txt to set permission
              "-rwxrwxr--" to "-rwxr-xr--" (here g = rx ,g i.e group)
            - combine all command in onle line
              $chmod o+wx,u-x,g = rx testfile

        - Absoulte : here we use number to specify each set of permission.
          0	No permission (---)
          1	Execute permission (--x)
          2	Write permission (-w-)
          3	Execute and write permission: 1+2
          4	Read permission
          5	Read and execute permission
          6	Read and write permission (rw-)
          7	All permissions (rwx)

            - $ chmod 755 test_file.txt
              "-rwxrwxr--" to "-rwxr-xr-x" (7 user 5 group and 5 others)
        - Change owner of file $chown tatodaria test_file.txt will change existing user to tatodaria.
        - Change group of file $chgrp efsgropu test_file.txt will change existing user to efsgroup.

        - Password is stored in /etc/shadow file and sepecial permission needed to chagge it. These permissiong is given to program via mechanism known as SUID AND SGID i.e Set User or Group Id bits.
            - 's' (small) will appear in permission if available.
              e.g. $ ls -l /usr/bin/passwd will print -r-s-xr-x
              Shows that the SUID bit is set and that the command is owned by the root.
              if "S" (CAPITAL) then its not set.


*********************UNIX/Linux Shell Script  *****************************

- Program/Script to be run by Linux/Unix system. Basically it provides interface to UNIX system.
- Many type of shell script e.g. Bourne Shel , GNU Bourne shell etc.
- Shell script performs things like program execution, read text, file manupulation.
- prompt, $ its called command prompt and is issued by shell.
- Bourne shell its $ AND for C shell its %
- Bourne shell has following categories.
    - Bourne shell (sh)
    - bourne again shell (bash)
    - Bourne shell is usually installed as /bin/sh on most UNIX system.
    - its best choise as shell compare to other shell scripts.
    - Shell scripts and functions are both interpreted. This means they are not compiled
- Bourne shell
    - Exmaple script.
        - create test.sh
        - before anything write in shell script  we need to alert system that shell script is starting.
        - this is done by shebang i.e. #! /bin/sh . tells the system that the commands that follow are to be executed by the Bourne shell

      #! /bin/sh

      # Auther Tejpal

      pwd
      ls
      read $NAME
      echo "Hello" $NAME

      Save the above content and make script executable.
      $chmod +x test.sh

      execut it.

      $./test.sh

    - Variables:
        - Name of variable either a to z, A to Z , 0 to 9 or _
        - Declaring variable : NAME = "Tejpal" , AGE = 38.
        - Accessing variable : $AGE
        - Read only variable :
          Score = 90
          readonly Score
          Score = 85 will throw exception.
        - Unset variable :
          Score = 98
          unset Score
          echo $Score ... will not print anything.

        - Types of Variable
            - Local : present within current instance of shell only.
            - Env : available to any child process of shell
            - Shell : it is set by Shell and require by Shell to run shell scripting.

        - Special variable can be used in script

            - $0 filename of the current script
                - echo "File Name: $0" --> File Name : ./test.sh
            - $n correspond to the arguments with which a script was invoked and n is position of argument.
            - $# number of arguments supplied to a script.
                - echo "Total Number of Parameters : $#" --> "Total Number of Parameters : 2
            - $* arguments are double quoted. If a script receives two arguments, $* is equivalent to $1 $2
            - $@ arguments are individually double quoted. If a script receives two arguments, $@ is equivalent to $1 $2
                - both work like same but unless enclosed by "".
                - $* takes whole argument as single line with space e.g. "tej is good person" if this runs in loop then it will print
                  tej
                  is
                  good
                  person
                - $@ which takes sentence and split by space so here we dont need to use loop its already splitted.

            - $? exit status of the last command executed.
                -  $echo $? --> 130
            - $$ process ID under which they are executing shell script
            - $! process number of the last background command.
    - Array
        - array_name[index]= value
        - array initialization ==> array_name =(value1.. valuen)
        - accesing array ==> ${array_name[index]}
        - e.g.

          NAME[0]="Zara"
          NAME[1]="Veer"

          echo "First Index: ${NAME[0]}" ==> Zara

          echo "First Method: ${NAME[*]}" or echo "First Method: ${NAME[@]}" ==> Zara  Veer

    - Operators:
        - Airthmetic
            - Bourne does not have inbuild airthemtic operator so that it uses external lib like "awk" or "expr"
            - val = 'expr 2+2' ==> echo $val = 2
            - Supported  +, - ,/ * ,% , = , ==, !=,
            - for =, == ,!= , shell does not require expr or any third party lib.
            - e.g. [ $a == $b ] OR [ $a != $b ]  compares two number and return true  or false.

        - Relational
            - [ $a -eq $b ] / [ $a -ne $b ] checks value of two operands are equal or not and return true /false
            - more e.g.  -gt, -lt,-ge,-le
        - Boolean
            -  ! , -o ( logical OR) , - a ( logical AND )
            - e.g. [ $a -lt 20 -o $b -gt 100 ]
        - String
            - e.g. = / != checks equality or inequality of two string [ $a = $b ]
            - e.g. -z , check if given string size is 0 if 0 then true [ -z $a ]
            - e.g. -n , check if given string size is NOT 0 if NOT 0 then true [ -n $a ]
            - e.g. str , if str is not empty string then true else false [$a]
        - File Test
            - These operators use to test file related properties of UNIX file system.
            - Assume a variable file holds an existing file name "test" the size of which is 100 bytes and has read, write and execute permission on
              -e.g. [-b $file] Checks if file is a block special file
              -e.g. [-c $file] Checks if file is a char special file
              -e.g. [-d $file] Checks if file is a direcory
              -e.g. [-f $file] Checks if file is NOT a direcory and a regular file.
              -e.g. [-r $file] Checks if file is redable file.
              -e.g. [-w $file] Checks if file is writable file.
              -e.g. [-x $file] Checks if file is executable file.
              -e.g. [-e $file] Checks if file is exists.

    - IF ELSE / CASE decesion

        - if .. fi
        - if..else fi
        - if..elif..else..fi
        - e.g.

          #! /bin/sh

          a = 10
          b = 5

          if[$a==$b]
          then
          echo "a is equal b"
          elif[$a gt $b]
          then
          echo "a is bigger than b"
          else

          	echo "a is smaller than b"

        - casee.. esac..

      -e.g.

      	FRUIT = "kiwi"
      	
      	case "$FRUIT" in 
      		"apple") echo "apple..."
      		;;
      		
      		"banana") echo "ba..."
      		;;
      		
      		"kiwi") echo "kiw...."
      		;;
      		
      	esac

    - Loop:

        - While loop e.g.

          a =0;
          while ["$a" -lt 10]

          	do 
          		b= "$a"
          		echo "$b"
          		a = a+1;

          	done

        - for loop e.g.

          for var in word1, word2 ... wordn
          do
          echo "$var"
          done

          # here var is the name of a variable

          # In below e.g. display all the files starting with .bash and available in your home

          for FILE in $HOME/.bash*
          do
          echo $FILE
          done

        - until loop ( do while)

          a=0
          until [ ! $a -lt 10 ]
          do
          echo $a
          a=`expr $a + 1`
          done


		- select loop : select loop provides an easy way to create a numbered menu from which users can select options. It is useful when you need to ask the user to choose one or more items from a list of choices. 
		
			select var in word1 word2 ... wordN
			do
				Statement(s) to be executed for every word.
			done
			
			select DRINK in tea cofee water juice appe all none
			do
				case $DRINK in 
				tea|cofee)
					echo ....
					
				....
				
			done
		
		- break / continue loop.
		
			- break : break statement is used to come out of a loop. there are two type of break
				- break
				- break n (e.g. n = 2 i.e 2nd enclosing loop to the exit from)
				
					#!/bin/sh

					for var1 in 1 2 3
					do
					   for var2 in 0 5
					   do
						  if [ $var1 -eq 2 -a $var2 -eq 0 ]
						  then
							 break 2 # break out of outer loop and ultimately from the inner loop as well
						  else
							 echo "$var1 $var2"
						  fi
					   done
					done
					
			- continue : exit current iteration of the loop , rather than the entire loop. two type of continue statement
				- contine
				- continue n
				
	- Substitution: shell performs substitution when it encounters an expression that contains one or more special characters
	
		-> -e enables interpretation of backslash esace
			e.g. 
				echo -e "Value of a is $a \n"
				"Value of a is 2 # assuing a =2 
				
				without -e result will be "Value of a is 2 \n"
		-> escpae sequence
			\\ for backslash , \n new line , \r retrun , \t tab, \v vertical tab \ 
			
		-> Variable substitution:
			
			- ${var} --> simple e..g $NAME
			- ${var : -word} : --> if var is null or empty then word is substitue.
			- ${var := word} : --> if var is null or empty then var = word.
			
	- Metacharacter /Special characters : metacharacters which have special meaning while using them in any Shell Script so can not just use as it is without taking away their special meaning.
		
		-> * ? [ ] ' " \ $ ; & ( ) | ^ < > new-line space tab (these are all special char of shell)
		
		-> ? matches with a single characters
		-> * ? matches with a all  charcters.
	
		-> How to use disable their special meaning.
			1. to get print Hello; Word says echo "Hello\; Word"
			2.  $ sign is one of the metacharacters, so it must be quoted to avoid special handling by the shell e.g. echo "I have \$1200" =>  I have $1200
			
		-> ' ' all special char between this single quote will loose their speciality.
			- echo 'It\'s Shell Programming
			
		-> " "  Most special char loses their speciality between double quote.
			- echo "$VAR owes <-\$1500.**>; [ as of (`date +%m/%d`) ]"
			
		-> \  any char followed by back slash.
		-> ` ` anything between back quotes treat as command and try to execute.
			-  DATE=`date`
			   echo "today date is $DATE" --> today date is  Thu Jul  2 05:28:45 MST 2009
			   
	Function :
	
			#!/bin/sh
			# Define your function here
			function_name () { 
				list of commands
			}
			
			# Invoke your function
			function_name
	
		e.g.
		
			Hello () {
			   echo "Hello World"
			}		
			Hello
		
		e.g with parameters and return value.
		
			function_Hello_1(){
			 echo "Hello there $Name1, $Name2"
			}
			
			function_Hello_1 tej montu -->res Hello there tej , montu
			
			
			function_Hello_2(){
			 echo "Hello there $Name1, $Name2"
			 return 10;
			}
			
			function_Hello_2 tej montu
			
			# Capture value returnd by last command
			ret=$?
			
			echo "Return value is $ret"
			
			..All result in to.....
			
			 Hello there tej , montu
			 Return value is 10


*********************UNIX/Linux Cron Jobs  *****************************
- Cron Job :  
    - It is used to schedule commands at a specific time and these commands called as "corn jobs"
    - Format : Minute(0-59) Hour(0-24) Day_of_month(1-31) Month(1-12) Day_of_week(0-6) Command_to_execute
    - Display cron jobs ---> $ crontab -l
    - Edit cron jobs ---> $ crontab -e (If it is the first time, you will be asked to choose an editor to edit the cron jobs.)
    - E.g.
        * * * * * <command-to-execute> (run job every minute)
      */5 * * * * <command-to-execute> (run job every 5 minute)
    - Use Crontab syntax generators for above purpose.




********************* Docker For Developer  *****************************

- Intro :
    - Vitrual machine and Docker looks alike but ITS NOT.
        - VM
            - Applications running in virtual machines, apart from the hypervisor, require a full instance of the operating system and any supporting libraries.
            - How it looks ?
              Server --> Host OS --> Hypervisor --> Guest OS --> bins/lib --> App1 (Hypervisor to App is VM)
              Server --> Host OS --> Hypervisor --> Guest OS --> bins/lib --> App2 (Hypervisor to App is VM)

        - Docker
            - Docker share the operating system with the host.
            - How it looks ?
              Server --> Host OS --> Docker --> bins/lib --> App1 and/or App2 (Docker to App(s) is container)
            - Processes running inside the containers are just like the native processes on the host, and do not introduce any overheads associated like its does while using VM / hypervisor execution.
            - applications can reuse the libraries and share the data between containers

    - Docker Architecture :- Docker Daemon sits on HOST (Host machine/OS/Server) talks to Docker client (talks to Deamon via http basically we write commands on client that later understand by daemon and execute by daemon) one hand and on other hands it talks to Registry (its image registry / docker hub contains  public and official images) to get image if not avilable on local machine , talks to image (if availabe on local) and talks/run container using image.

    - Install docker on win or mac from docker website
    - Once installed try command which download image from hub put it on local machine and then run.
      $ docker run hello-world

- Useful commands :

    - Dokcer client understands different commands.

      $ docker help # to get help
      $ docker COMMAND -- help # to get help on some command it self.
      $ docker version # shows docker version.
      $ docker info # shows docker info.

      $ docker search busybox # will search image name busybox on docker hub.
      $ docker run  -t -i busybox
      # will download image from hub , put it on local machine and runs as "interactive and attached using -t and -i"
      # also once its starts container led you on container bash/sh command prompt i.e. logged you in and put u at commnad prompt.
      # here we can execute any commnad inside container os.
      # "exit" command will stop container and put you out of it i.e back to host machine.

      $ docker ps
      # will list of containers are running.
      # it gives info like CONTAINER_ID (unique container id e.g. ab0e37214358), IMAGE (image is used to build container) , COMMAND (Default commnad executed when this container launched)

      $ docker ps --all
      # shows previously launched and currenly running containers info.

      $ docker images
      # will list all images availabe locally.
      # there are two main info like REPOSITORY name and TAG name.


		$ docker run -t -i busybox:1.0 # here 1.0 is tag name and its useful when mutlitple versions are available for same image.
		$ docker run -t -i busybox:2.0 # same way 2.0
		
		$ docker start ab0e37214358 
			# will start container with id ab0e37214358 this id can be find by $docker ps command
			# but no interactive and attached
			
		$ docker attach ab0e37214358 # to run already attached container and This will get you back to the Prompt i.e logged you in.
		
		$ docker stop ab0e37214358 # to stop container.
		
		$ docker pull httpd # just pull image from hub not run it.
		$ dcoker run -d --name customNameForWebServerContainer httpd
			# given custom name to our container as "customNameForWebServerContainer"
			# run as detached mode.
			# image name is here "httpd"
			# once start returned container id  as "4c39730ab784a998c3bb452"
			
		$ docker stop customNameForWebServerContainer # will stop CONTAINER and see we used container name here.
		$ docker rm customNameForWebServerContainer # will REMOVE CONTAINER and see we used container name here.
		
		$ docker run -d --name customNameForWebServerContainer -p httpd
			# here image has written command to expose port
			# so that we tell docker via -P when run this container assign randome port
			# will return as 80/tcp -> 0.0.0.0:32769
			
		$ docker run -d --name customNameForWebServerContainer -p 8080:8089 httpd 
			# run with fix port like -p HostPort:ContainerPort
			
		$ docker run -it --name mycontainer1 --rm ubuntu:latest
			# Here it will download/run image on container named as mycontainer1 but when exit it iwll also remove container since --rm is specified.
		
		$ docker inspect customNameForWebServerContainer
			# this will inspect container


- Buildind DOCKER images :
  - N/A
- Docker Private Registry :
    - N/A
- Data Volumes:
    - There are two ways
        - Data Volumes
        - Data Volume containers

    - Data Volumess:
        - its a designated directory in the container
        - its initialized when container started and kept by defualt even if container stopped.
        - it can shared across other container too.
        - can be made read only too.

        - Mounting Volume:
            - $ docker run -it -v /data --name container1 busybox
              # -v/data will mount volume named "data"

            - $ docker inspect container1
              # will give details about volume under "Mounts" :[....] section.
              # e.g.
              "Source":"/var/lib/docker/volumes/568258a7940182c5ac52f0637c60c1d1f81e9ec77f3e4694647b4879c2ff003c/_data",

              "Destination": "/data",

              Here  (/data), it has created a folder /var/lib/…. for you

            - Even though you have removed the container1, the data volume is still present on the host. This is a dangling or ghost volume and could remain there on your machine consuming space

            - This can be removed when container removed via  -v option while removing the container.


			- Mounting Host direcotry as a Data Volume:
		
				- Same as mounting Data Volume but not from ghost directory but using sepcific directory from the Host Machine.
				
				- ... -v HostFolder:ContainerVolumeName
			
				- $ docker run -it --name myContainer -v /Users:/datavol busybox
				# mapped Users folder to datavol in container.
				# either you got to /Users folder or go to /datavol in contianer this will be same
				
		
		- Data volume containers
			 - Basically have 1 container with mounted volume and from 2nd container use this 1 contaier volume
			 - TODO...

- Linking Containers :
    - N/A

- Writing a Dockerfile:
    - Dockerfile is a text file that has a series of instructions on how to build your image
    - It supports simple command like FROM,CMD,ENTRYPOINT,VOLUME,ENV, COPY etc.
    - Two step process,
        - crate Dockerfile with instruction and
        - use docker build comnand to create Docker image based on Dockerfile.
        - run image as like any other images.

    - e.g and explanation of Dockerfile as

      FROM docker.io/centos:7
      #  FROM command sets the base image for the rest of the instructions.

      RUN yum -y install java-1.8.0-openjdk.x86_64 && yum -y update
      #  RUN instruction is used to execute any commands like here install java jdk and update it also.

      WORKDIR  /opt/apps/efs/
      # set working dir as /opt/apps/efs/

      ADD /source/sample.jar /opt/apps/efs/sample.jar

      	# ADD or COPY command will copy file from source to destination
      	# Remember from where Dockerfile is stored on machine e.g. jenkins box from that folder all relative path is given assuming other resources also sits in same place where Dockerfile sits.

      EXPOSE 8080
      # EXPOSE command here to inform what port the container will be listening on.

      ENTRYPOINT ["./start.sh"]
      #  ENTRYPOINT is used to specify the default app that you want to run
      #  This is the way to configure a container that will run as an executable
      #  CMD command will then provide only the list of parameters to that ENTRYPOINT application (e.g. CMD [“ls”,”-al”] or CMD [“param1”,”param2”]


	- e.g and explanation of build Dockerfile.
	
		- $ docker build -t myimagename:latest .
			# "-t myimagename:latest" is build image as given name "myimage" with tag "latest" 
			# "."  second parameter is location of Dockerfile. 
				full / relative path like "/opt/apps/files/" OR "." if running docker build command in same folder where Dockerfile sits.
			
			# if dockerfile is on some other path givne full path like /opt/apps/images/my
			
	- NOW RUN IT.
	
		$ docker run -it myimagename

-  Getting Started with Kubernetes using Minikube
    - N/A


- Extra:
    - When using maven to build and deploy project.
        - and to build docker image part of project build we need to use plugin com.spotify (docker-maven-plugin) and below command will trigger this plugin.
        - mvn clean install docker:build -DdockerRepo=cicd-repo -DpushImageTag -DdockerImageTags=latest