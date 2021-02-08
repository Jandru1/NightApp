package com.example.jandrullue;

import java.util.HashMap;

public class TrivialClass {

    private HashMap<Integer,String> PreguntasTrivialFacil = new HashMap<>();
    private HashMap<Integer,String> PreguntasTrivialMedio = new HashMap<>();
    private HashMap<Integer,String> PreguntasTrivialDificil = new HashMap<>();
    private HashMap<Integer,String> RespuestasTrivialFacil = new HashMap<>();
    private HashMap<Integer,String> RespuestasTrivialMedio = new HashMap<>();
    private HashMap<Integer,String> RespuestasTrivialDificil = new HashMap<>();

    public TrivialClass() {

        this.PreguntasTrivialFacil.put(0,"¿Cuál es el oceano más grande del mundo?");
        this.RespuestasTrivialFacil.put(0,"El océano Pacífico");

        this.PreguntasTrivialFacil.put(1, "¿Cuántos estados tiene integrados Estados Unidos?");
        this.RespuestasTrivialFacil.put(1," 50 estados");

        this.PreguntasTrivialFacil.put(2," ¿Quién es el autor de 'La Odisea'?");
        this.RespuestasTrivialFacil.put(2," Homero");
/*
        this.PreguntasTrivialFacil.put(3," ¿Cuál es la capital de Filipinas?");
        this.RespuestasTrivialFacil.put(3," Manila");

        this.PreguntasTrivialFacil.put(4," ¿Cuál era el nombre del dios del Sol en el Antiguo Egipto?");
        this.RespuestasTrivialFacil.put(4," Ra");

        this.PreguntasTrivialFacil.put(5," ¿Cuántos años duró la guerra de los 100 años?");
        this.RespuestasTrivialFacil.put(5," 116 años");

        this.PreguntasTrivialFacil.put(6," ¿Cómo murió Vincent Van Gogh?");
        this.RespuestasTrivialFacil.put(6," Suicidio");

        this.PreguntasTrivialFacil.put(7," ¿Cómo se llama el perro de Tintín?");
        this.RespuestasTrivialFacil.put(7," Milú");

        this.PreguntasTrivialFacil.put(8," ¿De dónde surgió la celebración de los juegos olímpicos?");
        this.RespuestasTrivialFacil.put(9," De la Antigua Grecia");

        this.PreguntasTrivialFacil.put(10," ¿Cómo se llama el estadio de fútbol del Real Madrid?");
        this.RespuestasTrivialFacil.put(10," Estadio Santiago Bernabeu");

        this.PreguntasTrivialFacil.put(11," ¿De qué país es el jugador de fútbol Luis Suárez?");
        this.RespuestasTrivialFacil.put(11," Uruguay");

        this.PreguntasTrivialFacil.put(12," ¿Cuál es el nombre del teorema que afirma que, en el triángulo rectángulo, el cuadrado de la hipotenusa es igual a la suma de los cuadrados de los catetos?");
        this.RespuestasTrivialFacil.put(12," Teorema de Pitágoras");

        this.PreguntasTrivialFacil.put(13," ¿Quién descubrió la penicilina?  ");
        this.RespuestasTrivialFacil.put(13," Alexander Fleming ");

        this.PreguntasTrivialFacil.put(14," ¿En la fórmula F=m.a qué significa la 'a'?");
        this.RespuestasTrivialFacil.put(14," Aceleración");

        this.PreguntasTrivialFacil.put(15," ¿Quién descubrió la penicilina?");
        this.RespuestasTrivialFacil.put(15," Alexander Fleming");

        this.PreguntasTrivialFacil.put(16," ¿Quién planteó la teoría de la evolución?");
        this.RespuestasTrivialFacil.put(16," Charles Darwin");

        this.PreguntasTrivialFacil.put(17," ¿Cuál es el nombre de la sustancia que le da el color verde a las plantas? ");
        this.RespuestasTrivialFacil.put(17,"Clorofila");

        this.PreguntasTrivialFacil.put(18," ¿Cuál es el planeta más grande del sistema solar? ");
        this.RespuestasTrivialFacil.put(18," ¿Cuál es el planeta más grande del sistema solar?");

        this.PreguntasTrivialFacil.put(19," ¿Dónde nació Rafael Nadal?");
        this.RespuestasTrivialFacil.put(19," Mallorca, España");

        this.PreguntasTrivialFacil.put(20," ¿Cuál es el atleta con más medallas de oro olímpicas?");
        this.RespuestasTrivialFacil.put(20," Michael Phelps");

        this.PreguntasTrivialFacil.put(21,"¿En qué deporte destaca Tiger Woods?");
        this.RespuestasTrivialFacil.put(21," En el golf");

        this.PreguntasTrivialFacil.put(22," ¿Qué conflicto finalizó tras la firma del Tratado de Versalles?");
        this.RespuestasTrivialFacil.put(22," La I Guerra Mundial");

        this.PreguntasTrivialFacil.put(23,"¿Quién fue el primer presidente de Estados Unidos? ");
        this.RespuestasTrivialFacil.put(23," George Washington");

        this.PreguntasTrivialFacil.put(24," ¿Quién es Jeff Bezos?");
        this.RespuestasTrivialFacil.put(24," Jeff Preston Bezos es un empresario y magnate estadounidense, fundador y director ejecutivo de Amazon.");

        this.PreguntasTrivialFacil.put(25," ¿Cuál es la fórmula química del agua");
        this.RespuestasTrivialFacil.put(25," H20");

        this.PreguntasTrivialFacil.put(26," En la mitología griega, ¿quién era el mensajero de los dioses?");
        this.RespuestasTrivialFacil.put(26," El mensajero de los dioses es Hermes.");

        this.PreguntasTrivialFacil.put(27," ¿Cuál es el símbolo químico del oro?");
        this.RespuestasTrivialFacil.put(27," AU");

        this.PreguntasTrivialFacil.put(28," ¿Cuál es la capital de Islandia?");
        this.RespuestasTrivialFacil.put(28," . La capital de Islandia es Reikiavik.");

        this.PreguntasTrivialFacil.put(29," ¿Qué descubrieron Marie Curie y su esposo Pierre?");
        this.RespuestasTrivialFacil.put(29," La radioactividad.");

        this.PreguntasTrivialFacil.put(30," ¿Quién enunció la metáfora filosófica del mito de la caverna?");
        this.RespuestasTrivialFacil.put(30," El mito de la caverna fue escrito por Platón.");

        this.PreguntasTrivialFacil.put(31," ¿Qué artista popularizó la canción Billie Jean?");
        this.RespuestasTrivialFacil.put(31," Michael Jackson");

        this.PreguntasTrivialFacil.put(32," ¿En qué año llegó Cristóbal Colón a América?");
        this.RespuestasTrivialFacil.put(32," Cristóbal Colón llegó a América es en 1492");

        this.PreguntasTrivialFacil.put(33," ¿Qué movimiento tiene el caballo en ajedrez?");
        this.RespuestasTrivialFacil.put(33," En ajedrez, el caballo tiene un movimiento semejante a una L");

        this.PreguntasTrivialFacil.put(34," ¿En qué equipo de la NBA jugó Kobe Bryant desde 1996?");
        this.RespuestasTrivialFacil.put(34," Kobe Bryant jugó hasta su muerte en los Angeles Lakers.");
        this.PreguntasTrivialFacil.put(35," ¿Sabes cuántos corazones tiene un pulpo?");
        this.RespuestasTrivialFacil.put(35," 3 ");

        this.PreguntasTrivialFacil.put(36," ¿Quién es el hermano de Thor según Marvel?");
        this.RespuestasTrivialFacil.put(36," El hermano adoptivo de Thor, según los cómics de Marvel, es Loki");

        this.PreguntasTrivialFacil.put(37," ¿Quién inventó el avión?");
        this.RespuestasTrivialFacil.put(37,"  Los hermanos Wright");

        this.PreguntasTrivialFacil.put(38," ¿Qué pasó el 20 de julio de 1969?");
        this.RespuestasTrivialFacil.put(38," El 20 de julio de 1969 el Apolo 11 aterrizó en la Luna");

        this.PreguntasTrivialFacil.put(39," ¿Quién es el autor de el Don Quijote de la Mancha?");
        this.RespuestasTrivialFacil.put(39," Miguel de Cervantes en 1615");

        this.PreguntasTrivialFacil.put(40," ¿En qué país se encuentra el Wembley Arena?");
        this.RespuestasTrivialFacil.put(40," El Wembley Arena es un famoso estadio ubicado cerca de Londres, en el Reino Unido");

        this.PreguntasTrivialFacil.put(41," ¿Qué nombre científico recibe el detector de mentiras?");
        this.RespuestasTrivialFacil.put(41," El aparato que utiliza la policía para detectar mentiras es el polígrafo");

        this.PreguntasTrivialFacil.put(42," ¿Quién es el dirigente en Corea del Norte?");
        this.RespuestasTrivialFacil.put(42," Kim Jong-un es el actual dirigente de Corea del Norte");

        this.PreguntasTrivialFacil.put(43," ¿Quién dijo “yo sólo sé que no se nada?");
        this.RespuestasTrivialFacil.put(43," Sócrates ");

        this.PreguntasTrivialFacil.put(44," ¿Cómo se llaman los 3 tipos de triángulos?");
        this.RespuestasTrivialFacil.put(44," El equilátero, isósceles ,escaleno");

        this.PreguntasTrivialFacil.put(45," ¿Cuál es tercer planeta del sistema solar?");
        this.RespuestasTrivialFacil.put(45," El tercer planeta es la Tierra.");

        this.PreguntasTrivialFacil.put(46,"¿Cuál es el edificio más alto del mundo?");
        this.RespuestasTrivialFacil.put(46," El edificio Burj Khalifa, situado en Dubai,");

        this.PreguntasTrivialFacil.put(47," ¿Cuándo empezó la Primera Guerra Mundial?");
        this.RespuestasTrivialFacil.put(47," La Primera Guerra Mundial estalló en 1914.");

        this.PreguntasTrivialFacil.put(48," ¿En qué país se encuentra la ciudad de Varsovia?");
        this.RespuestasTrivialFacil.put(48," Varsovia no solo es una ciudad de Polonia, sino que además es su capital.");


 */
        this.PreguntasTrivialMedio.put(0, "7");
        this.PreguntasTrivialMedio.put(1, "8");
        this.PreguntasTrivialMedio.put(2,"9");
        this.PreguntasTrivialMedio.put(3,"10");
        this.PreguntasTrivialMedio.put(4,"11");
        this.PreguntasTrivialMedio.put(5,"12");

        this.PreguntasTrivialDificil.put(0,"13");
        this.PreguntasTrivialDificil.put(1,"14");
        this.PreguntasTrivialDificil.put(2,"15");
        this.PreguntasTrivialDificil.put(3,"16");
        this.PreguntasTrivialDificil.put(4,"17");
        this.PreguntasTrivialDificil.put(5,"18");

    }

    public HashMap<Integer,String> getPreguntasTrivialFaciles(){ return this.PreguntasTrivialFacil;}

    public HashMap<Integer,String> getPreguntasTrivialMedio(){ return this.PreguntasTrivialMedio;}

    public HashMap<Integer,String> getPreguntasTrivialDificil(){ return this.PreguntasTrivialDificil;}

    public HashMap<Integer,String> getRespuestasTrivialFaciles(){ return this.RespuestasTrivialFacil;}

    public HashMap<Integer,String> getRespuestasTrivialMedio(){ return this.RespuestasTrivialMedio;}

    public HashMap<Integer,String> getRespuestasTrivialDificil(){ return this.RespuestasTrivialDificil;}
}
