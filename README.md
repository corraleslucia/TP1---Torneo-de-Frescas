1) MAVEN:
Es una herramienta que se utiliza en la gestión y construcción de un software.
Posee la capacidad de realizar ciertas tareas definidas, como la compilación del código 
y su empaquetado. Es decir, hace posible la creación de software con dependencias incluidas 
dentro de la estructura del JAR.
Es necesario definir todas las dependencias del proyecto (librerías externas utilizadas) 
en un fichero propio de todo proyecto Maven, el POM.
La característica más importante de MAVEN es su capacidad de trabajar en red. Cuando definimos 
las dependencias, este sistema se encargará de ubicar las librerías que deseamos utilizar en 
Maven Central, el cual es un repositorio que contiene cientos de librerías actualizadas por 
sus creadores.

2) POM:
Sus siglas significan Proyect Object Model. Es un fichero en formato XML que contiene todo lo 
necesario para que a la hora de generar el fichero ejecutable de nuestra aplicación, este 
contenga todo lo que necesita para su ejecución en su interior.
Los POMs pueden heredar deotro POM que se defina como parent. La raiz implícita desde donde 
heredan todos los POMs es el Super POM definido por MAVEN. El POM resultante luego de incorporar
todos los ancestros se llama Effective POM. 

3) ARCHETYPE Y ARTIFACTID:
El Artifact es la unidad mínima que maneja en su repositorio. Cuando MAVEN compila y empaqueta
código, produce también artifacts que instala en el repositorio. Estos estan agrupados bajo 
el id de grupo (GroupId) y tienen un id propio (ArtifactId), una versión, un clasificador y
una extensión. Para administrar artefactos en el repositorio MAVEN los acompaña con un
respectivo pom.xml conteniendo los datos anteriores.
El Archetype es una especie de planilla que se utiliza para generar la estructura y configuración
inicial de un proyecto, dado que la descripción y administración de un proyecto con MAVEN
requiere que el mismo tenga una estructura determinada con los pom.xml correspondientes.
Para esto,MAVEN cuanta con un plugin que permite la generación a partir de arquetipos, el cual
tambien se llama Archetype. Cada arquetipo consta de un directorio Resourses que contiene
todos los archivos y directorios que contendrá el proyecto generado y un descriptor (el xml).
Así, la diferencia entre uno y otro radica en que el artifact es la salida de un build, lo que
el build crea, como así tambien inputs para un build, pudiendo ser un módulo del cual dependa
otro módulo (si un módulo A depende de un módulo B, módulo A necesitará los artifacts del
módulo B), mientras que el archetype es un build que genera un proyecto basado en una planilla, 
creado para hacer más facil los builds.

4) MAVEN GOALS:
Los goals de Maven son las unidades mínimas de ejecución de las que disponemos durante su uso.
Un grupo de goals conforman un plugin. La ejecución de un goal se dispara desde línea de comandos
invocando Maven con el nombre del plugin que lo contiene: mvn plugin:goal
Otra forma de invocar un goal es indirectamente declarando por ejemplo, el uso de un plugin en
un POM. Maven lo invocará dependiendo de la fase del ciclo de vida cuando por ejemplo se
ejecute mvn compile.

- Clean: remueve todos los archivos generados en el build anterior.
- Package: toma el código compilado y lo empaqueta en su formato distribuible, por ejemplo JAR.
- Install: instala el paquete en el repositorio local, para usarlo como una dependencia en otros
proyectos locales.
- Compile: compila el codigo fuente del proyecto.

5) MAVEN SCOPES:
Los scopes sirven para indicar el alcance de nuestra dependecia y su transitividad.

- Compile: es el que tenemos por defecto si no se especifica el scope. Indica que la dependencia
es necesaria para compilar. La dependencia además se propaga en los proyectos dependientes.
- Provide: Es como el anterior, pero indica que se espera que el JDK o un contenedor provee la
dependencia en runtime. 
- Runtime: este scope indica que la dependencia no es requerida para la complicación, pero si
para la ejecución.
- Test: ete scope indica que la dependencia no es requerida para uso normal de la aplicación,
y esta sólo disponible para las fases de compilación de los codigos fuentes de testeo y ejecución.
- System:Es similar al de Provide exceptuando que uno debe proveer el JAR explicitamente
que lo contiene. El artefacto está siempre disponible y no se lo va a buscar al repositorio.
