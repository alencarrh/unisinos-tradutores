# Tradutores - Trabalho 2 - ANTLR

#### Autores: Alencar Rodrigo Hentges e Christian de Mello Lima.

## São pré-requisitos deste projeto:
* **Maven 3** *[como instalar](https://www.mkyong.com/maven/how-to-install-maven-in-windows/)*
* **Java 8**
* **[Lombok](https://projectlombok.org/)** Habilitado na sua IDE (*se utilizar uma IDE*)

### Setup inicial
```
git clone https://github.com/alencarrh/Tradutores
cd Tradutores/trabalhos/trabalho2/antlr-trabalho2
```

### Build
```
mvn clean install
```

### Executar

```
$ java -jar target/antlr-trabalho2-1.0-spring-boot.jar "./src/main/java/unisinos/tradutores/antlr/main/TesteClass.java"
Resultados:
-> Método: method1
        -> Complexidade Ciclomática: 7
        -> Fanout: 9
        -> Aninhamento: 2
-> Método: method2
        -> Complexidade Ciclomática: 10
        -> Fanout: 3
        -> Aninhamento: 7
-> Método: X
        -> Complexidade Ciclomática: 3
        -> Fanout: 0
        -> Aninhamento: 1
-> Método: Y
        -> Complexidade Ciclomática: 1
        -> Fanout: 0
        -> Aninhamento: 1
-> Método: Z
        -> Complexidade Ciclomática: 1
        -> Fanout: 0
        -> Aninhamento: 1
```
