1) MAVEN:
Es una herramienta que se utiliza en la gesti�n y construcci�n de un software.
Posee la capacidad de realizar ciertas tareas definidas, como la compilaci�n del c�digo 
y su empaquetado. Es decir, hace posible la creaci�n de software con dependencias incluidas 
dentro de la estructura del JAR.
Es necesario definir todas las dependencias del proyecto (librer�as externas utilizadas) 
en un fichero propio de todo proyecto Maven, el POM.
La caracter�stica m�s importante de MAVEN es su capacidad de trabajar en red. Cuando definimos 
las dependencias, este sistema se encargar� de ubicar las librer�as que deseamos utilizar en 
Maven Central, el cual es un repositorio que contiene cientos de librer�as actualizadas por 
sus creadores.

2) POM:
Sus siglas significan Proyect Object Model. Es un fichero en formato XML que contiene todo lo 
necesario para que a la hora de generar el fichero ejecutable de nuestra aplicaci�n, este 
contenga todo lo que necesita para su ejecuci�n en su interior.
Los POMs pueden heredar deotro POM que se defina como parent. La raiz impl�cita desde donde 
heredan todos los POMs es el Super POM definido por MAVEN. El POM resultante luego de incorporar
todos los ancestros se llama Effective POM. 

3) ARCHETYPE Y ARTIFACTID:
El Artifact es la unidad m�nima que maneja en su repositorio. Cuando MAVEN compila y empaqueta
c�digo, produce tambi�n artifacts que instala en el repositorio. Estos estan agrupados bajo 
el id de grupo (GroupId) y tienen un id propio (ArtifactId), una versi�n, un clasificador y
una extensi�n. Para administrar artefactos en el repositorio MAVEN los acompa�a con un
respectivo pom.xml conteniendo los datos anteriores.
El Archetype es una especie de planilla que se utiliza para generar la estructura y configuraci�n
inicial de un proyecto, dado que la descripci�n y administraci�n de un proyecto con MAVEN
requiere que el mismo tenga una estructura determinada con los pom.xml correspondientes.
Para esto,MAVEN cuanta con un plugin que permite la generaci�n a partir de arquetipos, el cual
tambien se llama Archetype. Cada arquetipo consta de un directorio Resourses que contiene
todos los archivos y directorios que contendr� el proyecto generado y un descriptor (el xml).
As�, la diferencia entre uno y otro radica en que el artifact es la salida de un build, lo que
el build crea, como as� tambien inputs para un build, pudiendo ser un m�dulo del cual dependa
otro m�dulo (si un m�dulo A depende de un m�dulo B, m�dulo A necesitar� los artifacts del
m�dulo B), mientras que el archetype es un build que genera un proyecto basado en una planilla, 
creado para hacer m�s facil los builds.

4) MAVEN GOALS:
Los goals de Maven son las unidades m�nimas de ejecuci�n de las que disponemos durante su uso.
Un grupo de goals conforman un plugin. La ejecuci�n de un goal se dispara desde l�nea de comandos
invocando Maven con el nombre del plugin que lo contiene: mvn plugin:goal
Otra forma de invocar un goal es indirectamente declarando por ejemplo, el uso de un plugin en
un POM. Maven lo invocar� dependiendo de la fase del ciclo de vida cuando por ejemplo se
ejecute mvn compile.

- Clean: remueve todos los archivos generados en el build anterior.
- Package: toma el c�digo compilado y lo empaqueta en su formato distribuible, por ejemplo JAR.
- Install: instala el paquete en el repositorio local, para usarlo como una dependencia en otros
proyectos locales.
- Compile: compila el codigo fuente del proyecto.

5) MAVEN SCOPES:
Los scopes sirven para indicar el alcance de nuestra dependecia y su transitividad.

- Compile: es el que tenemos por defecto si no se especifica el scope. Indica que la dependencia
es necesaria para compilar. La dependencia adem�s se propaga en los proyectos dependientes.
- Provide: Es como el anterior, pero indica que se espera que el JDK o un contenedor provee la
dependencia en runtime. 
- Runtime: este scope indica que la dependencia no es requerida para la complicaci�n, pero si
para la ejecuci�n.
- Test: ete scope indica que la dependencia no es requerida para uso normal de la aplicaci�n,
y esta s�lo disponible para las fases de compilaci�n de los codigos fuentes de testeo y ejecuci�n.
- System:Es similar al de Provide exceptuando que uno debe proveer el JAR explicitamente
que lo contiene. El artefacto est� siempre disponible y no se lo va a buscar al repositorio.
