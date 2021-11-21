# bank-sub-system

Objectifs du système à modéliser : Obtention de financements.

On propose de modéliser un système d'acquisition (MASTER) d'un emprunt (loan) pouvant supporter plusieurs banques (bank)
ainsi que plusieurs courtiers (broker).
Le système master, gère 


Le courtier(broker) se caractérise d'intermédiaire entre la banque et l'acquéreur afin d'obtenir un emprunt au meilleur
taux selon le projet. Son rôle est de recevoir le dossier du client, déterminer avec le client quels sont les organismes 
de crédit à contacter parmi ceux partenaires au broker. Suite à cela, après été reçu par mail, le dossier client sera
aux organismes de crédit séléctionnés.

La banque/organisme de crédit(bank), propose une simulation de financement pour le projet dédié.

Lors de l'obtention d'une option de financement, on a plusieurs phases

Phase 1: collecte et envoie d'informations valides aux organismes de crédit concernés : 

- Rassembler et vérifier l'ensemble des pièces justificatives du dossier (broker)
- Déterminer les organismes de crédit à contacter (broker)

Phase 2: proposer une simulation de financement

- vérifier validité des rélevés de comptes en interne.
- vérifier validité avis imposition

Phase 3 :

## Schéma relationnel
### Bank System
![](bank_system_Relat.jpg)
### Broker System
![](broker_system_Relat.jpg)