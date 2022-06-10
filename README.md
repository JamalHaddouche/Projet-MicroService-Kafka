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
