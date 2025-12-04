# CICD_Jenkins_Docker

cd CICD_Jenkins_Docker

## DOCKER COMPOSE

docker compose build

docker compose up -d

Open this in your browser: http://localhost:8080

Login credentials (from your groovy init scripts):

Username: admin

Password: admin123

Go to: Manage Jenkins → System

Set Jenkins URL : http://localhost:8080/


## Configure Email (Basic Mailer)

Go to: Manage Jenkins : System

Scroll to E-mail Notification

Set:

SMTP server : smtp.gmail.com -- give your server

 Check Use SMTP Authentication

User Name : example@mail.com -- give your sender mail

Password : (your 16-digit Gmail App Password) -- create the app passwrod if your using google server 

check TLS

SMTP Port : 587 -- enter you port

Reply-To Address : example1@mail.com --change it according to your recipient mail

Test e-mail recipient : example@email.com

Click Test configuration

Make sure you see:
“Email was successfully sent”


## Configure Extended E-mail Notification (emailext)

Manage Jenkins → System

Find Extended E-mail Notification

Set:

SMTP server : smtp.gmail.com

SMTP Port : 587

check the TLS

In credentials dropdown:

 Add : Jenkins

Kind: Username with password

Username : example@mail.com  -- give your sender mail id which you use to send mail from

Password : (same 16-digit app password) -- give the same password you gave earlier

ID : gmail-smtp

Set the credential: 

Default user e-mail suffix : @gmail.com -- give your suffix

Allowed Domains : gmail.com -- give your doamain

Default Recipients :example1@mail.com.com

## Add Docker Hub Credentials

Manage Jenkins : Credentials → System → (Global)

Click: Add Credentials

Kind → Username with password

Username : <your username> -- give your user name

Password : <your Docker Hub access token> -- give you docker hub token

ID → DockerCred

Description → Docker Hub token for CI/CD

Click Create.

## Create the Pipeline Job Connected to GitHub

In main page, click New Item

Name it: cicd-pipeline-jenkins-docker

Choose Pipeline : OK

In the config:

Scroll to Pipeline section

check github project

Project URL 
   :https://github.com/youraccount/repo.git

Pipline
 
  Definition : Pipeline script from SCM

  SCM → Git

        Repository URL :  https://github.com/youraccount/repo.git

        select the git credentials, if not added add by clicking add and give your correct username of git and PAT

Branch Specifier : */main

Script Path : jenkinsfile -- give the correct name of the jenkins file

Click Save

Build the pipeline by clicking build in main page.

Check the console output and mail notification 



