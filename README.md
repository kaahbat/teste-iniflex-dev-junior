# Teste Prático - Iniflex / Projedata

Projeto desenvolvido como parte do processo seletivo para a vaga de Desenvolvedor de Software Júnior. O sistema gerencia uma lista de funcionários, aplicando uma série de regras de negócio, cálculos e relatórios conforme especificado no teste.

## Tecnologias Utilizadas
* **Java 17** (ou a versão que você usou)
* **Maven** para gerenciamento de dependências e build.
* **Git** para versionamento de código.

## Pré-requisitos
Para compilar e executar este projeto, você precisará ter instalado:
* JDK 17+
* Apache Maven 3.8+

## Como Executar o Projeto

Siga os passos abaixo para executar a aplicação via terminal:

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/kaahbat/teste-iniflex-dev-junior
    ```

2.  **Navegue até a pasta do projeto:**
    ```bash
    cd teste-pratico-iniflex
    ```

3.  **Compile o projeto com o Maven:**
    ```bash
    mvn compile
    ```

4.  **Execute a classe principal:**
    ```bash
    mvn exec:java -Dexec.mainClass="br.com.projedata.main.Main"
    ```
A saída completa do programa, com todos os relatórios solicitados, será exibida no console.

## Estrutura e Decisões de Design
O projeto foi desenvolvido com foco em boas práticas de programação e princípios de design de software, visando um código limpo, organizado e de fácil manutenção.

* **Separação de Responsabilidades (SOLID):** A arquitetura foi dividida em três camadas distintas para separar as responsabilidades:
    * **Model (`br.com.projedata.model`):** Classes que representam as entidades de dados da aplicação (`Person`, `Employee`).
    * **Service (`br.com.projedata.service`):** Classes que contêm a lógica de negócio e as operações sobre os dados (`EmployeeService`).
    * **Apresentação (`br.com.projedata.main`):** A classe `Main` atua como orquestradora e camada de apresentação, responsável por iniciar a aplicação e exibir os resultados no console.

* **Código Limpo (Clean Code):** Foi adotado o padrão de "main limpo", onde a lógica de apresentação complexa foi extraída para métodos auxiliares privados, tornando o fluxo de execução principal legível e conciso.

* **Versionamento com Git:** O desenvolvimento foi versionado com commits atômicos e mensagens seguindo o padrão *Conventional Commits* (`feat:`, `refactor:`, `docs:`, `fix`).


* **LinkedIn:** https://www.linkedin.com/in/carlos-n22/
