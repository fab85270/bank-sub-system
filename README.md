# bank-sub-system

##Objectifs du système à modéliser :

On propose ici de modéliser un système de gestion de l'acquisition d'un emprunt entre un Borrower(client) et une banque
grâce à un Broker(courtier).
A noter que ces emprunts se feront uniquement pour l'achat de biens immobiliers ( appartements, maisons, chateaux..).

Le courtier(broker) se caractérise comme un intermédiaire entre la banque et l'acquéreur afin d'obtenir un emprunt au meilleur
taux selon un projet client.
Son rôle est de recevoir le dossier du client; déterminer avec approbation du client, quels sont les organismes
de crédit à contacter parmi ceux avec lesquels il est partenaire.


Le système Bank, génère des propositions d'emprunts (simulation de financement) selon un projet qui lui est soumis.
Cette proposition, pourra prendre différentes formes selon les banques et les règles métiers qu'elles fixent :
- tranche d'âge
- Remboursement ?..
-> A compléter avec la logique métier que Abel a implementé.



La réalisation d'une proposition d'emprunt s'effectue en plusieurs phases :

###Phase 1 : Création et envoie d'un projet dans le système du broker

Le client(borrower) remplit un formulaire de création d'un projet de demande d'emprunt. Ce formulaire possède
ses informations personnelles (adresse, nom, Prénom..), des informations sur le bien qu'il désire acquérir à la suite
de cet emprunt. Ce formulaire, se situe au localhost du projet (http://localhost:8080/) après avoir effectué
la commande [quarkus dev] dans le terminal de commande dans le répertoire courant du système "loan-broker".

Une fois le formulaire validé et envoyé, un projet sera créé pour ce client.
Le broker(courtier), pourra ainsi observer l'ensemble des projets qui ont été crées et qui lui ont été soumis.
Il pourra ensuite choisir, grâce à un nouveau formulaire situé à l'adresse suite (http://localhost:8080/ProjectSummary.html),
d'envoyer ce projet à ses banques partenaires.


###Phase 2 : Réception du project et génération d'une proposition d'emprunt

Le Système de la bank (loan-bank) reçoit sur une queue:JMS les différents projets que le broker lui a soumis.
Suite à cette reception, selon les règles métiers définies par la banque, une proposition
d'emprunt sera générée si le projet corresponds à ses règles.
Elle se verra transmise par la suite au courtier(broker) par le moyen d'une queue:JMS.


###Phase 3 :
Le Broker reçoit les loan proposals (les projets qui ont été validés par la banque)

Il choisit parmis ses loan proposals celle qu'il considère comme la meilleure

Un message Reply est envoyé à la banque lui informant que sa banque a été choisie

La banque envoie donc un mail au client (borrower) avec les informations du prêts

##Interfaces
```
broker1->buyer: rest:get:partner_bank_list
buyer->broker1: rest:post:project_description
broker1->buyer: smtp:jusft_upload_link
buyer->broker1: rest:post:justif_file

broker2->buyer: rest:get:partner_bank_list
buyer->broker2: rest:post:project_description
broker2->buyer: smtp:jusft_upload_link
buyer->broker2: rest:post:justif_file

broker1->bank1.1: jms:send_file
bank1.1->broker1: jms:ok_loan_proposal
broker1->bank1.2: jms:send_file
bank1.2->broker1: jms:ok_loan_proposal
broker1->broker1: service_best_proposal
broker1->bank1.1: jms:you_have_been_selected
bank1.1->broker1: jms:here's my callback

broker1->buyer: smtp:loan_proposal_best_bank
```
![](seqDiagram.png)
## Schéma relationnel
### Bank System
![](class_bank_system.png)
### Broker System
![](class_broker_system.png)
