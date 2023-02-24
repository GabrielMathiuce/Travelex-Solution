** Resolucao exercicio proposto - Travelex  **

Boa tarde á todos, segundo o exercicio proposto, expus um serviço REST que recebe dois parametros, peso e altura, e devolve o calculo do IMC e sua faixa de peso.
Também foram implementadas as seguintes logicas: 

- Nome não pode ser nulo
- Nome não pode ser vazio
- Nome não pode conter espaços extras no início e no fim
- Deve ser possível obter o primeiro nome. Exemplo: Se o nome for "João Soares Silva", deve retornar "João".
- Retornar o último nome. Exemplo: Se o nome for "João Soares Silva", deve retornar "Soares Silva".
- Retornar o nome todo em letras maiúsculas.
- Retornar o nome abreviado. Exemplo: Se o nome for "João Soares Silva", retornar "João S. Silva".

Para isto, criei uma classe abstrata chamada ExchangeEntity, na qual se concentram os metodos getters e setters necessarios para tal, assim como seu construtor.
As classes  Cliente, Gerente e Robo herdam da classe ExchangeEntity.

Implementei testes no path padrao (src/test/java/com/travelex/resolucao/ResolucaoApplicationTests.java) e todos foram sucedidos.

Para rodar o programa:

  -Caso tenha Docker instalado na maquina, existem duas abordagens:
     - docker compose up
     - dentro da pasta raiz do projeto -> docker build . -> docker images (pegar id da image) -> docker run -p 8080:8080 (ou porta desejada) "idCapturadaNoComandoAnterior"
     
  -Caso nao tenha o docker, é possivel rodar o programa no terminal, dentro da pasta raiz do programa, atraves da seguinte linha de comando: mvn spring-boot:run
  
Acessando o endereco da aplicacao, ex: http://localhost:8080/swagger-ui.html, é possivel verificar o Swagger dos endpoints da aplicacao.

Grato pela atencao e tempo dos senhores.
