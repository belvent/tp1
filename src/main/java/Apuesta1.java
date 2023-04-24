import java.util.HashMap;

public class Apuesta1 {

    private HashMap<Integer, Partido> pronostico;

    public Apuesta1(){
        pronostico = new HashMap<>();
    }
    public void agregarPronos (Partido nueApu){
        pronostico.put(nueApu.getNumero(), nueApu);
    }

    public Partido resulApuesta(int nume) {
        return pronostico.get(nume);
    }



}

