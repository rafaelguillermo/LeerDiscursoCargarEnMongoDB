package tfm.unir.mongodb.ivanduque.leerdiscursocargarenmongodb;

/**
 *
 * @author Rafael Guillermo Blanco Banquez <rafaelg.blancob@gmail.com>
 */
public class DiscursoDTO {
    
    private String data;
    private String file;

    public DiscursoDTO() {
    }

    public DiscursoDTO(String data, String file) {
        this.data = data;
        this.file = file;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
    
}
