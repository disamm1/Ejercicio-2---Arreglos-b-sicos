public class Jugador{

    private String nombre;
    private String nickname;
    private int edad;
    private int[] puntajes;
    private int partidasJugadas;


    // Constructor
    public Jugador(String nombre, String nickname, int edad){
        this.nombre = nombre;
        this.nickname = nickname;
        this.edad = edad;
        this.puntajes = new int[10];
        this.partidasJugadas = 0;
        
    }


    //getters
public String getNombre(){
    return nombre;
}

public String getNickname(){
    return nickname;
}

public int getPartidasJugadas(){
    return partidasJugadas;
}

public int getEdad(){
    return edad;
}

public int getPartidasDisponibles() {
    return 10 - partidasJugadas;
}

//setters


public void setNombre(String nombre){
    this.nombre = nombre;
}

public void setNickname(String nickname){
    this.nickname = nickname;
}

public void setEdad(int edad){
    this.edad = edad;
}



    //METODOS
    // Registramos una partida como completa cuando el puntaje es entre 0  y 100 y las partidas jugadas no estan llenaas (10, como pide la guia)
    public boolean registrarPartida(int puntaje){
        if(puntaje < 0 || puntaje > 100){
            return false;
        }
         

        if(partidasJugadas >= 10){
            return  false;
        }

        puntajes[partidasJugadas] = puntaje;
        partidasJugadas++;

        return true;
}


// Se consulta el puntaje de las partidas, si esa partida no se ha jugado, entonces retorna un numero que con el main se le envia un mensaje al usuario de no disponible
public int consultarPuntaje(int partida) {

    partida = partida - 1;

    if (partida < 0 || partida >= partidasJugadas) {
        return -1;
    }

    return puntajes[partida];
}


// Se puede modificar el puntaje de alguna partida guardada, pero antes se comprueba que el puntaje sea entre 0 y 100 y que la partida que se quita modificar
// ya se haya jugado
public boolean modificarPuntaje(int partida, int puntaje){
    partida = partida - 1;
    if (partida < 0 || partida >= partidasJugadas) {
        return false;
    }
    if(puntaje < 0 || puntaje > 100){
            return false;
        }

    puntajes[partida] = puntaje;
    return true;


}


// Se obtienen los puntajes de las partidas que ya se jugaron, si no hay partidas retorna null 
public int[] obtenerPuntajes() {

    int[] registrados = new int[partidasJugadas];
    if(partidasJugadas == 0){
        registrados = null;
        return registrados;
    }

    for(int i = 0; i < partidasJugadas; i++) {
        registrados[i] = puntajes[i];
    }

    return registrados;
}


// Se calcula el promedio de los puntakes de las partidas, si no hay partidasa retorna -1 para enviarle un mensaje al usuario.
public double calcularPromedio(){
    double promedio = 0;
    if(partidasJugadas == 0){
        return -1;
    }
    for (int i = 0; i < partidasJugadas; i++) {
        promedio += puntajes[i];
    }

    promedio = promedio / partidasJugadas;
    return promedio;


}

//Se obtiene el puntaje Mayor, si no hay partidas retorna -1 para enviarle un mensaje al usuario
public int obtenerPuntajeMayor(){
    if (partidasJugadas == 0) {
        return -1;
    }

    int pMayor = puntajes[0];
    for (int i = 1; i < partidasJugadas;i++) {
        if (puntajes[i] > pMayor) {
            pMayor = puntajes[i];
        }
    }

    return pMayor;


}

//Se obtiene el puntaje Menor, si no hay partidas retorna -1 para enviarle un mensaje al usuario
public int obtenerPuntajeMenor(){
    if (partidasJugadas == 0) {
        return -1;
    }

    int pMenor = puntajes[0];
    for (int i = 1; i < partidasJugadas;i++) {
        if (puntajes[i] < pMenor) {
            pMenor = puntajes[i];
        }
    }

    return pMenor;


    }

}
