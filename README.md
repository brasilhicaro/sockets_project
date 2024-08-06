# Documentação

## Contexto Geral

Projeto proposto na disciplina de Sistemas Distribuídos, basea-se na arquitetura cliente/servidor com o auxilio de sockets em Java.
O Cliente é responsável para fazer a solicitação de mensagens específicas ou aleatórias do servidor.

## Funcionalidades

### Infra

*MessageHandler* : Responsável pela manipulação das mensagens recebidas e enviadas pelo servidowr. Ele processa as solicitações do cliente e retorna as respostas apropriadas.

*Server* : Responsável por aceitar conexões de clientes e delegar as solicitações para o `MessageHandler`.

*Client* : Responsável por enviar solicitações ao servidor e processar as respostas recebidas.

### Funcionalidades do Cliente

- Enviar solicitação de mensagem específica.
- Enviar solicitação de mensagem aleatória.
- Receber e exibir a mensagem do servidor.

### Funcionalidades do Servidor

- Aceitar conexões de múltiplos clientes.
- Processar solicitações de mensagens específicas.
- Processar solicitações de mensagens aleatórias.
- Enviar respostas apropriadas aos clientes.

## Como Executar

### Requisitos

- Java 8 ou superior

### Passos

1. Clone o repositório:
    ```sh
    git clone <URL_DO_REPOSITORIO>
    ```
2. Navegue até o diretório do projeto:
    ```sh
    cd <DIRETORIO_DO_PROJETO>
    ```
3. Compile o projeto usando Maven:
    ```sh
    mvn clean install
    ```
4. Execute o servidor:
    ```sh
    java -cp target/<NOME_DO_JAR>.jar com.exemplo.Server
    ```
5. Em outra janela do terminal, execute o cliente:
    ```sh
    java -cp target/<NOME_DO_JAR>.jar com.exemplo.Client
    ```

Substitua `<URL_DO_REPOSITORIO>` e `<NOME_DO_JAR>` pelos valores apropriados.

## Estrutura do Projeto

- `src/main/java/com/exemplo/` : Contém os arquivos fonte do projeto.
- `src/test/java/com/exemplo/` : Contém os testes unitários do projeto.

## Contribuição

1. Faça um fork do projeto.
2. Crie uma nova branch para sua feature ou correção:
    ```sh
    git checkout -b minha-feature
    ```
3. Faça commit das suas alterações:
    ```sh
    git commit -m 'Minha nova feature'
    ```
4. Envie para o repositório remoto:
    ```sh
    git push origin minha-feature
    ```
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.