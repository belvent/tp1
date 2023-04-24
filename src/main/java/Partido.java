import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

public class Partido {
    private int numero;
    private String local;
    private int golesLoc;
    private String visitante;
    private int golesVis;


    @Override
    public String toString() {
       // return "Partido" + " " + numero + ": " + "  " + local + " " + golesLoc + "-" + golesVis + " " + visitante;
        return String.format("Partido %2d: %-20s %1d-%1d %20s", numero, local,golesLoc,golesVis,visitante);
    }
}
