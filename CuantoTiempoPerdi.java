import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static int tiempoMaximo(List<Integer> MediaTiempo) {
        
    int TiempoMax = 0;
    int Tiempo = 0;
    for(int i = 0; i < MediaTiempo.size(); i++) {
        if (MediaTiempo.get(i) > 0) 
        {
            Tiempo += MediaTiempo.get(i);
        } 
        else 
        {
            Tiempo = 0;
        }
        if (Tiempo > TiempoMax) 
        {
            TiempoMax = Tiempo;
        }
    }
    return TiempoMax;
    }

}

public class CuantoTiempoPerdi {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
      
        //int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> tiempos = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int res = Result.tiempoMaximo(tiempos);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
