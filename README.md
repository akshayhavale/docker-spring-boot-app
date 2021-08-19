# docker-spring-boot-app




Docker
1. Docker is tool for running applications in an isolated environment
2. Similar to virtual machine
3. App run in same environment

Containers vs VMs
1. Containers are an abstraction at top app layer that packages code and dependencies together.
2. Multiple containers can run on same machine
3. Can share same OS karnel
4. each run in isolated process in user space

VirtualMachines
1. Virtual machines are abstraction of physical hardware turning server into many servers.
2. Hypervisor helps to run multiple vms run on single machine.
3. Each VMS consist of full copy of os+application+binaries+libraries.
4. Slow to boot


Docker architecture
---------------------------
Container(app+dependencies)
i
app1,app2,app3 and so on->Containerisation 
	i
Docker
	i
Host Operating System
	i
Infrastructure


VMs architecture
-----------------------
guest OS + app 
i
vm1,vm2,vm2
	i
Hypervisor
	i
Infrastructure


Benefits of Docker
------------------------

1. Run container in seconds 
2. Less disk space
3. Use less space
4. Does not need full OS
5. Deployment
6. Testing

Installation Of Docker
---------------------------- 


https://docs.docker.com/get-docker/


Verify Installation
--------------------------
~docker
you going to see set of commands

~docker --version

Docker Image
--------------------
1. Docker image is a template for creating environment of our choice.
2. It is also snapshot
3. Has everything that our app required
4. OS+software+appCode
Containers
----------------

1. It is just running instance of an image

image -> run -> Container
---
1. PULLING DOCKER IMAGES


~docker pull IMAGENAME
ex-> ~docker pull nginx


2. Check images list
~docker images

3. Running Container
~docker run nginx:latest

for detached mode running container

~docker run -d nginx:latest

4. Check Container List 
~docker ps      ->Simply lists the running containers
[
	~docker ps --help
	
	from this to get all containers list
	~docker ps -a

]
or
~docker container ls

5. Exporting ports
host to container
can done by -p 8080:80
that is 8080 is localhost port to access by browser
80 is tcp port of container

~docker run -d -p 8080:80 nginx:latest

6. Stop container

-> ~docker stop CONTAINERID

-> ~docker stop ACTUALNAME   -> from this we are not removed completely we can start by using the same name
		i.e ~docker start ACTUALNAME
		ex:- ~docker start jolly_euler

7. Exposing multiple ports
~docker run -d -p 3212:80 -p 3213:80 nginx:latest

8. Delete Containers 

~docker rm CONTAINERID OR CONTAINERANAME --> single single container delete

remove all
~docker rm $(docker ps -aq) -> this for only unused containers

Forced remove running container also
~docker rm -f $(docker ps -aq)

9. Only DOCKER IDS you want
~docker ps -aq

10. Naming Containers

~docker run --name CONTAINERNAME_THAT_WANT_TO_GIVE -d -p 8080:80 nginx:latest

11. Docker PS and Formating

~docker ps --format="ID\t{{.ID}}\nNAME\t{{.Names}}\nIMAGE\t{{.Image}}\nPORTS\t{{.Ports}}\nCOMMAND\t{{.Command}}\nCREATED\t{{.CreatedAt}}\nSTATUS\t{{.Status}}\n"


if you want to assign to variable then

~export FORMAT = "ID\t{{.ID}}\nNAME\t{{.Names}}\nIMAGE\t{{.Image}}\nPORTS\t{{.Ports}}\nCOMMAND\t{{.Command}}\nCREATED\t{{.CreatedAt}}\nSTATUS\t{{.Status}}\n"


~docker ps --format = $FORMAT

12. Docker Volumes

-> Allows us to share data (Files and Folders)
Container 
Filesystem -> in that DockerArea

-> Using container and FileSystem we can crate Docker Volume
-> Volume allows to share data between host and container and also between Containers

13. Volumes between host and container

mount the document to container

~docker run --name website -v SOURCE:TARGET:ro -d -p 3212:80 nginx:latest

ro -> read olny
ex:- ~docker run --name website -v $(pwd):/usr/share/nginx/html:ro -d -p 3212:80 nginx:latest

To Interact with Container by pausing the container execution 

~docker exec -it website bash

inside the container to check files

command is:       ls -al

write permission given by just remove (ro)

ex:- ~docker run --name website -v $(pwd):/usr/share/nginx/html -d -p 3212:80 nginx:latest

to create any file use command :- touch xyz.html. -> it crate xyz.html


14. Sharing volumes between containers

by using --volumes-from:website

now need to share volume between website and website-copy container

ex:-  ~docker run --name website-copy  -volumes-from website -d -p 8000:80 nginx:latest

15. DOCKERFILE
-------------------------

-> Helps to build our own images

Spring boot
https://spring.io/guides/topicals/spring-boot-docker

https://spring.io/guides/gs/spring-boot-docker/

https://stackoverflow.com/questions/55562381/not-able-to-connect-to-docker-image-with-a-spring-boot-application






