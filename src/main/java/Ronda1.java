import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
public class Ronda1 {
    private HashMap<Integer, Partido> partido;

    public Ronda1() {
        partido = new HashMap<>();

    }
    public void agregarPartido(Partido nuevo) {
        partido.put(nuevo.getNumero(), nuevo);

    }
    public Partido resulPartido(int num) {
        return partido.get(num);
    }







}
