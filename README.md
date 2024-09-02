# Primeiros socorros App

 Um aplicativo que tem como objeticvo auxiliar as pessoas em como lidar em situações de emergência, possuindo uma lista de ocorrência e como agir nas situações.
 
# Estrutura
 
 Projeto desenvolvimento em Kotlin e Jetpack Compose, utilizando boas práticas baseadas no Clean Code, onde a arquitetura tem os conceitos do Clean Architecture. Ainda para manter uma organização maior na camada de apresentação fez se uso de MVVM.
 Todos os dados estão armazenados no Cloud Firestore do Firebase.
 O possui apenas dois módulos, designsystem e app, porém o app possui uma organização por pacotes onde devem trabalhar isolados, onde dentro de cada pacote possui uma organização por feature
 
 - design system: possui todos os componentes, configurações, temas necessários para construção visual;
 - app: módulo com toda a aplicação em si, onde esta divido nos seguintes pacotes;
   - common: objetos e classes comuns entre todos os pacotes;
   - data: pacote com toda a estrutura para comunicação com servidor externos;
   - domain: responsável pelas regras de negócio quando necessário e a conversão dos objetos do pacote de data para objetos internos do app;
   - presentation: possui a construção das telas para interação com o cliente;

 Composição do app, passa por uma estrutura de Navigation com uso fragment, sendo todo o layout feito em Compose, para injeção de dependência foi utilizado Koin, nos testes unitários foi utilizado o mockk para mockar os objetos.

# Melhorias
 - Migrar o app para multi-modulos por features
 - Construir teste automatizados
 - Migrar a navegação para estrutura de apenas um fragment fazendo alteração apenas das screen em compose
 - Melhorar o layout da aplicação

# Documentação
 Temos a [documentação](https://docs.google.com/document/d/1Iwo14pdTEtzIPVLrcgqRczlTHQbMdlukPpfVfOm00P8/edit) da idealização do projeto, com os conceitos e funcionalidades pensadas, juntamente com breve road map e para acompanhar a evolução temos o [board](https://trello.com/b/rwpTPYdx/projeto-primeiros-socorros)