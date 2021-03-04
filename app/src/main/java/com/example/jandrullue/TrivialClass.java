package com.example.jandrullue;

import java.util.HashMap;

public class TrivialClass {

    private final HashMap<Integer,String> PreguntasTrivialFacil = new HashMap<>();
    private final HashMap<Integer,String> PreguntasTrivialMedio = new HashMap<>();
    private final HashMap<Integer,String> PreguntasTrivialDificil = new HashMap<>();
    private final HashMap<Integer,String> RespuestasTrivialFacil = new HashMap<>();
    private final HashMap<Integer,String> RespuestasTrivialMedio = new HashMap<>();
    private final HashMap<Integer,String> RespuestasTrivialDificil = new HashMap<>();
    private final HashMap<Integer,String> RespuestasIncorrectasFacil = new HashMap<>();
    private final HashMap<Integer,String> RespuestasIncorrectasMedio = new HashMap<>();
    private final HashMap<Integer,String> RespuestasIncorrectasDificil = new HashMap<>();

    public TrivialClass() {

        this.PreguntasTrivialFacil.put(0, " ¿Cuál es el oceano más grande del mundo? ");
        this.RespuestasTrivialFacil.put(0, " El Pacífico ");
        this.RespuestasIncorrectasFacil.put(0, " El Atlántico || El Índico || El Ártártico ");

        this.PreguntasTrivialFacil.put(1, " ¿Cuántos estados tiene integrados Estados Unidos? ");
        this.RespuestasTrivialFacil.put(1, " 50 ");
        this.RespuestasIncorrectasFacil.put(1, " 25 || 52 || 35 ");

        this.PreguntasTrivialFacil.put(2, " ¿Quién es el autor de 'La Odisea'? ");
        this.RespuestasTrivialFacil.put(2, " Homero ");
        this.RespuestasIncorrectasFacil.put(2, " Hesíodo || Platón || Píndaro ");

        this.PreguntasTrivialFacil.put(3, " ¿Cuál es la capital de Brasil? ");
        this.RespuestasTrivialFacil.put(3, " Brasilia ");
        this.RespuestasIncorrectasFacil.put(3, " Río De Janeiro || São Paulo || Salvador ");

        this.PreguntasTrivialFacil.put(4, " ¿Cuál era el nombre del dios del Sol en el Antiguo Egipto? ");
        this.RespuestasTrivialFacil.put(4, " Ra ");
        this.RespuestasIncorrectasFacil.put(4, " Thot || Osiris || Horus ");

        this.PreguntasTrivialFacil.put(5, " ¿La 'oda a la alegría' forma parte de que sinfonía de Beethoven? ");
        this.RespuestasTrivialFacil.put(5, " Sinfonía nº 9 ");
        this.RespuestasIncorrectasFacil.put(5, " Sinfonía nº 3 || Sinfonía nº 5 || Sinfonía nº 6 ");

        this.PreguntasTrivialFacil.put(6, " ¿Cómo murió Vincent Van Gogh? ");
        this.RespuestasTrivialFacil.put(6, " Suicidio ");
        this.RespuestasIncorrectasFacil.put(6, " Asesinado || Atropellado || Por enfermedad ");

        this.PreguntasTrivialFacil.put(7, " ¿Cómo se llama el perro de Tintín? ");
        this.RespuestasTrivialFacil.put(7, " Milú ");
        this.RespuestasIncorrectasFacil.put(7, " Buster || Bolt || Scud ");

        this.PreguntasTrivialFacil.put(8, " ¿De dónde surgió la celebración de los juegos olímpicos? ");
        this.RespuestasTrivialFacil.put(8, " De la Antigua Grecia ");
        this.RespuestasIncorrectasFacil.put(8, " Del Imperio Romano || Del Imperio Otomano || Del Antiguo Egipto ");

        this.PreguntasTrivialFacil.put(9, "  ¿Cuál es el mejor juego para emborracharse con amigos? ");
        this.RespuestasTrivialFacil.put(9, " Potto Game 😊 ");
        this.RespuestasIncorrectasFacil.put(9, " Potto Game 😊 || Potto Game 😊 || Potto Game 😊 ");

        this.PreguntasTrivialFacil.put(10, " ¿Cómo se llama el estadio de fútbol del Real Madrid? ");
        this.RespuestasTrivialFacil.put(10, " Santiago Bernabeu ");
        this.RespuestasIncorrectasFacil.put(10, " Benito Villamarin || Camp Nou || Wembley Arena ");

        this.PreguntasTrivialFacil.put(11, " ¿De qué país es el jugador de fútbol Luis Suárez? ");
        this.RespuestasTrivialFacil.put(11, " Uruguay ");
        this.RespuestasIncorrectasFacil.put(11, " Panamá || Chile || Argentina ");

        this.PreguntasTrivialFacil.put(12, "¿En qué ciudad se usó la primera bomba atómica en combate? ");
        this.RespuestasTrivialFacil.put(12, " Hiroshima ");
        this.RespuestasIncorrectasFacil.put(12, " Osaka || Tokyo || Kyoto ");

        this.PreguntasTrivialFacil.put(13, "¿Cuál es la religión que considera el Corán su libro sagrado? ");
        this.RespuestasTrivialFacil.put(13, " El islam ");
        this.RespuestasIncorrectasFacil.put(13, " El cristianismo || El budismo || El hinduismo ");

        this.PreguntasTrivialFacil.put(14, " ¿En la fórmula F=m.a qué significa la 'a'? ");
        this.RespuestasTrivialFacil.put(14, " Aceleración ");
        this.RespuestasIncorrectasFacil.put(14, " Agua || Aplicación || Atracción ");

        this.PreguntasTrivialFacil.put(15, " ¿Sobre qué superfície se juega el torneo de tennis Wimbledon? ");
        this.RespuestasTrivialFacil.put(15, " Hierba ");
        this.RespuestasIncorrectasFacil.put(15, " Madera || Dura || Tierra batida ");

        this.PreguntasTrivialFacil.put(16, " ¿Quién planteó la teoría de la evolución? ");
        this.RespuestasTrivialFacil.put(16, " Charles Darwin ");
        this.RespuestasIncorrectasFacil.put(16, " Galileo Galilei || Stephen Hawking || Thomas Alva Edison ");

        this.PreguntasTrivialFacil.put(17, " ¿En qué lado del cuerpo tenemos el hígado? ");
        this.RespuestasTrivialFacil.put(17, " En el derecho ");
        this.RespuestasIncorrectasFacil.put(17, " En el izquierdo || Los humanos no tenemos hígado || Está exactamente en el centro ");

        this.PreguntasTrivialFacil.put(18, " ¿Cuál es el planeta más grande del sistema solar? ");
        this.RespuestasTrivialFacil.put(18, " Júpiter ");
        this.RespuestasIncorrectasFacil.put(18, " Saturno || Urano || Neptuno ");


        this.PreguntasTrivialFacil.put(19, " ¿Dónde nació Rafael Nadal? ");
        this.RespuestasTrivialFacil.put(19, " Mallorca ");
        this.RespuestasIncorrectasFacil.put(19, " Lanzarote || Menorca || Ibiza ");

        this.PreguntasTrivialFacil.put(20, " ¿Cuál es el atleta con más medallas de oro olímpicas? ");
        this.RespuestasTrivialFacil.put(20, " Michael Phelps ");
        this.RespuestasIncorrectasFacil.put(20, " Roger Federer || Carl Lewis || Usain Bolt ");

        this.PreguntasTrivialFacil.put(21, " ¿En qué deporte destaca Tiger Woods? ");
        this.RespuestasTrivialFacil.put(21, " En el golf ");
        this.RespuestasIncorrectasFacil.put(21, " En el fútbol americano || En el tenis || En el béisbol ");

        this.PreguntasTrivialFacil.put(22, " ¿Qué conflicto finalizó tras la firma del Tratado de Versalles? ");
        this.RespuestasTrivialFacil.put(22, " La I Guerra Mundial ");
        this.RespuestasIncorrectasFacil.put(22, " La Guerra Fría || La Guerra Civil || La II Guerra Mundial ");

        this.PreguntasTrivialFacil.put(23, " ¿Quién fue el primer presidente de Estados Unidos? ");
        this.RespuestasTrivialFacil.put(23, " George Washington ");
        this.RespuestasIncorrectasFacil.put(23, " Thomas Jefferson || Barack Obama || Abraham Lincoln ");

        this.PreguntasTrivialFacil.put(24, " ¿Quién es Jeff Bezos? ");
        this.RespuestasTrivialFacil.put(24, " Fundador y director ejecutivo de Amazon ");
        this.RespuestasIncorrectasFacil.put(24, " El famoso inventor de la bombilla || Creador de Google || Nadie importante ");

        this.PreguntasTrivialFacil.put(25, " ¿Cuál es la fórmula química del agua ");
        this.RespuestasTrivialFacil.put(25, " H20 ");
        this.RespuestasIncorrectasFacil.put(25, " NH3 || CO2 || K3 ");

        this.PreguntasTrivialFacil.put(26, " En la mitología griega, ¿quién era el mensajero de los dioses? ");
        this.RespuestasTrivialFacil.put(26, " Hermes ");
        this.RespuestasIncorrectasFacil.put(26, " Hefesto || Apolo || Dionisio ");

        this.PreguntasTrivialFacil.put(27, " ¿En qué continente viajarías si estas vacaciones fueras a Checoslovaquia ? ");
        this.RespuestasTrivialFacil.put(27, " ¿Que qué? Eso no existe burro ");
        this.RespuestasIncorrectasFacil.put(27, " Europa || Asia || Oceanía ");

        this.PreguntasTrivialFacil.put(28, " ¿Cuál es la capital de Islandia? ");
        this.RespuestasTrivialFacil.put(28, " Reikiavik ");
        this.RespuestasIncorrectasFacil.put(28, " Dublin || Nuuk || Oslo ");

        this.PreguntasTrivialFacil.put(29, " ¿Qué descubrieron Marie Curie y su esposo Pierre? ");
        this.RespuestasTrivialFacil.put(29, " La radioactividad ");
        this.RespuestasIncorrectasFacil.put(29, " La gravedad || La penicilina || La electricidad ");

        this.PreguntasTrivialFacil.put(30, " ¿Quién enunció la metáfora filosófica del mito de la caverna? ");
        this.RespuestasTrivialFacil.put(30, " Platón ");
        this.RespuestasIncorrectasFacil.put(30, " Pitágoras || Aristóteles || Sócrates ");

        this.PreguntasTrivialFacil.put(31, " ¿Qué artista popularizó la canción Billie Jean? ");
        this.RespuestasTrivialFacil.put(31, " Michael Jackson ");
        this.RespuestasIncorrectasFacil.put(31, " Bob Marley || Freddy Mercury || John Lennon ");

        this.PreguntasTrivialFacil.put(32, " ¿En qué año llegó Cristóbal Colón a América? ");
        this.RespuestasTrivialFacil.put(32, " 1492 ");
        this.RespuestasIncorrectasFacil.put(32, " 1472 || 1483 || 1427 ");

        this.PreguntasTrivialFacil.put(33, " ¿Qué movimiento tiene el caballo en ajedrez? ");
        this.RespuestasTrivialFacil.put(33, " Semejante a una L ");
        this.RespuestasIncorrectasFacil.put(33, " Diagonal || Horizontal || Vertical ");

        this.PreguntasTrivialFacil.put(34, " ¿En qué equipo de la NBA jugó Kobe Bryant desde 1996? ");
        this.RespuestasTrivialFacil.put(34, " Los Angeles Lakers ");
        this.RespuestasIncorrectasFacil.put(34, " Los Angeles Clippers || Chicago Bulls || Boston Celtics ");

        this.PreguntasTrivialFacil.put(35, " ¿Sabes cuántos corazones tiene un pulpo? ");
        this.RespuestasTrivialFacil.put(35, " 3 ");
        this.RespuestasIncorrectasFacil.put(35, " 1 || 4 || 2 ");

        this.PreguntasTrivialFacil.put(36, " ¿Quién es el hermano de Thor según Marvel? ");
        this.RespuestasTrivialFacil.put(36, " Loki ");
        this.RespuestasIncorrectasFacil.put(36, " Odín || Zeus || Asgard ");

        this.PreguntasTrivialFacil.put(37, " ¿Si tiramos un dado y obtenemos un 1, 2 ,3, 4 y 5 como resultado ¿Qué resultado obtendremos la sexta vez que lo tiremos?  ");
        this.RespuestasTrivialFacil.put(37, " Cualquier resultado del  1 al 6 ");
        this.RespuestasIncorrectasFacil.put(37, " 6 || 7 || Cualquier resultado menos el 6 ");

        this.PreguntasTrivialFacil.put(38, " ¿Qué pasó el 20 de julio de 1969? ");
        this.RespuestasTrivialFacil.put(38, " El Apolo 11 aterrizó en la Luna ");
        this.RespuestasIncorrectasFacil.put(38, " Terminó la Guerra Fría || Asesinato de Jhon F. Kennedy || Nació Mafalda ");

        this.PreguntasTrivialFacil.put(39, " ¿Quién es el autor de Don Quijote de la Mancha? ");
        this.RespuestasTrivialFacil.put(39, " Miguel de Cervantes ");
        this.RespuestasIncorrectasFacil.put(39, " Federico García Lorca || Edar Allan Poe || William Shakespeare ");

        this.PreguntasTrivialFacil.put(40, " ¿En qué país se encuentra el Wembley Arena? ");
        this.RespuestasTrivialFacil.put(40, " En el Reino Unido ");
        this.RespuestasIncorrectasFacil.put(40, " En Alemania || En Brasil || En España ");

        this.PreguntasTrivialFacil.put(41, " ¿Qué nombre científico recibe el detector de mentiras? ");
        this.RespuestasTrivialFacil.put(41, " Polígrafo ");
        this.RespuestasIncorrectasFacil.put(41, " DLP (Don't Lie Please) || Perígrafo || Monotorígrafo ");

        this.PreguntasTrivialFacil.put(42, " ¿Quién es el dirigente en Corea del Norte? ");
        this.RespuestasTrivialFacil.put(42, " Kim Jong-un ");
        this.RespuestasIncorrectasFacil.put(42, " Moon Jae-In || Park Geun-hye || Kim-Jung-sook ");

        this.PreguntasTrivialFacil.put(43, " ¿Quién dijo 'yo sólo sé que no se nada?' ");
        this.RespuestasTrivialFacil.put(43, " Sócrates ");
        this.RespuestasIncorrectasFacil.put(43, " Platón || Aristóteles || Tales de Mileto ");

        this.PreguntasTrivialFacil.put(44, " ¿Cómo se llaman los 3 tipos de triángulos? ");
        this.RespuestasTrivialFacil.put(44, " El equilátero, isósceles ,escaleno ");
        this.RespuestasIncorrectasFacil.put(44, "  El equilátero, isósceles ,réctangulo ||  El rectángulo, isósceles ,escaleno ||  El equilátero, rectángulo ,escaleno ");

        this.PreguntasTrivialFacil.put(45, " ¿Cuál es tercer planeta del sistema solar? ");
        this.RespuestasTrivialFacil.put(45, " La Tierra ");
        this.RespuestasIncorrectasFacil.put(45, " Marte || Venus || Saturno ");

        this.PreguntasTrivialFacil.put(46, " ¿Cuál es el edificio más alto del mundo? ");
        this.RespuestasTrivialFacil.put(46, " El edificio Burj Khalifa ");
        this.RespuestasIncorrectasFacil.put(46, " Empire State Building || One World Trade Center || Torre de Shanghai ");

        this.PreguntasTrivialFacil.put(47, " ¿Cuándo empezó la Primera Guerra Mundial? ");
        this.RespuestasTrivialFacil.put(47, " 1914 ");
        this.RespuestasIncorrectasFacil.put(47, " 1920 || 1900 || 1908 ");

        this.PreguntasTrivialFacil.put(48, " ¿En qué país se encuentra la ciudad de Varsovia? ");
        this.RespuestasTrivialFacil.put(48, " En Polonia ");
        this.RespuestasIncorrectasFacil.put(48, " En Ucrania || En Finlandia || En Ecuador ");

        this.PreguntasTrivialFacil.put(49, " ¿Cuál es el nombre de la herramienta necesaria para jugar al billar? ");
        this.RespuestasTrivialFacil.put(49, " Taco ");
        this.RespuestasIncorrectasFacil.put(49, " El Palito || Carambola || Snooker ");

        this.PreguntasTrivialFacil.put(50, " ¿En qué continente se encuentra el río Indo? ");
        this.RespuestasTrivialFacil.put(50, " En Asia ");
        this.RespuestasIncorrectasFacil.put(50, " En África || En Europa || En Oceanía ");

        this.PreguntasTrivialFacil.put(51, " ¿Quién escribió la obra de teatro 'La casa de Bernarda Alba'? ");
        this.RespuestasTrivialFacil.put(51, " Federico García Lorca ");
        this.RespuestasIncorrectasFacil.put(51, " Oscar Wild || Hernest Hemingway || Edgar Alllan Poe ");

        this.PreguntasTrivialFacil.put(52, "¿Qué tienen las ranas en la boca que no tienen los sapos? ");
        this.RespuestasTrivialFacil.put(52, " Dientes ");
        this.RespuestasIncorrectasFacil.put(52, " Lengua || Ácido || Los sapos no tienen boca ");

        this.PreguntasTrivialFacil.put(53, " ¿De qué país es Laura Pausini? ");
        this.RespuestasTrivialFacil.put(53, "  Italia ");
        this.RespuestasIncorrectasFacil.put(53, " Argentina || Inglaterra || Francia ");

        this.PreguntasTrivialFacil.put(54, " ¿Cuál es la capital de Finlandia? ");
        this.RespuestasTrivialFacil.put(54, " Helsinki ");
        this.RespuestasIncorrectasFacil.put(54, " Oslo || Estocolmo || Copenhague ");

        this.PreguntasTrivialFacil.put(55, " ¿Qué nombre tiene el supercontinente antiguo que agrupaba todos los continentes ahora existentes en uno solo? ");
        this.RespuestasTrivialFacil.put(55, " Pangea ");
        this.RespuestasIncorrectasFacil.put(55, " Panem || Sealand || Elleore ");

        this.PreguntasTrivialFacil.put(56, " ¿En la cima de que monte se suponía que vivía el dios Zeus? ");
        this.RespuestasTrivialFacil.put(56, " Monte Olimpo ");
        this.RespuestasIncorrectasFacil.put(56, " Everest || Kasfuh || Monte Fuji ");

        this.PreguntasTrivialFacil.put(57, " ¿Qué quería hacer Cruella de Vil con los 101 dálmatas? ");
        this.RespuestasTrivialFacil.put(57, " Un abrigo ");
        this.RespuestasIncorrectasFacil.put(57, " Unos zapatos || Unos pendientes || Un bolso ");

        this.PreguntasTrivialFacil.put(58, " ¿Cuál es la comida favorita del gato Garfield  ? ");
        this.RespuestasTrivialFacil.put(58, " Lasaña ");
        this.RespuestasIncorrectasFacil.put(58, " Pizza || Caviar || Hamburguesa ");

        this.PreguntasTrivialFacil.put(59, " ¿Dónde se encuentra el músculo esternocleidomastoideo ? ");
        this.RespuestasTrivialFacil.put(59, " En la zona lateral del cuello ");
        this.RespuestasIncorrectasFacil.put(59, " Detrás de la pierna || En el talón || En el antebrazo ");

        this.PreguntasTrivialFacil.put(60, " ¿Cómo se llama el conducto por donde se expulsa la orina? ");
        this.RespuestasTrivialFacil.put(60, " Uretra ");
        this.RespuestasIncorrectasFacil.put(60, " El conducto deferente || Vejiga || Próstata ");

        this.PreguntasTrivialFacil.put(61, " ¿Cuál es la Comunidad Autónoma española que tiene mayor número de provincias? ");
        this.RespuestasTrivialFacil.put(61, " Castilla y León ");
        this.RespuestasIncorrectasFacil.put(61, " Cataluña || País Vasco || Extremadura ");

        this.PreguntasTrivialFacil.put(62, " ¿En qué isla se encuentran las gigantescas estatuas llamadas 'Moáis'? ");
        this.RespuestasTrivialFacil.put(62, "  La isla de Pascua ");
        this.RespuestasIncorrectasFacil.put(62, " Menorca || Madagascar || Hawaii ");

        this.PreguntasTrivialFacil.put(63, " ¿Qué función tiene el laberinto en el cuerpo humano? ");
        this.RespuestasTrivialFacil.put(63, " Mantener el equilibrio ");
        this.RespuestasIncorrectasFacil.put(63, " Hacer una correcta digestión || Intercambiar el oxígeno por dióxido de carbono || Mantener una correcta circulación de la sangre ");

        this.PreguntasTrivialFacil.put(64, "Una persona que dentro de un tren en marcha se desplaza hasta la parte del principio del tren. ¿Va más rápido, más lento o igual que el propio tren? ");
        this.RespuestasTrivialFacil.put(64, " Más rápido ");
        this.RespuestasIncorrectasFacil.put(64, " Más lento || Van igual de rápido || Si estas dentro de un tren no te puedes mover ");

        this.PreguntasTrivialFacil.put(65, " ¿Cuál es el país menos poblado de Europa? ");
        this.RespuestasTrivialFacil.put(65, " Ciudad del Vaticano ");
        this.RespuestasIncorrectasFacil.put(65, " San Marino || Andorra || Liechtenstein ");

        this.PreguntasTrivialFacil.put(66, " ¿Cuál era el dios de la guerra en la mitología romana? ");
        this.RespuestasTrivialFacil.put(66, " Marte ");
        this.RespuestasIncorrectasFacil.put(66, " Júpiter || Minerva || Juno ");

        this.PreguntasTrivialFacil.put(67, " ¿Cuál es el río más caudaloso del mundo? ");
        this.RespuestasTrivialFacil.put(67, " El Amazonas ");
        this.RespuestasIncorrectasFacil.put(67, " El Nilo || El Danubio || El Misisipi ");

        this.PreguntasTrivialFacil.put(68, " ¿Contra quiénes luchó Leónidas en las Termópilas ? ");
        this.RespuestasTrivialFacil.put(68, " Persas ");
        this.RespuestasIncorrectasFacil.put(68, " Griegos || Romanos || Espartanos ");

        this.PreguntasTrivialFacil.put(69, " ¿En que estado se encuentra la famosa ciudad de Las Vegas?  ");
        this.RespuestasTrivialFacil.put(69, " Nevada ");
        this.RespuestasIncorrectasFacil.put(69, " Texas || Arizona || Illinois ");

        this.PreguntasTrivialFacil.put(70, " ¿Cuál es el libro más vendido de la historia? ");
        this.RespuestasTrivialFacil.put(70, " La Biblia ");
        this.RespuestasIncorrectasFacil.put(70, " El Corán || Don Quijote || El Principito ");

        this.PreguntasTrivialFacil.put(71, " ¿Con qué se tapa su propia desnudez Venus de Botticelli?  ");
        this.RespuestasTrivialFacil.put(71, " Con el cabello ");
        this.RespuestasIncorrectasFacil.put(71, " Con una concha || Con un girasol || Con un taparrabos ");

        this.PreguntasTrivialFacil.put(72, " ¿Cuál es la película más taquillera de la historia ? ");
        this.RespuestasTrivialFacil.put(72, " Avengers Endgame ");
        this.RespuestasIncorrectasFacil.put(72, " Avatar || Titanic || El Rey León ");

        this.PreguntasTrivialFacil.put(73, "  ¿Cuáles son los 4 pasos del Chiki - chiki de Rodolfo Chikilicuatre? ");
        this.RespuestasTrivialFacil.put(73, " 1.El Breinkindance 2.El Crusaíto 3.Maiquel Yason 4.El Robocop ");
        this.RespuestasIncorrectasFacil.put(73, " 1.El Breinkindance 2.El Reverse Turn 3.Step touch 4.El Robocop || 1.El Breinkindance 2.Basic Weave 3.Maiquel Yason 4.El Robocop || 1. El Cross Walk 2.El Revelé 3.Maiquel Yason 4.El Robocop ");

        this.PreguntasTrivialFacil.put(74, " ¿Qué se tatúa en el cuerpo el protagonista de Prisión Break? ");
        this.RespuestasTrivialFacil.put(74, " El plano de una prisión ");
        this.RespuestasIncorrectasFacil.put(74, " Un símbolo de interrogación || Un dragón escupiendo fuego azul || El corazón de su sobrina hecho pedazos ");

        this.PreguntasTrivialFacil.put(75, " ¿De qué color es el billete de 200 ? ");
        this.RespuestasTrivialFacil.put(75, " Amarillo ");
        this.RespuestasIncorrectasFacil.put(75, " Azul || Verde || Naranja ");

        this.PreguntasTrivialFacil.put(76, " ¿Por qué peculiar característica destaca Brian, el perro de los Griffin, en la serie Padre de Familia ? ");
        this.RespuestasTrivialFacil.put(76, " Puede hablar ");
        this.RespuestasIncorrectasFacil.put(76, " Tiene un gran olfato || Por su tamaño || Tiene heterocromía ");

        this.PreguntasTrivialFacil.put(77, " ¿Por qué antiguo nombre era reconocida la poderosa ciudad de Estambul? ");
        this.RespuestasTrivialFacil.put(77, " Constantinopla ");
        this.RespuestasIncorrectasFacil.put(77, " Atenas || Damasco || Cartago ");

        this.PreguntasTrivialFacil.put(78, "¿Qué famoso expresidente sudafricano estuvo encarcelado durante 27 años? ");
        this.RespuestasTrivialFacil.put(78, " Nelson Mandela ");
        this.RespuestasIncorrectasFacil.put(78, " Cyril Ramaphosa || Morgan Freeman || Jacob Zuma ");

        this.PreguntasTrivialFacil.put(79, " ¿Cuál de las siguientes obras hace referencia a una población española atacada durante la Guerra Civil pintada por Picasso? ");
        this.RespuestasTrivialFacil.put(79, " El Guernica ");
        this.RespuestasIncorrectasFacil.put(79, " La Noche Estrellada || Las Meninas || La Gioconda ");

        this.PreguntasTrivialFacil.put(80, " ¿Qué famoso descrubidor y explorador le puso su nombre al estrecho que conecta el oceano Pacífico y el Atlántico? ");
        this.RespuestasTrivialFacil.put(80, " Fernando de Magallanes ");
        this.RespuestasIncorrectasFacil.put(80, " Cristóbal Colón || James Cook || Charles Darwin ");

        this.PreguntasTrivialFacil.put(81, " Termina el refrán No por mucho madrugar...  ");
        this.RespuestasTrivialFacil.put(81, " amanece más temprano ");
        this.RespuestasIncorrectasFacil.put(81, " verá aquel que no quiera ver || dios te ayudará || que pajaro en mano ");

        this.PreguntasTrivialFacil.put(82, " ¿Quién fue el primer presidente de la democracia española tras el franquismo? ");
        this.RespuestasTrivialFacil.put(82, " Adolfo Suárez ");
        this.RespuestasIncorrectasFacil.put(82, " Calvo Sotelo || Felipe González Márquez || Jose María Aznar ");

        this.PreguntasTrivialFacil.put(83, " ¿Qué isla africana alberga el 58% de las especies de plantas y animales del mundo? ");
        this.RespuestasTrivialFacil.put(83, " Madagascar ");
        this.RespuestasIncorrectasFacil.put(83, " Mauricio || Santiago || Isla de Sal ");


        //------------------N-U-E-V-O-------------------------------------------------------------------------------------




        //----------------------------------------------------------------------------------------------------------------

        this.PreguntasTrivialMedio.put(0, " ¿Con qué se fabricaba el pergamino? ");
        this.RespuestasTrivialMedio.put(0, " Con piel de animal ");
        this.RespuestasIncorrectasMedio.put(0, " Con tela || Con cuero || Con madera ");

        this.PreguntasTrivialMedio.put(1, " ¿Cuál fue el primer metal que empleó el hombre? ");
        this.RespuestasTrivialMedio.put(1, " Cobre ");
        this.RespuestasIncorrectasMedio.put(1, " Aluminio || Oro || Hierro ");

        this.PreguntasTrivialMedio.put(2, " ¿Para que se utiliza el término matemático 'La Campana de Gauss'? ");
        this.RespuestasTrivialMedio.put(2, " Para el cálculo de probabilidades ");
        this.RespuestasIncorrectasMedio.put(2, " Para el cálculo de intereses || Para el cálculo de ángulos || Para el cálculo de volúmenes ");

        this.PreguntasTrivialMedio.put(3, " ¿Cómo se llama el perro de Will Smith en 'Soy Leyenda'? ");
        this.RespuestasTrivialMedio.put(3, " Sam ");
        this.RespuestasIncorrectasMedio.put(3, " Milú || Charlie || Scott ");

        this.PreguntasTrivialMedio.put(4, " ¿Cuántos años duró la guerra de los 100 años? ");
        this.RespuestasTrivialMedio.put(4, " 116 años ");
        this.RespuestasIncorrectasMedio.put(4, " 100 años || 50 años || 109 años ");

        this.PreguntasTrivialMedio.put(5, " ¿Cuál es el nombre del teorema que afirma que, en el triángulo rectángulo, el cuadrado de la hipotenusa es igual a la suma de los cuadrados de los catetos? ");
        this.RespuestasTrivialMedio.put(5, " Teorema de Pitágoras ");
        this.RespuestasIncorrectasMedio.put(5, " Teorema del coseno || Teorema de Bolzano || Ley de Ohm ");

        this.PreguntasTrivialMedio.put(6, " ¿Cuál es el idioma más antiguo de los que sobreviven en España y a la vez en Europa? ");
        this.RespuestasTrivialMedio.put(6, " El vasco ");
        this.RespuestasIncorrectasMedio.put(6, " El catalan || El español || El gallego ");

        this.PreguntasTrivialMedio.put(7, " ¿Cuál es el país con mayor porcentaje de budistas? ");
        this.RespuestasTrivialMedio.put(7, " Camboya ");
        this.RespuestasIncorrectasMedio.put(7, " China || India || Sri Lanka ");

        this.PreguntasTrivialMedio.put(8, " ¿Quién asistió a Andrés Iniesta para ganar el Mundial de 2010? ");
        this.RespuestasTrivialMedio.put(8, " Cesc Fábregas ");
        this.RespuestasIncorrectasMedio.put(8, " Fernando Torres || Xavi Hernández || Carles Puyol ");

        this.PreguntasTrivialMedio.put(9, " ¿Qué actriz ha ganado el mayor número de Premios Óscar? ");
        this.RespuestasTrivialMedio.put(9, " Katherine Hepburn ");
        this.RespuestasIncorrectasMedio.put(9, " Meryl Streep || Julia Roberts || Audrey Hepburn ");

        this.PreguntasTrivialMedio.put(10, " ¿Cuánto duró la Guerra Fría aproximadamente ? ");
        this.RespuestasTrivialMedio.put(10, " 44 años ");
        this.RespuestasIncorrectasMedio.put(10, " 22 años || 33 años || 55 años ");

        this.PreguntasTrivialMedio.put(11, " ¿A qué edad murió Wolfgang Amadeus Mozart? ");
        this.RespuestasTrivialMedio.put(11, " 35 años ");
        this.RespuestasIncorrectasMedio.put(11, " 30 años || 40 años || 25 años ");

        this.PreguntasTrivialMedio.put(12, " ¿Cuál es el nombre de la sustancia que le da el color verde a las plantas? ");
        this.RespuestasTrivialMedio.put(12, " Clorofila ");
        this.RespuestasIncorrectasMedio.put(12, " Salfumán || Éter || Cloroquina ");

        this.PreguntasTrivialMedio.put(13, " ¿En qué ciudad se originó el jazz? ");
        this.RespuestasTrivialMedio.put(13, " Nueva Orleans ");
        this.RespuestasIncorrectasMedio.put(13, " Boston || Kansas || Nueva York ");

        this.PreguntasTrivialMedio.put(14, " ¿Quién fue el presidente estadounidense al inicio de la Segunda Guerra Mundial? ");
        this.RespuestasTrivialMedio.put(14, " Franklin Delano Roosevelt ");
        this.RespuestasIncorrectasMedio.put(14, " George Washington || John F. Kennedy || Richard Nixon ");

        this.PreguntasTrivialMedio.put(15, " ¿Cuál es el símbolo químico del oro? ");
        this.RespuestasTrivialMedio.put(15, " AU ");
        this.RespuestasIncorrectasMedio.put(15, " HG || AG || FE ");

        this.PreguntasTrivialMedio.put(16, " IMBECIL ¿Qué significan las siglas ATP en el ámbito deportivo? ");
        this.RespuestasTrivialMedio.put(16, " Asociación de Tenistas Profesionales ");
        this.RespuestasIncorrectasMedio.put(16, " Asociación de Trineos Profesionales || Ámbito Típicamente Profesional || Asociación Temporal de Tenistas ");

        this.PreguntasTrivialMedio.put(17, " ¿Quién inventó el avión? ");
        this.RespuestasTrivialMedio.put(17, " Los hermanos Wright ");
        this.RespuestasIncorrectasMedio.put(17, " Alexander Graham Bell || Los hermanos Lumière || Arquímedes ");

        this.PreguntasTrivialMedio.put(18, " ¿Por qué nombre fue conocido Muhammad Ali al inicio de su carrera? ");
        this.RespuestasTrivialMedio.put(18, " Cassius Clay ");
        this.RespuestasIncorrectasMedio.put(18, " Mike Tyson || George Foreman || Carlos Monzón ");

        this.PreguntasTrivialMedio.put(19, " ¿Qué se usó originalmente en la icónica escena de la ducha de 'Psicosis' para simular la sangre de Janet Leigh? ");
        this.RespuestasTrivialMedio.put(19, " Salsa de chocolate ");
        this.RespuestasIncorrectasMedio.put(19, " Ketchup || Salsa de tomate || Sangre real ");

        this.PreguntasTrivialMedio.put(20, " IMBECIL ¿Cuál es el nombre del malvado rey de la película Shrek? ");
        this.RespuestasTrivialMedio.put(20, " Lord Farquaad ");
        this.RespuestasIncorrectasMedio.put(20, " Rey Arturo || Rey Midas || ¿Qué rey? ");

        this.PreguntasTrivialMedio.put(21, " ¿Cuál es el animal más venenoso del mundo? ");
        this.RespuestasTrivialMedio.put(21, " La medusa ");
        this.RespuestasIncorrectasMedio.put(21, " La víbora || El escorpión || El sapo ");

        this.PreguntasTrivialMedio.put(22, " ¿Cuántos huesos hay en el cuerpo humano, aproximadamente? ");
        this.RespuestasTrivialMedio.put(22, " 200 ");
        this.RespuestasIncorrectasMedio.put(22, " 300 || 100 || 150 ");

        this.PreguntasTrivialMedio.put(23, " ¿Cuál es el apellido del famoso amigo de Bart, Milhouse? ");
        this.RespuestasTrivialMedio.put(23, " Milhouse Van Houten ");
        this.RespuestasIncorrectasMedio.put(23, " Milhouse Simpson || Milhouse Skinner || Milhouse Muntz ");

        this.PreguntasTrivialMedio.put(24, " ¿Quién fue el primer ministro de Reino Unido durante la Segunda Guerra Mundial? ");
        this.RespuestasTrivialMedio.put(24, " Winston Churchill ");
        this.RespuestasIncorrectasMedio.put(24, " Boris Johnson || Harold MacMillan || Harold Wilson ");

        this.PreguntasTrivialMedio.put(25, " ¿De qué estilo arquitectónico es la Catedral de Notre Dame en París? ");
        this.RespuestasTrivialMedio.put(25, " De estilo gótico ");
        this.RespuestasIncorrectasMedio.put(25, " De estilo románico || De estilo barroco || De estilo neoclásico ");

        this.PreguntasTrivialMedio.put(26, " ¿Cuántas lenguas cooficiales existen en España además del español? ");
        this.RespuestasTrivialMedio.put(26, " 4. El euskera, catalán, gallego y aranés ");
        this.RespuestasIncorrectasMedio.put(26, " 5.El euskera, catalán, gallego, aranés y valenciano  || 5.El euskera, catalán, gallego, aranés y manchego || 4.El euskera, catalán, gallego y valenciano  ");

        this.PreguntasTrivialMedio.put(27, " ¿Quién es reconocido como 'el mejor inversor de la historia'? ");
        this.RespuestasTrivialMedio.put(27, " Warren Buffet ");
        this.RespuestasIncorrectasMedio.put(27, " Peter Lynch || Benjamin Graham || Bill Gates ");

        this.PreguntasTrivialMedio.put(28, " ¿Quién fue el escritor de 'Cien años de soledad'? ");
        this.RespuestasTrivialMedio.put(28, " Gabriel García Márquez ");
        this.RespuestasIncorrectasMedio.put(28, " Miguel de Cervantes || Lope de Vega || Pablo Neruda ");

        this.PreguntasTrivialMedio.put(29, " ¿Cómo se llamaban los tres sobrinos del Pato Donald? ");
        this.RespuestasTrivialMedio.put(29, " Juanito, Jaimito y Jorgito ");
        this.RespuestasIncorrectasMedio.put(29, " Joselito, Jaimito y Jorgito || Javito, Joselito y Jaimito || Juanito, Javito y Julito ");

        this.PreguntasTrivialMedio.put(30, " IMBECIL ¿Cómo se llama la canción con la que la cantante española Massiel ganó Eurovisión en 1968? ");
        this.RespuestasTrivialMedio.put(30, " Lalala ");
        this.RespuestasIncorrectasMedio.put(30, " Lelele || Lololo || Nanana ");

        this.PreguntasTrivialMedio.put(31, " IMBECIL ¿Cuál era el nombre de las 3 caravelas de Cirstobal Colon? ");
        this.RespuestasTrivialMedio.put(31, " Santa María, La Niña y La Pinta ");
        this.RespuestasIncorrectasMedio.put(31, " El Bismarck, La Pinta y La Santa María || La Doña, La Reina y la Santa María || La Santa María, La Reina y la Niña ");

        this.PreguntasTrivialMedio.put(32, " ¿Quien fue el director del Señor de los Anillos? ");
        this.RespuestasTrivialMedio.put(32, " Peter Jackson ");
        this.RespuestasIncorrectasMedio.put(32, " Steven Spielberg || James Cameron || Zack Snyder ");

        this.PreguntasTrivialMedio.put(33, " ¿Cuál es el nombre de la mujer de Iker Casillas? ");
        this.RespuestasTrivialMedio.put(33, " Sara Carbonero ");
        this.RespuestasIncorrectasMedio.put(33, " Cristina Pedroche || Ana Pastor || Mónica Carillo ");

        this.PreguntasTrivialMedio.put(34, " IMBECIL ¿Cual es la fórmula química del agua oxigenada? ");
        this.RespuestasTrivialMedio.put(34, " H2O2 ");
        this.RespuestasIncorrectasMedio.put(34, " HCI || CO2 || H2O3 ");

        this.PreguntasTrivialMedio.put(35, " ¿A qué país pertence Groenlandia? ");
        this.RespuestasTrivialMedio.put(35, " Dinamarca ");
        this.RespuestasIncorrectasMedio.put(35, " Islandia || Estados Unidos || Es un país ");

        this.PreguntasTrivialMedio.put(36, " ¿Cuál fue el primer satélite artificial lanzado al espacio? ");
        this.RespuestasTrivialMedio.put(36, " Sputnik 1 ");
        this.RespuestasIncorrectasMedio.put(36, " Explorer 1 || Apolo 11 || Astérix ");

        this.PreguntasTrivialMedio.put(37, " ¿A qué país pertenece el Cabo de Hornos? ");
        this.RespuestasTrivialMedio.put(37, " Chile ");
        this.RespuestasIncorrectasMedio.put(37, " Argentina || Panamá || Ecuador ");

        this.PreguntasTrivialMedio.put(38, " ¿Quién fue el inventor de la penicilina? ");
        this.RespuestasTrivialMedio.put(38, " Alexander Flemming ");
        this.RespuestasIncorrectasMedio.put(38, " James Watson || Edward Jenner || Maurice Hilleman ");

        this.PreguntasTrivialMedio.put(39, " ¿En qué país está el Kilimanjaro? ");
        this.RespuestasTrivialMedio.put(39, " Tanzania ");
        this.RespuestasIncorrectasMedio.put(39, " Zambia || Mozambique || Kenia ");

        this.PreguntasTrivialMedio.put(40, " Según el antiguo testamento, ¿cuántos días le tomó a Dios crear el mundo? ");
        this.RespuestasTrivialMedio.put(40, " 6 días ");
        this.RespuestasIncorrectasMedio.put(40, " 7 días || 8 días || 3 días ");

        this.PreguntasTrivialMedio.put(41, "¿Cómo se llama el primer videojuego que protagonizó Mario y en el que hizo su primera aparición? ");
        this.RespuestasTrivialMedio.put(41, " Donkey Kong ");
        this.RespuestasIncorrectasMedio.put(41, " Mario Bros || Mario Kart || Mario Land ");

        this.PreguntasTrivialMedio.put(42, "¿Cuál es el álbum musical más vendido de la hitoria? ");
        this.RespuestasTrivialMedio.put(42, " Thriller, de Michael Jackson ");
        this.RespuestasIncorrectasMedio.put(42, " Grease, artistas varios || Billie Jean, Michael Jackson || The Dark side of the moon, Pink Floyd ");

        this.PreguntasTrivialMedio.put(43, "¿Cuántas estrellas tiene la bandera actual de Estados Unidos? ");
        this.RespuestasTrivialMedio.put(43, " 50 ");
        this.RespuestasIncorrectasMedio.put(43, " 51 || 49 || 48 ");

        this.PreguntasTrivialMedio.put(44, " ¿Cuál es la capital de Irán? ");
        this.RespuestasTrivialMedio.put(44, " Teherán ");
        this.RespuestasIncorrectasMedio.put(44, " Riad || Abu Dabi || Baddag ");

        this.PreguntasTrivialMedio.put(45, "¿Quien el autor de la novela 'Viaje al centro de la Tirra'? ");
        this.RespuestasTrivialMedio.put(45, " Julio Verne ");
        this.RespuestasIncorrectasMedio.put(45, " Gabriel García Márquez || Agatha Christie || Mario Vargas Llosa ");

        this.PreguntasTrivialMedio.put(46, " IMBECIL ¿En qué lugar escribió Cervantes la mayor parte del Quijote? ");
        this.RespuestasTrivialMedio.put(46, " En la cárcel ");
        this.RespuestasIncorrectasMedio.put(46, " En su molino || En un bar || En un pueblo cerca de París ");

        this.PreguntasTrivialMedio.put(47, "¿Cuál era el nombre de la unidad de voluntarios españoles que lucho contra la unión soviética en la Segunda Guerra Mundial? ");
        this.RespuestasTrivialMedio.put(47, " La División Azul ");
        this.RespuestasIncorrectasMedio.put(47, " Brigada Costa del Sol || La Brigada Fantasma || Regimiento Nacional ");

        this.PreguntasTrivialMedio.put(48, "¿Cuántos distritos existían en Los Juegos del Hambre? ");
        this.RespuestasTrivialMedio.put(48, " 13 ");
        this.RespuestasIncorrectasMedio.put(48, " 12 || 11 || 14 ");

        this.PreguntasTrivialMedio.put(49, " ¿Qué mares unen el Canal de Suez? ");
        this.RespuestasTrivialMedio.put(49, " Mar Rojo y Mar Mediterráneo ");
        this.RespuestasIncorrectasMedio.put(49, " Mar Arábigo y Mar Mediterráneo || Mar Rojo y Mar Arábigo || Mar Negro y Mar Mediterráneo ");

        this.PreguntasTrivialMedio.put(50, " ¿Qué nombre le fue dado a la crisis económica mundial que hubo en el año 1929? ");
        this.RespuestasTrivialMedio.put(50, " El crack del 29 ");
        this.RespuestasIncorrectasMedio.put(50, " El Jueves Negro || Nixon Shock || La Gran Recesión ");

        this.PreguntasTrivialMedio.put(51, " ¿Qué cualidad le otorgaron los dioses a Pandora, que provocó que esta abriera el mítico recipiente? ");
        this.RespuestasTrivialMedio.put(51, " La curiosidad ");
        this.RespuestasIncorrectasMedio.put(51, " La envidia || El miedo || La esperanza ");

        this.PreguntasTrivialMedio.put(52, " IMBECIL ¿Cuál era el nombre de la ciudad del Rey Arturo? ");
        this.RespuestasTrivialMedio.put(52, " Camelot ");
        this.RespuestasIncorrectasMedio.put(52, " Lancelot || Tristán || Excálibur ");

        this.PreguntasTrivialMedio.put(53, " ¿Cuál era el nombre de Barcelona durante la época romana? ");
        this.RespuestasTrivialMedio.put(53, " Barcino ");
        this.RespuestasIncorrectasMedio.put(53, " Barcena || Barca || Barraco ");

        this.PreguntasTrivialMedio.put(54, " ¿En qué ciudad se rodaron las escenas de Juego de Tronos ubicadas en Braavos? ");
        this.RespuestasTrivialMedio.put(54, " Girona ");
        this.RespuestasIncorrectasMedio.put(54, " Sevilla || Almería || Córdoba ");

        this.PreguntasTrivialMedio.put(55, " IMBECIL ¿Qué se utiliza para dar forma al clítoris en una vaginoplastia? ");
        this.RespuestasTrivialMedio.put(55, " El glande ");
        this.RespuestasIncorrectasMedio.put(55, " El escroto || El prepucio || Piel ");

        this.PreguntasTrivialMedio.put(56, " ¿Quién fue el creador de la imprenta? ");
        this.RespuestasTrivialMedio.put(56, "Johhanes Gutemberg ");
        this.RespuestasIncorrectasMedio.put(56, " Louis Pasteur || Samuel Morse || Blaise Pascal ");

        this.PreguntasTrivialMedio.put(57, " ¿Dónde está el único desierto de España y, a la vez, de Europa? ");
        this.RespuestasTrivialMedio.put(57, " En Almería ");
        this.RespuestasIncorrectasMedio.put(57, " En San Sebastián || En Santiago de Compostela || En Murcia ");

        this.PreguntasTrivialMedio.put(58, " ¿Con la mezcla de qué colores se consigue el color violeta? ");
        this.RespuestasTrivialMedio.put(58, " Rojo y azul ");
        this.RespuestasIncorrectasMedio.put(58, " Rojo y Rosa || Azul y Amarillo || Naranja y Rosa ");

        this.PreguntasTrivialMedio.put(59, " ¿En qué países se encuentra el Everest? ");
        this.RespuestasTrivialMedio.put(59, " China y Nepal ");
        this.RespuestasIncorrectasMedio.put(59, " Nepal y India || India y Bangladesh || China y Bután ");

        this.PreguntasTrivialMedio.put(60, " ¿Qué afamada cantante es conocida como 'La reina del pop'? ");
        this.RespuestasTrivialMedio.put(60, " Madonna ");
        this.RespuestasIncorrectasMedio.put(60, " Shakira || Dua Lipa || Christina Aguilera ");

        this.PreguntasTrivialMedio.put(61, " IMBECIL ¿Qué dos hermanos fundaron Roma? ");
        this.RespuestasTrivialMedio.put(61, " Romulo y Remo ");
        this.RespuestasIncorrectasMedio.put(61, " Romulus y Romero || Rómilo y Roma || Roma y Remo ");

        this.PreguntasTrivialMedio.put(62, " IMBECIL ¿Qué volcán arrasó con la ciudad de Pompeya? ");
        this.RespuestasTrivialMedio.put(62, " El Vesubio ");
        this.RespuestasIncorrectasMedio.put(62, " Monte Tambora || Mont Peleé ||El Tambora  ");

        this.PreguntasTrivialMedio.put(63, " ¿Cuál es el río más largo de la península ibérica? ");
        this.RespuestasTrivialMedio.put(63, " El Tajo ");
        this.RespuestasIncorrectasMedio.put(63, " El Ebro || El Guadalquivir || El Pirineo Oriental ");

        this.PreguntasTrivialMedio.put(64, " ¿Cúal es la ciudad más poblada del mundo? ");
        this.RespuestasTrivialMedio.put(64, " Tokio ");
        this.RespuestasIncorrectasMedio.put(64, " Rio de Janeiro || Seúl || Shangai ");

        this.PreguntasTrivialMedio.put(65, " ¿Qué porcentaje de agua hay en el cuerpo humano? ");
        this.RespuestasTrivialMedio.put(65, " 75% ");
        this.RespuestasIncorrectasMedio.put(65, " 90% || 85% || 70% ");

        this.PreguntasTrivialMedio.put(66, " ¿A qué edad dio Mozart su primer concierto público? ");
        this.RespuestasTrivialMedio.put(66, " A los 5 años ");
        this.RespuestasIncorrectasMedio.put(66, " A los 7 años || A los 13 años || A los 15 años ");

        this.PreguntasTrivialMedio.put(67, " ¿Cuántos dedos tienes los caballos en cada pata? ");
        this.RespuestasTrivialMedio.put(67, " 1 ");
        this.RespuestasIncorrectasMedio.put(67, " 2 || 3 || ¿Dedos? ");

        this.PreguntasTrivialMedio.put(68, "¿Quién es el autor de 'Sueño de una noche de verano'? ");
        this.RespuestasTrivialMedio.put(68, " William Shakespeare ");
        this.RespuestasIncorrectasMedio.put(68, " Gabriel Garquía Marquez || Pablo Neruda || Lope de Vega ");

        this.PreguntasTrivialMedio.put(69, " ¿Cuántos jugadores hay por equipo en la pista durante un partido de volley? ");
        this.RespuestasTrivialMedio.put(69, " 6 ");
        this.RespuestasIncorrectasMedio.put(69, " 5 || 4 || 7 ");

        this.PreguntasTrivialMedio.put(70, " ¿Qué animal de granja no puede mirar hacia arriba? ");
        this.RespuestasTrivialMedio.put(70, " El cerdo ");
        this.RespuestasIncorrectasMedio.put(70, " La gallina || La vaca || Tu madre ");

        this.PreguntasTrivialMedio.put(71, " ¿Qué significa el término samurai? ");
        this.RespuestasTrivialMedio.put(71, " Servidor ");
        this.RespuestasIncorrectasMedio.put(71, " Guerrero || Valiente || Camarada ");

        this.PreguntasTrivialMedio.put(72, " ¿Cómo se llamaba el presentador del famoso concurso Pasapalbra durante 2007-2019? ");
        this.RespuestasTrivialMedio.put(72, " Christian Gálvez ");
        this.RespuestasIncorrectasMedio.put(72, " Jesús Vázquez || Matías Prats || Carlos Sobera ");

        this.PreguntasTrivialMedio.put(73, " ¿De qué novela es originario el personage de Gran Hermano ? ");
        this.RespuestasTrivialMedio.put(73, " 1984 ");
        this.RespuestasIncorrectasMedio.put(73, " Rebelión en la granja || La hija del clérigo || Subir a respirar ");

        this.PreguntasTrivialMedio.put(74, " ¿Cuántas especies de pingüinos existen en el hemisferio norte ? ");
        this.RespuestasTrivialMedio.put(74, " Ninguna ");
        this.RespuestasIncorrectasMedio.put(74, " 3 || 2 || 1 ");

        this.PreguntasTrivialMedio.put(75, " ¿Quién inventó la polea compuesta? ");
        this.RespuestasTrivialMedio.put(75, " Arquímedes ");
        this.RespuestasIncorrectasMedio.put(75, " Thomas Alva Eddison || Benjamin Franklin || Louis Lumière ");

        this.PreguntasTrivialMedio.put(76, " ¿Cuál es la religióm mayoritaria en India? ");
        this.RespuestasTrivialMedio.put(76, " El hinduismo ");
        this.RespuestasIncorrectasMedio.put(76, " El budismo || El islam || El Ghandismo ");

        this.PreguntasTrivialMedio.put(77, " ¿Cuánto duerme en promedio un koala al día? ");
        this.RespuestasTrivialMedio.put(77, " Alrededor de 20 horas ");
        this.RespuestasIncorrectasMedio.put(77, " Alrededor de 22 horas || Alrededor de 15 horas || Alrededor de 24 horas ");

        this.PreguntasTrivialMedio.put(78, " ¿Qué ciudad santa del islam se haya en Arabia Saudita? ");
        this.RespuestasTrivialMedio.put(78, " La Meca ");
        this.RespuestasIncorrectasMedio.put(78, " El Cairo || Jerusalén || Medina ");

        this.PreguntasTrivialMedio.put(79, " ¿Qué vestían los antiguos griegos para participar en las Olimpiadas? ");
        this.RespuestasTrivialMedio.put(79, " Nada ");
        this.RespuestasIncorrectasMedio.put(79, " Taparrabos || Una bata || Un collar y una tobillera ");


        this.PreguntasTrivialMedio.put(80, " IMBECIL El objetivo de los juicios de Nuremberg fue... ");
        this.RespuestasTrivialMedio.put(80, " Llevar a juicio a los nazis responsables del Holocausto ");
        this.RespuestasIncorrectasMedio.put(80, " Levar a juicio a los responsables de la I Guerra Mundial || Levar a juicio a Galileo Galilei || Levar a juicio a los causantes de la revolución francesa ");

        /*this.PreguntasTrivialMedio.put(80, " ¿Cuál es el apellido hispano más común en EEUU? ");
        this.RespuestasTrivialMedio.put(80, " Rodríguez ");
        this.RespuestasIncorrectasMedio.put(1, " García || Johnson || Wilson ");*/

        this.PreguntasTrivialMedio.put(81, " ¿Cómo se llamaba su dictador antes de la invasión a Irak? ");
        this.RespuestasTrivialMedio.put(81, " Saddam Hussein ");
        this.RespuestasIncorrectasMedio.put(81, " Augusto Pinochet || Mauma el Gadafi || Bachar el Asad ");

        this.PreguntasTrivialMedio.put(82, " ¿De qué idioma proviene el nombre de la unidad de longitud 'milla' ? ");
        this.RespuestasTrivialMedio.put(82, " Del latín ");
        this.RespuestasIncorrectasMedio.put(82, " Del Hebreo || Del anglosajón || Del farsi ");

        this.PreguntasTrivialMedio.put(83, " IMBECIL ¿Cuál es el músculo más rápido del cuerpo humano? ");
        this.RespuestasTrivialMedio.put(83, " El párpado ");
        this.RespuestasIncorrectasMedio.put(83, "  ||  ||  ");

        this.PreguntasTrivialMedio.put(84, " ¿Cuál es el único país que ha participado en todas las copas del mundo de fútbol? ");
        this.RespuestasTrivialMedio.put(84, " Brasil ");
        this.RespuestasIncorrectasMedio.put(84, " Alemania || España || Argentina ");

        this.PreguntasTrivialMedio.put(85, " IMBECIL¿Las aventuras de qué famoso personaje llevó Spielberg al cine en 2011? ");
        this.RespuestasTrivialMedio.put(85, " Tintin ");
        this.RespuestasIncorrectasMedio.put(85, " Shrek || Gru || Garfield ");

        this.PreguntasTrivialMedio.put(86, " ¿Cuánto debe durar una buena siesta según los neurólogos? ");
        this.RespuestasTrivialMedio.put(86, " Entre 10 y 20 minutos ");
        this.RespuestasIncorrectasMedio.put(86, " Entre 30 minutos y 1 hora || Entre 1 y 2 horas || Entre 20 y 40 minutos ");

        this.PreguntasTrivialMedio.put(87, " IMBECIL ¿Qué famoso personaje histórico 'tuvo un sueño' ? ");
        this.RespuestasTrivialMedio.put(87, " Martin Luther King ");
        this.RespuestasIncorrectasMedio.put(87, "  ||  ||  ");

        this.PreguntasTrivialMedio.put(88, " ¿De qué nacionalidad era el escritor del libro de la selva, Rudyard Kipling? ");
        this.RespuestasTrivialMedio.put(88, " Británico ");
        this.RespuestasIncorrectasMedio.put(88, " Indú || Peruano || Bangladesh ");

        this.PreguntasTrivialMedio.put(89, " ¿Qué país feu el primero en aprobar el sufragio femenino? ");
        this.RespuestasTrivialMedio.put(89, " Nueva Zelanda ");
        this.RespuestasIncorrectasMedio.put(89, " Estados Unidos || Alemania || Australia ");

        this.PreguntasTrivialMedio.put(90, " ¿Cuál es el significado de la palabra 'yoga'? ");
        this.RespuestasTrivialMedio.put(90, " Unión ");
        this.RespuestasIncorrectasMedio.put(90, " Equilibrio || Amor || Paz ");

        this.PreguntasTrivialMedio.put(91, " IMBECIL ¿Qué llevan incorporado en las boinas los integrantes de los 'Peaky Blinders' ? ");
        this.RespuestasTrivialMedio.put(91, " Cuchillas ");
        this.RespuestasIncorrectasMedio.put(91, "  ||  ||  ");

        this.PreguntasTrivialMedio.put(92, " ¿Cómo se llama el bar predilecto de los personajes de ¿Cómo conocí a vuestra madre'? ");
        this.RespuestasTrivialMedio.put(92, " MacLaren's ");
        this.RespuestasIncorrectasMedio.put(92, " La almeja borracha || Max&Henry || Central Perk ");

        this.PreguntasTrivialMedio.put(93, " IMBECIL ¿Qué mascota tenía Ross Geller de la famoso serie 'Friends' ? ");
        this.RespuestasTrivialMedio.put(93, " Un mono llamado Marcel ");
        this.RespuestasIncorrectasMedio.put(93, " Un gato llamado Marcel || Un cerdito llamado Marcel || Un pato llamado Marcel ");

        this.PreguntasTrivialMedio.put(94, " IMBECIL ¿En qué película interpreta Mel Gilbson a un rebelde escocés ? ");
        this.RespuestasTrivialMedio.put(94, " Braveheart ");
        this.RespuestasIncorrectasMedio.put(94, " El patriota || Apocalypto || We were soldiers ");

        this.PreguntasTrivialMedio.put(95, " ¿En qué país se inventó el fútbol? ");
        this.RespuestasTrivialMedio.put(95, " Inglaterra ");
        this.RespuestasIncorrectasMedio.put(95, " Alemania || Brasil || Argetina ");

        this.PreguntasTrivialMedio.put(96, " ¿A qué distancia está el punto de penalti de una portería de futbol? ");
        this.RespuestasTrivialMedio.put(96, " 11 metros ");
        this.RespuestasIncorrectasMedio.put(96, " 10 metros || 9 metros || 7 metros ");

        this.PreguntasTrivialMedio.put(97, " ¿De dónde es originario el grupo musical ABBA? ");
        this.RespuestasTrivialMedio.put(97, " Suecia ");
        this.RespuestasIncorrectasMedio.put(97, " Suiza || Noruega || Finlandia ");

        this.PreguntasTrivialMedio.put(98, " IMBECIL ¿De qué sexo son los caballitos de mar? ");
        this.RespuestasTrivialMedio.put(98, " Son hermafroditas ");
        this.RespuestasIncorrectasMedio.put(98, " Macho || Hembra || Prefieren no decirlo ");

        this.PreguntasTrivialMedio.put(99, " IMBECIL ¿Cuáles son las tres reliquias de la muerte de Harry Potter? ");
        this.RespuestasTrivialMedio.put(99, " Barita de Sauco, piedra de la resurrección y capa de la invisibilidad ");
        this.RespuestasIncorrectasMedio.put(99, " Barita de Sauco, piedra de la resurrección y el anillo de Marvolo Gaunt || Barita de Sauco, Copa de Hufflepuff y capa de la invisibilidad || Anillo de Marvolo Gaunt, Copa de Hufflepuff y capa de la invisibilidad ");









        //------N-U-E-V-O-S-----------------------------------------------------------------------------------------------




        //----------------------------------------------------------------------------------------------------------------

        this.PreguntasTrivialDificil.put(0, " ¿Cúal era el nombre del primer cartaginés que pisó España y recibió el nombre de 'Fundador de España'? ");
        this.RespuestasTrivialDificil.put(0, " Almilcar Barca ");
        this.RespuestasIncorrectasDificil.put(0, " Atila el huno || Centurión || Escipión Emiliano ");

        this.PreguntasTrivialDificil.put(1, " ¿Cuál es la capital de Pakistan? ");
        this.RespuestasTrivialDificil.put(1, " Islamabad ");

        this.PreguntasTrivialDificil.put(2, " El caviar verdadero es de huevos de qué pescado ? ");
        this.RespuestasTrivialDificil.put(2, " Esturión ");

        this.PreguntasTrivialDificil.put(3, " ¿En qué lugar del cuerpo se produce la insulina? ? ");
        this.RespuestasTrivialDificil.put(3, " En el páncreas ");

        this.PreguntasTrivialDificil.put(4, " ¿En qué año se disolvió la Unión Soviética? ");
        this.RespuestasTrivialDificil.put(4, " En 1991 ");

        this.PreguntasTrivialDificil.put(5, " ¿Cuál fue la primera película que apareció de Disney? ");
        this.RespuestasTrivialDificil.put(5, " Blancanieves, que se estrenó en el 1937 ");

        this.PreguntasTrivialDificil.put(6, " ¿De qué pintor es la obra 'El grito' ? ");
        this.RespuestasTrivialDificil.put(6, " De Edvard Munch ");

        this.PreguntasTrivialDificil.put(7, " ¿A qué estilo pertenece la obra 'El aquelarre' de Francisco de Goya? ");
        this.RespuestasTrivialDificil.put(7, " Romanticismo ");

        this.PreguntasTrivialDificil.put(8, " ¿Quién es el máximo goleador en la historia de los Mundiales de fútbol? ");
        this.RespuestasTrivialDificil.put(8, " Miroslav Klose ");

        this.PreguntasTrivialDificil.put(9, " ¿Cuál es el nombre de la obra literaria más famosa de Charles Dickens ? ");
        this.RespuestasTrivialDificil.put(9, " Oliver Twist ");

        this.PreguntasTrivialDificil.put(10, " ¿Cuál es el deporte en el que destacó Carl Lewis? ");
        this.RespuestasTrivialDificil.put(10, " Fue una figura importante del atletismo ");

        this.PreguntasTrivialDificil.put(11, "¿En qué deporte destacaba Toni Elías? ");
        this.RespuestasTrivialDificil.put(11, " En el motociclismo ");

        this.PreguntasTrivialDificil.put(12, "¿Cómo se le llama al proceso de división celular para formar dos células hijas a partir de una única célula? ");
        this.RespuestasTrivialDificil.put(12, " Mitosis ");

        this.PreguntasTrivialDificil.put(13, " ¿Cuál es el nombre de las partículas subatómicas de carga negativa? ");
        this.RespuestasTrivialDificil.put(13, " Electrones ");

        this.PreguntasTrivialDificil.put(14, " ¿Qué significan las siglas ADN? ");
        this.RespuestasTrivialDificil.put(14, " Ácido desoxirribonucleico ");

        this.PreguntasTrivialDificil.put(15, " ¿Dónde están ubicados los huesos escafoides? ");
        this.RespuestasTrivialDificil.put(15, " En la muñeca ");

        this.PreguntasTrivialDificil.put(16, " Cuál es la fórmula más famosa de Albert Einstein? ");
        this.RespuestasTrivialDificil.put(16, " E=MC^2. La energía equivale a la masa por la velocidad de la luz al cuadrado ");

        this.PreguntasTrivialDificil.put(17, "¿Qué moneda se utiliza en Marruecos? ");
        this.RespuestasTrivialDificil.put(17, " El dírham ");

        this.PreguntasTrivialDificil.put(18, " ¿Cómo se llamaba el famoso submarino de 'Veinte mil leguas de Viaje Submarino' de Julio Verne? ");
        this.RespuestasTrivialDificil.put(18, " Nautilus  ");

        this.PreguntasTrivialDificil.put(19, "¿Por qué hecho es recordada Rosa Parks? ");
        this.RespuestasTrivialDificil.put(19, " Por no ceder su asiento del autobús a una persona blanca ");

        this.PreguntasTrivialDificil.put(20, " ¿Qué significa la siguiente frase en latín?: 'Cogito ergo sum' ");
        this.RespuestasTrivialDificil.put(20, " Pienso, luego existo ");

        this.PreguntasTrivialDificil.put(21, " ¿Qué significa la siguiente frase en latín?: 'Alea iacta est'  ");
        this.RespuestasTrivialDificil.put(21, "  La suerte está echada - Julio César ");

        this.PreguntasTrivialDificil.put(22, " En la mitología griega:¿Quién diseño y fabrico el laberinto del minotauro?  ");
        this.RespuestasTrivialDificil.put(22, " Dédalo ");

        this.PreguntasTrivialDificil.put(23, "¿Qué mercader es célebre por sus viajes a Asia oriental durante la Edad Media? ");
        this.RespuestasTrivialDificil.put(23, " Marco Polo ");

        this.PreguntasTrivialDificil.put(24, " ¿Por qué motivo se celebra el día internacional de la mujer el 8 de marzo? ");
        this.RespuestasTrivialDificil.put(24, " El 8M de 1857 en Nueva York, cientos de mujeres protestaron contra bajos salarios después del incendio de su fábrica ");

        this.PreguntasTrivialDificil.put(25, " ¿A partir de qué momento termina la Edad Antigua y empieza la Edad Media? ");
        this.RespuestasTrivialDificil.put(25, " La caída del Imperio Romano, en el 476 d.C. ");

        this.PreguntasTrivialDificil.put(26, " ¿Qué conocido actor cómico imitó a Adolf Hitler en la película ‘El Gran Dictador’? ");
        this.RespuestasTrivialDificil.put(26, " Charles Chaplin ");

        this.PreguntasTrivialDificil.put(27, " ¿Cuál fue la dictadura que dio comienzo en España en el año 1923?  ");
        this.RespuestasTrivialDificil.put(27, " La del general Primo de Rivera ");

        this.PreguntasTrivialDificil.put(28, " ¿Qué famoso cantante ganó el premió Nobel de literatura en 2016? ");
        this.RespuestasTrivialDificil.put(28, " Bob Dylan ");

        this.PreguntasTrivialDificil.put(29, " ¿Qué arte marcial de origen suramericano fue concebido para parecerse a una danza? ");
        this.RespuestasTrivialDificil.put(29, " La capoeira ");

        this.PreguntasTrivialDificil.put(30, " ¿Cómo se llama la planta a partir de la cual se elabora el licor conocido como Tequila? ");
        this.RespuestasTrivialDificil.put(30, " Mezcal ");

        this.PreguntasTrivialDificil.put(31, " ¿En qué ciudad vivía el Mago de Oz? ");
        this.RespuestasTrivialDificil.put(31, " La Ciudad Esmeralda ");

        this.PreguntasTrivialDificil.put(32, "¿Dónde se encuentra el mar de la tranquilidad? ");
        this.RespuestasTrivialDificil.put(32, " En La Luna ");

        this.PreguntasTrivialDificil.put(33, " ¿De qué mujer estaba enamorado el Quijote?  ");
        this.RespuestasTrivialDificil.put(33, " De Dulcinea ");

        this.PreguntasTrivialDificil.put(34, " ¿Cuál era la ciudad natal de Marco Polo? ");
        this.RespuestasTrivialDificil.put(34, " Venecia ");

        this.PreguntasTrivialDificil.put(35, " ¿De qué banda es 'Smell Like Teen Spirit'? ");
        this.RespuestasTrivialDificil.put(35, " Nirvana ");

        this.PreguntasTrivialDificil.put(36, " ¿Quién es el inventor del telescopio reflector? ");
        this.RespuestasTrivialDificil.put(36, " El físico e inventor Isaac Newton ");

        this.PreguntasTrivialDificil.put(37, " ¿Con qué nombre se conoce el miedo a las alturas? ");
        this.RespuestasTrivialDificil.put(37, " Acrofobia ");

        this.PreguntasTrivialDificil.put(38, " Existe un ave que se alimenta básicamente de huesos. ¿Cuál es? ");
        this.RespuestasTrivialDificil.put(38, " Quebrantahuesos ");

        this.PreguntasTrivialDificil.put(39, "¿Cuál es el nombre de la madre de Simba en 'El Rey León'? ");
        this.RespuestasTrivialDificil.put(39, " Sarabi ");

        this.PreguntasTrivialDificil.put(40, " ¿Qué escritor español era apodado como 'el manco de Lepanto'? ");
        this.RespuestasTrivialDificil.put(40, " Miguel de Cervantes ");

        this.PreguntasTrivialDificil.put(41, " 'Ser o no ser, esa es la cuestión' es un soliloquio que pertenece a una obra de Shakespeare. ¿Cómo se llama?  ");
        this.RespuestasTrivialDificil.put(41, " Hamlet ");

        this.PreguntasTrivialDificil.put(42, " ¿Cuáles son las bases nitrogenadas del ADN?  ");
        this.RespuestasTrivialDificil.put(42, " La Guanina, la adenina, la timina y la citosina ");

        this.PreguntasTrivialDificil.put(43, " ¿Qué elemento contiene todos los componentes orgánicos?  ");
        this.RespuestasTrivialDificil.put(43, " El carbono ");

        this.PreguntasTrivialDificil.put(44, " ¿Quién es el mejor ajedrecista noruego de la historia?  ");
        this.RespuestasTrivialDificil.put(44, " Magnus Carlsen ");

        this.PreguntasTrivialDificil.put(45, " ¿Qué ocurre si tiras una pelota al Mar Negro?  ");
        this.RespuestasTrivialDificil.put(45, " Se moja ");

        this.PreguntasTrivialDificil.put(46, " ¿Qué objeto común  puede tener cara sin poseer cuerpo? ");
        this.RespuestasTrivialDificil.put(46, " Una moneda");

        this.PreguntasTrivialDificil.put(47, " ¿En qué lugar es posible ver el día jueves antes que el día miércoles? ");
        this.RespuestasTrivialDificil.put(47, " En el diccionario ");

        this.PreguntasTrivialDificil.put(48, " ¿Cuáles son los días más largos que tiene un mes cualquiera?  ");
        this.RespuestasTrivialDificil.put(48, " Miércoles ya que contiene nueve letras. M-i-é-r-c-o-l-e-s ");

        this.PreguntasTrivialDificil.put(49, " Existe un sastre que pesa más de 150kg, ¿ sabes qué mide? ");
        this.RespuestasTrivialDificil.put(49, " Tela, los sastres miden tela ");

        this.PreguntasTrivialDificil.put(50, " En la mitología griega a que dios se le asocia con el vino,la fertilidad,el teatro y el éxtasis? ");
        this.RespuestasTrivialDificil.put(50, " Dionisio ");

        this.PreguntasTrivialDificil.put(51, " ¿En la mitología griega qué dios tenía habilidades de herrero?  ");
        this.RespuestasTrivialDificil.put(51, " Hefesto ");

        this.PreguntasTrivialDificil.put(52, " ¿En qué país se encuentra la última tribu caníbal conocida del planeta? ");
        this.RespuestasTrivialDificil.put(52, " Nueva Guinea ");

        this.PreguntasTrivialDificil.put(53, " ¿En qué país se encuentra el río Po? ");
        this.RespuestasTrivialDificil.put(53, " Italia ");

        this.PreguntasTrivialDificil.put(54, " ¿Cuál es el país más visitado del mundo? ");
        this.RespuestasTrivialDificil.put(54, " Francia ");

        this.PreguntasTrivialDificil.put(55, " ¿En qué paises es oficial el quechua como lengua oficial nacional? ");
        this.RespuestasTrivialDificil.put(55, " Perú, Ecuador y Bolivia ");

        this.PreguntasTrivialDificil.put(56, " ¿Cuál es el océano que baña las aguas de Sri Lanka? ");
        this.RespuestasTrivialDificil.put(56, " El Índico ");

        this.PreguntasTrivialDificil.put(57, " ¿Qué nombre recibe un cowboy argentino? ");
        this.RespuestasTrivialDificil.put(57, " Gaucho ");

        this.PreguntasTrivialDificil.put(58, " ¿A qué dos continentes se debe la existencia del budú? ");
        this.RespuestasTrivialDificil.put(58, " A África y América ");

        this.PreguntasTrivialDificil.put(59, " ¿Quién fue el autor español de la fábula de 'La Hormiga y la Cigarra'? ");
        this.RespuestasTrivialDificil.put(59, " Félix María Samaniego ");

        this.PreguntasTrivialDificil.put(60, " ¿Qué pseudónimo usaba el escritor inglés Eric Arthur Blair?" );
        this.RespuestasTrivialDificil.put(60, " George Orwell ");

        this.PreguntasTrivialDificil.put(61, " ¿Cómo se llama el libro de Ray Bradbury en el que se queman libros? ");
        this.RespuestasTrivialDificil.put(61, " Fahrenheit 451 ");

        this.PreguntasTrivialDificil.put(62, " ¿Quién escribió 'Poeta en Nueva York'? ");
        this.RespuestasTrivialDificil.put(62, " Federico García Lorca ");

        this.PreguntasTrivialDificil.put(63, " ¿Quién era el campanero jorobado de Notre Damme? ");
        this.RespuestasTrivialDificil.put(63, " Quasimodo ");

        this.PreguntasTrivialDificil.put(64, " ¿En qué ciudad comenzó y terminó Phileas Fogg su viaje alrededor del mundo? ");
        this.RespuestasTrivialDificil.put(64, " En Londres ");

        this.PreguntasTrivialDificil.put(65, " ¿En qué ciudad española se encuentra 'La casa de las conchas'? ");
        this.RespuestasTrivialDificil.put(65, " Salamanca ");

        this.PreguntasTrivialDificil.put(66, " ¿Quién dirigió y protagonizó 'Ciudadano Kane'? ");
        this.RespuestasTrivialDificil.put(66, " Orson Welles ");

        this.PreguntasTrivialDificil.put(67, " ¿Por qué motivo fue famosa la perra Laika? ");
        this.RespuestasTrivialDificil.put(67, " Fue el primer perro en ir al espacio ");

        this.PreguntasTrivialDificil.put(68, " ¿Qué significan las siglas a.m. detrás de una hora? ");
        this.RespuestasTrivialDificil.put(68, " Antes del Meridiano ");

        this.PreguntasTrivialDificil.put(69, " ¿Cómo se llaman las lineas que unen los puntos de igual temperatura? ");
        this.RespuestasTrivialDificil.put(69, " Isobaras ");





        //----------------N-U-E-V-O-S--------------------------------------------------------


    }

    public HashMap<Integer,String> getPreguntasTrivialFaciles(){ return this.PreguntasTrivialFacil;}

    public HashMap<Integer,String> getPreguntasTrivialMedio(){ return this.PreguntasTrivialMedio;}

    public HashMap<Integer,String> getPreguntasTrivialDificil(){ return this.PreguntasTrivialDificil;}

    public HashMap<Integer,String> getRespuestasTrivialFaciles(){ return this.RespuestasTrivialFacil;}

    public HashMap<Integer,String> getRespuestasTrivialMedio(){ return this.RespuestasTrivialMedio;}

    public HashMap<Integer,String> getRespuestasTrivialDificil(){ return this.RespuestasTrivialDificil;}

    public HashMap<Integer, String> getRespuestasIncorrectasFacil() { return RespuestasIncorrectasFacil; }

    public HashMap<Integer, String> getRespuestasIncorrectasMedio() { return RespuestasIncorrectasMedio; }

    public HashMap<Integer, String> getRespuestasIncorrectasDificil() { return RespuestasIncorrectasDificil; }
}
