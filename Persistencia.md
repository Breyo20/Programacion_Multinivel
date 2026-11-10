# Tema 1 · El patrón Repository

## 1. ¿Qué es el patrón Repository (o DAO) y qué problema resuelve?
### El patrón Repository es una forma de organizar el código para separar las operaciones de almacenamiento de información de las demás funciones del programa. Se encarga de consultar, guardar, actualizar y eliminar datos sin que otras partes del sistema tengan que conocer cómo funciona la base de datos. En el RPG Manager, por ejemplo, PersonajeRepository se encargaría de guardar y recuperar los personajes y sus inventarios. Esto facilita los cambios y evita repetir código de consultas.

## 2. ¿Qué diferencia hay entre la capa de negocio (Service) y la capa de datos (Repository)? Den un ejemplo con una regla del RPG Manager.

### La capa Service se encarga de controlar las reglas y condiciones que debe cumplir el juego, mientras que Repository se ocupa de guardar y consultar la información. Por ejemplo, si un Guerrero intenta equipar un arma que no corresponde a su clase, GuerreroService verifica si puede utilizarla y permite o rechaza la operación. Después, InventarioRepository se encarga de guardar los cambios realizados en el inventario.

## 3. ¿Por qué se dice que un Repository no debe validar reglas de negocio?

### Porque su responsabilidad es manejar los datos y no decidir cómo deben funcionar las reglas del juego. Si Repository también validara esas condiciones, terminaría mezclando responsabilidades y sería más difícil modificar o mantener el programa. Por ejemplo, PersonajeRepository puede guardar un Mago, pero quien debe comprobar si tiene el nivel necesario para aprender un hechizo es MagoService.


# Tema 2 · Contratos en Java y Python

## 1. ¿Qué es una interface en Java? ¿Qué pasa si una clase que la implementa olvida un método?

### Una interface en Java es como un contrato que establece qué métodos debe tener una clase, pero normalmente no indica cómo deben funcionar. Cuando una clase utiliza implements, se compromete a implementar los métodos que exige esa interfaz. Por ejemplo, si existe una interfaz Atacable, las clases Guerrero, Mago y Arquero deben implementar el método atacar(). Si una clase olvida implementar un método obligatorio, Java genera un error de compilación, a menos que la clase también sea abstracta.

## 2. ¿Qué es una clase abstracta con ABC y @abstractmethod en Python? ¿Qué pasa si intentan crear un objeto de esa clase?

### En Python, ABC permite crear clases abstractas que sirven como base para otras clases, mientras que @abstractmethod indica qué métodos deben implementar sus clases hijas. Por ejemplo, podemos crear una clase abstracta Personaje que exija un método atacar() para los tipos de personajes del RPG Manager. Si intentamos crear directamente un objeto de Personaje sin implementar sus métodos abstractos, Python genera un error y no permite hacerlo.

## 3. ¿En qué se parecen y en qué se diferencian las dos formas?

### Las dos formas permiten establecer un contrato para que varias clases cumplan con ciertos métodos obligatorios. La diferencia es que Java utiliza interface y comprueba que se cumpla el contrato durante la compilación, mientras que Python utiliza clases abstractas con ABC y @abstractmethod, comprobándolo cuando se intenta crear un objeto. Ambas ayudan a mantener un código organizado y a que clases como Guerrero, Mago y Arquero compartan comportamientos definidos.


# Tema 3 · Inyección de dependencias por constructor

## 1. ¿Qué significa "programar contra una interfaz y no contra una implementación"?

### Significa que una clase debe depender de lo que otra clase puede hacer, y no de cómo está construida internamente. Por ejemplo, PersonajeService puede trabajar con una interfaz llamada PersonajeRepository, sin importar si los datos se guardan en MariaDB, MongoDB o en otro sistema. Así, podemos cambiar la forma de almacenar los personajes sin tener que modificar toda la lógica del juego.

## 2. ¿Qué es la inyección de dependencias por constructor? Explíquenlo con un PersonajeService que necesita guardar personajes.

### Es una forma de entregar a una clase los objetos que necesita mediante su constructor, en lugar de crearlos directamente dentro de ella. Por ejemplo, PersonajeService necesita un PersonajeRepository para guardar los personajes del RPG Manager. Al crear el servicio, se le entrega un repositorio como argumento y así puede utilizarlo para almacenar los datos de Guerreros, Magos y Arqueros.

## 3. ¿Qué ventaja tiene que el Service reciba el repositorio en vez de crearlo él mismo?

### La principal ventaja es que el servicio no queda dependiendo de una implementación específica del repositorio. Por ejemplo, PersonajeService puede recibir un repositorio que guarde los personajes en MariaDB y, si después queremos utilizar MongoDB, podemos cambiarlo sin modificar la lógica del servicio. Además, facilita realizar pruebas y mantener el código, porque podemos utilizar diferentes repositorios según lo que necesitemos.


# Tema 4 · Configuración y secretos

## 1. ¿Cómo se lee un archivo .properties en Java y un archivo .ini en Python? Nombren la clase o el módulo que se usa.

### En Java, los archivos .properties se pueden leer utilizando la clase Properties, que permite obtener valores guardados en forma de clave y valor. En Python, los archivos .ini se leen con el módulo configparser, que permite organizar la configuración por secciones. Por ejemplo, en el RPG Manager podemos guardar allí el nombre de la base de datos, el servidor y otros datos de conexión, evitando escribir esa configuración directamente en el código.

## 2. ¿Para qué sirve .gitignore y qué pasa si un archivo ya se subió antes de ignorarlo?

### El archivo .gitignore sirve para indicarle a Git qué archivos o carpetas no debe incluir en el repositorio, como archivos de configuración que contienen contraseñas o claves de acceso. Si un archivo ya fue subido, agregarlo a .gitignore no lo elimina ni deja de rastrearlo automáticamente. Para dejar de rastrearlo se puede utilizar git rm --cached nombre_archivo, pero si contenía una contraseña que ya fue publicada, también es necesario cambiarla porque pudo haber sido vista por otras personas.

## 3. Busquen un caso real de contraseñas o llaves filtradas en GitHub: ¿qué pasó y qué consecuencias tuvo?

### Un caso real ocurrió con Uber en 2016, cuando unos atacantes encontraron credenciales de acceso a AWS dentro de un repositorio privado de GitHub. Con esas credenciales lograron acceder a copias de información de aproximadamente 57 millones de usuarios y conductores. Entre los datos expuestos había nombres, correos, teléfonos y licencias de conducción. Uber terminó pagando 100.000 dólares a los atacantes y recibió críticas por no informar del incidente oportunamente. 
National Security Archive+1


# Tema 5 · MariaDB desde el código

## 1. ¿Qué es JDBC y qué hace un driver? ¿Qué librería cumple ese papel en Python para MariaDB?

### JDBC es una herramienta de Java que permite conectar los programas con bases de datos y ejecutar consultas SQL. Para funcionar necesita un driver, que actúa como intermediario entre Java y la base de datos, traduciendo las instrucciones para que puedan comunicarse. En Python se puede utilizar la librería PyMySQL, que permite conectarse a MariaDB y realizar operaciones como guardar, consultar o actualizar personajes del RPG Manager.

## 2. ¿Qué es la inyección SQL? Muestren un ejemplo con el nombre de un personaje y expliquen por qué PreparedStatement (Java) o los parámetros %s (Python) la evitan.

### La inyección SQL es un ataque en el que alguien introduce instrucciones SQL dentro de un dato para intentar modificar una consulta o acceder a información sin autorización. Por ejemplo, si el RPG Manager busca un personaje llamado Guerrero, una consulta construida uniendo directamente el texto ingresado podría ser manipulada. Para evitarlo, Java utiliza PreparedStatement y Python utiliza parámetros %s, porque separan los datos de las instrucciones SQL y evitan que el nombre del personaje se interprete como código.

### Ejemplo en Python:
### cursor.execute(    "SELECT * FROM personajes WHERE nombre = %s",    ("Guerrero",))

## 3. ¿Qué es una transacción y qué hace commit()? ¿Qué pasa en PyMySQL si no se llama?

### Una transacción es un conjunto de operaciones que se ejecutan como una sola unidad, buscando que los cambios se realicen correctamente. En el RPG Manager, por ejemplo, al comprar un objeto se puede descontar el oro del personaje y agregar el objeto a su inventario dentro de una misma transacción. El método commit() confirma y guarda los cambios en la base de datos. Si en PyMySQL no se llama a commit(), los cambios pendientes normalmente no quedan guardados y pueden perderse cuando se cierra la conexión.

## 4. ¿Por qué hay que cerrar las conexiones? ¿Qué es try-with-resources en Java y with en Python?

### Las conexiones deben cerrarse porque utilizan recursos del sistema y de la base de datos, y mantenerlas abiertas sin necesidad puede provocar problemas o impedir que otros procesos se conecten. En Java, try-with-resources permite cerrar automáticamente recursos como conexiones y consultas cuando termina el bloque de código. En Python, with permite administrar recursos mediante un administrador de contexto, facilitando su liberación incluso cuando ocurre un error. En el RPG Manager esto ayuda a evitar conexiones abiertas después de guardar o consultar personajes.


## Tema 6 · MongoDB desde el código

## 1. ¿Qué es un ObjectId y qué información guarda por dentro?

### Un ObjectId es un identificador único que MongoDB utiliza normalmente para distinguir cada documento dentro de una colección. Está formado por 12 bytes que contienen tres partes: una marca de tiempo de 4 bytes, un valor aleatorio de 5 bytes y un contador de 3 bytes. Por ejemplo, en el RPG Manager, cada personaje puede tener su propio ObjectId para diferenciarlo de los demás. 

## 2. ¿En qué se parece un documento de MongoDB a un HashMap de Java o a un dict de Python?

### Se parecen porque los tres permiten almacenar información mediante pares de clave y valor. En MongoDB, un documento puede guardar datos de un personaje como su nombre, nivel, clase y habilidades. De forma similar, en Python se podría representar con un dict y en Java con un HashMap. La diferencia es que MongoDB almacena esos documentos de forma persistente en una base de datos, mientras que un diccionario o un HashMap normalmente se utilizan dentro del programa.

### Ejemplo de un documento del RPG Manager:
### {
###  "nombre": "Arthas",
###  "clase": "Guerrero",
###  "nivel": 15,
###  "inventario": ["Espada", "Escudo"]
### }

## 3. ¿Qué diferencia hay entre MongoDB local, MongoDB Atlas y mongoplayground.net? ¿Cuál de los tres puede usar un programa en Java o Python?
 
### MongoDB local es una base de datos instalada y ejecutada directamente en nuestro computador. MongoDB Atlas es un servicio en la nube que permite crear y administrar bases de datos sin tener que mantener un servidor propio. Por otro lado, Mongo Playground es una herramienta en línea para probar consultas y operaciones de MongoDB, pero no funciona como un servidor de base de datos para conectar directamente una aplicación. Un programa en Java o Python puede conectarse a MongoDB local o Atlas utilizando sus respectivos drivers, como MongoDB Java Driver o PyMongo.

# Tema 7 · ORM

## 1. ¿Qué es un ORM?

### Un ORM es una herramienta que permite trabajar con una base de datos utilizando objetos y clases del lenguaje de programación, en lugar de escribir todas las consultas SQL manualmente. Se encarga de relacionar las clases del programa con las tablas de la base de datos. Por ejemplo, en el RPG Manager podemos tener una clase Personaje y utilizar el ORM para guardar sus datos en una tabla sin escribir manualmente cada instrucción SQL.

## 2. Nombren uno de Java y uno de Python.

### En Java uno de los ORM más conocidos es Hibernate, que permite relacionar las clases y objetos del programa con las tablas de una base de datos. En Python se encuentra SQLAlchemy, que permite trabajar con modelos y realizar operaciones sobre la base de datos. Ambos facilitan el almacenamiento y la consulta de información del RPG Manager, como personajes, niveles e inventarios. 

## 3. Den una ventaja y una desventaja de usar un ORM en lugar de escribir el SQL a mano.

### Una ventaja de utilizar un ORM es que permite trabajar con objetos y reduce la cantidad de consultas SQL que debemos escribir manualmente, haciendo que el código sea más fácil de organizar y mantener. Por ejemplo, podemos guardar un Guerrero utilizando su objeto Personaje sin construir toda la consulta SQL. Una desventaja es que puede generar consultas menos eficientes o difíciles de optimizar si no conocemos cómo funciona internamente, por lo que en algunos casos es mejor escribir el SQL directamente.

# Bibliografia
   
1. Repository Pattern. Martin Fowler. Disponible en https://martinfowler.com/eaaCatalog/repository.html
2. Data Access Object. Oracle. Disponible en https://www.oracle.com/java/technologies/data-access-object.html
3. Defining an Interface in Java. Oracle. Disponible en https://docs.oracle.com/javase/tutorial/java/IandI/interfaceDef.html
4. Abstract Base Classes. Python. Disponible en https://docs.python.org/3/library/abc.html
5. Dependency Injection. Spring Framework. Disponible en https://docs.spring.io/spring-framework/reference/core/beans/dependencies/factory-collaborators.html
6. Inversion of Control Containers and the Dependency Injection Pattern. Martin Fowler. Disponible en https://martinfowler.com/articles/injection.html
7. Class Properties. Oracle. Disponible en https://docs.oracle.com/en/java/javase/26/docs/api/java.base/java/util/Properties.html
8. ConfigParser — Configuration file parser. Python. Disponible en https://docs.python.org/3/library/configparser.html
9. Gitignore Documentation. Git. Disponible en https://git-scm.com/docs/gitignore
10. FTC Addresses Uber's Undisclosed Data Breach. Federal Trade Commission. Disponible en https://www.ftc.gov/business-guidance/blog/2018/04/ftc-addresses-ubers-undisclosed-data-breach-new-proposed-order
11. JDBC Database Access. Oracle. Disponible en https://docs.oracle.com/javase/tutorial/jdbc/
12. Using Prepared Statements. Oracle. Disponible en https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
13. MariaDB Connector/Python. MariaDB. Disponible en https://mariadb.com/docs/connectors/mariadb-connector-python/
14. PyMySQL Documentation. PyMySQL. Disponible en https://pymysql.readthedocs.io/en/latest/
Tema 6 · MongoDB desde el código
14. BSON Types: ObjectId. MongoDB. Disponible en https://www.mongodb.com/docs/manual/reference/bson-types/#objectid
