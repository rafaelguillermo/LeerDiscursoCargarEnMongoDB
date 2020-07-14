package tfm.unir.mongodb.ivanduque.leerdiscursocargarenmongodb;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import java.io.File;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Rafael Guillermo Blanco Banquez <rafaelg.blancob@gmail.com>
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        
        File dirBase = new File("C:\\Users\\rafar\\OneDrive\\Documentos\\DocRafael\\Master\\trabajo grado\\2020\\discursos");
        
        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("db_unir");
        
        DBCollection collection = db.getCollection("c_discursos");
        
        File[] files = dirBase.listFiles();
        for (File file : files) {
            System.out.println("Escribiendo en mongo...");
            if(file.isFile()){
                System.out.println(file);
                Scanner scannerIN = new Scanner(file);
                String line, url;
                StringBuilder sb = new StringBuilder();
                while (scannerIN.hasNextLine()) {
                    line = scannerIN.nextLine();
                    sb.append(line);
                }
                scannerIN.close();
                
                DiscursoDTO discursoDTO = new DiscursoDTO();
                discursoDTO.setData(sb.toString());
                discursoDTO.setFile(file.getName());
                
                BasicDBObjectBuilder discursoBuilder = BasicDBObjectBuilder.start();
		discursoBuilder.append("name", discursoDTO.getFile());
		discursoBuilder.append("data", discursoDTO.getData());
                
                WriteResult result = collection.insert(discursoBuilder.get());
                
            } 
        }
        
        //close resources
	mongo.close();
    }
}
