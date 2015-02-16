/**
 * Created by smurphy on 2/16/15.
 */
public class SpringLogic {
    private float stiffness;
    private float compression;

    public SpringLogic(float s, float c){
        stiffness = c;
        compression = c;
    }

    public void setStiffness(float s){
        stiffness = s;
    }
    public float getStiffness(){
        return stiffness;
    }
    public void setCompression(float c){
        compression = c;
    }
    public float getCompression(){
        return compression;
    }
}
