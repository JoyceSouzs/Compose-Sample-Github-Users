# Compose Sample Github Users

Compose Sample Github Users é uma aplicação Android para fins de estudos, desenvolvido com Jetpack Compose, apresentando uma interface de usuário que exive uma lista pública de usuários do GitHub.  
Ele se conecta com a api [GITHUB](https://api.github.com/) para acesso ao conteúdo.

## Tecnologias e Bibliotecas Utilizadas
- [Jetpack Compose](https://developer.android.com/jetpack/compose): Kit de ferramentas de UI moderno para criar UIs nativas do Android
- [Koin](https://github.com/InsertKoinIO/koin) - Estrutura pragmática e leve de injeção de dependência
- [Coroutines](https://developer.android.com/kotlin/coroutines): Para programação assíncrona
- [Retrofit](https://square.github.io/retrofit/): Para fazer solicitações de rede
- [Coil](https://coil-kt.github.io/coil/compose/): Para carregamento e cache de imagens

### Características dos pacotes
- App: Contém tudo o que é necessário para que o aplicativo funcione corretamente, como estrutura e navegação da IU.
- Core: Contém bibliotecas comuns contendo código auxiliar e dependências específicas que precisam ser compartilhadas entre outros módulos
  **network**: Contém a camada de rede utilizando Retrofit para as chamadas de API.
  **design System**: Contém os componentes principais da interface do usuário.
  **navigation**: Com as rotas de nagevação.
- Features: Contém funcionalidade associada a um recurso específico ou jornada do usuário.
  **Users**: Contém a lógica e as interfaces de usuário para a listagem dos usuários.
  **User_details**: Contém a lógica e as interfaces de usuário para exibir o detalhe do usuário.

#### Recursos para o futuro
- Arquitetura Modularizada seguindo as características dos pacotes
- Nova feature para exibição de detalhes do Usuário
- Salvar usuários no Favoritos usando o ROOM