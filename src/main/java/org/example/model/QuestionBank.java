package app.model;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Banco de preguntas de cultura general.
 * 30 preguntas por categoría (Historia, Ciencia, Cultura):
 * - 15 de nivel 1 (fáciles)
 * - 15 de nivel 2 (difíciles)
 */
public class QuestionBank {
    private List<Question> questions = new ArrayList<>();
    private Random rnd = new Random();

    public QuestionBank() {
        loadSampleQuestions();
    }

    private void loadSampleQuestions() {

        /* ========================================================
         *                      HISTORIA — NIVEL 1 (15)
         * ======================================================== */
        questions.add(new Question("Historia","¿Quién fue el primer presidente de Estados Unidos?",
                Arrays.asList("George Washington","Thomas Jefferson","Abraham Lincoln","John Adams"),0,1));
        questions.add(new Question("Historia","¿En qué año llegó Cristóbal Colón a América?",
                Arrays.asList("1492","1500","1510","1485"),0,1));
        questions.add(new Question("Historia","¿Cuál civilización construyó Machu Picchu?",
                Arrays.asList("Inca","Maya","Azteca","Olmeca"),0,1));
        questions.add(new Question("Historia","¿Dónde se originaron los Juegos Olímpicos antiguos?",
                Arrays.asList("Grecia","Roma","Egipto","China"),0,1));
        questions.add(new Question("Historia","¿Quién liberó parte de Sudamérica del dominio español?",
                Arrays.asList("Simón Bolívar","San Martín","Sucre","O'Higgins"),0,1));
        questions.add(new Question("Historia","¿Qué imperio construyó el Coliseo?",
                Arrays.asList("Imperio Romano","Imperio Bizantino","Imperio Otomano","Imperio Persa"),0,1));
        questions.add(new Question("Historia","¿Qué ciudad fue destruida por el Vesubio en el año 79?",
                Arrays.asList("Pompeya","Cartago","Atenas","Tiro"),0,1));
        questions.add(new Question("Historia","¿Qué nación construyó la Gran Muralla?",
                Arrays.asList("China","Japón","Corea","Mongolia"),0,1));
        questions.add(new Question("Historia","¿Cuál era el barco del Titanic?",
                Arrays.asList("RMS Titanic","HMS Victory","SS Great Britain","USS Constitution"),0,1));
        questions.add(new Question("Historia","¿Qué guerra enfrentó a Aliados y Potencias del Eje?",
                Arrays.asList("Segunda Guerra Mundial","Primera Guerra Mundial","Guerra Fría","Guerra del Golfo"),0,1));
        questions.add(new Question("Historia","¿Qué país lanzó la primera bomba atómica?",
                Arrays.asList("Estados Unidos","Rusia","Japón","Alemania"),0,1));
        questions.add(new Question("Historia","¿Quién descubrió la penicilina?",
                Arrays.asList("Alexander Fleming","Pasteur","Koch","Newton"),0,1));
        questions.add(new Question("Historia","¿Qué muro dividió Berlín hasta 1989?",
                Arrays.asList("Muro de Berlín","Gran Muralla","Muralla Atlántica","Muralla Roja"),0,1));
        questions.add(new Question("Historia","¿Qué cultura creó los jeroglíficos?",
                Arrays.asList("Egipcia","China","Sumeria","Inca"),0,1));
        questions.add(new Question("Historia","¿En qué país surgió el Renacimiento?",
                Arrays.asList("Italia","Francia","España","Holanda"),0,1));

        /* ========================================================
         *                      HISTORIA — NIVEL 2 (15)
         * ======================================================== */
        questions.add(new Question("Historia","¿Qué doctrina definió la política exterior de EE. UU. en 1823?",
                Arrays.asList("Doctrina Monroe","Plan Marshall","Doctrina Truman","Doctrina Brezhnev"),0,2));
        questions.add(new Question("Historia","¿Qué tratado puso fin a la Primera Guerra Mundial?",
                Arrays.asList("Tratado de Versalles","Tratado de París","Pacto de Varsovia","Tratado de Utrecht"),0,2));
        questions.add(new Question("Historia","¿Qué imperio gobernó Ciro el Grande?",
                Arrays.asList("Persa","Egipcio","Romano","Hitita"),0,2));
        questions.add(new Question("Historia","¿Qué dinastía unificó China y creó la muralla?",
                Arrays.asList("Qin","Han","Zhou","Tang"),0,2));
        questions.add(new Question("Historia","¿Quién fue el último zar ruso?",
                Arrays.asList("Nicolás II","Pedro I","Iván IV","Alejandro III"),0,2));
        questions.add(new Question("Historia","¿Quién luchó contra el apartheid?",
                Arrays.asList("Nelson Mandela","Haile Selassie","Nkrumah","Lumumba"),0,2));
        questions.add(new Question("Historia","¿Quién escribió El arte de la guerra?",
                Arrays.asList("Sun Tzu","Confucio","Mencio","Lao Tse"),0,2));
        questions.add(new Question("Historia","¿Qué guerra se libró entre Norte y Sur de EE. UU.?",
                Arrays.asList("Guerra Civil","Guerra Hispanoamericana","Guerra de Secesión","Guerra de Independencia"),0,2));
        questions.add(new Question("Historia","¿Qué país colonizó Filipinas hasta 1898?",
                Arrays.asList("España","Holanda","Portugal","Reino Unido"),0,2));
        questions.add(new Question("Historia","¿Cuál era la principal ruta comercial Asia–Mediterráneo?",
                Arrays.asList("Ruta de la Seda","Camino del Incienso","Ruta Báltica","Camino Real"),0,2));
        questions.add(new Question("Historia","¿Qué rey inglés tuvo seis esposas?",
                Arrays.asList("Enrique VIII","Ricardo III","Carlos I","Eduardo VI"),0,2));
        questions.add(new Question("Historia","¿Qué civilización inventó el cero?",
                Arrays.asList("Mayas","Egipcios","Romanos","Vikingos"),0,2));
        questions.add(new Question("Historia","¿En qué país ocurrió la Restauración Meiji?",
                Arrays.asList("Japón","China","Corea","Vietnam"),0,2));
        questions.add(new Question("Historia","¿Qué imperio cayó en 1453?",
                Arrays.asList("Bizantino","Romano","Persa","Otomano"),0,2));
        questions.add(new Question("Historia","¿Quién creó el Código de Hammurabi?",
                Arrays.asList("Babilonios","Asirios","Sumerios","Persas"),0,2));


        /* ========================================================
         *                      HISTORIA — NIVEL 3 (15)
         * ======================================================== */
        questions.add(new Question("Historia","¿Cuál fue la primera civilización en usar escritura cuneiforme?",
                Arrays.asList("Sumerios","Babilonios","Asirios","Fenicios"),0,3));
        questions.add(new Question("Historia","¿En qué año cayó el Imperio Romano de Occidente?",
                Arrays.asList("476 d.C.","410 d.C.","536 d.C.","600 d.C."),0,3));
        questions.add(new Question("Historia","¿Quién completó la primera vuelta al mundo?",
                Arrays.asList("Elcano","Magallanes","Colón","Vasco da Gama"),0,3));
        questions.add(new Question("Historia","¿Qué imperio usaba quipus para registrar datos?",
                Arrays.asList("Inca","Azteca","Maya","Olmeca"),0,3));
        questions.add(new Question("Historia","¿Qué guerra introdujo tanques por primera vez?",
                Arrays.asList("Primera Guerra Mundial","Segunda Guerra Mundial","Guerra de Crimea","Guerra Franco-Prusiana"),0,3));
        questions.add(new Question("Historia","¿Qué documento limitó el poder del rey inglés en 1215?",
                Arrays.asList("Carta Magna","Pacto de Oxford","Constitución Real","Tratado de Londres"),0,3));
        questions.add(new Question("Historia","¿Qué imperio construyó Angkor Wat?",
                Arrays.asList("Imperio Jemer","Imperio Chino","Imperio Indio","Imperio Mongol"),0,3));
        questions.add(new Question("Historia","¿Qué batalla marcó la caída de Napoleón?",
                Arrays.asList("Waterloo","Austerlitz","Trafalgar","Leipzig"),0,3));
        questions.add(new Question("Historia","¿Quién fue la primera mujer en ganar un Nobel?",
                Arrays.asList("Marie Curie","Florence Nightingale","Ada Lovelace","Barbara McClintock"),0,3));
        questions.add(new Question("Historia","¿Qué dinastía gobernó Francia antes de la Revolución?",
                Arrays.asList("Borbones","Valois","Capetos","Habsburgo"),0,3));
        questions.add(new Question("Historia","¿Qué civilización construyó Tikal y Palenque?",
                Arrays.asList("Maya","Azteca","Tolteca","Olmeca"),0,3));
        questions.add(new Question("Historia","¿Qué conquistador derrotó al Imperio Inca?",
                Arrays.asList("Francisco Pizarro","Cortés","Balboa","Orellana"),0,3));
        questions.add(new Question("Historia","¿Qué guerra terminó con la caída de Saigón en 1975?",
                Arrays.asList("Guerra de Vietnam","Guerra de Corea","Guerra del Golfo","Guerra Fría"),0,3));
        questions.add(new Question("Historia","¿Quién fundó la Biblioteca de Alejandría?",
                Arrays.asList("Ptolomeo I","Alejandro Magno","Cleopatra","Ramsés II"),0,3));
        questions.add(new Question("Historia","¿Qué imperio cayó ante los otomanos en 1453?",
                Arrays.asList("Bizantino","Romano","Macedonio","Helénico"),0,3));


        /* ========================================================
         *                    CIENCIA — NIVEL 1 (15)
         * ======================================================== */
        questions.add(new Question("Ciencia","¿Cuál es la fórmula del agua?",
                Arrays.asList("H₂O","CO₂","O₂","H₂SO₄"),0,1));
        questions.add(new Question("Ciencia","¿Qué partícula tiene carga negativa?",
                Arrays.asList("Electrón","Protón","Neutrón","Bosón"),0,1));
        questions.add(new Question("Ciencia","¿Qué planeta es el planeta rojo?",
                Arrays.asList("Marte","Venus","Júpiter","Saturno"),0,1));
        questions.add(new Question("Ciencia","¿Cuál es el órgano más grande del cuerpo humano?",
                Arrays.asList("La piel","El hígado","El corazón","El cerebro"),0,1));
        questions.add(new Question("Ciencia","¿Qué gas necesitamos para respirar?",
                Arrays.asList("Oxígeno","Hidrógeno","Nitrógeno","Amoníaco"),0,1));
        questions.add(new Question("Ciencia","¿Cuál es el centro del Sistema Solar?",
                Arrays.asList("El Sol","La Tierra","Júpiter","La Luna"),0,1));
        questions.add(new Question("Ciencia","¿Cuántos cromosomas tiene un humano?",
                Arrays.asList("46","44","56","48"),0,1));
        questions.add(new Question("Ciencia","¿Cuál es el metal más ligero?",
                Arrays.asList("Litio","Aluminio","Plata","Titanio"),0,1));
        questions.add(new Question("Ciencia","¿Qué energía proviene del sol?",
                Arrays.asList("Solar","Eólica","Geotérmica","Nuclear"),0,1));
        questions.add(new Question("Ciencia","¿Qué fuerza nos mantiene en el suelo?",
                Arrays.asList("Gravedad","Inercia","Fricción","Centrífuga"),0,1));
        questions.add(new Question("Ciencia","¿Cuál es el animal terrestre más grande?",
                Arrays.asList("Elefante africano","Jirafa","Rinoceronte","Hipopótamo"),0,1));
        questions.add(new Question("Ciencia","¿Qué órgano bombea la sangre?",
                Arrays.asList("Corazón","Pulmones","Hígado","Riñones"),0,1));
        questions.add(new Question("Ciencia","¿Cómo se llama la cría del perro?",
                Arrays.asList("Cachorro","Ternero","Polluelo","Cabrito"),0,1));
        questions.add(new Question("Ciencia","¿Estado del agua a 100°C?",
                Arrays.asList("Gaseoso","Líquido","Sólido","Plasma"),0,1));
        questions.add(new Question("Ciencia","¿Qué instrumento mide la temperatura?",
                Arrays.asList("Termómetro","Barómetro","Anemómetro","Higrómetro"),0,1));


        /* ========================================================
         *                    CIENCIA — NIVEL 2 (15)
         * ======================================================== */
        questions.add(new Question("Ciencia","¿Velocidad de la luz?",
                Arrays.asList("3×10⁸ m/s","3×10⁶ m/s","1×10⁵ m/s","9.8 m/s"),0,2));
        questions.add(new Question("Ciencia","¿Quién propuso la relatividad?",
                Arrays.asList("Einstein","Newton","Planck","Hawking"),0,2));
        questions.add(new Question("Ciencia","Elemento más abundante del universo:",
                Arrays.asList("Hidrógeno","Helio","Oxígeno","Carbono"),0,2));
        questions.add(new Question("Ciencia","Radiación que causa quemaduras solares:",
                Arrays.asList("UV","IR","Microondas","Gamma"),0,2));
        questions.add(new Question("Ciencia","Molécula que contiene información genética:",
                Arrays.asList("ADN","ARN","Proteínas","Lípidos"),0,2));
        questions.add(new Question("Ciencia","Número atómico del carbono:",
                Arrays.asList("6","12","8","14"),0,2));
        questions.add(new Question("Ciencia","Proceso por el que plantas fabrican alimento:",
                Arrays.asList("Fotosíntesis","Respiración","Fermentación","Oxidación"),0,2));
        questions.add(new Question("Ciencia","Unidad de fuerza:",
                Arrays.asList("Newton","Joule","Watt","Pascal"),0,2));
        questions.add(new Question("Ciencia","Organelo que produce energía:",
                Arrays.asList("Mitocondria","Ribosoma","Núcleo","Cloroplasto"),0,2));
        questions.add(new Question("Ciencia","¿Dónde están los neutrones?",
                Arrays.asList("Núcleo","Órbita","Corteza","Citoplasma"),0,2));
        questions.add(new Question("Ciencia","Estrella más cercana:",
                Arrays.asList("El Sol","Próxima Centauri","Sirio","Betelgeuse"),0,2));
        questions.add(new Question("Ciencia","¿Quién descubrió la gravedad?",
                Arrays.asList("Newton","Galileo","Kepler","Descartes"),0,2));
        questions.add(new Question("Ciencia","¿Qué es materia oscura?",
                Arrays.asList("Materia invisible que afecta gravedad","Gas interestelar","Luz no visible","Materia submarina"),0,2));
        questions.add(new Question("Ciencia","Planeta con vientos más fuertes:",
                Arrays.asList("Neptuno","Urano","Saturno","Marte"),0,2));
        questions.add(new Question("Ciencia","¿Quién describió las leyes del movimiento planetario?",
                Arrays.asList("Kepler","Copérnico","Ptolomeo","Brahe"),0,2));


        /* ========================================================
         *                    CIENCIA — NIVEL 3 (15)
         * ======================================================== */
        questions.add(new Question("Ciencia","¿Qué científico desarrolló el principio de incertidumbre?",
                Arrays.asList("Heisenberg","Bohr","Dirac","Planck"),0,3));
        questions.add(new Question("Ciencia","¿Cuál es la constante de gravitación universal?",
                Arrays.asList("6.67×10⁻¹¹","3.14","9.8","1.6×10⁻¹⁹"),0,3));
        questions.add(new Question("Ciencia","¿Quién formuló las leyes de la termodinámica?",
                Arrays.asList("Clausius","Einstein","Pascal","Coulomb"),0,3));
        questions.add(new Question("Ciencia","¿Qué partículas forman el núcleo atómico?",
                Arrays.asList("Protones y neutrones","Electrones","Quarks","Fotones"),0,3));
        questions.add(new Question("Ciencia","¿Qué científico propuso la teoría del Big Bang?",
                Arrays.asList("Georges Lemaître","Hubble","Einstein","Hoyle"),0,3));
        questions.add(new Question("Ciencia","¿Cuál es el tejido más duro del cuerpo?",
                Arrays.asList("Esmalte dental","Hueso","Cartílago","Tendón"),0,3));
        questions.add(new Question("Ciencia","¿Qué fenómeno explica la expansión del universo?",
                Arrays.asList("Corrimiento al rojo","Difracción","Refracción","Efecto fotoeléctrico"),0,3));
        questions.add(new Question("Ciencia","¿Cuál es el nombre científico del ser humano?",
                Arrays.asList("Homo sapiens","Homo erectus","Homo habilis","Homo neanderthalensis"),0,3));
        questions.add(new Question("Ciencia","¿Qué científico descubrió el electrón?",
                Arrays.asList("Thomson","Rutherford","Bohr","Planck"),0,3));
        questions.add(new Question("Ciencia","¿Cuál es la galaxia más cercana a la Vía Láctea?",
                Arrays.asList("Andrómeda","Sagitario","Sombrero","Triángulo"),0,3));
        questions.add(new Question("Ciencia","¿Qué proceso produce energía en el Sol?",
                Arrays.asList("Fusión nuclear","Fisión nuclear","Combustión","Oxidación"),0,3));
        questions.add(new Question("Ciencia","¿Qué unidad mide la frecuencia?",
                Arrays.asList("Hertz","Pascal","Volt","Newton"),0,3));
        questions.add(new Question("Ciencia","¿Cómo se llama el proceso de división celular?",
                Arrays.asList("Mitosis","Meiosis","Citocinesis","Duplicación"),0,3));
        questions.add(new Question("Ciencia","¿Qué parte del oído convierte sonido en impulsos nerviosos?",
                Arrays.asList("Cóclea","Tímpano","Martillo","Yunque"),0,3));
        questions.add(new Question("Ciencia","¿Qué tipo de galaxia es la Vía Láctea?",
                Arrays.asList("Espiral barrada","Elíptica","Irregular","Anular"),0,3));


        /* ========================================================
         *                    CULTURA — NIVEL 1 (15)
         * ======================================================== */
        questions.add(new Question("Cultura","¿Cuál es la capital de Colombia?",
                Arrays.asList("Bogotá","Cali","Medellín","Barranquilla"),0,1));
        questions.add(new Question("Cultura","¿Quién escribió Cien años de soledad?",
                Arrays.asList("Gabriel García Márquez","Pablo Neruda","Vargas Llosa","Cortázar"),0,1));
        questions.add(new Question("Cultura","Idioma más hablado del mundo:",
                Arrays.asList("Chino mandarín","Inglés","Español","Hindi"),0,1));
        questions.add(new Question("Cultura","¿De qué país es el sushi?",
                Arrays.asList("Japón","China","Corea","Vietnam"),0,1));
        questions.add(new Question("Cultura","Océano más grande:",
                Arrays.asList("Pacífico","Atlántico","Índico","Ártico"),0,1));
        questions.add(new Question("Cultura","¿Qué instrumento tiene teclas blancas y negras?",
                Arrays.asList("Piano","Guitarra","Violín","Trompeta"),0,1));
        questions.add(new Question("Cultura","Moneda oficial de la Unión Europea:",
                Arrays.asList("Euro","Dólar","Libra","Franco"),0,1));
        questions.add(new Question("Cultura","¿En qué continente está Egipto?",
                Arrays.asList("África","Asia","Europa","Oceanía"),0,1));
        questions.add(new Question("Cultura","¿Qué deporte practica Messi?",
                Arrays.asList("Fútbol","Tenis","Baloncesto","Béisbol"),0,1));
        questions.add(new Question("Cultura","País famoso por el carnaval de Río:",
                Arrays.asList("Brasil","México","Colombia","Argentina"),0,1));
        questions.add(new Question("Cultura","Animal símbolo de la paz:",
                Arrays.asList("Paloma","Águila","León","Tigre"),0,1));
        questions.add(new Question("Cultura","¿Qué país inventó la pizza?",
                Arrays.asList("Italia","Francia","España","Alemania"),0,1));
        questions.add(new Question("Cultura","Idioma oficial de Brasil:",
                Arrays.asList("Portugués","Español","Inglés","Francés"),0,1));
        questions.add(new Question("Cultura","¿Qué color sale de mezclar azul y amarillo?",
                Arrays.asList("Verde","Rojo","Naranja","Morado"),0,1));
        questions.add(new Question("Cultura","Bebida típica del Caribe colombiano:",
                Arrays.asList("Agua de panela","Café","Aguardiente","Vino"),0,1));


        /* ========================================================
         *                    CULTURA — NIVEL 2 (15)
         * ======================================================== */
        questions.add(new Question("Cultura","¿En qué año fue el primer mundial de fútbol?",
                Arrays.asList("1930","1920","1950","1948"),0,2));
        questions.add(new Question("Cultura","¿Quién pintó La noche estrellada?",
                Arrays.asList("Van Gogh","Picasso","Da Vinci","Monet"),0,2));
        questions.add(new Question("Cultura","Obra más famosa de Cervantes:",
                Arrays.asList("Don Quijote","La Galatea","Novelas ejemplares","El Coloquio"),0,2));
        questions.add(new Question("Cultura","¿Quién escribió La República?",
                Arrays.asList("Platón","Aristóteles","Sócrates","Heráclito"),0,2));
        questions.add(new Question("Cultura","Religión predominante en India:",
                Arrays.asList("Hinduismo","Islam","Cristianismo","Budismo"),0,2));
        questions.add(new Question("Cultura","¿Qué instrumento construyó Stradivari?",
                Arrays.asList("Violín Stradivarius","Piano","Arpa","Flauta"),0,2));
        questions.add(new Question("Cultura","Capital de Islandia:",
                Arrays.asList("Reikiavik","Oslo","Copenhague","Helsinki"),0,2));
        questions.add(new Question("Cultura","¿Quién compuso la Novena Sinfonía?",
                Arrays.asList("Beethoven","Mozart","Bach","Schubert"),0,2));
        questions.add(new Question("Cultura","Autor de El Principito:",
                Arrays.asList("Saint-Exupéry","Verne","Lewis","Twain"),0,2));
        questions.add(new Question("Cultura","Capital de Nueva Zelanda:",
                Arrays.asList("Wellington","Auckland","Sydney","Melbourne"),0,2));
        questions.add(new Question("Cultura","¿Dónde nació Frida Kahlo?",
                Arrays.asList("México","Colombia","España","Argentina"),0,2));
        questions.add(new Question("Cultura","Festival famoso por la Palma de Oro:",
                Arrays.asList("Cannes","Venecia","Berlín","Toronto"),0,2));
        questions.add(new Question("Cultura","¿Qué cultura inventó el teatro?",
                Arrays.asList("Grecia","Roma","Egipto","Fenicia"),0,2));
        questions.add(new Question("Cultura","¿Quién escribió Romeo y Julieta?",
                Arrays.asList("Shakespeare","Dickens","Poe","Dante"),0,2));
        questions.add(new Question("Cultura","¿Quién pintó Guernica?",
                Arrays.asList("Picasso","Dalí","Miró","Goya"),0,2));


        /* ========================================================
         *                    CULTURA — NIVEL 3 (15)
         * ======================================================== */
        questions.add(new Question("Cultura","¿Cuál es la obra cumbre de Homero?",
                Arrays.asList("La Ilíada","La Odisea","La Eneida","La República"),0,3));
        questions.add(new Question("Cultura","¿Qué filósofo fue maestro de Alejandro Magno?",
                Arrays.asList("Aristóteles","Platón","Sócrates","Epicuro"),0,3));
        questions.add(new Question("Cultura","¿Qué compositor creó La Flauta Mágica?",
                Arrays.asList("Mozart","Beethoven","Bach","Handel"),0,3));
        questions.add(new Question("Cultura","¿Qué cultura desarrolló el haiku?",
                Arrays.asList("Japonesa","China","Coreana","Vietnamita"),0,3));
        questions.add(new Question("Cultura","¿Cuál es la ópera más famosa de Verdi?",
                Arrays.asList("La Traviata","Aida","Otello","Rigoletto"),0,3));
        questions.add(new Question("Cultura","¿Qué escritor creó 1984?",
                Arrays.asList("George Orwell","Aldous Huxley","Bradbury","Asimov"),0,3));
        questions.add(new Question("Cultura","¿Dónde se originó el ballet clásico?",
                Arrays.asList("Francia","Rusia","Italia","Austria"),0,3));
        questions.add(new Question("Cultura","¿Quién escribió Crimen y castigo?",
                Arrays.asList("Dostoyevski","Tolstói","Gorki","Chejov"),0,3));
        questions.add(new Question("Cultura","¿Qué país creó el origami?",
                Arrays.asList("Japón","China","Tailandia","Corea"),0,3));
        questions.add(new Question("Cultura","¿Quién pintó El grito?",
                Arrays.asList("Edvard Munch","Klimt","Kandinsky","Monet"),0,3));
        questions.add(new Question("Cultura","¿Qué civilización creó las líneas de Nazca?",
                Arrays.asList("Nazca","Inca","Moche","Chimú"),0,3));
        questions.add(new Question("Cultura","¿Quién escribió La metamorfosis?",
                Arrays.asList("Kafka","Camus","Sartre","Hesse"),0,3));
        questions.add(new Question("Cultura","¿Qué novelista escribió Los miserables?",
                Arrays.asList("Victor Hugo","Balzac","Stendhal","Flaubert"),0,3));
        questions.add(new Question("Cultura","¿Qué cultura creó la porcelana?",
                Arrays.asList("China","Japón","Corea","Vietnam"),0,3));
        questions.add(new Question("Cultura","¿Qué arquitecto diseñó la Sagrada Familia?",
                Arrays.asList("Gaudí","Calatrava","Mies van der Rohe","Le Corbusier"),0,3));
    }


    /** Obtiene N preguntas aleatorias de una categoría y nivel. */
    public List<Question> getRandomQuestions(String category, int level, int n) {
        List<Question> filtered = questions.stream()
                .filter(q -> q.getCategory().equalsIgnoreCase(category) && q.getLevel() == level)
                .collect(Collectors.toList());

        Collections.shuffle(filtered, rnd);
        if (filtered.size() <= n) return new ArrayList<>(filtered);
        return filtered.subList(0, n);
    }

    /** Mezcla preguntas si faltan del nivel solicitado */
    public List<Question> getRandomQuestionsFallback(String category, int level, int n) {
        List<Question> pick = getRandomQuestions(category, level, n);

        if (pick.size() < n) {
            List<Question> other = questions.stream()
                    .filter(q -> q.getCategory().equalsIgnoreCase(category) && q.getLevel() != level)
                    .collect(Collectors.toList());

            Collections.shuffle(other, rnd);

            for (Question q : other) {
                if (pick.size() >= n) break;
                pick.add(q);
            }
        }
        return pick;
    }
}
