# projetoGerenFut - Back-end.
Projeto para gerenciamento e analise de dados estatisticos de futebol.


Fases do projeto:

1ª Fase: Modelagem do sistema
    - A ideia do projeto é realizar análise estatísticas com dados do futebol brasileiro.
    A partir desses dádos estatísticos será possível inferir alguns dados e fazer algumas
    conclusões a respeito dos times.
    - As conclusões e os dados a serem inferidos serão planejados ao longo da criação do projeto,
    tendo em vista que cada informação inferida vai depender das possíveis situações e tecnologias
    que serão utilizadas no projeto, como, por exemplo, utilização de APIs externas e alimentações
    (manuais ou automáticas) de dados externos.
    - Objetivo central (de longo prazo): Determinar se os times de futebol estão realizando bons
    investimentos em seus jogadores, se esses jogadores realmente refletem o valor de mercado e
    etc...

2ª Fase: Estruturação do Back-end
    - Criação das tabelas no banco de dados;
    - Criação dos pacotes com as classes (divididas de forma organizada pelo padrão de projeto adotado);
    - Criação dos serviços e dos métodos responsáveis pela realização correta desse serviço;
    - Alimentar as tabelas do banco de dados. Esse processo pode ocorrer por um processo manual (não recomendado),
    por um processo automático (pouco recomendado) de leitura de arquivo (populado manualmente por mim) ou
    por meio de alguma API que possua informações que desejamos (recomendado);
    - Utilizar a API https://www.api-futebol.com.br/ para alimentar os dados que serão úteis.
    
3ª Fase: Estruturação do Front-end
    - De forma geral: Criação de um site que seja possível visualizar a informações do futebol brasileiro;
    - Em relação as informações citadas anteriormente, alguns exemplos são: Informações sobre os times,
    sobre os jogadores, sobre o campeonato brasileiro (tabela), dados que serão concluídos e inferidos
    pelo Back-end e etc.
    
4ª Fase: Atualizações pontuais (e manutenção) do projeto
    - Pesquisar por mais fontes de informações para alimentar o sistema. Exemplo: Utilização de crawlers para
    buscar informações na internet (não precisando buscar informações diretamente de uma API).
    - Atualizar os padrões de projeto e desenvolvimento ao longo do tempo, de forma a deixar o projeto com
    tecnologias atuais.
    
Observações do projeto:
    - As fases do projeto podem ser desenvolvidas paralelamente, menos a 4ª Fase
    (que corresponde à fase de manutenção e atualização do sistema).
    - Projeto criado, inicialmente, com o intuito de estudar e me atualizar com as novas tecnologias
    de desenvolvimento de web services.
    - Tecnologias utilizadas no projeto até agora:
        - Servidor Tomcat V9.0;
        - Controle de dependências com Maven;
        - Jersey RESTful web service (JAX-RS annotations);
        - Hibernate para acesso ao banco;
        - JPA annotations;
        - Git;
        - Banco de dados relacional postgresql;
    
    
    
    
    
    
    
    
    
    
    
    
