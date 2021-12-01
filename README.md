# bank-sub-system

##Objectifs du système à modéliser : 
Communication entre un client, un broker et une banque en vue d'obtention d'un
financement pour l'obtention d'un bien immobilier.

On propose de modéliser un système d'acquisition d'un emprunt pouvant supporter plusieurs banques (bank)
ainsi que plusieurs courtiers (broker).
Le système master, gère 


Le courtier(broker) se caractérise d'intermédiaire entre la banque et l'acquéreur afin d'obtenir un emprunt au meilleur
taux selon le projet. Son rôle est de recevoir le dossier du client, déterminer avec le client quels sont les organismes 
de crédit à contacter parmi ceux partenaires au broker. Suite à cela, après été reçu par mail, le dossier client sera
envoyé aux organismes de crédit séléctionnés.

La banque/organisme de crédit(bank), propose une simulation de financement (loan proposal) pour le projet dédié.

Lors de l'obtention d'une option de financement, on a plusieurs phases

###Phase 1 : 
Le client renseigne ses informations sur lui et le prêt dans un formulaire.
http://localhost:8080/

Le projet est constitué, ainsi le broker peut voir tous ceux qu'on lui a proposé

Il choisit quel projet envoyé à quelle banque et l'envoie.

http://localhost:8080/ProjectSummary.html

###Phase 2 :
La bank reçoit sur une queue:JMS les différents projets qu'on lui propose, il les affiche et les analyse
Selon des règles métiers précises.

Les projets qui sont acceptés sont transformées en loanProposal et sont renvoyées au Broker

###Phase 3 :
Le Broker reçoit les loan proposals (les projets qui ont été validés par la banque)

Il choisit parmis ses loan proposals celle qu'il considère comme la meilleure

Puis envoie un email au Client avec la meilleure loanProposal

## Amelioration possible
Possiblement 
- Transformer le JSON en PDF pour l'envoie au client

test
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
![](bank_system_Relat.png)
### Broker System
![](broker_system_Relat.png)
