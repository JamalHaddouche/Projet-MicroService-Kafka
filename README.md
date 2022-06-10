# Projet-MicroService-Kafka
Pour faire l'architecture entre les services en utilise des micro-services techniques, parmi lesquel on trouve le micro service d'enregistrement.
chaque micro service qui démmare a besoin de se connecter et s'enregistre dans le service d'enregistrement pour publier trois informations:
- le nom de micro service 
- l'addresse IP
- le numéro de port
Dans l'application le client ne connaise que le service Gatway,tout les requêtes envoyer par le client suivi par le nom de service sont envoyer vers le Gateway(proxy),
et le moment quand le gateway connait le service il va contacter le micro-service d'enregistrement pour lui fournir tous les informations de micro-service pour ce communiquer directement avec le service demander par le client.
Pour éviter de créer un fichier de configuartion de chaque micro-service, on utilise un service de configuration.
On utilise Rest pour la communication entre les services c'est une communication synchrone.
## Customer-service
dans ce service j'ai crée une classe customer dans les attributs porte l'id , le nom et l'email de client ,puis j ai crée un interface CustomersRepository pour ajouter les élements dans base de données.
voici la liste des consomateur :

![image](https://user-images.githubusercontent.com/82270887/173071571-65f2a8e8-81e1-456b-89b8-338f9d2611e9.png)

pour voir que les IDs et les noms des utilisateurs ,on utilise une projection:
- la liste des consomateurs avec la projetcion :

![image](https://user-images.githubusercontent.com/82270887/173072008-dc296287-e4ab-46cf-adbf-743ae69690df.png)

- la projection du premier consomateur

![image](https://user-images.githubusercontent.com/82270887/173071830-9d7cf41f-0f76-4df5-88eb-8c0794b392c5.png)
