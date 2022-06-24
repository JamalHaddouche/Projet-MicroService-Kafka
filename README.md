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
dans ce service j'ai crée une classe customer dans les attributs porte l'id , le nom et l'email de client ,puis j'ai crée un interface CustomersRepository pour ajouter les élements dans base de données.
voici la liste des consomateur :

![image](https://user-images.githubusercontent.com/82270887/173071571-65f2a8e8-81e1-456b-89b8-338f9d2611e9.png)

pour voir que les IDs et les noms des utilisateurs ,on utilise une projection:
- la liste des consomateurs avec la projetcion :

![image](https://user-images.githubusercontent.com/82270887/173072008-dc296287-e4ab-46cf-adbf-743ae69690df.png)

- la projection du premiere consomateur

![image](https://user-images.githubusercontent.com/82270887/173071830-9d7cf41f-0f76-4df5-88eb-8c0794b392c5.png)

## Inventory-service
dans ce service j'ai crée une classe Product  dans les attributs porte un id le nom du produit et le prix de produit ,puis j'ai créé une interface ProductRepository 
- la listes des produits:
![image](https://user-images.githubusercontent.com/82270887/173076302-98493a3d-82a0-4286-aa64-3408dd638047.png)

## Gateway-service:
Dans l'application gateway j'ai créé une classe de configuration qui permet de retourner un objet de type routeLocator:
![image](https://user-images.githubusercontent.com/82270887/173077913-01b671ba-a55b-4ec8-832d-c3769195762a.png)

## Service d'enregistrement " Eureka-service " :
ce service sera connecter avec le service consumer-service et le service inventory-service.
Puis on va modifier la façon dans le Gateway-service se communique avec le service d'enregistrement ,on le méttre dynamique, on utilise une classe de configuration, on va créer un objet  qui va retourner DiscoveryClientRouteDefinitionLocator:
![image](https://user-images.githubusercontent.com/82270887/173079939-576db895-c286-477f-8cbf-2214e8e7fa29.png)
Pour visualiser les services qui sont connecter avec eurika on utlise la commande : localhost:8761
![image](https://user-images.githubusercontent.com/82270887/173147437-33ab1aa3-8a1b-4599-91bf-cc66a0e6cf0a.png)

## Billing-service:
pour afficher la liste des factures on utilise la commande "localhost:8888/BILLING-SERVICE:bills
![image](https://user-images.githubusercontent.com/82270887/173152497-9f1fa47b-2d70-465c-b17a-16dbda514a97.png)

pour afficher la fatcure dans l'id =1 on utilise la commande "localhost:8888/BILLING-SERVICE/bills/1 ,on remarque que cette facture porte l'id de consomateur 1:
![image](https://user-images.githubusercontent.com/82270887/173154254-bca34589-53d2-448c-b07a-4f46fc0bd5bb.png)

pour afficher la liste des produits commander par un consomateur on utlise la projection fullBill , la commande suivant ""http://localhost:8888/BILLING-SERVICE/fullBill/1 "affiche les produits commander par le consomateur qui porte l'id=1 et affiche des informations concernant ce client :
![image](https://user-images.githubusercontent.com/82270887/173154108-324eceb7-d5f6-4807-a431-74f5fe39a331.png)




## Question 7: Mise en place d’une solution de messagerie asynchrone avec le Broker KAFKA

ce micro service permet d'envoyer un topic Facturation chaque seconde contenant un numéro de facture, le nom du client et le montant de la facture:

![image](https://user-images.githubusercontent.com/82270887/175530699-aa7f753f-9d2d-40a6-9d85-b4a300b8ef7b.png)

j'ai créer un fonction total facture qui permet d'afficher que la somme de la facture pour chaque 5 second:

![image](https://user-images.githubusercontent.com/82270887/175531004-ccef5b05-5956-4d5b-a453-bf2b7c325413.png)

Puis une fonction qui permet de calculer le totale de la facture pour cahque client :

![image](https://user-images.githubusercontent.com/82270887/175531155-8caad8c4-a892-470f-91fb-3682b1295017.png)


