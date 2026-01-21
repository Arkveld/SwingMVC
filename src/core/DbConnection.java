package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {

    //Méthode statique pour se connecter à la BDD
    public static Connection seConnecter(){
        Connection con = null;

        try {
            //Chargement du fichier config.properties
            Properties props = new Properties();
            //Flux(tampon) pour enregistrer un fichier
            FileInputStream files = new FileInputStream("config.properties");
            props.load(files);

            //Attributs de connection
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            //Connection à la BDD
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion à la BDD");
        } catch (SQLException e) {
            System.err.println("Échec lors de la connection: " + e.getMessage());
        } catch (IOException e){
            System.err.println("Échec lors du chargement du fichier" + e.getMessage());
            throw new RuntimeException("Impossible de charger le fichier");
        }

        return con;
    }
}
